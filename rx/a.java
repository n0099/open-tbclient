package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d jUi = c.jUo;
    public static final d jUj = jUi;
    public static final d jUk = b.jUn;
    public static final d jUl = C0477a.jUm;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cDq() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b jUn = new b();

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
        static final C0477a jUm = new C0477a();

        private C0477a() {
        }

        @Override // rx.a.d
        public boolean cDq() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c jUo = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cDq() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
