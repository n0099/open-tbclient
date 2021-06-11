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
    public static final boolean f43314h;

    /* renamed from: e  reason: collision with root package name */
    public int f43315e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43316f = true;

    /* renamed from: g  reason: collision with root package name */
    public int f43317g = 0;

    static {
        f43314h = d.a.d0.a.b.a.f43271a.get() == null || d.a.d0.a.b.a.f43271a.get().s();
    }

    public void a(Activity activity) {
        if (f43314h) {
            Log.d("PrologueActivityLifecycle", "进前台--启动类型： " + this.f43317g);
        }
        if (this.f43316f) {
            this.f43317g = 0;
            this.f43316f = false;
        }
        SplashAdFacade.e().h(this.f43317g);
    }

    public void b(Activity activity) {
        if (f43314h) {
            Log.d("PrologueActivityLifecycle", "退后台");
        }
        this.f43317g = 1;
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
        int i2 = this.f43315e + 1;
        this.f43315e = i2;
        if (i2 == 1) {
            a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        int i2 = this.f43315e - 1;
        this.f43315e = i2;
        if (i2 == 0) {
            b(activity);
        }
    }
}
