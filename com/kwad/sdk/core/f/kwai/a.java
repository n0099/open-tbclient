package com.kwad.sdk.core.f.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.kwad.sdk.core.f.a.a;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes10.dex */
public final class a {
    public final LinkedBlockingQueue<IBinder> Zp = new LinkedBlockingQueue<>(1);
    public ServiceConnection Zq = new ServiceConnection() { // from class: com.kwad.sdk.core.f.kwai.a.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.Zp.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };
    public Context mContext;

    public a(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setAction("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            if (this.mContext.bindService(intent, this.Zq, 1)) {
                try {
                    str = new a.C0666a(this.Zp.take()).getID();
                    new StringBuilder("getOAID oaid:").append(str);
                    context = this.mContext;
                } catch (Exception unused) {
                    context = this.mContext;
                } catch (Throwable th) {
                    this.mContext.unbindService(this.Zq);
                    throw th;
                }
                context.unbindService(this.Zq);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
