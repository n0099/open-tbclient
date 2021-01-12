package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes14.dex */
public final class a {
    public static final d qnq = c.qnw;
    public static final d qnr = qnq;
    public static final d qns = b.qnv;
    public static final d qnt = C1301a.qnu;

    /* loaded from: classes14.dex */
    public interface d {
        boolean eKd() throws MissingBackpressureException;
    }

    /* loaded from: classes14.dex */
    static final class b implements d {
        static final b qnv = new b();

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
        static final C1301a qnu = new C1301a();

        private C1301a() {
        }

        @Override // rx.a.d
        public boolean eKd() {
            return false;
        }
    }

    /* loaded from: classes14.dex */
    static final class c implements d {
        static final c qnw = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eKd() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
