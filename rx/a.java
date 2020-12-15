package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes12.dex */
public final class a {
    public static final d pOI = c.pOO;
    public static final d pOJ = pOI;
    public static final d pOK = b.pON;
    public static final d pOL = C1059a.pOM;

    /* loaded from: classes12.dex */
    public interface d {
        boolean eFh() throws MissingBackpressureException;
    }

    /* loaded from: classes12.dex */
    static final class b implements d {
        static final b pON = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean eFh() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    static final class C1059a implements d {
        static final C1059a pOM = new C1059a();

        private C1059a() {
        }

        @Override // rx.a.d
        public boolean eFh() {
            return false;
        }
    }

    /* loaded from: classes12.dex */
    static final class c implements d {
        static final c pOO = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eFh() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
