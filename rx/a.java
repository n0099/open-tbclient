package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d irI = c.irO;
    public static final d irJ = irI;
    public static final d irK = b.irN;
    public static final d irL = C0363a.irM;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cbl() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b irN = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cbl() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0363a implements d {
        static final C0363a irM = new C0363a();

        private C0363a() {
        }

        @Override // rx.a.d
        public boolean cbl() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c irO = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cbl() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
