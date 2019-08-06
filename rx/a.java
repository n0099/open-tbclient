package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d kvh = c.kvn;
    public static final d kvi = kvh;
    public static final d kvj = b.kvm;
    public static final d kvk = C0504a.kvl;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cPg() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b kvm = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cPg() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0504a implements d {
        static final C0504a kvl = new C0504a();

        private C0504a() {
        }

        @Override // rx.a.d
        public boolean cPg() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c kvn = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cPg() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
