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
    public static final ThreadLocal<a> f61202g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    public c f61206d;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f61203a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f61204b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final C1592a f61205c = new C1592a();

    /* renamed from: e  reason: collision with root package name */
    public long f61207e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61208f = false;

    /* renamed from: d.b.i0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1592a {
        public C1592a() {
        }

        public void a() {
            a.this.f61207e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.h(aVar.f61207e);
            if (a.this.f61204b.size() > 0) {
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
        public final C1592a f61210a;

        public c(C1592a c1592a) {
            this.f61210a = c1592a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f61211b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f61212c;

        /* renamed from: d  reason: collision with root package name */
        public long f61213d;

        /* renamed from: d.b.i0.u.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1593a implements Runnable {
            public RunnableC1593a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f61213d = SystemClock.uptimeMillis();
                d.this.f61210a.a();
            }
        }

        public d(C1592a c1592a) {
            super(c1592a);
            this.f61213d = -1L;
            this.f61211b = new RunnableC1593a();
            this.f61212c = new Handler(Looper.myLooper());
        }

        @Override // d.b.i0.u.a.c
        public void a() {
            this.f61212c.postDelayed(this.f61211b, Math.max(10 - (SystemClock.uptimeMillis() - this.f61213d), 0L));
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f61215b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f61216c;

        /* renamed from: d.b.i0.u.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1594a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC1594a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                e.this.f61210a.a();
            }
        }

        public e(C1592a c1592a) {
            super(c1592a);
            this.f61215b = Choreographer.getInstance();
            this.f61216c = new Choreographer$FrameCallbackC1594a();
        }

        @Override // d.b.i0.u.a.c
        public void a() {
            this.f61215b.postFrameCallback(this.f61216c);
        }
    }

    public static a i() {
        if (f61202g.get() == null) {
            f61202g.set(new a());
        }
        return f61202g.get();
    }

    public void f(b bVar, long j) {
        if (this.f61204b.size() == 0) {
            j().a();
        }
        if (!this.f61204b.contains(bVar)) {
            this.f61204b.add(bVar);
        }
        if (j > 0) {
            this.f61203a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public final void g() {
        if (this.f61208f) {
            for (int size = this.f61204b.size() - 1; size >= 0; size--) {
                if (this.f61204b.get(size) == null) {
                    this.f61204b.remove(size);
                }
            }
            this.f61208f = false;
        }
    }

    public final void h(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.f61204b.size(); i++) {
            b bVar = this.f61204b.get(i);
            if (bVar != null && k(bVar, uptimeMillis)) {
                bVar.a(j);
            }
        }
        g();
    }

    public final c j() {
        if (this.f61206d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f61206d = new e(this.f61205c);
            } else {
                this.f61206d = new d(this.f61205c);
            }
        }
        return this.f61206d;
    }

    public final boolean k(b bVar, long j) {
        Long l = this.f61203a.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.f61203a.remove(bVar);
            return true;
        }
        return false;
    }

    public void l(b bVar) {
        this.f61203a.remove(bVar);
        int indexOf = this.f61204b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f61204b.set(indexOf, null);
            this.f61208f = true;
        }
    }
}
