package d.a.h0.a.l0.j;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.h0.a.a2.g.h;
import d.a.h0.a.i2.e0;
import d.a.h0.a.k;
import d.a.h0.a.l0.h.c.a;
import d.a.h0.p.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a<T extends d.a.h0.a.l0.h.c.a> extends d.a.h0.a.l0.e.a<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f43221b = k.f43101a;

    /* renamed from: d.a.h0.a.l0.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0697a {

        /* renamed from: a  reason: collision with root package name */
        public int f43222a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f43223b;

        public static C0697a a(int i2, String str) {
            C0697a c0697a = new C0697a();
            c0697a.f43222a = i2;
            c0697a.f43223b = str;
            return c0697a;
        }

        public static C0697a b(String str) {
            return a(1, str);
        }

        public static C0697a d() {
            return a(0, "");
        }

        public boolean c() {
            return this.f43222a == 0;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.f43222a + ", message='" + this.f43223b + "'}";
        }
    }

    public a(@NonNull T t) {
        super(t);
    }

    @Override // d.a.h0.a.l0.e.a
    public File a() {
        return new File(super.a(), "remote");
    }

    public final void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.g(str);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ld/a/h0/a/l0/h/a;>(TT;)Ljava/lang/Exception; */
    public Exception d(@NonNull d.a.h0.a.l0.h.a aVar) {
        if (f43221b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.f43210b)) {
            if (f43221b) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0697a g2 = g(aVar.f43209a, aVar.f43210b, aVar.f43211c);
        if (f43221b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + g2);
        }
        c(aVar.f43210b);
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
        extensionCore.extensionCoreVersionName = d.a.h0.a.l0.k.a.f(f2);
        extensionCore.extensionCorePath = b(f2).getPath();
        extensionCore.extensionCoreType = 1;
        return extensionCore;
    }

    public long f() {
        return h.a().getLong(this.f43135a.d(), 0L);
    }

    public final C0697a g(String str, @NonNull String str2, String str3) {
        if (f43221b) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + str + " ,filePath: " + str2 + " ,sign:" + str3);
        }
        long e2 = d.a.h0.a.l0.k.a.e(str);
        if (e2 == 0) {
            return C0697a.b("invalid version code : " + str);
        } else if (!e0.a(new File(str2), str3)) {
            return C0697a.b("sign failed.");
        } else {
            if (!d.F(str2, b(e2).getPath())) {
                return C0697a.b("unzip bundle failed.");
            }
            d.a.h0.a.l0.k.a.b(a(), f(), e2);
            h(e2);
            if (f43221b) {
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + e2);
            }
            return C0697a.d();
        }
    }

    public void h(long j) {
        h.a().putLong(this.f43135a.d(), j);
    }
}
