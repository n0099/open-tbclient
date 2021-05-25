package d.a.l0.e.o.b;

import android.graphics.Bitmap;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.facade.init.SwanAppInitHelper;
import d.a.l0.a.h0.s.e;
@Autowired
/* loaded from: classes3.dex */
public final class b {

    /* loaded from: classes3.dex */
    public static class a implements d.a.l0.a.h0.s.c {
        @Override // d.a.l0.a.h0.s.c
        public void onFail() {
        }

        @Override // d.a.l0.a.h0.s.c
        public void onSuccess() {
        }
    }

    /* renamed from: d.a.l0.e.o.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0969b {
        d.a.l0.n.l.b a();

        void b(boolean z, d.a.l0.a.h0.s.c cVar);

        boolean c();

        Bitmap d();
    }

    public static void a() {
        if (ProcessUtils.isMainProcess() && !d.a.l0.a.c1.a.n0().d()) {
            synchronized (SwanAppInitHelper.class) {
                if (SwanAppInitHelper.isDelayInit()) {
                    SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
                }
            }
            e eVar = new e();
            eVar.f42571a = "by_silent";
            d.a.l0.a.c1.a.n0().b(eVar, new a());
        }
    }

    @Inject(force = false)
    public static InterfaceC0969b b() {
        return d.a.n0.u.b.l.b.a();
    }
}
