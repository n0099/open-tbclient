package d.a.i0.a.v2;

import android.util.Base64;
import android.util.Log;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes3.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45260a = d.a.i0.a.k.f43025a;

    @NonNull
    @CheckResult
    public static String a(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
        try {
            Cipher cipher = Cipher.getInstance(str3);
            cipher.init(1, new SecretKeySpec(str.getBytes("utf-8"), "AES"), new IvParameterSpec(str4.getBytes("utf-8")));
            return Base64.encodeToString(cipher.doFinal(str2.getBytes("utf-8")), 2);
        } catch (Exception e2) {
            if (f45260a) {
                Log.e("SwanAppEncryptUtils", "aesEncrypt", e2);
                return "";
            }
            return "";
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0054: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:38:0x0054 */
    public static String b(String str, File file, boolean z) {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.reset();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            String e2 = e(messageDigest.digest(), "", z);
                            d.a.i0.t.d.d(fileInputStream);
                            return e2;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    if (f45260a) {
                        e.printStackTrace();
                    }
                    d.a.i0.t.d.d(fileInputStream);
                    return null;
                } catch (IOException e4) {
                    e = e4;
                    if (f45260a) {
                        e.printStackTrace();
                    }
                    d.a.i0.t.d.d(fileInputStream);
                    return null;
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    if (f45260a) {
                        e.printStackTrace();
                    }
                    d.a.i0.t.d.d(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                d.a.i0.t.d.d(closeable2);
                throw th;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            fileInputStream = null;
        } catch (IOException e7) {
            e = e7;
            fileInputStream = null;
        } catch (NoSuchAlgorithmException e8) {
            e = e8;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.i0.t.d.d(closeable2);
            throw th;
        }
    }

    public static String c(String str, byte[] bArr, boolean z) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.reset();
        messageDigest.update(bArr);
        return e(messageDigest.digest(), "", z);
    }

    @NonNull
    @CheckResult
    public static String d(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes("utf-8"), 0)));
            Cipher cipher = Cipher.getInstance(str3);
            cipher.init(1, generatePublic);
            return Base64.encodeToString(cipher.doFinal(str2.getBytes("utf-8")), 2);
        } catch (Exception e2) {
            if (f45260a) {
                Log.e("SwanAppEncryptUtils", "rsaEncrypt", e2);
                return "";
            }
            return "";
        }
    }

    public static String e(byte[] bArr, String str, boolean z) {
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
}
