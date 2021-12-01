package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.os.RemoteException;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.openid.sdk.c;
import com.fun.openid.sdk.f;
/* loaded from: classes2.dex */
public class k implements f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        if (r1.versionCode >= 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009a, code lost:
        if (r0.a == null) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    @Override // com.fun.openid.sdk.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Context context, f.a aVar) {
        boolean z;
        String a;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048576, this, context, aVar) != null) {
            return;
        }
        c cVar = c.b.a;
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
                b.f55755b = z;
                b.a = true;
                if (!b.f55755b) {
                    FunOpenIDSdk.isLogEnabled();
                    aVar.a(false, null);
                    return;
                } else if (b.a) {
                    c cVar2 = c.b.a;
                    Context applicationContext2 = context.getApplicationContext();
                    synchronized (cVar2) {
                        if (Looper.myLooper() != Looper.getMainLooper()) {
                            if (cVar2.a == null) {
                                Intent intent = new Intent();
                                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                                if (applicationContext2.bindService(intent, cVar2.f55759e, 1)) {
                                    synchronized (cVar2.f55758d) {
                                        try {
                                            cVar2.f55758d.wait(3000L);
                                        } catch (InterruptedException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                }
                            }
                            try {
                                a = cVar2.a(applicationContext2, "OUID");
                            } catch (RemoteException e4) {
                                e4.printStackTrace();
                                a = "";
                                aVar.a(true, a);
                                return;
                            }
                        } else {
                            throw new IllegalStateException("Cannot run on MainThread");
                        }
                    }
                    aVar.a(true, a);
                    return;
                } else {
                    throw new RuntimeException("SDK Need Init First!");
                }
            }
            z = false;
            b.f55755b = z;
            b.a = true;
            if (!b.f55755b) {
            }
        } else {
            if (packageInfo != null) {
            }
            z = false;
            b.f55755b = z;
            b.a = true;
            if (!b.f55755b) {
            }
        }
    }
}
