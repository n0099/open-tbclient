package com.kwad.sdk.core.f.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.a.e;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes7.dex */
public final class g {
    public final LinkedBlockingQueue<IBinder> Zp = new LinkedBlockingQueue<>(1);
    public ServiceConnection Zq = new ServiceConnection() { // from class: com.kwad.sdk.core.f.kwai.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                g.this.Zp.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    public Context mContext;

    public g(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (this.mContext.bindService(intent, this.Zq, 1)) {
                try {
                    str = new e.a(this.Zp.take()).getID();
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
