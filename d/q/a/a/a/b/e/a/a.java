package d.q.a.a.a.b.e.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f67512c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f67513d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static HandlerThread f67514e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f67515f;

    /* renamed from: g  reason: collision with root package name */
    public static String f67516g;

    /* renamed from: h  reason: collision with root package name */
    public static String f67517h;

    /* renamed from: a  reason: collision with root package name */
    public Context f67518a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67519b = false;

    public a(Context context) {
        this.f67518a = context;
        HandlerThread handlerThread = new HandlerThread("meizu_work");
        f67514e = handlerThread;
        handlerThread.start();
        f67515f = new b(this, f67514e.getLooper(), context);
    }

    public static a a(Context context) {
        if (f67512c == null) {
            synchronized (a.class) {
                if (f67512c == null) {
                    f67512c = new a(context);
                }
            }
        }
        return f67512c;
    }

    public static String f(Context context, String str) {
        String str2;
        Cursor cursor = null;
        r0 = null;
        r0 = null;
        String str3 = null;
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToNext()) {
                        str3 = query.getString(query.getColumnIndex("value"));
                        d.q.a.a.c.b.b.e("getIdFromContentProvider meizu " + str3 + " " + str);
                    }
                } catch (Throwable th) {
                    th = th;
                    String str4 = str3;
                    cursor = query;
                    str2 = str4;
                    try {
                        d.q.a.a.c.b.b.c(th);
                        return str2;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
            if (query != null) {
                query.close();
                return str3;
            }
            return str3;
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
        }
    }

    public final boolean d() {
        return h();
    }

    public final String e() {
        if (h()) {
            String str = f67517h;
            if (str != null) {
                return str;
            }
            try {
                synchronized (f67513d) {
                    Message obtainMessage = f67515f.obtainMessage();
                    obtainMessage.what = 666;
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", 0);
                    bundle.putString("appid", "oaid");
                    obtainMessage.setData(bundle);
                    f67515f.sendMessage(obtainMessage);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    try {
                        f67513d.wait(2000L);
                    } catch (InterruptedException unused) {
                    }
                    if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                        f67517h = f67516g;
                        f67516g = null;
                    }
                }
            } catch (Throwable th) {
                d.q.a.a.c.b.b.c(th);
            }
            return f67517h;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
        return r10.f67519b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h() {
        Cursor cursor = null;
        try {
            if (this.f67519b) {
                return this.f67519b;
            }
            PackageManager packageManager = this.f67518a.getPackageManager();
            if (packageManager == null) {
                this.f67519b = false;
            }
            if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                d.q.a.a.c.b.b.e("resolveContentProvider meizu");
                cursor = this.f67518a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursor == null) {
                    this.f67519b = false;
                }
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    String string = cursor.getString(columnIndex);
                    d.q.a.a.c.b.b.e("resolveContentProvider meizu " + string);
                    this.f67519b = "0".equals(string);
                }
            } else {
                this.f67519b = false;
            }
        } catch (Throwable th) {
            try {
                d.q.a.a.c.b.b.c(th);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }
}
