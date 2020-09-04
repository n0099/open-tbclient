package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes5.dex */
public final class a {
    public static final d oDt = c.oDz;
    public static final d oDu = oDt;
    public static final d oDv = b.oDy;
    public static final d oDw = C0985a.oDx;

    /* loaded from: classes5.dex */
    public interface d {
        boolean ejK() throws MissingBackpressureException;
    }

    /* loaded from: classes5.dex */
    static final class b implements d {
        static final b oDy = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean ejK() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    static final class C0985a implements d {
        static final C0985a oDx = new C0985a();

        private C0985a() {
        }

        @Override // rx.a.d
        public boolean ejK() {
            return false;
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements d {
        static final c oDz = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean ejK() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
