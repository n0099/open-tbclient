package h;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d f71765a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f71766b;

    /* renamed from: h.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C1969a implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final C1969a f71767a = new C1969a();

        @Override // h.a.d
        public boolean a() {
            return false;
        }
    }

    /* loaded from: classes8.dex */
    public static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f71768a = new b();

        @Override // h.a.d
        public boolean a() {
            return true;
        }
    }

    /* loaded from: classes8.dex */
    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f71769a = new c();

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
        c cVar = c.f71769a;
        f71765a = cVar;
        f71766b = cVar;
        b bVar = b.f71768a;
        C1969a c1969a = C1969a.f71767a;
    }
}
