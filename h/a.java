package h;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d f67676a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f67677b;

    /* renamed from: h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1849a implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final C1849a f67678a = new C1849a();

        @Override // h.a.d
        public boolean a() {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f67679a = new b();

        @Override // h.a.d
        public boolean a() {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f67680a = new c();

        @Override // h.a.d
        public boolean a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* loaded from: classes7.dex */
    public interface d {
        boolean a() throws MissingBackpressureException;
    }

    static {
        c cVar = c.f67680a;
        f67676a = cVar;
        f67677b = cVar;
        b bVar = b.f67679a;
        C1849a c1849a = C1849a.f67678a;
    }
}
