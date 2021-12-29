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
/* loaded from: classes3.dex */
public class f {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f58031b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f58032c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.kwai.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "onServiceConnected");
            try {
                f.this.f58031b.put(iBinder);
            } catch (InterruptedException e2) {
                com.kwad.sdk.core.d.a.a(e2);
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
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
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
            boolean bindService = this.a.bindService(intent, this.f58032c, 1);
            com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "getOAID isBin=" + bindService);
            if (bindService) {
                try {
                    str = new d.a(this.f58031b.take()).a(this.a.getPackageName(), b(), "OUID");
                    com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "getOAID oaid" + str);
                    context = this.a;
                    serviceConnection = this.f58032c;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    context = this.a;
                    serviceConnection = this.f58032c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.c("OppoDeviceIDHelper", "getOAID service not found");
            com.kwad.sdk.core.d.a.b(e3);
        }
        return str;
    }
}
