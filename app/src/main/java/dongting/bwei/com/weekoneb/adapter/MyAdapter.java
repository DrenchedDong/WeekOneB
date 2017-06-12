package dongting.bwei.com.weekoneb.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import dongting.bwei.com.weekoneb.MyItemClickListener;
import dongting.bwei.com.weekoneb.R;
import dongting.bwei.com.weekoneb.bean.Student;

/**
 * 作者:${董婷}
 * 日期:2017/6/11
 * 描述:
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CViewHolder>{
    private LayoutInflater inflater;
    private List<Student.StudentsBean.StudentBean> list;
    private Context context;

    public MyAdapter(List<Student.StudentsBean.StudentBean> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyAdapter.CViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_item, parent, false);

        CViewHolder viewHolder = new CViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.CViewHolder holder, final int position) {

        holder.title.setText(list.get(position).getName());
        Glide.with(context).load(list.get(position).getImg()).
                diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.iv);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }



    class CViewHolder extends RecyclerView.ViewHolder{
        private MyItemClickListener mListener;
        TextView title;
        ImageView iv;

        public CViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.b_title);
            iv= (ImageView) itemView.findViewById(R.id.iv);
        }
    }


    public MyItemClickListener listener ;

    public void setOnItemClickListener(MyItemClickListener listener){

        this.listener = listener;
    }
}
