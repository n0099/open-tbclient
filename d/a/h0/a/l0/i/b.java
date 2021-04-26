package d.a.h0.a.l0.i;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.c0.c;
import d.a.h0.a.i2.k0;
import d.a.h0.a.k;
import d.a.h0.a.l0.h.c.a;
import d.a.h0.p.d;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public abstract class b<T extends d.a.h0.a.l0.h.c.a> extends d.a.h0.a.l0.e.a<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43216c = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.h0.a.i2.u0.b<Exception>> f43217b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.h("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
            d.a.h0.a.l0.i.a b2 = d.a.h0.a.l0.i.a.b(b.this.f43135a);
            d.a.h0.a.l0.h.a aVar = new d.a.h0.a.l0.h.a();
            aVar.f43209a = b2.f43215a;
            aVar.f43210b = b.this.f43135a.a();
            b bVar = b.this;
            bVar.j(bVar.f(aVar));
        }
    }

    /* renamed from: d.a.h0.a.l0.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0696b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.h0.a.i2.u0.b f43219e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f43220f;

        public RunnableC0696b(b bVar, d.a.h0.a.i2.u0.b bVar2, Exception exc) {
            this.f43219e = bVar2;
            this.f43220f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43219e.onCallback(this.f43220f);
        }
    }

    public b(@NonNull T t) {
        super(t);
        this.f43217b = new CopyOnWriteArrayList<>();
    }

    @Override // d.a.h0.a.l0.e.a
    public File a() {
        return new File(super.a(), "preset");
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ld/a/h0/a/l0/h/a;>(TT;)Ljava/lang/Exception; */
    public Exception f(@NonNull d.a.h0.a.l0.h.a aVar) {
        if (f43216c) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.f43210b)) {
            if (f43216c) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long e2 = d.a.h0.a.l0.k.a.e(aVar.f43209a);
        if (d.G(aVar.f43210b, b(e2).getPath())) {
            d.a.h0.a.l0.k.a.b(a(), e2);
            l(e2);
            d.a.h0.a.l0.k.a.j(this.f43135a.b(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.f43210b);
        if (f43216c) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
        }
        return exc;
    }

    @NonNull
    public ExtensionCore g() {
        ExtensionCore extensionCore = new ExtensionCore();
        long h2 = h();
        extensionCore.extensionCoreVersionCode = h2;
        extensionCore.extensionCoreVersionName = d.a.h0.a.l0.k.a.f(h2);
        extensionCore.extensionCorePath = b(h2).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    public long h() {
        return h.a().getLong(this.f43135a.d(), 0L);
    }

    public final boolean i() {
        if (!d.a.h0.a.l0.k.a.i(this.f43135a.b())) {
            if (f43216c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
            }
            return false;
        }
        d.a.h0.a.l0.i.a b2 = d.a.h0.a.l0.i.a.b(this.f43135a);
        long h2 = h();
        long e2 = d.a.h0.a.l0.k.a.e(b2.f43215a);
        if (f43216c) {
            Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + h2 + " newVer: " + e2);
        }
        return h2 < e2;
    }

    public final void j(Exception exc) {
        Iterator<d.a.h0.a.i2.u0.b<Exception>> it = this.f43217b.iterator();
        while (it.hasNext()) {
            k(it.next(), exc);
        }
        this.f43217b.clear();
    }

    public final void k(@Nullable d.a.h0.a.i2.u0.b<Exception> bVar, Exception exc) {
        if (bVar != null) {
            k0.X(new RunnableC0696b(this, bVar, exc));
        }
    }

    public void l(long j) {
        h.a().putLong(this.f43135a.d(), j);
    }

    @SuppressLint({"SwanNewThread"})
    public void m(@Nullable d.a.h0.a.i2.u0.b<Exception> bVar) {
        c.h("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!i()) {
            c.h("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            k(bVar, null);
            return;
        }
        if (this.f43217b.isEmpty()) {
            new Thread(new a(), "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.f43217b.add(bVar);
        }
    }

    public void n() {
        if (i()) {
            d.a.h0.a.l0.i.a b2 = d.a.h0.a.l0.i.a.b(this.f43135a);
            d.a.h0.a.l0.h.a aVar = new d.a.h0.a.l0.h.a();
            aVar.f43209a = b2.f43215a;
            aVar.f43210b = this.f43135a.a();
            j(f(aVar));
        }
    }
}
