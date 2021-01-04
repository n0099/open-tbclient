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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes6.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f14417a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f14418b = "";
    private static String c = null;
    private static String d = null;
    private static final String e = String.valueOf((char) 2);

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f601a = {"--", "a-", "u-", "v-", "o-", "g-"};
    private static String f = null;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f600a = false;

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
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = str.charAt(i2) + (i * 31);
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
    public static String m407a() {
        if (Build.VERSION.SDK_INT <= 8 || Build.VERSION.SDK_INT >= 26) {
            if (Build.VERSION.SDK_INT >= 26) {
                return (String) ba.a("android.os.Build", "getSerial", (Object[]) null);
            }
            return null;
        }
        return Build.SERIAL;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m408a(int i) {
        return (i <= 0 || i >= f601a.length) ? f601a[0] : f601a[i];
    }

    public static String a(Context context) {
        return "a-" + bf.b(((String) null) + e(context) + ((String) null));
    }

    public static String a(Context context, boolean z) {
        int i;
        if (c == null) {
            String e2 = e(context);
            switch (1) {
                case 1:
                    String f2 = l.d() ? "" : z ? f(context) : p(context);
                    String m407a = m407a();
                    if ((Build.VERSION.SDK_INT < 26) || !TextUtils.isEmpty(f2) || !TextUtils.isEmpty(m407a)) {
                        e2 = f2 + e2 + m407a;
                        i = 1;
                        break;
                    }
                    break;
                case 2:
                    String a2 = au.a(context).a();
                    if (!TextUtils.isEmpty(a2)) {
                        String str = a2 + e2;
                        i = 2;
                        e2 = str;
                        break;
                    }
                case 3:
                    String o = o(context);
                    if (!TextUtils.isEmpty(o)) {
                        i = 3;
                        e2 = o;
                        break;
                    }
                case 4:
                    String mo154b = au.a(context).mo154b();
                    if (!TextUtils.isEmpty(mo154b)) {
                        i = 4;
                        e2 = mo154b;
                        break;
                    }
                case 5:
                    i = 5;
                    break;
                default:
                    i = 1;
                    e2 = "";
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.b("devid rule select:" + i);
            if (i == 3) {
                c = e2;
            } else {
                c = m408a(i) + bf.b(e2);
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
                if (m414c(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevid");
                    uVar = u.a(context, file2);
                    y.m608a(file2);
                    y.a(file2, f);
                }
                y.a(new File(context.getFilesDir(), ".vdevid"), f);
                if (uVar != null) {
                    uVar.a();
                }
            } catch (IOException e2) {
                com.xiaomi.channel.commonutils.logger.b.m73a("update vdevid failure :" + e2.getMessage());
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
    public static boolean m409a(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m410a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < f601a.length; i++) {
            if (str.startsWith(f601a[i])) {
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
    public static String m411b() {
        return a(b()) + "GB";
    }

    public static String b(Context context) {
        try {
            return j.a(context).a();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m73a("failure to get gaid:" + e2.getMessage());
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
                if (m414c(context)) {
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
                    y.m608a(file2);
                    y.a(file2, c + e + a(c));
                    com.xiaomi.channel.commonutils.logger.b.b("lvdd write succ.");
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m73a("not support write lvdd.");
                }
                if (uVar != null) {
                    uVar.a();
                }
            } catch (IOException e2) {
                com.xiaomi.channel.commonutils.logger.b.m73a("write lvdd failure :" + e2.getMessage());
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
    public static boolean m412b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    private static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && bf.m184b(str) && !bf.c(str);
    }

    private static int c() {
        return Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static String m413c() {
        return a(((a(Environment.getDataDirectory()) / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.xiaomi.push.u */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: com.xiaomi.push.u */
    /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.xiaomi.push.u */
    /* JADX WARN: Multi-variable type inference failed */
    public static String c(Context context) {
        Throwable th;
        u uVar;
        u uVar2;
        if (!m414c(context)) {
            return null;
        }
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        File filesDir = context.getFilesDir();
        f = y.a(new File(filesDir, ".vdevid"));
        try {
            if (!TextUtils.isEmpty(f)) {
                return f;
            }
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
                uVar2 = u.a(context, file);
                try {
                    f = "";
                    String a2 = y.a(file);
                    if (a2 != null) {
                        f = a2;
                    }
                    String str = f;
                    if (uVar2 != null) {
                        uVar2.a();
                        return str;
                    }
                    return str;
                } catch (IOException e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.m73a("getVDevID failure :" + e.getMessage());
                    if (uVar2 != null) {
                        uVar2.a();
                    }
                    return f;
                }
            } catch (IOException e3) {
                e = e3;
                uVar2 = null;
            } catch (Throwable th2) {
                th = th2;
                uVar = 0;
                if (uVar != 0) {
                    uVar.a();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            uVar = filesDir;
        }
    }

    /* renamed from: c  reason: collision with other method in class */
    private static boolean m414c(Context context) {
        if (m.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && !l.m519a()) {
            boolean z = Build.VERSION.SDK_INT >= 26;
            return !z ? t.m606a(context) : z;
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
        if (!m414c(context) || f600a) {
            return null;
        }
        f600a = true;
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
                    com.xiaomi.channel.commonutils.logger.b.m73a("check id failure :" + e.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m73a("empty local vid");
            return "F*";
        }
        f = a2;
        if (TextUtils.isEmpty(str) || str.length() > 128) {
            com.xiaomi.channel.commonutils.logger.b.m73a("recover vid :" + str);
            a(context, a2);
        } else if (!TextUtils.equals(a2, str)) {
            com.xiaomi.channel.commonutils.logger.b.m73a("vid changed, need sync");
            return str;
        }
        com.xiaomi.channel.commonutils.logger.b.c("vdevid = " + f + " " + str);
        return null;
    }

    /* renamed from: d  reason: collision with other method in class */
    private static boolean m415d(Context context) {
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
        if (f14417a != null) {
            return f14417a;
        }
        try {
            String str2 = (!l.m519a() || (a2 = ba.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a3 = ba.a(a2, "getMiuiDeviceId", new Object[0])) == null || !(a3 instanceof String)) ? null : (String) String.class.cast(a3);
            if (str2 == null && m415d(context)) {
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
                f14417a = str;
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
            if (TextUtils.isEmpty(f14418b)) {
                if (m415d(context)) {
                    g(context);
                    if (TextUtils.isEmpty(f14417a)) {
                        return "";
                    }
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        Integer num = (Integer) ba.a(telephonyManager, "getPhoneCount", new Object[0]);
                        if (num == null || num.intValue() <= 1) {
                            return "";
                        }
                        String str = null;
                        for (int i = 0; i < num.intValue(); i++) {
                            if (Build.VERSION.SDK_INT < 26) {
                                str = (String) ba.a(telephonyManager, "getDeviceId", Integer.valueOf(i));
                            } else if (1 == telephonyManager.getPhoneType()) {
                                str = (String) ba.a(telephonyManager, "getImei", Integer.valueOf(i));
                            } else if (2 == telephonyManager.getPhoneType()) {
                                str = (String) ba.a(telephonyManager, "getMeid", Integer.valueOf(i));
                            }
                            if (!TextUtils.isEmpty(str) && !TextUtils.equals(f14417a, str) && b(str)) {
                                f14418b += str + ",";
                            }
                        }
                        int length = f14418b.length();
                        if (length > 0) {
                            f14418b = f14418b.substring(0, length - 1);
                        }
                        return f14418b;
                    } catch (Exception e2) {
                        com.xiaomi.channel.commonutils.logger.b.d(e2.toString());
                        return "";
                    }
                }
                return "";
            }
            return f14418b;
        }
        return "";
    }

    public static String j(Context context) {
        i(context);
        if (TextUtils.isEmpty(f14418b)) {
            return "";
        }
        String str = "";
        for (String str2 : f14418b.split(",")) {
            if (b(str2)) {
                str = str + bf.a(str2) + ",";
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
                d = bf.b(e2 + m407a());
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        if (a(r0) == java.lang.Integer.parseInt(r4[1])) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String o(Context context) {
        u uVar;
        String str;
        if (!m414c(context)) {
            com.xiaomi.channel.commonutils.logger.b.m73a("not support read lvdd.");
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
                                str = split[0];
                                try {
                                } catch (Exception e2) {
                                    str = null;
                                }
                            }
                        }
                        str = null;
                        try {
                            if (TextUtils.isEmpty(str)) {
                                y.m608a(file);
                                com.xiaomi.channel.commonutils.logger.b.b("lvdd content invalid, remove it.");
                            }
                        } catch (IOException e3) {
                            e = e3;
                            com.xiaomi.channel.commonutils.logger.b.m73a("get lvdd failure :" + e.getMessage());
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
                } catch (IOException e4) {
                    e = e4;
                    str = null;
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
            e = e5;
            uVar = null;
            str = null;
        } catch (Throwable th2) {
            th = th2;
            uVar = null;
            if (uVar != null) {
            }
            throw th;
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
