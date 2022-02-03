package ru.myproevent

import android.app.Application
import android.util.Log
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import ru.myproevent.domain.di.AppComponent
import ru.myproevent.domain.di.AppModule
import ru.myproevent.domain.di.DaggerAppComponent
import ru.myproevent.domain.models.entities.EventDate
import ru.myproevent.domain.models.entities.Interval
import ru.myproevent.domain.models.entities.RepeatInterval
import ru.myproevent.domain.utils.EventDateUseCases

class ProEventApp : Application() {
    companion object {
        lateinit var instance: ProEventApp
            private set
    }

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

        // TODO: Вынести в Dagger
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath(getString(R.string.default_font))
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )

        Log.d(
            "[TEST]", "toTimeIntervals: ${
                EventDateUseCases.toTimeIntervals(
                    listOf(
                        EventDate(Interval(7, 11), RepeatInterval(Interval(9, 17), 3))
                    )
                )
            }"
        )
    }
}