package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d its = c.ity;
    public static final d itt = its;
    public static final d itu = b.itx;
    public static final d itv = C0391a.itw;

    /* loaded from: classes2.dex */
    public interface d {
        boolean caI() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b itx = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean caI() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0391a implements d {
        static final C0391a itw = new C0391a();

        private C0391a() {
        }

        @Override // rx.a.d
        public boolean caI() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c ity = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean caI() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
