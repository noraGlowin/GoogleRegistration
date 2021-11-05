package com.example.googleregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.method.HideReturnsTransformationMethod
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

        binding.showpass.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                binding.passwordInput.transformationMethod = HideReturnsTransformationMethod.getInstance()
                binding.confirmInput.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }else {
                binding.passwordInput.transformationMethod = PasswordTransformationMethod.getInstance()
                binding.confirmInput.transformationMethod = PasswordTransformationMethod.getInstance()
            }
        }
    }
    fun registration() {
        val firstName = binding.firstNameInput.text.toString()
        val lastName = binding.lastNameInput.text.toString()
        val email = binding.userNameInput.text.toString()
        val password =binding.passwordInput.text.toString()
        val confirm = binding.confirmInput.text.toString()

if (firstName.isNotEmpty()&& lastName.isNotEmpty()&& email.isNotEmpty() &&password.isNotEmpty()&&confirm.isNotEmpty()){
   // Toast.makeText(MainActivity@ this, "in $email ", Toast.LENGTH_SHORT).show()
    if (email.contains('!') || email.contains('@')||email.contains(' ') || email.contains('#')
        || email.contains('$')||email.contains('%') || email.contains('^')
        || email.contains('&')||email.contains('*') || email.contains('?')
        || email.contains('>')||email.contains('-') || email.contains('_')){
       // binding.userName.helperText = "Please Enter User Name Without Symbol or spaces"
        Toast.makeText(this, "Please Enter User Name Without Symbol or spaces", Toast.LENGTH_SHORT).show()
    }
   else if (password==confirm){
        Toast.makeText(this,"Hi $firstName you register successfully", Toast.LENGTH_LONG).show()
    }else{

        binding.password.helperText="Password Mismatch , please re-enter your password"
        binding.confirm.helperText="Password Mismatch , please re-enter your password"
    }

}else{
    binding.firstName.helperText="full the blank please !"
    binding.userName.helperText="full the blank please !"
    binding.password.helperText="full the blank please !"
    binding.confirm.helperText="full the blank please !"
    binding.lastName.helperText="full the blank please !"
}
    }




}

