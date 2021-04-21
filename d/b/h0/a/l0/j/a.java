package d.b.h0.a.l0.j;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.b.h0.a.a2.g.h;
import d.b.h0.a.i2.e0;
import d.b.h0.a.k;
import d.b.h0.a.l0.h.c.a;
import d.b.h0.p.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a<T extends d.b.h0.a.l0.h.c.a> extends d.b.h0.a.l0.e.a<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f45887b = k.f45772a;

    /* renamed from: d.b.h0.a.l0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0758a {

        /* renamed from: a  reason: collision with root package name */
        public int f45888a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f45889b;

        public static C0758a a(int i, String str) {
            C0758a c0758a = new C0758a();
            c0758a.f45888a = i;
            c0758a.f45889b = str;
            return c0758a;
        }

        public static C0758a b(String str) {
            return a(1, str);
        }

        public static C0758a d() {
            return a(0, "");
        }

        public boolean c() {
            return this.f45888a == 0;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.f45888a + ", message='" + this.f45889b + "'}";
        }
    }

    public a(@NonNull T t) {
        super(t);
    }

    @Override // d.b.h0.a.l0.e.a
    public File a() {
        return new File(super.a(), "remote");
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.g(str);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ld/b/h0/a/l0/h/a;>(TT;)Ljava/lang/Exception; */
    public Exception d(@NonNull d.b.h0.a.l0.h.a aVar) {
        if (f45887b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.f45876b)) {
            if (f45887b) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0758a g2 = g(aVar.f45875a, aVar.f45876b, aVar.f45877c);
        if (f45887b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + g2);
        }
        c(aVar.f45876b);
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
        extensionCore.extensionCoreVersionName = d.b.h0.a.l0.k.a.f(f2);
        extensionCore.extensionCorePath = b(f2).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    public long f() {
        return h.a().getLong(this.f45806a.a(), 0L);
    }

    public final C0758a g(String str, @NonNull String str2, String str3) {
        if (f45887b) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long e2 = d.b.h0.a.l0.k.a.e(str);
        if (e2 == 0) {
            return C0758a.b("invalid version code : " + str);
        } else if (!e0.a(new File(str2), str3)) {
            return C0758a.b("sign failed.");
        } else {
            if (!d.F(str2, b(e2).getPath())) {
                return C0758a.b("unzip bundle failed.");
            }
            d.b.h0.a.l0.k.a.b(a(), f(), e2);
            h(e2);
            if (f45887b) {
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + e2);
            }
            return C0758a.d();
        }
    }

    public void h(long j) {
        h.a().putLong(this.f45806a.a(), j);
    }
}
