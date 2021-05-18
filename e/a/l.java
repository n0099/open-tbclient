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
    public Integer f68209e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final Object f68210f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public final DxmSdkSensorsDataAPI f68211g;

    /* renamed from: h  reason: collision with root package name */
    public final g f68212h;

    /* renamed from: i  reason: collision with root package name */
    public final f f68213i;

    public l(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI, g gVar, f fVar) {
        this.f68211g = dxmSdkSensorsDataAPI;
        this.f68212h = gVar;
        this.f68213i = fVar;
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
            synchronized (this.f68210f) {
                if (this.f68209e.intValue() == 0) {
                    if (this.f68213i.b() == null) {
                        this.f68213i.a(j.format(Long.valueOf(System.currentTimeMillis())));
                    }
                    this.f68212h.b().booleanValue();
                    try {
                        this.f68211g.i();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f68211g.F();
                }
                this.f68209e = Integer.valueOf(this.f68209e.intValue() + 1);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            synchronized (this.f68210f) {
                Integer valueOf = Integer.valueOf(this.f68209e.intValue() - 1);
                this.f68209e = valueOf;
                if (valueOf.intValue() == 0) {
                    try {
                        this.f68211g.K();
                        this.f68211g.j();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        this.f68211g.p();
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
