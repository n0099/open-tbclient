package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes12.dex */
public final class a {
    public static final d pOG = c.pOM;
    public static final d pOH = pOG;
    public static final d pOI = b.pOL;
    public static final d pOJ = C1059a.pOK;

    /* loaded from: classes12.dex */
    public interface d {
        boolean eFg() throws MissingBackpressureException;
    }

    /* loaded from: classes12.dex */
    static final class b implements d {
        static final b pOL = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean eFg() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    static final class C1059a implements d {
        static final C1059a pOK = new C1059a();

        private C1059a() {
        }

        @Override // rx.a.d
        public boolean eFg() {
            return false;
        }
    }

    /* loaded from: classes12.dex */
    static final class c implements d {
        static final c pOM = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eFg() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
