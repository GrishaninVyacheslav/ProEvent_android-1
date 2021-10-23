package ru.myproevent.domain.di

import dagger.Binds
import dagger.Module
import ru.myproevent.domain.model.IProEventLoginRepository
import ru.myproevent.domain.model.ProEventLoginRepository
import javax.inject.Singleton

@Module
interface ProEventRepositoriesModule {
    @Singleton
    @Binds
    fun bindLoginRepository(proEventLoginRepository: ProEventLoginRepository): IProEventLoginRepository
}