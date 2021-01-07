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
/* loaded from: classes6.dex */
public class gx {

    /* renamed from: a  reason: collision with other field name */
    private static al f488a = new al(true);

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f14370a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f487a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static final Object f490a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f492a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private static String f491a = "";

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f489a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f14371a;

        /* renamed from: a  reason: collision with other field name */
        public long f493a;

        /* renamed from: a  reason: collision with other field name */
        public String f494a;

        /* renamed from: b  reason: collision with root package name */
        public int f14372b;

        /* renamed from: b  reason: collision with other field name */
        public long f495b;

        /* renamed from: b  reason: collision with other field name */
        public String f496b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f494a = "";
            this.f493a = 0L;
            this.f14371a = -1;
            this.f14372b = -1;
            this.f496b = "";
            this.f495b = 0L;
            this.f494a = str;
            this.f493a = j;
            this.f14371a = i;
            this.f14372b = i2;
            this.f496b = str2;
            this.f495b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f494a, this.f494a) && TextUtils.equals(aVar.f496b, this.f496b) && aVar.f14371a == this.f14371a && aVar.f14372b == this.f14372b && Math.abs(aVar.f493a - this.f493a) <= 5000;
        }
    }

    public static int a(Context context) {
        if (f14370a == -1) {
            f14370a = b(context);
        }
        return f14370a;
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
            long j3 = f487a;
            f487a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return 2 * j;
            }
        }
        return ((i == 0 ? 13 : 11) * j) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m357a(Context context) {
        if (f489a != null) {
            return f489a;
        }
        f489a = new com.xiaomi.push.providers.a(context);
        return f489a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static synchronized String m358a(Context context) {
        String str;
        synchronized (gx.class) {
            str = !TextUtils.isEmpty(f491a) ? f491a : "";
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m360a(Context context) {
        f14370a = b(context);
    }

    private static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f490a) {
            isEmpty = f492a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m358a(context) : "", j));
        }
        if (isEmpty) {
            f488a.a(new gy(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : f492a) {
            if (aVar2.a(aVar)) {
                aVar2.f495b += aVar.f495b;
                return;
            }
        }
        f492a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m361a(String str) {
        synchronized (gx.class) {
            if (!l.d() && !TextUtils.isEmpty(str)) {
                f491a = str;
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
            synchronized (com.xiaomi.push.providers.a.f872a) {
                SQLiteDatabase writableDatabase = m357a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.f494a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f493a));
                    contentValues.put(HttpConstants.NETWORK_TYPE, Integer.valueOf(aVar.f14371a));
                    contentValues.put("bytes", Long.valueOf(aVar.f495b));
                    contentValues.put("rcv", Integer.valueOf(aVar.f14372b));
                    contentValues.put("imsi", aVar.f496b);
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
