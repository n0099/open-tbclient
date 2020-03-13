package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d nNa = c.nNg;
    public static final d nNb = nNa;
    public static final d nNc = b.nNf;
    public static final d nNd = C0784a.nNe;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dNM() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b nNf = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dNM() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0784a implements d {
        static final C0784a nNe = new C0784a();

        private C0784a() {
        }

        @Override // rx.a.d
        public boolean dNM() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c nNg = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dNM() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
