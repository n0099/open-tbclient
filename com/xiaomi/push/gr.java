package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class gr {

    /* renamed from: a  reason: collision with other field name */
    private static al f421a = new al(true);
    private static volatile int a = -1;

    /* renamed from: a  reason: collision with other field name */
    private static long f420a = System.currentTimeMillis();

    /* renamed from: a  reason: collision with other field name */
    private static final Object f423a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private static List<a> f425a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private static String f424a = "";

    /* renamed from: a  reason: collision with other field name */
    private static com.xiaomi.push.providers.a f422a = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public long f426a;

        /* renamed from: a  reason: collision with other field name */
        public String f427a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public long f428b;

        /* renamed from: b  reason: collision with other field name */
        public String f429b;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.f427a = "";
            this.f426a = 0L;
            this.a = -1;
            this.b = -1;
            this.f429b = "";
            this.f428b = 0L;
            this.f427a = str;
            this.f426a = j;
            this.a = i;
            this.b = i2;
            this.f429b = str2;
            this.f428b = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.f427a, this.f427a) && TextUtils.equals(aVar.f429b, this.f429b) && aVar.a == this.a && aVar.b == this.b && Math.abs(aVar.f426a - this.f426a) <= 5000;
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
            return str.getBytes(HTTP.UTF_8).length;
        } catch (UnsupportedEncodingException e) {
            return str.getBytes().length;
        }
    }

    private static long a(int i, long j, boolean z, long j2, boolean z2) {
        if (z && z2) {
            long j3 = f420a;
            f420a = j2;
            if (j2 - j3 > StatisticConfig.MIN_UPLOAD_INTERVAL && j > 1024) {
                return 2 * j;
            }
        }
        return ((i == 0 ? 13 : 11) * j) / 10;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static com.xiaomi.push.providers.a m299a(Context context) {
        if (f422a != null) {
            return f422a;
        }
        f422a = new com.xiaomi.push.providers.a(context);
        return f422a;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static synchronized String m300a(Context context) {
        String str;
        synchronized (gr.class) {
            str = !TextUtils.isEmpty(f424a) ? f424a : "";
        }
        return str;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m302a(Context context) {
        a = b(context);
    }

    private static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (f423a) {
            isEmpty = f425a.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? m300a(context) : "", j));
        }
        if (isEmpty) {
            f421a.a(new gs(context), 5000L);
        }
    }

    public static void a(Context context, String str, long j, boolean z, boolean z2, long j2) {
        a(context, str, a(a(context), j, z, j2, z2), z, j2);
    }

    private static void a(a aVar) {
        for (a aVar2 : f425a) {
            if (aVar2.a(aVar)) {
                aVar2.f428b += aVar.f428b;
                return;
            }
        }
        f425a.add(aVar);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static synchronized void m303a(String str) {
        synchronized (gr.class) {
            if (!l.d() && !TextUtils.isEmpty(str)) {
                f424a = str;
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
            synchronized (com.xiaomi.push.providers.a.f804a) {
                SQLiteDatabase writableDatabase = m299a(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(Constants.PACKAGE_NAME, aVar.f427a);
                    contentValues.put("message_ts", Long.valueOf(aVar.f426a));
                    contentValues.put("network_type", Integer.valueOf(aVar.a));
                    contentValues.put("bytes", Long.valueOf(aVar.f428b));
                    contentValues.put("rcv", Integer.valueOf(aVar.b));
                    contentValues.put("imsi", aVar.f429b);
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
