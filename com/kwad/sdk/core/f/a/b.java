package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.b;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f9428a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f9429b = new LinkedBlockingQueue<>(1);
    private ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.b.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                com.kwad.sdk.core.d.a.b("HWDeviceIDHelper", "onServiceConnected");
                b.this.f9429b.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public b(Context context) {
        this.f9428a = context;
    }

    public String a() {
        String str;
        Throwable th;
        String str2;
        try {
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            try {
                if (this.f9428a.bindService(intent, this.c, 1)) {
                    try {
                        b.a aVar = new b.a(this.f9429b.take());
                        str = aVar.a();
                        try {
                            try {
                                com.kwad.sdk.core.d.a.b("HWDeviceIDHelper", "getOAID oaid:" + str + "--boos:" + aVar.b());
                                this.f9428a.unbindService(this.c);
                            } catch (Exception e) {
                                e = e;
                                com.kwad.sdk.core.d.a.a(e);
                                this.f9428a.unbindService(this.c);
                                return str;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = str;
                            try {
                                this.f9428a.unbindService(this.c);
                                throw th;
                            } catch (Exception e2) {
                                e = e2;
                                str = str2;
                                com.kwad.sdk.core.d.a.b("HWDeviceIDHelper", "getOAID hw service not found");
                                com.kwad.sdk.core.d.a.b(e);
                                return str;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str = "";
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = "";
                        this.f9428a.unbindService(this.c);
                        throw th;
                    }
                    return str;
                }
                return "";
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            str = "";
        }
    }
}
