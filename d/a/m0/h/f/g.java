package d.a.m0.h.f;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import d.a.m0.a.k;
import java.io.File;
import org.json.JSONObject;
@Service
/* loaded from: classes3.dex */
public class g implements d.a.m0.a.p.b.a.f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51139a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f51140b = g.class.getSimpleName();

    /* loaded from: classes3.dex */
    public class a extends d.a.m0.h.f.k.a {
        public a(g gVar) {
        }

        @Override // d.a.m0.h.f.k.a
        @NonNull
        public File a() {
            return d.a.m0.a.e0.e.a();
        }

        @Override // d.a.m0.h.f.k.a
        public void b(@NonNull String str, long j) {
            d.a.m0.a.e0.e.e(str, j);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.h.f.b {
        public b(g gVar) {
        }

        @Override // d.a.m0.h.f.b
        public void a(boolean z) {
            if (g.f51139a) {
                String str = g.f51140b;
                Log.d(str, "download sConsole result: " + z);
            }
        }
    }

    @Override // d.a.m0.a.p.b.a.f
    public void a(@NonNull Activity activity, @Nullable DialogInterface.OnClickListener onClickListener) {
        d.m().p(activity, onClickListener);
    }

    @Override // d.a.m0.a.p.b.a.f
    public String b() {
        return d.m().e();
    }

    @Override // d.a.m0.a.p.b.a.f
    public void c(JSONObject jSONObject) {
        f.h(jSONObject);
    }

    @Override // d.a.m0.a.p.b.a.f
    public d.a.m0.n.f.g d() {
        return new d.a.m0.h.f.j.a(new a(this), new b(this));
    }

    @Override // d.a.m0.a.p.b.a.f
    public void e(int i2, String str) {
        i.d(i2, str);
    }

    @Override // d.a.m0.a.p.b.a.f
    public void f(d.a.m0.a.v2.e1.b<Boolean> bVar) {
        d.m().o(bVar);
    }
}
