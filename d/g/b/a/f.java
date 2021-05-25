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
    public static final f f66186h = new f();

    /* renamed from: a */
    public Exception f66187a;

    /* renamed from: b */
    public ArCoreApk.Availability f66188b;

    /* renamed from: c */
    public boolean f66189c;

    /* renamed from: d */
    public l f66190d;

    /* renamed from: e */
    public boolean f66191e;

    /* renamed from: f */
    public boolean f66192f;

    /* renamed from: g */
    public int f66193g;

    public static f d() {
        return f66186h;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static int k(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(XRSessionAnchor.apkinfo, 4);
            int i2 = packageInfo.versionCode;
            if (i2 == 0) {
                if (packageInfo.services != null) {
                    if (packageInfo.services.length == 0) {
                    }
                }
                return -1;
            }
            return i2;
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
                if ((this.f66188b == null || this.f66188b.isUnknown()) && !this.f66189c) {
                    this.f66189c = true;
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
                if (this.f66188b != null) {
                    return this.f66188b;
                } else if (this.f66189c) {
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
        if (this.f66190d == null) {
            l lVar = new l((byte) 0);
            lVar.d(context.getApplicationContext());
            this.f66190d = lVar;
        }
        return this.f66190d;
    }

    public final synchronized void g() {
        Exception exc = this.f66187a;
        if (this.f66190d != null) {
            this.f66190d.a();
            this.f66190d = null;
        }
    }

    public final boolean h(Context context) {
        l(context);
        return k(context) == 0 || k(context) >= this.f66193g;
    }

    public final boolean j(Context context) {
        l(context);
        return this.f66192f;
    }

    public final synchronized void l(Context context) {
        if (this.f66191e) {
            return;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            Bundle bundle = packageManager.getApplicationInfo(packageName, 128).metaData;
            if (bundle.containsKey(XRSessionAnchor.apkinfo)) {
                this.f66192f = bundle.getString(XRSessionAnchor.apkinfo).equals("required");
                if (bundle.containsKey("com.google.ar.core.min_apk_version")) {
                    this.f66193g = bundle.getInt("com.google.ar.core.min_apk_version");
                    try {
                        ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 1).activities;
                        String canonicalName = InstallActivity.class.getCanonicalName();
                        int length = activityInfoArr.length;
                        boolean z = false;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            } else if (canonicalName.equals(activityInfoArr[i2].name)) {
                                z = true;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (!z) {
                            String valueOf = String.valueOf(canonicalName);
                            throw new FatalException(valueOf.length() != 0 ? "Application manifest must contain activity ".concat(valueOf) : new String("Application manifest must contain activity "));
                        } else {
                            this.f66191e = true;
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
