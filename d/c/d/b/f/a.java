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
/* loaded from: classes6.dex */
public class a implements Thread.UncaughtExceptionHandler {
    public static a i;

    /* renamed from: e  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f65822e;

    /* renamed from: g  reason: collision with root package name */
    public b f65824g;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<Thread.UncaughtExceptionHandler> f65823f = new HashSet<>();

    /* renamed from: h  reason: collision with root package name */
    public long f65825h = -1;

    /* renamed from: d.c.d.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1801a extends Thread {
        public C1801a() {
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
        this.f65824g = bVar;
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
            new C1801a().start();
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
            if (this.f65822e == null) {
                this.f65822e = defaultUncaughtExceptionHandler;
            } else {
                this.f65823f.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    public final void h(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.f65823f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.f65822e.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean d2;
        if (SystemClock.uptimeMillis() - this.f65825h < 20000) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f65825h = SystemClock.uptimeMillis();
            d2 = d(thread, th);
        } finally {
            try {
            } finally {
            }
        }
        if (d2) {
            com.bytedance.tea.crash.c cVar = com.bytedance.tea.crash.c.JAVA;
            f(thread, th);
            if (d2 && this.f65824g != null && this.f65824g.a(th)) {
                this.f65824g.a(currentTimeMillis, thread, th);
                Log.i("crash_dispatcher", "end dispose " + th);
            }
        }
    }
}
