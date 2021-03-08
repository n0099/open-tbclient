package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.c;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Context f6077a;
    private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    private ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.c.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.a.b("LenovoDeviceIDHelper", "onServiceConnected");
                c.this.b.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public c(Context context) {
        this.f6077a = context;
    }

    public String a() {
        String str;
        Throwable th;
        String str2;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            try {
                try {
                    if (this.f6077a.bindService(intent, this.c, 1)) {
                        try {
                            str = new c.a(this.b.take()).a();
                            try {
                                com.kwad.sdk.core.d.a.b("LenovoDeviceIDHelper", "getOAID oaid:" + str);
                                this.f6077a.unbindService(this.c);
                            } catch (Exception e) {
                                e = e;
                                com.kwad.sdk.core.d.a.a(e);
                                this.f6077a.unbindService(this.c);
                                return str;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = "";
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = "";
                            try {
                                this.f6077a.unbindService(this.c);
                                throw th;
                            } catch (Exception e3) {
                                e = e3;
                                str = str2;
                                com.kwad.sdk.core.d.a.b("LenovoDeviceIDHelper", "getOAID Lenovo service not found");
                                com.kwad.sdk.core.d.a.a(e);
                                return str;
                            }
                        }
                        return str;
                    }
                    return "";
                } catch (Exception e4) {
                    e = e4;
                    com.kwad.sdk.core.d.a.b("LenovoDeviceIDHelper", "getOAID Lenovo service not found");
                    com.kwad.sdk.core.d.a.a(e);
                    return str;
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = str;
            }
        } catch (Exception e5) {
            e = e5;
            str = "";
        }
    }
}
