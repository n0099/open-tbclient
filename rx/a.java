package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d jUX = c.jVd;
    public static final d jUY = jUX;
    public static final d jUZ = b.jVc;
    public static final d jVa = C0382a.jVb;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cDy() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b jVc = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cDy() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0382a implements d {
        static final C0382a jVb = new C0382a();

        private C0382a() {
        }

        @Override // rx.a.d
        public boolean cDy() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c jVd = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cDy() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
