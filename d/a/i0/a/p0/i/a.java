package d.a.i0.a.p0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.i0.a.k;
import d.a.i0.a.k2.g.h;
import d.a.i0.a.p0.g.c.a;
import d.a.i0.a.v2.j0;
import d.a.i0.t.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a<T extends d.a.i0.a.p0.g.c.a> extends d.a.i0.a.p0.d.a<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f43929b = k.f43025a;

    /* renamed from: d.a.i0.a.p0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0787a {

        /* renamed from: a  reason: collision with root package name */
        public int f43930a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f43931b;

        public static C0787a a(int i2, String str) {
            C0787a c0787a = new C0787a();
            c0787a.f43930a = i2;
            c0787a.f43931b = str;
            return c0787a;
        }

        public static C0787a b(String str) {
            return a(1, str);
        }

        public static C0787a d() {
            return a(0, "");
        }

        public boolean c() {
            return this.f43930a == 0;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.f43930a + ", message='" + this.f43931b + "'}";
        }
    }

    public a(@NonNull T t) {
        super(t);
    }

    @Override // d.a.i0.a.p0.d.a
    public File a() {
        return new File(super.a(), "remote");
    }

    public void c() {
        k("0");
        j(0L);
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.j(str);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ld/a/i0/a/p0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception e(@NonNull d.a.i0.a.p0.g.a aVar) {
        if (f43929b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.f43914c)) {
            if (f43929b) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0787a i2 = i(aVar);
        if (f43929b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + i2);
        }
        d(aVar.f43914c);
        if (i2.c()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + i2.toString());
    }

    @NonNull
    public ExtensionCore f() {
        ExtensionCore extensionCore = new ExtensionCore();
        long g2 = g();
        extensionCore.extensionCoreVersionCode = g2;
        extensionCore.extensionCoreVersionName = h();
        extensionCore.extensionCorePath = b(g2).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    public long g() {
        return h.a().getLong(this.f43837a.b(), 0L);
    }

    public String h() {
        return h.a().getString(this.f43837a.e(), "0");
    }

    public final C0787a i(@NonNull d.a.i0.a.p0.g.a aVar) {
        if (f43929b) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + aVar.f43912a + " ,filePath: " + aVar.f43914c + " ,sign:" + aVar.f43915d);
        }
        long j = aVar.f43913b;
        if (j == 0) {
            return C0787a.b("invalid version code : " + aVar.f43912a);
        } else if (!j0.a(new File(aVar.f43914c), aVar.f43915d)) {
            return C0787a.b("sign failed.");
        } else {
            if (!d.T(aVar.f43914c, b(j).getPath())) {
                return C0787a.b("unzip bundle failed.");
            }
            d.a.i0.a.p0.j.a.b(a(), g(), j);
            j(j);
            k(aVar.f43912a);
            if (f43929b) {
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + j);
            }
            return C0787a.d();
        }
    }

    public void j(long j) {
        h.a().putLong(this.f43837a.b(), j);
    }

    public void k(String str) {
        h.a().putString(this.f43837a.e(), str);
    }
}
