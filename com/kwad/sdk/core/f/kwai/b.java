package com.kwad.sdk.core.f.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.a.b;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes3.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f58027b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f58028c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.kwai.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.a.c("HWDeviceIDHelper", "onServiceConnected");
                b.this.f58027b.put(iBinder);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public b(Context context) {
        this.a = context;
    }

    public String a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (this.a.bindService(intent, this.f58028c, 1)) {
                try {
                    b.a aVar = new b.a(this.f58027b.take());
                    str = aVar.a();
                    boolean b2 = aVar.b();
                    com.kwad.sdk.core.d.a.c("HWDeviceIDHelper", "getOAID oaid:" + str + "--boos:" + b2);
                    context = this.a;
                    serviceConnection = this.f58028c;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    context = this.a;
                    serviceConnection = this.f58028c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.c("HWDeviceIDHelper", "getOAID hw service not found");
            com.kwad.sdk.core.d.a.b(e3);
        }
        return str;
    }
}
