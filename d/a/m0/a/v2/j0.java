package d.a.m0.a.v2;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.yy.hiidostatis.inner.util.cipher.RsaCipher;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
/* loaded from: classes3.dex */
public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49200a = d.a.m0.a.k.f46983a;

    public static boolean a(File file, String str) {
        return b(file, str, null);
    }

    public static boolean b(File file, String str, d.a.m0.a.v2.a1.c cVar) {
        boolean z = file == null;
        if (z || !file.exists() || TextUtils.isEmpty(str)) {
            if (cVar != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("zipfile: isEmpty=");
                sb.append(z);
                sb.append("; exists=");
                sb.append(z ? "" : Boolean.valueOf(file.exists()));
                cVar.f49138a = sb.toString();
            }
            return false;
        }
        ReadableByteChannel readableByteChannel = null;
        try {
            readableByteChannel = Channels.newChannel(new FileInputStream(file));
            return d(readableByteChannel, str, cVar);
        } catch (IOException e2) {
            if (f49200a) {
                e2.printStackTrace();
            }
            return false;
        } finally {
            d.a.m0.t.d.d(readableByteChannel);
        }
    }

    public static boolean c(ReadableByteChannel readableByteChannel, String str) throws IOException {
        return d(readableByteChannel, str, null);
    }

    public static boolean d(ReadableByteChannel readableByteChannel, String str, d.a.m0.a.v2.a1.c cVar) throws IOException {
        boolean z = readableByteChannel == null;
        if (z || TextUtils.isEmpty(str)) {
            if (cVar != null) {
                cVar.f49138a = "zipSource isNullIs=" + z;
            }
            return false;
        }
        String c2 = d.a.m0.t.f.c(false, readableByteChannel);
        if (cVar != null) {
            cVar.f49138a = c2;
        }
        try {
            String str2 = new String(e(Base64.decode(str.getBytes("utf-8"), 8), f("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDZuy3GEbahJc292fsyvrGneTJKQnzpdhNsJfDS5csb0MtmW+4JEvBH5wCZK5j4+nrRfKBF7JuTHe0nSWOZWNxgLU87pwCxozXSNrsiiOjsV+3KwYfdz5QlvvyCfvmllGObPqL7dWR92V2UYEWMSneBHtwDhCBCzmhAoOxZVsAq2wIDAQAB")), "utf-8");
            if (cVar != null) {
                cVar.f49139b = str2;
            }
            return TextUtils.equals(str2, c2);
        } catch (Exception e2) {
            if (f49200a) {
                Log.i("SwanAppSignChecker", e2.toString());
                e2.printStackTrace();
            }
            if (cVar != null) {
                cVar.f49139b = e2.getLocalizedMessage();
            }
            return false;
        }
    }

    public static byte[] e(byte[] bArr, PublicKey publicKey) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(RsaCipher.RSA_PADDING);
        cipher.init(2, publicKey);
        return cipher.doFinal(bArr);
    }

    public static PublicKey f(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes("utf-8"), 0)));
        } catch (UnsupportedEncodingException | NullPointerException | NoSuchAlgorithmException | InvalidKeySpecException unused) {
            return null;
        }
    }
}
