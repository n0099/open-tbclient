package d.a.m0.e.k.d;

import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import d.a.m0.a.p.d.j0;
@Service
/* loaded from: classes3.dex */
public class a implements j0 {
    @Override // d.a.m0.a.p.d.j0
    public void a() {
        d();
    }

    @Override // d.a.m0.a.p.d.j0
    public void b() {
        d();
    }

    @Override // d.a.m0.a.p.d.j0
    public void c() {
        d();
    }

    public final void d() {
        synchronized (SwanAppInitHelper.class) {
            if (SwanAppInitHelper.isDelayInit()) {
                SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
            }
        }
    }
}
