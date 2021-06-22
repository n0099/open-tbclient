package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.a;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f34318a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f34319b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f34320c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.f34319b.put(iBinder);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public a(Context context) {
        this.f34318a = context;
    }

    public String a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (this.f34318a.bindService(intent, this.f34320c, 1)) {
                try {
                    str = new a.C0385a(this.f34319b.take()).a();
                    com.kwad.sdk.core.d.a.b("ASUSDeviceIDHelper", "getOAID oaid:" + str);
                    context = this.f34318a;
                    serviceConnection = this.f34320c;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    context = this.f34318a;
                    serviceConnection = this.f34320c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.b("ASUSDeviceIDHelper", "getOAID asus service not found;");
            com.kwad.sdk.core.d.a.a(e3);
        }
        return str;
    }
}
