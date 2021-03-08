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
/* loaded from: classes5.dex */
public class gx {

    /* renamed from: a  reason: collision with other field name */
    private static al f408a = new al(true);

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f8400a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f407a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static final Object f410a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f412a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private static String f411a = "";

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f409a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f8401a;

        /* renamed from: a  reason: collision with other field name */
        public long f413a;

        /* renamed from: a  reason: collision with other field name */
        public String f414a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f415b;

        /* renamed from: b  reason: collision with other field name */
        public String f416b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f414a = "";
            this.f413a = 0L;
            this.f8401a = -1;
            this.b = -1;
            this.f416b = "";
            this.f415b = 0L;
            this.f414a = str;
            this.f413a = j;
            this.f8401a = i;
            this.b = i2;
            this.f416b = str2;
            this.f415b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f414a, this.f414a) && TextUtils.equals(aVar.f416b, this.f416b) && aVar.f8401a == this.f8401a && aVar.b == this.b && Math.abs(aVar.f413a - this.f413a) <= 5000;
        }
    }

    public static int a(Context context) {
        if (f8400a == -1) {
            f8400a = b(context);
        }
        return f8400a;
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
            long j3 = f407a;
            f407a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return 2 * j;
            }
        }
        return ((i == 0 ? 13 : 11) * j) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m331a(Context context) {
        if (f409a != null) {
            return f409a;
        }
        f409a = new com.xiaomi.push.providers.a(context);
        return f409a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static synchronized String m332a(Context context) {
        String str;
        synchronized (gx.class) {
            str = !TextUtils.isEmpty(f411a) ? f411a : "";
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m334a(Context context) {
        f8400a = b(context);
    }

    private static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f410a) {
            isEmpty = f412a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m332a(context) : "", j));
        }
        if (isEmpty) {
            f408a.a(new gy(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : f412a) {
            if (aVar2.a(aVar)) {
                aVar2.f415b += aVar.f415b;
                return;
            }
        }
        f412a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m335a(String str) {
        synchronized (gx.class) {
            if (!l.d() && !TextUtils.isEmpty(str)) {
                f411a = str;
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
            synchronized (com.xiaomi.push.providers.a.f792a) {
                SQLiteDatabase writableDatabase = m331a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.f414a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f413a));
                    contentValues.put(HttpConstants.NETWORK_TYPE, Integer.valueOf(aVar.f8401a));
                    contentValues.put("bytes", Long.valueOf(aVar.f415b));
                    contentValues.put("rcv", Integer.valueOf(aVar.b));
                    contentValues.put("imsi", aVar.f416b);
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
