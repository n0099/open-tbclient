package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.e;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f9142a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f9143b = new LinkedBlockingQueue<>(1);
    private ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.g.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                g.this.f9143b.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public g(Context context) {
        this.f9142a = context;
    }

    public String a() {
        String str;
        Throwable th;
        String str2;
        try {
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            try {
                try {
                    if (this.f9142a.bindService(intent, this.c, 1)) {
                        try {
                            str = new e.a(this.f9143b.take()).a();
                            try {
                                com.kwad.sdk.core.d.a.b("SamsungDeviceIDHelper", "getOAID oaid:" + str);
                                this.f9142a.unbindService(this.c);
                            } catch (Exception e) {
                                e = e;
                                com.kwad.sdk.core.d.a.a(e);
                                this.f9142a.unbindService(this.c);
                                return str;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            str = "";
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = "";
                            try {
                                this.f9142a.unbindService(this.c);
                                throw th;
                            } catch (Exception e3) {
                                e = e3;
                                str = str2;
                                com.kwad.sdk.core.d.a.b("SamsungDeviceIDHelper", "getOAID service not found");
                                com.kwad.sdk.core.d.a.a(e);
                                return str;
                            }
                        }
                        return str;
                    }
                    return "";
                } catch (Exception e4) {
                    e = e4;
                    com.kwad.sdk.core.d.a.b("SamsungDeviceIDHelper", "getOAID service not found");
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
