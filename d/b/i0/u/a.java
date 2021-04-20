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
    public static final ThreadLocal<a> f62638g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    public c f62642d;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f62639a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f62640b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final C1635a f62641c = new C1635a();

    /* renamed from: e  reason: collision with root package name */
    public long f62643e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f62644f = false;

    /* renamed from: d.b.i0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1635a {
        public C1635a() {
        }

        public void a() {
            a.this.f62643e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.h(aVar.f62643e);
            if (a.this.f62640b.size() > 0) {
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
        public final C1635a f62646a;

        public c(C1635a c1635a) {
            this.f62646a = c1635a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f62647b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f62648c;

        /* renamed from: d  reason: collision with root package name */
        public long f62649d;

        /* renamed from: d.b.i0.u.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1636a implements Runnable {
            public RunnableC1636a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f62649d = SystemClock.uptimeMillis();
                d.this.f62646a.a();
            }
        }

        public d(C1635a c1635a) {
            super(c1635a);
            this.f62649d = -1L;
            this.f62647b = new RunnableC1636a();
            this.f62648c = new Handler(Looper.myLooper());
        }

        @Override // d.b.i0.u.a.c
        public void a() {
            this.f62648c.postDelayed(this.f62647b, Math.max(10 - (SystemClock.uptimeMillis() - this.f62649d), 0L));
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f62651b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f62652c;

        /* renamed from: d.b.i0.u.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1637a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC1637a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                e.this.f62646a.a();
            }
        }

        public e(C1635a c1635a) {
            super(c1635a);
            this.f62651b = Choreographer.getInstance();
            this.f62652c = new Choreographer$FrameCallbackC1637a();
        }

        @Override // d.b.i0.u.a.c
        public void a() {
            this.f62651b.postFrameCallback(this.f62652c);
        }
    }

    public static a i() {
        if (f62638g.get() == null) {
            f62638g.set(new a());
        }
        return f62638g.get();
    }

    public void f(b bVar, long j) {
        if (this.f62640b.size() == 0) {
            j().a();
        }
        if (!this.f62640b.contains(bVar)) {
            this.f62640b.add(bVar);
        }
        if (j > 0) {
            this.f62639a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public final void g() {
        if (this.f62644f) {
            for (int size = this.f62640b.size() - 1; size >= 0; size--) {
                if (this.f62640b.get(size) == null) {
                    this.f62640b.remove(size);
                }
            }
            this.f62644f = false;
        }
    }

    public final void h(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.f62640b.size(); i++) {
            b bVar = this.f62640b.get(i);
            if (bVar != null && k(bVar, uptimeMillis)) {
                bVar.a(j);
            }
        }
        g();
    }

    public final c j() {
        if (this.f62642d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f62642d = new e(this.f62641c);
            } else {
                this.f62642d = new d(this.f62641c);
            }
        }
        return this.f62642d;
    }

    public final boolean k(b bVar, long j) {
        Long l = this.f62639a.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.f62639a.remove(bVar);
            return true;
        }
        return false;
    }

    public void l(b bVar) {
        this.f62639a.remove(bVar);
        int indexOf = this.f62640b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f62640b.set(indexOf, null);
            this.f62644f = true;
        }
    }
}
