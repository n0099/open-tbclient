package d.b.j0.u;

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
    public static final ThreadLocal<a> f63059g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    public c f63063d;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f63060a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f63061b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final C1658a f63062c = new C1658a();

    /* renamed from: e  reason: collision with root package name */
    public long f63064e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f63065f = false;

    /* renamed from: d.b.j0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1658a {
        public C1658a() {
        }

        public void a() {
            a.this.f63064e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.h(aVar.f63064e);
            if (a.this.f63061b.size() > 0) {
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
        public final C1658a f63067a;

        public c(C1658a c1658a) {
            this.f63067a = c1658a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f63068b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f63069c;

        /* renamed from: d  reason: collision with root package name */
        public long f63070d;

        /* renamed from: d.b.j0.u.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1659a implements Runnable {
            public RunnableC1659a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f63070d = SystemClock.uptimeMillis();
                d.this.f63067a.a();
            }
        }

        public d(C1658a c1658a) {
            super(c1658a);
            this.f63070d = -1L;
            this.f63068b = new RunnableC1659a();
            this.f63069c = new Handler(Looper.myLooper());
        }

        @Override // d.b.j0.u.a.c
        public void a() {
            this.f63069c.postDelayed(this.f63068b, Math.max(10 - (SystemClock.uptimeMillis() - this.f63070d), 0L));
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f63072b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f63073c;

        /* renamed from: d.b.j0.u.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1660a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC1660a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                e.this.f63067a.a();
            }
        }

        public e(C1658a c1658a) {
            super(c1658a);
            this.f63072b = Choreographer.getInstance();
            this.f63073c = new Choreographer$FrameCallbackC1660a();
        }

        @Override // d.b.j0.u.a.c
        public void a() {
            this.f63072b.postFrameCallback(this.f63073c);
        }
    }

    public static a i() {
        if (f63059g.get() == null) {
            f63059g.set(new a());
        }
        return f63059g.get();
    }

    public void f(b bVar, long j) {
        if (this.f63061b.size() == 0) {
            j().a();
        }
        if (!this.f63061b.contains(bVar)) {
            this.f63061b.add(bVar);
        }
        if (j > 0) {
            this.f63060a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public final void g() {
        if (this.f63065f) {
            for (int size = this.f63061b.size() - 1; size >= 0; size--) {
                if (this.f63061b.get(size) == null) {
                    this.f63061b.remove(size);
                }
            }
            this.f63065f = false;
        }
    }

    public final void h(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.f63061b.size(); i++) {
            b bVar = this.f63061b.get(i);
            if (bVar != null && k(bVar, uptimeMillis)) {
                bVar.a(j);
            }
        }
        g();
    }

    public final c j() {
        if (this.f63063d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f63063d = new e(this.f63062c);
            } else {
                this.f63063d = new d(this.f63062c);
            }
        }
        return this.f63063d;
    }

    public final boolean k(b bVar, long j) {
        Long l = this.f63060a.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.f63060a.remove(bVar);
            return true;
        }
        return false;
    }

    public void l(b bVar) {
        this.f63060a.remove(bVar);
        int indexOf = this.f63061b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f63061b.set(indexOf, null);
            this.f63065f = true;
        }
    }
}
