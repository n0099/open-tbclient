package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public class gr {

    /* renamed from: a  reason: collision with other field name */
    private static al f422a = new al(true);
    private static volatile int a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f421a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static final Object f424a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f426a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private static String f425a = "";

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f423a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f427a;

        /* renamed from: a  reason: collision with other field name */
        public String f428a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f429b;

        /* renamed from: b  reason: collision with other field name */
        public String f430b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f428a = "";
            this.f427a = 0L;
            this.a = -1;
            this.b = -1;
            this.f430b = "";
            this.f429b = 0L;
            this.f428a = str;
            this.f427a = j;
            this.a = i;
            this.b = i2;
            this.f430b = str2;
            this.f429b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f428a, this.f428a) && TextUtils.equals(aVar.f430b, this.f430b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f427a - this.f427a) <= 5000;
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
            long j3 = f421a;
            f421a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return 2 * j;
            }
        }
        return ((i == 0 ? 13 : 11) * j) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m316a(Context context) {
        if (f423a != null) {
            return f423a;
        }
        f423a = new com.xiaomi.push.providers.a(context);
        return f423a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static synchronized String m317a(Context context) {
        String str;
        synchronized (gr.class) {
            str = !TextUtils.isEmpty(f425a) ? f425a : "";
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m319a(Context context) {
        a = b(context);
    }

    private static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f424a) {
            isEmpty = f426a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m317a(context) : "", j));
        }
        if (isEmpty) {
            f422a.a(new gs(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : f426a) {
            if (aVar2.a(aVar)) {
                aVar2.f429b += aVar.f429b;
                return;
            }
        }
        f426a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m320a(String str) {
        synchronized (gr.class) {
            if (!l.d() && !TextUtils.isEmpty(str)) {
                f425a = str;
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
            synchronized (com.xiaomi.push.providers.a.f805a) {
                SQLiteDatabase writableDatabase = m316a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.f428a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f427a));
                    contentValues.put("network_type", Integer.valueOf(aVar.a));
                    contentValues.put("bytes", Long.valueOf(aVar.f429b));
                    contentValues.put("rcv", Integer.valueOf(aVar.b));
                    contentValues.put("imsi", aVar.f430b);
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
