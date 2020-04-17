package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d nis = c.niy;
    public static final d nit = nis;
    public static final d niu = b.nix;
    public static final d niv = C0808a.niw;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dHl() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b nix = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dHl() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0808a implements d {
        static final C0808a niw = new C0808a();

        private C0808a() {
        }

        @Override // rx.a.d
        public boolean dHl() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c niy = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dHl() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
