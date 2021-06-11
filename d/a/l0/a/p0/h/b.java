package d.a.l0.a.p0.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.l0.a.e0.d;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.p0.g.c.a;
import d.a.l0.a.v2.q0;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public abstract class b<T extends d.a.l0.a.p0.g.c.a> extends d.a.l0.a.p0.d.a<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f47772c = k.f46875a;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.l0.a.v2.e1.b<Exception>> f47773b;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.h("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
            d.a.l0.a.p0.h.a b2 = d.a.l0.a.p0.h.a.b(b.this.f47687a);
            d.a.l0.a.p0.g.a aVar = new d.a.l0.a.p0.g.a();
            aVar.f47762a = b2.f47770a;
            aVar.f47763b = b2.f47771b;
            aVar.f47764c = b.this.f47687a.a();
            b bVar = b.this;
            bVar.l(bVar.g(aVar));
        }
    }

    /* renamed from: d.a.l0.a.p0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC0853b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f47775e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f47776f;

        public RunnableC0853b(b bVar, d.a.l0.a.v2.e1.b bVar2, Exception exc) {
            this.f47775e = bVar2;
            this.f47776f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47775e.onCallback(this.f47776f);
        }
    }

    public b(@NonNull T t) {
        super(t);
        this.f47773b = new CopyOnWriteArrayList<>();
    }

    @Override // d.a.l0.a.p0.d.a
    public File a() {
        return new File(super.a(), "preset");
    }

    public void f() {
        o("0");
        n(0L);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ld/a/l0/a/p0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception g(@NonNull d.a.l0.a.p0.g.a aVar) {
        if (f47772c) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.f47764c)) {
            if (f47772c) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long j = aVar.f47763b;
        if (d.a.l0.t.d.U(aVar.f47764c, b(j).getPath())) {
            d.a.l0.a.p0.j.a.b(a(), j);
            n(j);
            o(aVar.f47762a);
            d.a.l0.a.p0.j.a.i(this.f47687a.c(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.f47764c);
        if (f47772c) {
            Log.e("ExtCore-PresetControl", "doUpdate preset unzip failed: " + Log.getStackTraceString(exc));
        }
        return exc;
    }

    @NonNull
    public ExtensionCore h() {
        ExtensionCore extensionCore = new ExtensionCore();
        long i2 = i();
        extensionCore.extensionCoreVersionCode = i2;
        extensionCore.extensionCoreVersionName = j();
        extensionCore.extensionCorePath = b(i2).getPath();
        extensionCore.extensionCoreType = 0;
        return extensionCore;
    }

    public long i() {
        return h.a().getLong(this.f47687a.b(), 0L);
    }

    public String j() {
        return h.a().getString(this.f47687a.e(), "");
    }

    public boolean k() {
        if (!h().a()) {
            if (f47772c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: true, getCurExtensionCore not available.");
            }
            return true;
        } else if (!d.a.l0.a.p0.j.a.h(this.f47687a.c())) {
            if (f47772c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
            }
            return false;
        } else {
            d.a.l0.a.p0.h.a b2 = d.a.l0.a.p0.h.a.b(this.f47687a);
            long i2 = i();
            long j = b2.f47771b;
            if (f47772c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + i2 + " newVer: " + j);
            }
            return i2 < j;
        }
    }

    public final void l(Exception exc) {
        Iterator<d.a.l0.a.v2.e1.b<Exception>> it = this.f47773b.iterator();
        while (it.hasNext()) {
            m(it.next(), exc);
        }
        this.f47773b.clear();
    }

    public final void m(@Nullable d.a.l0.a.v2.e1.b<Exception> bVar, Exception exc) {
        if (bVar != null) {
            q0.b0(new RunnableC0853b(this, bVar, exc));
        }
    }

    public void n(long j) {
        h.a().putLong(this.f47687a.b(), j);
    }

    public void o(String str) {
        h.a().putString(this.f47687a.e(), str);
    }

    @SuppressLint({"SwanNewThread"})
    public void p(@Nullable d.a.l0.a.v2.e1.b<Exception> bVar) {
        d.h("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!k()) {
            d.h("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            m(bVar, null);
            return;
        }
        if (this.f47773b.isEmpty()) {
            new Thread(new a(), "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.f47773b.add(bVar);
        }
    }

    public void q() {
        if (k()) {
            d.a.l0.a.p0.h.a b2 = d.a.l0.a.p0.h.a.b(this.f47687a);
            d.a.l0.a.p0.g.a aVar = new d.a.l0.a.p0.g.a();
            aVar.f47762a = b2.f47770a;
            aVar.f47763b = b2.f47771b;
            aVar.f47764c = this.f47687a.a();
            l(g(aVar));
        }
    }
}
