package io.reactivex.f;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class a {
    static final v nOB = io.reactivex.e.a.i(new h());
    static final v nOC = io.reactivex.e.a.f(new b());
    static final v nOD = io.reactivex.e.a.g(new c());
    static final v nOE = k.dPS();
    static final v nOF = io.reactivex.e.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0888a {
        static final v nJu = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d {
        static final v nJu = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class e {
        static final v nJu = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class g {
        static final v nJu = new j();
    }

    public static v dQa() {
        return io.reactivex.e.a.f(nOC);
    }

    public static v dQb() {
        return io.reactivex.e.a.g(nOD);
    }

    public static v dQc() {
        return nOE;
    }

    public static v dQd() {
        return io.reactivex.e.a.h(nOF);
    }

    public static v dQe() {
        return io.reactivex.e.a.i(nOB);
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
        /* renamed from: dPx */
        public v call() throws Exception {
            return d.nJu;
        }
    }

    /* loaded from: classes7.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dPx */
        public v call() throws Exception {
            return e.nJu;
        }
    }

    /* loaded from: classes7.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dPx */
        public v call() throws Exception {
            return g.nJu;
        }
    }

    /* loaded from: classes7.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dPx */
        public v call() throws Exception {
            return C0888a.nJu;
        }
    }
}
