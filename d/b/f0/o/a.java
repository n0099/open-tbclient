package d.b.f0.o;

import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public Context f43043b;

    /* renamed from: a  reason: collision with root package name */
    public com.baidu.sso.n.a f43042a = null;

    /* renamed from: c  reason: collision with root package name */
    public String f43044c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f43045d = null;

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f43046e = new c(this);

    public a(Context context, d.b.f0.m.c cVar) {
        this.f43043b = context;
    }

    public final String a(String str) {
        return this.f43042a == null ? "" : b(str);
    }

    public final String b(String str) {
        String str2;
        Signature[] signatureArr;
        String str3 = null;
        try {
            if (TextUtils.isEmpty(this.f43044c)) {
                this.f43044c = this.f43043b.getPackageName();
            }
            if (TextUtils.isEmpty(this.f43045d)) {
                try {
                    signatureArr = this.f43043b.getPackageManager().getPackageInfo(this.f43044c, 64).signatures;
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
                this.f43045d = str3;
            }
            str2 = this.f43042a.a(this.f43044c, this.f43045d, str);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = str3;
        }
        return TextUtils.isEmpty(str2) ? "" : str2;
    }
}
