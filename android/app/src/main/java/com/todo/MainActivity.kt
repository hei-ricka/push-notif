package com.todo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.facebook.react.ReactActivity
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : ReactActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun getMainComponentName(): String = "todo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Récupération et affichage du token FCM
        FirebaseMessaging.getInstance().token
            .addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.e(TAG, "Échec de la récupération du token FCM", task.exception)
                    return@addOnCompleteListener
                }

                val token = task.result
                if (token != null) {
                    Log.d(TAG, "Token FCM : $token")
                    Toast.makeText(this, "Token FCM : $token", Toast.LENGTH_LONG).show()
                    println("Token FCM : $token")  // Affichage dans la console
                } else {
                    Log.e(TAG, "Token FCM non disponible")
                }
            }
    }
}
