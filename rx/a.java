package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d nEF = c.nEL;
    public static final d nEG = nEF;
    public static final d nEH = b.nEK;
    public static final d nEI = C0892a.nEJ;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dPq() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b nEK = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dPq() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0892a implements d {
        static final C0892a nEJ = new C0892a();

        private C0892a() {
        }

        @Override // rx.a.d
        public boolean dPq() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c nEL = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dPq() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
