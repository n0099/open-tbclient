package d.b.g0.a.l0;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.g0.a.k;
/* loaded from: classes2.dex */
public class a extends d.b.g0.a.l0.e.b<d.b.g0.a.l0.i.c.a, d.b.g0.a.l0.j.b.a> {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f45470d = k.f45443a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f45471e;

    /* renamed from: d.b.g0.a.l0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0731a extends ProviderDelegation {
        public final ExtensionCore a() {
            ExtensionCore c2 = b().c();
            if (c2.a()) {
                return c2;
            }
            b().g();
            return b().c();
        }

        public final d.b.g0.a.l0.e.b b() {
            return b.d(c());
        }

        public int c() {
            return 0;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("aiapps_extension_core", a());
            return bundle2;
        }
    }

    public a() {
        super(new d.b.g0.a.l0.i.c.a(), new d.b.g0.a.l0.j.b.a());
    }

    public static a h() {
        if (f45471e == null) {
            synchronized (a.class) {
                if (f45471e == null) {
                    f45471e = new a();
                }
            }
        }
        return f45471e;
    }

    @Override // d.b.g0.a.l0.e.b
    @Nullable
    public ExtensionCore b() {
        ExtensionCore extensionCore;
        if (ProcessUtils.isMainProcess()) {
            extensionCore = c();
        } else {
            Bundle bundle = DelegateUtils.callOnMainWithContentProvider(AppRuntime.getAppContext(), C0731a.class, null).mResult;
            bundle.setClassLoader(ExtensionCore.class.getClassLoader());
            extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
            if (f45470d) {
                Log.d("ExtCore-AppsManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            }
        }
        return (extensionCore == null || !d.b.g0.a.m1.a.a.S() || extensionCore.extensionCoreVersionCode >= 4294967297L) ? extensionCore : d.b.g0.a.m1.a.a.a(extensionCore);
    }
}
