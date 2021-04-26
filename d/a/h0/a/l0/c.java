package d.a.h0.a.l0;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.h0.a.k;
import d.a.h0.a.l0.a;
/* loaded from: classes2.dex */
public class c extends d.a.h0.a.l0.e.b<d.a.h0.g.k.c.a, d.a.h0.g.k.d.a> {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f43131d = k.f43101a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile c f43132e;

    /* loaded from: classes2.dex */
    public static class a extends a.C0690a {
        @Override // d.a.h0.a.l0.a.C0690a
        public int c() {
            return 1;
        }
    }

    public c() {
        super(new d.a.h0.g.k.c.a(), new d.a.h0.g.k.d.a());
    }

    public static c h() {
        if (f43132e == null) {
            synchronized (c.class) {
                if (f43132e == null) {
                    f43132e = new c();
                }
            }
        }
        return f43132e;
    }

    @Override // d.a.h0.a.l0.e.b
    @Nullable
    public ExtensionCore b() {
        if (ProcessUtils.isMainProcess()) {
            return c();
        }
        Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null).mResult;
        bundle.setClassLoader(ExtensionCore.class.getClassLoader());
        ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
        if (f43131d) {
            Log.d("ExtCore-GamesManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            return extensionCore;
        }
        return extensionCore;
    }
}
