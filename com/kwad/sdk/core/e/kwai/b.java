package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.b;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public final class b {
    public Context a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    public ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.b.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public b(Context context) {
        this.a = context;
    }

    public final String a() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (this.a.bindService(intent, this.c, 1)) {
                try {
                    b.a aVar = new b.a(this.b.take());
                    str = aVar.a();
                    boolean b = aVar.b();
                    StringBuilder sb = new StringBuilder("getOAID oaid:");
                    sb.append(str);
                    sb.append("--boos:");
                    sb.append(b);
                    context = this.a;
                } catch (Exception unused) {
                    context = this.a;
                } catch (Throwable th) {
                    this.a.unbindService(this.c);
                    throw th;
                }
                context.unbindService(this.c);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
