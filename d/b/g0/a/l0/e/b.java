package d.b.g0.a.l0.e;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.g0.a.k;
import d.b.g0.a.l0.i.b;
import d.b.g0.a.l0.j.a;
/* loaded from: classes2.dex */
public abstract class b<P extends d.b.g0.a.l0.i.b, R extends d.b.g0.a.l0.j.a> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45086c = k.f45051a;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public P f45087a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public R f45088b;

    public b(@NonNull P p, @NonNull R r) {
        this.f45087a = p;
        this.f45088b = r;
    }

    public <T extends d.b.g0.a.l0.h.a> Exception a(T t) {
        if (t == null) {
            return new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo");
        }
        return this.f45088b.d(t);
    }

    @Nullable
    public abstract ExtensionCore b();

    @NonNull
    public ExtensionCore c() {
        String path;
        int c2 = this.f45087a.f45085a.c();
        if (d.b.g0.a.l0.k.a.g(c2)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = d.b.g0.a.l0.k.a.f(0L);
            if (c2 == 1) {
                path = d.b.g0.g.k.a.b.b().getPath();
            } else {
                path = d.b.g0.a.l0.g.b.b().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (f45086c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore g2 = this.f45087a.g();
        ExtensionCore e2 = this.f45088b.e();
        if (g2.extensionCoreVersionCode >= e2.extensionCoreVersionCode) {
            if (f45086c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + g2.toString());
            }
            return g2;
        }
        if (f45086c) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + e2.toString());
        }
        return e2;
    }

    @NonNull
    public P d() {
        return this.f45087a;
    }

    @NonNull
    public R e() {
        return this.f45088b;
    }

    public void f(@Nullable d.b.g0.a.i2.u0.b<Exception> bVar) {
        this.f45087a.m(bVar);
    }

    public void g() {
        this.f45087a.n();
    }
}
