package d.a.h0.d.g.b;

import com.baidu.pyramid.annotation.Service;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import d.a.h0.a.p.c.b0;
@Service
/* loaded from: classes3.dex */
public class a implements b0 {
    @Override // d.a.h0.a.p.c.b0
    public void a() {
        d();
    }

    @Override // d.a.h0.a.p.c.b0
    public void b() {
        d();
    }

    @Override // d.a.h0.a.p.c.b0
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
