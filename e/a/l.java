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
    public Integer f71508e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final Object f71509f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public final DxmSdkSensorsDataAPI f71510g;

    /* renamed from: h  reason: collision with root package name */
    public final g f71511h;

    /* renamed from: i  reason: collision with root package name */
    public final f f71512i;

    public l(DxmSdkSensorsDataAPI dxmSdkSensorsDataAPI, g gVar, f fVar) {
        this.f71510g = dxmSdkSensorsDataAPI;
        this.f71511h = gVar;
        this.f71512i = fVar;
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
            synchronized (this.f71509f) {
                if (this.f71508e.intValue() == 0) {
                    if (this.f71512i.b() == null) {
                        this.f71512i.a(j.format(Long.valueOf(System.currentTimeMillis())));
                    }
                    this.f71511h.b().booleanValue();
                    try {
                        this.f71510g.i();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f71510g.F();
                }
                this.f71508e = Integer.valueOf(this.f71508e.intValue() + 1);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        try {
            synchronized (this.f71509f) {
                Integer valueOf = Integer.valueOf(this.f71508e.intValue() - 1);
                this.f71508e = valueOf;
                if (valueOf.intValue() == 0) {
                    try {
                        this.f71510g.K();
                        this.f71510g.j();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        this.f71510g.p();
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
