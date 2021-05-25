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
    public static final boolean f47450d = k.f43199a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f47451e;

    /* renamed from: d.a.l0.h.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1030a extends a.C0791a {
        @Override // d.a.l0.a.p0.a.C0791a
        public int c() {
            return 1;
        }
    }

    public a() {
        super(new d.a.l0.h.m.d.a(), new d.a.l0.h.m.e.a());
    }

    public static a i() {
        if (f47451e == null) {
            synchronized (a.class) {
                if (f47451e == null) {
                    f47451e = new a();
                }
            }
        }
        return f47451e;
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
        Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C1030a.class, null).mResult;
        bundle.setClassLoader(ExtensionCore.class.getClassLoader());
        ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
        if (f47450d) {
            Log.d("ExtCore-GamesManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            return extensionCore;
        }
        return extensionCore;
    }
}
