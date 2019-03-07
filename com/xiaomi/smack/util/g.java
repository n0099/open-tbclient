package com.xiaomi.smack.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.baidu.tbadk.TbConfig;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.http.protocol.HTTP;
/* loaded from: classes3.dex */
public class g {
    private static com.xiaomi.channel.commonutils.misc.h a = new com.xiaomi.channel.commonutils.misc.h(true);
    private static int b = -1;
    private static final Object c = new Object();
    private static List<a> d = Collections.synchronizedList(new ArrayList());
    private static String e = "";
    private static com.xiaomi.push.providers.a f = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        public String a;
        public long b;
        public int c;
        public int d;
        public String e;
        public long f;

        public a(String str, long j, int i, int i2, String str2, long j2) {
            this.a = "";
            this.b = 0L;
            this.c = -1;
            this.d = -1;
            this.e = "";
            this.f = 0L;
            this.a = str;
            this.b = j;
            this.c = i;
            this.d = i2;
            this.e = str2;
            this.f = j2;
        }

        public boolean a(a aVar) {
            return TextUtils.equals(aVar.a, this.a) && TextUtils.equals(aVar.e, this.e) && aVar.c == this.c && aVar.d == this.d && Math.abs(aVar.b - this.b) <= TbConfig.NOTIFY_SOUND_INTERVAL;
        }
    }

    private static int a(Context context) {
        if (b == -1) {
            b = b(context);
        }
        return b;
    }

    public static int a(String str) {
        try {
            return str.getBytes(HTTP.UTF_8).length;
        } catch (UnsupportedEncodingException e2) {
            return str.getBytes().length;
        }
    }

    private static long a(int i, long j) {
        return ((i == 0 ? 13 : 11) * j) / 10;
    }

    public static void a(Context context, String str, long j, boolean z, long j2) {
        int a2;
        boolean isEmpty;
        if (context == null || TextUtils.isEmpty(str) || !"com.xiaomi.xmsf".equals(context.getPackageName()) || "com.xiaomi.xmsf".equals(str) || -1 == (a2 = a(context))) {
            return;
        }
        synchronized (c) {
            isEmpty = d.isEmpty();
            a(new a(str, j2, a2, z ? 1 : 0, a2 == 0 ? c(context) : "", a(a2, j)));
        }
        if (isEmpty) {
            a.a(new h(context), TbConfig.NOTIFY_SOUND_INTERVAL);
        }
    }

    private static void a(a aVar) {
        for (a aVar2 : d) {
            if (aVar2.a(aVar)) {
                aVar2.f += aVar.f;
                return;
            }
        }
        d.add(aVar);
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
            } catch (Exception e2) {
                return -1;
            }
        } catch (Exception e3) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, List<a> list) {
        try {
            synchronized (com.xiaomi.push.providers.a.a) {
                SQLiteDatabase writableDatabase = d(context).getWritableDatabase();
                writableDatabase.beginTransaction();
                for (a aVar : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("package_name", aVar.a);
                    contentValues.put("message_ts", Long.valueOf(aVar.b));
                    contentValues.put("network_type", Integer.valueOf(aVar.c));
                    contentValues.put("bytes", Long.valueOf(aVar.f));
                    contentValues.put("rcv", Integer.valueOf(aVar.d));
                    contentValues.put("imsi", aVar.e);
                    writableDatabase.insert("traffic", null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (SQLiteException e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }

    private static synchronized String c(Context context) {
        String str;
        synchronized (g.class) {
            if (TextUtils.isEmpty(e)) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE);
                    if (telephonyManager != null) {
                        e = telephonyManager.getSubscriberId();
                    }
                } catch (Exception e2) {
                }
                str = e;
            } else {
                str = e;
            }
        }
        return str;
    }

    private static com.xiaomi.push.providers.a d(Context context) {
        if (f != null) {
            return f;
        }
        f = new com.xiaomi.push.providers.a(context);
        return f;
    }
}
