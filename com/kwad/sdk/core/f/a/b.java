package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.b;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f34224a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f34225b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f34226c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.a.b("HWDeviceIDHelper", "onServiceConnected");
                b.this.f34225b.put(iBinder);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public b(Context context) {
        this.f34224a = context;
    }

    public String a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "";
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            if (this.f34224a.bindService(intent, this.f34226c, 1)) {
                try {
                    b.a aVar = new b.a(this.f34225b.take());
                    str = aVar.a();
                    boolean b2 = aVar.b();
                    com.kwad.sdk.core.d.a.b("HWDeviceIDHelper", "getOAID oaid:" + str + "--boos:" + b2);
                    context = this.f34224a;
                    serviceConnection = this.f34226c;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    context = this.f34224a;
                    serviceConnection = this.f34226c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.b("HWDeviceIDHelper", "getOAID hw service not found");
            com.kwad.sdk.core.d.a.b(e3);
        }
        return str;
    }
}
