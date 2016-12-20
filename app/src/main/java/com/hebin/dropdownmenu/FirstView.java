package com.hebin.dropdownmenu;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

class FirstView {

    private Context context;
    private MyItemClickListener listener;

    FirstView(Context context) {
        this.context = context;
    }

    void setListener(MyItemClickListener listener) {
        this.listener = listener;
    }

    View firstView() {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_first, null);
        TextView tvBtnOne = (TextView) view.findViewById(R.id.btn_one);
        TextView tvBtnTwo = (TextView) view.findViewById(R.id.btn_two);
        tvBtnOne.setOnClickListener(new mClick("第一个"));
        tvBtnTwo.setOnClickListener(new mClick("第二个"));
        return view;
    }

    private class mClick implements View.OnClickListener {

        String string;

        private mClick(String string) {
            this.string = string;
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(v, 1, string);
        }
    }

}
