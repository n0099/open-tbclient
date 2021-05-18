package h;

import rx.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d f68362a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f68363b;

    /* renamed from: h.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1913a implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final C1913a f68364a = new C1913a();

        @Override // h.a.d
        public boolean a() {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final b f68365a = new b();

        @Override // h.a.d
        public boolean a() {
            return true;
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements d {

        /* renamed from: a  reason: collision with root package name */
        public static final c f68366a = new c();

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
        c cVar = c.f68366a;
        f68362a = cVar;
        f68363b = cVar;
        b bVar = b.f68365a;
        C1913a c1913a = C1913a.f68364a;
    }
}
