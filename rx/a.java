package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes14.dex */
public final class a {
    public static final d qeE = c.qeK;
    public static final d qeF = qeE;
    public static final d qeG = b.qeJ;
    public static final d qeH = C1095a.qeI;

    /* loaded from: classes14.dex */
    public interface d {
        boolean eFh() throws MissingBackpressureException;
    }

    /* loaded from: classes14.dex */
    static final class b implements d {
        static final b qeJ = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean eFh() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    static final class C1095a implements d {
        static final C1095a qeI = new C1095a();

        private C1095a() {
        }

        @Override // rx.a.d
        public boolean eFh() {
            return false;
        }
    }

    /* loaded from: classes14.dex */
    static final class c implements d {
        static final c qeK = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eFh() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
