package d.a.i0.a.p0.h;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.i0.a.e0.d;
import d.a.i0.a.k;
import d.a.i0.a.k2.g.h;
import d.a.i0.a.p0.g.c.a;
import d.a.i0.a.v2.q0;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public abstract class b<T extends d.a.i0.a.p0.g.c.a> extends d.a.i0.a.p0.d.a<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f43922c = k.f43025a;

    /* renamed from: b  reason: collision with root package name */
    public CopyOnWriteArrayList<d.a.i0.a.v2.e1.b<Exception>> f43923b;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.h("ExtCore-PresetControl", "run: tryUpdateAsync start doUpdate");
            d.a.i0.a.p0.h.a b2 = d.a.i0.a.p0.h.a.b(b.this.f43837a);
            d.a.i0.a.p0.g.a aVar = new d.a.i0.a.p0.g.a();
            aVar.f43912a = b2.f43920a;
            aVar.f43913b = b2.f43921b;
            aVar.f43914c = b.this.f43837a.a();
            b bVar = b.this;
            bVar.l(bVar.g(aVar));
        }
    }

    /* renamed from: d.a.i0.a.p0.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0786b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.v2.e1.b f43925e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Exception f43926f;

        public RunnableC0786b(b bVar, d.a.i0.a.v2.e1.b bVar2, Exception exc) {
            this.f43925e = bVar2;
            this.f43926f = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43925e.onCallback(this.f43926f);
        }
    }

    public b(@NonNull T t) {
        super(t);
        this.f43923b = new CopyOnWriteArrayList<>();
    }

    @Override // d.a.i0.a.p0.d.a
    public File a() {
        return new File(super.a(), "preset");
    }

    public void f() {
        o("0");
        n(0L);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ld/a/i0/a/p0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception g(@NonNull d.a.i0.a.p0.g.a aVar) {
        if (f43922c) {
            Log.d("ExtCore-PresetControl", "doUpdate: preset");
        }
        if (TextUtils.isEmpty(aVar.f43914c)) {
            if (f43922c) {
                Log.e("ExtCore-PresetControl", "doUpdate: preset with null coreFilePath");
            }
            return new IllegalStateException("ExtCore-PresetControl doUpdate: failed by updateInfo.coreFilePath is empty");
        }
        long j = aVar.f43913b;
        if (d.a.i0.t.d.U(aVar.f43914c, b(j).getPath())) {
            d.a.i0.a.p0.j.a.b(a(), j);
            n(j);
            o(aVar.f43912a);
            d.a.i0.a.p0.j.a.i(this.f43837a.c(), false);
            return null;
        }
        Exception exc = new Exception("ExtCore-PresetControl doUpdate: failed by can not unzip coreFile = " + aVar.f43914c);
        if (f43922c) {
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
        return h.a().getLong(this.f43837a.b(), 0L);
    }

    public String j() {
        return h.a().getString(this.f43837a.e(), "");
    }

    public boolean k() {
        if (!h().a()) {
            if (f43922c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: true, getCurExtensionCore not available.");
            }
            return true;
        } else if (!d.a.i0.a.p0.j.a.h(this.f43837a.c())) {
            if (f43922c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate: false");
            }
            return false;
        } else {
            d.a.i0.a.p0.h.a b2 = d.a.i0.a.p0.h.a.b(this.f43837a);
            long i2 = i();
            long j = b2.f43921b;
            if (f43922c) {
                Log.d("ExtCore-PresetControl", "isNeedUpdate curVer: " + i2 + " newVer: " + j);
            }
            return i2 < j;
        }
    }

    public final void l(Exception exc) {
        Iterator<d.a.i0.a.v2.e1.b<Exception>> it = this.f43923b.iterator();
        while (it.hasNext()) {
            m(it.next(), exc);
        }
        this.f43923b.clear();
    }

    public final void m(@Nullable d.a.i0.a.v2.e1.b<Exception> bVar, Exception exc) {
        if (bVar != null) {
            q0.b0(new RunnableC0786b(this, bVar, exc));
        }
    }

    public void n(long j) {
        h.a().putLong(this.f43837a.b(), j);
    }

    public void o(String str) {
        h.a().putString(this.f43837a.e(), str);
    }

    @SuppressLint({"SwanNewThread"})
    public void p(@Nullable d.a.i0.a.v2.e1.b<Exception> bVar) {
        d.h("ExtCore-PresetControl", "tryUpdateAsync: start");
        if (!k()) {
            d.h("ExtCore-PresetControl", "tryUpdateAsync: isNeedUpdate = false");
            m(bVar, null);
            return;
        }
        if (this.f43923b.isEmpty()) {
            new Thread(new a(), "updateExtensionCoreAsync").start();
        }
        if (bVar != null) {
            this.f43923b.add(bVar);
        }
    }

    public void q() {
        if (k()) {
            d.a.i0.a.p0.h.a b2 = d.a.i0.a.p0.h.a.b(this.f43837a);
            d.a.i0.a.p0.g.a aVar = new d.a.i0.a.p0.g.a();
            aVar.f43912a = b2.f43920a;
            aVar.f43913b = b2.f43921b;
            aVar.f43914c = this.f43837a.a();
            l(g(aVar));
        }
    }
}
