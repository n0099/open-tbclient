package d.q.a.a.a.b.i.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f71374c;

    /* renamed from: d  reason: collision with root package name */
    public static a f71375d;

    /* renamed from: e  reason: collision with root package name */
    public static Object f71376e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public static HandlerThread f71377f;

    /* renamed from: g  reason: collision with root package name */
    public static Handler f71378g;

    /* renamed from: h  reason: collision with root package name */
    public static String f71379h;

    /* renamed from: i  reason: collision with root package name */
    public static String f71380i;

    /* renamed from: a  reason: collision with root package name */
    public Context f71381a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f71382b;

    public b(Context context) {
        this.f71382b = false;
        this.f71381a = context;
        boolean equals = "1".equals(d("persist.sys.identifierid.supported", "0"));
        this.f71382b = equals;
        if (equals) {
            HandlerThread handlerThread = new HandlerThread("vivo_work");
            f71377f = handlerThread;
            handlerThread.start();
            f71378g = new c(this, f71377f.getLooper(), context);
        }
    }

    public static b a(Context context) {
        if (f71374c == null) {
            synchronized (b.class) {
                if (f71374c == null) {
                    f71374c = new b(context);
                }
            }
        }
        return f71374c;
    }

    public static String d(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String h(Context context, int i2, String str) {
        Cursor cursor;
        String str2;
        Uri parse;
        Cursor query;
        String str3 = null;
        try {
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (i2 == 0) {
            str2 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID";
        } else if (i2 == 1) {
            str2 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str;
        } else if (i2 != 2) {
            parse = null;
            query = context.getContentResolver().query(parse, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        str3 = query.getString(query.getColumnIndex("value"));
                    }
                } catch (Throwable th2) {
                    cursor = query;
                    th = th2;
                    try {
                        d.q.a.a.c.b.b.c(th);
                        return str3;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (query != null) {
                query.close();
            }
            return str3;
        } else {
            str2 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str;
        }
        parse = Uri.parse(str2);
        query = context.getContentResolver().query(parse, null, null, null, null);
        if (query != null) {
        }
        if (query != null) {
        }
        return str3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
        if (android.text.TextUtils.isEmpty(d.q.a.a.a.b.i.a.b.f71379h) == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e(int i2, String str) {
        try {
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return;
        }
        synchronized (f71376e) {
            Message obtainMessage = f71378g.obtainMessage();
            obtainMessage.what = 666;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i2);
            if (i2 == 1 || i2 == 2) {
                bundle.putString("appid", str);
            }
            obtainMessage.setData(bundle);
            f71378g.sendMessage(obtainMessage);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f71376e.wait(2000L);
            } catch (InterruptedException unused) {
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2 && !TextUtils.isEmpty(f71379h)) {
                        }
                    }
                    d.q.a.a.c.b.b.c(th);
                    return;
                }
                f71380i = f71379h;
                f71379h = null;
            }
        }
    }

    public final boolean f() {
        return this.f71382b;
    }

    public final String g() {
        if (this.f71382b) {
            String str = f71380i;
            if (str != null) {
                return str;
            }
            e(0, null);
            if (f71375d == null) {
                Context context = this.f71381a;
                f71375d = new a(f71374c, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f71375d);
            }
            return f71380i;
        }
        return null;
    }
}
