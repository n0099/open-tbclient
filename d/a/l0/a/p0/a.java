package d.a.l0.a.p0;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import d.a.l0.a.p0.f.c;
import d.a.l0.a.v1.b.f;
import d.a.l0.a.v2.h;
/* loaded from: classes3.dex */
public class a extends d.a.l0.a.p0.d.b<d.a.l0.a.p0.h.c.a, d.a.l0.a.p0.i.b.a> {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f47681d = k.f46875a;

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f47682e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f47683f;

    /* renamed from: d.a.l0.a.p0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0847a extends ProviderDelegation {
        public final ExtensionCore a() {
            if (b() == null) {
                return null;
            }
            ExtensionCore d2 = b().d();
            if (d2.a()) {
                return d2;
            }
            b().h();
            return b().d();
        }

        public final d.a.l0.a.p0.d.b b() {
            return d.a.l0.a.p0.b.f(c());
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

    /* loaded from: classes3.dex */
    public static class b extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("swan_preset_extension", a.f47683f);
            d.h("ExtCore-AppsManager", "is extension file exists : " + a.n());
            return bundle2;
        }
    }

    static {
        d.a.l0.a.c1.a.Z().getSwitch("swan_preset_extension", true);
        f47683f = true;
    }

    public a() {
        super(m(), new d.a.l0.a.p0.i.b.a());
    }

    public static boolean k() {
        if (ProcessUtils.isMainProcess()) {
            d.h("ExtCore-AppsManager", "MainProcess mPresetExtension: " + f47683f);
            return f47683f;
        }
        f b2 = d.a.l0.a.v1.b.d.b(b.class, null);
        boolean z = true;
        if (b2.a() && !b2.f48971a.getBoolean("swan_preset_extension", true)) {
            z = false;
        }
        d.h("ExtCore-AppsManager", "swanProcess mPresetExtension: " + z);
        return z;
    }

    public static a l() {
        if (f47682e == null) {
            synchronized (a.class) {
                if (f47682e == null) {
                    f47682e = new a();
                }
            }
        }
        return f47682e;
    }

    public static d.a.l0.a.p0.h.c.a m() {
        return k() ? new d.a.l0.a.p0.h.c.a() : new d.a.l0.a.p0.h.c.b();
    }

    public static boolean n() {
        d.a.l0.a.p0.g.b.a aVar = new d.a.l0.a.p0.g.b.a();
        boolean z = h.a(AppRuntime.getAppContext(), aVar.d()) && h.a(AppRuntime.getAppContext(), aVar.a());
        d.h("ExtCore-AppsManager", "preset extension isFileExists : " + z);
        return z;
    }

    @Override // d.a.l0.a.p0.d.b
    public String b(int i2) {
        if (i2 != 1) {
            return c.b().getPath();
        }
        return null;
    }

    @Override // d.a.l0.a.p0.d.b
    @Nullable
    public ExtensionCore c() {
        ExtensionCore extensionCore;
        if (ProcessUtils.isMainProcess()) {
            extensionCore = d();
        } else {
            Bundle bundle = d.a.l0.a.v1.b.d.b(C0847a.class, null).f48971a;
            bundle.setClassLoader(ExtensionCore.class.getClassLoader());
            extensionCore = (ExtensionCore) bundle.getParcelable("aiapps_extension_core");
            if (f47681d) {
                Log.d("ExtCore-AppsManager", "getExtensionCore:" + ProcessUtils.getCurProcessName() + " extension core: " + extensionCore);
            }
        }
        return (extensionCore == null || !d.a.l0.a.u1.a.a.W() || extensionCore.extensionCoreVersionCode >= 4294967297L) ? extensionCore : d.a.l0.a.u1.a.a.a(extensionCore);
    }
}
