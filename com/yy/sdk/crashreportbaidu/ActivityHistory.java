package com.yy.sdk.crashreportbaidu;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import com.baidu.tieba.obc;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public enum ActivityHistory {
    INSTANCE;
    
    public static final String BACKGROUND = "BACKGROUND";
    public static final int MAX_LENGTH = 500;
    public static final int MAX_SIZE = 15;
    public static final String SCREEN_OFF = "SCREEN_OFF";
    public static final String SCREEN_ON = "SCREEN_ON";
    public static final String TAG = "History";
    public final List<String> mHistory = new ArrayList();
    public int mLastTrimLevel = 0;
    public int count = 0;

    /* loaded from: classes10.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            ActivityHistory.this.addRecord(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            ActivityHistory.access$008(ActivityHistory.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            ActivityHistory.access$010(ActivityHistory.this);
        }
    }

    /* loaded from: classes10.dex */
    public class b implements ComponentCallbacks2 {
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        public b() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            obc.b(ActivityHistory.TAG, "trim level: " + i);
            ActivityHistory.this.mLastTrimLevel = i;
            if (i == 20) {
                ActivityHistory.this.addRecord(ActivityHistory.BACKGROUND);
            }
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            obc.b(ActivityHistory.TAG, "low memory");
        }
    }

    public int getLastTrimLevel() {
        return this.mLastTrimLevel;
    }

    public boolean isForeground() {
        if (this.count == 0) {
            return false;
        }
        return true;
    }

    ActivityHistory() {
    }

    public static /* synthetic */ int access$008(ActivityHistory activityHistory) {
        int i = activityHistory.count;
        activityHistory.count = i + 1;
        return i;
    }

    public static /* synthetic */ int access$010(ActivityHistory activityHistory) {
        int i = activityHistory.count;
        activityHistory.count = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addRecord(Activity activity) {
        addRecord(activity.getClass().getSimpleName());
    }

    public void init(Context context) {
        if ((context instanceof Application) && Build.VERSION.SDK_INT >= 14) {
            ((Application) context).registerActivityLifecycleCallbacks(new a());
            context.registerComponentCallbacks(new b());
        }
    }

    public void addRecord(String str) {
        this.mHistory.add(str + ":" + System.currentTimeMillis());
        if (this.mHistory.size() > 15) {
            this.mHistory.remove(0);
        }
    }

    public String getHistory() {
        String str = "";
        synchronized (this.mHistory) {
            for (int size = this.mHistory.size() - 1; size >= 0; size--) {
                String str2 = this.mHistory.get(size);
                if (str.length() + str2.length() > 500) {
                    break;
                }
                str = str2 + "|" + str;
            }
        }
        if (str.endsWith("|")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }
}
