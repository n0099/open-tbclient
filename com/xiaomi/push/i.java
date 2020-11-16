package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes18.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f4969a = null;
    private static String b = "";
    private static String c = null;
    private static String d = null;
    private static final String e = String.valueOf((char) 2);

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f525a = {"--", "a-", "u-", "v-", "o-", "g-"};
    private static String f = null;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f524a = false;

    private static double a(double d2) {
        int i = 1;
        while (i < d2) {
            i <<= 1;
        }
        return i;
    }

    private static float a(int i) {
        float f2 = ((((((BdStatsConstant.MAX_WRITE_LOG_SIZE + i) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        return ((double) f2) > 0.5d ? (float) Math.ceil(f2) : f2;
    }

    @TargetApi(17)
    public static int a() {
        Object a2;
        if (Build.VERSION.SDK_INT >= 17 && (a2 = ba.a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return ((Integer) Integer.class.cast(a2)).intValue();
        }
        return -1;
    }

    private static int a(String str) {
        int i = 0;
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            int i2 = 0;
            while (i2 < length) {
                i2++;
                i = str.charAt(i2) + (i * 31);
            }
        }
        return i;
    }

    private static long a(File file) {
        long blockCount;
        long blockSize;
        StatFs statFs = new StatFs(file.getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            blockCount = statFs.getBlockCountLong();
            blockSize = statFs.getBlockSizeLong();
        } else {
            blockCount = statFs.getBlockCount();
            blockSize = statFs.getBlockSize();
        }
        return blockSize * blockCount;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m391a() {
        if (Build.VERSION.SDK_INT <= 8 || Build.VERSION.SDK_INT >= 26) {
            if (Build.VERSION.SDK_INT >= 26) {
                return (String) ba.a("android.os.Build", "getSerial", (Object[]) null);
            }
            return null;
        }
        return Build.SERIAL;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m392a(int i) {
        return (i <= 0 || i >= f525a.length) ? f525a[0] : f525a[i];
    }

    public static String a(Context context) {
        return "a-" + bf.b(((String) null) + e(context) + ((String) null));
    }

    public static String a(Context context, boolean z) {
        int i;
        String str;
        if (c == null) {
            String e2 = e(context);
            switch (1) {
                case 1:
                    String f2 = l.d() ? "" : z ? f(context) : p(context);
                    String m391a = m391a();
                    if ((Build.VERSION.SDK_INT < 26) || !TextUtils.isEmpty(f2) || !TextUtils.isEmpty(m391a)) {
                        str = f2 + e2 + m391a;
                        i = 1;
                        break;
                    }
                    break;
                case 2:
                    String a2 = au.a(context).a();
                    if (!TextUtils.isEmpty(a2)) {
                        str = a2 + e2;
                        i = 2;
                        break;
                    }
                case 3:
                    String o = o(context);
                    if (!TextUtils.isEmpty(o)) {
                        str = o;
                        i = 3;
                        break;
                    }
                case 4:
                    str = au.a(context).mo138b();
                    if (!TextUtils.isEmpty(str)) {
                        i = 4;
                        break;
                    }
                case 5:
                    i = 5;
                    str = e2;
                    break;
                default:
                    str = "";
                    i = 1;
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.b("devid rule select:" + i);
            if (i == 3) {
                c = str;
            } else {
                c = m392a(i) + bf.b(str);
            }
            b(context, c);
        }
        return c;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static void a(Context context, String str) {
        com.xiaomi.channel.commonutils.logger.b.c("update vdevid = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f = str;
        u uVar = null;
        try {
            try {
                if (m398c(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevid");
                    uVar = u.a(context, file2);
                    y.m592a(file2);
                    y.a(file2, f);
                }
                y.a(new File(context.getFilesDir(), ".vdevid"), f);
                if (uVar != null) {
                    uVar.a();
                }
            } catch (IOException e2) {
                com.xiaomi.channel.commonutils.logger.b.m57a("update vdevid failure :" + e2.getMessage());
                if (uVar != null) {
                    uVar.a();
                }
            }
        } catch (Throwable th) {
            if (uVar != null) {
                uVar.a();
            }
            throw th;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m393a(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m394a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < f525a.length; i++) {
            if (str.startsWith(f525a[i])) {
                return true;
            }
        }
        return false;
    }

    public static int b() {
        BufferedReader bufferedReader;
        String[] split;
        int i = 0;
        if (new File("/proc/meminfo").exists()) {
            try {
                bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            } catch (Exception e2) {
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                    i = Integer.parseInt(split[1]);
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Exception e4) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e5) {
                    }
                }
                return i;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        }
        return i;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m395b() {
        return a(b()) + "GB";
    }

    public static String b(Context context) {
        try {
            return j.a(context).a();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m57a("failure to get gaid:" + e2.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    private static void b(Context context, String str) {
        com.xiaomi.channel.commonutils.logger.b.c("write lvdd = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u uVar = null;
        try {
            try {
                if (m398c(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevidlocal");
                    if (file2.exists() && file2.isFile()) {
                        com.xiaomi.channel.commonutils.logger.b.b("vdr exists, not rewrite.");
                        if (0 != 0) {
                            uVar.a();
                            return;
                        }
                        return;
                    }
                    uVar = u.a(context, file2);
                    y.m592a(file2);
                    y.a(file2, c + e + a(c));
                    com.xiaomi.channel.commonutils.logger.b.b("lvdd write succ.");
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m57a("not support write lvdd.");
                }
                if (uVar != null) {
                    uVar.a();
                }
            } catch (IOException e2) {
                com.xiaomi.channel.commonutils.logger.b.m57a("write lvdd failure :" + e2.getMessage());
                if (0 != 0) {
                    uVar.a();
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                uVar.a();
            }
            throw th;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m396b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    private static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && bf.m168b(str) && !bf.c(str);
    }

    private static int c() {
        return Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static String m397c() {
        return a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        u uVar;
        Throwable th;
        IOException e2;
        if (!m398c(context)) {
            return null;
        }
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        f = y.a(new File(context.getFilesDir(), ".vdevid"));
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
            uVar = u.a(context, file);
            try {
                try {
                    f = "";
                    String a2 = y.a(file);
                    if (a2 != null) {
                        f = a2;
                    }
                    String str = f;
                    if (uVar != null) {
                        uVar.a();
                        return str;
                    }
                    return str;
                } catch (IOException e3) {
                    e2 = e3;
                    com.xiaomi.channel.commonutils.logger.b.m57a("getVDevID failure :" + e2.getMessage());
                    if (uVar != null) {
                        uVar.a();
                    }
                    return f;
                }
            } catch (Throwable th2) {
                th = th2;
                if (uVar != null) {
                    uVar.a();
                }
                throw th;
            }
        } catch (IOException e4) {
            uVar = null;
            e2 = e4;
        } catch (Throwable th3) {
            uVar = null;
            th = th3;
            if (uVar != null) {
            }
            throw th;
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private static boolean m398c(Context context) {
        if (m.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && !l.m503a()) {
            boolean z = Build.VERSION.SDK_INT >= 26;
            return !z ? t.m590a(context) : z;
        }
        return false;
    }

    public static String d() {
        return b() + "KB";
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x00dc */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:39:0x001f */
    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.xiaomi.push.u */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.xiaomi.push.u */
    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.xiaomi.push.u */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d1  */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(Context context) {
        u uVar;
        String str;
        if (!m398c(context) || f524a) {
            return null;
        }
        f524a = true;
        u filesDir = context.getFilesDir();
        String a2 = y.a(new File((File) filesDir, ".vdevid"));
        try {
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
                uVar = u.a(context, file);
                try {
                    str = y.a(file);
                    if (uVar != null) {
                        uVar.a();
                    }
                } catch (IOException e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.m57a("check id failure :" + e.getMessage());
                    if (uVar != null) {
                        uVar.a();
                        str = null;
                    } else {
                        str = null;
                    }
                    filesDir = TextUtils.isEmpty(a2);
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
            uVar = null;
        } catch (Throwable th2) {
            th = th2;
            filesDir = 0;
            if (filesDir != 0) {
            }
            throw th;
        }
        filesDir = TextUtils.isEmpty(a2);
        if (filesDir == 0) {
            com.xiaomi.channel.commonutils.logger.b.m57a("empty local vid");
            return "F*";
        }
        f = a2;
        if (TextUtils.isEmpty(str) || str.length() > 128) {
            com.xiaomi.channel.commonutils.logger.b.m57a("recover vid :" + str);
            a(context, a2);
        } else if (!TextUtils.equals(a2, str)) {
            com.xiaomi.channel.commonutils.logger.b.m57a("vid changed, need sync");
            return str;
        }
        com.xiaomi.channel.commonutils.logger.b.c("vdevid = " + f + " " + str);
        return null;
    }

    /* renamed from: d  reason: collision with other method in class */
    private static boolean m399d(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    public static String e() {
        return (a(Environment.getDataDirectory()) / 1024) + "KB";
    }

    public static String e(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    public static String f(Context context) {
        int c2 = c();
        String g = g(context);
        while (g == null) {
            int i = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
            }
            g = g(context);
            c2 = i;
        }
        return g;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0064 A[Catch: Throwable -> 0x0067, TRY_LEAVE, TryCatch #0 {Throwable -> 0x0067, blocks: (B:9:0x0012, B:11:0x0018, B:13:0x002a, B:15:0x0036, B:17:0x003a, B:19:0x0045, B:21:0x004b, B:23:0x005a, B:24:0x005e, B:26:0x0064, B:31:0x006e, B:33:0x0074, B:34:0x0081, B:36:0x0088), top: B:41:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0095 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String g(Context context) {
        String str;
        Object a2;
        Object a3;
        if (l.d()) {
            return "";
        }
        if (f4969a != null) {
            return f4969a;
        }
        try {
            String str2 = (!l.m503a() || (a2 = ba.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a3 = ba.a(a2, "getMiuiDeviceId", new Object[0])) == null || !(a3 instanceof String)) ? null : (String) String.class.cast(a3);
            if (str2 == null && m399d(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (Build.VERSION.SDK_INT < 26) {
                    str = telephonyManager.getDeviceId();
                } else if (1 == telephonyManager.getPhoneType()) {
                    str = (String) ba.a(telephonyManager, "getImei", (Object[]) null);
                } else if (2 == telephonyManager.getPhoneType()) {
                    str = (String) ba.a(telephonyManager, "getMeid", (Object[]) null);
                }
                if (b(str)) {
                    return "";
                }
                f4969a = str;
                return str;
            }
            str = str2;
            if (b(str)) {
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
            return null;
        }
    }

    public static String h(Context context) {
        int c2 = c();
        String j = j(context);
        while (j == null) {
            int i = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
            }
            j = j(context);
            c2 = i;
        }
        return j;
    }

    public static String i(Context context) {
        if (!l.d() && Build.VERSION.SDK_INT >= 22) {
            if (TextUtils.isEmpty(b)) {
                if (m399d(context)) {
                    g(context);
                    if (TextUtils.isEmpty(f4969a)) {
                        return "";
                    }
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        Integer num = (Integer) ba.a(telephonyManager, "getPhoneCount", new Object[0]);
                        if (num == null || num.intValue() <= 1) {
                            return "";
                        }
                        String str = null;
                        int i = 0;
                        while (i < num.intValue()) {
                            String str2 = Build.VERSION.SDK_INT < 26 ? (String) ba.a(telephonyManager, "getDeviceId", Integer.valueOf(i)) : 1 == telephonyManager.getPhoneType() ? (String) ba.a(telephonyManager, "getImei", Integer.valueOf(i)) : 2 == telephonyManager.getPhoneType() ? (String) ba.a(telephonyManager, "getMeid", Integer.valueOf(i)) : str;
                            if (!TextUtils.isEmpty(str2) && !TextUtils.equals(f4969a, str2) && b(str2)) {
                                b += str2 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                            }
                            i++;
                            str = str2;
                        }
                        int length = b.length();
                        if (length > 0) {
                            b = b.substring(0, length - 1);
                        }
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

    public static String j(Context context) {
        i(context);
        if (TextUtils.isEmpty(b)) {
            return "";
        }
        String str = "";
        for (String str2 : b.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (b(str2)) {
                str = str + bf.a(str2) + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    public static synchronized String k(Context context) {
        String str;
        synchronized (i.class) {
            if (d != null) {
                str = d;
            } else {
                String e2 = e(context);
                d = bf.b(e2 + m391a());
                str = d;
            }
        }
        return str;
    }

    public static synchronized String l(Context context) {
        String b2;
        synchronized (i.class) {
            b2 = bf.b(e(context) + ((String) null));
        }
        return b2;
    }

    public static String m(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    public static String n(Context context) {
        return "";
    }

    private static String o(Context context) {
        u uVar;
        String str;
        IOException iOException;
        String str2 = null;
        if (!m398c(context)) {
            com.xiaomi.channel.commonutils.logger.b.m57a("not support read lvdd.");
            return null;
        }
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevidlocal");
            if (file.exists() && file.isFile()) {
                uVar = u.a(context, file);
                try {
                    try {
                        String a2 = y.a(file);
                        if (!TextUtils.isEmpty(a2)) {
                            String[] split = a2.split(e);
                            if (split.length == 2) {
                                String str3 = split[0];
                                try {
                                    if (a(str3) != Integer.parseInt(split[1])) {
                                        str3 = null;
                                    }
                                    str2 = str3;
                                } catch (Exception e2) {
                                }
                            }
                        }
                    } catch (IOException e3) {
                        str = null;
                        iOException = e3;
                    }
                    try {
                        if (TextUtils.isEmpty(str2)) {
                            y.m592a(file);
                            com.xiaomi.channel.commonutils.logger.b.b("lvdd content invalid, remove it.");
                        }
                        str = str2;
                    } catch (IOException e4) {
                        str = str2;
                        iOException = e4;
                        com.xiaomi.channel.commonutils.logger.b.m57a("get lvdd failure :" + iOException.getMessage());
                        if (uVar != null) {
                            uVar.a();
                        }
                        return str;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (uVar != null) {
                        uVar.a();
                    }
                    throw th;
                }
            } else {
                com.xiaomi.channel.commonutils.logger.b.b("lvdf not exists");
                uVar = null;
                str = null;
            }
            if (uVar != null) {
                uVar.a();
            }
        } catch (IOException e5) {
            uVar = null;
            str = null;
            iOException = e5;
        } catch (Throwable th2) {
            th = th2;
            uVar = null;
        }
        return str;
    }

    private static String p(Context context) {
        int c2 = c();
        String g = g(context);
        while (TextUtils.isEmpty(g)) {
            int i = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
            }
            g = g(context);
            c2 = i;
        }
        return g;
    }
}
