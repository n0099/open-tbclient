package d.c.d.b.f;

import android.os.SystemClock;
import android.util.Log;
import d.c.d.b.i;
import d.c.d.b.k;
import d.c.d.b.l;
import d.c.d.b.m;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
/* loaded from: classes5.dex */
public class a implements Thread.UncaughtExceptionHandler {
    public static a i;

    /* renamed from: e  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f66762e;

    /* renamed from: g  reason: collision with root package name */
    public b f66764g;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<Thread.UncaughtExceptionHandler> f66763f = new HashSet<>();

    /* renamed from: h  reason: collision with root package name */
    public long f66765h = -1;

    /* renamed from: d.c.d.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1832a extends Thread {
        public C1832a() {
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
        if (i == null) {
            i = new a();
        }
        return i;
    }

    public void c(b bVar) {
        this.f66764g = bVar;
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
            new C1832a().start();
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
            if (this.f66762e == null) {
                this.f66762e = defaultUncaughtExceptionHandler;
            } else {
                this.f66763f.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    public final void h(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.f66763f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.f66762e.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean d2;
        if (SystemClock.uptimeMillis() - this.f66765h < 20000) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f66765h = SystemClock.uptimeMillis();
            d2 = d(thread, th);
        } finally {
            try {
            } finally {
            }
        }
        if (d2) {
            com.bytedance.tea.crash.c cVar = com.bytedance.tea.crash.c.JAVA;
            f(thread, th);
            if (d2 && this.f66764g != null && this.f66764g.a(th)) {
                this.f66764g.a(currentTimeMillis, thread, th);
                Log.i("crash_dispatcher", "end dispose " + th);
            }
        }
    }
}
