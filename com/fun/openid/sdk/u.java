package com.fun.openid.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.fun.openid.sdk.g;
import com.fun.openid.sdk.h;
import com.fun.openid.sdk.i;
import com.fun.openid.sdk.s;
import com.fun.openid.sdk.v;
/* loaded from: classes3.dex */
public class u implements ServiceConnection {
    public final /* synthetic */ v pRn;

    public u(v vVar) {
        this.pRn = vVar;
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        s c1075a;
        String str;
        s sVar;
        boolean z = false;
        synchronized (this) {
            v vVar = this.pRn;
            int i = s.a.f5251a;
            if (iBinder == null) {
                c1075a = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
                c1075a = (queryLocalInterface == null || !(queryLocalInterface instanceof s)) ? new s.a.C1075a(iBinder) : (s) queryLocalInterface;
            }
            vVar.pRo = c1075a;
            v vVar2 = this.pRn;
            v.a aVar = vVar2.pRp;
            if (aVar != null) {
                i.a aVar2 = (i.a) aVar;
                try {
                    s sVar2 = vVar2.pRo;
                    if (sVar2 != null) {
                        z = sVar2.a();
                    }
                } catch (RemoteException e) {
                }
                if (z) {
                    h.a aVar3 = aVar2.pRg;
                    if (vVar2.f5254a != null) {
                        try {
                            sVar = vVar2.pRo;
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                        if (sVar != null) {
                            str = sVar.b();
                            ((g.a) aVar3).a(true, str);
                        }
                        str = null;
                        ((g.a) aVar3).a(true, str);
                    } else {
                        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
                    }
                } else {
                    if (b.isLogEnabled()) {
                        Log.e("FunOpenIDSdk", "当前设备不支持获取OAID");
                    }
                    ((g.a) aVar2.pRg).a(false, null);
                }
                try {
                    vVar2.f5254a.unbindService(vVar2.c);
                } catch (IllegalArgumentException e3) {
                }
                vVar2.pRo = null;
                i.this.f5246a = false;
            }
            this.pRn.getClass();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.pRn.pRo = null;
    }
}
