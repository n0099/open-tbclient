package rx;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class a {
    public static final d kyi = c.kyo;
    public static final d kyj = kyi;
    public static final d kyk = b.kyn;
    public static final d kyl = C0611a.kym;

    /* loaded from: classes2.dex */
    public interface d {
        boolean cNZ() throws MissingBackpressureException;
    }

    /* loaded from: classes2.dex */
    static final class b implements d {
        static final b kyn = new b();

        private b() {
        }

        @Override // rx.a.d
        public boolean cNZ() {
            return true;
        }
    }

    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0611a implements d {
        static final C0611a kym = new C0611a();

        private C0611a() {
        }

        @Override // rx.a.d
        public boolean cNZ() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    static final class c implements d {
        static final c kyo = new c();

        private c() {
        }

        @Override // rx.a.d
        public boolean cNZ() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }
}
