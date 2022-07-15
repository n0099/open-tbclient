package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.a;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public final class a {
    public Context a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    public ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.a.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.b.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public a(Context context) {
        this.a = context;
    }

    public final String a() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (this.a.bindService(intent, this.c, 1)) {
                try {
                    str = new a.C0541a(this.b.take()).a();
                    new StringBuilder("getOAID oaid:").append(str);
                    context = this.a;
                } catch (Exception unused) {
                    context = this.a;
                } catch (Throwable th) {
                    this.a.unbindService(this.c);
                    throw th;
                }
                context.unbindService(this.c);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
