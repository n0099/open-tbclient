package com.yxcorp.kuaishou.addfp.a.b.h.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f14370a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14371b;
    private static volatile b qbL = null;
    private static a qbM = null;
    private static a qbN = null;
    private static a qbO = null;
    private static Object g = new Object();
    private static HandlerThread h = null;
    private static Handler i = null;
    private static String j = null;
    private static String k = null;

    private b(Context context) {
        this.f14371b = false;
        this.f14370a = context;
        this.f14371b = "1".equals(a("persist.sys.identifierid.supported", "0"));
        if (this.f14371b) {
            HandlerThread handlerThread = new HandlerThread("vivo_work");
            h = handlerThread;
            handlerThread.start();
            i = new c(this, h.getLooper(), context);
        }
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable th) {
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(Context context, int i2, String str) {
        Cursor cursor;
        Uri parse;
        String string;
        try {
            switch (i2) {
                case 0:
                    parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
                    break;
                case 1:
                    parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
                    break;
                case 2:
                    parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
                    break;
                default:
                    parse = null;
                    break;
            }
            cursor = context.getContentResolver().query(parse, null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        string = cursor.getString(cursor.getColumnIndex("value"));
                        if (cursor == null) {
                            cursor.close();
                            return string;
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        com.yxcorp.kuaishou.addfp.android.b.b.a(th);
                        if (cursor != null) {
                            cursor.close();
                            return null;
                        }
                        return null;
                    } catch (Throwable th2) {
                        Cursor cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th2;
                    }
                }
            }
            string = null;
            if (cursor == null) {
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public static b jb(Context context) {
        if (qbL == null) {
            synchronized (b.class) {
                if (qbL == null) {
                    qbL = new b(context);
                }
            }
        }
        return qbL;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
        if (android.text.TextUtils.isEmpty(com.yxcorp.kuaishou.addfp.a.b.h.a.b.j) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(int i2, String str) {
        try {
            synchronized (g) {
                Message obtainMessage = i.obtainMessage();
                obtainMessage.what = 666;
                Bundle bundle = new Bundle();
                bundle.putInt("type", i2);
                if (i2 == 1 || i2 == 2) {
                    bundle.putString("appid", str);
                }
                obtainMessage.setData(bundle);
                i.sendMessage(obtainMessage);
                long uptimeMillis = SystemClock.uptimeMillis();
                try {
                    g.wait(2000L);
                } catch (InterruptedException e) {
                }
                if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                    switch (i2) {
                        case 0:
                            k = j;
                            j = null;
                            break;
                        case 1:
                            if (!TextUtils.isEmpty(j)) {
                                j = null;
                                break;
                            }
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final boolean a() {
        return this.f14371b;
    }

    public final String b() {
        if (this.f14371b) {
            if (k != null) {
                return k;
            }
            a(0, (String) null);
            if (qbM == null) {
                Context context = this.f14370a;
                qbM = new a(qbL, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, qbM);
            }
            return k;
        }
        return null;
    }
}
