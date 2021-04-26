package d.a.j0.s.b.e;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import d.a.h0.a.k;
import d.a.h0.a.p.c.c0;
import d.a.h0.a.r1.e;
import d.a.i0.k0.d;
import java.util.ArrayList;
import java.util.List;
@Singleton
@Service
/* loaded from: classes4.dex */
public class a implements c0 {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f59943b = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public long f59944a;

    @Override // d.a.h0.a.p.c.c0
    public void a() {
        if (f59943b) {
            Log.e("DefaultSwanAppLifecycle", "onAppForeground" + e.h().f43823f);
        }
        this.f59944a = System.currentTimeMillis();
    }

    @Override // d.a.h0.a.p.c.c0
    public void b() {
        if (f59943b) {
            Log.e("DefaultSwanAppLifecycle", "onAppBackground");
        }
        long l = d.a.i0.r.d0.b.j().l("smart_app_tid", 0L);
        String p = d.a.i0.r.d0.b.j().p("smart_app_id", "");
        String p2 = d.a.i0.r.d0.b.j().p("smart_app_name", "");
        if (this.f59944a == 0 || l == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f59944a;
        d dVar = new d();
        dVar.v(currentTimeMillis);
        dVar.p(e());
        dVar.y(l);
        dVar.f48572i = p;
        dVar.j = p2;
        dVar.u(f());
        d.a.i0.k0.e.b().h(true);
        d.a.i0.k0.e.b().i(TbadkApplication.getInst().getApplicationContext(), dVar, g());
        d.a.i0.r.d0.b.j().w("smart_app_tid", 0L);
    }

    @Override // d.a.h0.a.p.c.c0
    public void c() {
    }

    @Override // d.a.h0.a.p.c.c0
    public void d(@NonNull SwanAppActivity swanAppActivity, int i2, @Nullable d.a.h0.a.y0.e.b bVar) {
        if (f59943b) {
            Log.e("DefaultSwanAppLifecycle", "onAppExit");
        }
        if (d.a.i0.r.d0.b.j().g("key_ai_app_guide_display", true)) {
            d.a.i0.r.d0.b.j().t("key_ai_app_guide_display", false);
            Intent intent = new Intent(swanAppActivity, DealIntentService.class);
            intent.putExtra(DealIntentService.KEY_CLASS, 38);
            swanAppActivity.startService(intent);
        }
    }

    public String e() {
        return "a061";
    }

    public List<String> f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("a001");
        return arrayList;
    }

    public d.a.i0.k0.b g() {
        return null;
    }
}
