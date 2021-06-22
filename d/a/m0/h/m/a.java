package d.a.m0.h.m;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.m0.a.k;
import d.a.m0.a.p0.a;
import d.a.m0.a.p0.d.b;
/* loaded from: classes3.dex */
public class a extends b<d.a.m0.h.m.d.a, d.a.m0.h.m.e.a> {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f51232d = k.f46983a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f51233e;

    /* renamed from: d.a.m0.h.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1089a extends a.C0850a {
        @Override // d.a.m0.a.p0.a.C0850a
        public int c() {
            return 1;
        }
    }

    public a() {
        super(new d.a.m0.h.m.d.a(), new d.a.m0.h.m.e.a());
    }

    public static a i() {
        if (f51233e == null) {
            synchronized (a.class) {
                if (f51233e == null) {
                    f51233e = new a();
                }
            }
        }
        return f51233e;
    }

    @Override // d.a.m0.a.p0.d.b
    public String b(int i2) {
        if (i2 == 1) {
            return d.a.m0.h.m.b.b.b().getPath();
        }
        return null;
    }

    @Override // d.a.m0.a.p0.d.b
    @Nullable
    public ExtensionCore c() {
        if (ProcessUtils.isMainProcess()) {
            return d();
        }
        Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C1089a.class, null).mResult;
        bundle.setClassLoader(ExtensionCore.class.getClassLoader());
        ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
        if (f51232d) {
            Log.d("ExtCore-GamesManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            return extensionCore;
        }
        return extensionCore;
    }
}
