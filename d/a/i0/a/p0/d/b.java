package d.a.i0.a.p0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.i0.a.k;
import d.a.i0.a.p0.h.b;
import d.a.i0.a.p0.i.a;
/* loaded from: classes2.dex */
public abstract class b<P extends d.a.i0.a.p0.h.b, R extends d.a.i0.a.p0.i.a> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43838c = k.f43025a;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public P f43839a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public R f43840b;

    public b(@NonNull P p, @NonNull R r) {
        this.f43839a = p;
        this.f43840b = r;
    }

    public <T extends d.a.i0.a.p0.g.a> Exception a(T t) {
        if (t == null) {
            return new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo");
        }
        return this.f43840b.e(t);
    }

    public abstract String b(int i2);

    @Nullable
    public abstract ExtensionCore c();

    @NonNull
    public ExtensionCore d() {
        int c2 = this.f43839a.f43837a.c();
        if (d.a.i0.a.p0.j.a.f(c2)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = "0";
            extensionCore.extensionCorePath = b(c2);
            extensionCore.extensionCoreType = 2;
            if (f43838c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore h2 = this.f43839a.h();
        ExtensionCore f2 = this.f43840b.f();
        if (h2.extensionCoreVersionCode < f2.extensionCoreVersionCode && f2.a()) {
            if (f43838c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + f2.toString());
            }
            return f2;
        }
        if (f43838c) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + h2.toString());
        }
        return h2;
    }

    @NonNull
    public P e() {
        return this.f43839a;
    }

    @NonNull
    public R f() {
        return this.f43840b;
    }

    public void g(@Nullable d.a.i0.a.v2.e1.b<Exception> bVar) {
        this.f43839a.p(bVar);
    }

    public void h() {
        this.f43839a.q();
    }
}
