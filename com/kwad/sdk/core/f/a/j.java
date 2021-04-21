package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.f;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public Context f34003a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f34004b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f34005c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.j.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.a.b("ZTEDeviceIDHelper", "onServiceConnected");
                j.this.f34004b.put(iBinder);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public j(Context context) {
        this.f34003a = context;
    }

    public String a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent.setAction("com.bun.msa.action.bindto.service");
            intent.putExtra("com.bun.msa.param.pkgname", this.f34003a.getPackageName());
            boolean bindService = this.f34003a.bindService(intent, this.f34005c, 1);
            com.kwad.sdk.core.d.a.b("ZTEDeviceIDHelper", "getOAID isBind=" + bindService);
            if (bindService) {
                try {
                    str = new f.a(this.f34004b.take()).a();
                    com.kwad.sdk.core.d.a.b("ZTEDeviceIDHelper", "getOAID oaid:" + str);
                    context = this.f34003a;
                    serviceConnection = this.f34005c;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    context = this.f34003a;
                    serviceConnection = this.f34005c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.b("ZTEDeviceIDHelper", "getOAID hw service not found");
            com.kwad.sdk.core.d.a.a(e3);
        }
        return str;
    }
}
