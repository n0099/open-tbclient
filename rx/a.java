package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d nMN = c.nMT;
    public static final d nMO = nMN;
    public static final d nMP = b.nMS;
    public static final d nMQ = C0784a.nMR;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dNJ() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b nMS = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dNJ() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0784a implements d {
        static final C0784a nMR = new C0784a();

        private C0784a() {
        }

        @Override // rx.a.d
        public boolean dNJ() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c nMT = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dNJ() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
