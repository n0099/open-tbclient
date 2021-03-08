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
/* loaded from: classes14.dex */
public class bp {
    public static long a(Context context) {
        return context.getSharedPreferences("_prefs", 0).getLong("bdts", 0L);
    }

    public static void a(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString(str, "");
        edit.commit();
    }

    public static byte[] a(String str) {
        int i;
        int i2;
        String trim = str.toUpperCase().trim();
        if (trim.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[trim.length() / 2];
        int i3 = 0;
        while (i3 < trim.length()) {
            char charAt = trim.charAt(i3);
            if (charAt >= '0' && charAt <= '9') {
                i = (charAt - '0') * 16;
            } else if (charAt < 'A' || charAt > 'F') {
                return null;
            } else {
                i = (charAt - '7') * 16;
            }
            int i4 = i3 + 1;
            char charAt2 = trim.charAt(i4);
            if (charAt2 >= '0' && charAt2 <= '9') {
                i2 = charAt2 - '0';
            } else if (charAt2 < 'A' || charAt2 > 'F') {
                return null;
            } else {
                i2 = charAt2 - '7';
            }
            bArr[i4 / 2] = (byte) (i2 + i);
            i3 = i4 + 1;
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
            return null;
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String b(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("bp", "");
    }

    public static long c(Context context) {
        return context.getSharedPreferences("_prefs", 0).getLong("ck_al", 0L);
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

    public static String i(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("oaid", "");
    }

    public static int iO(Context context) {
        return context.getSharedPreferences("_prefs", 0).getInt("timeout_sec", 5);
    }

    public static long iP(Context context) {
        return context.getSharedPreferences("_prefs", 0).getLong("lu_date", 0L);
    }

    public static int iQ(Context context) {
        return context.getSharedPreferences("_prefs", 0).getInt("re_pro", 4);
    }

    public static long iR(Context context) {
        return context.getSharedPreferences("_prefs", 0).getLong("spl_dev_timeout", 2000L);
    }

    public static String j(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("oid", "");
    }

    public static String k(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("pids", "[]");
    }

    public static int l(Context context) {
        return context.getSharedPreferences("_prefs", 0).getInt("psdopt", 0);
    }

    public static String m(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("psdid", "");
    }

    public static long o(Context context) {
        return context.getSharedPreferences("_prefs", 0).getLong("las", 12L) * 3600 * 1000;
    }

    public static String p(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("key_show_institial_adid", "");
    }

    public static String q(Context context) {
        return context.getSharedPreferences("_prefs", 0).getString("key_show_native_adid", "");
    }

    public static boolean t(Context context) {
        return context.getSharedPreferences("_prefs", 0).getInt("hbsw", 1) == 1;
    }

    public static boolean u(Context context) {
        if (context.getSharedPreferences("_prefs", 0).getInt("psd", 0) == 1) {
            if (((float) (System.currentTimeMillis() / 1000)) - (context.getSharedPreferences("_prefs", 0).getFloat("psdpt", 0.0f) / 1000.0f) >= ((float) context.getSharedPreferences("_prefs", 0).getInt("psdt", 0))) {
                return true;
            }
        }
        return false;
    }

    public static void v(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putLong("bdts", currentTimeMillis);
        edit.apply();
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

    public static void b(Context context, String str, Object obj) {
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
                for (byte b : byteArray) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() < 2) {
                        stringBuffer2.append(0);
                    }
                    stringBuffer2.append(hexString.toUpperCase());
                }
                stringBuffer = stringBuffer2.toString();
            }
            edit.putString(str, stringBuffer);
            edit.commit();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("", "保存obj失败");
        }
    }

    public static void b(Context context, String str, boolean z) {
        String q = q(context);
        if (!TextUtils.isEmpty(q) && !z) {
            str = q + "," + str;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString("key_show_native_adid", str);
        edit.apply();
    }

    public static void a(Context context, String str, boolean z) {
        String p = p(context);
        if (!TextUtils.isEmpty(p) && !z) {
            str = p + "," + str;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("_prefs", 0).edit();
        edit.putString("key_show_institial_adid", str);
        edit.apply();
    }
}
