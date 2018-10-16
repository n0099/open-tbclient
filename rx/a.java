package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d irH = c.irN;
    public static final d irI = irH;
    public static final d irJ = b.irM;
    public static final d irK = C0363a.irL;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cbl() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b irM = new b();

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
        static final C0363a irL = new C0363a();

        private C0363a() {
        }

        @Override // rx.a.d
        public boolean cbl() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c irN = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cbl() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
