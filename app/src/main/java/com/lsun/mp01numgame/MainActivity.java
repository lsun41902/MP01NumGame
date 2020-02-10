package com.lsun.mp01numgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;
    TextView tv=null;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    int[] com;
    int a;
    int b;
    int c;
    int aa=0;
    int bb=0;
    int cc=0;
    int S=0;
    int B=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.scrollview);


        startgame();
        tv=findViewById(R.id.tv_anser);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);

        new AlertDialog.Builder(this).setTitle("규칙!").setMessage("첫번째: 000 ~ 999 사이의 숫자 3개를 예상한다. \n 두번째: 컴퓨터의 숫자와 자리수가 같고 숫자가 같을때 1스트라이크, 자리수는 다르지만 숫자가 일치하면 1볼 ").setPositiveButton("시작 하기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setCancelable(false).create().show();





    }


    void startgame(){
        com=new int[3];
        Random rnd = new Random();
        for(int i=0;i<3;i++){
            com[i]=rnd.nextInt(10);
            for(int j=0;j<i;j++){
                if(com[i]==com[j]){
                    i--;
                }
            }
        }
        a=com[0];
        b=com[1];
        c=com[2];
    }
    public void clickCheck(View view) {




        if(aa==a|| bb==b ||cc==c ) {
            S = 1;
        }
        if((aa==a && bb==b) || (aa==a&&cc==c) || (bb==b&& cc==c)){
            S=2;
        }
        if(aa==a && bb==b && cc==c) {
            S = 3;
        }

        if(aa==b || aa==c || bb==a || bb==c || cc==a || cc==b){
            B=1;
        }


        if( (aa==b && bb==a) || (aa==b&&cc==a) ||(aa==b&&bb==c) || (aa==c&&bb==a)||
                (aa==c&&cc==a)||  (bb==c&&cc==a) ||(bb==a&&cc==b) ||
                (cc==b&&bb==c)){
            B=2;
        }
        if((aa==b&&bb==c&&cc==a)||(aa==c&&bb==a&&cc==b)){
            B=3;
        }


        tv.append(aa+""+bb+""+cc+""+"="+S+" 스트라이크, "+B+" 볼 입니다."+"\n");


        if(S==3){
            new AlertDialog.Builder(this).setTitle("스트라이크!").setMessage("다시 하기를 원하십니까?").setPositiveButton("네", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startgame();
                    tv.setText("");
                    tv1.setText(0+"");
                    tv2.setText(0+"");
                    tv3.setText(0+"");
                    aa=0;
                    bb=0;
                    cc=0;
                    S=0;
                    B=0;
                    dialog.dismiss();
                }
            }).setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                }
            }).setCancelable(false).create().show();
        }
        S=0;
        B=0;

    }

    public void btnUP1(View view) {

        aa++;
        if (aa==10) aa=0;
        tv1.setText(aa+"");

    }

    public void btnUP2(View view) {

        bb++;
        if (bb==10) bb=0;
        tv2.setText(bb+"");

    }

    public void btnUP3(View view) {

        cc++;
        if (cc==10) cc=0;
        tv3.setText(cc+"");
    }

    public void btnDOWN1(View view) {
        aa--;
        if (aa==-1) aa=9;
        tv1.setText(aa+"");
    }

    public void btnDOWN2(View view) {
        bb--;
        if (bb==-1) bb=9;
        tv2.setText(bb+"");
    }

    public void btnDOWN3(View view) {
        cc--;
        if (cc==-1) cc=9;
        tv3.setText(cc+"");
    }
}