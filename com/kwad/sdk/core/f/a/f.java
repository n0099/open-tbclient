package com.kwad.sdk.core.f.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import com.kwad.sdk.core.f.b.d;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public Context f33993a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f33994b = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f33995c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.kwad.sdk.core.d.a.b("OppoDeviceIDHelper", "onServiceConnected");
            try {
                f.this.f33994b.put(iBinder);
            } catch (InterruptedException e2) {
                com.kwad.sdk.core.d.a.a(e2);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public f(Context context) {
        this.f33993a = context;
    }

    private String b() {
        try {
            Signature[] signatureArr = this.f33993a.getPackageManager().getPackageInfo(this.f33993a.getPackageName(), 64).signatures;
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
            boolean bindService = this.f33993a.bindService(intent, this.f33995c, 1);
            com.kwad.sdk.core.d.a.b("OppoDeviceIDHelper", "getOAID isBin=" + bindService);
            if (bindService) {
                try {
                    str = new d.a(this.f33994b.take()).a(this.f33993a.getPackageName(), b(), "OUID");
                    com.kwad.sdk.core.d.a.b("OppoDeviceIDHelper", "getOAID oaid" + str);
                    context = this.f33993a;
                    serviceConnection = this.f33995c;
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.a.a(e2);
                    context = this.f33993a;
                    serviceConnection = this.f33995c;
                }
                context.unbindService(serviceConnection);
            }
        } catch (Exception e3) {
            com.kwad.sdk.core.d.a.b("OppoDeviceIDHelper", "getOAID service not found");
            com.kwad.sdk.core.d.a.b(e3);
        }
        return str;
    }
}
