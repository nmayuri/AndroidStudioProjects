package com.mnandanuri.mytodoapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    //TextView txt;
    EditText etName;
    ArrayAdapter<String> itemsAdapter;
    String item;
    private final int REQUEST_CODE = 20;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        EditText etName = (EditText) findViewById(R.id.etMultiLineText);
        String itemData;

        Intent i = getIntent();
        String receivedAction = i.getAction();
        // fetch value from key-value pair and make it visible on TextView.

        item = i.getStringExtra("Text");
        System.out.println(item);

        etName.setText(item);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_todo, menu);
        return true;
    }

    //Update new Item to the List
    public void onSave(View view) {
        EditText etName = (EditText) findViewById(R.id.etMultiLineText);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("Text", etName.getText().toString());

        data.putExtra("REQUEST_CODE", 20);
        data.putExtra("CommandName", "Update");
        setResult(RESULT_OK, data);// set result code and bundle data for response
        finish(); // closes the activity, pass data to parent

    }

    //If item to be cancelled ,Notify user ,pass intent data with cmd set to Cancel to identify the call on the receiving end.
    public void onCancel(View view) {
        //  EditText etName = (EditText) findViewById(R.id.etMultiLineText);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Cancel Item");
        builder.setMessage("Item will not be updated in the list");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog

                dialog.dismiss();
                Intent data = new Intent();
                // Pass relevant data back as a result
                data.putExtra("Text", item);

                data.putExtra("REQUEST_CODE", 50);
                data.putExtra("CommandName", "Cancel");
                setResult(RESULT_OK, data);// set result code and bundle data for response
                finish(); // closes the activity, pass data to parent
            }
        });


        AlertDialog alert = builder.create();
        alert.show();


        // Prepare data intent
/*        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("Text", item);

        data.putExtra("REQUEST_CODE", 50);
        setResult(RESULT_OK, data);// set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
*/
    }


}
