package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.searchbox.pms.constants.PmsConstant;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class gq {

    /* renamed from: a  reason: collision with other field name */
    public static al f438a = new al(true);

    /* renamed from: a  reason: collision with root package name */
    public static volatile int f40602a = -1;

    /* renamed from: a  reason: collision with other field name */
    public static long f437a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    public static final Object f440a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static List<a> f442a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    public static String f441a = "";

    /* renamed from: a  reason: collision with other field name */
    public static com.xiaomi.push.providers.a f439a = null;

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f40603a;

        /* renamed from: a  reason: collision with other field name */
        public long f443a;

        /* renamed from: a  reason: collision with other field name */
        public String f444a;

        /* renamed from: b  reason: collision with root package name */
        public int f40604b;

        /* renamed from: b  reason: collision with other field name */
        public long f445b;

        /* renamed from: b  reason: collision with other field name */
        public String f446b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f444a = "";
            this.f443a = 0L;
            this.f40603a = -1;
            this.f40604b = -1;
            this.f446b = "";
            this.f445b = 0L;
            this.f444a = str;
            this.f443a = j;
            this.f40603a = i;
            this.f40604b = i2;
            this.f446b = str2;
            this.f445b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f444a, this.f444a) && TextUtils.equals(aVar.f446b, this.f446b) && aVar.f40603a == this.f40603a && aVar.f40604b == this.f40604b && Math.abs(aVar.f443a - this.f443a) <= 5000;
        }
    }

    public static int a(Context context) {
        if (f40602a == -1) {
            f40602a = b(context);
        }
        return f40602a;
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
            long j3 = f437a;
            f437a = j2;
            if (j2 - j3 > StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD && j > 1024) {
                return j * 2;
            }
        }
        return (j * (i == 0 ? 13 : 11)) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static com.xiaomi.push.providers.a m337a(Context context) {
        com.xiaomi.push.providers.a aVar = f439a;
        if (aVar != null) {
            return aVar;
        }
        com.xiaomi.push.providers.a aVar2 = new com.xiaomi.push.providers.a(context);
        f439a = aVar2;
        return aVar2;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized String m338a(Context context) {
        synchronized (gq.class) {
            if (TextUtils.isEmpty(f441a)) {
                return "";
            }
            return f441a;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m340a(Context context) {
        f40602a = b(context);
    }

    public static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f440a) {
            isEmpty = f442a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m338a(context) : "", j));
        }
        if (isEmpty) {
            f438a.a(new gr(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    public static void a(a aVar) {
        for (a aVar2 : f442a) {
            if (aVar2.a(aVar)) {
                aVar2.f445b += aVar.f445b;
                return;
            }
        }
        f442a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m341a(String str) {
        synchronized (gq.class) {
            if (!l.d() && !TextUtils.isEmpty(str)) {
                f441a = str;
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
            synchronized (com.xiaomi.push.providers.a.f823a) {
                SQLiteDatabase writableDatabase = m337a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.f444a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f443a));
                    contentValues.put(PmsConstant.Statistic.STATISTIC_NETWORK, Integer.valueOf(aVar.f40603a));
                    contentValues.put("bytes", Long.valueOf(aVar.f445b));
                    contentValues.put("rcv", Integer.valueOf(aVar.f40604b));
                    contentValues.put("imsi", aVar.f446b);
                    writableDatabase.insert("traffic", null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (SQLiteException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }
}
