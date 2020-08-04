package io.reactivex.f;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class a {
    static final v nXm = io.reactivex.e.a.i(new h());
    static final v nXn = io.reactivex.e.a.f(new b());
    static final v nXo = io.reactivex.e.a.g(new c());
    static final v nXp = k.dTp();
    static final v nXq = io.reactivex.e.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0903a {
        static final v nSe = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d {
        static final v nSe = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class e {
        static final v nSe = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class g {
        static final v nSe = new j();
    }

    public static v dTx() {
        return io.reactivex.e.a.f(nXn);
    }

    public static v dTy() {
        return io.reactivex.e.a.g(nXo);
    }

    public static v dTz() {
        return nXp;
    }

    public static v dTA() {
        return io.reactivex.e.a.h(nXq);
    }

    public static v dTB() {
        return io.reactivex.e.a.i(nXm);
    }

    public static v a(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    /* loaded from: classes7.dex */
    static final class c implements Callable<v> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dSU */
        public v call() throws Exception {
            return d.nSe;
        }
    }

    /* loaded from: classes7.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dSU */
        public v call() throws Exception {
            return e.nSe;
        }
    }

    /* loaded from: classes7.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dSU */
        public v call() throws Exception {
            return g.nSe;
        }
    }

    /* loaded from: classes7.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dSU */
        public v call() throws Exception {
            return C0903a.nSe;
        }
    }
}
