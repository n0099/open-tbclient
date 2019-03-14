package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d jUP = c.jUV;
    public static final d jUQ = jUP;
    public static final d jUR = b.jUU;
    public static final d jUS = C0477a.jUT;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cDB() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b jUU = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cDB() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0477a implements d {
        static final C0477a jUT = new C0477a();

        private C0477a() {
        }

        @Override // rx.a.d
        public boolean cDB() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c jUV = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cDB() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
