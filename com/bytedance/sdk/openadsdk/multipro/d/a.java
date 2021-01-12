package com.bytedance.sdk.openadsdk.multipro.d;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f7409a;

    public static boolean a() {
        if (f7409a == null || p.a() == null) {
            u.b("The context of SPHelper is null, please initialize sdk in main process");
            return false;
        }
        return true;
    }

    private static ContentResolver b() {
        try {
            if (a()) {
                return c().getContentResolver();
            }
        } catch (Throwable th) {
        }
        return null;
    }

    public static void a(Context context) {
        f7409a = context == null ? p.a() : context.getApplicationContext();
    }

    private static Context c() {
        return f7409a == null ? p.a() : f7409a;
    }

    private static String d() {
        return e.f7413b + "/t_sp/";
    }

    private static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : "?sp_file_name=" + str;
    }

    public static synchronized void a(String str, String str2, Boolean bool) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        Uri parse = Uri.parse(d() + "boolean/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", bool);
                        b2.update(parse, contentValues, null, null);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2) {
        synchronized (a.class) {
            a((String) null, str, str2);
        }
    }

    public static synchronized void a(String str, String str2, String str3) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        Uri parse = Uri.parse(d() + "string/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", str3);
                        b2.update(parse, contentValues, null, null);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static synchronized void a(String str, Integer num) {
        synchronized (a.class) {
            a((String) null, str, num);
        }
    }

    public static synchronized void a(String str, String str2, Integer num) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        Uri parse = Uri.parse(d() + "int/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", num);
                        b2.update(parse, contentValues, null, null);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static synchronized void a(String str, Long l) {
        synchronized (a.class) {
            a((String) null, str, l);
        }
    }

    public static synchronized void a(String str, String str2, Long l) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        Uri parse = Uri.parse(d() + "long/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", l);
                        b2.update(parse, contentValues, null, null);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Float f) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        Uri parse = Uri.parse(d() + "float/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", f);
                        b2.update(parse, contentValues, null, null);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Set<String> set) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        Uri parse = Uri.parse(d() + "string_set/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        HashSet hashSet = new HashSet();
                        for (String str3 : set) {
                            hashSet.add(str3.replace(",", "__COMMA__"));
                        }
                        contentValues.put("value", hashSet.toString());
                        b2.update(parse, contentValues, null, null);
                    }
                } catch (Throwable th) {
                }
            }
        }
    }

    public static String b(String str, String str2) {
        return b((String) null, str, str2);
    }

    public static String b(String str, String str2, String str3) {
        String type;
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 == null || (type = b2.getType(Uri.parse(d() + "string/" + str2 + b(str)))) == null) {
                    return str3;
                }
                return !type.equals("null") ? type : str3;
            } catch (Throwable th) {
                return str3;
            }
        }
        return str3;
    }

    public static int a(String str, String str2, int i) {
        String type;
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null && (type = b2.getType(Uri.parse(d() + "int/" + str2 + b(str)))) != null && !type.equals("null")) {
                    return Integer.parseInt(type);
                }
                return i;
            } catch (Throwable th) {
                return i;
            }
        }
        return i;
    }

    public static float a(String str, String str2, float f) {
        String type;
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null && (type = b2.getType(Uri.parse(d() + "float/" + str2 + b(str)))) != null && !type.equals("null")) {
                    return Float.parseFloat(type);
                }
                return f;
            } catch (Throwable th) {
                return f;
            }
        }
        return f;
    }

    public static boolean a(String str, String str2, boolean z) {
        String type;
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null && (type = b2.getType(Uri.parse(d() + "boolean/" + str2 + b(str)))) != null && !type.equals("null")) {
                    return Boolean.parseBoolean(type);
                }
                return z;
            } catch (Throwable th) {
                return z;
            }
        }
        return z;
    }

    public static long a(String str, long j) {
        return a((String) null, str, j);
    }

    public static long a(String str, String str2, long j) {
        String type;
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null && (type = b2.getType(Uri.parse(d() + "long/" + str2 + b(str)))) != null && !type.equals("null")) {
                    return Long.parseLong(type);
                }
                return j;
            } catch (Throwable th) {
                return j;
            }
        }
        return j;
    }

    @TargetApi(11)
    public static Set<String> b(String str, String str2, Set<String> set) {
        String type;
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null && (type = b2.getType(Uri.parse(d() + "string_set/" + str2 + b(str)))) != null && !type.equals("null") && type.matches("\\[.*\\]")) {
                    String[] split = type.substring(1, type.length() - 1).split(", ");
                    HashSet hashSet = new HashSet();
                    for (String str3 : split) {
                        hashSet.add(str3.replace("__COMMA__", ", "));
                    }
                    return hashSet;
                }
                return set;
            } catch (Throwable th) {
                return set;
            }
        }
        return set;
    }

    public static void c(String str, String str2) {
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null) {
                    b2.delete(Uri.parse(d() + "long/" + str2 + b(str)), null, null);
                }
            } catch (Throwable th) {
            }
        }
    }

    public static void a(String str) {
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null) {
                    b2.delete(Uri.parse(d() + "clean" + b(str)), null, null);
                }
            } catch (Throwable th) {
            }
        }
    }
}
