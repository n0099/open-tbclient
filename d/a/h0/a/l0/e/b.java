package d.a.h0.a.l0.e;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.h0.a.k;
import d.a.h0.a.l0.i.b;
import d.a.h0.a.l0.j.a;
/* loaded from: classes2.dex */
public abstract class b<P extends d.a.h0.a.l0.i.b, R extends d.a.h0.a.l0.j.a> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43136c = k.f43101a;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public P f43137a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public R f43138b;

    public b(@NonNull P p, @NonNull R r) {
        this.f43137a = p;
        this.f43138b = r;
    }

    public <T extends d.a.h0.a.l0.h.a> Exception a(T t) {
        if (t == null) {
            return new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo");
        }
        return this.f43138b.d(t);
    }

    @Nullable
    public abstract ExtensionCore b();

    @NonNull
    public ExtensionCore c() {
        String path;
        int b2 = this.f43137a.f43135a.b();
        if (d.a.h0.a.l0.k.a.g(b2)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = d.a.h0.a.l0.k.a.f(0L);
            if (b2 == 1) {
                path = d.a.h0.g.k.a.b.b().getPath();
            } else {
                path = d.a.h0.a.l0.g.b.b().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (f43136c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore g2 = this.f43137a.g();
        ExtensionCore e2 = this.f43138b.e();
        if (g2.extensionCoreVersionCode >= e2.extensionCoreVersionCode) {
            if (f43136c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + g2.toString());
            }
            return g2;
        }
        if (f43136c) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + e2.toString());
        }
        return e2;
    }

    @NonNull
    public P d() {
        return this.f43137a;
    }

    @NonNull
    public R e() {
        return this.f43138b;
    }

    public void f(@Nullable d.a.h0.a.i2.u0.b<Exception> bVar) {
        this.f43137a.m(bVar);
    }

    public void g() {
        this.f43137a.n();
    }
}
