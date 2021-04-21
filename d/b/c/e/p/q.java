package d.b.c.e.p;

import com.baidu.adp.lib.util.BdLog;
import java.io.InputStream;
import java.security.MessageDigest;
/* loaded from: classes.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f42770a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(f42770a[(bArr[i] & 240) >>> 4]);
            sb.append(f42770a[bArr[i] & 15]);
        }
        return sb.toString();
    }

    public static String b(InputStream inputStream) {
        String str = null;
        if (inputStream == null) {
            return null;
        }
        try {
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                str = a(messageDigest.digest());
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
            return str;
        } finally {
            m.e(inputStream);
        }
    }

    public static String c(String str) {
        if (str == null) {
            return null;
        }
        try {
            return d(str.getBytes("UTF-8"));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String d(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (Exception e2) {
            BdLog.e(e2);
            return null;
        }
    }
}
