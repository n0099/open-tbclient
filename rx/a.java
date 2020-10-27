package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes16.dex */
public final class a {
    public static final d pTH = c.pTN;
    public static final d pTI = pTH;
    public static final d pTJ = b.pTM;
    public static final d pTK = C1072a.pTL;

    /* loaded from: classes16.dex */
    public interface d {
        boolean eBr() throws MissingBackpressureException;
    }

    /* loaded from: classes16.dex */
    static final class b implements d {
        static final b pTM = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean eBr() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    static final class C1072a implements d {
        static final C1072a pTL = new C1072a();

        private C1072a() {
        }

        @Override // rx.a.d
        public boolean eBr() {
            return false;
        }
    }

    /* loaded from: classes16.dex */
    static final class c implements d {
        static final c pTN = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eBr() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
