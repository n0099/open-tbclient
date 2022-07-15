package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.f;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public final class j {
    public Context a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    public ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.j.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                j.this.b.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public j(Context context) {
        this.a = context;
    }

    public final String a() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
            boolean bindService = this.a.bindService(intent, this.c, 1);
            new StringBuilder("getOAID isBind=").append(bindService);
            if (bindService) {
                try {
                    str = new f.a(this.b.take()).a();
                    new StringBuilder("getOAID oaid:").append(str);
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
