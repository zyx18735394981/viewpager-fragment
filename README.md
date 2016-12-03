MainActivity

            package com.zyx.viewpagerfragment_12_1;
            import android.graphics.Color;
            import android.os.Bundle;
            import android.support.v4.app.Fragment;
           import android.support.v4.app.FragmentActivity;
           import android.support.v4.view.ViewPager;
           import android.view.View;
           import android.widget.LinearLayout;
           import android.widget.TextView;

           import com.zyx.viewpagerfragment_12_1.Adapter.MyPagerAdapter;
           import com.zyx.viewpagerfragment_12_1.Fragment.Fragment1;
           import com.zyx.viewpagerfragment_12_1.Fragment.Fragment2;

           import java.util.ArrayList;
           import java.util.List;
           public class MainActivity extends Fragm entActivity {
               private LinearLayout ll_line;
             private LinearLayout ll_title;
             private ViewPager vp;
             //存放四个页面,集合里面放Fragment，当前的activity要继承FragmentActivity
             private List<Fragment> list;

             private List<TextView> listTitle;//title
             private List<TextView> listLine;//line

             @Override
             protected void onCreate(Bundle savedInstanceState) {
                 super.onCreate(savedInstanceState);
                 setContentView(R.layout.activity_main);

                 initUI();//初始化控件


                initData();//初始化数据

                //v4包下的Fragment就用getSupportFragmentManager()---自己写的adapter
                MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), list);

                vp.setAdapter(adapter);


                initTitleLineData();//把title跟line分别放入对应的集合里面


                //设置line的颜色以及title的状态
                setData();

               //设置滑动监听
                vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int i, float v, int i2) {

                    }

                    @Override
                    public void onPageSelected(int i) {
                        for(int j=0;j<list.size();j++){
                            listTitle.get(j).setEnabled(true);
                            listLine.get(j).setBackgroundColor(Color.GRAY);

                        }
                        listTitle.get(i).setEnabled(false);
                        listLine.get(i).setBackgroundColor(Color.GREEN);


                    }

                    @Override
                    public void onPageScrollStateChanged(int i) {

                    }
                });


            }

            private void initUI() {
                ll_line = (LinearLayout) findViewById(R.id.ll_line);
                ll_title = (LinearLayout) findViewById(R.id.ll_title);
                vp = (ViewPager) findViewById(R.id.vp);

            }

            private void initData() {
                list = new ArrayList<>();
                Fragment1 fragment1 = new Fragment1();
                Fragment2 fragment2 = new Fragment2();
                Fragment1 fragment3 = new Fragment1();
                Fragment2 fragment4 = new Fragment2();

                //把四个Fragment添加到集合里面
                list.add(fragment1);
                list.add(fragment2);
                list.add(fragment3);
                list.add(fragment4);


            }

            private void initTitleLineData() {
                //循环找控件--把title放入listTitle集合 把Line放入listLine集合

                listTitle = new ArrayList<>();



                //放title
                for (int i = 0; i < list.size(); i++) {

                    TextView tv_title = (TextView) ll_title.getChildAt(i);

                    listTitle.add(tv_title);

                }

                listLine = new ArrayList<>();

                //放line
                for (int j = 0; j < list.size(); j++) {

                    TextView tv_line = (TextView) ll_line.getChildAt(j);

                    listLine.add(tv_line);

                }

                //默认第一个按钮选中 下划线为绿色
                listTitle.get(0).setEnabled(false);
                listLine.get(0).setBackgroundColor(Color.GREEN);
                vp.setCurrentItem(0);


            }

            //设置点击textview，底线跟禁用的状态

            private void setData() {

                for(int i=0;i<listTitle.size();i++){

                    listTitle.get(i).setTag(i);
                    //循环设置点击事件,
                    listTitle.get(i).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //循环将下划线变成默认灰
                            for (int j=0;j<listTitle.size();j++){
                                    listLine.get(j).setBackgroundColor(Color.GRAY);
                                listTitle.get(j).setEnabled(true);

                            }

                            //当前选中的设置成绿色
                            listLine.get((Integer)v.getTag()).setBackgroundColor(Color.GREEN);
                            listTitle.get((Integer)v.getTag()).setEnabled(false);
                            vp.setCurrentItem((Integer)v.getTag());

                        }
                    });

                }

            }


            }
Adapter
            
             package com.zyx.viewpagerfragment_12_1.Adapter;

              import android.support.v4.app.Fragment;
              import android.support.v4.app.FragmentManager;
              import android.support.v4.app.FragmentPagerAdapter;

              import java.util.List;

              /**
               * Created by Administrator on 2016/12/1 0001.
               * Administrator  ZYX
               */
              public class MyPagerAdapter extends FragmentPagerAdapter{
                  private List<Fragment> listdata;

              //传过来list数据，也就是四个界面
                  public MyPagerAdapter(FragmentManager fm,List<Fragment> list) {
                      super(fm);
                      listdata=list;
                  }

                  @Override
                  public Fragment getItem(int position) {
                      return listdata.get(position);
                  }

                  @Override
                  public int getCount() {
                      return listdata.size();
                  }


              }
fragment页面

              package com.zyx.viewpagerfragment_12_1.Fragment;

      import android.os.Bundle;
      import android.support.annotation.Nullable;
      import android.support.v4.app.Fragment;
      import android.view.LayoutInflater;
      import android.view.View;
      import android.view.ViewGroup;

      import com.zyx.viewpagerfragment_12_1.R;

      /**
       * Created by Administrator on 2016/12/1 0001.
       * Administrator  ZYX
       */
      public class Fragment1 extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
             View view=inflater.inflate(R.layout.fragment1_item,container,false);

             return view;
    }
       }
       
xml布局

                <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
                                xmlns:tools="http://schemas.android.com/tools"
                                android:layout_width="match_parent"
                                android:layout_height="match_parent"
                                android:orientation="vertical"
                                tools:context=".MainActivity">


                    <LinearLayout
                        android:id="@+id/ll_title"
                        android:layout_width="match_parent"
                        android:layout_height="0dp"
                        android:layout_weight="0.5"
                        android:orientation="horizontal"
                        >

                        <TextView
                            android:layout_marginTop="2dp"
                            android:layout_width="0dp"
                            android:layout_weight="1"
                            android:layout_height="wrap_content"
                            android:text="新闻"
                            android:gravity="center"

                            />
                        <TextView
                            android:layout_marginTop="2dp"
                            android:layout_width="0dp"
                            android:layout_weight="1"
                            android:layout_height="wrap_content"
                            android:text="八卦"
                            android:gravity="center"
                            />

                        <TextView
                            android:layout_marginTop="2dp"
                            android:layout_width="0dp"
                            android:layout_weight="1"
                            android:layout_height="wrap_content"
                            android:text="娱乐"
                            android:gravity="center"
                            />
                        <TextView
                            android:layout_marginTop="2dp"
                            android:layout_width="0dp"
                            android:layout_weight="1"
                            android:layout_height="wrap_content"
                            android:text="网络"
                            android:gravity="center"
                            />

                    </LinearLayout>


                    <LinearLayout
                        android:id="@+id/ll_line"
                        android:layout_width="match_parent"
                        android:layout_height="0dp"
                        android:layout_weight="0.1"
                        android:orientation="horizontal"
                        >


                        <TextView
                            android:layout_width="0dp"
                            android:layout_weight="1"
                            android:layout_height="wrap_content"
                           android:background="#cccccc"

                            />
                        <TextView
                            android:layout_width="0dp"
                            android:layout_weight="1"
                            android:layout_height="wrap_content"
                            android:background="#cccccc"

                            />

                        <TextView
                            android:layout_width="0dp"
                            android:layout_weight="1"
                            android:layout_height="wrap_content"
                            android:background="#cccccc"


                            />
                        <TextView
                            android:layout_width="0dp"
                            android:layout_weight="1"
                            android:layout_height="wrap_content"
                            android:background="#cccccc"

                            />



                    </LinearLayout>

                    <android.support.v4.view.ViewPager
                        android:id="@+id/vp"
                        android:layout_width="match_parent"
                        android:layout_height="0dp"
                        android:layout_weight="10"
                        />




                </LinearLayout>
