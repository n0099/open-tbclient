package com.kwad.sdk.core.e.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import com.kwad.sdk.core.e.a.d;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes5.dex */
public final class f {
    public Context a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);
    public ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.e.kwai.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                f.this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public f(Context context) {
        this.a = context;
    }

    private String b() {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return null;
            }
            byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public final String a() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            boolean bindService = this.a.bindService(intent, this.c, 1);
            new StringBuilder("getOAID isBin=").append(bindService);
            if (bindService) {
                try {
                    str = new d.a(this.b.take()).a(this.a.getPackageName(), b(), "OUID");
                    new StringBuilder("getOAID oaid").append(str);
                    context = this.a;
                } catch (Exception unused) {
                    context = this.a;
                }
                context.unbindService(this.c);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
