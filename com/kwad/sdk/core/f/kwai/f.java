package com.kwad.sdk.core.f.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import com.kwad.sdk.core.f.a.d;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public class f {
    public Context a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    public ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.kwai.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "onServiceConnected");
            try {
                f.this.b.put(iBinder);
            } catch (InterruptedException e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public f(Context context) {
        this.a = context;
    }

    private String b() {
        try {
            Signature[] signatureArr = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return null;
            }
            byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            return null;
        }
    }

    public String a() {
        Context context;
        ServiceConnection serviceConnection;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            boolean bindService = this.a.bindService(intent, this.c, 1);
            com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "getOAID isBin=" + bindService);
            if (bindService) {
                try {
                    str = new d.a(this.b.take()).a(this.a.getPackageName(), b(), "OUID");
                    com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "getOAID oaid" + str);
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
            com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "getOAID service not found");
            com.kwad.sdk.core.d.a.b(e2);
        }
        return str;
    }
}
