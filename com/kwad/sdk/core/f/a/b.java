package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.b;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes10.dex */
public final class b {
    public Context mContext;
    public final LinkedBlockingQueue<IBinder> auV = new LinkedBlockingQueue<>(1);
    public ServiceConnection auT = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.auV.put(iBinder);
            } catch (Exception unused) {
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (this.mContext.bindService(intent, this.auT, 1)) {
                try {
                    b.a aVar = new b.a(this.auV.take());
                    str = aVar.Dj();
                    boolean Dk = aVar.Dk();
                    StringBuilder sb = new StringBuilder("getOAID oaid:");
                    sb.append(str);
                    sb.append("--boos:");
                    sb.append(Dk);
                    context = this.mContext;
                } catch (Exception unused) {
                    context = this.mContext;
                } catch (Throwable th) {
                    this.mContext.unbindService(this.auT);
                    throw th;
                }
                context.unbindService(this.auT);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
