package fr.utt.if26.if26app;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    DatabaseHelper myDb;

    EditText editCode, editMarks, editID;

    Button addDataButton;
    Button viewDataButton;
    Button updateDataButton;
    Button deleteDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myDb = new DatabaseHelper(this);

        editCode = (EditText)findViewById(R.id.codeTextField);
        editMarks = (EditText)findViewById(R.id.marksTextField);
        editID = (EditText)findViewById(R.id.idTextField);

        addDataButton = (Button)findViewById(R.id.addButton);
        viewDataButton = (Button)findViewById(R.id.viewButton);
        updateDataButton = (Button)findViewById(R.id.updateButton);
        deleteDataButton = (Button)findViewById(R.id.deleteButton);

        AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }

    public void DeleteData(){
        deleteDataButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Integer deletedRows = myDb.deleteData(editID.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(Main2Activity.this, "Note supprimée", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main2Activity.this, "Note non supprimée", Toast.LENGTH_LONG).show();

                        editCode.setText("");
                        editMarks.setText("");
                        editID.setText("");
                    }
                }
        );
    }

    public void UpdateData(){
        updateDataButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        boolean isUpdate = myDb.updateData(editID.getText().toString(),
                                editCode.getText().toString(), editMarks.getText().toString());
                            if(isUpdate == true)
                                Toast.makeText(Main2Activity.this, "Note mis à jour", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(Main2Activity.this, "Note non mis à jour", Toast.LENGTH_LONG).show();

                        editCode.setText("");
                        editMarks.setText("");
                        editID.setText("");
                    }
                }
        );
    }

    public void AddData(){
        addDataButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                       boolean isInserted = myDb.insertData(editCode.getText().toString(),
                                editMarks.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(Main2Activity.this, "Note ajoutée", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Main2Activity.this, "Note non ajoutée", Toast.LENGTH_LONG).show();

                        editCode.setText("");
                        editMarks.setText("");
                        editID.setText("");
                    }
                }
        );
    }

    public void viewAll(){
        viewDataButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                       Cursor res = myDb.getAllData();
                        if(res.getCount() == 0){
                            //show message
                            showMessage("Erreur", "Pas de notes trouvées" );
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("ID : " + res.getString(0) + "\n");
                            buffer.append("UV Code : " + res.getString(1) + "\n");
                            buffer.append("Note : " + res.getString(2) + "\n\n");
                        }

                        //show all data
                        showMessage("Liste des Notes", buffer.toString());

                        editCode.setText("");
                        editMarks.setText("");
                        editID.setText("");
                    }
                }
        );
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
