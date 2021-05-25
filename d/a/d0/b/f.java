package d.a.d0.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.SplashAdFacade;
@SuppressLint({"LongLogTag"})
/* loaded from: classes2.dex */
public class f implements Application.ActivityLifecycleCallbacks {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f39633h;

    /* renamed from: e  reason: collision with root package name */
    public int f39634e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f39635f = true;

    /* renamed from: g  reason: collision with root package name */
    public int f39636g = 0;

    static {
        f39633h = d.a.d0.a.b.a.f39590a.get() == null || d.a.d0.a.b.a.f39590a.get().s();
    }

    public void a(Activity activity) {
        if (f39633h) {
            Log.d("PrologueActivityLifecycle", "进前台--启动类型： " + this.f39636g);
        }
        if (this.f39635f) {
            this.f39636g = 0;
            this.f39635f = false;
        }
        SplashAdFacade.e().h(this.f39636g);
    }

    public void b(Activity activity) {
        if (f39633h) {
            Log.d("PrologueActivityLifecycle", "退后台");
        }
        this.f39636g = 1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        int i2 = this.f39634e + 1;
        this.f39634e = i2;
        if (i2 == 1) {
            a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        int i2 = this.f39634e - 1;
        this.f39634e = i2;
        if (i2 == 0) {
            b(activity);
        }
    }
}
