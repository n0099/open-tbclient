package d.a.i0.a.p0.h.c;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.i0.a.k;
/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f43928e = k.f43025a;

    @Override // d.a.i0.a.p0.h.b
    public void f() {
    }

    @Override // d.a.i0.a.p0.h.b
    public <T extends d.a.i0.a.p0.g.a> Exception g(@NonNull T t) {
        if (f43928e) {
            Log.d("SwanNoPresetExtensionCoreControl", "doUpdate: preset");
            return null;
        }
        return null;
    }

    @Override // d.a.i0.a.p0.h.b
    @NonNull
    public ExtensionCore h() {
        ExtensionCore extensionCore = new ExtensionCore();
        extensionCore.extensionCoreVersionCode = 0L;
        extensionCore.extensionCoreVersionName = "0";
        extensionCore.extensionCorePath = "";
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    @Override // d.a.i0.a.p0.h.b
    public long i() {
        return 0L;
    }

    @Override // d.a.i0.a.p0.h.b
    public String j() {
        return "0";
    }

    @Override // d.a.i0.a.p0.h.c.a, d.a.i0.a.p0.h.b
    public boolean k() {
        if (f43928e) {
            Log.d("SwanNoPresetExtensionCoreControl", "isNeedUpdate false");
            return false;
        }
        return false;
    }

    @Override // d.a.i0.a.p0.h.b
    public void n(long j) {
    }

    @Override // d.a.i0.a.p0.h.b
    public void o(String str) {
    }
}
