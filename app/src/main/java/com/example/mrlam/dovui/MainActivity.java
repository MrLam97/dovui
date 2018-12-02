package com.example.mrlam.dovui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnDung,btnSai,btnTruoc,btnSau;
    private TextView tvCauhoi;
    private int stt=0;
    private List<Tonghopcauhoi> listcauhoi=new ArrayList<Tonghopcauhoi>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Anhxa();

        //Add cauhoi
        listcauhoi.add(new Tonghopcauhoi("2*5+5=15?",true));
        listcauhoi.add(new Tonghopcauhoi("Việt Nam thuộc châu Á?",true));
        listcauhoi.add(new Tonghopcauhoi("TP Hồ Chí Minh là thủ đô nước Việt Nam?",false));
        listcauhoi.add(new Tonghopcauhoi("Samsung là sản phẩm của Apple?",false));
        listcauhoi.add(new Tonghopcauhoi("Số 5 < 6 và > 4?",true));
        listcauhoi.add(new Tonghopcauhoi("Hệ mặt trời có 10 hành tinh?",false));
        listcauhoi.add(new Tonghopcauhoi("Huế nằm ở miền nam?",false));
        listcauhoi.add(new Tonghopcauhoi("Hoàng Sa và Trường Sa là của Việt Nam?",true));

        tvCauhoi.setText(listcauhoi.get(stt).getCauhoi());

        btnDung.setOnClickListener(this);
        btnSai.setOnClickListener(this);
        btnTruoc.setOnClickListener(this);
        btnSau.setOnClickListener(this);
    }

    private void Anhxa() {
        tvCauhoi=(TextView) findViewById(R.id.tvCauhoi);
        btnDung=(Button) findViewById(R.id.btnDung);
        btnSai=(Button) findViewById(R.id.btnSai);
        btnTruoc=(Button) findViewById(R.id.btnTruoc);
        btnSau=(Button) findViewById(R.id.btnSau);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnDung.getId()){
            if (listcauhoi.get(stt).isDapan()==true){
                Toast.makeText(this, "Bạn đã trả lời đúng.", Toast.LENGTH_SHORT).show();
                if (stt<listcauhoi.size()-1){
                    stt++;
                    tvCauhoi.setText(listcauhoi.get(stt).getCauhoi());
                }
                else
                    Toast.makeText(this, "Đã hết câu hỏi.", Toast.LENGTH_SHORT).show();
            }else
                Toast.makeText(this, "Bạn đã trả lời sai.", Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==btnSai.getId()){
            if (listcauhoi.get(stt).isDapan()==false){
                Toast.makeText(this, "Bạn đã trả lời đúng.", Toast.LENGTH_SHORT).show();
                stt++;
                tvCauhoi.setText(listcauhoi.get(stt).getCauhoi());
            }else
                Toast.makeText(this, "Bạn đã trả lời sai.", Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==btnTruoc.getId()){
            if (stt==0){
                Toast.makeText(this, "Đã hết câu hỏi.", Toast.LENGTH_SHORT).show();
            }else{
                stt--;
                tvCauhoi.setText(listcauhoi.get(stt).getCauhoi());
            }

        }
        if(v.getId()==btnSau.getId()){
            if (stt==listcauhoi.size()-1){
                Toast.makeText(this, "Đã hết câu hỏi.", Toast.LENGTH_SHORT).show();
            }else{
                stt++;
                tvCauhoi.setText(listcauhoi.get(stt).getCauhoi());
            }
        }
    }
}
