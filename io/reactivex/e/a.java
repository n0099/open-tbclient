package io.reactivex.e;

import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
/* loaded from: classes4.dex */
public final class a {
    static final v mYd = io.reactivex.d.a.g(new h());
    static final v mYe = io.reactivex.d.a.d(new b());
    static final v mYf = io.reactivex.d.a.e(new c());
    static final v mYg = k.dEi();
    static final v mYh = io.reactivex.d.a.f(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0709a {
        static final v mYi = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class d {
        static final v mYi = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class e {
        static final v mYi = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static final class g {
        static final v mYi = new j();
    }

    public static v dEq() {
        return io.reactivex.d.a.a(mYd);
    }

    /* loaded from: classes4.dex */
    static final class c implements Callable<v> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dEr */
        public v call() throws Exception {
            return d.mYi;
        }
    }

    /* loaded from: classes4.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dEr */
        public v call() throws Exception {
            return e.mYi;
        }
    }

    /* loaded from: classes4.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dEr */
        public v call() throws Exception {
            return g.mYi;
        }
    }

    /* loaded from: classes4.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: dEr */
        public v call() throws Exception {
            return C0709a.mYi;
        }
    }
}
