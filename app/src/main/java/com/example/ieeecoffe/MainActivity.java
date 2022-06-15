package com.example.ieeecoffe;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button incrementBtn;
    Button decrementBtn;
    EditText ETCustomer_name;

    TextView TV_SUMMARY;
    Button Btn_Order;
    CheckBox hasCream;
    CheckBox hasChoclate;
    TextView quantity;

    Integer Amount_OF_One_Cofee =50;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TV_SUMMARY = findViewById(R.id.TV_Summary);
        incrementBtn = findViewById(R.id.BtnInc);
        decrementBtn = findViewById(R.id.BtnDec);

        ETCustomer_name = findViewById(R.id.ETCustomerName);
        Btn_Order =findViewById(R.id.Btn_Order);
        quantity= findViewById(R.id.Tv_quantity);

        hasCream = findViewById(R.id.hasCream);

        hasChoclate = findViewById(R.id.hasChoc);

       incrementBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               //Toast.makeText(MainActivity.this, "Button succesfully clicked", Toast.LENGTH_SHORT).show();

             String String_quantity = quantity.getText().toString();


             Integer Int_quantity = Integer.parseInt(String_quantity);

             Int_quantity++;

             String final_string_quantity = String.valueOf(Int_quantity);

             quantity.setText(final_string_quantity);






           }
       });


        decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(MainActivity.this, "Button succesfully clicked", Toast.LENGTH_SHORT).show();

                String String_quantity = quantity.getText().toString();


                Integer Int_quantity = Integer.parseInt(String_quantity);

                Int_quantity--;

                String final_string_quantity = String.valueOf(Int_quantity);

                quantity.setText(final_string_quantity);






            }
        });







       Btn_Order.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {


               Integer price_of_cream=0;

               if(hasCream.isChecked()){
                   price_of_cream =10;
               }

               Integer price_of_choclate=0;

               if(hasChoclate.isChecked()){
                   price_of_choclate =20;
               }



               String  username=  ETCustomer_name.getText().toString();



               Integer total_Quantity = Integer.parseInt(quantity.getText().toString());

               Integer Total_amount = total_Quantity * (Amount_OF_One_Cofee + price_of_cream + price_of_choclate);

               String summary =  "Customer name is = "+  username + "  total quantity " + total_Quantity +'\n' + " has cream ?" + hasCream.isChecked() +'\n' + "has choclate  ?  "+ hasChoclate.isChecked() +'\n'+ " total amount is " + Total_amount ;


               TV_SUMMARY.setText(summary);



               Intent intent = new Intent(Intent.ACTION_SEND);
               intent.setType("text/html");

               intent.putExtra(Intent.EXTRA_EMAIL, "emailaddress@emailaddress.com");

               intent.putExtra(Intent.EXTRA_SUBJECT, "coffe order for" + username);
               intent.putExtra(Intent.EXTRA_TEXT, summary);

               startActivity(Intent.createChooser(intent, "Send Email"));


             //  Toast.makeText(MainActivity.this, username , Toast.LENGTH_SHORT).show();


           }
       });




    }
}