package wennytugas.pemvisual;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

import wennytugas.pemvisual.R;

public class MainActivity extends AppCompatActivity {

    int quantity = 1;
    private CharSequence pesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void decrement(View view) {
        if (quantity == 0) {
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }

    public void increment(View view) {
        if (quantity == 100) {
            return;
        }
        quantity = quantity + 1;
        display(quantity);
    }

    public void display(int quantity) {
        TextView quantity1 = (TextView) findViewById(R.id.quantity_textview);
        quantity1.setText("" + quantity);
    }

    public void submit(View view) {

        EditText nama1 = (EditText) findViewById(R.id.txtNama);
        String nama= nama1.getText().toString();

        CheckBox cbCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        CheckBox cbChoco = (CheckBox) findViewById(R.id.chocolate);
        CheckBox cbChip = (CheckBox) findViewById(R.id.ChocoChip);
        CheckBox cbMarsh = (CheckBox) findViewById(R.id.marshmellow);

        boolean cream = cbCream.isChecked();
        boolean choco = cbChoco.isChecked();
        boolean chip = cbChip.isChecked();
        boolean marsh = cbMarsh.isChecked();

        int total=hitung(nama, cream, choco, chip, marsh);
        String pesan=nota(nama,total,cream,choco,chip,marsh);
        alert(pesan);
        //alert("Nama :" +nama + "\nPrice = "+total + "\n Topping="+message);
        //TextView total1 = (TextView) findViewById(R.id.total_textview);
        //total1.setText("" + total);
    }

    private int hitung(String nama, boolean cream, boolean choco, boolean chip, boolean marsh){
        int price=10;
        String message="";
        int total=0;
        if (cream){
            price=price +1;
            message=message+"Whipped Cream";

        }

        if (choco){
            price=price +2;
            message=message+"Chocolate";
        }

        if (chip){
            price=price +3;
            message=message+"Chocochip";
        }

        if (marsh){
            price=price +4;
            message=message+"Marshmellow";
        }

        total = quantity * price;
        return total;
    }
    private void alert(String pesan){
        AlertDialog alertPesan = new AlertDialog.Builder(MainActivity.this).create();
        alertPesan.setTitle("PESAN");
        alertPesan.setMessage(pesan);
        alertPesan.show();
    }

    private String nota(String nama, int price, boolean Cream, boolean Chocolate, boolean Chocochip, boolean Marshmellow){
        String pesan = "Nama :" +nama;
        pesan += "\n" +"Whipped Cream :" +Cream;
        pesan += "\n" +"Chocolate :" +Chocolate;
        pesan += "\n" +"ChocoChip :" +Chocochip;
        pesan += "\n" +"Marshmellow :" +Marshmellow;
        pesan += "\n" +"Jumlah :" +quantity;
        pesan += "\n" +"Total Harga :" + NumberFormat.getCurrencyInstance().format(price) ;
        return pesan;
    }
}
