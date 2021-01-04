package io.reactivex.e;

import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
/* loaded from: classes3.dex */
public final class a {
    static final v qlg = io.reactivex.d.a.g(new h());
    static final v qlh = io.reactivex.d.a.d(new b());
    static final v qli = io.reactivex.d.a.e(new c());
    static final v qlj = k.eLy();
    static final v qlk = io.reactivex.d.a.f(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C1264a {
        static final v qll = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class d {
        static final v qll = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class e {
        static final v qll = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class g {
        static final v qll = new j();
    }

    public static v eLG() {
        return io.reactivex.d.a.a(qlg);
    }

    /* loaded from: classes3.dex */
    static final class c implements Callable<v> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eLH */
        public v call() throws Exception {
            return d.qll;
        }
    }

    /* loaded from: classes3.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eLH */
        public v call() throws Exception {
            return e.qll;
        }
    }

    /* loaded from: classes3.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eLH */
        public v call() throws Exception {
            return g.qll;
        }
    }

    /* loaded from: classes3.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eLH */
        public v call() throws Exception {
            return C1264a.qll;
        }
    }
}
