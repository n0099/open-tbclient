package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d iDL = c.iDR;
    public static final d iDM = iDL;
    public static final d iDN = b.iDQ;
    public static final d iDO = C0405a.iDP;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cdB() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b iDQ = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cdB() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0405a implements d {
        static final C0405a iDP = new C0405a();

        private C0405a() {
        }

        @Override // rx.a.d
        public boolean cdB() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c iDR = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cdB() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
