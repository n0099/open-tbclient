package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d kmy = c.kmE;
    public static final d kmz = kmy;
    public static final d kmA = b.kmD;
    public static final d kmB = C0498a.kmC;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cKW() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b kmD = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cKW() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0498a implements d {
        static final C0498a kmC = new C0498a();

        private C0498a() {
        }

        @Override // rx.a.d
        public boolean cKW() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c kmE = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cKW() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
