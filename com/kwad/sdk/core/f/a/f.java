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
/* loaded from: classes4.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private Context f9137a;

    /* renamed from: b  reason: collision with root package name */
    private final LinkedBlockingQueue<IBinder> f9138b = new LinkedBlockingQueue<>(1);
    private ServiceConnection c = new ServiceConnection() { // from class: com.kwad.sdk.core.f.a.f.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.kwad.sdk.core.d.a.b("OppoDeviceIDHelper", "onServiceConnected");
            try {
                f.this.f9138b.put(iBinder);
            } catch (InterruptedException e) {
                com.kwad.sdk.core.d.a.a(e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public f(Context context) {
        this.f9137a = context;
    }

    private String b() {
        try {
            Signature[] signatureArr = this.f9137a.getPackageManager().getPackageInfo(this.f9137a.getPackageName(), 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return null;
            }
            byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
            return null;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:31:0x003f */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public String a() {
        String str;
        Throwable th;
        String str2;
        String str3;
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            ?? bindService = this.f9137a.bindService(intent, this.c, 1);
            com.kwad.sdk.core.d.a.b("OppoDeviceIDHelper", "getOAID isBin=" + ((boolean) bindService));
            try {
                if (bindService != 0) {
                    try {
                        String a2 = new d.a(this.f9138b.take()).a(this.f9137a.getPackageName(), b(), "OUID");
                        try {
                            try {
                                com.kwad.sdk.core.d.a.b("OppoDeviceIDHelper", "getOAID oaid" + a2);
                                this.f9137a.unbindService(this.c);
                                bindService = a2;
                            } catch (Exception e) {
                                e = e;
                                str3 = a2;
                                com.kwad.sdk.core.d.a.a(e);
                                this.f9137a.unbindService(this.c);
                                bindService = str3;
                                return bindService;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            str2 = str3;
                            try {
                                this.f9137a.unbindService(this.c);
                                throw th;
                            } catch (Exception e2) {
                                e = e2;
                                str = str2;
                                com.kwad.sdk.core.d.a.b("OppoDeviceIDHelper", "getOAID service not found");
                                com.kwad.sdk.core.d.a.b(e);
                                return str;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str3 = "";
                    } catch (Throwable th3) {
                        th = th3;
                        str2 = "";
                        this.f9137a.unbindService(this.c);
                        throw th;
                    }
                    return bindService;
                }
                return "";
            } catch (Exception e4) {
                e = e4;
                str = bindService;
            }
        } catch (Exception e5) {
            e = e5;
            str = "";
        }
    }
}
