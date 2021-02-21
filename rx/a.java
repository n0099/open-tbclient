package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes5.dex */
public final class a {
    public static final d qxU = c.qya;
    public static final d qxV = qxU;
    public static final d qxW = b.qxZ;
    public static final d qxX = C1313a.qxY;

    /* loaded from: classes5.dex */
    public interface d {
        boolean eMB() throws MissingBackpressureException;
    }

    /* loaded from: classes5.dex */
    static final class b implements d {
        static final b qxZ = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean eMB() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C1313a implements d {
        static final C1313a qxY = new C1313a();

        private C1313a() {
        }

        @Override // rx.a.d
        public boolean eMB() {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements d {
        static final c qya = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eMB() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
