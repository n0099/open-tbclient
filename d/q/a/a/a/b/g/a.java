package d.q.a.a.a.b.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f71357d;

    /* renamed from: e  reason: collision with root package name */
    public Context f71358e;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.f.a f71354a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f71355b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f71356c = null;

    /* renamed from: f  reason: collision with root package name */
    public CountDownLatch f71359f = new CountDownLatch(1);

    /* renamed from: g  reason: collision with root package name */
    public ServiceConnection f71360g = new b(this);

    /* renamed from: h  reason: collision with root package name */
    public boolean f71361h = false;

    public static boolean g(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            return Build.VERSION.SDK_INT >= 28 ? packageInfo != null && packageInfo.getLongVersionCode() >= 1 : packageInfo != null && packageInfo.versionCode > 0;
        } catch (PackageManager.NameNotFoundException e2) {
            d.q.a.a.c.b.b.c(e2);
            return false;
        }
    }

    public final String a(Context context, String str) {
        try {
            if (this.f71361h) {
                if (TextUtils.isEmpty(this.f71355b)) {
                    this.f71355b = context.getPackageName();
                }
                if (TextUtils.isEmpty(this.f71356c)) {
                    String str2 = null;
                    Signature[] signatureArr = context.getPackageManager().getPackageInfo(this.f71355b, 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        byte[] byteArray = signatureArr[0].toByteArray();
                        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                        if (messageDigest != null) {
                            byte[] digest = messageDigest.digest(byteArray);
                            StringBuilder sb = new StringBuilder();
                            for (byte b2 : digest) {
                                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                            }
                            str2 = sb.toString();
                        }
                    }
                    this.f71356c = str2;
                }
                if (!TextUtils.isEmpty(this.f71356c) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f71355b)) {
                    String a2 = this.f71354a.a(this.f71355b, this.f71356c, str);
                    return TextUtils.isEmpty(a2) ? "" : a2;
                }
                return "";
            }
            return "";
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return "";
        }
    }

    public final void c(Context context) {
        ServiceConnection serviceConnection = this.f71360g;
        if (serviceConnection == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.f71357d = bVar;
            this.f71358e = context;
            boolean g2 = g(context);
            this.f71361h = g2;
            if (!g2) {
                e(false);
                return;
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (!context.bindService(intent, this.f71360g, 1)) {
                e(false);
                return;
            }
            this.f71359f.await(3000L, TimeUnit.MILLISECONDS);
            if (this.f71354a != null) {
                e(true);
            } else {
                e(false);
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            e(false);
        }
    }

    public final void e(boolean z) {
        try {
            if (z) {
                this.f71357d.a(this.f71354a);
            } else {
                this.f71357d.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final boolean f() {
        return this.f71361h;
    }
}
