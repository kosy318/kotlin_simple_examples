package com.soo.firebaselogin_ex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.soo.firebaselogin_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Initialize Firebase Auth
        auth = Firebase.auth

        binding.joinBtn.setOnClickListener {
            Log.d("signIn", binding.emailInput.text.toString())
            Log.d("signIn", binding.passwordInput.text.toString())

            auth.createUserWithEmailAndPassword(binding.emailInput.text.toString(), binding.passwordInput.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
                        Log.d("signIn", "createUserWithEmail:success")
                        val user = auth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("signIn", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Join Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        binding.EmailLoginBtn.setOnClickListener{
            auth.signInWithEmailAndPassword(binding.emailInput.text.toString(), binding.passwordInput.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("signIn", "signInWithEmail:success")
                        val user = auth.currentUser
                        login(binding.emailInput.text.toString().split("@")[0])
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("signIn", "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
        }

        binding.noEmailLoginBtn.setOnClickListener {
            auth.signInAnonymously()
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth.currentUser
                        Log.d("signIn", "signInAnonymously:success " + user!!.uid)
                        login("")
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("signIn", "signInAnonymously:failure", task.exception)
                        Toast.makeText(baseContext, "SignIn Authentication failed.", Toast.LENGTH_SHORT).show()
                    }
                }
        }


    }

    private fun login(user: String) {
        Toast.makeText(this, "로그인", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, InsideApp::class.java)
        intent.putExtra("user", user)
        startActivity(intent)

    }
}