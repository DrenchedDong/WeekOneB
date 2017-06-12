package dongting.bwei.com.weekoneb;

import android.app.Application;

import org.xutils.x;

/**
 * 作者:${董婷}
 * 日期:2017/6/11
 * 描述:
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
