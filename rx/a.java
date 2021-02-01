package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes5.dex */
public final class a {
    public static final d qxu = c.qxA;
    public static final d qxv = qxu;
    public static final d qxw = b.qxz;
    public static final d qxx = C1311a.qxy;

    /* loaded from: classes5.dex */
    public interface d {
        boolean eMt() throws MissingBackpressureException;
    }

    /* loaded from: classes5.dex */
    static final class b implements d {
        static final b qxz = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean eMt() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C1311a implements d {
        static final C1311a qxy = new C1311a();

        private C1311a() {
        }

        @Override // rx.a.d
        public boolean eMt() {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements d {
        static final c qxA = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eMt() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
