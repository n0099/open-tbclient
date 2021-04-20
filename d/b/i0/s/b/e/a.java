package d.b.i0.s.b.e;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import d.b.g0.a.k;
import d.b.g0.a.p.c.c0;
import d.b.g0.a.r1.e;
import d.b.h0.k0.d;
import java.util.ArrayList;
import java.util.List;
@Singleton
@Service
/* loaded from: classes4.dex */
public class a implements c0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f61364b = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public long f61365a;

    @Override // d.b.g0.a.p.c.c0
    public void a() {
        if (f61364b) {
            Log.e("DefaultSwanAppLifecycle", "onAppForeground" + e.y().f46132f);
        }
        this.f61365a = System.currentTimeMillis();
    }

    @Override // d.b.g0.a.p.c.c0
    public void b() {
        if (f61364b) {
            Log.e("DefaultSwanAppLifecycle", "onAppBackground");
        }
        long l = d.b.h0.r.d0.b.j().l("smart_app_tid", 0L);
        String p = d.b.h0.r.d0.b.j().p("smart_app_id", "");
        String p2 = d.b.h0.r.d0.b.j().p("smart_app_name", "");
        if (this.f61365a == 0 || l == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f61365a;
        d dVar = new d();
        dVar.v(currentTimeMillis);
        dVar.p(e());
        dVar.y(l);
        dVar.i = p;
        dVar.j = p2;
        dVar.u(f());
        d.b.h0.k0.e.b().h(true);
        d.b.h0.k0.e.b().i(TbadkApplication.getInst().getApplicationContext(), dVar, g());
        d.b.h0.r.d0.b.j().w("smart_app_tid", 0L);
    }

    @Override // d.b.g0.a.p.c.c0
    public void c(@NonNull SwanAppActivity swanAppActivity, int i, @Nullable d.b.g0.a.y0.e.b bVar) {
        if (f61364b) {
            Log.e("DefaultSwanAppLifecycle", "onAppExit");
        }
        if (d.b.h0.r.d0.b.j().g("key_ai_app_guide_display", true)) {
            d.b.h0.r.d0.b.j().t("key_ai_app_guide_display", false);
            Intent intent = new Intent(swanAppActivity, DealIntentService.class);
            intent.putExtra(DealIntentService.KEY_CLASS, 38);
            swanAppActivity.startService(intent);
        }
    }

    @Override // d.b.g0.a.p.c.c0
    public void d() {
    }

    public String e() {
        return "a061";
    }

    public List<String> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a001");
        return arrayList;
    }

    public d.b.h0.k0.b g() {
        return null;
    }
}
