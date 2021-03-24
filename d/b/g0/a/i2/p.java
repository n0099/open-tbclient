package d.b.g0.a.i2;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: b  reason: collision with root package name */
    public static volatile k f44739b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile k f44740c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile k f44741d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44738a = d.b.g0.a.k.f45050a;

    /* renamed from: e  reason: collision with root package name */
    public static final h.n.b f44742e = new c();

    /* loaded from: classes3.dex */
    public static class a implements h.n.b<Throwable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            if (p.f44738a) {
                Log.wtf("SwanAppExecutorUtils", "delay task fail", th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements h.n.b<Runnable> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Runnable runnable) {
            runnable.run();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements h.n.b<Pair<Runnable, String>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            boolean z;
            String name = Thread.currentThread().getName();
            Thread currentThread = Thread.currentThread();
            currentThread.setName(name + "-" + ((String) pair.second));
            try {
                long currentTimeMillis = p.f44738a ? System.currentTimeMillis() : 0L;
                ((Runnable) pair.first).run();
                if (p.f44738a) {
                    Log.d("SwanAppExecutorUtils", "Task [" + ((String) pair.second) + "] caused " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                }
            } finally {
                if (z) {
                }
                Thread.currentThread().setName(name);
            }
            Thread.currentThread().setName(name);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements h.n.f<Pair<Runnable, String>, h.d<?>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(Pair<Runnable, String> pair) {
            return h.h.g(pair).h(Schedulers.io()).f(p.f44742e).m();
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements h.n.f<Pair<Runnable, String>, h.d<?>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(Pair<Runnable, String> pair) {
            return h.h.g(pair).h(Schedulers.computation()).f(p.f44742e).m();
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44743e;

        public f(String str) {
            this.f44743e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            if (p.f44738a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.f44743e + "] fail!", th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements h.n.b<Pair<Runnable, String>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            p.g().execute((Runnable) pair.first, (String) pair.second);
        }
    }

    /* loaded from: classes3.dex */
    public static class h implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44744e;

        public h(String str) {
            this.f44744e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            if (p.f44738a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.f44744e + "] fail!", th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class i implements h.n.b<Pair<Runnable, String>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            p.f().execute((Runnable) pair.first, (String) pair.second);
        }
    }

    /* loaded from: classes3.dex */
    public interface j extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    /* loaded from: classes3.dex */
    public static class k extends h.t.c<Pair<Runnable, String>, Pair<Runnable, String>> implements j {
        public k(h.t.d dVar) {
            super(dVar);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            execute(runnable, "");
        }

        @Override // d.b.g0.a.i2.p.j
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            onNext(Pair.create(runnable, p.i(str)));
        }
    }

    public static h.k c(@NonNull Runnable runnable, @NonNull String str, @NonNull long j2, @NonNull TimeUnit timeUnit) {
        return h.h.g(Pair.create(runnable, i(str))).c(j2, timeUnit).f(new i()).e(new h(str)).i();
    }

    public static h.k d(@NonNull Runnable runnable, @NonNull String str, @NonNull long j2, @NonNull TimeUnit timeUnit) {
        return h.h.g(Pair.create(runnable, i(str))).c(j2, timeUnit).f(new g()).e(new f(str)).i();
    }

    public static h.k e(Runnable runnable, long j2, TimeUnit timeUnit) {
        return h.h.g(runnable).c(j2, timeUnit).l(Schedulers.immediate()).f(new b()).e(new a()).i();
    }

    public static j f() {
        if (f44740c == null) {
            synchronized (p.class) {
                if (f44740c == null) {
                    f44740c = new k(PublishSubject.L());
                    f44740c.t().h(new e()).y().z();
                }
            }
        }
        return f44740c;
    }

    public static j g() {
        if (f44739b == null) {
            synchronized (p.class) {
                if (f44739b == null) {
                    f44739b = new k(PublishSubject.L());
                    f44739b.t().h(new d()).y().z();
                }
            }
        }
        return f44739b;
    }

    public static j h() {
        if (f44741d == null) {
            synchronized (p.class) {
                if (f44741d == null) {
                    f44741d = new k(PublishSubject.L());
                    f44741d.t().p(Schedulers.io()).e(f44742e).y().z();
                }
            }
        }
        return f44741d;
    }

    public static String i(String str) {
        if (str == null) {
            str = null;
        } else if (!str.startsWith("SwanAppExecutorUtils_")) {
            str = "SwanAppExecutorUtils_" + str;
        }
        if (str == null) {
            str = "SwanAppExecutorUtils";
        }
        return str.length() > 256 ? str.substring(0, 255) : str;
    }

    public static void j(@NonNull Runnable runnable, @NonNull String str) {
        f().execute(runnable, str);
    }

    public static void k(@NonNull Runnable runnable, @NonNull String str) {
        g().execute(runnable, str);
    }

    public static void l(@NonNull Runnable runnable, @NonNull String str) {
        h().execute(runnable, str);
    }
}
