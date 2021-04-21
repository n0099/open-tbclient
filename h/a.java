package h;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d f68813a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f68814b;

    /* renamed from: h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1902a implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final C1902a f68815a = new C1902a();

        @Override // h.a.d
        public boolean a() {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f68816a = new b();

        @Override // h.a.d
        public boolean a() {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f68817a = new c();

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
        c cVar = c.f68817a;
        f68813a = cVar;
        f68814b = cVar;
        b bVar = b.f68816a;
        C1902a c1902a = C1902a.f68815a;
    }
}
