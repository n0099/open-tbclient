package com.bytedance.tea.crash.d;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.tea.crash.e;
import com.bytedance.tea.crash.f;
import com.bytedance.tea.crash.g.j;
import com.bytedance.tea.crash.g.m;
import com.bytedance.tea.crash.h;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes6.dex */
public class a implements Thread.UncaughtExceptionHandler {
    private static a pyl;
    private Thread.UncaughtExceptionHandler b;
    private HashSet<Thread.UncaughtExceptionHandler> c = new HashSet<>();
    private long e = -1;
    private b pym;

    private a() {
        c();
        b();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.tea.crash.d.a$1] */
    private void b() {
        try {
            new Thread() { // from class: com.bytedance.tea.crash.d.a.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    super.run();
                    try {
                        while (true) {
                            SystemClock.sleep(Math.abs(new Random().nextLong()) % 5000);
                            a.this.c();
                        }
                    } catch (Throwable th) {
                    }
                }
            }.start();
        } catch (Throwable th) {
        }
    }

    public static a ern() {
        if (pyl == null) {
            pyl = new a();
        }
        return pyl;
    }

    public void a(b bVar) {
        this.pym = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.b == null) {
                this.b = defaultUncaughtExceptionHandler;
            } else {
                this.c.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (SystemClock.uptimeMillis() - this.e >= 20000) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                this.e = SystemClock.uptimeMillis();
                boolean c = c(thread, th);
                if (c) {
                    com.bytedance.tea.crash.c cVar = com.bytedance.tea.crash.c.JAVA;
                    d(thread, th);
                    if (c && this.pym != null && this.pym.a(th)) {
                        this.pym.a(currentTimeMillis, thread, th);
                        Log.i("crash_dispatcher", "end dispose " + th);
                    }
                }
            } catch (Throwable th2) {
                try {
                    j.a(th2);
                } finally {
                    e(thread, th);
                }
            }
        }
    }

    private boolean c(Thread thread, Throwable th) {
        f erl = h.erw().erl();
        if (erl != null) {
            try {
                return erl.a(th, thread);
            } catch (Throwable th2) {
                return true;
            }
        }
        return true;
    }

    private void d(Thread thread, Throwable th) {
        List<e> b = h.erw().b();
        com.bytedance.tea.crash.c cVar = com.bytedance.tea.crash.c.JAVA;
        for (e eVar : b) {
            try {
                eVar.a(cVar, m.a(th), thread);
            } catch (Throwable th2) {
                j.b(th2);
            }
        }
    }

    private void e(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.c.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable th2) {
                }
            }
            this.b.uncaughtException(thread, th);
        } catch (Throwable th3) {
        }
    }
}
