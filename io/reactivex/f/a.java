package io.reactivex.f;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes25.dex */
public final class a {
    static final v oBj = io.reactivex.e.a.i(new h());
    static final v oBk = io.reactivex.e.a.f(new b());
    static final v oBl = io.reactivex.e.a.g(new c());
    static final v oBm = k.ejx();
    static final v oBn = io.reactivex.e.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C0958a {
        static final v owc = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static final class d {
        static final v owc = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static final class e {
        static final v owc = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes25.dex */
    public static final class g {
        static final v owc = new j();
    }

    public static v ejF() {
        return io.reactivex.e.a.f(oBk);
    }

    public static v ejG() {
        return io.reactivex.e.a.g(oBl);
    }

    public static v ejH() {
        return oBm;
    }

    public static v ejI() {
        return io.reactivex.e.a.h(oBn);
    }

    public static v ejJ() {
        return io.reactivex.e.a.i(oBj);
    }

    public static v a(Executor executor) {
        return new ExecutorScheduler(executor);
    }

    /* loaded from: classes25.dex */
    static final class c implements Callable<v> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: ejc */
        public v call() throws Exception {
            return d.owc;
        }
    }

    /* loaded from: classes25.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: ejc */
        public v call() throws Exception {
            return e.owc;
        }
    }

    /* loaded from: classes25.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: ejc */
        public v call() throws Exception {
            return g.owc;
        }
    }

    /* loaded from: classes25.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: ejc */
        public v call() throws Exception {
            return C0958a.owc;
        }
    }
}
