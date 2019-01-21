package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d iET = c.iEZ;
    public static final d iEU = iET;
    public static final d iEV = b.iEY;
    public static final d iEW = C0404a.iEX;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cej() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b iEY = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cej() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0404a implements d {
        static final C0404a iEX = new C0404a();

        private C0404a() {
        }

        @Override // rx.a.d
        public boolean cej() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c iEZ = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cej() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
