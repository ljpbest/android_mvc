package ljp.qianfeng.com.day10_31demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import ljp.qianfeng.com.day10_31demo.bean.MainBean;
import ljp.qianfeng.com.day10_31demo.model.DataModel;
import ljp.qianfeng.com.day10_31demo.tool.LogUtils;
import ljp.qianfeng.com.day10_31demo.ui.SecondActivity;
import ljp.qianfeng.com.day10_31demo.view.MainView;

/**
 *
 * */
public class MainActivity extends AppCompatActivity implements MainView,View.OnClickListener{

    DataModel dataModel=null;
    private TextView textmain;
    private MainBean mainBean=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        dataModel=new DataModel();
        dataModel.setMainView(this);
        dataModel.querDatas();
        textmain.setOnClickListener(this);
    }
    void initView(){
        textmain = (TextView)findViewById(R.id.text_main);
    }

    @Override
    public void refresData(MainBean mainBean) {
        LogUtils.log(MainActivity.class,mainBean.getList().get(0).getGname());
        this.mainBean=mainBean;
        textmain.setText(mainBean.getList().get(0).getGname());
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("id",mainBean.getList().get(0).getId());
        startActivity(intent);
    }
}
