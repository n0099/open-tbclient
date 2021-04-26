package d.b.d.b.h.a;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Application f65172a;

    /* renamed from: b  reason: collision with root package name */
    public Context f65173b;

    /* renamed from: g  reason: collision with root package name */
    public String f65178g;

    /* renamed from: h  reason: collision with root package name */
    public long f65179h;

    /* renamed from: i  reason: collision with root package name */
    public String f65180i;
    public long j;
    public String k;
    public long l;
    public String m;
    public long n;
    public String o;
    public long p;
    public int q;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f65174c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public List<Long> f65175d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public List<String> f65176e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public List<Long> f65177f = new ArrayList();
    public final Application.ActivityLifecycleCallbacks r = new a();

    /* loaded from: classes5.dex */
    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            b.this.f65178g = activity.getClass().getName();
            b.this.f65179h = System.currentTimeMillis();
            b.this.f65174c.add(b.this.f65178g);
            b.this.f65175d.add(Long.valueOf(b.this.f65179h));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            int indexOf = b.this.f65174c.indexOf(name);
            if (indexOf > -1 && indexOf < b.this.f65174c.size()) {
                b.this.f65174c.remove(indexOf);
                b.this.f65175d.remove(indexOf);
            }
            b.this.f65176e.add(name);
            b.this.f65177f.add(Long.valueOf(System.currentTimeMillis()));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            b.this.m = activity.getClass().getName();
            b.this.n = System.currentTimeMillis();
            b.v(b.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            b.this.k = activity.getClass().getName();
            b.this.l = System.currentTimeMillis();
            b.r(b.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            b.this.f65180i = activity.getClass().getName();
            b.this.j = System.currentTimeMillis();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            b.this.o = activity.getClass().getName();
            b.this.p = System.currentTimeMillis();
        }
    }

    public b(@NonNull Context context) {
        this.f65173b = context;
        if (context instanceof Application) {
            this.f65172a = (Application) context;
        }
        m();
    }

    public static /* synthetic */ int r(b bVar) {
        int i2 = bVar.q;
        bVar.q = i2 + 1;
        return i2;
    }

    public static /* synthetic */ int v(b bVar) {
        int i2 = bVar.q;
        bVar.q = i2 - 1;
        return i2;
    }

    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("last_create_activity", e(this.f65178g, this.f65179h));
            jSONObject.put("last_start_activity", e(this.f65180i, this.j));
            jSONObject.put("last_resume_activity", e(this.k, this.l));
            jSONObject.put("last_pause_activity", e(this.m, this.n));
            jSONObject.put("last_stop_activity", e(this.o, this.p));
            jSONObject.put("alive_activities", q());
            jSONObject.put("finish_activities", u());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final JSONObject e(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("time", j);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0024 A[Catch: Exception -> 0x0077, TryCatch #0 {Exception -> 0x0077, blocks: (B:3:0x0005, B:6:0x0012, B:9:0x001a, B:10:0x001e, B:12:0x0024, B:14:0x002c, B:17:0x0031), top: B:22:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONArray i() {
        ActivityManager activityManager;
        List<ActivityManager.RunningTaskInfo> runningTasks;
        JSONArray jSONArray = new JSONArray();
        try {
            activityManager = (ActivityManager) this.f65173b.getSystemService("activity");
        } catch (Exception unused) {
        }
        if (activityManager == null || (runningTasks = activityManager.getRunningTasks(5)) == null) {
            return jSONArray;
        }
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
            if (runningTaskInfo != null) {
                if (runningTaskInfo.baseActivity != null) {
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
                    } catch (JSONException unused2) {
                    }
                }
                while (r1.hasNext()) {
                }
            }
        }
        return jSONArray;
    }

    public final void m() {
        Application application;
        if (Build.VERSION.SDK_INT < 14 || (application = this.f65172a) == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this.r);
    }

    public final JSONArray q() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f65174c;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < this.f65174c.size(); i2++) {
                try {
                    jSONArray.put(e(this.f65174c.get(i2), this.f65175d.get(i2).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public final JSONArray u() {
        JSONArray jSONArray = new JSONArray();
        List<String> list = this.f65176e;
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < this.f65176e.size(); i2++) {
                try {
                    jSONArray.put(e(this.f65176e.get(i2), this.f65177f.get(i2).longValue()));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }
}
