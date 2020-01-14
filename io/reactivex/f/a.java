package io.reactivex.f;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public final class a {
    static final v nAv = io.reactivex.e.a.i(new h());
    static final v nAw = io.reactivex.e.a.f(new b());
    static final v nAx = io.reactivex.e.a.g(new c());
    static final v nAy = k.dIu();
    static final v nAz = io.reactivex.e.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0752a {
        static final v nvn = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d {
        static final v nvn = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e {
        static final v nvn = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class g {
        static final v nvn = new j();
    }

    public static v dIC() {
        return io.reactivex.e.a.f(nAw);
    }

    public static v dID() {
        return io.reactivex.e.a.g(nAx);
    }

    public static v dIE() {
        return nAy;
    }

    public static v dIF() {
        return io.reactivex.e.a.h(nAz);
    }

    public static v dIG() {
        return io.reactivex.e.a.i(nAv);
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
        /* renamed from: dIa */
        public v call() throws Exception {
            return d.nvn;
        }
    }

    /* loaded from: classes5.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dIa */
        public v call() throws Exception {
            return e.nvn;
        }
    }

    /* loaded from: classes5.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dIa */
        public v call() throws Exception {
            return g.nvn;
        }
    }

    /* loaded from: classes5.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dIa */
        public v call() throws Exception {
            return C0752a.nvn;
        }
    }
}
