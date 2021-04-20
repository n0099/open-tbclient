package d.b.g0.a.l0.j;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.g0.a.a2.g.h;
import d.b.g0.a.i2.e0;
import d.b.g0.a.k;
import d.b.g0.a.l0.h.c.a;
import d.b.g0.p.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a<T extends d.b.g0.a.l0.h.c.a> extends d.b.g0.a.l0.e.a<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45558b = k.f45443a;

    /* renamed from: d.b.g0.a.l0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0738a {

        /* renamed from: a  reason: collision with root package name */
        public int f45559a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f45560b;

        public static C0738a a(int i, String str) {
            C0738a c0738a = new C0738a();
            c0738a.f45559a = i;
            c0738a.f45560b = str;
            return c0738a;
        }

        public static C0738a b(String str) {
            return a(1, str);
        }

        public static C0738a d() {
            return a(0, "");
        }

        public boolean c() {
            return this.f45559a == 0;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.f45559a + ", message='" + this.f45560b + "'}";
        }
    }

    public a(@NonNull T t) {
        super(t);
    }

    @Override // d.b.g0.a.l0.e.a
    public File a() {
        return new File(super.a(), "remote");
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.g(str);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ld/b/g0/a/l0/h/a;>(TT;)Ljava/lang/Exception; */
    public Exception d(@NonNull d.b.g0.a.l0.h.a aVar) {
        if (f45558b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.f45547b)) {
            if (f45558b) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0738a g2 = g(aVar.f45546a, aVar.f45547b, aVar.f45548c);
        if (f45558b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + g2);
        }
        c(aVar.f45547b);
        if (g2.c()) {
            return null;
        }
        return new Exception("ExtCore-RemoteControl doUpdate: failed by " + g2.toString());
    }

    @NonNull
    public ExtensionCore e() {
        ExtensionCore extensionCore = new ExtensionCore();
        long f2 = f();
        extensionCore.extensionCoreVersionCode = f2;
        extensionCore.extensionCoreVersionName = d.b.g0.a.l0.k.a.f(f2);
        extensionCore.extensionCorePath = b(f2).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    public long f() {
        return h.a().getLong(this.f45477a.a(), 0L);
    }

    public final C0738a g(String str, @NonNull String str2, String str3) {
        if (f45558b) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long e2 = d.b.g0.a.l0.k.a.e(str);
        if (e2 == 0) {
            return C0738a.b("invalid version code : " + str);
        } else if (!e0.a(new File(str2), str3)) {
            return C0738a.b("sign failed.");
        } else {
            if (!d.F(str2, b(e2).getPath())) {
                return C0738a.b("unzip bundle failed.");
            }
            d.b.g0.a.l0.k.a.b(a(), f(), e2);
            h(e2);
            if (f45558b) {
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + e2);
            }
            return C0738a.d();
        }
    }

    public void h(long j) {
        h.a().putLong(this.f45477a.a(), j);
    }
}
