package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d oaq = c.oaw;
    public static final d oar = oaq;
    public static final d oas = b.oav;
    public static final d oat = C0911a.oau;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dTW() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b oav = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dTW() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0911a implements d {
        static final C0911a oau = new C0911a();

        private C0911a() {
        }

        @Override // rx.a.d
        public boolean dTW() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c oaw = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dTW() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
