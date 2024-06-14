package com.mcal.uidesigner.helper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mcal.uidesigner.R;

public class BinderView extends RecyclerView.Adapter<BinderView.Holder> {

  @Override
  public Holder onCreateViewHolder(ViewGroup arg0, int pos) {
    View view =
        LayoutInflater.from(arg0.getContext()).inflate(R.layout.layout_bind_rv1, arg0, false);

    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(Holder holder, int arg1) {
    for (int i = 0; i < 20; ++i) {

      holder.text.setText("Item " + i);
    }
    holder.text.setOnClickListener(v -> {});
    holder.text.setFocusable(true);
    holder.text.setBackgroundResource(R.drawable.background_tv);
  }

  @Override
  public int getItemCount() {

    return 10;
  }

  class Holder extends RecyclerView.ViewHolder {
    TextView text;

    public Holder(View view) {
      super(view);
      text = view.findViewById(R.id.row);
    }
  }
}
