package com.google.ar.core;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.google.ar.core.ArCoreApk;
import com.google.ar.core.exceptions.FatalException;
/* loaded from: classes11.dex */
public final class o extends ArCoreApk {
    private static final o obT = new o();

    /* renamed from: a */
    Exception f4043a;
    private boolean c;
    private int d;
    private boolean g;
    private boolean i;
    private boolean j;
    private int k;
    private ArCoreApk.Availability obU;
    private w obV;

    o() {
    }

    public static o eeL() {
        return obT;
    }

    @Override // com.google.ar.core.ArCoreApk
    public final ArCoreApk.Availability gK(Context context) {
        if (!c()) {
            return ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE;
        }
        try {
            if (b(context)) {
                b();
                return n.gL(context);
            }
            synchronized (this) {
                if ((this.obU == null || this.obU.isUnknown()) && !this.g) {
                    this.g = true;
                    n nVar = new n(this);
                    if (b(context)) {
                        nVar.a(ArCoreApk.Availability.SUPPORTED_INSTALLED);
                    } else if (d(context) != -1) {
                        nVar.a(ArCoreApk.Availability.SUPPORTED_APK_TOO_OLD);
                    } else if (c(context)) {
                        nVar.a(ArCoreApk.Availability.SUPPORTED_NOT_INSTALLED);
                    } else {
                        gN(context).a(context, nVar);
                    }
                }
                if (this.obU != null) {
                    return this.obU;
                } else if (this.g) {
                    return ArCoreApk.Availability.UNKNOWN_CHECKING;
                } else {
                    Log.e("ARCore-ArCoreApk", "request not running but result is null?");
                    return ArCoreApk.Availability.UNKNOWN_ERROR;
                }
            }
        } catch (FatalException e) {
            Log.e("ARCore-ArCoreApk", "Error while checking app details and ARCore status", e);
            return ArCoreApk.Availability.UNKNOWN_ERROR;
        }
    }

    public final synchronized w gN(Context context) {
        if (this.obV == null) {
            w wVar = new w((byte) 0);
            wVar.a(context.getApplicationContext());
            this.obV = wVar;
        }
        return this.obV;
    }

    public final synchronized void b() {
        if (this.f4043a == null) {
            this.d = 0;
        }
        this.c = false;
        if (this.obV != null) {
            this.obV.a();
            this.obV = null;
        }
    }

    public final boolean b(Context context) {
        e(context);
        return d(context) == 0 || d(context) >= this.k;
    }

    private final boolean c(Context context) {
        e(context);
        return this.j;
    }

    private static boolean c() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private static int d(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.ar.core", 4);
            int i = packageInfo.versionCode;
            if (i == 0) {
                if (packageInfo.services == null) {
                    return -1;
                }
                if (packageInfo.services.length == 0) {
                    return -1;
                }
            }
            return i;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }

    private final synchronized void e(Context context) {
        boolean z = true;
        synchronized (this) {
            if (!this.i) {
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                try {
                    Bundle bundle = packageManager.getApplicationInfo(packageName, 128).metaData;
                    if (bundle.containsKey("com.google.ar.core")) {
                        this.j = bundle.getString("com.google.ar.core").equals("required");
                        if (bundle.containsKey("com.google.ar.core.min_apk_version")) {
                            this.k = bundle.getInt("com.google.ar.core.min_apk_version");
                            try {
                                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 1).activities;
                                String canonicalName = InstallActivity.class.getCanonicalName();
                                int length = activityInfoArr.length;
                                int i = 0;
                                while (true) {
                                    if (i >= length) {
                                        z = false;
                                        break;
                                    } else if (canonicalName.equals(activityInfoArr[i].name)) {
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                                if (!z) {
                                    String valueOf = String.valueOf(canonicalName);
                                    throw new FatalException(valueOf.length() != 0 ? "Application manifest must contain activity ".concat(valueOf) : new String("Application manifest must contain activity "));
                                }
                                this.i = true;
                            } catch (PackageManager.NameNotFoundException e) {
                                throw new FatalException("Could not load application package info", e);
                            }
                        } else {
                            throw new FatalException("Application manifest must contain meta-data com.google.ar.core.min_apk_version");
                        }
                    } else {
                        throw new FatalException("Application manifest must contain meta-data com.google.ar.core");
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new FatalException("Could not load application package metadata", e2);
                }
            }
        }
    }
}
