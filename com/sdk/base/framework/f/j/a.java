package com.sdk.base.framework.f.j;

import android.content.Context;
import com.sdk.base.framework.c.f;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes16.dex */
public class a extends com.sdk.base.framework.f.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4503a = a.class.getName();
    private static boolean b = f.b;
    private static String c = "a6Hy5Hb8IfX46D1f";

    public static String a(int i) {
        Random random = new Random();
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            String str2 = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(str2)) {
                str = str + ((char) ((random.nextInt(2) % 2 == 0 ? 65 : 97) + random.nextInt(26)));
            } else if ("num".equalsIgnoreCase(str2)) {
                str = str + String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }

    public static String a(Context context) {
        String b2 = com.sdk.base.framework.f.b.a.b(context, f.f4484a);
        if (com.sdk.base.framework.a.a.c.a(b2).booleanValue()) {
            String a2 = a(16);
            com.sdk.base.framework.f.b.a.b(context, f.f4484a, a2);
            return a2;
        }
        return b2;
    }

    public static String a(String str, String str2) {
        return b(str, str2, c);
    }

    public static String a(String str, String str2, String str3) {
        String str4 = null;
        if (str != null) {
            try {
            } catch (Exception e) {
                a(f4503a, "EncryptCbcIv", e.getMessage(), b);
            }
            if (str.length() != 0 && str.trim().length() != 0) {
                if (str2 == null) {
                    a(f4503a, "EncryptCbcIv", "encrypt key is null", b);
                } else if (str2.length() != 16) {
                    a(f4503a, "EncryptCbcIv", "encrypt key length error", b);
                } else if (str3.length() != 16) {
                    a(f4503a, "EncryptCbcIv", "ivStr length error", b);
                } else {
                    Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.p);
                    cipher.init(1, new SecretKeySpec(str2.getBytes("utf-8"), com.baidu.sapi2.utils.e.q), new IvParameterSpec(str3.getBytes("utf-8")));
                    str4 = c.a(cipher.doFinal(str.getBytes("utf-8")));
                }
                return str4;
            }
        }
        a(f4503a, "EncryptCbcIv", "encrypt content is null", b);
        return str4;
    }

    public static String b(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (str.length() != 0 && str.trim().length() != 0) {
                    if (str2 == null) {
                        throw new Exception("decrypt key is null");
                    }
                    if (str2.length() != 16) {
                        throw new Exception("decrypt key length error");
                    }
                    if (str3.length() != 16) {
                        throw new Exception(" iv decrypt key length error");
                    }
                    byte[] a2 = c.a(str);
                    Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.p);
                    cipher.init(2, new SecretKeySpec(str2.getBytes("utf-8"), com.baidu.sapi2.utils.e.q), new IvParameterSpec(str3.getBytes("utf-8")));
                    return new String(cipher.doFinal(a2), "utf-8");
                }
            } catch (Exception e) {
                throw new Exception("decrypt errot", e);
            }
        }
        return null;
    }
}
