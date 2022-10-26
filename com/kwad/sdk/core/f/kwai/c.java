package com.kwad.sdk.core.f.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.a.c;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes7.dex */
public final class c {
    public Context mContext;
    public final LinkedBlockingQueue Zs = new LinkedBlockingQueue(1);
    public ServiceConnection Zq = new ServiceConnection() { // from class: com.kwad.sdk.core.f.kwai.c.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                c.this.Zs.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public c(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.mContext.bindService(intent, this.Zq, 1)) {
                try {
                    str = new c.a((IBinder) this.Zs.take()).getOaid();
                    new StringBuilder("getOAID oaid:").append(str);
                    context = this.mContext;
                } catch (Exception unused) {
                    context = this.mContext;
                }
                context.unbindService(this.Zq);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
