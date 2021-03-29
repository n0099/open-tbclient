package e.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import dxm.sasdk.DxmSdkSensorsDataAPI;
import java.text.SimpleDateFormat;
import java.util.Locale;
@TargetApi(14)
/* loaded from: classes7.dex */
public class l implements Application.ActivityLifecycleCallbacks {
    public static final SimpleDateFormat j = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    /* renamed from: e  reason: collision with root package name */
    public Integer f67433e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final Object f67434f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public final DxmSdkSensorsDataAPI f67435g;

    /* renamed from: h  reason: collision with root package name */
    public final g f67436h;
    public final f i;

    public l(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI, g gVar, f fVar) {
        this.f67435g = dxmSdkSensorsDataAPI;
        this.f67436h = gVar;
        this.i = fVar;
    }

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
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        try {
            synchronized (this.f67434f) {
                if (this.f67433e.intValue() == 0) {
                    if (this.i.b() == null) {
                        this.i.a(j.format(Long.valueOf(System.currentTimeMillis())));
                    }
                    this.f67436h.b().booleanValue();
                    try {
                        this.f67435g.i();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f67435g.F();
                }
                this.f67433e = Integer.valueOf(this.f67433e.intValue() + 1);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            synchronized (this.f67434f) {
                Integer valueOf = Integer.valueOf(this.f67433e.intValue() - 1);
                this.f67433e = valueOf;
                if (valueOf.intValue() == 0) {
                    try {
                        this.f67435g.K();
                        this.f67435g.j();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        this.f67435g.p();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
