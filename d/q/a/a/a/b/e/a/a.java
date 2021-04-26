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
    public static volatile a f66826c;

    /* renamed from: d  reason: collision with root package name */
    public static Object f66827d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static HandlerThread f66828e;

    /* renamed from: f  reason: collision with root package name */
    public static Handler f66829f;

    /* renamed from: g  reason: collision with root package name */
    public static String f66830g;

    /* renamed from: h  reason: collision with root package name */
    public static String f66831h;

    /* renamed from: a  reason: collision with root package name */
    public Context f66832a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66833b = false;

    public a(Context context) {
        this.f66832a = context;
        HandlerThread handlerThread = new HandlerThread("meizu_work");
        f66828e = handlerThread;
        handlerThread.start();
        f66829f = new b(this, f66828e.getLooper(), context);
    }

    public static a a(Context context) {
        if (f66826c == null) {
            synchronized (a.class) {
                if (f66826c == null) {
                    f66826c = new a(context);
                }
            }
        }
        return f66826c;
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
            String str = f66831h;
            if (str != null) {
                return str;
            }
            try {
                synchronized (f66827d) {
                    Message obtainMessage = f66829f.obtainMessage();
                    obtainMessage.what = 666;
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", 0);
                    bundle.putString("appid", "oaid");
                    obtainMessage.setData(bundle);
                    f66829f.sendMessage(obtainMessage);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    try {
                        f66827d.wait(2000L);
                    } catch (InterruptedException unused) {
                    }
                    if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                        f66831h = f66830g;
                        f66830g = null;
                    }
                }
            } catch (Throwable th) {
                d.q.a.a.c.b.b.c(th);
            }
            return f66831h;
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
        if (r0 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
        return r10.f66833b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h() {
        Cursor cursor = null;
        try {
            if (this.f66833b) {
                return this.f66833b;
            }
            PackageManager packageManager = this.f66832a.getPackageManager();
            if (packageManager == null) {
                this.f66833b = false;
            }
            if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
                d.q.a.a.c.b.b.e("resolveContentProvider meizu");
                cursor = this.f66832a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursor == null) {
                    this.f66833b = false;
                }
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    String string = cursor.getString(columnIndex);
                    d.q.a.a.c.b.b.e("resolveContentProvider meizu " + string);
                    this.f66833b = "0".equals(string);
                }
            } else {
                this.f66833b = false;
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
