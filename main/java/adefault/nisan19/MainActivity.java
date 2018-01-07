package adefault.nisan19;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnsms;
    EditText edtisim;
    EditText edtno;
    EditText edtmesaj;
    ListView lw;


    Button listeekle;
    Button listeguncelle;
    EditText yas;
    EditText isim;
    CheckBox cinsiyet;

    List<Kisi> GosterilecekKisilerim=new ArrayList<Kisi>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listeekle=(Button) findViewById(R.id.btnekle);
        listeguncelle=(Button) findViewById(R.id.btnlisteguncelle);
        yas=(EditText) findViewById(R.id.listeyas);
        isim =(EditText) findViewById(R.id.listeisim);
        cinsiyet=(CheckBox) findViewById(R.id.cbcinsiyet);


        lw=(ListView) findViewById(R.id.liste);


        GosterilecekKisilerim.add(new Kisi("kahtalı mıçı","56", true));
        GosterilecekKisilerim.add(new Kisi("müzeyyen senar","78", false));



     final  Ozeladapter mydadatadapter=new Ozeladapter(this,GosterilecekKisilerim);
        lw.setAdapter(mydadatadapter);



        listeekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (cinsiyet.isChecked())
                {
                    GosterilecekKisilerim.add(new Kisi(isim.getText().toString(),yas.getText().toString(),true));
                    lw.setAdapter(mydadatadapter);
                }

                else
                {
                    GosterilecekKisilerim.add(new Kisi(isim.toString(),yas.toString(),false));
                    lw.setAdapter(mydadatadapter);
                }

            }
        });


        lw.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



                if (cinsiyet.isChecked())
                {
                    cinsiyet.setChecked(true);
                }

                else
                {
                    cinsiyet.setChecked(false);
                }

                listeguncelle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        lw.setAdapter(mydadatadapter);
                    }
                });

            }
        });

























        btnsms=(Button) findViewById(R.id.btnsmsgonder);
        edtisim=(EditText) findViewById(R.id.edtisim);
        edtno= (EditText) findViewById(R.id.edtno);
        edtmesaj=(EditText) findViewById(R.id.edtmesaj);

        String[] isimler=new String[2];
        String[] numaralar=new String[2];


        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               String isim=edtisim.getText().toString();
                String[] isimler=isim.split(";");
                String no=edtno.getText().toString();
                String[] numaralar=no.split(";");

                String mesaj=edtisim.getText().toString();

                SmsManager mysmsmanager = SmsManager.getDefault();

               for (int i=0;i<numaralar.length;i++) {

                   mysmsmanager.sendTextMessage(numaralar[i].toString(), null, mesaj +" "+ isimler[i].toString(), null, null);
               }
                //edtmesaj.toString()+edtisim.toString()
                  //  mysmsmanager.sendTextMessage("05343460377", null, "selam", null, null);

           //     Toast.makeText(MainActivity.this, "gönderildi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

