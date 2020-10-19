package io.reactivex.f;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes17.dex */
public final class a {
    static final v oQy = io.reactivex.e.a.i(new h());
    static final v oQz = io.reactivex.e.a.f(new b());
    static final v oQA = io.reactivex.e.a.g(new c());
    static final v oQB = k.enj();
    static final v oQC = io.reactivex.e.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C0976a {
        static final v oLr = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class d {
        static final v oLr = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class e {
        static final v oLr = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static final class g {
        static final v oLr = new j();
    }

    public static v enr() {
        return io.reactivex.e.a.f(oQz);
    }

    public static v ens() {
        return io.reactivex.e.a.g(oQA);
    }

    public static v ent() {
        return oQB;
    }

    public static v enu() {
        return io.reactivex.e.a.h(oQC);
    }

    public static v env() {
        return io.reactivex.e.a.i(oQy);
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
        /* renamed from: emN */
        public v call() throws Exception {
            return d.oLr;
        }
    }

    /* loaded from: classes17.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: emN */
        public v call() throws Exception {
            return e.oLr;
        }
    }

    /* loaded from: classes17.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: emN */
        public v call() throws Exception {
            return g.oLr;
        }
    }

    /* loaded from: classes17.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: emN */
        public v call() throws Exception {
            return C0976a.oLr;
        }
    }
}
