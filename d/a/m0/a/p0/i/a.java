package d.a.m0.a.p0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.m0.a.k;
import d.a.m0.a.k2.g.h;
import d.a.m0.a.p0.g.c.a;
import d.a.m0.a.v2.j0;
import d.a.m0.t.d;
import java.io.File;
/* loaded from: classes3.dex */
public class a<T extends d.a.m0.a.p0.g.c.a> extends d.a.m0.a.p0.d.a<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f47887b = k.f46983a;

    /* renamed from: d.a.m0.a.p0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0857a {

        /* renamed from: a  reason: collision with root package name */
        public int f47888a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f47889b;

        public static C0857a a(int i2, String str) {
            C0857a c0857a = new C0857a();
            c0857a.f47888a = i2;
            c0857a.f47889b = str;
            return c0857a;
        }

        public static C0857a b(String str) {
            return a(1, str);
        }

        public static C0857a d() {
            return a(0, "");
        }

        public boolean c() {
            return this.f47888a == 0;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.f47888a + ", message='" + this.f47889b + "'}";
        }
    }

    public a(@NonNull T t) {
        super(t);
    }

    @Override // d.a.m0.a.p0.d.a
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

    /* JADX WARN: Incorrect types in method signature: <T:Ld/a/m0/a/p0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception e(@NonNull d.a.m0.a.p0.g.a aVar) {
        if (f47887b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.f47872c)) {
            if (f47887b) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0857a i2 = i(aVar);
        if (f47887b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + i2);
        }
        d(aVar.f47872c);
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
        return h.a().getLong(this.f47795a.b(), 0L);
    }

    public String h() {
        return h.a().getString(this.f47795a.e(), "0");
    }

    public final C0857a i(@NonNull d.a.m0.a.p0.g.a aVar) {
        if (f47887b) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + aVar.f47870a + " ,filePath: " + aVar.f47872c + " ,sign:" + aVar.f47873d);
        }
        long j = aVar.f47871b;
        if (j == 0) {
            return C0857a.b("invalid version code : " + aVar.f47870a);
        } else if (!j0.a(new File(aVar.f47872c), aVar.f47873d)) {
            return C0857a.b("sign failed.");
        } else {
            if (!d.T(aVar.f47872c, b(j).getPath())) {
                return C0857a.b("unzip bundle failed.");
            }
            d.a.m0.a.p0.j.a.b(a(), g(), j);
            j(j);
            k(aVar.f47870a);
            if (f47887b) {
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + j);
            }
            return C0857a.d();
        }
    }

    public void j(long j) {
        h.a().putLong(this.f47795a.b(), j);
    }

    public void k(String str) {
        h.a().putString(this.f47795a.e(), str);
    }
}
