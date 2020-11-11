package io.reactivex.f;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes17.dex */
public final class a {
    static final v pRp = io.reactivex.e.a.i(new h());
    static final v pRq = io.reactivex.e.a.f(new b());
    static final v pRr = io.reactivex.e.a.g(new c());
    static final v pRs = k.eAX();
    static final v pRt = io.reactivex.e.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C1068a {
        static final v pMi = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class d {
        static final v pMi = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class e {
        static final v pMi = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class g {
        static final v pMi = new j();
    }

    public static v eBf() {
        return io.reactivex.e.a.f(pRq);
    }

    public static v eBg() {
        return io.reactivex.e.a.g(pRr);
    }

    public static v eBh() {
        return pRs;
    }

    public static v eBi() {
        return io.reactivex.e.a.h(pRt);
    }

    public static v eBj() {
        return io.reactivex.e.a.i(pRp);
    }

    public static v a(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    /* loaded from: classes17.dex */
    static final class c implements Callable<v> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eAC */
        public v call() throws Exception {
            return d.pMi;
        }
    }

    /* loaded from: classes17.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eAC */
        public v call() throws Exception {
            return e.pMi;
        }
    }

    /* loaded from: classes17.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eAC */
        public v call() throws Exception {
            return g.pMi;
        }
    }

    /* loaded from: classes17.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eAC */
        public v call() throws Exception {
            return C1068a.pMi;
        }
    }
}
