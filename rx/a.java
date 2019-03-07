package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d jUE = c.jUK;
    public static final d jUF = jUE;
    public static final d jUG = b.jUJ;
    public static final d jUH = C0379a.jUI;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cDo() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b jUJ = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cDo() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0379a implements d {
        static final C0379a jUI = new C0379a();

        private C0379a() {
        }

        @Override // rx.a.d
        public boolean cDo() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c jUK = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cDo() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
