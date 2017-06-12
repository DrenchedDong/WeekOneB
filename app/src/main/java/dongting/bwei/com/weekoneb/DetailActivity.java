package dongting.bwei.com.weekoneb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * 作者:${董婷}
 * 日期:2017/6/11
 * 描述:
 */

public class DetailActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.detail);

        TextView tv = (TextView) findViewById(R.id.tabber_title);
        ImageView iv = (ImageView) findViewById(R.id.image);
        TextView content = (TextView) findViewById(R.id.detatil_content);
        Intent intent = getIntent();
        String content1 = intent.getStringExtra("content");
        content.setText(content1);
        String name = intent.getStringExtra("name");
        tv.setText(name + "的信息");

        Glide.with(this).load(intent.getStringExtra("image"))
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(iv);
    }
}
