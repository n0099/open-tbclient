package com.bytedance.sdk.openadsdk.multipro.d;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.multipro.e;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Context f29737a;

    public static boolean a() {
        if (f29737a == null || p.a() == null) {
            u.b("The context of SPHelper is null, please initialize sdk in main process");
            return false;
        }
        return true;
    }

    public static ContentResolver b() {
        try {
            if (a()) {
                return c().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Context c() {
        Context context = f29737a;
        return context == null ? p.a() : context;
    }

    public static String d() {
        return e.f29741b + "/t_sp/";
    }

    public static void c(String str, String str2) {
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null) {
                    b2.delete(Uri.parse(d() + "long/" + str2 + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context) {
        f29737a = context == null ? p.a() : context.getApplicationContext();
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=" + str;
    }

    public static synchronized void a(String str, Boolean bool) {
        synchronized (a.class) {
            a((String) null, str, bool);
        }
    }

    public static String b(String str, String str2) {
        return b((String) null, str, str2);
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
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static String b(String str, String str2, String str3) {
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null) {
                    String type = b2.getType(Uri.parse(d() + "string/" + str2 + b(str)));
                    if (type != null) {
                        if (!type.equals(StringUtil.NULL_STRING)) {
                            return type;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
            return str3;
        }
        return str3;
    }

    @TargetApi(11)
    public static Set<String> b(String str, String str2, Set<String> set) {
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null) {
                    String type = b2.getType(Uri.parse(d() + "string_set/" + str2 + b(str)));
                    if (type == null || type.equals(StringUtil.NULL_STRING) || !type.matches("\\[.*\\]")) {
                        return set;
                    }
                    String[] split = type.substring(1, type.length() - 1).split(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    HashSet hashSet = new HashSet();
                    for (String str3 : split) {
                        hashSet.add(str3.replace("__COMMA__", StringUtil.ARRAY_ELEMENT_SEPARATOR));
                    }
                    return hashSet;
                }
            } catch (Throwable unused) {
            }
            return set;
        }
        return set;
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
                } catch (Throwable unused) {
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
                } catch (Throwable unused) {
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
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static synchronized void a(String str, String str2, Float f2) {
        synchronized (a.class) {
            if (a()) {
                try {
                    ContentResolver b2 = b();
                    if (b2 != null) {
                        Uri parse = Uri.parse(d() + "float/" + str2 + b(str));
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("value", f2);
                        b2.update(parse, contentValues, null, null);
                    }
                } catch (Throwable unused) {
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
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static int a(String str, String str2, int i2) {
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null) {
                    String type = b2.getType(Uri.parse(d() + "int/" + str2 + b(str)));
                    if (type != null && !type.equals(StringUtil.NULL_STRING)) {
                        return Integer.parseInt(type);
                    }
                }
            } catch (Throwable unused) {
            }
            return i2;
        }
        return i2;
    }

    public static boolean a(String str, boolean z) {
        return a((String) null, str, z);
    }

    public static boolean a(String str, String str2, boolean z) {
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null) {
                    String type = b2.getType(Uri.parse(d() + "boolean/" + str2 + b(str)));
                    if (type != null && !type.equals(StringUtil.NULL_STRING)) {
                        return Boolean.parseBoolean(type);
                    }
                }
            } catch (Throwable unused) {
            }
            return z;
        }
        return z;
    }

    public static long a(String str, long j) {
        return a((String) null, str, j);
    }

    public static long a(String str, String str2, long j) {
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null) {
                    String type = b2.getType(Uri.parse(d() + "long/" + str2 + b(str)));
                    if (type != null && !type.equals(StringUtil.NULL_STRING)) {
                        return Long.parseLong(type);
                    }
                }
            } catch (Throwable unused) {
            }
            return j;
        }
        return j;
    }

    public static void a(String str) {
        if (a()) {
            try {
                ContentResolver b2 = b();
                if (b2 != null) {
                    b2.delete(Uri.parse(d() + "clean" + b(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
