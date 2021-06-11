package d.a.n0.u.b.e;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import d.a.l0.a.k;
import d.a.l0.a.p.d.k0;
import d.a.m0.k0.d;
import d.a.m0.k0.e;
import java.util.ArrayList;
import java.util.List;
@Singleton
@Service
/* loaded from: classes4.dex */
public class a implements k0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f64970b = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public long f64971a;

    @Override // d.a.l0.a.p.d.k0
    public void a(String str) {
        if (f64970b) {
            Log.e("DefaultSwanAppLifecycle", "onAppBackground");
        }
        long l = d.a.m0.r.d0.b.j().l("smart_app_tid", 0L);
        String p = d.a.m0.r.d0.b.j().p("smart_app_id", "");
        String p2 = d.a.m0.r.d0.b.j().p("smart_app_name", "");
        if (this.f64971a == 0 || l == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f64971a;
        d dVar = new d();
        dVar.v(currentTimeMillis);
        dVar.p(g());
        dVar.y(l);
        dVar.f53118i = p;
        dVar.j = p2;
        dVar.u(h());
        e.b().h(true);
        e.b().i(TbadkApplication.getInst().getApplicationContext(), dVar, i());
        d.a.m0.r.d0.b.j().w("smart_app_tid", 0L);
    }

    @Override // d.a.l0.a.p.d.k0
    public void b() {
    }

    @Override // d.a.l0.a.p.d.k0
    public void c(String str) {
        if (f64970b) {
            Log.e("DefaultSwanAppLifecycle", "onAppForeground" + d.a.l0.a.a2.e.i().f44425f);
        }
        this.f64971a = System.currentTimeMillis();
    }

    @Override // d.a.l0.a.p.d.k0
    public void d(@NonNull SwanAppActivity swanAppActivity, int i2, @Nullable d.a.l0.a.f1.e.b bVar) {
        if (f64970b) {
            Log.e("DefaultSwanAppLifecycle", "onAppExit");
        }
        if (d.a.m0.r.d0.b.j().g("key_ai_app_guide_display", true)) {
            d.a.m0.r.d0.b.j().t("key_ai_app_guide_display", false);
            Intent intent = new Intent(swanAppActivity, DealIntentService.class);
            intent.putExtra(DealIntentService.KEY_CLASS, 38);
            swanAppActivity.startService(intent);
        }
    }

    @Override // d.a.l0.a.p.d.k0
    public void e(String str) {
    }

    @Override // d.a.l0.a.p.d.k0
    public void f(String str) {
    }

    public String g() {
        return "a061";
    }

    public List<String> h() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a001");
        return arrayList;
    }

    public d.a.m0.k0.b i() {
        return null;
    }
}
