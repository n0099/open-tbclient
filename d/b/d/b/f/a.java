package d.b.d.b.f;

import android.os.SystemClock;
import android.util.Log;
import d.b.d.b.i;
import d.b.d.b.k;
import d.b.d.b.l;
import d.b.d.b.m;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes6.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* renamed from: i  reason: collision with root package name */
    public static a f65851i;

    /* renamed from: e  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f65852e;

    /* renamed from: g  reason: collision with root package name */
    public b f65854g;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<Thread.UncaughtExceptionHandler> f65853f = new HashSet<>();

    /* renamed from: h  reason: collision with root package name */
    public long f65855h = -1;

    /* renamed from: d.b.d.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1836a extends Thread {
        public C1836a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            try {
                while (true) {
                    SystemClock.sleep(Math.abs(new Random().nextLong()) % 5000);
                    a.this.g();
                }
            } catch (Throwable unused) {
            }
        }
    }

    public a() {
        g();
        e();
    }

    public static a a() {
        if (f65851i == null) {
            f65851i = new a();
        }
        return f65851i;
    }

    public void c(b bVar) {
        this.f65854g = bVar;
    }

    public final boolean d(Thread thread, Throwable th) {
        k g2 = m.c().g();
        if (g2 != null) {
            try {
                return g2.a(th, thread);
            } catch (Throwable unused) {
                return true;
            }
        }
        return true;
    }

    public final void e() {
        try {
            new C1836a().start();
        } catch (Throwable unused) {
        }
    }

    public final void f(Thread thread, Throwable th) {
        List<i> e2 = m.c().e();
        com.bytedance.tea.crash.c cVar = com.bytedance.tea.crash.c.JAVA;
        for (i iVar : e2) {
            try {
                iVar.a(cVar, l.n.a(th), thread);
            } catch (Throwable th2) {
                l.k.c(th2);
            }
        }
    }

    public final void g() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != this) {
            Thread.setDefaultUncaughtExceptionHandler(this);
            if (this.f65852e == null) {
                this.f65852e = defaultUncaughtExceptionHandler;
            } else {
                this.f65853f.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    public final void h(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.f65853f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.f65852e.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean d2;
        if (SystemClock.uptimeMillis() - this.f65855h < 20000) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f65855h = SystemClock.uptimeMillis();
            d2 = d(thread, th);
        } finally {
            try {
            } finally {
            }
        }
        if (d2) {
            com.bytedance.tea.crash.c cVar = com.bytedance.tea.crash.c.JAVA;
            f(thread, th);
            if (d2 && this.f65854g != null && this.f65854g.a(th)) {
                this.f65854g.a(currentTimeMillis, thread, th);
                Log.i("crash_dispatcher", "end dispose " + th);
            }
        }
    }
}
