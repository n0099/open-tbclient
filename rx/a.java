package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes5.dex */
public final class a {
    public static final d nLT = c.nLZ;
    public static final d nLU = nLT;
    public static final d nLV = b.nLY;
    public static final d nLW = C0776a.nLX;

    /* loaded from: classes5.dex */
    public interface d {
        boolean dMu() throws MissingBackpressureException;
    }

    /* loaded from: classes5.dex */
    static final class b implements d {
        static final b nLY = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dMu() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C0776a implements d {
        static final C0776a nLX = new C0776a();

        private C0776a() {
        }

        @Override // rx.a.d
        public boolean dMu() {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements d {
        static final c nLZ = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dMu() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
