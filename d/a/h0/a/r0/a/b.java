package d.a.h0.a.r0.a;

import android.util.Base64;
import android.util.Log;
import d.a.h0.a.k;
import d.a.h0.p.d;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43789a = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f43790b = {31, -117};

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static File a(byte[] bArr, File file) {
        if (bArr != null && bArr.length >= 2 && file != null && file.exists()) {
            byte[] bArr2 = f43790b;
            bArr[0] = bArr2[0];
            bArr[1] = bArr2[1];
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                InputStreamReader inputStreamReader = new InputStreamReader(gZIPInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    }
                    if (f43789a) {
                        Log.d("SwanAppCloneModule", "first char:" + sb.charAt(0));
                    }
                    String string = new JSONObject(sb.toString()).getString(d.a.h0.a.r0.a.d.a.l);
                    if (f43789a) {
                        Log.d("SwanAppCloneModule", string);
                    }
                    byte[] doFinal = b(2).doFinal(Base64.decode(string, 0));
                    File file2 = new File(file, d.a.h0.a.r0.a.d.a.l);
                    new FileOutputStream(file2).write(doFinal);
                    if (f43789a) {
                        Log.d("SwanAppCloneModule", file2.getAbsolutePath());
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return file2;
                } finally {
                }
            } catch (Exception e2) {
                if (f43789a) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    public static Cipher b(int i2) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(i2, new SecretKeySpec(c("la32118_p9d8#*!6)".getBytes()).substring(16).getBytes(), "AES"), new IvParameterSpec("2081147213143090".getBytes()));
        return cipher;
    }

    public static String c(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return d.E(messageDigest.digest(), "", false);
        } catch (NoSuchAlgorithmException e2) {
            if (f43789a) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }
}
