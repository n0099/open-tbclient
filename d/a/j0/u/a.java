package d.a.j0.u;

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
    public static final ThreadLocal<a> f61267g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    public c f61271d;

    /* renamed from: a  reason: collision with root package name */
    public final SimpleArrayMap<b, Long> f61268a = new SimpleArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f61269b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final C1598a f61270c = new C1598a();

    /* renamed from: e  reason: collision with root package name */
    public long f61272e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61273f = false;

    /* renamed from: d.a.j0.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1598a {
        public C1598a() {
        }

        public void a() {
            a.this.f61272e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.h(aVar.f61272e);
            if (a.this.f61269b.size() > 0) {
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
        public final C1598a f61275a;

        public c(C1598a c1598a) {
            this.f61275a = c1598a;
        }

        public abstract void a();
    }

    /* loaded from: classes4.dex */
    public static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f61276b;

        /* renamed from: c  reason: collision with root package name */
        public final Handler f61277c;

        /* renamed from: d  reason: collision with root package name */
        public long f61278d;

        /* renamed from: d.a.j0.u.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1599a implements Runnable {
            public RunnableC1599a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f61278d = SystemClock.uptimeMillis();
                d.this.f61275a.a();
            }
        }

        public d(C1598a c1598a) {
            super(c1598a);
            this.f61278d = -1L;
            this.f61276b = new RunnableC1599a();
            this.f61277c = new Handler(Looper.myLooper());
        }

        @Override // d.a.j0.u.a.c
        public void a() {
            this.f61277c.postDelayed(this.f61276b, Math.max(10 - (SystemClock.uptimeMillis() - this.f61278d), 0L));
        }
    }

    @RequiresApi(16)
    /* loaded from: classes4.dex */
    public static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        public final Choreographer f61280b;

        /* renamed from: c  reason: collision with root package name */
        public final Choreographer.FrameCallback f61281c;

        /* renamed from: d.a.j0.u.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class Choreographer$FrameCallbackC1600a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC1600a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                e.this.f61275a.a();
            }
        }

        public e(C1598a c1598a) {
            super(c1598a);
            this.f61280b = Choreographer.getInstance();
            this.f61281c = new Choreographer$FrameCallbackC1600a();
        }

        @Override // d.a.j0.u.a.c
        public void a() {
            this.f61280b.postFrameCallback(this.f61281c);
        }
    }

    public static a i() {
        if (f61267g.get() == null) {
            f61267g.set(new a());
        }
        return f61267g.get();
    }

    public void f(b bVar, long j) {
        if (this.f61269b.size() == 0) {
            j().a();
        }
        if (!this.f61269b.contains(bVar)) {
            this.f61269b.add(bVar);
        }
        if (j > 0) {
            this.f61268a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public final void g() {
        if (this.f61273f) {
            for (int size = this.f61269b.size() - 1; size >= 0; size--) {
                if (this.f61269b.get(size) == null) {
                    this.f61269b.remove(size);
                }
            }
            this.f61273f = false;
        }
    }

    public final void h(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i2 = 0; i2 < this.f61269b.size(); i2++) {
            b bVar = this.f61269b.get(i2);
            if (bVar != null && k(bVar, uptimeMillis)) {
                bVar.a(j);
            }
        }
        g();
    }

    public final c j() {
        if (this.f61271d == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f61271d = new e(this.f61270c);
            } else {
                this.f61271d = new d(this.f61270c);
            }
        }
        return this.f61271d;
    }

    public final boolean k(b bVar, long j) {
        Long l = this.f61268a.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.f61268a.remove(bVar);
            return true;
        }
        return false;
    }

    public void l(b bVar) {
        this.f61268a.remove(bVar);
        int indexOf = this.f61269b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f61269b.set(indexOf, null);
            this.f61273f = true;
        }
    }
}
