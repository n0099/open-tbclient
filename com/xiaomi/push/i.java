package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class i {
    private static String a = null;
    private static String b = "";
    private static String c = null;
    private static String d = null;
    private static String e = null;

    /* renamed from: a  reason: collision with other field name */
    private static volatile boolean f584a = false;

    @TargetApi(17)
    public static int a() {
        Object a2;
        if (Build.VERSION.SDK_INT >= 17 && (a2 = at.a("android.os.UserHandle", "myUserId", new Object[0])) != null) {
            return ((Integer) Integer.class.cast(a2)).intValue();
        }
        return -1;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m372a() {
        if (Build.VERSION.SDK_INT <= 8 || Build.VERSION.SDK_INT >= 26) {
            if (Build.VERSION.SDK_INT >= 26) {
                return (String) at.a("android.os.Build", "getSerial", (Object[]) null);
            }
            return null;
        }
        return Build.SERIAL;
    }

    public static String a(Context context) {
        return "a-" + ay.b(((String) null) + e(context) + ((String) null));
    }

    public static String a(Context context, boolean z) {
        if (c == null) {
            c = "a-" + ay.b((l.d() ? "" : z ? f(context) : o(context)) + e(context) + m372a());
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
        u uVar = null;
        try {
            try {
                if (m373a(context)) {
                    File file = new File(Environment.getExternalStorageDirectory(), "/Xiaomi/");
                    if (file.exists() && file.isFile()) {
                        file.delete();
                    }
                    File file2 = new File(file, ".vdevid");
                    uVar = u.a(context, file2);
                    y.m550a(file2);
                    y.a(file2, e);
                }
                y.a(new File(context.getFilesDir(), ".vdevid"), e);
                if (uVar != null) {
                    uVar.a();
                }
            } catch (IOException e2) {
                com.xiaomi.channel.commonutils.logger.b.m30a("update vdevid failure :" + e2.getMessage());
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
    private static boolean m373a(Context context) {
        if (m.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") && !l.m466a()) {
            boolean z = Build.VERSION.SDK_INT >= 26;
            return !z ? t.m548a(context) : z;
        }
        return false;
    }

    private static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 15 && str.length() >= 14 && ay.m125b(str) && !ay.c(str);
    }

    public static String b(Context context) {
        try {
            return j.a(context).a();
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.m30a("failure to get gaid:" + e2.getMessage());
            return null;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private static boolean m374b(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(Context context) {
        u uVar;
        Throwable th;
        IOException e2;
        if (!m373a(context)) {
            return null;
        }
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        e = y.a(new File(context.getFilesDir(), ".vdevid"));
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            File file = new File(new File(Environment.getExternalStorageDirectory(), "/Xiaomi/"), ".vdevid");
            uVar = u.a(context, file);
            try {
                try {
                    e = "";
                    String a2 = y.a(file);
                    if (a2 != null) {
                        e = a2;
                    }
                    String str = e;
                    if (uVar != null) {
                        uVar.a();
                        return str;
                    }
                    return str;
                } catch (IOException e3) {
                    e2 = e3;
                    com.xiaomi.channel.commonutils.logger.b.m30a("getVDevID failure :" + e2.getMessage());
                    if (uVar != null) {
                        uVar.a();
                    }
                    return e;
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
        if (!m373a(context) || f584a) {
            return null;
        }
        f584a = true;
        u filesDir = context.getFilesDir();
        String a2 = y.a(new File((File) filesDir, ".vdevid"));
        try {
            try {
                File file = new File(new File(Environment.getExternalStorageDirectory(), "/Xiaomi/"), ".vdevid");
                uVar = u.a(context, file);
                try {
                    str = y.a(file);
                    if (uVar != null) {
                        uVar.a();
                    }
                } catch (IOException e2) {
                    e = e2;
                    com.xiaomi.channel.commonutils.logger.b.m30a("check id failure :" + e.getMessage());
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
            com.xiaomi.channel.commonutils.logger.b.m30a("empty local vid");
            return "F*";
        }
        e = a2;
        if (TextUtils.isEmpty(str) || str.length() > 128) {
            com.xiaomi.channel.commonutils.logger.b.m30a("recover vid :" + str);
            a(context, a2);
        } else if (!TextUtils.equals(a2, str)) {
            com.xiaomi.channel.commonutils.logger.b.m30a("vid changed, need sync");
            return str;
        }
        com.xiaomi.channel.commonutils.logger.b.c("vdevid = " + e + HanziToPinyin.Token.SEPARATOR + str);
        return null;
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
        int i = 10;
        String g = g(context);
        while (g == null) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
            }
            g = g(context);
            i = i2;
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
        if (a != null) {
            return a;
        }
        try {
            String str2 = (!l.m466a() || (a2 = at.a("miui.telephony.TelephonyManager", "getDefault", new Object[0])) == null || (a3 = at.a(a2, "getMiuiDeviceId", new Object[0])) == null || !(a3 instanceof String)) ? null : (String) String.class.cast(a3);
            if (str2 == null && m374b(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (Build.VERSION.SDK_INT < 26) {
                    str = telephonyManager.getDeviceId();
                } else if (1 == telephonyManager.getPhoneType()) {
                    str = (String) at.a(telephonyManager, "getImei", (Object[]) null);
                } else if (2 == telephonyManager.getPhoneType()) {
                    str = (String) at.a(telephonyManager, "getMeid", (Object[]) null);
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

    public static String h(Context context) {
        int i = 10;
        String j = j(context);
        while (j == null) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
            }
            j = j(context);
            i = i2;
        }
        return j;
    }

    public static String i(Context context) {
        if (!l.d() && Build.VERSION.SDK_INT >= 22) {
            if (TextUtils.isEmpty(b)) {
                if (m374b(context)) {
                    g(context);
                    if (TextUtils.isEmpty(a)) {
                        return "";
                    }
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        Integer num = (Integer) at.a(telephonyManager, "getPhoneCount", new Object[0]);
                        if (num == null || num.intValue() <= 1) {
                            return "";
                        }
                        String str = null;
                        int i = 0;
                        while (i < num.intValue()) {
                            String str2 = Build.VERSION.SDK_INT < 26 ? (String) at.a(telephonyManager, "getDeviceId", Integer.valueOf(i)) : 1 == telephonyManager.getPhoneType() ? (String) at.a(telephonyManager, "getImei", Integer.valueOf(i)) : 2 == telephonyManager.getPhoneType() ? (String) at.a(telephonyManager, "getMeid", Integer.valueOf(i)) : str;
                            if (!TextUtils.isEmpty(str2) && !TextUtils.equals(a, str2) && a(str2)) {
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
            if (a(str2)) {
                str = str + ay.a(str2) + Constants.ACCEPT_TIME_SEPARATOR_SP;
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
                d = ay.b(e2 + m372a());
                str = d;
            }
        }
        return str;
    }

    public static synchronized String l(Context context) {
        String b2;
        synchronized (i.class) {
            b2 = ay.b(e(context) + ((String) null));
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
        int i = 10;
        String g = g(context);
        while (TextUtils.isEmpty(g)) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e2) {
            }
            g = g(context);
            i = i2;
        }
        return g;
    }
}
