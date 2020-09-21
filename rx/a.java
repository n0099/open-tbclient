package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class a {
    public static final d oMY = c.oNe;
    public static final d oMZ = oMY;
    public static final d oNa = b.oNd;
    public static final d oNb = C0982a.oNc;

    /* loaded from: classes7.dex */
    public interface d {
        boolean enH() throws MissingBackpressureException;
    }

    /* loaded from: classes7.dex */
    static final class b implements d {
        static final b oNd = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean enH() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    static final class C0982a implements d {
        static final C0982a oNc = new C0982a();

        private C0982a() {
        }

        @Override // rx.a.d
        public boolean enH() {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    static final class c implements d {
        static final c oNe = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean enH() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
