package d.a.h0.d.j.c;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.facade.init.SwanAppInitHelper;
@Autowired
/* loaded from: classes3.dex */
public final class b {

    /* loaded from: classes3.dex */
    public static class a implements d.a.h0.a.e0.u.c {
        @Override // d.a.h0.a.e0.u.c
        public void onFail() {
        }

        @Override // d.a.h0.a.e0.u.c
        public void onSuccess() {
        }
    }

    /* renamed from: d.a.h0.d.j.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0896b {
        d.a.h0.l.o.b a();

        void b(boolean z, d.a.h0.a.e0.u.c cVar);

        boolean c();
    }

    public static void a() {
        if (ProcessUtils.isMainProcess() && !d.a.h0.a.w0.a.b0().c()) {
            synchronized (SwanAppInitHelper.class) {
                if (SwanAppInitHelper.isDelayInit()) {
                    SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
                }
            }
            d.a.h0.a.w0.a.b0().d(true, new a());
        }
    }

    @Inject(force = false)
    public static InterfaceC0896b b() {
        return d.a.j0.s.b.o.b.a();
    }
}
