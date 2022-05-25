package com.soo.dietmemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        private lateinit var auth: FirebaseAuth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Initialize Firebase Auth
        auth = Firebase.auth

        try {
            Log.d("signIn", auth.currentUser!!.uid) // 로그인이 안돼있으면 에러뜸

            Toast.makeText(baseContext, "비회원 로그인이 되어있습니다.", Toast.LENGTH_SHORT).show()

            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 1000)
        }catch (e: Exception){
            Log.d("signIn", "회원가입이 필요합니다.")

            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("signIn", "signInAnonymously:success")
                        Toast.makeText(baseContext, "비회원 로그인 성공", Toast.LENGTH_SHORT).show()

                        Handler(Looper.getMainLooper()).postDelayed({
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }, 1000)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("signIn", "signInAnonymously:failure", task.exception)
                        Toast.makeText(baseContext, "비회원 로그인 실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }
}