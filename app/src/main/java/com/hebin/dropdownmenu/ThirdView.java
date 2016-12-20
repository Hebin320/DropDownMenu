package com.hebin.dropdownmenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ThirdView extends Fragment {


    @InjectView(R.id.tv_01)
    TextView tv01;
    @InjectView(R.id.tv_02)
    TextView tv02;
    @InjectView(R.id.tv_03)
    TextView tv03;


    MyItemClickListener listener;

    public void setListener(MyItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_view, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    @OnClick({R.id.tv_01, R.id.tv_02, R.id.tv_03})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_01:
                listener.onItemClick(view,3,"tvOne");
                break;
            case R.id.tv_02:
                listener.onItemClick(view,3,"tvTwo");
                break;
            case R.id.tv_03:
                listener.onItemClick(view,3,"tvThree");
                break;
        }
    }
}
