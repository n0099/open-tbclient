package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes5.dex */
public final class a {
    public static final d nLY = c.nMe;
    public static final d nLZ = nLY;
    public static final d nMa = b.nMd;
    public static final d nMb = C0776a.nMc;

    /* loaded from: classes5.dex */
    public interface d {
        boolean dMw() throws MissingBackpressureException;
    }

    /* loaded from: classes5.dex */
    static final class b implements d {
        static final b nMd = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dMw() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C0776a implements d {
        static final C0776a nMc = new C0776a();

        private C0776a() {
        }

        @Override // rx.a.d
        public boolean dMw() {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements d {
        static final c nMe = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dMw() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
