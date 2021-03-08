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
import com.baidu.android.imsdk.internal.IMConnection;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.g;
import com.fun.openid.sdk.h;
/* loaded from: classes3.dex */
public class m implements h {
    @Override // com.fun.openid.sdk.h
    public void a(Context context, h.a aVar) {
        boolean z;
        String str;
        e eVar = e.b.pRd;
        Context applicationContext = context.getApplicationContext();
        eVar.getClass();
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            z = Build.VERSION.SDK_INT < 28 ? !(packageInfo == null || packageInfo.versionCode < 1) : !(packageInfo == null || packageInfo.getLongVersionCode() < 1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            z = false;
        }
        d.b = z;
        d.f5243a = true;
        if (!d.b) {
            if (b.isLogEnabled()) {
                Log.e("FunOpenIDSdk", "===========当前设备不支持获取OAID");
            }
            ((g.a) aVar).a(false, null);
        } else if (d.f5243a) {
            e eVar2 = e.b.pRd;
            Context applicationContext2 = context.getApplicationContext();
            synchronized (eVar2) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    if (eVar2.pRc == null) {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                        if (applicationContext2.bindService(intent, eVar2.poA, 1)) {
                            synchronized (eVar2.d) {
                                try {
                                    eVar2.d.wait(IMConnection.RETRY_DELAY_TIMES);
                                } catch (InterruptedException e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                        if (eVar2.pRc == null) {
                            str = "";
                        }
                    }
                    try {
                        str = eVar2.a(applicationContext2, "OUID");
                    } catch (RemoteException e3) {
                        e3.printStackTrace();
                        str = "";
                    }
                } else {
                    throw new IllegalStateException("Cannot run on MainThread");
                }
            }
            ((g.a) aVar).a(true, str);
        } else {
            throw new RuntimeException("SDK Need Init First!");
        }
    }
}
