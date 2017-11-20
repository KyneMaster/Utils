package com.anche.kyne.sewagemonitorplatform_management_hunan.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anche.kyne.sewagemonitorplatform_management_hunan.R;
import com.anche.kyne.sewagemonitorplatform_management_hunan.base.NewlyBaseActivity;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;
import java.util.List;

public class NewlyHomeActivity extends NewlyBaseActivity implements AdapterView.OnItemClickListener {
    GridMenuAdapter mAdapter;
    SliderLayout mSliderLayout;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_newly_home;
    }

    @Override
    protected void initContent() {
        mSliderLayout = (SliderLayout) findViewById(R.id.slider);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //        getSupportActionBar().setLogo(R.drawable.biaotou);
        getSupportActionBar().setTitle(R.string.app_name);
        setupSlider();
        setupMenus();
    }

    @Override
    protected void initData() {

    }

    /*设置标题头*/
    @Override
    public void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setupSlider() {
        mSliderLayout = (SliderLayout) findViewById(R.id.slider);
        int[] imageRes = new int[]{R.mipmap.new_banner1, R.mipmap.new_banner2, R.mipmap.new_banner3};
        String[] titles = new String[]{"弘扬劳模精神 助力追赶超越", "省公安厅交警总队徐小宁副总队长带队督导检查兴平市道路交通安全工作 ", "省公安厅交警总队李昌政委出席咸阳城市道路交通管理工作现场会"};
        for (int i = 0; i < 3; i++) {
            TextSliderView item = new TextSliderView(this);
            item.description(titles[i])
                    .image(imageRes[i])
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
            mSliderLayout.addSlider(item);
        }
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
    }

    /*设置九宫格样式*/
    private void setupMenus() {
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("信息查询统计", R.drawable.query, NewlyBaseActivity.class));
        menuItems.add(new MenuItem("检测数据验证", R.drawable.btn_menu_but7, NewlyBaseActivity.class));
        menuItems.add(new MenuItem("路检抽检", R.drawable.btn_menu_but1, NewlyBaseActivity.class));
        menuItems.add(new MenuItem("检验报告单核发", R.drawable.btn_menu_but4, NewlyBaseActivity.class));
        menuItems.add(new MenuItem("检测过程监控", R.drawable.btn_menu_but4, NewlyBaseActivity.class));
        menuItems.add(new MenuItem("资料下载", R.drawable.btn_menu_but4, NewlyBaseActivity.class));
        mAdapter = new GridMenuAdapter(this, menuItems);
        gridView.setAdapter(mAdapter);
        gridView.setOnItemClickListener(this);
    }


    /*九宫格的点击事件*/
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(this, BuChuanPicActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent.setClass(this, PersionInfoActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
                break;
            case 3:

                intent.setClass(this, BaoFeiCarActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent.setClass(this, BoHuiCarsActivity.class);
                startActivity(intent);
                break;
            case 5:
                intent.setClass(this, FindCarListActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }


    }

    /*点击的返回事件*/
    @Override
    public void onBackPressed() {
        exitApp();
    }

    private long exitTime = 0;

    /*双击退出APP*/
    private void exitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "再按一次退出...", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @Override
    public void onClick(View view) {

    }

    /*GridView的Item的初始化*/
    public class MenuItem {
        public String text;
        public int iconRes;
        public Class<?> aClass;

        public MenuItem(String text, int iconRes, Class<?> cls) {
            this.text = text;
            this.iconRes = iconRes;
            this.aClass = cls;
        }
    }

    /*GridView的适配器*/
    public class GridMenuAdapter extends ArrayAdapter<MenuItem> {

        int resourceId = R.layout.main_gridview_item_menu;
        int textResId = R.id.text;
        int iconResId = R.id.icon;
        Context mContext;

        public GridMenuAdapter(Context context, List<MenuItem> objects) {
            super(context, 0, objects);
            this.mContext = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            TextView text;
            ImageView icon;

            if (convertView == null) {
                view = LayoutInflater.from(mContext).inflate(resourceId, parent, false);
            } else {
                view = convertView;
            }
            text = (TextView) view.findViewById(textResId);
            icon = (ImageView) view.findViewById(iconResId);
            MenuItem item = getItem(position);
            text.setText(item.text);
            if (item.iconRes != 0) {
                icon.setImageResource(item.iconRes);
            } else {
                icon.setVisibility(View.GONE);
            }
            return view;
        }
    }
}
