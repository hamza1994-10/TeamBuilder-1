package fr.miage.teambuilder.ui.signIn

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint
import fr.miage.teambuilder.R
import fr.miage.teambuilder.enums.UserType
import fr.miage.teambuilder.ui.home.HomeScreen
import fr.miage.teambuilder.utils.SpinnerManager

@AndroidEntryPoint
class SignUpScreen: AppCompatActivity() {

    val viewModel: SignUpViewModel by viewModels()

    lateinit var emailTextField: TextInputEditText
    lateinit var nomTextField: TextInputEditText
    lateinit var prenomTextField: TextInputEditText
    lateinit var passwordTextField: TextInputEditText
    lateinit var confirmPasswordTextField: TextInputEditText
    lateinit var buttonSignUp: Button
    lateinit var userTypeSpinner: Spinner

    lateinit var content: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up_screen)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)


        emailTextField = findViewById(R.id.editTextEmail)
        nomTextField = findViewById(R.id.editTextNom)
        prenomTextField = findViewById(R.id.editTextPrenom)
        passwordTextField = findViewById(R.id.editTextPassword)
        confirmPasswordTextField = findViewById(R.id.editTextConfirmPassword)
        buttonSignUp = findViewById(R.id.buttonSignUpScreen)
        userTypeSpinner = findViewById(R.id.userTypeSpinner)

        SpinnerManager.setAdaptaterSpinner(this, R.array.userType, userTypeSpinner)

        content = findViewById(R.id.signUpScreen)

        viewModel.ldState.observe(this){
            when(it){
                SignUpViewModel.State.SuccessSignUp -> {
                    onSuccessSignUp()
                }
                is SignUpViewModel.State.FailSignUp -> {
                    onFailSignUp(it.message)
                }
                is SignUpViewModel.State.IncorrectInput -> {
                    onIncorrectSignUp()
                }
            }
        }

        buttonSignUp.setOnClickListener {
            viewModel.signUp(email = emailTextField.text.toString(), nom = nomTextField.text.toString(), prenom = prenomTextField.text.toString(), password = passwordTextField.text.toString(), confirmPassword = confirmPasswordTextField.text.toString(), userType = userTypeSpinner.selectedItem.toString(), this)
        }

    }

    fun onSuccessSignUp(){
        Snackbar.make(content, R.string.sign_up_success, Snackbar.LENGTH_LONG).show()
        val intent = Intent(this, SignInScreen::class.java)
        startActivity(intent)
    }

    fun onFailSignUp(message: String){
        Snackbar.make(content, message, Snackbar.LENGTH_LONG).show()

    }

    fun onIncorrectSignUp(){
        Snackbar.make(content, R.string.sign_up_incorrect_input, Snackbar.LENGTH_LONG).show()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> { this.finish()}
        }
        return super.onOptionsItemSelected(item)
    }
}