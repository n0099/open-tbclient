package d.b.g0.o;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public Context f43733b;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.sso.n.a f43732a = null;

    /* renamed from: c  reason: collision with root package name */
    public String f43734c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f43735d = null;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f43736e = new c(this);

    public a(Context context, d.b.g0.m.c cVar) {
        this.f43733b = context;
    }

    public final String a(String str) {
        return this.f43732a == null ? "" : b(str);
    }

    public final String b(String str) {
        String str2;
        Signature[] signatureArr;
        String str3 = null;
        try {
            if (TextUtils.isEmpty(this.f43734c)) {
                this.f43734c = this.f43733b.getPackageName();
            }
            if (TextUtils.isEmpty(this.f43735d)) {
                try {
                    signatureArr = this.f43733b.getPackageManager().getPackageInfo(this.f43734c, 64).signatures;
                } catch (PackageManager.NameNotFoundException unused) {
                    signatureArr = null;
                }
                if (signatureArr != null && signatureArr.length > 0) {
                    try {
                        byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        str3 = sb.toString();
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                }
                this.f43735d = str3;
            }
            str2 = this.f43732a.a(this.f43734c, this.f43735d, str);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = str3;
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
