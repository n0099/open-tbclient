package com.kwad.sdk.core.f.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.a.a;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public class a {
    public Context a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    public ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.kwai.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.b.put(iBinder);
            } catch (Exception e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public a(Context context) {
        this.a = context;
    }

    public String a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (this.a.bindService(intent, this.c, 1)) {
                try {
                    str = new a.C0298a(this.b.take()).a();
                    com.kwad.sdk.core.d.a.c("ASUSDeviceIDHelper", "getOAID oaid:" + str);
                    context = this.a;
                    serviceConnection = this.c;
                } catch (Exception e) {
                    com.kwad.sdk.core.d.a.a(e);
                    context = this.a;
                    serviceConnection = this.c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.c("ASUSDeviceIDHelper", "getOAID asus service not found;");
            com.kwad.sdk.core.d.a.a(e2);
        }
        return str;
    }
}
