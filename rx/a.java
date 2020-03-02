package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d nMP = c.nMV;
    public static final d nMQ = nMP;
    public static final d nMR = b.nMU;
    public static final d nMS = C0784a.nMT;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dNL() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b nMU = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dNL() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0784a implements d {
        static final C0784a nMT = new C0784a();

        private C0784a() {
        }

        @Override // rx.a.d
        public boolean dNL() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c nMV = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dNL() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
