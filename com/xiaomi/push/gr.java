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
/* loaded from: classes5.dex */
public class gr {

    /* renamed from: a  reason: collision with other field name */
    private static al f426a = new al(true);
    private static volatile int a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f425a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static final Object f428a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f430a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private static String f429a = "";

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f427a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f431a;

        /* renamed from: a  reason: collision with other field name */
        public String f432a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f433b;

        /* renamed from: b  reason: collision with other field name */
        public String f434b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f432a = "";
            this.f431a = 0L;
            this.a = -1;
            this.b = -1;
            this.f434b = "";
            this.f433b = 0L;
            this.f432a = str;
            this.f431a = j;
            this.a = i;
            this.b = i2;
            this.f434b = str2;
            this.f433b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f432a, this.f432a) && TextUtils.equals(aVar.f434b, this.f434b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f431a - this.f431a) <= 5000;
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
            long j3 = f425a;
            f425a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return 2 * j;
            }
        }
        return ((i == 0 ? 13 : 11) * j) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m302a(Context context) {
        if (f427a != null) {
            return f427a;
        }
        f427a = new com.xiaomi.push.providers.a(context);
        return f427a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static synchronized String m303a(Context context) {
        String str;
        synchronized (gr.class) {
            str = !TextUtils.isEmpty(f429a) ? f429a : "";
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m305a(Context context) {
        a = b(context);
    }

    private static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f428a) {
            isEmpty = f430a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m303a(context) : "", j));
        }
        if (isEmpty) {
            f426a.a(new gs(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : f430a) {
            if (aVar2.a(aVar)) {
                aVar2.f433b += aVar.f433b;
                return;
            }
        }
        f430a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m306a(String str) {
        synchronized (gr.class) {
            if (!l.d() && !TextUtils.isEmpty(str)) {
                f429a = str;
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
            synchronized (com.xiaomi.push.providers.a.f809a) {
                SQLiteDatabase writableDatabase = m302a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.f432a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f431a));
                    contentValues.put("network_type", Integer.valueOf(aVar.a));
                    contentValues.put("bytes", Long.valueOf(aVar.f433b));
                    contentValues.put("rcv", Integer.valueOf(aVar.b));
                    contentValues.put("imsi", aVar.f434b);
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
