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
    public static a f69729i;

    /* renamed from: e  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f69730e;

    /* renamed from: g  reason: collision with root package name */
    public b f69732g;

    /* renamed from: f  reason: collision with root package name */
    public HashSet<Thread.UncaughtExceptionHandler> f69731f = new HashSet<>();

    /* renamed from: h  reason: collision with root package name */
    public long f69733h = -1;

    /* renamed from: d.b.d.b.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1902a extends Thread {
        public C1902a() {
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
        if (f69729i == null) {
            f69729i = new a();
        }
        return f69729i;
    }

    public void c(b bVar) {
        this.f69732g = bVar;
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
            new C1902a().start();
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
            if (this.f69730e == null) {
                this.f69730e = defaultUncaughtExceptionHandler;
            } else {
                this.f69731f.add(defaultUncaughtExceptionHandler);
            }
        }
    }

    public final void h(Thread thread, Throwable th) {
        try {
            Iterator<Thread.UncaughtExceptionHandler> it = this.f69731f.iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            this.f69730e.uncaughtException(thread, th);
        } catch (Throwable unused2) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean d2;
        if (SystemClock.uptimeMillis() - this.f69733h < 20000) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f69733h = SystemClock.uptimeMillis();
            d2 = d(thread, th);
        } finally {
            try {
            } finally {
            }
        }
        if (d2) {
            com.bytedance.tea.crash.c cVar = com.bytedance.tea.crash.c.JAVA;
            f(thread, th);
            if (d2 && this.f69732g != null && this.f69732g.a(th)) {
                this.f69732g.a(currentTimeMillis, thread, th);
                Log.i("crash_dispatcher", "end dispose " + th);
            }
        }
    }
}
