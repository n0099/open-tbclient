package com.sdk.base.framework.f.j;

import android.content.Context;
import com.sdk.base.framework.c.f;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes14.dex */
public class a extends com.sdk.base.framework.f.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12853a = a.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f12854b = f.f12819b;
    private static String c = "a6Hy5Hb8IfX46D1f";

    public static String a(int i) {
        String str = "";
        Random random = new Random();
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
        String b2 = com.sdk.base.framework.f.b.a.b(context, f.f12818a);
        if (com.sdk.base.framework.a.a.c.a(b2).booleanValue()) {
            String a2 = a(16);
            com.sdk.base.framework.f.b.a.b(context, f.f12818a, a2);
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
                a(f12853a, "EncryptCbcIv", e.getMessage(), f12854b);
            }
            if (str.length() != 0 && str.trim().length() != 0) {
                if (str2 == null) {
                    a(f12853a, "EncryptCbcIv", "encrypt key is null", f12854b);
                } else if (str2.length() != 16) {
                    a(f12853a, "EncryptCbcIv", "encrypt key length error", f12854b);
                } else if (str3.length() != 16) {
                    a(f12853a, "EncryptCbcIv", "ivStr length error", f12854b);
                } else {
                    Cipher cipher = Cipher.getInstance(com.baidu.sapi2.utils.e.p);
                    cipher.init(1, new SecretKeySpec(str2.getBytes("utf-8"), com.baidu.sapi2.utils.e.q), new IvParameterSpec(str3.getBytes("utf-8")));
                    str4 = c.a(cipher.doFinal(str.getBytes("utf-8")));
                }
                return str4;
            }
        }
        a(f12853a, "EncryptCbcIv", "encrypt content is null", f12854b);
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
