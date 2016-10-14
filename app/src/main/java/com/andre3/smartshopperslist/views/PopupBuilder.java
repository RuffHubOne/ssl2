package com.andre3.smartshopperslist.views;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.andre3.smartshopperslist.R;
import com.andre3.smartshopperslist.dao.DBManager;

/**
 * Created by andre3 on 10/13/16.
 */

public class PopupBuilder {

    Context context;
    String dialogTitle;
    AutoCompleteTextView store_et;
    Button store_btn;


    public PopupBuilder(Context context) {
        this.context = context;
    }

    public void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
    }

    /********** Custom dialogs below ************/

    public Dialog newStore(boolean updateData){

        final Dialog dialog = new Dialog(this.context);
        dialog.setTitle(this.dialogTitle);
        dialog.setContentView(R.layout.popup_newstore);

        store_et = (AutoCompleteTextView)dialog.findViewById(R.id.store_et);
        store_btn = (Button)dialog.findViewById(R.id.store_btn);

        store_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return dialog;
    }

}