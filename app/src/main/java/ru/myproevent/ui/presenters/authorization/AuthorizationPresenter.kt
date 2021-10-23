package ru.myproevent.ui.presenters.authorization

import android.util.Log
import com.github.terrakok.cicerone.Router
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import moxy.MvpPresenter
import ru.myproevent.domain.model.IProEventLoginRepository
import ru.myproevent.ui.screens.IScreens
import ru.myproevent.ui.screens.Screens
import javax.inject.Inject

class AuthorizationPresenter: MvpPresenter<AuthorizationView>() {
    private inner class LoginObserver : DisposableSingleObserver<String?>() {
        override fun onSuccess(token: String) {
            router.newRootScreen(screens.home())
        }

        override fun onError(error: Throwable) {
            error.printStackTrace()
            if(error is retrofit2.adapter.rxjava2.HttpException){
                when(error.code()){
                    401, 404 -> viewState.authorizationDataInvalid()
                }
            }
        }
    }

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var loginRepository: IProEventLoginRepository

    private var disposables: CompositeDisposable = CompositeDisposable()

    // TODO: вынести в Dagger
    private var screens: IScreens = Screens()

    fun authorize(email: String, password: String) {
        disposables.add(
            loginRepository
                .login(email, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(LoginObserver())
        )
    }

    fun openRegistration() {
        router.navigateTo(screens.registration())
    }

    fun recoverPassword() {
        router.navigateTo(screens.recovery())
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}