package com.yxcorp.kuaishou.addfp.a.b.d.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f14651a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14652b = false;
    private static volatile a qew = null;
    private static Object d = new Object();
    private static HandlerThread e = null;
    private static Handler f = null;
    private static String g = null;
    private static String h = null;

    private a(Context context) {
        this.f14651a = context;
        HandlerThread handlerThread = new HandlerThread("meizu_work");
        e = handlerThread;
        handlerThread.start();
        f = new b(this, e.getLooper(), context);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004c A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, String str) {
        String str2;
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{str}, null);
        } catch (Throwable th) {
            th = th;
            str2 = null;
            cursor = null;
        }
        if (cursor != null) {
            try {
            } catch (Throwable th2) {
                th = th2;
                str2 = null;
            }
            if (cursor.moveToNext()) {
                str2 = cursor.getString(cursor.getColumnIndex("value"));
                try {
                    com.yxcorp.kuaishou.addfp.android.b.b.b("getIdFromContentProvider meizu " + str2 + " " + str);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return str2;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
                return str2;
            }
        }
        str2 = null;
        return str2;
    }

    private boolean d() {
        Cursor cursor;
        try {
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (this.f14652b) {
            return this.f14652b;
        }
        PackageManager packageManager = this.f14651a.getPackageManager();
        if (packageManager == null) {
            this.f14652b = false;
        }
        if (packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("resolveContentProvider meizu");
            cursor = this.f14651a.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
            if (cursor == null) {
                try {
                    this.f14652b = false;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return this.f14652b;
                    } catch (Throwable th3) {
                        Cursor cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th3;
                    }
                }
            }
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                String string = cursor.getString(columnIndex);
                com.yxcorp.kuaishou.addfp.android.b.b.b("resolveContentProvider meizu " + string);
                this.f14652b = "0".equals(string);
            }
        } else {
            this.f14652b = false;
            cursor = null;
        }
        if (cursor != null) {
            cursor.close();
        }
        return this.f14652b;
    }

    public static a jb(Context context) {
        if (qew == null) {
            synchronized (a.class) {
                if (qew == null) {
                    qew = new a(context);
                }
            }
        }
        return qew;
    }

    public final boolean a() {
        return d();
    }

    public final String b() {
        if (d()) {
            if (h != null) {
                return h;
            }
            try {
                synchronized (d) {
                    Message obtainMessage = f.obtainMessage();
                    obtainMessage.what = 666;
                    Bundle bundle = new Bundle();
                    bundle.putInt("type", 0);
                    bundle.putString("appid", "oaid");
                    obtainMessage.setData(bundle);
                    f.sendMessage(obtainMessage);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    try {
                        d.wait(2000L);
                    } catch (InterruptedException e2) {
                    }
                    if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                        h = g;
                        g = null;
                    }
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
            return h;
        }
        return null;
    }
}
