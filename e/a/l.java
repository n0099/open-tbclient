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
    public Integer f67523e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final Object f67524f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public final DxmSdkSensorsDataAPI f67525g;

    /* renamed from: h  reason: collision with root package name */
    public final g f67526h;

    /* renamed from: i  reason: collision with root package name */
    public final f f67527i;

    public l(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI, g gVar, f fVar) {
        this.f67525g = dxmSdkSensorsDataAPI;
        this.f67526h = gVar;
        this.f67527i = fVar;
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
            synchronized (this.f67524f) {
                if (this.f67523e.intValue() == 0) {
                    if (this.f67527i.b() == null) {
                        this.f67527i.a(j.format(Long.valueOf(System.currentTimeMillis())));
                    }
                    this.f67526h.b().booleanValue();
                    try {
                        this.f67525g.i();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f67525g.F();
                }
                this.f67523e = Integer.valueOf(this.f67523e.intValue() + 1);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            synchronized (this.f67524f) {
                Integer valueOf = Integer.valueOf(this.f67523e.intValue() - 1);
                this.f67523e = valueOf;
                if (valueOf.intValue() == 0) {
                    try {
                        this.f67525g.K();
                        this.f67525g.j();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        this.f67525g.p();
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
