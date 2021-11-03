package com.example.googleregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.googleregistration.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.next.setOnClickListener { registration() }
    }
    fun registration() {
        val firstName = binding.firstName.text.toString()
        val lastName = binding.lastName.text.toString()
        val email = binding.userName.text.toString()

        val password =binding.password.text.toString()
        val confirm = binding.confirm.text.toString()

if (firstName.isNotEmpty()&& lastName.isNotEmpty()&& email.isNotEmpty() &&password.isNotEmpty()&&confirm.isNotEmpty()){
    //Toast.makeText(MainActivity@ this, "in $email ", Toast.LENGTH_SHORT).show()
    if (email.contains('!') || email.contains('@')||email.contains(' ') || email.contains('#')
        || email.contains('$')||email.contains('%') || email.contains('^')
        || email.contains('&')||email.contains('*') || email.contains('?')
        || email.contains('>')||email.contains('-') || email.contains('_')){
        Toast.makeText(MainActivity@ this, "in if ", Toast.LENGTH_SHORT).show()
          binding.result.setText("Please Enter User Name Without Symbol or spaces")
    }
   else if (password==confirm){
       binding.result.setText("Hi $firstName you register successfully")
    }else{
        binding.result.setText("Password Missmatch")
    }

}else{
    binding.result.setText("Please full all blanks")
}
    }
//fun emailFormmat(){
//
//    val email = binding.useEmail.text.toString()
//    if (email.contentEquals("& * , ^%$#@!)(_-=+")){
//  return   binding.result.setText("Please Enter User Name Without Symbol")
//    }
//}
}