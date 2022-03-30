package com.ebookfrenzy.uifyp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PostActivity extends AppCompatActivity implements View.OnClickListener, OnItemSelectedListener  {

    //Product To Sell Activity

    private TextView postListing;
    private EditText editTextItemName, editTextItemDetails, editTextCondition, editTextPrice, editTextItemQty;
    private Button postItem;
    private Spinner categoryDialog;
    ArrayAdapter adapter;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item_sell);

        adapter = ArrayAdapter.createFromResource(this, R.array.spinner_option, android.R.layout.simple_spinner_item);

        categoryDialog = (Spinner) findViewById(R.id.spinner_dialog);
        categoryDialog.setAdapter(adapter);
        categoryDialog.setOnItemSelectedListener(PostActivity.this);

        postListing = (TextView) findViewById(R.id.postListing); //add textview
        postListing.setOnClickListener(this);

        postItem = (Button) findViewById(R.id.postItem);
        postItem.setOnClickListener(this);

        editTextItemQty = (EditText) findViewById(R.id.productQty);
        editTextItemName = (EditText) findViewById(R.id.productName);
        editTextItemDetails = (EditText) findViewById(R.id.productDetails);
        editTextPrice = (EditText) findViewById(R.id.productPrice);
        editTextCondition = (EditText) findViewById(R.id.productCondition);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.postItem:
                postItem();
                break;

        }
    }

    //feature for after pressing button
    private void postItem() {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("products");

        reference.setValue("insert product data");

        //check value
        String itemName = editTextItemName.getText().toString().trim();
        String itemDetails = editTextItemDetails.getText().toString().trim();
        String itemCategory = categoryDialog.getSelectedItem().toString();
        int itemPrice = Integer.parseInt(editTextPrice.getText().toString());
        String itemCondition = editTextCondition.getText().toString().trim();

        Product helperClass = new Product(itemName, itemCategory, itemCondition, itemPrice);
        if (itemName.isEmpty()) {
            editTextItemName.setError("Item name is required!");
            editTextItemName.requestFocus();
            return;
        }

        /*
        if(!TextUtils.isEmpty(editTextPrice)){
            editTextPrice.setError("Item Price is required");
            editTextPrice.requestFocus();
            return;
        }
        */

        if (itemCategory.isEmpty()) {
            editTextItemName.setError("Item name is required!");
            editTextItemName.requestFocus();
            return;
        }


        if (itemDetails.isEmpty()) {
            editTextItemDetails.setError("Item Details is required!");
            editTextItemDetails.requestFocus();
            return;
        }



        /*
        if (itemPrice.isEmpty()) {
            editTextItemDetails.setError("Item Price is required!");
            editTextItemDetails.requestFocus();
            return;
        }
        */

        if (itemCondition.isEmpty()) {
            editTextItemDetails.setError("Item Condition is required!");
            editTextItemDetails.requestFocus();
            return;
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        TextView spinnerDialogText = (TextView) view;
        Toast.makeText(this, "you selected" + spinnerDialogText.getText(), Toast.LENGTH_SHORT).show();
}

    @Override
    public void onNothingSelected(AdapterView<?> parent){

    }



/*
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
            @Override
            public void onComplete(@NonNull Task<AuthResult> task){

                if(task.isSuccessful()){
                    //redirect to user profile
                    startActivity(new Intent(LoginActivity.this, MyProfile.class));  //Change this to Homepage later

                }else{
                    Toast.makeText(LoginActivity.this, "Failed to login! Please check your credentials", Toast.LENGTH_LONG).show();
                }
            }
        });
  */
}
