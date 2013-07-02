package com.mofamulu.tieba.dslv.lock;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.util.Log;
import com.baidu.tieba.nearby.NearbyMapActivity;
import com.baidu.tieba.pb.ImageActivity;
import com.baidu.tieba.pb.WebActivity;
import com.baidu.tieba.pb.WebBdActivity;
import com.baidu.tieba.person.EditHeadActivity;
import com.baidu.tieba.write.WriteImageActivity;
import com.mofamulu.tieba.ch.bg;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static volatile long c;
    public static boolean d;
    List e = new LinkedList();
    public static final a a = new a();
    public static volatile boolean b = false;
    private static int f = -1;

    private a() {
        this.e.add(WriteImageActivity.class);
        this.e.add(WebActivity.class);
        this.e.add(WebBdActivity.class);
        this.e.add(EditHeadActivity.class);
        this.e.add(NearbyMapActivity.class);
    }

    public void a(Activity activity) {
        if (activity instanceof ImageActivity) {
            d = false;
        }
        if (!b) {
            c = System.currentTimeMillis();
        }
    }

    public void a() {
        if (!b) {
            c = System.currentTimeMillis();
        }
    }

    public void b(Activity activity) {
        if (!b) {
            c = System.currentTimeMillis();
        }
    }

    public void c(Activity activity) {
        Activity activity2;
        Intent a2;
        if (activity instanceof ImageActivity) {
            d = true;
        } else {
            d = false;
        }
        bg c2 = bg.c();
        if (c2.Q()) {
            int max = Math.max(c2.P() * 60000, 2000);
            long currentTimeMillis = System.currentTimeMillis() - c;
            if ((currentTimeMillis < 0 && currentTimeMillis > -2000) || currentTimeMillis > max) {
                Log.v("tbhp_sl", "interval:" + currentTimeMillis);
                if (activity.getParent() instanceof TabActivity) {
                    activity2 = activity.getParent();
                    int currentTab = ((TabActivity) activity2).getTabHost().getCurrentTab();
                    if (currentTab != f) {
                        f = currentTab;
                        a();
                        return;
                    }
                } else {
                    activity2 = activity;
                }
                if (!this.e.contains(activity2.getClass()) && c2.x().d() && (a2 = LockPatternActivity.a(activity2, c2)) != null) {
                    b = true;
                    activity2.startActivity(a2);
                }
            }
        }
    }
}
