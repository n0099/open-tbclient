package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d jUh = c.jUn;
    public static final d jUi = jUh;
    public static final d jUj = b.jUm;
    public static final d jUk = C0477a.jUl;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cDq() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b jUm = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cDq() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0477a implements d {
        static final C0477a jUl = new C0477a();

        private C0477a() {
        }

        @Override // rx.a.d
        public boolean cDq() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c jUn = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cDq() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
