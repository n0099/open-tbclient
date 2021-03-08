package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
/* loaded from: classes6.dex */
public final class Functions {
    static final io.reactivex.b.h<Object, Object> qoC = new g();
    public static final Runnable qoD = new d();
    public static final io.reactivex.b.a qoE = new a();
    static final io.reactivex.b.g<Object> qoF = new b();
    public static final io.reactivex.b.g<Throwable> qoG = new e();
    public static final io.reactivex.b.g<Throwable> qoH = new k();
    public static final io.reactivex.b.i qoI = new c();
    static final io.reactivex.b.j<Object> qoJ = new l();
    static final io.reactivex.b.j<Object> qoK = new f();
    static final Callable<Object> qoL = new j();
    static final Comparator<Object> qoM = new i();
    public static final io.reactivex.b.g<org.a.d> qoN = new h();

    /* loaded from: classes6.dex */
    enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* loaded from: classes6.dex */
    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes6.dex */
    static final class g implements io.reactivex.b.h<Object, Object> {
        g() {
        }

        @Override // io.reactivex.b.h
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* loaded from: classes6.dex */
    static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* loaded from: classes6.dex */
    static final class a implements io.reactivex.b.a {
        a() {
        }

        @Override // io.reactivex.b.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* loaded from: classes6.dex */
    static final class b implements io.reactivex.b.g<Object> {
        b() {
        }

        @Override // io.reactivex.b.g
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* loaded from: classes6.dex */
    static final class e implements io.reactivex.b.g<Throwable> {
        e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.g
        public void accept(Throwable th) {
            io.reactivex.d.a.onError(th);
        }
    }

    /* loaded from: classes6.dex */
    static final class k implements io.reactivex.b.g<Throwable> {
        k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.g
        public void accept(Throwable th) {
            io.reactivex.d.a.onError(new OnErrorNotImplementedException(th));
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements io.reactivex.b.i {
        c() {
        }
    }

    /* loaded from: classes6.dex */
    static final class l implements io.reactivex.b.j<Object> {
        l() {
        }

        @Override // io.reactivex.b.j
        public boolean test(Object obj) {
            return true;
        }
    }

    /* loaded from: classes6.dex */
    static final class f implements io.reactivex.b.j<Object> {
        f() {
        }

        @Override // io.reactivex.b.j
        public boolean test(Object obj) {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class j implements Callable<Object> {
        j() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* loaded from: classes6.dex */
    static final class i implements Comparator<Object> {
        i() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes6.dex */
    static final class h implements io.reactivex.b.g<org.a.d> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.b.g
        public void accept(org.a.d dVar) throws Exception {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
