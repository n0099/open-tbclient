package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
/* loaded from: classes17.dex */
public final class Functions {
    static final io.reactivex.c.h<Object, Object> pCU = new g();
    public static final Runnable pCV = new d();
    public static final io.reactivex.c.a pCW = new a();
    static final io.reactivex.c.g<Object> pCX = new b();
    public static final io.reactivex.c.g<Throwable> pCY = new e();
    public static final io.reactivex.c.g<Throwable> pCZ = new k();
    public static final io.reactivex.c.i pDa = new c();
    static final io.reactivex.c.j<Object> pDb = new l();
    static final io.reactivex.c.j<Object> pDc = new f();
    static final Callable<Object> pDd = new j();
    static final Comparator<Object> pDe = new i();
    public static final io.reactivex.c.g<org.a.d> pDf = new h();

    public static <T> io.reactivex.c.g<T> ewQ() {
        return (io.reactivex.c.g<T>) pCX;
    }

    /* loaded from: classes17.dex */
    enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* loaded from: classes17.dex */
    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes17.dex */
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

    /* loaded from: classes17.dex */
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

    /* loaded from: classes17.dex */
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

    /* loaded from: classes17.dex */
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

    /* loaded from: classes17.dex */
    static final class e implements io.reactivex.c.g<Throwable> {
        e() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        public void accept(Throwable th) {
            io.reactivex.e.a.onError(th);
        }
    }

    /* loaded from: classes17.dex */
    static final class k implements io.reactivex.c.g<Throwable> {
        k() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // io.reactivex.c.g
        public void accept(Throwable th) {
            io.reactivex.e.a.onError(new OnErrorNotImplementedException(th));
        }
    }

    /* loaded from: classes17.dex */
    static final class c implements io.reactivex.c.i {
        c() {
        }

        @Override // io.reactivex.c.i
        public void hI(long j) {
        }
    }

    /* loaded from: classes17.dex */
    static final class l implements io.reactivex.c.j<Object> {
        l() {
        }

        @Override // io.reactivex.c.j
        public boolean test(Object obj) {
            return true;
        }
    }

    /* loaded from: classes17.dex */
    static final class f implements io.reactivex.c.j<Object> {
        f() {
        }

        @Override // io.reactivex.c.j
        public boolean test(Object obj) {
            return false;
        }
    }

    /* loaded from: classes17.dex */
    static final class j implements Callable<Object> {
        j() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* loaded from: classes17.dex */
    static final class i implements Comparator<Object> {
        i() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes17.dex */
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
