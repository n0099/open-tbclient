package d.b.h0.a.l0.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.h0.a.a2.g.h;
import d.b.h0.a.c0.c;
import d.b.h0.a.i2.k0;
import d.b.h0.a.k;
import d.b.h0.a.l0.h.c.a;
import d.b.h0.p.d;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public abstract class b<T extends d.b.h0.a.l0.h.c.a> extends d.b.h0.a.l0.e.a<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45882c = k.f45772a;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<d.b.h0.a.i2.u0.b<Exception>> f45883b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.h("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
            d.b.h0.a.l0.i.a b2 = d.b.h0.a.l0.i.a.b(b.this.f45806a);
            d.b.h0.a.l0.h.a aVar = new d.b.h0.a.l0.h.a();
            aVar.f45875a = b2.f45881a;
            aVar.f45876b = b.this.f45806a.b();
            b bVar = b.this;
            bVar.j(bVar.f(aVar));
        }
    }

    /* renamed from: d.b.h0.a.l0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0757b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.a.i2.u0.b f45885e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f45886f;

        public RunnableC0757b(b bVar, d.b.h0.a.i2.u0.b bVar2, Exception exc) {
            this.f45885e = bVar2;
            this.f45886f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45885e.onCallback(this.f45886f);
        }
    }

    public b(@NonNull T t) {
        super(t);
        this.f45883b = new CopyOnWriteArrayList<>();
    }

    @Override // d.b.h0.a.l0.e.a
    public File a() {
        return new File(super.a(), "preset");
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ld/b/h0/a/l0/h/a;>(TT;)Ljava/lang/Exception; */
    public Exception f(@NonNull d.b.h0.a.l0.h.a aVar) {
        if (f45882c) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.f45876b)) {
            if (f45882c) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long e2 = d.b.h0.a.l0.k.a.e(aVar.f45875a);
        if (d.G(aVar.f45876b, b(e2).getPath())) {
            d.b.h0.a.l0.k.a.b(a(), e2);
            l(e2);
            d.b.h0.a.l0.k.a.j(this.f45806a.c(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.f45876b);
        if (f45882c) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
        }
        return exc;
    }

    @NonNull
    public ExtensionCore g() {
        ExtensionCore extensionCore = new ExtensionCore();
        long h2 = h();
        extensionCore.extensionCoreVersionCode = h2;
        extensionCore.extensionCoreVersionName = d.b.h0.a.l0.k.a.f(h2);
        extensionCore.extensionCorePath = b(h2).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    public long h() {
        return h.a().getLong(this.f45806a.a(), 0L);
    }

    public final boolean i() {
        if (!d.b.h0.a.l0.k.a.i(this.f45806a.c())) {
            if (f45882c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
            }
            return false;
        }
        d.b.h0.a.l0.i.a b2 = d.b.h0.a.l0.i.a.b(this.f45806a);
        long h2 = h();
        long e2 = d.b.h0.a.l0.k.a.e(b2.f45881a);
        if (f45882c) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + h2 + " newVer: " + e2);
        }
        return h2 < e2;
    }

    public final void j(Exception exc) {
        Iterator<d.b.h0.a.i2.u0.b<Exception>> it = this.f45883b.iterator();
        while (it.hasNext()) {
            k(it.next(), exc);
        }
        this.f45883b.clear();
    }

    public final void k(@Nullable d.b.h0.a.i2.u0.b<Exception> bVar, Exception exc) {
        if (bVar != null) {
            k0.X(new RunnableC0757b(this, bVar, exc));
        }
    }

    public void l(long j) {
        h.a().putLong(this.f45806a.a(), j);
    }

    @SuppressLint({"SwanNewThread"})
    public void m(@Nullable d.b.h0.a.i2.u0.b<Exception> bVar) {
        c.h("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!i()) {
            c.h("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            k(bVar, null);
            return;
        }
        if (this.f45883b.isEmpty()) {
            new Thread(new a(), "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.f45883b.add(bVar);
        }
    }

    public void n() {
        if (i()) {
            d.b.h0.a.l0.i.a b2 = d.b.h0.a.l0.i.a.b(this.f45806a);
            d.b.h0.a.l0.h.a aVar = new d.b.h0.a.l0.h.a();
            aVar.f45875a = b2.f45881a;
            aVar.f45876b = this.f45806a.b();
            j(f(aVar));
        }
    }
}
