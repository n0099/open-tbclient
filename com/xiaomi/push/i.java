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
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes7.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static String f40741a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f40742b = null;

    /* renamed from: c  reason: collision with root package name */
    public static String f40743c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f40744d;

    /* renamed from: e  reason: collision with root package name */
    public static String f40745e;

    /* renamed from: f  reason: collision with root package name */
    public static final String f40746f = String.valueOf((char) 2);

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f614a = {"--", "a-", "u-", "v-", "o-", "g-"};

    /* renamed from: g  reason: collision with root package name */
    public static String f40747g = null;

    /* renamed from: a  reason: collision with other field name */
    public static volatile boolean f613a = false;

    public static double a(double d2) {
        int i = 1;
        while (true) {
            double d3 = i;
            if (d3 >= d2) {
                return d3;
            }
            i <<= 1;
        }
    }

    public static float a(int i) {
        float f2 = ((((((i + LogSystemUploaderStrategy.CrashPadUtil.MAX_READ_BDMP) / 524288) + 1) * 512) * 1024) / 1024.0f) / 1024.0f;
        double d2 = f2;
        return d2 > 0.5d ? (float) Math.ceil(d2) : f2;
    }

    @TargetApi(17)
    public static int a() {
        Object a2;
        if (Build.VERSION.SDK_INT >= 17 && (a2 = bh.a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return ((Integer) Integer.class.cast(a2)).intValue();
        }
        return -1;
    }

    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = (i * 31) + str.charAt(i2);
        }
        return i;
    }

    public static long a(File file) {
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
    public static String m416a() {
        return a(b()) + "GB";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m417a(int i) {
        if (i > 0) {
            String[] strArr = f614a;
            if (i < strArr.length) {
                return strArr[i];
            }
        }
        return f614a[0];
    }

    public static String a(Context context) {
        try {
            return j.a(context).a();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m51a("failure to get gaid:" + e2.getMessage());
            return null;
        }
    }

    public static String a(Context context, boolean z) {
        if (f40744d == null) {
            String e2 = e(context);
            String f2 = !l.d() ? z ? f(context) : o(context) : "";
            String d2 = d(context);
            int i = 1;
            if (!(Build.VERSION.SDK_INT < 26) && b(f2) && b(d2)) {
                String a2 = ax.a(context).a();
                if (TextUtils.isEmpty(a2)) {
                    String n = n(context);
                    if (TextUtils.isEmpty(n)) {
                        String mo130b = ax.a(context).mo130b();
                        if (TextUtils.isEmpty(mo130b)) {
                            i = 5;
                        } else {
                            i = 4;
                            e2 = mo130b;
                        }
                    } else {
                        e2 = n;
                        i = 3;
                    }
                } else {
                    e2 = a2 + e2;
                    i = 2;
                }
            } else {
                e2 = f2 + e2 + d2;
            }
            com.xiaomi.channel.commonutils.logger.b.b("devid rule select:" + i);
            if (i == 3) {
                f40744d = e2;
            } else {
                f40744d = m417a(i) + bm.b(e2);
            }
            b(context, f40744d);
        }
        return f40744d;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static void a(Context context, String str) {
        com.xiaomi.channel.commonutils.logger.b.c("update vdevid = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f40747g = str;
        u uVar = null;
        try {
            try {
                if (m423c(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevid");
                    uVar = u.a(context, file2);
                    y.m623a(file2);
                    y.a(file2, f40747g);
                }
                y.a(new File(context.getFilesDir(), ".vdevid"), f40747g);
                if (uVar == null) {
                    return;
                }
            } catch (IOException unused) {
                com.xiaomi.channel.commonutils.logger.b.m51a("update vdevid failure.");
                if (uVar == null) {
                    return;
                }
            }
            uVar.a();
        } catch (Throwable th) {
            if (uVar != null) {
                uVar.a();
            }
            throw th;
        }
    }

    public static void a(Context context, Map<String, String> map) {
        if (map == null || context == null) {
            return;
        }
        String n = n(context);
        if (TextUtils.isEmpty(n)) {
            return;
        }
        map.put("local_virt_devid", n);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m418a(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            return intExtra == 2 || intExtra == 5;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m419a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = f614a;
            if (i >= strArr.length) {
                return false;
            }
            if (str.startsWith(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    public static int b() {
        BufferedReader bufferedReader;
        Throwable th;
        String[] split;
        if (new File("/proc/meminfo").exists()) {
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                } catch (IOException unused) {
                }
                try {
                    String readLine = bufferedReader.readLine();
                    if (!TextUtils.isEmpty(readLine) && (split = readLine.split("\\s+")) != null && split.length >= 2 && TextUtils.isDigitsOnly(split[1])) {
                        Integer.parseInt(split[1]);
                    }
                    bufferedReader.close();
                } catch (Exception unused2) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused4) {
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        }
        return 0;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m420b() {
        double a2 = a(Environment.getDataDirectory());
        Double.isNaN(a2);
        return a(((a2 / 1024.0d) / 1024.0d) / 1024.0d) + "GB";
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static String b(Context context) {
        u uVar = null;
        if (m423c(context)) {
            if (TextUtils.isEmpty(f40747g)) {
                String a2 = y.a(new File(context.getFilesDir(), ".vdevid"));
                f40747g = a2;
                if (TextUtils.isEmpty(a2)) {
                    try {
                        try {
                            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
                            uVar = u.a(context, file);
                            f40747g = "";
                            String a3 = y.a(file);
                            if (a3 != null) {
                                f40747g = a3;
                            }
                            String str = f40747g;
                            if (uVar != null) {
                                uVar.a();
                            }
                            return str;
                        } catch (IOException unused) {
                            com.xiaomi.channel.commonutils.logger.b.m51a("getVDevID failure.");
                            if (uVar != null) {
                                uVar.a();
                            }
                            return f40747g;
                        }
                    } catch (Throwable th) {
                        if (uVar != null) {
                            uVar.a();
                        }
                        throw th;
                    }
                }
                return f40747g;
            }
            return f40747g;
        }
        return null;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    public static void b(Context context, String str) {
        com.xiaomi.channel.commonutils.logger.b.c("write lvdd = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        u uVar = null;
        try {
            try {
                if (m423c(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/.vdevdir/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevidlocal");
                    if (file2.exists() && file2.isFile()) {
                        com.xiaomi.channel.commonutils.logger.b.b("vdr exists, not rewrite.");
                        return;
                    }
                    uVar = u.a(context, file2);
                    y.m623a(file2);
                    y.a(file2, f40744d + f40746f + a(f40744d));
                    com.xiaomi.channel.commonutils.logger.b.b("lvdd write succ.");
                } else {
                    com.xiaomi.channel.commonutils.logger.b.m51a("not support write lvdd.");
                }
                if (uVar == null) {
                    return;
                }
            } catch (IOException unused) {
                com.xiaomi.channel.commonutils.logger.b.m51a("write lvdd failure.");
                if (0 == 0) {
                    return;
                }
            }
            uVar.a();
        } catch (Throwable th) {
            if (0 != 0) {
                uVar.a();
            }
            throw th;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m421b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    public static boolean b(String str) {
        if (str == null) {
            return true;
        }
        String trim = str.trim();
        return trim.length() == 0 || trim.equalsIgnoreCase(StringUtil.NULL_STRING) || trim.equalsIgnoreCase("unknown");
    }

    public static int c() {
        return Build.VERSION.SDK_INT < 29 ? 10 : 0;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static String m422c() {
        return b() + "KB";
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        u uVar;
        String str;
        u uVar2 = null;
        if (!m423c(context) || f613a) {
            return null;
        }
        f613a = true;
        String a2 = y.a(new File(context.getFilesDir(), ".vdevid"));
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevid");
            uVar = u.a(context, file);
            try {
                try {
                    str = y.a(file);
                    if (uVar != null) {
                        uVar.a();
                    }
                } catch (IOException unused) {
                    com.xiaomi.channel.commonutils.logger.b.m51a("check id failure.");
                    if (uVar != null) {
                        uVar.a();
                    }
                    str = null;
                    if (!TextUtils.isEmpty(a2)) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                uVar2 = uVar;
                if (uVar2 != null) {
                    uVar2.a();
                }
                throw th;
            }
        } catch (IOException unused2) {
            uVar = null;
        } catch (Throwable th2) {
            th = th2;
            if (uVar2 != null) {
            }
            throw th;
        }
        if (!TextUtils.isEmpty(a2)) {
            com.xiaomi.channel.commonutils.logger.b.m51a("empty local vid");
            return "F*";
        }
        f40747g = a2;
        if (TextUtils.isEmpty(str) || str.length() > 128) {
            com.xiaomi.channel.commonutils.logger.b.m51a("recover vid :" + str);
            a(context, a2);
        } else if (!TextUtils.equals(a2, str)) {
            com.xiaomi.channel.commonutils.logger.b.m51a("vid changed, need sync");
            return str;
        }
        com.xiaomi.channel.commonutils.logger.b.c("vdevid = " + f40747g + " " + str);
        return null;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m423c(Context context) {
        if ((Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29) && m.a(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && !l.m516a()) {
            boolean z = Build.VERSION.SDK_INT >= 26;
            return !z ? t.m621a(context) : z;
        }
        return false;
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && bm.m164b(str) && !bm.c(str);
    }

    public static String d() {
        long a2 = a(Environment.getDataDirectory());
        return (a2 / 1024) + "KB";
    }

    public static String d(Context context) {
        if (m424d(context)) {
            int i = Build.VERSION.SDK_INT;
            if (i <= 8 || i >= 26) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return (String) bh.a("android.os.Build", "getSerial", (Object[]) null);
                }
                return null;
            }
            return Build.SERIAL;
        }
        return null;
    }

    /* renamed from: d  reason: collision with other method in class */
    public static boolean m424d(Context context) {
        String packageName = context.getPackageName();
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", packageName) == 0 || context.getPackageManager().checkPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", packageName) == 0;
    }

    public static String e(Context context) {
        String str = f40742b;
        if (str != null) {
            return str;
        }
        try {
            f40742b = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m51a("failure to get androidId: " + th);
        }
        return f40742b;
    }

    public static String f(Context context) {
        int c2 = c();
        String g2 = g(context);
        while (g2 == null) {
            int i = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            g2 = g(context);
            c2 = i;
        }
        return g2;
    }

    public static String g(Context context) {
        String str;
        Object obj;
        Object a2;
        Object a3;
        if (l.d()) {
            return "";
        }
        String str2 = f40741a;
        if (str2 != null) {
            return str2;
        }
        try {
            if (m424d(context)) {
                str = (!l.m516a() || (a2 = bh.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a3 = bh.a(a2, "getMiuiDeviceId", new Object[0])) == null || !(a3 instanceof String)) ? null : (String) String.class.cast(a3);
                if (str == null) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (Build.VERSION.SDK_INT < 26) {
                        str = telephonyManager.getDeviceId();
                    } else {
                        if (1 == telephonyManager.getPhoneType()) {
                            obj = bh.a((Object) telephonyManager, "getImei", (Object[]) null);
                        } else if (2 == telephonyManager.getPhoneType()) {
                            obj = bh.a((Object) telephonyManager, "getMeid", (Object[]) null);
                        }
                        str = (String) obj;
                    }
                }
            } else {
                str = null;
            }
            if (c(str)) {
                f40741a = str;
                return str;
            }
            return "";
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.m51a("failure to get id:" + th);
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
            } catch (InterruptedException unused) {
            }
            j = j(context);
            c2 = i;
        }
        return j;
    }

    public static String i(Context context) {
        Object a2;
        if (!l.d() && Build.VERSION.SDK_INT >= 22) {
            if (TextUtils.isEmpty(f40743c)) {
                g(context);
                if (TextUtils.isEmpty(f40741a)) {
                    return "";
                }
                try {
                    if (m424d(context)) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        Integer num = (Integer) bh.a((Object) telephonyManager, "getPhoneCount", new Object[0]);
                        if (num != null && num.intValue() > 1) {
                            String str = null;
                            for (int i = 0; i < num.intValue(); i++) {
                                if (Build.VERSION.SDK_INT < 26) {
                                    a2 = bh.a((Object) telephonyManager, "getDeviceId", Integer.valueOf(i));
                                } else if (1 == telephonyManager.getPhoneType()) {
                                    a2 = bh.a((Object) telephonyManager, "getImei", Integer.valueOf(i));
                                } else {
                                    if (2 == telephonyManager.getPhoneType()) {
                                        a2 = bh.a((Object) telephonyManager, "getMeid", Integer.valueOf(i));
                                    }
                                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(f40741a, str) && c(str)) {
                                        f40743c += str + ",";
                                    }
                                }
                                str = (String) a2;
                                if (!TextUtils.isEmpty(str)) {
                                    f40743c += str + ",";
                                }
                            }
                            int length = f40743c.length();
                            if (length > 0) {
                                f40743c = f40743c.substring(0, length - 1);
                            }
                            return f40743c;
                        }
                    }
                    return "";
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m51a("failure to get ids: " + e2);
                    return "";
                }
            }
            return f40743c;
        }
        return "";
    }

    public static String j(Context context) {
        i(context);
        String str = "";
        if (TextUtils.isEmpty(f40743c)) {
            return "";
        }
        for (String str2 : f40743c.split(",")) {
            if (c(str2)) {
                str = str + bm.a(str2) + ",";
            }
        }
        int length = str.length();
        return length > 0 ? str.substring(0, length - 1) : str;
    }

    public static synchronized String k(Context context) {
        synchronized (i.class) {
            if (f40745e != null) {
                return f40745e;
            }
            String e2 = e(context);
            String d2 = d(context);
            String b2 = bm.b(e2 + d2);
            f40745e = b2;
            return b2;
        }
    }

    public static synchronized String l(Context context) {
        String b2;
        synchronized (i.class) {
            String e2 = e(context);
            b2 = bm.b(e2 + ((String) null));
        }
        return b2;
    }

    public static String m(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getSimOperatorName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
        if (r1 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
        r1.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0081, code lost:
        if (r1 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0084, code lost:
        return r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(Context context) {
        String str;
        u uVar = null;
        r1 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        String str2 = null;
        uVar = null;
        u uVar2 = null;
        if (!m423c(context)) {
            com.xiaomi.channel.commonutils.logger.b.m51a("not support read lvdd.");
            return null;
        }
        try {
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/.vdevdir/"), ".vdevidlocal");
                if (file.exists() && file.isFile()) {
                    u a2 = u.a(context, file);
                    try {
                        try {
                            String a3 = y.a(file);
                            if (!TextUtils.isEmpty(a3)) {
                                String[] split = a3.split(f40746f);
                                if (split.length == 2) {
                                    String str3 = split[0];
                                    try {
                                        if (a(str3) == Integer.parseInt(split[1])) {
                                            str2 = str3;
                                        }
                                    } catch (Exception unused) {
                                    }
                                }
                            }
                            if (TextUtils.isEmpty(str2)) {
                                y.m623a(file);
                                com.xiaomi.channel.commonutils.logger.b.b("lvdd content invalid, remove it.");
                            }
                            String str4 = str2;
                            uVar = a2;
                            str = str4;
                        } catch (IOException unused2) {
                            String str5 = str2;
                            uVar = a2;
                            str = str5;
                            com.xiaomi.channel.commonutils.logger.b.m51a("get lvdd failure.");
                        }
                    } catch (Throwable th) {
                        th = th;
                        uVar2 = a2;
                        if (uVar2 != null) {
                            uVar2.a();
                        }
                        throw th;
                    }
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("lvdf not exists");
                    str = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused3) {
            str = null;
        }
    }

    public static String o(Context context) {
        int c2 = c();
        String g2 = g(context);
        while (TextUtils.isEmpty(g2)) {
            int i = c2 - 1;
            if (c2 <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            g2 = g(context);
            c2 = i;
        }
        return g2;
    }
}
