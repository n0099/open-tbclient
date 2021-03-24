package d.b.g0.a.t.c.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import d.b.g0.a.i2.k0;
import d.b.g0.a.t.c.g.a;
import d.b.g0.a.w0.c.d;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f46075b;

    /* renamed from: a  reason: collision with root package name */
    public c f46076a;

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f46077a;

        public a(a.c cVar) {
            this.f46077a = cVar;
        }

        @Override // d.b.g0.a.k1.b
        public void a(String str) {
            b.this.c(this.f46077a);
        }

        @Override // d.b.g0.a.k1.b
        public void b(int i, String str) {
            d.b.g0.a.c0.c.b("GetLocationHelper", str);
            b.this.f46076a.d(this.f46077a, str);
        }
    }

    /* renamed from: d.b.g0.a.t.c.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0814b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f46079a;

        public C0814b(a.c cVar) {
            this.f46079a = cVar;
        }

        @Override // d.b.g0.a.w0.c.d.a
        public void a(d.b.g0.a.t1.k.k0.b bVar) {
            b.this.f46076a.f(this.f46079a, bVar);
        }

        @Override // d.b.g0.a.w0.c.d.a
        public void onFailed(int i) {
            b.this.f46076a.b(this.f46079a, i);
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void b(a.c cVar, int i);

        void d(a.c cVar, String str);

        void f(a.c cVar, d.b.g0.a.t1.k.k0.b bVar);
    }

    public static b d() {
        if (f46075b == null) {
            synchronized (b.class) {
                if (f46075b == null) {
                    f46075b = new b();
                }
            }
        }
        return f46075b;
    }

    public final void c(a.c cVar) {
        String str = "gcj02";
        if (!TextUtils.equals(cVar.f46072a, "gcj02")) {
            str = TextUtils.equals(cVar.f46072a, "bd09ll") ? "bd09ll" : CoordinateType.WGS84;
        }
        d.b.g0.a.w0.a.w().d(str, false, cVar.f46073b, new C0814b(cVar));
    }

    public void e(@NonNull a.c cVar, @NonNull c cVar2, boolean z) {
        this.f46076a = cVar2;
        if (k0.I()) {
            c(cVar);
        } else if (z) {
            this.f46076a.d(cVar, "GetLocation does not supported when app is invisible");
        } else {
            a aVar = new a(cVar);
            d.b.g0.a.k1.a.b(d.b.g0.a.r1.d.e().n(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, aVar);
        }
    }
}
