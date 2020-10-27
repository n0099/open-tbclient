package io.reactivex.f;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes17.dex */
public final class a {
    static final v pHV = io.reactivex.e.a.i(new h());
    static final v pHW = io.reactivex.e.a.f(new b());
    static final v pHX = io.reactivex.e.a.g(new c());
    static final v pHY = k.exi();
    static final v pHZ = io.reactivex.e.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C1048a {
        static final v pCO = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class d {
        static final v pCO = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class e {
        static final v pCO = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class g {
        static final v pCO = new j();
    }

    public static v exq() {
        return io.reactivex.e.a.f(pHW);
    }

    public static v exr() {
        return io.reactivex.e.a.g(pHX);
    }

    public static v exs() {
        return pHY;
    }

    public static v ext() {
        return io.reactivex.e.a.h(pHZ);
    }

    public static v exu() {
        return io.reactivex.e.a.i(pHV);
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
        /* renamed from: ewN */
        public v call() throws Exception {
            return d.pCO;
        }
    }

    /* loaded from: classes17.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: ewN */
        public v call() throws Exception {
            return e.pCO;
        }
    }

    /* loaded from: classes17.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: ewN */
        public v call() throws Exception {
            return g.pCO;
        }
    }

    /* loaded from: classes17.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: ewN */
        public v call() throws Exception {
            return C1048a.pCO;
        }
    }
}
