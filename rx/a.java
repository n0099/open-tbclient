package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d ojf = c.ojl;
    public static final d ojg = ojf;
    public static final d ojh = b.ojk;
    public static final d oji = C0927a.ojj;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dXx() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b ojk = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dXx() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0927a implements d {
        static final C0927a ojj = new C0927a();

        private C0927a() {
        }

        @Override // rx.a.d
        public boolean dXx() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c ojl = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dXx() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
