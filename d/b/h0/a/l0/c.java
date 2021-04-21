package d.b.h0.a.l0;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.h0.a.k;
import d.b.h0.a.l0.a;
/* loaded from: classes2.dex */
public class c extends d.b.h0.a.l0.e.b<d.b.h0.g.k.c.a, d.b.h0.g.k.d.a> {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45802d = k.f45772a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile c f45803e;

    /* loaded from: classes2.dex */
    public static class a extends a.C0751a {
        @Override // d.b.h0.a.l0.a.C0751a
        public int c() {
            return 1;
        }
    }

    public c() {
        super(new d.b.h0.g.k.c.a(), new d.b.h0.g.k.d.a());
    }

    public static c h() {
        if (f45803e == null) {
            synchronized (c.class) {
                if (f45803e == null) {
                    f45803e = new c();
                }
            }
        }
        return f45803e;
    }

    @Override // d.b.h0.a.l0.e.b
    @Nullable
    public ExtensionCore b() {
        if (ProcessUtils.isMainProcess()) {
            return c();
        }
        Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), a.class, null).mResult;
        bundle.setClassLoader(ExtensionCore.class.getClassLoader());
        ExtensionCore extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
        if (f45802d) {
            Log.d("ExtCore-GamesManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            return extensionCore;
        }
        return extensionCore;
    }
}
