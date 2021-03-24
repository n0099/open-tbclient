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
/* loaded from: classes3.dex */
public class a<T extends d.b.g0.a.l0.h.c.a> extends d.b.g0.a.l0.e.a<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45165b = k.f45050a;

    /* renamed from: d.b.g0.a.l0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0725a {

        /* renamed from: a  reason: collision with root package name */
        public int f45166a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f45167b;

        public static C0725a a(int i, String str) {
            C0725a c0725a = new C0725a();
            c0725a.f45166a = i;
            c0725a.f45167b = str;
            return c0725a;
        }

        public static C0725a b(String str) {
            return a(1, str);
        }

        public static C0725a d() {
            return a(0, "");
        }

        public boolean c() {
            return this.f45166a == 0;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.f45166a + ", message='" + this.f45167b + "'}";
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
        if (f45165b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.f45154b)) {
            if (f45165b) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0725a g2 = g(aVar.f45153a, aVar.f45154b, aVar.f45155c);
        if (f45165b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + g2);
        }
        c(aVar.f45154b);
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
        return h.a().getLong(this.f45084a.a(), 0L);
    }

    public final C0725a g(String str, @NonNull String str2, String str3) {
        if (f45165b) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long e2 = d.b.g0.a.l0.k.a.e(str);
        if (e2 == 0) {
            return C0725a.b("invalid version code : " + str);
        } else if (!e0.a(new File(str2), str3)) {
            return C0725a.b("sign failed.");
        } else {
            if (!d.F(str2, b(e2).getPath())) {
                return C0725a.b("unzip bundle failed.");
            }
            d.b.g0.a.l0.k.a.b(a(), f(), e2);
            h(e2);
            if (f45165b) {
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + e2);
            }
            return C0725a.d();
        }
    }

    public void h(long j) {
        h.a().putLong(this.f45084a.a(), j);
    }
}
