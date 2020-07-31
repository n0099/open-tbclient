package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d ojd = c.ojj;
    public static final d oje = ojd;
    public static final d ojf = b.oji;
    public static final d ojg = C0927a.ojh;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dXw() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b oji = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dXw() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0927a implements d {
        static final C0927a ojh = new C0927a();

        private C0927a() {
        }

        @Override // rx.a.d
        public boolean dXw() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c ojj = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dXw() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
