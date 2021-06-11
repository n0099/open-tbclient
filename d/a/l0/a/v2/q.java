package d.a.l0.a.v2;

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
    public static volatile i f49115b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile i f49116c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile i f49117d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f49114a = d.a.l0.a.k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public static final h.n.b f49118e = new a();

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
                long currentTimeMillis = q.f49114a ? System.currentTimeMillis() : 0L;
                ((Runnable) pair.first).run();
                if (q.f49114a) {
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
            return h.h.g(pair).h(Schedulers.io()).f(q.f49118e).l();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements h.n.f<Pair<Runnable, String>, h.d<?>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(Pair<Runnable, String> pair) {
            return h.h.g(pair).h(Schedulers.computation()).f(q.f49118e).l();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f49119e;

        public d(String str) {
            this.f49119e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            if (q.f49114a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.f49119e + "] fail!", th);
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
        public final /* synthetic */ String f49120e;

        public f(String str) {
            this.f49120e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            if (q.f49114a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.f49120e + "] fail!", th);
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

        @Override // d.a.l0.a.v2.q.h
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
        if (f49116c == null) {
            synchronized (q.class) {
                if (f49116c == null) {
                    f49116c = new i(PublishSubject.K());
                    f49116c.s().g(new c()).x().y();
                }
            }
        }
        return f49116c;
    }

    public static h f() {
        if (f49115b == null) {
            synchronized (q.class) {
                if (f49115b == null) {
                    f49115b = new i(PublishSubject.K());
                    f49115b.s().g(new b()).x().y();
                }
            }
        }
        return f49115b;
    }

    public static h g() {
        if (f49117d == null) {
            synchronized (q.class) {
                if (f49117d == null) {
                    f49117d = new i(PublishSubject.K());
                    f49117d.s().o(Schedulers.io()).d(f49118e).x().y();
                }
            }
        }
        return f49117d;
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
