package d.b.g0.l.r;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class b {
    public static String a(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0056: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:38:0x0056 */
    public static String b(File file, boolean z) {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.reset();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            String a2 = a(messageDigest.digest(), "", z);
                            d.b.g0.p.d.a(fileInputStream);
                            return a2;
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    if (d.b.g0.l.f.f48889a) {
                        e.printStackTrace();
                    }
                    d.b.g0.p.d.a(fileInputStream);
                    return null;
                } catch (IOException e3) {
                    e = e3;
                    if (d.b.g0.l.f.f48889a) {
                        e.printStackTrace();
                    }
                    d.b.g0.p.d.a(fileInputStream);
                    return null;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    if (d.b.g0.l.f.f48889a) {
                        e.printStackTrace();
                    }
                    d.b.g0.p.d.a(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                d.b.g0.p.d.a(closeable2);
                throw th;
            }
        } catch (FileNotFoundException e5) {
            e = e5;
            fileInputStream = null;
        } catch (IOException e6) {
            e = e6;
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e7) {
            e = e7;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.g0.p.d.a(closeable2);
            throw th;
        }
    }
}
