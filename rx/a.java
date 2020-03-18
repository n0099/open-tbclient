package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d nON = c.nOT;
    public static final d nOO = nON;
    public static final d nOP = b.nOS;
    public static final d nOQ = C0785a.nOR;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dOm() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b nOS = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dOm() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0785a implements d {
        static final C0785a nOR = new C0785a();

        private C0785a() {
        }

        @Override // rx.a.d
        public boolean dOm() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c nOT = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dOm() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
