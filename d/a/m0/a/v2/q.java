package d.a.m0.a.v2;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/* loaded from: classes3.dex */
public final class q {

    /* renamed from: b  reason: collision with root package name */
    public static volatile i f49223b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile i f49224c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile i f49225d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49222a = d.a.m0.a.k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public static final h.n.b f49226e = new a();

    /* loaded from: classes3.dex */
    public static class a implements h.n.b<Pair<Runnable, String>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            boolean z;
            String name = Thread.currentThread().getName();
            Thread currentThread = Thread.currentThread();
            currentThread.setName(name + "-" + ((String) pair.second));
            try {
                long currentTimeMillis = q.f49222a ? System.currentTimeMillis() : 0L;
                ((Runnable) pair.first).run();
                if (q.f49222a) {
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
    public static class b implements h.n.f<Pair<Runnable, String>, h.d<?>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(Pair<Runnable, String> pair) {
            return h.h.g(pair).h(Schedulers.io()).f(q.f49226e).l();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements h.n.f<Pair<Runnable, String>, h.d<?>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(Pair<Runnable, String> pair) {
            return h.h.g(pair).h(Schedulers.computation()).f(q.f49226e).l();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49227e;

        public d(String str) {
            this.f49227e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            if (q.f49222a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.f49227e + "] fail!", th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements h.n.b<Pair<Runnable, String>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            q.f().execute((Runnable) pair.first, (String) pair.second);
        }
    }

    /* loaded from: classes3.dex */
    public static class f implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49228e;

        public f(String str) {
            this.f49228e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            if (q.f49222a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.f49228e + "] fail!", th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g implements h.n.b<Pair<Runnable, String>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            q.e().execute((Runnable) pair.first, (String) pair.second);
        }
    }

    /* loaded from: classes3.dex */
    public interface h extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    /* loaded from: classes3.dex */
    public static class i extends h.t.c<Pair<Runnable, String>, Pair<Runnable, String>> implements h {
        public i(h.t.d dVar) {
            super(dVar);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            execute(runnable, "");
        }

        @Override // d.a.m0.a.v2.q.h
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            onNext(Pair.create(runnable, q.h(str)));
        }
    }

    public static h.k c(@NonNull Runnable runnable, @NonNull String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return h.h.g(Pair.create(runnable, h(str))).c(j, timeUnit).f(new g()).e(new f(str)).i();
    }

    public static h.k d(@NonNull Runnable runnable, @NonNull String str, @NonNull long j, @NonNull TimeUnit timeUnit) {
        return h.h.g(Pair.create(runnable, h(str))).c(j, timeUnit).f(new e()).e(new d(str)).i();
    }

    public static h e() {
        if (f49224c == null) {
            synchronized (q.class) {
                if (f49224c == null) {
                    f49224c = new i(PublishSubject.K());
                    f49224c.s().g(new c()).x().y();
                }
            }
        }
        return f49224c;
    }

    public static h f() {
        if (f49223b == null) {
            synchronized (q.class) {
                if (f49223b == null) {
                    f49223b = new i(PublishSubject.K());
                    f49223b.s().g(new b()).x().y();
                }
            }
        }
        return f49223b;
    }

    public static h g() {
        if (f49225d == null) {
            synchronized (q.class) {
                if (f49225d == null) {
                    f49225d = new i(PublishSubject.K());
                    f49225d.s().o(Schedulers.io()).d(f49226e).x().y();
                }
            }
        }
        return f49225d;
    }

    public static String h(String str) {
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

    public static void i(@NonNull Runnable runnable, @NonNull String str) {
        e().execute(runnable, str);
    }

    public static void j(@NonNull Runnable runnable, @NonNull String str) {
        f().execute(runnable, str);
    }

    public static void k(@NonNull Runnable runnable, @NonNull String str) {
        g().execute(runnable, str);
    }
}
