package d.b.i0.u;

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
    public static final ThreadLocal<a> f61201g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    public c f61205d;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f61202a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f61203b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final C1591a f61204c = new C1591a();

    /* renamed from: e  reason: collision with root package name */
    public long f61206e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61207f = false;

    /* renamed from: d.b.i0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1591a {
        public C1591a() {
        }

        public void a() {
            a.this.f61206e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.h(aVar.f61206e);
            if (a.this.f61203b.size() > 0) {
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
        public final C1591a f61209a;

        public c(C1591a c1591a) {
            this.f61209a = c1591a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f61210b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f61211c;

        /* renamed from: d  reason: collision with root package name */
        public long f61212d;

        /* renamed from: d.b.i0.u.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1592a implements Runnable {
            public RunnableC1592a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f61212d = SystemClock.uptimeMillis();
                d.this.f61209a.a();
            }
        }

        public d(C1591a c1591a) {
            super(c1591a);
            this.f61212d = -1L;
            this.f61210b = new RunnableC1592a();
            this.f61211c = new Handler(Looper.myLooper());
        }

        @Override // d.b.i0.u.a.c
        public void a() {
            this.f61211c.postDelayed(this.f61210b, Math.max(10 - (SystemClock.uptimeMillis() - this.f61212d), 0L));
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f61214b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f61215c;

        /* renamed from: d.b.i0.u.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1593a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC1593a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                e.this.f61209a.a();
            }
        }

        public e(C1591a c1591a) {
            super(c1591a);
            this.f61214b = Choreographer.getInstance();
            this.f61215c = new Choreographer$FrameCallbackC1593a();
        }

        @Override // d.b.i0.u.a.c
        public void a() {
            this.f61214b.postFrameCallback(this.f61215c);
        }
    }

    public static a i() {
        if (f61201g.get() == null) {
            f61201g.set(new a());
        }
        return f61201g.get();
    }

    public void f(b bVar, long j) {
        if (this.f61203b.size() == 0) {
            j().a();
        }
        if (!this.f61203b.contains(bVar)) {
            this.f61203b.add(bVar);
        }
        if (j > 0) {
            this.f61202a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public final void g() {
        if (this.f61207f) {
            for (int size = this.f61203b.size() - 1; size >= 0; size--) {
                if (this.f61203b.get(size) == null) {
                    this.f61203b.remove(size);
                }
            }
            this.f61207f = false;
        }
    }

    public final void h(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.f61203b.size(); i++) {
            b bVar = this.f61203b.get(i);
            if (bVar != null && k(bVar, uptimeMillis)) {
                bVar.a(j);
            }
        }
        g();
    }

    public final c j() {
        if (this.f61205d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f61205d = new e(this.f61204c);
            } else {
                this.f61205d = new d(this.f61204c);
            }
        }
        return this.f61205d;
    }

    public final boolean k(b bVar, long j) {
        Long l = this.f61202a.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.f61202a.remove(bVar);
            return true;
        }
        return false;
    }

    public void l(b bVar) {
        this.f61202a.remove(bVar);
        int indexOf = this.f61203b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f61203b.set(indexOf, null);
            this.f61207f = true;
        }
    }
}
