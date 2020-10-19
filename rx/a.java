package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes16.dex */
public final class a {
    public static final d pco = c.pcu;
    public static final d pcp = pco;
    public static final d pcq = b.pct;
    public static final d pcr = C1000a.pcs;

    /* loaded from: classes16.dex */
    public interface d {
        boolean ert() throws MissingBackpressureException;
    }

    /* loaded from: classes16.dex */
    static final class b implements d {
        static final b pct = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean ert() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    static final class C1000a implements d {
        static final C1000a pcs = new C1000a();

        private C1000a() {
        }

        @Override // rx.a.d
        public boolean ert() {
            return false;
        }
    }

    /* loaded from: classes16.dex */
    static final class c implements d {
        static final c pcu = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean ert() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
