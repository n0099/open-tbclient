package d.r.b.a.a.f.h;

import com.baidu.searchbox.pms.db.PackageTable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public class a {
    public static synchronized String a(String str) {
        String str2;
        synchronized (a.class) {
            str2 = "";
            try {
                for (byte b2 : MessageDigest.getInstance(PackageTable.MD5).digest(str.getBytes())) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    str2 = str2 + hexString;
                }
            } catch (NoSuchAlgorithmException unused) {
                if (d.r.b.a.a.f.a.c().d()) {
                    throw new RuntimeException("没有md5这个算法！");
                }
                return str2;
            }
        }
        return str2;
    }
}
