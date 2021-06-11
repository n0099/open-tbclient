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
    public static final ThreadLocal<a> f66134g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    public c f66138d;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f66135a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f66136b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final C1750a f66137c = new C1750a();

    /* renamed from: e  reason: collision with root package name */
    public long f66139e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66140f = false;

    /* renamed from: d.a.n0.w.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1750a {
        public C1750a() {
        }

        public void a() {
            a.this.f66139e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.h(aVar.f66139e);
            if (a.this.f66136b.size() > 0) {
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
        public final C1750a f66142a;

        public c(C1750a c1750a) {
            this.f66142a = c1750a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f66143b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f66144c;

        /* renamed from: d  reason: collision with root package name */
        public long f66145d;

        /* renamed from: d.a.n0.w.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1751a implements Runnable {
            public RunnableC1751a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f66145d = SystemClock.uptimeMillis();
                d.this.f66142a.a();
            }
        }

        public d(C1750a c1750a) {
            super(c1750a);
            this.f66145d = -1L;
            this.f66143b = new RunnableC1751a();
            this.f66144c = new Handler(Looper.myLooper());
        }

        @Override // d.a.n0.w.a.c
        public void a() {
            this.f66144c.postDelayed(this.f66143b, Math.max(10 - (SystemClock.uptimeMillis() - this.f66145d), 0L));
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f66147b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f66148c;

        /* renamed from: d.a.n0.w.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1752a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC1752a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                e.this.f66142a.a();
            }
        }

        public e(C1750a c1750a) {
            super(c1750a);
            this.f66147b = Choreographer.getInstance();
            this.f66148c = new Choreographer$FrameCallbackC1752a();
        }

        @Override // d.a.n0.w.a.c
        public void a() {
            this.f66147b.postFrameCallback(this.f66148c);
        }
    }

    public static a i() {
        if (f66134g.get() == null) {
            f66134g.set(new a());
        }
        return f66134g.get();
    }

    public void f(b bVar, long j) {
        if (this.f66136b.size() == 0) {
            j().a();
        }
        if (!this.f66136b.contains(bVar)) {
            this.f66136b.add(bVar);
        }
        if (j > 0) {
            this.f66135a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public final void g() {
        if (this.f66140f) {
            for (int size = this.f66136b.size() - 1; size >= 0; size--) {
                if (this.f66136b.get(size) == null) {
                    this.f66136b.remove(size);
                }
            }
            this.f66140f = false;
        }
    }

    public final void h(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i2 = 0; i2 < this.f66136b.size(); i2++) {
            b bVar = this.f66136b.get(i2);
            if (bVar != null && k(bVar, uptimeMillis)) {
                bVar.a(j);
            }
        }
        g();
    }

    public final c j() {
        if (this.f66138d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f66138d = new e(this.f66137c);
            } else {
                this.f66138d = new d(this.f66137c);
            }
        }
        return this.f66138d;
    }

    public final boolean k(b bVar, long j) {
        Long l = this.f66135a.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.f66135a.remove(bVar);
            return true;
        }
        return false;
    }

    public void l(b bVar) {
        this.f66135a.remove(bVar);
        int indexOf = this.f66136b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f66136b.set(indexOf, null);
            this.f66140f = true;
        }
    }
}
