package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes15.dex */
public final class a {
    public static final d qqk = c.qqq;
    public static final d qql = qqk;
    public static final d qqm = b.qqp;
    public static final d qqn = C1277a.qqo;

    /* loaded from: classes15.dex */
    public interface d {
        boolean eNp() throws MissingBackpressureException;
    }

    /* loaded from: classes15.dex */
    static final class b implements d {
        static final b qqp = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean eNp() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    static final class C1277a implements d {
        static final C1277a qqo = new C1277a();

        private C1277a() {
        }

        @Override // rx.a.d
        public boolean eNp() {
            return false;
        }
    }

    /* loaded from: classes15.dex */
    static final class c implements d {
        static final c qqq = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eNp() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
