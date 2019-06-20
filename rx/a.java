package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d kmC = c.kmI;
    public static final d kmD = kmC;
    public static final d kmE = b.kmH;
    public static final d kmF = C0498a.kmG;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cKX() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b kmH = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cKX() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0498a implements d {
        static final C0498a kmG = new C0498a();

        private C0498a() {
        }

        @Override // rx.a.d
        public boolean cKX() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c kmI = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cKX() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
