package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d nDv = c.nDB;
    public static final d nDw = nDv;
    public static final d nDx = b.nDA;
    public static final d nDy = C0891a.nDz;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dPc() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b nDA = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dPc() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0891a implements d {
        static final C0891a nDz = new C0891a();

        private C0891a() {
        }

        @Override // rx.a.d
        public boolean dPc() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c nDB = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dPc() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
