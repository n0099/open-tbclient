package d.b.g0.a.l0.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.c0.c;
import d.b.g0.a.i2.k0;
import d.b.g0.a.k;
import d.b.g0.a.l0.h.c.a;
import d.b.g0.p.d;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public abstract class b<T extends d.b.g0.a.l0.h.c.a> extends d.b.g0.a.l0.e.a<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f45160c = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<d.b.g0.a.i2.u0.b<Exception>> f45161b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.h("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
            d.b.g0.a.l0.i.a b2 = d.b.g0.a.l0.i.a.b(b.this.f45084a);
            d.b.g0.a.l0.h.a aVar = new d.b.g0.a.l0.h.a();
            aVar.f45153a = b2.f45159a;
            aVar.f45154b = b.this.f45084a.b();
            b bVar = b.this;
            bVar.j(bVar.f(aVar));
        }
    }

    /* renamed from: d.b.g0.a.l0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0724b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.g0.a.i2.u0.b f45163e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f45164f;

        public RunnableC0724b(b bVar, d.b.g0.a.i2.u0.b bVar2, Exception exc) {
            this.f45163e = bVar2;
            this.f45164f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f45163e.onCallback(this.f45164f);
        }
    }

    public b(@NonNull T t) {
        super(t);
        this.f45161b = new CopyOnWriteArrayList<>();
    }

    @Override // d.b.g0.a.l0.e.a
    public File a() {
        return new File(super.a(), "preset");
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ld/b/g0/a/l0/h/a;>(TT;)Ljava/lang/Exception; */
    public Exception f(@NonNull d.b.g0.a.l0.h.a aVar) {
        if (f45160c) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.f45154b)) {
            if (f45160c) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long e2 = d.b.g0.a.l0.k.a.e(aVar.f45153a);
        if (d.G(aVar.f45154b, b(e2).getPath())) {
            d.b.g0.a.l0.k.a.b(a(), e2);
            l(e2);
            d.b.g0.a.l0.k.a.j(this.f45084a.c(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.f45154b);
        if (f45160c) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
        }
        return exc;
    }

    @NonNull
    public ExtensionCore g() {
        ExtensionCore extensionCore = new ExtensionCore();
        long h2 = h();
        extensionCore.extensionCoreVersionCode = h2;
        extensionCore.extensionCoreVersionName = d.b.g0.a.l0.k.a.f(h2);
        extensionCore.extensionCorePath = b(h2).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    public long h() {
        return h.a().getLong(this.f45084a.a(), 0L);
    }

    public final boolean i() {
        if (!d.b.g0.a.l0.k.a.i(this.f45084a.c())) {
            if (f45160c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
            }
            return false;
        }
        d.b.g0.a.l0.i.a b2 = d.b.g0.a.l0.i.a.b(this.f45084a);
        long h2 = h();
        long e2 = d.b.g0.a.l0.k.a.e(b2.f45159a);
        if (f45160c) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + h2 + " newVer: " + e2);
        }
        return h2 < e2;
    }

    public final void j(Exception exc) {
        Iterator<d.b.g0.a.i2.u0.b<Exception>> it = this.f45161b.iterator();
        while (it.hasNext()) {
            k(it.next(), exc);
        }
        this.f45161b.clear();
    }

    public final void k(@Nullable d.b.g0.a.i2.u0.b<Exception> bVar, Exception exc) {
        if (bVar != null) {
            k0.X(new RunnableC0724b(this, bVar, exc));
        }
    }

    public void l(long j) {
        h.a().putLong(this.f45084a.a(), j);
    }

    @SuppressLint({"SwanNewThread"})
    public void m(@Nullable d.b.g0.a.i2.u0.b<Exception> bVar) {
        c.h("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!i()) {
            c.h("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            k(bVar, null);
            return;
        }
        if (this.f45161b.isEmpty()) {
            new Thread(new a(), "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.f45161b.add(bVar);
        }
    }

    public void n() {
        if (i()) {
            d.b.g0.a.l0.i.a b2 = d.b.g0.a.l0.i.a.b(this.f45084a);
            d.b.g0.a.l0.h.a aVar = new d.b.g0.a.l0.h.a();
            aVar.f45153a = b2.f45159a;
            aVar.f45154b = this.f45084a.b();
            j(f(aVar));
        }
    }
}
