package d.r.a.a.a.b.e.a;

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
    public static volatile a f68447c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f68448d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static HandlerThread f68449e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f68450f;

    /* renamed from: g  reason: collision with root package name */
    public static String f68451g;

    /* renamed from: h  reason: collision with root package name */
    public static String f68452h;

    /* renamed from: a  reason: collision with root package name */
    public Context f68453a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f68454b = false;

    public a(Context context) {
        this.f68453a = context;
        HandlerThread handlerThread = new HandlerThread("meizu_work");
        f68449e = handlerThread;
        handlerThread.start();
        f68450f = new b(this, f68449e.getLooper(), context);
    }

    public static a a(Context context) {
        if (f68447c == null) {
            synchronized (a.class) {
                if (f68447c == null) {
                    f68447c = new a(context);
                }
            }
        }
        return f68447c;
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
                        d.r.a.a.c.b.b.e("getIdFromContentProvider meizu " + str3 + " " + str);
                    }
                } catch (Throwable th) {
                    th = th;
                    String str4 = str3;
                    cursor = query;
                    str2 = str4;
                    try {
                        d.r.a.a.c.b.b.c(th);
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
            String str = f68452h;
            if (str != null) {
                return str;
            }
            try {
                synchronized (f68448d) {
                    Message obtainMessage = f68450f.obtainMessage();
                    obtainMessage.what = 666;
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", 0);
                    bundle.putString("appid", "oaid");
                    obtainMessage.setData(bundle);
                    f68450f.sendMessage(obtainMessage);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    try {
                        f68448d.wait(2000L);
                    } catch (InterruptedException unused) {
                    }
                    if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                        f68452h = f68451g;
                        f68451g = null;
                    }
                }
            } catch (Throwable th) {
                d.r.a.a.c.b.b.c(th);
            }
            return f68452h;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
        return r10.f68454b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h() {
        Cursor cursor = null;
        try {
            if (this.f68454b) {
                return this.f68454b;
            }
            PackageManager packageManager = this.f68453a.getPackageManager();
            if (packageManager == null) {
                this.f68454b = false;
            }
            if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                d.r.a.a.c.b.b.e("resolveContentProvider meizu");
                cursor = this.f68453a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursor == null) {
                    this.f68454b = false;
                }
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    String string = cursor.getString(columnIndex);
                    d.r.a.a.c.b.b.e("resolveContentProvider meizu " + string);
                    this.f68454b = "0".equals(string);
                }
            } else {
                this.f68454b = false;
            }
        } catch (Throwable th) {
            try {
                d.r.a.a.c.b.b.c(th);
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
    }
}
