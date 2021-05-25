package d.a.l0.a.p0.d;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.l0.a.k;
import d.a.l0.a.p0.h.b;
import d.a.l0.a.p0.i.a;
/* loaded from: classes2.dex */
public abstract class b<P extends d.a.l0.a.p0.h.b, R extends d.a.l0.a.p0.i.a> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44014c = k.f43199a;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public P f44015a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public R f44016b;

    public b(@NonNull P p, @NonNull R r) {
        this.f44015a = p;
        this.f44016b = r;
    }

    public <T extends d.a.l0.a.p0.g.a> Exception a(T t) {
        if (t == null) {
            return new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo");
        }
        return this.f44016b.e(t);
    }

    public abstract String b(int i2);

    @Nullable
    public abstract ExtensionCore c();

    @NonNull
    public ExtensionCore d() {
        int c2 = this.f44015a.f44013a.c();
        if (d.a.l0.a.p0.j.a.f(c2)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = "0";
            extensionCore.extensionCorePath = b(c2);
            extensionCore.extensionCoreType = 2;
            if (f44014c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore h2 = this.f44015a.h();
        ExtensionCore f2 = this.f44016b.f();
        if (h2.extensionCoreVersionCode < f2.extensionCoreVersionCode && f2.a()) {
            if (f44014c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + f2.toString());
            }
            return f2;
        }
        if (f44014c) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + h2.toString());
        }
        return h2;
    }

    @NonNull
    public P e() {
        return this.f44015a;
    }

    @NonNull
    public R f() {
        return this.f44016b;
    }

    public void g(@Nullable d.a.l0.a.v2.e1.b<Exception> bVar) {
        this.f44015a.p(bVar);
    }

    public void h() {
        this.f44015a.q();
    }
}
