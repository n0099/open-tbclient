package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d kmz = c.kmF;
    public static final d kmA = kmz;
    public static final d kmB = b.kmE;
    public static final d kmC = C0498a.kmD;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cKY() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b kmE = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cKY() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0498a implements d {
        static final C0498a kmD = new C0498a();

        private C0498a() {
        }

        @Override // rx.a.d
        public boolean cKY() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c kmF = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cKY() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
