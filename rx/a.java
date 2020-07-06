package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d oat = c.oaz;
    public static final d oau = oat;
    public static final d oav = b.oay;
    public static final d oaw = C0912a.oax;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dUa() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b oay = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dUa() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0912a implements d {
        static final C0912a oax = new C0912a();

        private C0912a() {
        }

        @Override // rx.a.d
        public boolean dUa() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c oaz = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dUa() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
