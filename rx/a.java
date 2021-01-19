package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes14.dex */
public final class a {
    public static final d qnr = c.qnx;
    public static final d qns = qnr;
    public static final d qnt = b.qnw;
    public static final d qnu = C1301a.qnv;

    /* loaded from: classes14.dex */
    public interface d {
        boolean eKd() throws MissingBackpressureException;
    }

    /* loaded from: classes14.dex */
    static final class b implements d {
        static final b qnw = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean eKd() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    static final class C1301a implements d {
        static final C1301a qnv = new C1301a();

        private C1301a() {
        }

        @Override // rx.a.d
        public boolean eKd() {
            return false;
        }
    }

    /* loaded from: classes14.dex */
    static final class c implements d {
        static final c qnx = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eKd() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
