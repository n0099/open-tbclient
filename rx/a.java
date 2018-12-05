package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d iAB = c.iAH;
    public static final d iAC = iAB;
    public static final d iAD = b.iAG;
    public static final d iAE = C0405a.iAF;

    /* loaded from: classes2.dex */
    public interface d {
        boolean ccL() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b iAG = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean ccL() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0405a implements d {
        static final C0405a iAF = new C0405a();

        private C0405a() {
        }

        @Override // rx.a.d
        public boolean ccL() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c iAH = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean ccL() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
