package d.b.h0.a.t.c.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import d.b.h0.a.i2.k0;
import d.b.h0.a.t.c.g.a;
import d.b.h0.a.w0.c.d;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f46797b;

    /* renamed from: a  reason: collision with root package name */
    public c f46798a;

    /* loaded from: classes2.dex */
    public class a implements d.b.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f46799a;

        public a(a.c cVar) {
            this.f46799a = cVar;
        }

        @Override // d.b.h0.a.k1.b
        public void a(String str) {
            b.this.c(this.f46799a);
        }

        @Override // d.b.h0.a.k1.b
        public void b(int i, String str) {
            d.b.h0.a.c0.c.b("GetLocationHelper", str);
            b.this.f46798a.d(this.f46799a, str);
        }
    }

    /* renamed from: d.b.h0.a.t.c.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0847b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f46801a;

        public C0847b(a.c cVar) {
            this.f46801a = cVar;
        }

        @Override // d.b.h0.a.w0.c.d.a
        public void a(d.b.h0.a.t1.k.k0.b bVar) {
            b.this.f46798a.f(this.f46801a, bVar);
        }

        @Override // d.b.h0.a.w0.c.d.a
        public void onFailed(int i) {
            b.this.f46798a.b(this.f46801a, i);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void b(a.c cVar, int i);

        void d(a.c cVar, String str);

        void f(a.c cVar, d.b.h0.a.t1.k.k0.b bVar);
    }

    public static b d() {
        if (f46797b == null) {
            synchronized (b.class) {
                if (f46797b == null) {
                    f46797b = new b();
                }
            }
        }
        return f46797b;
    }

    public final void c(a.c cVar) {
        String str = "gcj02";
        if (!TextUtils.equals(cVar.f46794a, "gcj02")) {
            str = TextUtils.equals(cVar.f46794a, "bd09ll") ? "bd09ll" : CoordinateType.WGS84;
        }
        d.b.h0.a.w0.a.w().d(str, false, cVar.f46795b, new C0847b(cVar));
    }

    public void e(@NonNull a.c cVar, @NonNull c cVar2, boolean z) {
        this.f46798a = cVar2;
        if (k0.I()) {
            c(cVar);
        } else if (z) {
            this.f46798a.d(cVar, "GetLocation does not supported when app is invisible");
        } else {
            a aVar = new a(cVar);
            d.b.h0.a.k1.a.b(d.b.h0.a.r1.d.e().n(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, aVar);
        }
    }
}
