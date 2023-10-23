package com.example.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    TextInputLayout LayoutTen,LayoutCMND ;
    TextInputEditText TextHoTen, TextCMND, TextBS, TextTTCN;
    RadioButton btnRadio_TC,btnRadio_CD,btnRadio_DH;
    CheckBox checkboxDocSach,checkboxNgheNhac, checkboxXemPhim;
    Button btnGuiTT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddView();
        AddEvent();
    }

    private void AddView(){
        LayoutTen = findViewById(R.id.LayoutTen);
        LayoutCMND = findViewById(R.id.LayoutCMND);

        TextHoTen = findViewById(R.id.TextHoTen);
        TextCMND = findViewById(R.id.TextCMND);

        btnRadio_TC = findViewById(R.id.btnRadio_TC);
        btnRadio_CD = findViewById(R.id.btnRadio_CD);
        btnRadio_DH = findViewById(R.id.btnRadio_DH);

        checkboxDocSach = findViewById(R.id.checkboxDocSach);
        checkboxNgheNhac = findViewById(R.id.checkboxNgheNhac);
        checkboxXemPhim = findViewById(R.id.checkboxXemPhim);

        btnGuiTT = findViewById(R.id.btnGuiTT);

        TextBS = findViewById(R.id.TextBS);
        TextTTCN = findViewById(R.id.TextTTCN);
    }

    boolean ktHoTen= false;
    boolean ktCMND = false;
    private void AddEvent(){
        TextHoTen.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 0) {
                    LayoutTen.setError("Họ tên không được rỗng!!!");
                    ktHoTen = false;
                }else {
                    LayoutTen.setError(null);
                    ktHoTen = true;
                }    
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        TextCMND.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {


            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() <9){
                    LayoutTen.setError("CMND phải đủ 9 số!!!");
                    ktCMND =false;
                } else {
                    LayoutTen.setError(null);
                    ktCMND = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btnGuiTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ktHoTen ==false|| ktCMND ==false)
                    return;
                String ten = TextHoTen.getText().toString().trim();
                String cmnd = TextCMND.getText().toString().trim();
                
                String bangCap= "";
                if(btnRadio_TC.isChecked()== true)
                    bangCap = btnRadio_TC.getText().toString();
                else if(btnRadio_CD.isChecked()== true)
                    bangCap = btnRadio_CD.getText().toString();
                else 
                    bangCap =btnRadio_DH.getText().toString();
                
                String soThich ="";
                if(checkboxDocSach.isChecked())
                    soThich = checkboxDocSach.getText().toString();
                if(checkboxNgheNhac.isChecked()) {
                    if(soThich.length()>0)
                        soThich +=", ";
                    soThich += checkboxNgheNhac.getText().toString();
                }
                if(checkboxXemPhim.isChecked()) {
                    if (soThich.length() > 0)
                        soThich += ", ";
                    soThich += checkboxXemPhim.getText().toString();
                }    
                
                String boSung = TextBS.getText().toString().trim();
                
                TextTTCN.setText(ten + "\n" +cmnd + "\n" + bangCap +"\n"+ soThich + "\n" + boSung);


                
            }
        });
    }
}