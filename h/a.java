package h;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d f71661a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f71662b;

    /* renamed from: h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1966a implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final C1966a f71663a = new C1966a();

        @Override // h.a.d
        public boolean a() {
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f71664a = new b();

        @Override // h.a.d
        public boolean a() {
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f71665a = new c();

        @Override // h.a.d
        public boolean a() throws MissingBackpressureException {
            throw new MissingBackpressureException("Overflowed buffer");
        }
    }

    /* loaded from: classes8.dex */
    public interface d {
        boolean a() throws MissingBackpressureException;
    }

    static {
        c cVar = c.f71665a;
        f71661a = cVar;
        f71662b = cVar;
        b bVar = b.f71664a;
        C1966a c1966a = C1966a.f71663a;
    }
}
