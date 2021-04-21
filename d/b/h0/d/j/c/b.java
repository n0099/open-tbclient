package d.b.h0.d.j.c;

import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.facade.init.SwanAppInitHelper;
@Autowired
/* loaded from: classes3.dex */
public final class b {

    /* loaded from: classes3.dex */
    public static class a implements d.b.h0.a.e0.u.c {
        @Override // d.b.h0.a.e0.u.c
        public void onFail() {
        }

        @Override // d.b.h0.a.e0.u.c
        public void onSuccess() {
        }
    }

    /* renamed from: d.b.h0.d.j.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0957b {
        d.b.h0.l.o.b a();

        void b(boolean z, d.b.h0.a.e0.u.c cVar);

        boolean c();
    }

    public static void a() {
        if (ProcessUtils.isMainProcess() && !d.b.h0.a.w0.a.b0().b()) {
            synchronized (SwanAppInitHelper.class) {
                if (SwanAppInitHelper.isDelayInit()) {
                    SwanAppInitHelper.initModules(AppRuntime.getApplication(), false);
                }
            }
            d.b.h0.a.w0.a.b0().d(true, new a());
        }
    }

    @Inject(force = false)
    public static InterfaceC0957b b() {
        return d.b.j0.s.b.o.b.a();
    }
}
