package d.a.j0.l;

import android.text.TextUtils;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f44158a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(byte b2) {
        int i2;
        if (b2 < 0) {
            i2 = b2 + 256;
        }
        return f44158a[i2 / 16] + f44158a[i2 % 16];
    }

    public static String b(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String str3 = new String(str);
            try {
                return c(MessageDigest.getInstance("MD5").digest(str3.getBytes()));
            } catch (Throwable th) {
                th = th;
                str2 = str3;
                c.d(th);
                return str2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(a(b2));
        }
        return stringBuffer.toString();
    }

    public static String d(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        try {
            return c(MessageDigest.getInstance("MD5").digest(bArr));
        } catch (Throwable th) {
            c.d(th);
            return "";
        }
    }

    public static byte[] e(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (Throwable th) {
            c.d(th);
            return null;
        }
    }
}
