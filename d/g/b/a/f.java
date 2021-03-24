package d.g.b.a;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.baidu.ar.session.XRSessionAnchor;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.InstallActivity;
import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes6.dex */
public final class f extends ArCoreApk {

    /* renamed from: h */
    public static final f f66049h = new f();

    /* renamed from: a */
    public Exception f66050a;

    /* renamed from: b */
    public ArCoreApk.Availability f66051b;

    /* renamed from: c */
    public boolean f66052c;

    /* renamed from: d */
    public l f66053d;

    /* renamed from: e */
    public boolean f66054e;

    /* renamed from: f */
    public boolean f66055f;

    /* renamed from: g */
    public int f66056g;

    public static f d() {
        return f66049h;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static int k(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(XRSessionAnchor.apkinfo, 4);
            int i = packageInfo.versionCode;
            if (i == 0) {
                if (packageInfo.services != null) {
                    if (packageInfo.services.length == 0) {
                    }
                }
                return -1;
            }
            return i;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    @Override // com.google.ar.core.ArCoreApk
    public final ArCoreApk.Availability a(Context context) {
        if (!i()) {
            return ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE;
        }
        try {
            if (h(context)) {
                g();
                return e.c(context);
            }
            synchronized (this) {
                if ((this.f66051b == null || this.f66051b.isUnknown()) && !this.f66052c) {
                    this.f66052c = true;
                    e eVar = new e(this);
                    if (h(context)) {
                        eVar.a(ArCoreApk.Availability.SUPPORTED_INSTALLED);
                    } else if (k(context) != -1) {
                        eVar.a(ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD);
                    } else if (j(context)) {
                        eVar.a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
                    } else {
                        e(context).e(context, eVar);
                    }
                }
                if (this.f66051b != null) {
                    return this.f66051b;
                } else if (this.f66052c) {
                    return ArCoreApk.Availability.UNKNOWN_CHECKING;
                } else {
                    Log.e("ARCore-ArCoreApk", "request not running but result is null?");
                    return ArCoreApk.Availability.UNKNOWN_ERROR;
                }
            }
        } catch (FatalException e2) {
            Log.e("ARCore-ArCoreApk", "Error while checking app details and ARCore status", e2);
            return ArCoreApk.Availability.UNKNOWN_ERROR;
        }
    }

    public final synchronized l e(Context context) {
        if (this.f66053d == null) {
            l lVar = new l((byte) 0);
            lVar.d(context.getApplicationContext());
            this.f66053d = lVar;
        }
        return this.f66053d;
    }

    public final synchronized void g() {
        Exception exc = this.f66050a;
        if (this.f66053d != null) {
            this.f66053d.a();
            this.f66053d = null;
        }
    }

    public final boolean h(Context context) {
        l(context);
        return k(context) == 0 || k(context) >= this.f66056g;
    }

    public final boolean j(Context context) {
        l(context);
        return this.f66055f;
    }

    public final synchronized void l(Context context) {
        if (this.f66054e) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            Bundle bundle = packageManager.getApplicationInfo(packageName, 128).metaData;
            if (bundle.containsKey(XRSessionAnchor.apkinfo)) {
                this.f66055f = bundle.getString(XRSessionAnchor.apkinfo).equals("required");
                if (bundle.containsKey("com.google.ar.core.min_apk_version")) {
                    this.f66056g = bundle.getInt("com.google.ar.core.min_apk_version");
                    try {
                        ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 1).activities;
                        String canonicalName = InstallActivity.class.getCanonicalName();
                        int length = activityInfoArr.length;
                        boolean z = false;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            } else if (canonicalName.equals(activityInfoArr[i].name)) {
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (!z) {
                            String valueOf = String.valueOf(canonicalName);
                            throw new FatalException(valueOf.length() != 0 ? "Application manifest must contain activity ".concat(valueOf) : new String("Application manifest must contain activity "));
                        } else {
                            this.f66054e = true;
                            return;
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                        throw new FatalException("Could not load application package info", e2);
                    }
                }
                throw new FatalException("Application manifest must contain meta-data com.google.ar.core.min_apk_version");
            }
            throw new FatalException("Application manifest must contain meta-data com.google.ar.core");
        } catch (PackageManager.NameNotFoundException e3) {
            throw new FatalException("Could not load application package metadata", e3);
        }
    }
}
