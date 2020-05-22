package io.reactivex.f;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes7.dex */
public final class a {
    static final v nrB = io.reactivex.e.a.i(new h());
    static final v nrC = io.reactivex.e.a.f(new b());
    static final v nrD = io.reactivex.e.a.g(new c());
    static final v nrE = k.dKU();
    static final v nrF = io.reactivex.e.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C0867a {
        static final v nms = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class d {
        static final v nms = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class e {
        static final v nms = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class g {
        static final v nms = new j();
    }

    public static v dLc() {
        return io.reactivex.e.a.f(nrC);
    }

    public static v dLd() {
        return io.reactivex.e.a.g(nrD);
    }

    public static v dLe() {
        return nrE;
    }

    public static v dLf() {
        return io.reactivex.e.a.h(nrF);
    }

    public static v dLg() {
        return io.reactivex.e.a.i(nrB);
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
        /* renamed from: dKz */
        public v call() throws Exception {
            return d.nms;
        }
    }

    /* loaded from: classes7.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dKz */
        public v call() throws Exception {
            return e.nms;
        }
    }

    /* loaded from: classes7.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dKz */
        public v call() throws Exception {
            return g.nms;
        }
    }

    /* loaded from: classes7.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dKz */
        public v call() throws Exception {
            return C0867a.nms;
        }
    }
}
