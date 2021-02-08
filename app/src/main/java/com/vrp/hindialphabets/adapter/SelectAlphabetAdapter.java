package com.vrp.hindialphabets.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.vrp.hindialphabets.R;
import com.vrp.hindialphabets.model.SelectAlphabetModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectAlphabetAdapter extends RecyclerView.Adapter<SelectAlphabetAdapter.ViewHolder> {

    private Context context;
    private List<SelectAlphabetModel> alphabetModelList;
    ClickListener clickListener;

    public SelectAlphabetAdapter(Context context, List<SelectAlphabetModel> alphabetModelList) {
        this.context = context;
        this.alphabetModelList = alphabetModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_select_alphabet_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_vowels.setText(alphabetModelList.get(position).getTv_vowels());
        holder.ll_vowels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onAplhabetClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return alphabetModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_vowels)
        TextView tv_vowels;
        @BindView(R.id.ll_vowels)
        LinearLayout ll_vowels;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface ClickListener {
        void onItemClick(int position);

        void onAplhabetClick(int position);
    }
    public void onItemClick(ClickListener listener) {
        this.clickListener = listener;
    }
}
