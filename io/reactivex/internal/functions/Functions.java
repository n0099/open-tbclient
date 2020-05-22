package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
/* loaded from: classes7.dex */
public final class Functions {
    static final io.reactivex.c.h<Object, Object> nmy = new g();
    public static final Runnable nmz = new d();
    public static final io.reactivex.c.a nmA = new a();
    static final io.reactivex.c.g<Object> nmB = new b();
    public static final io.reactivex.c.g<Throwable> nmC = new e();
    public static final io.reactivex.c.g<Throwable> nmD = new k();
    public static final io.reactivex.c.i nmE = new c();
    static final io.reactivex.c.j<Object> nmF = new l();
    static final io.reactivex.c.j<Object> nmG = new f();
    static final Callable<Object> nmH = new j();
    static final Comparator<Object> nmI = new i();
    public static final io.reactivex.c.g<org.a.d> nmJ = new h();

    public static <T> io.reactivex.c.g<T> dKC() {
        return (io.reactivex.c.g<T>) nmB;
    }

    /* loaded from: classes7.dex */
    enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* loaded from: classes7.dex */
    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes7.dex */
    static final class g implements io.reactivex.c.h<Object, Object> {
        g() {
        }

        @Override // io.reactivex.c.h
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
    static final class a implements io.reactivex.c.a {
        a() {
        }

        @Override // io.reactivex.c.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* loaded from: classes7.dex */
    static final class b implements io.reactivex.c.g<Object> {
        b() {
        }

        @Override // io.reactivex.c.g
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* loaded from: classes7.dex */
    static final class e implements io.reactivex.c.g<Throwable> {
        e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        public void accept(Throwable th) {
            io.reactivex.e.a.onError(th);
        }
    }

    /* loaded from: classes7.dex */
    static final class k implements io.reactivex.c.g<Throwable> {
        k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        public void accept(Throwable th) {
            io.reactivex.e.a.onError(new OnErrorNotImplementedException(th));
        }
    }

    /* loaded from: classes7.dex */
    static final class c implements io.reactivex.c.i {
        c() {
        }

        @Override // io.reactivex.c.i
        public void gf(long j) {
        }
    }

    /* loaded from: classes7.dex */
    static final class l implements io.reactivex.c.j<Object> {
        l() {
        }

        @Override // io.reactivex.c.j
        public boolean test(Object obj) {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    static final class f implements io.reactivex.c.j<Object> {
        f() {
        }

        @Override // io.reactivex.c.j
        public boolean test(Object obj) {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    static final class j implements Callable<Object> {
        j() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* loaded from: classes7.dex */
    static final class i implements Comparator<Object> {
        i() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes7.dex */
    static final class h implements io.reactivex.c.g<org.a.d> {
        h() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        public void accept(org.a.d dVar) throws Exception {
            dVar.request(Long.MAX_VALUE);
        }
    }
}
