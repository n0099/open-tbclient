package d.a.m0.a.p0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.m0.a.k;
import d.a.m0.a.p0.h.b;
import d.a.m0.a.p0.i.a;
/* loaded from: classes3.dex */
public abstract class b<P extends d.a.m0.a.p0.h.b, R extends d.a.m0.a.p0.i.a> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47796c = k.f46983a;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public P f47797a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public R f47798b;

    public b(@NonNull P p, @NonNull R r) {
        this.f47797a = p;
        this.f47798b = r;
    }

    public <T extends d.a.m0.a.p0.g.a> Exception a(T t) {
        if (t == null) {
            return new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo");
        }
        return this.f47798b.e(t);
    }

    public abstract String b(int i2);

    @Nullable
    public abstract ExtensionCore c();

    @NonNull
    public ExtensionCore d() {
        int c2 = this.f47797a.f47795a.c();
        if (d.a.m0.a.p0.j.a.f(c2)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = "0";
            extensionCore.extensionCorePath = b(c2);
            extensionCore.extensionCoreType = 2;
            if (f47796c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore h2 = this.f47797a.h();
        ExtensionCore f2 = this.f47798b.f();
        if (h2.extensionCoreVersionCode < f2.extensionCoreVersionCode && f2.a()) {
            if (f47796c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + f2.toString());
            }
            return f2;
        }
        if (f47796c) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + h2.toString());
        }
        return h2;
    }

    @NonNull
    public P e() {
        return this.f47797a;
    }

    @NonNull
    public R f() {
        return this.f47798b;
    }

    public void g(@Nullable d.a.m0.a.v2.e1.b<Exception> bVar) {
        this.f47797a.p(bVar);
    }

    public void h() {
        this.f47797a.q();
    }
}
