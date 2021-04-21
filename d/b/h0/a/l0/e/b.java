package d.b.h0.a.l0.e;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.h0.a.k;
import d.b.h0.a.l0.i.b;
import d.b.h0.a.l0.j.a;
/* loaded from: classes2.dex */
public abstract class b<P extends d.b.h0.a.l0.i.b, R extends d.b.h0.a.l0.j.a> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45807c = k.f45772a;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public P f45808a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public R f45809b;

    public b(@NonNull P p, @NonNull R r) {
        this.f45808a = p;
        this.f45809b = r;
    }

    public <T extends d.b.h0.a.l0.h.a> Exception a(T t) {
        if (t == null) {
            return new Exception("ExtCore-Manager doRemoteUpdate: null updateInfo");
        }
        return this.f45809b.d(t);
    }

    @Nullable
    public abstract ExtensionCore b();

    @NonNull
    public ExtensionCore c() {
        String path;
        int c2 = this.f45808a.f45806a.c();
        if (d.b.h0.a.l0.k.a.g(c2)) {
            ExtensionCore extensionCore = new ExtensionCore();
            extensionCore.extensionCoreVersionCode = 0L;
            extensionCore.extensionCoreVersionName = d.b.h0.a.l0.k.a.f(0L);
            if (c2 == 1) {
                path = d.b.h0.g.k.a.b.b().getPath();
            } else {
                path = d.b.h0.a.l0.g.b.b().getPath();
            }
            extensionCore.extensionCorePath = path;
            extensionCore.extensionCoreType = 2;
            if (f45807c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: debug=>" + extensionCore.toString());
            }
            return extensionCore;
        }
        ExtensionCore g2 = this.f45808a.g();
        ExtensionCore e2 = this.f45809b.e();
        if (g2.extensionCoreVersionCode >= e2.extensionCoreVersionCode) {
            if (f45807c) {
                Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: preset=>" + g2.toString());
            }
            return g2;
        }
        if (f45807c) {
            Log.d("ExtCore-Manager", "getExtensionCoreInMainProcess: remote=>" + e2.toString());
        }
        return e2;
    }

    @NonNull
    public P d() {
        return this.f45808a;
    }

    @NonNull
    public R e() {
        return this.f45809b;
    }

    public void f(@Nullable d.b.h0.a.i2.u0.b<Exception> bVar) {
        this.f45808a.m(bVar);
    }

    public void g() {
        this.f45808a.n();
    }
}
