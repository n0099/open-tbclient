package io.reactivex.e;

import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.schedulers.k;
import io.reactivex.v;
import java.util.concurrent.Callable;
/* loaded from: classes6.dex */
public final class a {
    static final v qtt = io.reactivex.d.a.g(new h());
    static final v qtu = io.reactivex.d.a.d(new b());
    static final v qtv = io.reactivex.d.a.e(new c());
    static final v qtw = k.eKs();
    static final v qtx = io.reactivex.d.a.f(new f());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.reactivex.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1282a {
        static final v qty = new io.reactivex.internal.schedulers.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class d {
        static final v qty = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class e {
        static final v qty = new io.reactivex.internal.schedulers.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static final class g {
        static final v qty = new j();
    }

    public static v eKA() {
        return io.reactivex.d.a.a(qtt);
    }

    /* loaded from: classes6.dex */
    static final class c implements Callable<v> {
        c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eKB */
        public v call() throws Exception {
            return d.qty;
        }
    }

    /* loaded from: classes6.dex */
    static final class f implements Callable<v> {
        f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eKB */
        public v call() throws Exception {
            return e.qty;
        }
    }

    /* loaded from: classes6.dex */
    static final class h implements Callable<v> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eKB */
        public v call() throws Exception {
            return g.qty;
        }
    }

    /* loaded from: classes6.dex */
    static final class b implements Callable<v> {
        b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        /* renamed from: eKB */
        public v call() throws Exception {
            return C1282a.qty;
        }
    }
}
