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
    public static final boolean f60062b = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public long f60063a;

    @Override // d.b.g0.a.p.c.c0
    public void a() {
        if (f60062b) {
            Log.e("DefaultSwanAppLifecycle", "onAppForeground" + e.y().f45739f);
        }
        this.f60063a = System.currentTimeMillis();
    }

    @Override // d.b.g0.a.p.c.c0
    public void b() {
        if (f60062b) {
            Log.e("DefaultSwanAppLifecycle", "onAppBackground");
        }
        long k = d.b.h0.r.d0.b.i().k("smart_app_tid", 0L);
        String o = d.b.h0.r.d0.b.i().o("smart_app_id", "");
        String o2 = d.b.h0.r.d0.b.i().o("smart_app_name", "");
        if (this.f60063a == 0 || k == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f60063a;
        d dVar = new d();
        dVar.v(currentTimeMillis);
        dVar.p(e());
        dVar.y(k);
        dVar.i = o;
        dVar.j = o2;
        dVar.u(f());
        d.b.h0.k0.e.b().h(true);
        d.b.h0.k0.e.b().i(TbadkApplication.getInst().getApplicationContext(), dVar, g());
        d.b.h0.r.d0.b.i().v("smart_app_tid", 0L);
    }

    @Override // d.b.g0.a.p.c.c0
    public void c(@NonNull SwanAppActivity swanAppActivity, int i, @Nullable d.b.g0.a.y0.e.b bVar) {
        if (f60062b) {
            Log.e("DefaultSwanAppLifecycle", "onAppExit");
        }
        if (d.b.h0.r.d0.b.i().g("key_ai_app_guide_display", true)) {
            d.b.h0.r.d0.b.i().s("key_ai_app_guide_display", false);
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
