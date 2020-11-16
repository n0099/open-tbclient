package io.reactivex.f;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public final class a {
    static final v pSS = io.reactivex.e.a.i(new h());
    static final v pST = io.reactivex.e.a.f(new b());
    static final v pSU = io.reactivex.e.a.g(new c());
    static final v pSV = k.eAY();
    static final v pSW = io.reactivex.e.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1071a {
        static final v pNL = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d {
        static final v pNL = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e {
        static final v pNL = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class g {
        static final v pNL = new j();
    }

    public static v eBg() {
        return io.reactivex.e.a.f(pST);
    }

    public static v eBh() {
        return io.reactivex.e.a.g(pSU);
    }

    public static v eBi() {
        return pSV;
    }

    public static v eBj() {
        return io.reactivex.e.a.h(pSW);
    }

    public static v eBk() {
        return io.reactivex.e.a.i(pSS);
    }

    public static v a(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    /* loaded from: classes5.dex */
    static final class c implements Callable<v> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eAD */
        public v call() throws Exception {
            return d.pNL;
        }
    }

    /* loaded from: classes5.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eAD */
        public v call() throws Exception {
            return e.pNL;
        }
    }

    /* loaded from: classes5.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eAD */
        public v call() throws Exception {
            return g.pNL;
        }
    }

    /* loaded from: classes5.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eAD */
        public v call() throws Exception {
            return C1071a.pNL;
        }
    }
}
