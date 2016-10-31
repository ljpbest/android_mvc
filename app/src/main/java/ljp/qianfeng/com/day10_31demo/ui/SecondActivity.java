package ljp.qianfeng.com.day10_31demo.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import ljp.qianfeng.com.day10_31demo.R;
import ljp.qianfeng.com.day10_31demo.bean.DetialBean;
import ljp.qianfeng.com.day10_31demo.model.DataModel;
import ljp.qianfeng.com.day10_31demo.view.DetialView;

public class SecondActivity extends AppCompatActivity implements DetialView{

    private String id;
    private DataModel dataModel;
    private TextView detial_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initview();
        id = getIntent().getStringExtra("id");
        dataModel = new DataModel();
        dataModel.setDetialView(this);
        dataModel.queryDetial(id);
    }
    void initview(){
        detial_text = (TextView)findViewById(R.id.detial_text);
    }
    @Override
    public void refreshDetialView(DetialBean detialBean) {
        detial_text.setText(detialBean.toString());
    }
}
