package h;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d f67655a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f67656b;

    /* renamed from: h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1862a implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final C1862a f67657a = new C1862a();

        @Override // h.a.d
        public boolean a() {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f67658a = new b();

        @Override // h.a.d
        public boolean a() {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f67659a = new c();

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
        c cVar = c.f67659a;
        f67655a = cVar;
        f67656b = cVar;
        b bVar = b.f67658a;
        C1862a c1862a = C1862a.f67657a;
    }
}
