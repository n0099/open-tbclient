package h;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d f68405a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f68406b;

    /* renamed from: h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1917a implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final C1917a f68407a = new C1917a();

        @Override // h.a.d
        public boolean a() {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f68408a = new b();

        @Override // h.a.d
        public boolean a() {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f68409a = new c();

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
        c cVar = c.f68409a;
        f68405a = cVar;
        f68406b = cVar;
        b bVar = b.f68408a;
        C1917a c1917a = C1917a.f68407a;
    }
}
