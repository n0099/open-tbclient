package d.a.i0.a.v2;

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
    public static volatile i f45265b;

    /* renamed from: c  reason: collision with root package name */
    public static volatile i f45266c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile i f45267d;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f45264a = d.a.i0.a.k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public static final h.n.b f45268e = new a();

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
                long currentTimeMillis = q.f45264a ? System.currentTimeMillis() : 0L;
                ((Runnable) pair.first).run();
                if (q.f45264a) {
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
            return h.h.g(pair).h(Schedulers.io()).f(q.f45268e).l();
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements h.n.f<Pair<Runnable, String>, h.d<?>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.f
        /* renamed from: a */
        public h.d<?> call(Pair<Runnable, String> pair) {
            return h.h.g(pair).h(Schedulers.computation()).f(q.f45268e).l();
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45269e;

        public d(String str) {
            this.f45269e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            if (q.f45264a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.f45269e + "] fail!", th);
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
        public final /* synthetic */ String f45270e;

        public f(String str) {
            this.f45270e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            if (q.f45264a) {
                Log.wtf("SwanAppExecutorUtils", "delay task [" + this.f45270e + "] fail!", th);
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

        @Override // d.a.i0.a.v2.q.h
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
        if (f45266c == null) {
            synchronized (q.class) {
                if (f45266c == null) {
                    f45266c = new i(PublishSubject.K());
                    f45266c.s().g(new c()).x().y();
                }
            }
        }
        return f45266c;
    }

    public static h f() {
        if (f45265b == null) {
            synchronized (q.class) {
                if (f45265b == null) {
                    f45265b = new i(PublishSubject.K());
                    f45265b.s().g(new b()).x().y();
                }
            }
        }
        return f45265b;
    }

    public static h g() {
        if (f45267d == null) {
            synchronized (q.class) {
                if (f45267d == null) {
                    f45267d = new i(PublishSubject.K());
                    f45267d.s().o(Schedulers.io()).d(f45268e).x().y();
                }
            }
        }
        return f45267d;
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
