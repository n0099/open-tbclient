package com.xiaomi.channel.commonutils.android;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class d {
    private static String a = null;
    private static String b = "";
    private static String c = null;
    private static String d = null;
    private static String e = null;
    private static volatile boolean f = false;

    public static String a() {
        if (Build.VERSION.SDK_INT <= 8 || Build.VERSION.SDK_INT >= 26) {
            if (Build.VERSION.SDK_INT >= 26) {
                return (String) com.xiaomi.channel.commonutils.reflect.a.a("android.os.Build", "getSerial", (Object[]) null);
            }
            return null;
        }
        return Build.SERIAL;
    }

    public static String a(Context context) {
        return "a-" + com.xiaomi.channel.commonutils.string.d.b(((String) null) + d(context) + ((String) null));
    }

    public static String a(Context context, boolean z) {
        if (c == null) {
            c = "a-" + com.xiaomi.channel.commonutils.string.d.b((f.g() ? "" : z ? e(context) : o(context)) + d(context) + a());
        }
        return c;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static void a(Context context, String str) {
        com.xiaomi.channel.commonutils.logger.b.c("update vdevid = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e = str;
        com.xiaomi.channel.commonutils.file.a aVar = null;
        try {
            try {
                if (n(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/Xiaomi/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevid");
                    aVar = com.xiaomi.channel.commonutils.file.a.a(context, file2);
                    com.xiaomi.channel.commonutils.file.b.a(file2);
                    com.xiaomi.channel.commonutils.file.b.a(file2, e);
                }
                com.xiaomi.channel.commonutils.file.b.a(new File(context.getFilesDir(), ".vdevid"), e);
                if (aVar != null) {
                    aVar.a();
                }
            } catch (IOException e2) {
                com.xiaomi.channel.commonutils.logger.b.a("update vdevid failure :" + e2.getMessage());
                if (aVar != null) {
                    aVar.a();
                }
            }
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.a();
            }
            throw th;
        }
    }

    private static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && com.xiaomi.channel.commonutils.string.d.e(str) && !com.xiaomi.channel.commonutils.string.d.f(str);
    }

    @TargetApi(17)
    public static int b() {
        Object a2;
        if (Build.VERSION.SDK_INT >= 17 && (a2 = com.xiaomi.channel.commonutils.reflect.a.a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return ((Integer) Integer.class.cast(a2)).intValue();
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context) {
        com.xiaomi.channel.commonutils.file.a aVar;
        Throwable th;
        IOException e2;
        if (!n(context)) {
            return null;
        }
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        e = com.xiaomi.channel.commonutils.file.b.b(new File(context.getFilesDir(), ".vdevid"));
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/Xiaomi/"), ".vdevid");
            aVar = com.xiaomi.channel.commonutils.file.a.a(context, file);
            try {
                try {
                    e = "";
                    String b2 = com.xiaomi.channel.commonutils.file.b.b(file);
                    if (b2 != null) {
                        e = b2;
                    }
                    String str = e;
                    if (aVar != null) {
                        aVar.a();
                        return str;
                    }
                    return str;
                } catch (IOException e3) {
                    e2 = e3;
                    com.xiaomi.channel.commonutils.logger.b.a("getVDevID failure :" + e2.getMessage());
                    if (aVar != null) {
                        aVar.a();
                    }
                    return e;
                }
            } catch (Throwable th2) {
                th = th2;
                if (aVar != null) {
                    aVar.a();
                }
                throw th;
            }
        } catch (IOException e4) {
            aVar = null;
            e2 = e4;
        } catch (Throwable th3) {
            aVar = null;
            th = th3;
            if (aVar != null) {
            }
            throw th;
        }
    }

    private static boolean b(String str) {
        boolean z;
        if (!TextUtils.isEmpty(str) && str.length() == 17 && Pattern.compile("^([A-Fa-f0-9]{2}[-,:]){5}[A-Fa-f0-9]{2}$").matcher(str).matches()) {
            char charAt = str.charAt(0);
            if (charAt == '0' || charAt == 'f' || charAt == 'F') {
                int i = 1;
                while (i < str.length()) {
                    if (str.charAt(i) != charAt) {
                        z = false;
                        break;
                    }
                    if (i < str.length() - 1 && (str.charAt(i + 1) == '-' || str.charAt(i + 1) == ':')) {
                        i++;
                    }
                    i++;
                }
            }
            z = true;
            return !z;
        }
        return false;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00dc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x001f */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.xiaomi.channel.commonutils.file.a */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.xiaomi.channel.commonutils.file.a */
    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.xiaomi.channel.commonutils.file.a */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d1  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        com.xiaomi.channel.commonutils.file.a aVar;
        String str;
        if (!n(context) || f) {
            return null;
        }
        f = true;
        com.xiaomi.channel.commonutils.file.a filesDir = context.getFilesDir();
        String b2 = com.xiaomi.channel.commonutils.file.b.b(new File((File) filesDir, ".vdevid"));
        try {
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/Xiaomi/"), ".vdevid");
                aVar = com.xiaomi.channel.commonutils.file.a.a(context, file);
                try {
                    str = com.xiaomi.channel.commonutils.file.b.b(file);
                    if (aVar != null) {
                        aVar.a();
                    }
                } catch (IOException e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.a("check id failure :" + e.getMessage());
                    if (aVar != null) {
                        aVar.a();
                        str = null;
                    } else {
                        str = null;
                    }
                    filesDir = TextUtils.isEmpty(b2);
                    if (filesDir == 0) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (filesDir != 0) {
                    filesDir.a();
                }
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            aVar = null;
        } catch (Throwable th2) {
            th = th2;
            filesDir = 0;
            if (filesDir != 0) {
            }
            throw th;
        }
        filesDir = TextUtils.isEmpty(b2);
        if (filesDir == 0) {
            com.xiaomi.channel.commonutils.logger.b.a("empty local vid");
            return "F*";
        }
        e = b2;
        if (TextUtils.isEmpty(str) || str.length() > 128) {
            com.xiaomi.channel.commonutils.logger.b.a("recover vid :" + str);
            a(context, b2);
        } else if (!TextUtils.equals(b2, str)) {
            com.xiaomi.channel.commonutils.logger.b.a("vid changed, need sync");
            return str;
        }
        com.xiaomi.channel.commonutils.logger.b.c("vdevid = " + e + HanziToPinyin.Token.SEPARATOR + str);
        return null;
    }

    public static String d(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    public static String e(Context context) {
        int i = 10;
        String f2 = f(context);
        while (f2 == null) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
            }
            f2 = f(context);
            i = i2;
        }
        return f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0064 A[Catch: Throwable -> 0x0067, TRY_LEAVE, TryCatch #0 {Throwable -> 0x0067, blocks: (B:9:0x0012, B:11:0x0018, B:13:0x002a, B:15:0x0036, B:17:0x003a, B:19:0x0045, B:21:0x004b, B:23:0x005a, B:24:0x005e, B:26:0x0064, B:31:0x006e, B:33:0x0074, B:34:0x007f, B:36:0x0086), top: B:41:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0091 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String f(Context context) {
        String str;
        Object a2;
        Object a3;
        if (f.g()) {
            return "";
        }
        if (a != null) {
            return a;
        }
        try {
            String str2 = (!f.a() || (a2 = com.xiaomi.channel.commonutils.reflect.a.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a3 = com.xiaomi.channel.commonutils.reflect.a.a(a2, "getMiuiDeviceId", new Object[0])) == null || !(a3 instanceof String)) ? null : (String) String.class.cast(a3);
            if (str2 == null && p(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (Build.VERSION.SDK_INT < 26) {
                    str = telephonyManager.getDeviceId();
                } else if (1 == telephonyManager.getPhoneType()) {
                    str = (String) com.xiaomi.channel.commonutils.reflect.a.a(telephonyManager, "getImei", (Object[]) null);
                } else if (2 == telephonyManager.getPhoneType()) {
                    str = (String) com.xiaomi.channel.commonutils.reflect.a.a(telephonyManager, "getMeid", (Object[]) null);
                }
                if (a(str)) {
                    return "";
                }
                a = str;
                return str;
            }
            str = str2;
            if (a(str)) {
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    public static String g(Context context) {
        int i = 10;
        String i2 = i(context);
        while (i2 == null) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
            }
            i2 = i(context);
            i = i3;
        }
        return i2;
    }

    public static String h(Context context) {
        if (!f.g() && Build.VERSION.SDK_INT >= 22) {
            if (TextUtils.isEmpty(b)) {
                if (p(context)) {
                    a = f(context);
                    if (TextUtils.isEmpty(a)) {
                        return "";
                    }
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        Integer num = (Integer) com.xiaomi.channel.commonutils.reflect.a.a(telephonyManager, "getPhoneCount", new Object[0]);
                        if (num == null || num.intValue() <= 1) {
                            return "";
                        }
                        String str = null;
                        int i = 0;
                        while (i < num.intValue()) {
                            String str2 = Build.VERSION.SDK_INT < 26 ? (String) com.xiaomi.channel.commonutils.reflect.a.a(telephonyManager, "getDeviceId", Integer.valueOf(i)) : 1 == telephonyManager.getPhoneType() ? (String) com.xiaomi.channel.commonutils.reflect.a.a(telephonyManager, "getImei", Integer.valueOf(i)) : 2 == telephonyManager.getPhoneType() ? (String) com.xiaomi.channel.commonutils.reflect.a.a(telephonyManager, "getMeid", Integer.valueOf(i)) : str;
                            if (!TextUtils.isEmpty(str2) && !TextUtils.equals(a, str2)) {
                                b += str2 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                            }
                            i++;
                            str = str2;
                        }
                        b = b.substring(0, b.length() - 1);
                        return b;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
                        return "";
                    }
                }
                return "";
            }
            return b;
        }
        return "";
    }

    public static String i(Context context) {
        h(context);
        if (TextUtils.isEmpty(b)) {
            return "";
        }
        String str = "";
        for (String str2 : b.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (a(str2)) {
                str = str + com.xiaomi.channel.commonutils.string.d.a(str2) + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    public static ArrayList<String> j(Context context) {
        a = f(context);
        b = h(context);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(a);
        if (TextUtils.isEmpty(b)) {
            return arrayList;
        }
        for (String str : b.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            arrayList.add(str);
        }
        return arrayList;
    }

    public static synchronized String k(Context context) {
        String str;
        synchronized (d.class) {
            if (d != null) {
                str = d;
            } else {
                String d2 = d(context);
                d = com.xiaomi.channel.commonutils.string.d.b(d2 + a());
                str = d;
            }
        }
        return str;
    }

    public static String l(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static String m(Context context) {
        if (f.g()) {
            return "";
        }
        try {
            String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
            return b(macAddress) ? com.xiaomi.channel.commonutils.string.d.g(macAddress) : "";
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    private static boolean n(Context context) {
        if (g.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && !f.a()) {
            boolean z = Build.VERSION.SDK_INT >= 26;
            return !z ? n.b(context) : z;
        }
        return false;
    }

    private static String o(Context context) {
        int i = 10;
        String f2 = f(context);
        while (TextUtils.isEmpty(f2)) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
            }
            f2 = f(context);
            i = i2;
        }
        return f2;
    }

    private static boolean p(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }
}
