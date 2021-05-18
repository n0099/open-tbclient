package d.a.i0.a.u.e.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import d.a.i0.a.c1.d.d;
import d.a.i0.a.e0.d;
import d.a.i0.a.k;
import d.a.i0.a.s1.e;
import d.a.i0.a.s1.f;
import d.a.i0.a.u.e.i.a;
import d.a.i0.a.v2.q0;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f44849b;

    /* renamed from: a  reason: collision with root package name */
    public c f44850a;

    /* loaded from: classes2.dex */
    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f44851a;

        public a(a.c cVar) {
            this.f44851a = cVar;
        }

        @Override // d.a.i0.a.s1.f
        public void a(String str) {
            b.this.c(this.f44851a);
        }

        @Override // d.a.i0.a.s1.f
        public void b(int i2, String str) {
            d.b("GetLocationHelper", str);
            b.this.f44850a.f(this.f44851a, str);
        }
    }

    /* renamed from: d.a.i0.a.u.e.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0842b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f44853a;

        public C0842b(a.c cVar) {
            this.f44853a = cVar;
        }

        @Override // d.a.i0.a.c1.d.d.a
        public void a(d.a.i0.a.c2.f.k0.b bVar) {
            b.this.f44850a.g(this.f44853a, bVar);
        }

        @Override // d.a.i0.a.c1.d.d.a
        public void onFailed(int i2) {
            b.this.f44850a.b(this.f44853a, i2);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void b(a.c cVar, int i2);

        void f(a.c cVar, String str);

        void g(a.c cVar, d.a.i0.a.c2.f.k0.b bVar);
    }

    static {
        boolean z = k.f43025a;
    }

    public static b d() {
        if (f44849b == null) {
            synchronized (b.class) {
                if (f44849b == null) {
                    f44849b = new b();
                }
            }
        }
        return f44849b;
    }

    public final void c(a.c cVar) {
        String str = "gcj02";
        if (!TextUtils.equals(cVar.f44846a, "gcj02")) {
            str = TextUtils.equals(cVar.f44846a, "bd09ll") ? "bd09ll" : CoordinateType.WGS84;
        }
        d.a.i0.a.c1.a.E().b(str, false, cVar.f44847b, new C0842b(cVar));
    }

    public void e(@NonNull a.c cVar, @NonNull c cVar2, boolean z) {
        this.f44850a = cVar2;
        if (q0.L()) {
            c(cVar);
        } else if (z) {
            this.f44850a.f(cVar, "GetLocation does not supported when app is invisible");
        } else {
            a aVar = new a(cVar);
            e.f(d.a.i0.a.a2.d.g().x(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, aVar);
        }
    }
}
