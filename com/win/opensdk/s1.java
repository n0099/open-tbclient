package com.win.opensdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
/* loaded from: classes7.dex */
public class s1 {
    public static float a(Context context, String str, float f2) {
        return context.getSharedPreferences("_prefs", 0).getFloat(str, f2);
    }

    public static long a(Context context) {
        return context.getSharedPreferences("_prefs", 0).getLong("bdts", 0L);
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString(str, "");
        edit.commit();
    }

    public static byte[] a(String str) {
        int i2;
        int i3;
        String trim = str.toUpperCase().trim();
        if (trim.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[trim.length() / 2];
        int i4 = 0;
        while (i4 < trim.length()) {
            char charAt = trim.charAt(i4);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    i2 = charAt - '7';
                }
                return null;
            }
            i2 = charAt - '0';
            int i5 = i2 * 16;
            int i6 = i4 + 1;
            char charAt2 = trim.charAt(i6);
            if (charAt2 < '0' || charAt2 > '9') {
                if (charAt2 >= 'A' && charAt2 <= 'F') {
                    i3 = charAt2 - '7';
                }
                return null;
            }
            i3 = charAt2 - '0';
            bArr[i6 / 2] = (byte) (i5 + i3);
            i4 = i6 + 1;
        }
        return bArr;
    }

    public static Object b(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("_prefs", 0);
            if (sharedPreferences.contains(str)) {
                String string = sharedPreferences.getString(str, "");
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                return new ObjectInputStream(new ByteArrayInputStream(a(string))).readObject();
            }
        } catch (StreamCorruptedException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        } catch (ClassNotFoundException e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static String b(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("bp", "");
    }

    public static long c(Context context) {
        return context.getSharedPreferences("_prefs", 0).getLong("ck_al", 0L);
    }

    public static long d(Context context) {
        return context.getSharedPreferences("_prefs", 0).getLong("spl_dev_timeout", 2000L);
    }

    public static String e(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("p_i", "");
    }

    public static int f(Context context) {
        return context.getSharedPreferences("_prefs", 0).getInt("bro_high", 0);
    }

    public static int g(Context context) {
        return context.getSharedPreferences("_prefs", 0).getInt("jumpsw", 0);
    }

    public static long h(Context context) {
        return context.getSharedPreferences("_prefs", 0).getLong("lu_date", 0L);
    }

    public static String i(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("oaid", "");
    }

    public static String j(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("oid", "");
    }

    public static String k(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString(TiebaStatic.Params.PID_MERGE, "[]");
    }

    public static int l(Context context) {
        return context.getSharedPreferences("_prefs", 0).getInt("re_pro", 4);
    }

    public static long m(Context context) {
        return context.getSharedPreferences("_prefs", 0).getLong("las", 12L) * 3600 * 1000;
    }

    public static String n(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("key_show_institial_adid", "");
    }

    public static String o(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("key_show_native_adid", "");
    }

    public static long p(Context context) {
        return context.getSharedPreferences("_prefs", 0).getLong("spl_timeout", 1000L);
    }

    public static int q(Context context) {
        return context.getSharedPreferences("_prefs", 0).getInt("timeout_sec", 5);
    }

    public static void r(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putLong("bdts", currentTimeMillis);
        edit.apply();
    }

    public static void a(Context context, String str, Object obj) {
        String stringBuffer;
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray == null) {
                stringBuffer = null;
            } else if (byteArray.length == 0) {
                stringBuffer = "";
            } else {
                StringBuffer stringBuffer2 = new StringBuffer(byteArray.length);
                for (byte b2 : byteArray) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() < 2) {
                        stringBuffer2.append(0);
                    }
                    stringBuffer2.append(hexString.toUpperCase());
                }
                stringBuffer = stringBuffer2.toString();
            }
            edit.putString(str, stringBuffer);
            edit.commit();
        } catch (IOException e2) {
            e2.printStackTrace();
            Log.e("", "保存obj失败");
        }
    }

    public static void b(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putLong("lu_date", j);
        edit.apply();
    }

    public static void c(Context context, String str) {
        if (context.getSharedPreferences("_prefs", 0).contains("sever_tk")) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString("sever_tk", str);
        edit.apply();
    }

    public static void d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString("p_i", str);
        edit.apply();
    }

    public static void e(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString("lcss", str);
        edit.apply();
    }

    public static void f(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString("oaid", str);
        edit.apply();
    }

    public static void g(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString("oid", str);
        edit.apply();
    }

    public static void b(Context context, String str, boolean z) {
        String o = o(context);
        if (!TextUtils.isEmpty(o) && !z) {
            str = o + "," + str;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString("key_show_native_adid", str);
        edit.apply();
    }

    public static void a(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putLong("spl_dev_timeout", j);
        edit.apply();
    }

    public static void b(Context context, float f2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putFloat("splash_width", f2);
        edit.apply();
    }

    public static void c(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putLong("spl_timeout", j);
        edit.apply();
    }

    public static void a(Context context, String str, boolean z) {
        String n = n(context);
        if (!TextUtils.isEmpty(n) && !z) {
            str = n + "," + str;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString("key_show_institial_adid", str);
        edit.apply();
    }

    public static void a(Context context, float f2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putFloat("splash_height", f2);
        edit.apply();
    }
}
