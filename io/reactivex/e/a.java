package io.reactivex.e;

import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
/* loaded from: classes5.dex */
public final class a {
    static final v qsr = io.reactivex.d.a.g(new h());
    static final v qss = io.reactivex.d.a.d(new b());
    static final v qst = io.reactivex.d.a.e(new c());
    static final v qsu = k.eKC();
    static final v qsv = io.reactivex.d.a.f(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1298a {
        static final v qsw = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d {
        static final v qsw = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e {
        static final v qsw = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class g {
        static final v qsw = new j();
    }

    public static v eKK() {
        return io.reactivex.d.a.a(qsr);
    }

    /* loaded from: classes5.dex */
    static final class c implements Callable<v> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eKL */
        public v call() throws Exception {
            return d.qsw;
        }
    }

    /* loaded from: classes5.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eKL */
        public v call() throws Exception {
            return e.qsw;
        }
    }

    /* loaded from: classes5.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eKL */
        public v call() throws Exception {
            return g.qsw;
        }
    }

    /* loaded from: classes5.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eKL */
        public v call() throws Exception {
            return C1298a.qsw;
        }
    }
}
