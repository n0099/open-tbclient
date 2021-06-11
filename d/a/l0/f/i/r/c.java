package d.a.l0.f.i.r;

import android.util.Pair;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f50504a;

    /* renamed from: b  reason: collision with root package name */
    public static final h.n.b f50505b = new a();

    /* loaded from: classes3.dex */
    public static class a implements h.n.b<Pair<Runnable, String>> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Pair<Runnable, String> pair) {
            String name = Thread.currentThread().getName();
            Thread currentThread = Thread.currentThread();
            currentThread.setName(name + "-" + ((String) pair.second));
            try {
                ((Runnable) pair.first).run();
            } catch (Throwable unused) {
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
            return h.h.g(pair).h(Schedulers.io()).f(c.f50505b).l();
        }
    }

    /* renamed from: d.a.l0.f.i.r.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceExecutorC1043c extends Executor {
        void execute(@NonNull Runnable runnable, @NonNull String str);
    }

    /* loaded from: classes3.dex */
    public static class d extends h.t.c<Pair<Runnable, String>, Pair<Runnable, String>> implements InterfaceExecutorC1043c {
        public d(h.t.d dVar) {
            super(dVar);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            execute(runnable, "");
        }

        @Override // d.a.l0.f.i.r.c.InterfaceExecutorC1043c
        public void execute(@NonNull Runnable runnable, @NonNull String str) {
            onNext(Pair.create(runnable, c.c(str)));
        }
    }

    public static InterfaceExecutorC1043c b() {
        if (f50504a == null) {
            synchronized (c.class) {
                if (f50504a == null) {
                    f50504a = new d(PublishSubject.K());
                    f50504a.s().g(new b()).x().y();
                }
            }
        }
        return f50504a;
    }

    public static String c(String str) {
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

    public static void d(@NonNull Runnable runnable, @NonNull String str) {
        b().execute(runnable, str);
    }
}
