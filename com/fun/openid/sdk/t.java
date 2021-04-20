package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.fun.openid.sdk.e;
import com.fun.openid.sdk.f;
import com.fun.openid.sdk.g;
import com.fun.openid.sdk.s;
import com.fun.openid.sdk.u;
/* loaded from: classes6.dex */
public class t implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f30540a;

    public t(u uVar) {
        this.f30540a = uVar;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:8|9|(2:10|11)|(5:13|(2:15|(5:20|21|(2:23|24)|31|24)(2:17|18))(3:34|(1:36)|37)|25|26|27)|39|(0)(0)|25|26|27) */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035 A[Catch: all -> 0x0081, TRY_ENTER, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:12:0x001e, B:14:0x0026, B:16:0x0029, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:26:0x0040, B:31:0x004a, B:38:0x006c, B:39:0x0073, B:32:0x0050, B:33:0x0057, B:29:0x0046, B:34:0x0058, B:36:0x005e, B:37:0x0065, B:40:0x007a, B:6:0x000a, B:8:0x0012, B:10:0x0016, B:11:0x0019), top: B:50:0x0001, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058 A[Catch: all -> 0x0081, TryCatch #1 {, blocks: (B:3:0x0001, B:12:0x001e, B:14:0x0026, B:16:0x0029, B:18:0x002d, B:22:0x0035, B:24:0x003c, B:26:0x0040, B:31:0x004a, B:38:0x006c, B:39:0x0073, B:32:0x0050, B:33:0x0057, B:29:0x0046, B:34:0x0058, B:36:0x005e, B:37:0x0065, B:40:0x007a, B:6:0x000a, B:8:0x0012, B:10:0x0016, B:11:0x0019), top: B:50:0x0001, inners: #3 }] */
    @Override // android.content.ServiceConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        s c0348a;
        boolean z;
        String str;
        s sVar;
        s sVar2;
        u uVar = this.f30540a;
        int i = s.a.f30538a;
        if (iBinder == null) {
            c0348a = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            c0348a = (queryLocalInterface == null || !(queryLocalInterface instanceof s)) ? new s.a.C0348a(iBinder) : (s) queryLocalInterface;
        }
        uVar.f30542b = c0348a;
        u uVar2 = this.f30540a;
        u.a aVar = uVar2.f30544d;
        if (aVar != null) {
            g.a aVar2 = (g.a) aVar;
            try {
                sVar2 = uVar2.f30542b;
            } catch (RemoteException unused) {
            }
            if (sVar2 != null) {
                z = sVar2.a();
                if (!z) {
                    f.a aVar3 = aVar2.f30518a;
                    if (uVar2.f30541a != null) {
                        try {
                            sVar = uVar2.f30542b;
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                        if (sVar != null) {
                            str = sVar.b();
                            ((e.a) aVar3).a(true, str);
                        }
                        str = null;
                        ((e.a) aVar3).a(true, str);
                    } else {
                        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
                    }
                } else {
                    if (FunOpenIDSdk.isLogEnabled()) {
                        Log.e(FunOpenIDSdk.TAG, "当前设备不支持获取OAID");
                    }
                    ((e.a) aVar2.f30518a).a(false, null);
                }
                uVar2.f30541a.unbindService(uVar2.f30543c);
                uVar2.f30542b = null;
                g.this.f30517a = false;
            }
            z = false;
            if (!z) {
            }
            uVar2.f30541a.unbindService(uVar2.f30543c);
            uVar2.f30542b = null;
            g.this.f30517a = false;
        }
        this.f30540a.getClass();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f30540a.f30542b = null;
    }
}
