package d.a.h0.a.t.c.g;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import d.a.h0.a.i2.k0;
import d.a.h0.a.t.c.g.a;
import d.a.h0.a.w0.c.d;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f44179b;

    /* renamed from: a  reason: collision with root package name */
    public c f44180a;

    /* loaded from: classes2.dex */
    public class a implements d.a.h0.a.k1.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f44181a;

        public a(a.c cVar) {
            this.f44181a = cVar;
        }

        @Override // d.a.h0.a.k1.b
        public void a(String str) {
            b.this.c(this.f44181a);
        }

        @Override // d.a.h0.a.k1.b
        public void b(int i2, String str) {
            d.a.h0.a.c0.c.b("GetLocationHelper", str);
            b.this.f44180a.e(this.f44181a, str);
        }
    }

    /* renamed from: d.a.h0.a.t.c.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0786b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f44183a;

        public C0786b(a.c cVar) {
            this.f44183a = cVar;
        }

        @Override // d.a.h0.a.w0.c.d.a
        public void a(d.a.h0.a.t1.k.k0.b bVar) {
            b.this.f44180a.f(this.f44183a, bVar);
        }

        @Override // d.a.h0.a.w0.c.d.a
        public void onFailed(int i2) {
            b.this.f44180a.b(this.f44183a, i2);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void b(a.c cVar, int i2);

        void e(a.c cVar, String str);

        void f(a.c cVar, d.a.h0.a.t1.k.k0.b bVar);
    }

    public static b d() {
        if (f44179b == null) {
            synchronized (b.class) {
                if (f44179b == null) {
                    f44179b = new b();
                }
            }
        }
        return f44179b;
    }

    public final void c(a.c cVar) {
        String str = "gcj02";
        if (!TextUtils.equals(cVar.f44176a, "gcj02")) {
            str = TextUtils.equals(cVar.f44176a, "bd09ll") ? "bd09ll" : CoordinateType.WGS84;
        }
        d.a.h0.a.w0.a.w().b(str, false, cVar.f44177b, new C0786b(cVar));
    }

    public void e(@NonNull a.c cVar, @NonNull c cVar2, boolean z) {
        this.f44180a = cVar2;
        if (k0.I()) {
            c(cVar);
        } else if (z) {
            this.f44180a.e(cVar, "GetLocation does not supported when app is invisible");
        } else {
            a aVar = new a(cVar);
            d.a.h0.a.k1.a.b(d.a.h0.a.r1.d.e().v(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, aVar);
        }
    }
}
