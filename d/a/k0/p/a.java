package d.a.k0.p;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.baidu.sso.o.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public Context f44313b;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.n.b f44316e;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.sso.o.a f44312a = null;

    /* renamed from: c  reason: collision with root package name */
    public String f44314c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f44315d = null;

    /* renamed from: f  reason: collision with root package name */
    public ServiceConnection f44317f = new c(this);

    public a(Context context) {
        this.f44313b = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051 A[Catch: NoSuchAlgorithmException -> 0x006b, all -> 0x007a, LOOP:0: B:22:0x004f->B:23:0x0051, LOOP_END, TryCatch #1 {NoSuchAlgorithmException -> 0x006b, blocks: (B:21:0x0041, B:23:0x0051, B:24:0x0067), top: B:39:0x0041 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str) {
        Signature[] signatureArr;
        PackageInfo packageInfo;
        if (this.f44312a != null) {
            String str2 = null;
            try {
                if (TextUtils.isEmpty(this.f44314c)) {
                    this.f44314c = this.f44313b.getPackageName();
                }
                if (TextUtils.isEmpty(this.f44315d)) {
                    try {
                        packageInfo = this.f44313b.getPackageManager().getPackageInfo(this.f44314c, 64);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                    if (packageInfo != null) {
                        signatureArr = packageInfo.signatures;
                        if (signatureArr != null && signatureArr.length > 0) {
                            try {
                                byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                                StringBuilder sb = new StringBuilder();
                                for (byte b2 : digest) {
                                    sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                                }
                                str2 = sb.toString();
                            } catch (NoSuchAlgorithmException unused2) {
                            }
                        }
                        this.f44315d = str2;
                    }
                    signatureArr = null;
                    if (signatureArr != null) {
                        byte[] digest2 = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                        StringBuilder sb2 = new StringBuilder();
                        while (r3 < r4) {
                        }
                        str2 = sb2.toString();
                    }
                    this.f44315d = str2;
                }
                str2 = ((a.AbstractBinderC0151a.C0152a) this.f44312a).a(this.f44314c, this.f44315d, str);
            } catch (Throwable unused3) {
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return "";
    }

    public void b() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        this.f44313b.bindService(intent, this.f44317f, 1);
    }
}
