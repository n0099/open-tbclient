package d.a.l0.h.m;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.l0.a.k;
import d.a.l0.a.p0.a;
import d.a.l0.a.p0.d.b;
/* loaded from: classes3.dex */
public class a extends b<d.a.l0.h.m.d.a, d.a.l0.h.m.e.a> {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f51124d = k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f51125e;

    /* renamed from: d.a.l0.h.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1086a extends a.C0847a {
        @Override // d.a.l0.a.p0.a.C0847a
        public int c() {
            return 1;
        }
    }

    public a() {
        super(new d.a.l0.h.m.d.a(), new d.a.l0.h.m.e.a());
    }

    public static a i() {
        if (f51125e == null) {
            synchronized (a.class) {
                if (f51125e == null) {
                    f51125e = new a();
                }
            }
        }
        return f51125e;
    }

    @Override // d.a.l0.a.p0.d.b
    public String b(int i2) {
        if (i2 == 1) {
            return d.a.l0.h.m.b.b.b().getPath();
        }
        return null;
    }

    @Override // d.a.l0.a.p0.d.b
    @Nullable
    public ExtensionCore c() {
        if (ProcessUtils.isMainProcess()) {
            return d();
        }
        Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C1086a.class, null).mResult;
        bundle.setClassLoader(ExtensionCore.class.getClassLoader());
        ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
        if (f51124d) {
            Log.d("ExtCore-GamesManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            return extensionCore;
        }
        return extensionCore;
    }
}
