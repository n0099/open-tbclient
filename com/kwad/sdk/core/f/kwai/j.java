package com.kwad.sdk.core.f.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.a.f;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes3.dex */
public class j {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f58035b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f58036c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.kwai.j.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "onServiceConnected");
                j.this.f58035b.put(iBinder);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
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
            boolean bindService = this.a.bindService(intent, this.f58036c, 1);
            com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "getOAID isBind=" + bindService);
            if (bindService) {
                try {
                    str = new f.a(this.f58035b.take()).a();
                    com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "getOAID oaid:" + str);
                    context = this.a;
                    serviceConnection = this.f58036c;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    context = this.a;
                    serviceConnection = this.f58036c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.c("ZTEDeviceIDHelper", "getOAID hw service not found");
            com.kwad.sdk.core.d.a.a(e3);
        }
        return str;
    }
}
