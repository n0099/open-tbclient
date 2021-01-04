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
    private static al f487a = new al(true);

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f14369a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f486a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static final Object f489a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f491a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private static String f490a = "";

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f488a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f14370a;

        /* renamed from: a  reason: collision with other field name */
        public long f492a;

        /* renamed from: a  reason: collision with other field name */
        public String f493a;

        /* renamed from: b  reason: collision with root package name */
        public int f14371b;

        /* renamed from: b  reason: collision with other field name */
        public long f494b;

        /* renamed from: b  reason: collision with other field name */
        public String f495b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f493a = "";
            this.f492a = 0L;
            this.f14370a = -1;
            this.f14371b = -1;
            this.f495b = "";
            this.f494b = 0L;
            this.f493a = str;
            this.f492a = j;
            this.f14370a = i;
            this.f14371b = i2;
            this.f495b = str2;
            this.f494b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f493a, this.f493a) && TextUtils.equals(aVar.f495b, this.f495b) && aVar.f14370a == this.f14370a && aVar.f14371b == this.f14371b && Math.abs(aVar.f492a - this.f492a) <= 5000;
        }
    }

    public static int a(Context context) {
        if (f14369a == -1) {
            f14369a = b(context);
        }
        return f14369a;
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
            long j3 = f486a;
            f486a = j2;
            if (j2 - j3 > 30000 && j > 1024) {
                return 2 * j;
            }
        }
        return ((i == 0 ? 13 : 11) * j) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m346a(Context context) {
        if (f488a != null) {
            return f488a;
        }
        f488a = new com.xiaomi.push.providers.a(context);
        return f488a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static synchronized String m347a(Context context) {
        String str;
        synchronized (gx.class) {
            str = !TextUtils.isEmpty(f490a) ? f490a : "";
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m349a(Context context) {
        f14369a = b(context);
    }

    private static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f489a) {
            isEmpty = f491a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m347a(context) : "", j));
        }
        if (isEmpty) {
            f487a.a(new gy(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : f491a) {
            if (aVar2.a(aVar)) {
                aVar2.f494b += aVar.f494b;
                return;
            }
        }
        f491a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m350a(String str) {
        synchronized (gx.class) {
            if (!l.d() && !TextUtils.isEmpty(str)) {
                f490a = str;
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
            synchronized (com.xiaomi.push.providers.a.f871a) {
                SQLiteDatabase writableDatabase = m346a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.f493a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f492a));
                    contentValues.put(HttpConstants.NETWORK_TYPE, Integer.valueOf(aVar.f14370a));
                    contentValues.put("bytes", Long.valueOf(aVar.f494b));
                    contentValues.put("rcv", Integer.valueOf(aVar.f14371b));
                    contentValues.put("imsi", aVar.f495b);
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
