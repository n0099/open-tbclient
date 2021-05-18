package d.a.i0.h.m;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.i0.a.k;
import d.a.i0.a.p0.a;
import d.a.i0.a.p0.d.b;
/* loaded from: classes3.dex */
public class a extends b<d.a.i0.h.m.d.a, d.a.i0.h.m.e.a> {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47274d = k.f43025a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f47275e;

    /* renamed from: d.a.i0.h.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1019a extends a.C0780a {
        @Override // d.a.i0.a.p0.a.C0780a
        public int c() {
            return 1;
        }
    }

    public a() {
        super(new d.a.i0.h.m.d.a(), new d.a.i0.h.m.e.a());
    }

    public static a i() {
        if (f47275e == null) {
            synchronized (a.class) {
                if (f47275e == null) {
                    f47275e = new a();
                }
            }
        }
        return f47275e;
    }

    @Override // d.a.i0.a.p0.d.b
    public String b(int i2) {
        if (i2 == 1) {
            return d.a.i0.h.m.b.b.b().getPath();
        }
        return null;
    }

    @Override // d.a.i0.a.p0.d.b
    @Nullable
    public ExtensionCore c() {
        if (ProcessUtils.isMainProcess()) {
            return d();
        }
        Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C1019a.class, null).mResult;
        bundle.setClassLoader(ExtensionCore.class.getClassLoader());
        ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
        if (f47274d) {
            Log.d("ExtCore-GamesManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            return extensionCore;
        }
        return extensionCore;
    }
}
