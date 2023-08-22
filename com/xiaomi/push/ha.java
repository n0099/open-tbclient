package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class ha {

    /* renamed from: a  reason: collision with other field name */
    public static am f457a = new am(true);
    public static volatile int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public static long f456a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    public static final Object f459a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static List<a> f461a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    public static String f460a = "";

    /* renamed from: a  reason: collision with other field name */
    public static com.xiaomi.push.providers.a f458a = null;

    /* loaded from: classes10.dex */
    public static class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f462a;

        /* renamed from: a  reason: collision with other field name */
        public String f463a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f464b;

        /* renamed from: b  reason: collision with other field name */
        public String f465b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f463a = "";
            this.f462a = 0L;
            this.a = -1;
            this.b = -1;
            this.f465b = "";
            this.f464b = 0L;
            this.f463a = str;
            this.f462a = j;
            this.a = i;
            this.b = i2;
            this.f465b = str2;
            this.f464b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f463a, this.f463a) && TextUtils.equals(aVar.f465b, this.f465b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f462a - this.f462a) <= 5000;
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
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes().length;
        }
    }

    public static long a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f456a;
            f456a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return j * 2;
            }
        }
        return (j * (i == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static com.xiaomi.push.providers.a m542a(Context context) {
        com.xiaomi.push.providers.a aVar = f458a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f458a = aVar2;
        return aVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m543a(Context context) {
        synchronized (ha.class) {
            if (TextUtils.isEmpty(f460a)) {
                return "";
            }
            return f460a;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m545a(Context context) {
        a = b(context);
    }

    public static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f459a) {
            isEmpty = f461a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m543a(context) : "", j));
        }
        if (isEmpty) {
            f457a.a(new hb(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    public static void a(a aVar) {
        for (a aVar2 : f461a) {
            if (aVar2.a(aVar)) {
                aVar2.f464b += aVar.f464b;
                return;
            }
        }
        f461a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m546a(String str) {
        synchronized (ha.class) {
            if (!j.m716d() && !TextUtils.isEmpty(str)) {
                f460a = str;
            }
        }
    }

    public static int b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.f830a) {
                SQLiteDatabase writableDatabase = m542a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.f463a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f462a));
                    contentValues.put("network_type", Integer.valueOf(aVar.a));
                    contentValues.put("bytes", Long.valueOf(aVar.f464b));
                    contentValues.put("rcv", Integer.valueOf(aVar.b));
                    contentValues.put(BaseStatisContent.IMSI, aVar.f465b);
                    writableDatabase.insert("traffic", null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (Throwable th) {
            com.xiaomi.channel.commonutils.logger.b.a(th);
        }
    }
}
