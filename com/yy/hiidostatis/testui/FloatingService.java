package com.yy.hiidostatis.testui;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.searchbox.download.util.LocalFilesFilterKt;
import com.yy.hiidostatis.inner.util.UiThreadExecutor;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public enum FloatingService {
    INSTANCT;
    
    public static final int DEFAULT_BG = 1879048192;
    public static final int MOVING_BG = 1895611159;
    public Context app;
    public String filterAppkey;
    public boolean isDebug;
    public ListView listView;
    public boolean movingState;
    public WindowManager windowManager;
    public WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
    public List<String> logs = new ArrayList();
    public LogAdapter adapter = new LogAdapter();
    public volatile boolean init = false;

    /* loaded from: classes10.dex */
    public class FloatingOnTouchListener implements View.OnTouchListener {
        public long downTime;
        public boolean hasDown;
        public int x;
        public int y;

        public FloatingOnTouchListener() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2 || !this.hasDown) {
                        return true;
                    }
                    if (FloatingService.this.movingState) {
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        int i = rawX - this.x;
                        int i2 = rawY - this.y;
                        this.x = rawX;
                        this.y = rawY;
                        FloatingService.this.layoutParams.x += i;
                        FloatingService.this.layoutParams.y += i2;
                        FloatingService.this.windowManager.updateViewLayout(view2, FloatingService.this.layoutParams);
                    } else if (System.currentTimeMillis() - this.downTime > 1500) {
                        FloatingService.this.movingState = true;
                        FloatingService.this.listView.setBackgroundColor(FloatingService.MOVING_BG);
                    }
                } else if (!this.hasDown) {
                    return true;
                } else {
                    this.hasDown = false;
                    if (FloatingService.this.movingState) {
                        FloatingService.this.movingState = false;
                        FloatingService.this.listView.setBackgroundColor(FloatingService.DEFAULT_BG);
                    }
                }
            } else {
                this.x = (int) motionEvent.getRawX();
                this.y = (int) motionEvent.getRawY();
                int[] iArr = new int[2];
                FloatingService.this.listView.getLocationOnScreen(iArr);
                int i3 = iArr[0];
                int i4 = this.x;
                if (i3 < i4 && i4 < iArr[0] + FloatingService.this.listView.getWidth()) {
                    int i5 = iArr[1];
                    int i6 = this.y;
                    if (i5 < i6 && i6 < iArr[1] + FloatingService.this.listView.getHeight()) {
                        this.hasDown = true;
                        this.downTime = System.currentTimeMillis();
                    }
                }
                this.hasDown = false;
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes10.dex */
    public class LogAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public LogAdapter() {
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return FloatingService.this.logs.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return FloatingService.this.logs.size();
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            TextView textView;
            LinearLayout linearLayout;
            if (view2 == null) {
                LinearLayout linearLayout2 = new LinearLayout(viewGroup.getContext());
                linearLayout2.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                linearLayout2.setDividerPadding(0);
                textView = new TextView(viewGroup.getContext());
                textView.setTag(LocalFilesFilterKt.FILTER_NAME_LOG);
                textView.setTextColor(-1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                textView.setLayoutParams(layoutParams);
                linearLayout2.addView(textView, layoutParams);
                linearLayout = linearLayout2;
            } else {
                textView = (TextView) view2.findViewWithTag(LocalFilesFilterKt.FILTER_NAME_LOG);
                linearLayout = view2;
            }
            textView.setText((CharSequence) FloatingService.this.logs.get(i));
            return linearLayout;
        }
    }

    public String getFilterAppkey() {
        return this.filterAppkey;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public boolean isInit() {
        return this.init;
    }

    FloatingService() {
    }

    public void setDebug(boolean z) {
        this.isDebug = z;
    }

    public void setFilterAppkey(String str) {
        this.filterAppkey = str;
    }

    public void showFloatingWindow(Activity activity) {
        this.isDebug = true;
        Application application = activity.getApplication();
        this.app = application;
        if (Build.VERSION.SDK_INT >= 23) {
            if (Settings.canDrawOverlays(application)) {
                initView();
                return;
            }
            return;
        }
        initView();
    }

    private void initView() {
        this.windowManager = (WindowManager) this.app.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
        ListView listView = new ListView(this.app);
        listView.setAdapter((ListAdapter) this.adapter);
        listView.setBackgroundColor(DEFAULT_BG);
        listView.setPadding(10, 10, 10, 10);
        this.listView = listView;
        if (Build.VERSION.SDK_INT >= 26) {
            this.layoutParams.type = 2038;
        } else {
            this.layoutParams.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.layoutParams;
        layoutParams.format = 1;
        layoutParams.width = -1;
        layoutParams.height = 300;
        layoutParams.x = 0;
        layoutParams.y = 10;
        layoutParams.flags = 40;
        layoutParams.gravity = 51;
        listView.setOnTouchListener(new FloatingOnTouchListener());
        this.windowManager.addView(listView, this.layoutParams);
        this.init = true;
    }

    public void addLog(String str, String str2, String str3, String str4, String str5) {
        final String format;
        if (!this.isDebug) {
            return;
        }
        String str6 = this.filterAppkey;
        if (str6 != null && !str6.isEmpty()) {
            if (!this.filterAppkey.startsWith(str2)) {
                return;
            }
            format = String.format("%s  %s  %s  %s", str, str3, str5, str4);
        } else {
            format = String.format("%s %s %s %s %s", str, str3, str5, str4, str2);
        }
        UiThreadExecutor.runTask(new Runnable() { // from class: com.yy.hiidostatis.testui.FloatingService.1
            @Override // java.lang.Runnable
            public void run() {
                if (FloatingService.this.logs.size() >= 499) {
                    FloatingService.this.logs.remove(0);
                }
                FloatingService.this.logs.add(format);
                if (FloatingService.this.init) {
                    FloatingService.this.adapter.notifyDataSetChanged();
                    FloatingService.this.listView.smoothScrollToPosition(FloatingService.this.logs.size());
                }
            }
        });
    }
}
