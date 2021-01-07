package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes15.dex */
public final class a {
    public static final d qrS = c.qrY;
    public static final d qrT = qrS;
    public static final d qrU = b.qrX;
    public static final d qrV = C1318a.qrW;

    /* loaded from: classes15.dex */
    public interface d {
        boolean eNT() throws MissingBackpressureException;
    }

    /* loaded from: classes15.dex */
    static final class b implements d {
        static final b qrX = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean eNT() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    static final class C1318a implements d {
        static final C1318a qrW = new C1318a();

        private C1318a() {
        }

        @Override // rx.a.d
        public boolean eNT() {
            return false;
        }
    }

    /* loaded from: classes15.dex */
    static final class c implements d {
        static final c qrY = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean eNT() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
