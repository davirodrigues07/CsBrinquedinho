package com.estudo.davisilva.csbrinquedinho;

import android.app.Activity;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

    @ViewById
    EditText name;
    @ViewById
    EditText title;
    @ViewById
    EditText annotation;

    @AfterViews
    public void init() {

    }


    @Click(R.id.submit)
    public void submitAnnotationToParse() {
        if (this.name.getText().length() > 0 &&
                this.title.getText().length() > 0 &&
                this.annotation.getText().length() > 0) {

            ParseObject anotacao = new ParseObject("Anotacao");
            anotacao.put("nome", this.name.getText().toString());
            anotacao.put("titulo", this.title.getText().toString());
            anotacao.put("nota", this.annotation.getText().toString());
            anotacao.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    new Toast(MainActivity.this).makeText(MainActivity.this, "Sua anotção foi salva.", Toast.LENGTH_LONG)
                            .show();
                }
            });

        } else {
            new Toast(this).makeText(this, "Todos os campos devem conter algum valor.", Toast.LENGTH_LONG)
                    .show();
        }
    }


}
