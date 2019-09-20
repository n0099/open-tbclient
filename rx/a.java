package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d kxA = c.kxG;
    public static final d kxB = kxA;
    public static final d kxC = b.kxF;
    public static final d kxD = C0510a.kxE;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cPS() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b kxF = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cPS() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0510a implements d {
        static final C0510a kxE = new C0510a();

        private C0510a() {
        }

        @Override // rx.a.d
        public boolean cPS() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c kxG = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cPS() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
