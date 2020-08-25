package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes5.dex */
public final class a {
    public static final d oDb = c.oDh;
    public static final d oDc = oDb;
    public static final d oDd = b.oDg;
    public static final d oDe = C0985a.oDf;

    /* loaded from: classes5.dex */
    public interface d {
        boolean ejB() throws MissingBackpressureException;
    }

    /* loaded from: classes5.dex */
    static final class b implements d {
        static final b oDg = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean ejB() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C0985a implements d {
        static final C0985a oDf = new C0985a();

        private C0985a() {
        }

        @Override // rx.a.d
        public boolean ejB() {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements d {
        static final c oDh = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean ejB() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
