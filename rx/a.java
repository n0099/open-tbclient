package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d kub = c.kuh;
    public static final d kuc = kub;
    public static final d kud = b.kug;
    public static final d kue = C0504a.kuf;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cOL() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b kug = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cOL() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0504a implements d {
        static final C0504a kuf = new C0504a();

        private C0504a() {
        }

        @Override // rx.a.d
        public boolean cOL() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c kuh = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cOL() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
