package d.a.m0.a.u.e.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import d.a.m0.a.c1.d.d;
import d.a.m0.a.e0.d;
import d.a.m0.a.k;
import d.a.m0.a.s1.e;
import d.a.m0.a.s1.f;
import d.a.m0.a.u.e.i.a;
import d.a.m0.a.v2.q0;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f48807b;

    /* renamed from: a  reason: collision with root package name */
    public c f48808a;

    /* loaded from: classes2.dex */
    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f48809a;

        public a(a.c cVar) {
            this.f48809a = cVar;
        }

        @Override // d.a.m0.a.s1.f
        public void a(String str) {
            b.this.c(this.f48809a);
        }

        @Override // d.a.m0.a.s1.f
        public void b(int i2, String str) {
            d.b("GetLocationHelper", str);
            b.this.f48808a.f(this.f48809a, str);
        }
    }

    /* renamed from: d.a.m0.a.u.e.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0912b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f48811a;

        public C0912b(a.c cVar) {
            this.f48811a = cVar;
        }

        @Override // d.a.m0.a.c1.d.d.a
        public void a(d.a.m0.a.c2.f.k0.b bVar) {
            b.this.f48808a.g(this.f48811a, bVar);
        }

        @Override // d.a.m0.a.c1.d.d.a
        public void onFailed(int i2) {
            b.this.f48808a.b(this.f48811a, i2);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void b(a.c cVar, int i2);

        void f(a.c cVar, String str);

        void g(a.c cVar, d.a.m0.a.c2.f.k0.b bVar);
    }

    static {
        boolean z = k.f46983a;
    }

    public static b d() {
        if (f48807b == null) {
            synchronized (b.class) {
                if (f48807b == null) {
                    f48807b = new b();
                }
            }
        }
        return f48807b;
    }

    public final void c(a.c cVar) {
        String str = "gcj02";
        if (!TextUtils.equals(cVar.f48804a, "gcj02")) {
            str = TextUtils.equals(cVar.f48804a, "bd09ll") ? "bd09ll" : CoordinateType.WGS84;
        }
        d.a.m0.a.c1.a.E().b(str, false, cVar.f48805b, new C0912b(cVar));
    }

    public void e(@NonNull a.c cVar, @NonNull c cVar2, boolean z) {
        this.f48808a = cVar2;
        if (q0.L()) {
            c(cVar);
        } else if (z) {
            this.f48808a.f(cVar, "GetLocation does not supported when app is invisible");
        } else {
            a aVar = new a(cVar);
            e.f(d.a.m0.a.a2.d.g().x(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, aVar);
        }
    }
}
