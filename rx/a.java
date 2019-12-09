package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d kxr = c.kxx;
    public static final d kxs = kxr;
    public static final d kxt = b.kxw;
    public static final d kxu = C0594a.kxv;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cNX() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b kxw = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cNX() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0594a implements d {
        static final C0594a kxv = new C0594a();

        private C0594a() {
        }

        @Override // rx.a.d
        public boolean cNX() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c kxx = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cNX() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
