package com.example.lab03_checkomelko;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText[] etN,eN;
    CheckBox[] enCh;
    RadioButton rbT, rbW;
    Double[] costs,ks;
    Toast toast;
    boolean out;
    protected void onCreate(Bundle savedInstanceState) { //created by Igor Omelko
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out=false;
        costs = new Double[4];
        ks = new Double[4];
        etN = new EditText[4];
        eN = new EditText[4];
        enCh = new CheckBox[4];
        etN[0]=findViewById(R.id.editText1);
        etN[1]=findViewById(R.id.editText2);
        etN[2]=findViewById(R.id.editText3);
        etN[3]=findViewById(R.id.editText4);
        eN[0]=findViewById(R.id.editNumber1);
        eN[1]=findViewById(R.id.editNumber2);
        eN[2]=findViewById(R.id.editNumber3);
        eN[3]=findViewById(R.id.editNumber4);
        enCh[0]=findViewById(R.id.checkBoxEnabled1);
        enCh[1]=findViewById(R.id.checkBoxEnabled2);
        enCh[2]=findViewById(R.id.checkBoxEnabled3);
        enCh[3]=findViewById(R.id.checkBoxEnabled4);
        rbT=findViewById(R.id.radioButtonOutputToast);
        rbW=findViewById(R.id.radioButtonOutputWindow);
    }
    public void Calculate(View v) { //created by Igor Omelko

        if (!InputCheckDouble(String.valueOf(etN[0].getText()))|| !InputCheckDouble(String.valueOf(etN[1].getText()))||
                !InputCheckDouble(String.valueOf(etN[2].getText()))|| !InputCheckDouble(String.valueOf(etN[3].getText()))){
        toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.TextError), Toast.LENGTH_SHORT); toast.show(); return; }
        if (!InputCheckDouble(String.valueOf(eN[0].getText()))|| !InputCheckDouble(String.valueOf(eN[1].getText()))||
                !InputCheckDouble(String.valueOf(eN[2].getText()))|| !InputCheckDouble(String.valueOf(eN[3].getText()))){
            toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.TextError), Toast.LENGTH_SHORT); toast.show(); return; }
        if (Double.parseDouble(String.valueOf(etN[0].getText()))<0|| Double.parseDouble(String.valueOf(etN[1].getText()))<0||
                Double.parseDouble(String.valueOf(etN[2].getText()))<0|| Double.parseDouble(String.valueOf(etN[3].getText()))<0){
            toast= Toast.makeText(getApplicationContext(), getResources().getString(R.string.TextError), Toast.LENGTH_SHORT); toast.show(); return; }
        for(int i = 0; i < 4; i++) {
            if (enCh[i].isChecked()){
                costs[i]=Double.parseDouble(String.valueOf(etN[i].getText()));
                ks[i]=Double.parseDouble(String.valueOf(eN[i].getText())); }
            else{
                costs[i]=0d;
                ks[i]=0d; } }
        double cost=0;
        Double[] temp = new Double[4];
        for(int i = 0; i < 4; i++) {
            //temp[i] = costs[i];
            costs[i] = costs[i] * ks[i];
            cost+=costs[i]; }
        toast= Toast.makeText(getApplicationContext(), String.valueOf(cost), Toast.LENGTH_SHORT);
        if (out){ toast.show(); }
        else{ DialogWindow(cost); } }
    public void DialogWindow(Double cost){ //created by Igor Omelko
        String res = String.valueOf(cost);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog dlg = builder.create();
        dlg.setIcon(R.drawable.image2);
        dlg.setTitle(res);
        dlg.show(); }
    public void RbChange(View rb) { //created by Igor Omelko
        switch (rb.getId()) {
            case R.id.radioButtonOutputToast:out=true;break;
            case R.id.radioButtonOutputWindow:out=false;break; } }
    public boolean InputCheckDouble(String value) { //created by Igor Omelko
        try {
            Double.parseDouble(value);
            return true; }
        catch (NumberFormatException e) {
            return false; } }

}