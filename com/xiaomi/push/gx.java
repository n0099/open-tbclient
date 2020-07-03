package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public class gx {

    /* renamed from: a  reason: collision with other field name */
    private static al f413a = new al(true);
    private static volatile int a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f412a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static final Object f415a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f417a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private static String f416a = "";

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f414a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f418a;

        /* renamed from: a  reason: collision with other field name */
        public String f419a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f420b;

        /* renamed from: b  reason: collision with other field name */
        public String f421b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f419a = "";
            this.f418a = 0L;
            this.a = -1;
            this.b = -1;
            this.f421b = "";
            this.f420b = 0L;
            this.f419a = str;
            this.f418a = j;
            this.a = i;
            this.b = i2;
            this.f421b = str2;
            this.f420b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f419a, this.f419a) && TextUtils.equals(aVar.f421b, this.f421b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f418a - this.f418a) <= 5000;
        }
    }

    public static int a(Context context) {
        if (a == -1) {
            a = b(context);
        }
        return a;
    }

    public static int a(String str) {
        try {
            return str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException e) {
            return str.getBytes().length;
        }
    }

    private static long a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f412a;
            f412a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return 2 * j;
            }
        }
        return ((i == 0 ? 13 : 11) * j) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m321a(Context context) {
        if (f414a != null) {
            return f414a;
        }
        f414a = new com.xiaomi.push.providers.a(context);
        return f414a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static synchronized String m322a(Context context) {
        String str;
        synchronized (gx.class) {
            str = !TextUtils.isEmpty(f416a) ? f416a : "";
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m324a(Context context) {
        a = b(context);
    }

    private static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f415a) {
            isEmpty = f417a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m322a(context) : "", j));
        }
        if (isEmpty) {
            f413a.a(new gy(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : f417a) {
            if (aVar2.a(aVar)) {
                aVar2.f420b += aVar.f420b;
                return;
            }
        }
        f417a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m325a(String str) {
        synchronized (gx.class) {
            if (!l.d() && !TextUtils.isEmpty(str)) {
                f416a = str;
            }
        }
    }

    private static int b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return -1;
                }
                return activeNetworkInfo.getType();
            } catch (Exception e) {
                return -1;
            }
        } catch (Exception e2) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f797a) {
                SQLiteDatabase writableDatabase = m321a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.f419a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f418a));
                    contentValues.put(HttpConstants.NETWORK_TYPE, Integer.valueOf(aVar.a));
                    contentValues.put("bytes", Long.valueOf(aVar.f420b));
                    contentValues.put("rcv", Integer.valueOf(aVar.b));
                    contentValues.put("imsi", aVar.f421b);
                    writableDatabase.insert("traffic", null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (SQLiteException e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
