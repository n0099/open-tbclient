package d.b.g0.a.l0;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.g0.a.k;
import d.b.g0.a.l0.a;
/* loaded from: classes2.dex */
public class c extends d.b.g0.a.l0.e.b<d.b.g0.g.k.c.a, d.b.g0.g.k.d.a> {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45081d = k.f45051a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile c f45082e;

    /* loaded from: classes2.dex */
    public static class a extends a.C0719a {
        @Override // d.b.g0.a.l0.a.C0719a
        public int c() {
            return 1;
        }
    }

    public c() {
        super(new d.b.g0.g.k.c.a(), new d.b.g0.g.k.d.a());
    }

    public static c h() {
        if (f45082e == null) {
            synchronized (c.class) {
                if (f45082e == null) {
                    f45082e = new c();
                }
            }
        }
        return f45082e;
    }

    @Override // d.b.g0.a.l0.e.b
    @Nullable
    public ExtensionCore b() {
        if (ProcessUtils.isMainProcess()) {
            return c();
        }
        Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null).mResult;
        bundle.setClassLoader(ExtensionCore.class.getClassLoader());
        ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
        if (f45081d) {
            Log.d("ExtCore-GamesManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            return extensionCore;
        }
        return extensionCore;
    }
}
