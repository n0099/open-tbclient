package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.a;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f9128a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f9129b = new LinkedBlockingQueue<>(1);
    private ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.f9129b.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public a(Context context) {
        this.f9128a = context;
    }

    public String a() {
        String str;
        Throwable th;
        String str2;
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            try {
                if (this.f9128a.bindService(intent, this.c, 1)) {
                    try {
                        str = new a.C1095a(this.f9129b.take()).a();
                        try {
                            try {
                                com.kwad.sdk.core.d.a.b("ASUSDeviceIDHelper", "getOAID oaid:" + str);
                                this.f9128a.unbindService(this.c);
                            } catch (Exception e) {
                                e = e;
                                com.kwad.sdk.core.d.a.a(e);
                                this.f9128a.unbindService(this.c);
                                return str;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = str;
                            try {
                                this.f9128a.unbindService(this.c);
                                throw th;
                            } catch (Exception e2) {
                                e = e2;
                                str = str2;
                                com.kwad.sdk.core.d.a.b("ASUSDeviceIDHelper", "getOAID asus service not found;");
                                com.kwad.sdk.core.d.a.a(e);
                                return str;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str = "";
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = "";
                        this.f9128a.unbindService(this.c);
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
