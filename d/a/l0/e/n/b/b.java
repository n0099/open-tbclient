package d.a.l0.e.n.b;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/* loaded from: classes3.dex */
public class b {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:33:0x004a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(byte[] bArr, Key key, int i2) {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] doFinal;
        ?? r0 = 0;
        if (bArr != null && bArr.length != 0 && key != null) {
            try {
                if (i2 > 0) {
                    try {
                        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                        cipher.init(1, key);
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            int length = bArr.length;
                            int i3 = 0;
                            while (true) {
                                int i4 = length - i3;
                                if (i4 <= 0) {
                                    break;
                                }
                                if (i4 > i2) {
                                    doFinal = cipher.doFinal(bArr, i3, i2);
                                } else {
                                    doFinal = cipher.doFinal(bArr, i3, i4);
                                }
                                byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                                i3 += i2;
                            }
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return byteArray;
                        } catch (InvalidKeyException e3) {
                            e = e3;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                            return null;
                        } catch (NoSuchAlgorithmException e5) {
                            e = e5;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                            }
                            return null;
                        } catch (BadPaddingException e6) {
                            e = e6;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                            }
                            return null;
                        } catch (IllegalBlockSizeException e7) {
                            e = e7;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                            }
                            return null;
                        } catch (NoSuchPaddingException e8) {
                            e = e8;
                            e.printStackTrace();
                            if (byteArrayOutputStream != null) {
                            }
                            return null;
                        }
                    } catch (InvalidKeyException e9) {
                        e = e9;
                        byteArrayOutputStream = null;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                        return null;
                    } catch (NoSuchAlgorithmException e10) {
                        e = e10;
                        byteArrayOutputStream = null;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                        return null;
                    } catch (BadPaddingException e11) {
                        e = e11;
                        byteArrayOutputStream = null;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                        return null;
                    } catch (IllegalBlockSizeException e12) {
                        e = e12;
                        byteArrayOutputStream = null;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                        return null;
                    } catch (NoSuchPaddingException e13) {
                        e = e13;
                        byteArrayOutputStream = null;
                        e.printStackTrace();
                        if (byteArrayOutputStream != null) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        if (r0 != 0) {
                            try {
                                r0.close();
                            } catch (IOException e14) {
                                e14.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                r0 = key;
            }
        }
        return null;
    }

    public static byte[] b(byte[] bArr, String str, int i2) {
        PublicKey c2;
        if (bArr == null || bArr.length == 0 || TextUtils.isEmpty(str) || i2 <= 0 || (c2 = c(str)) == null) {
            return null;
        }
        return a(bArr, c2, i2);
    }

    public static PublicKey c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str.getBytes("utf-8"), 0)));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeySpecException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
