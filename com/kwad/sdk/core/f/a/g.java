package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.e;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes7.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public Context f34336a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f34337b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f34338c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                g.this.f34337b.put(iBinder);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public g(Context context) {
        this.f34336a = context;
    }

    public String a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (this.f34336a.bindService(intent, this.f34338c, 1)) {
                try {
                    str = new e.a(this.f34337b.take()).a();
                    com.kwad.sdk.core.d.a.b("SamsungDeviceIDHelper", "getOAID oaid:" + str);
                    context = this.f34336a;
                    serviceConnection = this.f34338c;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    context = this.f34336a;
                    serviceConnection = this.f34338c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.b("SamsungDeviceIDHelper", "getOAID service not found");
            com.kwad.sdk.core.d.a.a(e3);
        }
        return str;
    }
}
