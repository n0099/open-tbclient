package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes6.dex */
public final class a {
    public static final d niv = c.niB;
    public static final d niw = niv;
    public static final d nix = b.niA;
    public static final d niy = C0829a.niz;

    /* loaded from: classes6.dex */
    public interface d {
        boolean dHi() throws MissingBackpressureException;
    }

    /* loaded from: classes6.dex */
    static final class b implements d {
        static final b niA = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean dHi() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static final class C0829a implements d {
        static final C0829a niz = new C0829a();

        private C0829a() {
        }

        @Override // rx.a.d
        public boolean dHi() {
            return false;
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements d {
        static final c niB = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean dHi() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
