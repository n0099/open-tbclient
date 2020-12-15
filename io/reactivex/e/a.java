package io.reactivex.e;

import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
/* loaded from: classes9.dex */
public final class a {
    static final v pJD = io.reactivex.d.a.g(new h());
    static final v pJE = io.reactivex.d.a.d(new b());
    static final v pJF = io.reactivex.d.a.e(new c());
    static final v pJG = k.eDq();
    static final v pJH = io.reactivex.d.a.f(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1046a {
        static final v pJI = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class d {
        static final v pJI = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class e {
        static final v pJI = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class g {
        static final v pJI = new j();
    }

    public static v eDy() {
        return io.reactivex.d.a.a(pJD);
    }

    /* loaded from: classes9.dex */
    static final class c implements Callable<v> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eDz */
        public v call() throws Exception {
            return d.pJI;
        }
    }

    /* loaded from: classes9.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eDz */
        public v call() throws Exception {
            return e.pJI;
        }
    }

    /* loaded from: classes9.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eDz */
        public v call() throws Exception {
            return g.pJI;
        }
    }

    /* loaded from: classes9.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eDz */
        public v call() throws Exception {
            return C1046a.pJI;
        }
    }
}
