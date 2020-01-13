package io.reactivex.f;

import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes5.dex */
public final class a {
    static final v nAq = io.reactivex.e.a.i(new h());
    static final v nAr = io.reactivex.e.a.f(new b());
    static final v nAs = io.reactivex.e.a.g(new c());
    static final v nAt = k.dIs();
    static final v nAu = io.reactivex.e.a.h(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0752a {
        static final v nvi = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d {
        static final v nvi = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e {
        static final v nvi = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class g {
        static final v nvi = new j();
    }

    public static v dIA() {
        return io.reactivex.e.a.f(nAr);
    }

    public static v dIB() {
        return io.reactivex.e.a.g(nAs);
    }

    public static v dIC() {
        return nAt;
    }

    public static v dID() {
        return io.reactivex.e.a.h(nAu);
    }

    public static v dIE() {
        return io.reactivex.e.a.i(nAq);
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
        /* renamed from: dHY */
        public v call() throws Exception {
            return d.nvi;
        }
    }

    /* loaded from: classes5.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dHY */
        public v call() throws Exception {
            return e.nvi;
        }
    }

    /* loaded from: classes5.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dHY */
        public v call() throws Exception {
            return g.nvi;
        }
    }

    /* loaded from: classes5.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dHY */
        public v call() throws Exception {
            return C0752a.nvi;
        }
    }
}
