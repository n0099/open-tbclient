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
/* loaded from: classes2.dex */
public abstract class b<T extends d.a.l0.a.p0.g.c.a> extends d.a.l0.a.p0.d.a<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f44098c = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.l0.a.v2.e1.b<Exception>> f44099b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.h("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
            d.a.l0.a.p0.h.a b2 = d.a.l0.a.p0.h.a.b(b.this.f44013a);
            d.a.l0.a.p0.g.a aVar = new d.a.l0.a.p0.g.a();
            aVar.f44088a = b2.f44096a;
            aVar.f44089b = b2.f44097b;
            aVar.f44090c = b.this.f44013a.a();
            b bVar = b.this;
            bVar.l(bVar.g(aVar));
        }
    }

    /* renamed from: d.a.l0.a.p0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0797b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.l0.a.v2.e1.b f44101e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f44102f;

        public RunnableC0797b(b bVar, d.a.l0.a.v2.e1.b bVar2, Exception exc) {
            this.f44101e = bVar2;
            this.f44102f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44101e.onCallback(this.f44102f);
        }
    }

    public b(@NonNull T t) {
        super(t);
        this.f44099b = new CopyOnWriteArrayList<>();
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
        if (f44098c) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.f44090c)) {
            if (f44098c) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long j = aVar.f44089b;
        if (d.a.l0.t.d.U(aVar.f44090c, b(j).getPath())) {
            d.a.l0.a.p0.j.a.b(a(), j);
            n(j);
            o(aVar.f44088a);
            d.a.l0.a.p0.j.a.i(this.f44013a.c(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.f44090c);
        if (f44098c) {
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
        return h.a().getLong(this.f44013a.b(), 0L);
    }

    public String j() {
        return h.a().getString(this.f44013a.e(), "");
    }

    public boolean k() {
        if (!h().a()) {
            if (f44098c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: true, getCurExtensionCore not available.");
            }
            return true;
        } else if (!d.a.l0.a.p0.j.a.h(this.f44013a.c())) {
            if (f44098c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
            }
            return false;
        } else {
            d.a.l0.a.p0.h.a b2 = d.a.l0.a.p0.h.a.b(this.f44013a);
            long i2 = i();
            long j = b2.f44097b;
            if (f44098c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + i2 + " newVer: " + j);
            }
            return i2 < j;
        }
    }

    public final void l(Exception exc) {
        Iterator<d.a.l0.a.v2.e1.b<Exception>> it = this.f44099b.iterator();
        while (it.hasNext()) {
            m(it.next(), exc);
        }
        this.f44099b.clear();
    }

    public final void m(@Nullable d.a.l0.a.v2.e1.b<Exception> bVar, Exception exc) {
        if (bVar != null) {
            q0.b0(new RunnableC0797b(this, bVar, exc));
        }
    }

    public void n(long j) {
        h.a().putLong(this.f44013a.b(), j);
    }

    public void o(String str) {
        h.a().putString(this.f44013a.e(), str);
    }

    @SuppressLint({"SwanNewThread"})
    public void p(@Nullable d.a.l0.a.v2.e1.b<Exception> bVar) {
        d.h("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!k()) {
            d.h("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            m(bVar, null);
            return;
        }
        if (this.f44099b.isEmpty()) {
            new Thread(new a(), "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.f44099b.add(bVar);
        }
    }

    public void q() {
        if (k()) {
            d.a.l0.a.p0.h.a b2 = d.a.l0.a.p0.h.a.b(this.f44013a);
            d.a.l0.a.p0.g.a aVar = new d.a.l0.a.p0.g.a();
            aVar.f44088a = b2.f44096a;
            aVar.f44089b = b2.f44097b;
            aVar.f44090c = this.f44013a.a();
            l(g(aVar));
        }
    }
}
