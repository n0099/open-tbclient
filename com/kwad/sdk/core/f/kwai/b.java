package com.kwad.sdk.core.f.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.a.b;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes8.dex */
public final class b {
    public Context mContext;
    public final LinkedBlockingQueue<IBinder> Zs = new LinkedBlockingQueue<>(1);
    public ServiceConnection Zq = new ServiceConnection() { // from class: com.kwad.sdk.core.f.kwai.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.Zs.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
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
            if (this.mContext.bindService(intent, this.Zq, 1)) {
                try {
                    b.a aVar = new b.a(this.Zs.take());
                    str = aVar.uk();
                    boolean ul = aVar.ul();
                    StringBuilder sb = new StringBuilder("getOAID oaid:");
                    sb.append(str);
                    sb.append("--boos:");
                    sb.append(ul);
                    context = this.mContext;
                } catch (Exception unused) {
                    context = this.mContext;
                } catch (Throwable th) {
                    this.mContext.unbindService(this.Zq);
                    throw th;
                }
                context.unbindService(this.Zq);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
