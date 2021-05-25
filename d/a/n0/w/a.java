package d.a.n0.w;

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
    public static final ThreadLocal<a> f62419g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    public c f62423d;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f62420a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f62421b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final C1693a f62422c = new C1693a();

    /* renamed from: e  reason: collision with root package name */
    public long f62424e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62425f = false;

    /* renamed from: d.a.n0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1693a {
        public C1693a() {
        }

        public void a() {
            a.this.f62424e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.h(aVar.f62424e);
            if (a.this.f62421b.size() > 0) {
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
        public final C1693a f62427a;

        public c(C1693a c1693a) {
            this.f62427a = c1693a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f62428b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f62429c;

        /* renamed from: d  reason: collision with root package name */
        public long f62430d;

        /* renamed from: d.a.n0.w.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1694a implements Runnable {
            public RunnableC1694a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f62430d = SystemClock.uptimeMillis();
                d.this.f62427a.a();
            }
        }

        public d(C1693a c1693a) {
            super(c1693a);
            this.f62430d = -1L;
            this.f62428b = new RunnableC1694a();
            this.f62429c = new Handler(Looper.myLooper());
        }

        @Override // d.a.n0.w.a.c
        public void a() {
            this.f62429c.postDelayed(this.f62428b, Math.max(10 - (SystemClock.uptimeMillis() - this.f62430d), 0L));
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f62432b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f62433c;

        /* renamed from: d.a.n0.w.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1695a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC1695a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                e.this.f62427a.a();
            }
        }

        public e(C1693a c1693a) {
            super(c1693a);
            this.f62432b = Choreographer.getInstance();
            this.f62433c = new Choreographer$FrameCallbackC1695a();
        }

        @Override // d.a.n0.w.a.c
        public void a() {
            this.f62432b.postFrameCallback(this.f62433c);
        }
    }

    public static a i() {
        if (f62419g.get() == null) {
            f62419g.set(new a());
        }
        return f62419g.get();
    }

    public void f(b bVar, long j) {
        if (this.f62421b.size() == 0) {
            j().a();
        }
        if (!this.f62421b.contains(bVar)) {
            this.f62421b.add(bVar);
        }
        if (j > 0) {
            this.f62420a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public final void g() {
        if (this.f62425f) {
            for (int size = this.f62421b.size() - 1; size >= 0; size--) {
                if (this.f62421b.get(size) == null) {
                    this.f62421b.remove(size);
                }
            }
            this.f62425f = false;
        }
    }

    public final void h(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i2 = 0; i2 < this.f62421b.size(); i2++) {
            b bVar = this.f62421b.get(i2);
            if (bVar != null && k(bVar, uptimeMillis)) {
                bVar.a(j);
            }
        }
        g();
    }

    public final c j() {
        if (this.f62423d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f62423d = new e(this.f62422c);
            } else {
                this.f62423d = new d(this.f62422c);
            }
        }
        return this.f62423d;
    }

    public final boolean k(b bVar, long j) {
        Long l = this.f62420a.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.f62420a.remove(bVar);
            return true;
        }
        return false;
    }

    public void l(b bVar) {
        this.f62420a.remove(bVar);
        int indexOf = this.f62421b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f62421b.set(indexOf, null);
            this.f62425f = true;
        }
    }
}
