package dongting.bwei.com.weekoneb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import dongting.bwei.com.weekoneb.adapter.MyAdapter;
import dongting.bwei.com.weekoneb.bean.Student;

/**
 * 作者:${董婷}
 * 日期:2017/6/11
 * 描述:
 */
//http://result.eolinker.com/Ikx4fDc398b93bfd0c8a146468e1f8cddfe9166719cba13?uri=zhoukao

public class SecondActivity extends Activity {

    private RecyclerView recyclerView;
    private ProgressBar bar;

    private List<Student.StudentsBean.StudentBean> list=new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_two);

        bar = (ProgressBar) findViewById(R.id.bar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        initData();

        adapter = new MyAdapter(list,SecondActivity.this);
        recyclerView.setAdapter(adapter);

         adapter.setOnItemClickListener(new MyItemClickListener() {
            @Override
            public void onItemClick(View view, int postion) {
                Intent intent = new Intent(SecondActivity.this, DetailActivity.class);
                intent.putExtra("content", list.get(postion).getContent());
                intent.putExtra("name", list.get(postion).getName());
                intent.putExtra("image", list.get(postion).getImg());
                startActivity(intent);
            }
        });
    }

    private void initData() {

        RequestParams requestParams =new RequestParams
                ("http://result.eolinker.com/Ikx4fDc398b93bfd0c8a146468e1f8cddfe9166719cba13?uri=zhoukao");

        x.http().get(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                Gson gson =new Gson();
                Student student = gson.fromJson(result, Student.class);

                List<Student.StudentsBean.StudentBean> studentList = student.getStudents().getStudent();

                list.addAll(studentList);

                adapter.notifyDataSetChanged();

                bar.setVisibility(View.GONE);
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
}
