package d.a.l0.a.u.e.i;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import d.a.l0.a.c1.d.d;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import d.a.l0.a.s1.e;
import d.a.l0.a.s1.f;
import d.a.l0.a.u.e.i.a;
import d.a.l0.a.v2.q0;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f45025b;

    /* renamed from: a  reason: collision with root package name */
    public c f45026a;

    /* loaded from: classes2.dex */
    public class a implements f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f45027a;

        public a(a.c cVar) {
            this.f45027a = cVar;
        }

        @Override // d.a.l0.a.s1.f
        public void a(String str) {
            b.this.c(this.f45027a);
        }

        @Override // d.a.l0.a.s1.f
        public void b(int i2, String str) {
            d.b("GetLocationHelper", str);
            b.this.f45026a.f(this.f45027a, str);
        }
    }

    /* renamed from: d.a.l0.a.u.e.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0853b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a.c f45029a;

        public C0853b(a.c cVar) {
            this.f45029a = cVar;
        }

        @Override // d.a.l0.a.c1.d.d.a
        public void a(d.a.l0.a.c2.f.k0.b bVar) {
            b.this.f45026a.g(this.f45029a, bVar);
        }

        @Override // d.a.l0.a.c1.d.d.a
        public void onFailed(int i2) {
            b.this.f45026a.b(this.f45029a, i2);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void b(a.c cVar, int i2);

        void f(a.c cVar, String str);

        void g(a.c cVar, d.a.l0.a.c2.f.k0.b bVar);
    }

    static {
        boolean z = k.f43199a;
    }

    public static b d() {
        if (f45025b == null) {
            synchronized (b.class) {
                if (f45025b == null) {
                    f45025b = new b();
                }
            }
        }
        return f45025b;
    }

    public final void c(a.c cVar) {
        String str = "gcj02";
        if (!TextUtils.equals(cVar.f45022a, "gcj02")) {
            str = TextUtils.equals(cVar.f45022a, "bd09ll") ? "bd09ll" : CoordinateType.WGS84;
        }
        d.a.l0.a.c1.a.E().b(str, false, cVar.f45023b, new C0853b(cVar));
    }

    public void e(@NonNull a.c cVar, @NonNull c cVar2, boolean z) {
        this.f45026a = cVar2;
        if (q0.L()) {
            c(cVar);
        } else if (z) {
            this.f45026a.f(cVar, "GetLocation does not supported when app is invisible");
        } else {
            a aVar = new a(cVar);
            e.f(d.a.l0.a.a2.d.g().x(), new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 0, aVar);
        }
    }
}
