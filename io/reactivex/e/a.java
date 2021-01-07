package io.reactivex.e;

import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
/* loaded from: classes5.dex */
public final class a {
    static final v qmO = io.reactivex.d.a.g(new h());
    static final v qmP = io.reactivex.d.a.d(new b());
    static final v qmQ = io.reactivex.d.a.e(new c());
    static final v qmR = k.eMc();
    static final v qmS = io.reactivex.d.a.f(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1305a {
        static final v qmT = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class d {
        static final v qmT = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e {
        static final v qmT = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class g {
        static final v qmT = new j();
    }

    public static v eMk() {
        return io.reactivex.d.a.a(qmO);
    }

    /* loaded from: classes5.dex */
    static final class c implements Callable<v> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eMl */
        public v call() throws Exception {
            return d.qmT;
        }
    }

    /* loaded from: classes5.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eMl */
        public v call() throws Exception {
            return e.qmT;
        }
    }

    /* loaded from: classes5.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eMl */
        public v call() throws Exception {
            return g.qmT;
        }
    }

    /* loaded from: classes5.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eMl */
        public v call() throws Exception {
            return C1305a.qmT;
        }
    }
}
