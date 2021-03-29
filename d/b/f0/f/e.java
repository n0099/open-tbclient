package d.b.f0.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import d.b.f0.l.f;
import d.b.f0.l.g;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    public static String f42960b;

    /* renamed from: a  reason: collision with root package name */
    public String f42961a = d.b.f0.b.b.f42827a;

    public e(Context context) {
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            eVar = new e(context);
        }
        return eVar;
    }

    public String b(String str, String str2) {
        String str3 = d.b.f0.a.f42809b;
        String str4 = d.b.f0.a.f42810c;
        String str5 = "";
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        try {
            str5 = c(str3, str4, currentTimeMillis);
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
        sb.append(f());
        sb.append(str);
        sb.append("/");
        sb.append("100");
        sb.append("/");
        sb.append(str3);
        sb.append("/");
        sb.append(currentTimeMillis);
        sb.append("/");
        sb.append(str5);
        sb.append("?skey=");
        sb.append(str2);
        return sb.toString();
    }

    public String c(String str, String str2, long j) {
        try {
            return g.b(str + j + str2);
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
            return "";
        }
    }

    public final void d() {
        try {
            f42960b = new String(d.b.f0.l.e.e(Base64.decode(this.f42961a, 0), "30212102dicudiab".getBytes("utf-8")));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
        }
    }

    public byte[] e(byte[] bArr, String str) {
        byte[] bArr2;
        try {
            bArr2 = f.b(str.getBytes("utf-8"));
        } catch (Throwable th) {
            d.b.f0.l.c.d(th);
            bArr2 = null;
        }
        return d.b.f0.l.e.f(bArr2, bArr);
    }

    public final String f() {
        if (TextUtils.isEmpty(f42960b)) {
            d();
        }
        return f42960b;
    }
}
