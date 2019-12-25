package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes4.dex */
public final class a {
    public static final d ncU = c.nda;
    public static final d ncV = ncU;
    public static final d ncW = b.ncZ;
    public static final d ncX = C0722a.ncY;

    /* loaded from: classes4.dex */
    public interface d {
        boolean dFT() throws MissingBackpressureException;
    }

    /* loaded from: classes4.dex */
    static final class b implements d {
        static final b ncZ = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dFT() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C0722a implements d {
        static final C0722a ncY = new C0722a();

        private C0722a() {
        }

        @Override // rx.a.d
        public boolean dFT() {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    static final class c implements d {
        static final c nda = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dFT() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
