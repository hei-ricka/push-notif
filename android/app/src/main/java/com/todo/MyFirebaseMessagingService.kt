package com.todo

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    companion object {
        private const val TAG = "FCM-Service"
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Nouveau token FCM généré : $token")

        // Envoyer le token au serveur si nécessaire
        sendRegistrationToServer(token)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d(TAG, "Message reçu de FCM : ${remoteMessage.messageId}")
    }

    private fun sendRegistrationToServer(token: String) {
        Log.d(TAG, "Envoi du token au serveur : $token")
    }
}
