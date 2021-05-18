package d.a.k0.u;

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
    public static final ThreadLocal<a> f61991g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    public c f61995d;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f61992a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f61993b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final C1663a f61994c = new C1663a();

    /* renamed from: e  reason: collision with root package name */
    public long f61996e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61997f = false;

    /* renamed from: d.a.k0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1663a {
        public C1663a() {
        }

        public void a() {
            a.this.f61996e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.h(aVar.f61996e);
            if (a.this.f61993b.size() > 0) {
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
        public final C1663a f61999a;

        public c(C1663a c1663a) {
            this.f61999a = c1663a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f62000b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f62001c;

        /* renamed from: d  reason: collision with root package name */
        public long f62002d;

        /* renamed from: d.a.k0.u.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1664a implements Runnable {
            public RunnableC1664a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f62002d = SystemClock.uptimeMillis();
                d.this.f61999a.a();
            }
        }

        public d(C1663a c1663a) {
            super(c1663a);
            this.f62002d = -1L;
            this.f62000b = new RunnableC1664a();
            this.f62001c = new Handler(Looper.myLooper());
        }

        @Override // d.a.k0.u.a.c
        public void a() {
            this.f62001c.postDelayed(this.f62000b, Math.max(10 - (SystemClock.uptimeMillis() - this.f62002d), 0L));
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f62004b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f62005c;

        /* renamed from: d.a.k0.u.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1665a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC1665a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                e.this.f61999a.a();
            }
        }

        public e(C1663a c1663a) {
            super(c1663a);
            this.f62004b = Choreographer.getInstance();
            this.f62005c = new Choreographer$FrameCallbackC1665a();
        }

        @Override // d.a.k0.u.a.c
        public void a() {
            this.f62004b.postFrameCallback(this.f62005c);
        }
    }

    public static a i() {
        if (f61991g.get() == null) {
            f61991g.set(new a());
        }
        return f61991g.get();
    }

    public void f(b bVar, long j) {
        if (this.f61993b.size() == 0) {
            j().a();
        }
        if (!this.f61993b.contains(bVar)) {
            this.f61993b.add(bVar);
        }
        if (j > 0) {
            this.f61992a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public final void g() {
        if (this.f61997f) {
            for (int size = this.f61993b.size() - 1; size >= 0; size--) {
                if (this.f61993b.get(size) == null) {
                    this.f61993b.remove(size);
                }
            }
            this.f61997f = false;
        }
    }

    public final void h(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i2 = 0; i2 < this.f61993b.size(); i2++) {
            b bVar = this.f61993b.get(i2);
            if (bVar != null && k(bVar, uptimeMillis)) {
                bVar.a(j);
            }
        }
        g();
    }

    public final c j() {
        if (this.f61995d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f61995d = new e(this.f61994c);
            } else {
                this.f61995d = new d(this.f61994c);
            }
        }
        return this.f61995d;
    }

    public final boolean k(b bVar, long j) {
        Long l = this.f61992a.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.f61992a.remove(bVar);
            return true;
        }
        return false;
    }

    public void l(b bVar) {
        this.f61992a.remove(bVar);
        int indexOf = this.f61993b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f61993b.set(indexOf, null);
            this.f61997f = true;
        }
    }
}
