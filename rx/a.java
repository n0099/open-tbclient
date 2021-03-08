package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes4.dex */
public final class a {
    public static final d qyw = c.qyC;
    public static final d qyx = qyw;
    public static final d qyy = b.qyB;
    public static final d qyz = C1295a.qyA;

    /* loaded from: classes4.dex */
    public interface d {
        boolean eMj() throws MissingBackpressureException;
    }

    /* loaded from: classes4.dex */
    static final class b implements d {
        static final b qyB = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean eMj() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static final class C1295a implements d {
        static final C1295a qyA = new C1295a();

        private C1295a() {
        }

        @Override // rx.a.d
        public boolean eMj() {
            return false;
        }
    }

    /* loaded from: classes4.dex */
    static final class c implements d {
        static final c qyC = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eMj() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
