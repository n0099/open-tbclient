package d.a.o0.w;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<a> f66259g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    public c f66263d;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f66260a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f66261b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final C1754a f66262c = new C1754a();

    /* renamed from: e  reason: collision with root package name */
    public long f66264e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66265f = false;

    /* renamed from: d.a.o0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1754a {
        public C1754a() {
        }

        public void a() {
            a.this.f66264e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.h(aVar.f66264e);
            if (a.this.f66261b.size() > 0) {
                a.this.j().a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean a(long j);
    }

    /* loaded from: classes4.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public final C1754a f66267a;

        public c(C1754a c1754a) {
            this.f66267a = c1754a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f66268b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f66269c;

        /* renamed from: d  reason: collision with root package name */
        public long f66270d;

        /* renamed from: d.a.o0.w.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1755a implements Runnable {
            public RunnableC1755a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f66270d = SystemClock.uptimeMillis();
                d.this.f66267a.a();
            }
        }

        public d(C1754a c1754a) {
            super(c1754a);
            this.f66270d = -1L;
            this.f66268b = new RunnableC1755a();
            this.f66269c = new Handler(Looper.myLooper());
        }

        @Override // d.a.o0.w.a.c
        public void a() {
            this.f66269c.postDelayed(this.f66268b, Math.max(10 - (SystemClock.uptimeMillis() - this.f66270d), 0L));
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f66272b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f66273c;

        /* renamed from: d.a.o0.w.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1756a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC1756a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                e.this.f66267a.a();
            }
        }

        public e(C1754a c1754a) {
            super(c1754a);
            this.f66272b = Choreographer.getInstance();
            this.f66273c = new Choreographer$FrameCallbackC1756a();
        }

        @Override // d.a.o0.w.a.c
        public void a() {
            this.f66272b.postFrameCallback(this.f66273c);
        }
    }

    public static a i() {
        if (f66259g.get() == null) {
            f66259g.set(new a());
        }
        return f66259g.get();
    }

    public void f(b bVar, long j) {
        if (this.f66261b.size() == 0) {
            j().a();
        }
        if (!this.f66261b.contains(bVar)) {
            this.f66261b.add(bVar);
        }
        if (j > 0) {
            this.f66260a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public final void g() {
        if (this.f66265f) {
            for (int size = this.f66261b.size() - 1; size >= 0; size--) {
                if (this.f66261b.get(size) == null) {
                    this.f66261b.remove(size);
                }
            }
            this.f66265f = false;
        }
    }

    public final void h(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i2 = 0; i2 < this.f66261b.size(); i2++) {
            b bVar = this.f66261b.get(i2);
            if (bVar != null && k(bVar, uptimeMillis)) {
                bVar.a(j);
            }
        }
        g();
    }

    public final c j() {
        if (this.f66263d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f66263d = new e(this.f66262c);
            } else {
                this.f66263d = new d(this.f66262c);
            }
        }
        return this.f66263d;
    }

    public final boolean k(b bVar, long j) {
        Long l = this.f66260a.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.f66260a.remove(bVar);
            return true;
        }
        return false;
    }

    public void l(b bVar) {
        this.f66260a.remove(bVar);
        int indexOf = this.f66261b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f66261b.set(indexOf, null);
            this.f66265f = true;
        }
    }
}
