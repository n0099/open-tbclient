package com.meizu.cloud.pushsdk.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.meizu.cloud.pushsdk.common.util.f;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class Logger {
    private static Callback b;
    private static Handler a = new c(Looper.getMainLooper());
    private static LinkedList<a> c = new LinkedList<>();
    private static Callback.Level d = Callback.Level.DEBUG;
    private static Callback.Level e = Callback.Level.DEBUG;
    private static b f = new b();

    /* loaded from: classes3.dex */
    public interface Callback {

        /* loaded from: classes3.dex */
        public enum Level {
            DEBUG,
            INFO,
            WARN,
            ERROR,
            NULL
        }

        void a(Level level, String str, String str2);
    }

    /* loaded from: classes3.dex */
    public enum Out {
        CONSOLE,
        FILE
    }

    /* loaded from: classes3.dex */
    public static class b {
        int a = 100;
        int b = BdStatisticsManager.UPLOAD_TIMER_INTERVAL;
    }

    public static void a(Out out, Callback.Level level) {
        if (out == Out.CONSOLE) {
            d = level;
        } else if (out == Out.FILE) {
            e = level;
        }
    }

    public static void a(Callback callback) {
        b = callback;
    }

    public static void a() {
        synchronized (c) {
            a.removeMessages(1);
            a.obtainMessage(1).sendToTarget();
        }
    }

    private static void a(Callback.Level level, String str, String str2) {
        if (b != null && e.ordinal() <= level.ordinal()) {
            synchronized (c) {
                c.addLast(new a(level, str, str2));
                if (c.size() >= f.a || f.b <= 0) {
                    a();
                } else if (!a.hasMessages(1)) {
                    a.sendMessageDelayed(a.obtainMessage(1), f.b);
                }
            }
        }
    }

    public static void a(String str, String str2) {
        if (d.ordinal() <= Callback.Level.DEBUG.ordinal()) {
            Log.d(str, str2);
        }
        a(Callback.Level.DEBUG, str, str2);
    }

    public static void b(String str, String str2) {
        if (d.ordinal() <= Callback.Level.INFO.ordinal()) {
            Log.i(str, str2);
        }
        a(Callback.Level.INFO, str, str2);
    }

    public static void c(String str, String str2) {
        if (d.ordinal() <= Callback.Level.WARN.ordinal()) {
            Log.w(str, str2);
        }
        a(Callback.Level.WARN, str, str2);
    }

    public static void d(String str, String str2) {
        if (d.ordinal() <= Callback.Level.ERROR.ordinal()) {
            Log.e(str, str2);
        }
        a(Callback.Level.ERROR, str, str2);
    }

    public static void a(String str, Throwable th) {
        d(str, Log.getStackTraceString(th));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        static SimpleDateFormat a = new SimpleDateFormat("MM-dd HH:mm:ss ");
        static String b = String.valueOf(Process.myPid());
        Callback.Level c;
        String d;
        String e;

        a(Callback.Level level, String str, String str2) {
            this.c = level;
            this.d = a.format(new Date()) + b + Constants.ACCEPT_TIME_SEPARATOR_SERVER + String.valueOf(Thread.currentThread().getId()) + " " + str;
            this.e = str2;
        }
    }

    /* loaded from: classes3.dex */
    private static class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (Logger.b != null) {
                f.a(new f.a() { // from class: com.meizu.cloud.pushsdk.common.util.Logger.c.1
                    @Override // com.meizu.cloud.pushsdk.common.util.f.a
                    public void a() {
                        LinkedList linkedList;
                        synchronized (Logger.c) {
                            linkedList = new LinkedList(Logger.c);
                            Logger.c.clear();
                        }
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            Logger.b.a(aVar.c, aVar.d, aVar.e);
                        }
                    }
                });
            }
        }
    }
}
