package com.bytedance.tea.crash.e.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Application f7933a;

    /* renamed from: b  reason: collision with root package name */
    private Context f7934b;
    private String g;
    private long h;
    private String i;
    private long j;
    private String k;
    private long l;
    private String m;
    private long n;
    private String o;
    private long p;
    private int q;
    private List<String> c = new ArrayList();
    private List<Long> d = new ArrayList();
    private List<String> e = new ArrayList();
    private List<Long> f = new ArrayList();
    private final Application.ActivityLifecycleCallbacks pqa = new Application.ActivityLifecycleCallbacks() { // from class: com.bytedance.tea.crash.e.a.b.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            b.this.g = activity.getClass().getName();
            b.this.h = System.currentTimeMillis();
            b.this.c.add(b.this.g);
            b.this.d.add(Long.valueOf(b.this.h));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            b.this.i = activity.getClass().getName();
            b.this.j = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            b.this.k = activity.getClass().getName();
            b.this.l = System.currentTimeMillis();
            b.f(b.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            b.this.m = activity.getClass().getName();
            b.this.n = System.currentTimeMillis();
            b.g(b.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            b.this.o = activity.getClass().getName();
            b.this.p = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            int indexOf = b.this.c.indexOf(name);
            if (indexOf > -1 && indexOf < b.this.c.size()) {
                b.this.c.remove(indexOf);
                b.this.d.remove(indexOf);
            }
            b.this.e.add(name);
            b.this.f.add(Long.valueOf(System.currentTimeMillis()));
        }
    };

    static /* synthetic */ int f(b bVar) {
        int i = bVar.q;
        bVar.q = i + 1;
        return i;
    }

    static /* synthetic */ int g(b bVar) {
        int i = bVar.q;
        bVar.q = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(@NonNull Context context) {
        this.f7934b = context;
        if (this.f7934b instanceof Application) {
            this.f7933a = (Application) context;
        }
        c();
    }

    private void c() {
        if (Build.VERSION.SDK_INT >= 14 && this.f7933a != null) {
            this.f7933a.registerActivityLifecycleCallbacks(this.pqa);
        }
    }

    private JSONArray d() {
        JSONArray jSONArray = new JSONArray();
        if (this.c == null || this.c.isEmpty()) {
            return jSONArray;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.c.size()) {
                break;
            }
            try {
                jSONArray.put(a(this.c.get(i2), this.d.get(i2).longValue()));
                i = i2 + 1;
            } catch (Throwable th) {
            }
        }
        return jSONArray;
    }

    private JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        if (this.e == null || this.e.isEmpty()) {
            return jSONArray;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.e.size()) {
                break;
            }
            try {
                jSONArray.put(a(this.e.get(i2), this.f.get(i2).longValue()));
                i = i2 + 1;
            } catch (Throwable th) {
            }
        }
        return jSONArray;
    }

    private JSONObject a(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", a(this.g, this.h));
            jSONObject.put("last_start_activity", a(this.i, this.j));
            jSONObject.put("last_resume_activity", a(this.k, this.l));
            jSONObject.put("last_pause_activity", a(this.m, this.n));
            jSONObject.put("last_stop_activity", a(this.o, this.p));
            jSONObject.put("alive_activities", d());
            jSONObject.put("finish_activities", e());
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public JSONArray b() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            activityManager = (ActivityManager) this.f7934b.getSystemService(PushConstants.INTENT_ACTIVITY_NAME);
        } catch (Exception e) {
        }
        if (activityManager != null && (runningTasks = activityManager.getRunningTasks(5)) != null) {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo != null && runningTaskInfo.baseActivity != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("id", runningTaskInfo.id);
                        jSONObject.put("package_name", runningTaskInfo.baseActivity.getPackageName());
                        jSONObject.put("description", runningTaskInfo.description);
                        jSONObject.put("number_of_activities", runningTaskInfo.numActivities);
                        jSONObject.put("number_of_running_activities", runningTaskInfo.numRunning);
                        jSONObject.put("topActivity", runningTaskInfo.topActivity.toString());
                        jSONObject.put("baseActivity", runningTaskInfo.baseActivity.toString());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e2) {
                    }
                }
            }
            return jSONArray;
        }
        return jSONArray;
    }
}
