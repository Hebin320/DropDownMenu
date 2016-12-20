package com.hebin.dropdownmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yyydjk.library.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements MyItemClickListener {

    @InjectView(R.id.dropDownMenu)
    DropDownMenu mDropDownMenu;


    private String headers[] = {"界面一", "界面二","界面三"};
    private List<View> popupViews = new ArrayList<>();
    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initView();
    }

    private void initView() {

        /**
         * 第一个界面
        * */
        FirstView firstView = new FirstView(MainActivity.this);
        firstView.setListener(this);
        popupViews.add(firstView.firstView());
        /**
        * 第二个界面
        * */
        SecView secView = new SecView(MainActivity.this);
        secView.setListener(this);
        popupViews.add(secView.secView());
        /**
        * 第三个界面
        * */
        View thirdView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_third, null);
        ThirdView fragment = (ThirdView) getSupportFragmentManager().findFragmentById(R.id.fg_third);
        fragment.setListener(this);
        popupViews.add(thirdView);

        /**
        * Dropdownmenu下面的主体部分
        * */
        View fifthView = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main_view, null);
        tvText = (TextView) fifthView.findViewById(R.id.tv_text);
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, fifthView);
    }

    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (mDropDownMenu.isShowing()) {
            mDropDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }


    /**
    * 每个界面中的控件的点击事件，点击将界面中的参数传给activity中调用
    * */
    @Override
    public void onItemClick(View view, int postion, String string) {
        switch (postion){
            case 1:
                mDropDownMenu.setTabText(string);
                mDropDownMenu.closeMenu();
                tvText.setText(string);
                break;
            case 2:
                mDropDownMenu.setTabText(string);
                mDropDownMenu.closeMenu();
                tvText.setText(string);
                break;
            case 3:
                mDropDownMenu.setTabText(string);
                mDropDownMenu.closeMenu();
                tvText.setText(string);
                break;
            default:
                break;
        }
    }
}
