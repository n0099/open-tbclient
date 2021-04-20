package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.c;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f33892a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f33893b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f33894c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.c.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.a.b("LenovoDeviceIDHelper", "onServiceConnected");
                c.this.f33893b.put(iBinder);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public c(Context context) {
        this.f33892a = context;
    }

    public String a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.f33892a.bindService(intent, this.f33894c, 1)) {
                try {
                    str = new c.a(this.f33893b.take()).a();
                    com.kwad.sdk.core.d.a.b("LenovoDeviceIDHelper", "getOAID oaid:" + str);
                    context = this.f33892a;
                    serviceConnection = this.f33894c;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    context = this.f33892a;
                    serviceConnection = this.f33894c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.b("LenovoDeviceIDHelper", "getOAID Lenovo service not found");
            com.kwad.sdk.core.d.a.a(e3);
        }
        return str;
    }
}
