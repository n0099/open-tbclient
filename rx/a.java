package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes16.dex */
public final class a {
    public static final d qdb = c.qdh;
    public static final d qdc = qdb;
    public static final d qdd = b.qdg;
    public static final d qde = C1092a.qdf;

    /* loaded from: classes16.dex */
    public interface d {
        boolean eFg() throws MissingBackpressureException;
    }

    /* loaded from: classes16.dex */
    static final class b implements d {
        static final b qdg = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean eFg() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    static final class C1092a implements d {
        static final C1092a qdf = new C1092a();

        private C1092a() {
        }

        @Override // rx.a.d
        public boolean eFg() {
            return false;
        }
    }

    /* loaded from: classes16.dex */
    static final class c implements d {
        static final c qdh = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eFg() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
