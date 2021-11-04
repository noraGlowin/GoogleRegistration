package com.example.googleregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.widget.CheckBox
import android.widget.Toast
import com.example.googleregistration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.next.setOnClickListener { registration() }
//        binding.showpass.setOnCheckedChangeListener()
    }
    fun registration() {
        val firstName = binding.firstNameInput.text.toString()
        val lastName = binding.lastNameInput.text.toString()
        val email = binding.userNameInput.text.toString()

        val password =binding.passwordInput.text.toString()
        val confirm = binding.confirmInput.text.toString()
//        val showPass ={
//            if(binding.showpass.isChecked ){
//         show pass
//        }else{
//         hide pass
//        }
//
//        }
       // showPass.setOnCheckedChangeListener()
if (firstName.isNotEmpty()&& lastName.isNotEmpty()&& email.isNotEmpty() &&password.isNotEmpty()&&confirm.isNotEmpty()){
   // Toast.makeText(MainActivity@ this, "in $email ", Toast.LENGTH_SHORT).show()
    if (email.contains('!') || email.contains('@')||email.contains(' ') || email.contains('#')
        || email.contains('$')||email.contains('%') || email.contains('^')
        || email.contains('&')||email.contains('*') || email.contains('?')
        || email.contains('>')||email.contains('-') || email.contains('_')){
       // Toast.makeText(MainActivity@ this, "in if ", Toast.LENGTH_SHORT).show()
        //  binding.result.setText("Please Enter User Name Without Symbol or spaces")
        Toast.makeText(this, "Please Enter User Name Without Symbol or spaces", Toast.LENGTH_SHORT).show()
    }
   else if (password==confirm){
        Toast.makeText(this,"Hi $firstName you register successfully", Toast.LENGTH_LONG).show()
    }else{
//        binding.result.setText("Password Missmatch")
        Toast.makeText(this, "Password Missmatch", Toast.LENGTH_SHORT).show()
    }

}else{
    binding.result.setText("Please full all blanks")
}
    }

}


