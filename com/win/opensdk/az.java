package com.win.opensdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
/* loaded from: classes4.dex */
public class az {
    private static final String java = az.class.getSimpleName();

    private az() {
    }

    private static int m(Context context, String str, int i) {
        return context.getSharedPreferences("_prefs", 0).getInt(str, i);
    }

    private static void n(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }

    private static void i(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putLong(str, j);
        edit.apply();
    }

    private static long j(Context context, String str, long j) {
        return context.getSharedPreferences("_prefs", 0).getLong(str, j);
    }

    private static void F(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private static String G(Context context, String str, String str2) {
        return context.getSharedPreferences("_prefs", 0).getString(str, str2);
    }

    public static void bJ(Context context, String str) {
        F(context, "oaid", str);
    }

    public static String iR(Context context) {
        return G(context, "oaid", "");
    }

    public static void bL(Context context, String str) {
        F(context, "lcss", str);
    }

    public static String iQ(Context context) {
        return G(context, "lcss", "");
    }

    public static void a(Context context, String str) {
        if (!context.getSharedPreferences("_prefs", 0).contains("sever_tk")) {
            F(context, "sever_tk", str);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m54a(Context context) {
        return G(context, "sever_tk", "");
    }

    public static void W(Context context, int i) {
        n(context, "timeout_sec", i);
    }

    public static int iS(Context context) {
        return m(context, "timeout_sec", 5);
    }

    public static void b(Context context, String str) {
        F(context, "pids", str);
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m56b(Context context) {
        return G(context, "pids", "[]");
    }

    public static void c(Context context, String str) {
        F(context, "psdid", str);
    }

    /* renamed from: c  reason: collision with other method in class */
    public static String m58c(Context context) {
        return G(context, "psdid", "");
    }

    public static void X(Context context, int i) {
        n(context, "psdopt", i);
    }

    public static int iT(Context context) {
        return m(context, "psdopt", 0);
    }

    public static void a(Context context, int i) {
        n(context, "psdt", i);
    }

    public static void j(Context context, float f) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putFloat("psdpt", f);
        edit.apply();
    }

    public static void b(Context context, int i) {
        n(context, "psd", i);
    }

    public static void c(Context context, int i) {
        n(context, "hbsw", i);
    }

    public static boolean iU(Context context) {
        return m(context, "hbsw", 1) == 1;
    }

    public static void Y(Context context, int i) {
        n(context, "interval", i);
    }

    public static int a(Context context) {
        return m(context, "interval", 0);
    }

    public static void d(Context context, String str) {
        F(context, "bp", str);
    }

    /* renamed from: d  reason: collision with other method in class */
    public static String m60d(Context context) {
        return G(context, "bp", "");
    }

    public static void Z(Context context, int i) {
        n(context, "bro_high", i);
    }

    public static int b(Context context) {
        return m(context, "bro_high", 0);
    }

    public static void l(Context context, long j) {
        i(context, "lu_date", j);
    }

    public static long iV(Context context) {
        return j(context, "lu_date", 0L);
    }

    public static void aa(Context context, int i) {
        n(context, "re_pro", i);
    }

    public static int c(Context context) {
        return m(context, "re_pro", 4);
    }

    public static void ab(Context context, int i) {
        n(context, "jumpsw", i);
    }

    public static int d(Context context) {
        return m(context, "jumpsw", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static long m53a(Context context) {
        return j(context, "spl_dev_timeout", 2000L);
    }

    public static void ac(Context context, int i) {
        n(context, "scb_sw", i);
    }

    public static void ad(Context context, int i) {
        n(context, "pcl_sw", i);
    }

    public static void ae(Context context, int i) {
        n(context, "scb_tsi", i);
    }

    public static void e(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            F(context, "p_i", str);
        }
    }

    /* renamed from: e  reason: collision with other method in class */
    public static String m62e(Context context) {
        return G(context, "p_i", "");
    }

    public static void af(Context context, int i) {
        n(context, "alh", i);
    }

    public static int e(Context context) {
        return m(context, "alh", 0);
    }

    public static void iK(Context context) {
        i(context, "ck_al", System.currentTimeMillis());
    }

    /* renamed from: b  reason: collision with other method in class */
    public static long m55b(Context context) {
        return j(context, "ck_al", 0L);
    }

    public static void iW(Context context) {
        i(context, "bdts", System.currentTimeMillis());
    }

    /* renamed from: c  reason: collision with other method in class */
    public static long m57c(Context context) {
        return j(context, "bdts", 0L);
    }

    public static void b(Context context, long j) {
        i(context, "bdtsi", j);
    }

    /* renamed from: d  reason: collision with other method in class */
    public static long m59d(Context context) {
        return j(context, "bdtsi", 24L);
    }

    public static void k(Context context, String str, boolean z) {
        String f = f(context);
        if (!TextUtils.isEmpty(f) && !z) {
            str = f + "," + str;
        }
        F(context, "key_show_native_adid", str);
    }

    public static String f(Context context) {
        return G(context, "key_show_native_adid", "");
    }

    public static void l(Context context, String str, boolean z) {
        String g = g(context);
        if (!TextUtils.isEmpty(g) && !z) {
            str = g + "," + str;
        }
        F(context, "key_show_institial_adid", str);
    }

    public static String g(Context context) {
        return G(context, "key_show_institial_adid", "");
    }

    public static void c(Context context, long j) {
        i(context, "las", j);
    }

    /* renamed from: e  reason: collision with other method in class */
    public static long m61e(Context context) {
        return j(context, "las", 12L) * 3600 * 1000;
    }

    public static void a(Context context, String str, Object obj) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            edit.putString(str, at(byteArrayOutputStream.toByteArray()));
            edit.commit();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("", "保存obj失败");
        }
    }

    private static String at(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object bM(Context context, String str) {
        byte[] bArr;
        int i;
        int i2;
        int i3 = 0;
        Object obj = null;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("_prefs", 0);
            if (sharedPreferences.contains(str)) {
                String string = sharedPreferences.getString(str, "");
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                String trim = string.toUpperCase().trim();
                if (trim.length() % 2 != 0) {
                    bArr = null;
                } else {
                    bArr = new byte[trim.length() / 2];
                    while (true) {
                        int i4 = i3;
                        if (i4 >= trim.length()) {
                            break;
                        }
                        char charAt = trim.charAt(i4);
                        if (charAt >= '0' && charAt <= '9') {
                            i = (charAt - '0') * 16;
                        } else if (charAt < 'A' || charAt > 'F') {
                            break;
                        } else {
                            i = (charAt - '7') * 16;
                        }
                        int i5 = i4 + 1;
                        char charAt2 = trim.charAt(i5);
                        if (charAt2 >= '0' && charAt2 <= '9') {
                            i2 = charAt2 - '0';
                        } else if (charAt2 < 'A' || charAt2 > 'F') {
                            break;
                        } else {
                            i2 = charAt2 - '7';
                        }
                        bArr[i5 / 2] = (byte) (i2 + i);
                        i3 = i5 + 1;
                    }
                    bArr = null;
                }
                obj = new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
                return obj;
            }
            return null;
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
            return obj;
        } catch (IOException e2) {
            e2.printStackTrace();
            return obj;
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
            return obj;
        }
    }

    public static void f(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString(str, "");
        edit.commit();
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2246=4] */
    public static boolean iL(Context context) {
        if (m(context, "psd", 0) == 1) {
            if (((float) (System.currentTimeMillis() / 1000)) - (context.getSharedPreferences("_prefs", 0).getFloat("psdpt", 0.0f) / 1000.0f) >= ((float) m(context, "psdt", 0))) {
                return true;
            }
        }
        return false;
    }
}
