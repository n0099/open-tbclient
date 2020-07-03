package io.reactivex.f;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class a {
    static final v nOy = io.reactivex.e.a.i(new h());
    static final v nOz = io.reactivex.e.a.f(new b());
    static final v nOA = io.reactivex.e.a.g(new c());
    static final v nOB = k.dPO();
    static final v nOC = io.reactivex.e.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0887a {
        static final v nJr = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d {
        static final v nJr = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class e {
        static final v nJr = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class g {
        static final v nJr = new j();
    }

    public static v dPW() {
        return io.reactivex.e.a.f(nOz);
    }

    public static v dPX() {
        return io.reactivex.e.a.g(nOA);
    }

    public static v dPY() {
        return nOB;
    }

    public static v dPZ() {
        return io.reactivex.e.a.h(nOC);
    }

    public static v dQa() {
        return io.reactivex.e.a.i(nOy);
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
        /* renamed from: dPt */
        public v call() throws Exception {
            return d.nJr;
        }
    }

    /* loaded from: classes7.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dPt */
        public v call() throws Exception {
            return e.nJr;
        }
    }

    /* loaded from: classes7.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dPt */
        public v call() throws Exception {
            return g.nJr;
        }
    }

    /* loaded from: classes7.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dPt */
        public v call() throws Exception {
            return C0887a.nJr;
        }
    }
}
