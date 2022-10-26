package com.kwad.sdk.core.f.kwai;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.IBinder;
import com.kwad.sdk.core.f.a.d;
import java.security.MessageDigest;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes7.dex */
public final class f {
    public Context mContext;
    public final LinkedBlockingQueue Zs = new LinkedBlockingQueue(1);
    public ServiceConnection Zq = new ServiceConnection() { // from class: com.kwad.sdk.core.f.kwai.f.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                f.this.Zs.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public f(Context context) {
        this.mContext = context;
    }

    private String uj() {
        Signature[] signatureArr;
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 64);
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

    public final String getOAID() {
        Context context;
        String str = "";
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            boolean bindService = this.mContext.bindService(intent, this.Zq, 1);
            new StringBuilder("getOAID isBin=").append(bindService);
            if (bindService) {
                try {
                    str = new d.a((IBinder) this.Zs.take()).getSerID(this.mContext.getPackageName(), uj(), "OUID");
                    new StringBuilder("getOAID oaid").append(str);
                    context = this.mContext;
                } catch (Exception unused) {
                    context = this.mContext;
                }
                context.unbindService(this.Zq);
            }
        } catch (Exception unused2) {
        }
        return str;
    }
}
