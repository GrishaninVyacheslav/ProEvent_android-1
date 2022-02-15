package ru.myproevent.ui.screens

import com.github.terrakok.cicerone.Screen
import ru.myproevent.domain.models.entities.Profile
import ru.myproevent.domain.models.entities.Address
import ru.myproevent.domain.models.entities.contact.Contact
import ru.myproevent.domain.models.entities.Event

interface IScreens {
    fun authorization(): Screen
    fun home(): Screen
    fun settings(): Screen
    fun registration(): Screen
    fun code(): Screen
    fun login(): Screen
    fun recovery(): Screen
    fun account(): Screen
    fun security(): Screen
    fun contacts(): Screen
    fun contact(profileId: Long): Screen
    fun contactAdd(): Screen
    fun chat(): Screen
    fun chat1(): Screen
    fun chats(): Screen
    fun events(): Screen
    fun event(): Screen
    fun event(event: Event): Screen
    fun currentlyOpenEventScreen(): Screen
    fun eventActionConfirmation(event: Event, status: Event.Status?): Screen
    fun participantPickerTypeSelection(participantsIds: List<Long>): Screen
    fun participantFromContactsPicker(participantsIds: List<Long>): Screen
    fun participantByEmailPicker(): Screen
    fun addEventPlace(address: Address? = null): Screen
    fun eventParticipant(profile: Profile): Screen
    fun newPassword(email: String): Screen
}