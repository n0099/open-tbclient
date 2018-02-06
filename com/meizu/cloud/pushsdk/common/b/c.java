package com.meizu.cloud.pushsdk.common.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.meizu.cloud.pushsdk.common.b.g;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes2.dex */
public class c {
    private static a b;
    private static Handler a = new e(Looper.getMainLooper());
    private static LinkedList<b> c = new LinkedList<>();
    private static a.EnumC0268a d = a.EnumC0268a.DEBUG;
    private static a.EnumC0268a e = a.EnumC0268a.DEBUG;
    private static C0269c f = new C0269c();

    /* loaded from: classes2.dex */
    public interface a {

        /* renamed from: com.meizu.cloud.pushsdk.common.b.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public enum EnumC0268a {
            DEBUG,
            INFO,
            WARN,
            ERROR,
            NULL
        }

        void a(EnumC0268a enumC0268a, String str, String str2);
    }

    /* renamed from: com.meizu.cloud.pushsdk.common.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0269c {
        int a = 100;
        int b = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    }

    /* loaded from: classes2.dex */
    public enum d {
        CONSOLE,
        FILE
    }

    public static void a(d dVar, a.EnumC0268a enumC0268a) {
        if (dVar == d.CONSOLE) {
            d = enumC0268a;
        } else if (dVar == d.FILE) {
            e = enumC0268a;
        }
    }

    public static void a(a aVar) {
        b = aVar;
    }

    public static void a() {
        synchronized (c) {
            a.removeMessages(1);
            a.obtainMessage(1).sendToTarget();
        }
    }

    private static void a(a.EnumC0268a enumC0268a, String str, String str2) {
        if (b != null && e.ordinal() <= enumC0268a.ordinal()) {
            synchronized (c) {
                c.addLast(new b(enumC0268a, str, str2));
                if (c.size() >= f.a || f.b <= 0) {
                    a();
                } else if (!a.hasMessages(1)) {
                    a.sendMessageDelayed(a.obtainMessage(1), f.b);
                }
            }
        }
    }

    public static void a(String str, String str2) {
        if (d.ordinal() <= a.EnumC0268a.DEBUG.ordinal()) {
            Log.d(str, str2);
        }
        a(a.EnumC0268a.DEBUG, str, str2);
    }

    public static void b(String str, String str2) {
        if (d.ordinal() <= a.EnumC0268a.INFO.ordinal()) {
            Log.i(str, str2);
        }
        a(a.EnumC0268a.INFO, str, str2);
    }

    public static void c(String str, String str2) {
        if (d.ordinal() <= a.EnumC0268a.WARN.ordinal()) {
            Log.w(str, str2);
        }
        a(a.EnumC0268a.WARN, str, str2);
    }

    public static void d(String str, String str2) {
        if (d.ordinal() <= a.EnumC0268a.ERROR.ordinal()) {
            Log.e(str, str2);
        }
        a(a.EnumC0268a.ERROR, str, str2);
    }

    public static void a(String str, Throwable th) {
        d(str, Log.getStackTraceString(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        static SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss ");
        static String b = String.valueOf(Process.myPid());
        a.EnumC0268a c;
        String d;
        String e;

        b(a.EnumC0268a enumC0268a, String str, String str2) {
            this.c = enumC0268a;
            this.d = a.format(new Date()) + b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(Thread.currentThread().getId()) + " " + str;
            this.e = str2;
        }
    }

    /* loaded from: classes2.dex */
    private static class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (c.b != null) {
                g.a(new g.a() { // from class: com.meizu.cloud.pushsdk.common.b.c.e.1
                    @Override // com.meizu.cloud.pushsdk.common.b.g.a
                    public void a() {
                        LinkedList linkedList;
                        synchronized (c.c) {
                            linkedList = new LinkedList(c.c);
                            c.c.clear();
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            c.b.a(bVar.c, bVar.d, bVar.e);
                        }
                    }
                });
            }
        }
    }
}
