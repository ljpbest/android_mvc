package ljp.qianfeng.com.day10_31demo.model;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import ljp.qianfeng.com.day10_31demo.bean.DetialBean;
import ljp.qianfeng.com.day10_31demo.bean.MainBean;
import ljp.qianfeng.com.day10_31demo.model.http.URLConstants;
import ljp.qianfeng.com.day10_31demo.view.DetialView;
import ljp.qianfeng.com.day10_31demo.view.MainView;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class DataModel {
    MainView mainView;
    DetialView  detialView;

    public void setDetialView(DetialView detialView) {
        this.detialView = detialView;
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }
    public void queryDetial(String id){
        RequestParams requestParams=new RequestParams(URLConstants.DETIAL_URL);
        requestParams.addBodyParameter("id=",id);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                DetialBean detialBean = gson.fromJson(result, DetialBean.class);
                detialView.refreshDetialView(detialBean);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
    public void querDatas(){
        //网络请求
        RequestParams requestParams=new RequestParams(URLConstants.MAIN_LIST_URL);
        requestParams.addBodyParameter("pageno","1");
        //参数一：requestParma对象，用来封装网络请求需要的参数：参数二：callback

        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                MainBean mainBean = gson.fromJson(result, MainBean.class);
                mainView.refresData(mainBean);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

        } );
    }
}
