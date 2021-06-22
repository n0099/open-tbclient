package com.sdk.base.framework.f.i;

import android.content.Context;
import com.sdk.base.framework.c.f;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes7.dex */
public class a extends com.sdk.base.framework.f.a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39480a = "com.sdk.base.framework.f.i.a";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f39481b = f.f39439b;

    /* renamed from: c  reason: collision with root package name */
    public static String f39482c = "a6Hy5Hb8IfX46D1f";

    public static String a(int i2) {
        Random random = new Random();
        String str = "";
        for (int i3 = 0; i3 < i2; i3++) {
            String str2 = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(str2)) {
                int i4 = random.nextInt(2) % 2 == 0 ? 65 : 97;
                str = str + ((char) (random.nextInt(26) + i4));
            } else if ("num".equalsIgnoreCase(str2)) {
                str = str + String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }

    public static String a(Context context) {
        String b2 = com.sdk.base.framework.f.b.a.b(context, f.f39438a);
        if (com.sdk.base.framework.a.a.c.a(b2).booleanValue()) {
            String a2 = a(16);
            com.sdk.base.framework.f.b.a.b(context, f.f39438a, a2);
            return a2;
        }
        return b2;
    }

    public static String a(String str, String str2) {
        return b(str, str2, f39482c);
    }

    public static String a(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (str.length() != 0 && str.trim().length() != 0) {
                    if (str2 == null) {
                        com.sdk.base.framework.f.a.a(f39480a, "EncryptCbcIv", "encrypt key is null", f39481b);
                        return null;
                    } else if (str2.length() != 16) {
                        com.sdk.base.framework.f.a.a(f39480a, "EncryptCbcIv", "encrypt key length error", f39481b);
                        return null;
                    } else if (str3.length() != 16) {
                        com.sdk.base.framework.f.a.a(f39480a, "EncryptCbcIv", "ivStr length error", f39481b);
                        return null;
                    } else {
                        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        cipher.init(1, new SecretKeySpec(str2.getBytes("utf-8"), "AES"), new IvParameterSpec(str3.getBytes("utf-8")));
                        return c.a(cipher.doFinal(str.getBytes("utf-8")));
                    }
                }
            } catch (Exception e2) {
                com.sdk.base.framework.f.a.a(f39480a, "EncryptCbcIv", e2.getMessage(), f39481b);
                return null;
            }
        }
        com.sdk.base.framework.f.a.a(f39480a, "EncryptCbcIv", "encrypt content is null", f39481b);
        return null;
    }

    public static String b(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (str.length() != 0 && str.trim().length() != 0) {
                    if (str2 != null) {
                        if (str2.length() == 16) {
                            if (str3.length() == 16) {
                                byte[] a2 = c.a(str);
                                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                                cipher.init(2, new SecretKeySpec(str2.getBytes("utf-8"), "AES"), new IvParameterSpec(str3.getBytes("utf-8")));
                                return new String(cipher.doFinal(a2), "utf-8");
                            }
                            throw new Exception(" iv decrypt key length error");
                        }
                        throw new Exception("decrypt key length error");
                    }
                    throw new Exception("decrypt key is null");
                }
                return null;
            } catch (Exception e2) {
                throw new Exception("decrypt errot", e2);
            }
        }
        return null;
    }
}
