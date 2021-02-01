package com.fun.ad;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.live.adp.lib.util.SecureHelper;
import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes6.dex */
public final class m {
    public static <T> String a(T t) {
        return new Gson().toJson(t);
    }

    public static String a(String str, String str2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(str2, 0), com.baidu.sapi2.utils.e.q);
        Cipher cipher = Cipher.getInstance(SecureHelper.CIPHER_TRIPLE_AES);
        cipher.init(2, secretKeySpec);
        return new String(cipher.doFinal(Base64.decode(str, 0)));
    }

    public static void a(String str) {
        if (d.e) {
            Log.e("FunAdSdk", str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0022, code lost:
        r5.setAccessible(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        r0 = r5.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        r1.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
        r1 = r2.getSuperclass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        if (r1 == java.lang.Object.class) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object C(String str, Object obj) {
        Class<? super Object> superclass;
        Object obj2 = null;
        if (obj != null) {
            try {
                Class<? super Object> cls = obj.getClass();
                loop0: while (true) {
                    if (cls != null) {
                        Field[] declaredFields = cls.getDeclaredFields();
                        int length = declaredFields.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                break;
                            }
                            Field field = declaredFields[i];
                            if (TextUtils.equals(str, field.getType().getName())) {
                                break loop0;
                            }
                            i++;
                        }
                    }
                    cls = superclass;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj2;
        return obj2;
    }

    public static String a(InputStream inputStream) {
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[4096];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }
}
