package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.fun.openid.sdk.c;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.f;
/* loaded from: classes6.dex */
public class k implements f {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
        if (r1.versionCode >= 1) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a1, code lost:
        if (r0.f30799a == null) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051  */
    @Override // com.fun.openid.sdk.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, f.a aVar) {
        boolean z;
        String a2;
        PackageInfo packageInfo;
        c cVar = c.b.f30805a;
        Context applicationContext = context.getApplicationContext();
        cVar.getClass();
        try {
            packageInfo = applicationContext.getPackageManager().getPackageInfo("com.heytap.openid", 0);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            if (packageInfo != null && packageInfo.getLongVersionCode() >= 1) {
                z = true;
                b.f30798b = z;
                b.f30797a = true;
                if (!b.f30798b) {
                    if (FunOpenIDSdk.isLogEnabled()) {
                        Log.e(FunOpenIDSdk.TAG, "===========当前设备不支持获取OAID");
                    }
                    ((e.a) aVar).a(false, null);
                    return;
                } else if (b.f30797a) {
                    c cVar2 = c.b.f30805a;
                    Context applicationContext2 = context.getApplicationContext();
                    synchronized (cVar2) {
                        if (Looper.myLooper() != Looper.getMainLooper()) {
                            if (cVar2.f30799a == null) {
                                Intent intent = new Intent();
                                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                                if (applicationContext2.bindService(intent, cVar2.f30803e, 1)) {
                                    synchronized (cVar2.f30802d) {
                                        try {
                                            cVar2.f30802d.wait(3000L);
                                        } catch (InterruptedException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                }
                            }
                            try {
                                a2 = cVar2.a(applicationContext2, "OUID");
                            } catch (RemoteException e4) {
                                e4.printStackTrace();
                                a2 = "";
                                ((e.a) aVar).a(true, a2);
                                return;
                            }
                        } else {
                            throw new IllegalStateException("Cannot run on MainThread");
                        }
                    }
                    ((e.a) aVar).a(true, a2);
                    return;
                } else {
                    throw new RuntimeException("SDK Need Init First!");
                }
            }
            z = false;
            b.f30798b = z;
            b.f30797a = true;
            if (!b.f30798b) {
            }
        } else {
            if (packageInfo != null) {
            }
            z = false;
            b.f30798b = z;
            b.f30797a = true;
            if (!b.f30798b) {
            }
        }
    }
}
