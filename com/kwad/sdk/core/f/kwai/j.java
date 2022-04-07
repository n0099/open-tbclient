package com.kwad.sdk.core.f.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.a.f;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public class j {
    public Context a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    public ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.kwai.j.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "onServiceConnected");
                j.this.b.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public j(Context context) {
        this.a = context;
    }

    public String a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", this.a.getPackageName());
            boolean bindService = this.a.bindService(intent, this.c, 1);
            com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "getOAID isBind=" + bindService);
            if (bindService) {
                try {
                    str = new f.a(this.b.take()).a();
                    com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "getOAID oaid:" + str);
                    context = this.a;
                    serviceConnection = this.c;
                } catch (Exception e) {
                    com.kwad.sdk.core.d.a.a(e);
                    context = this.a;
                    serviceConnection = this.c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "getOAID hw service not found");
            com.kwad.sdk.core.d.a.a(e2);
        }
        return str;
    }
}
