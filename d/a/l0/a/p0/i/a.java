package d.a.l0.a.p0.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import d.a.l0.a.k;
import d.a.l0.a.k2.g.h;
import d.a.l0.a.p0.g.c.a;
import d.a.l0.a.v2.j0;
import d.a.l0.t.d;
import java.io.File;
/* loaded from: classes2.dex */
public class a<T extends d.a.l0.a.p0.g.c.a> extends d.a.l0.a.p0.d.a<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f44105b = k.f43199a;

    /* renamed from: d.a.l0.a.p0.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0798a {

        /* renamed from: a  reason: collision with root package name */
        public int f44106a = 0;

        /* renamed from: b  reason: collision with root package name */
        public String f44107b;

        public static C0798a a(int i2, String str) {
            C0798a c0798a = new C0798a();
            c0798a.f44106a = i2;
            c0798a.f44107b = str;
            return c0798a;
        }

        public static C0798a b(String str) {
            return a(1, str);
        }

        public static C0798a d() {
            return a(0, "");
        }

        public boolean c() {
            return this.f44106a == 0;
        }

        public String toString() {
            return "RemoteExtensionCoreUpdateStatus{statusCode=" + this.f44106a + ", message='" + this.f44107b + "'}";
        }
    }

    public a(@NonNull T t) {
        super(t);
    }

    @Override // d.a.l0.a.p0.d.a
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

    /* JADX WARN: Incorrect types in method signature: <T:Ld/a/l0/a/p0/g/a;>(TT;)Ljava/lang/Exception; */
    public Exception e(@NonNull d.a.l0.a.p0.g.a aVar) {
        if (f44105b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote");
        }
        if (TextUtils.isEmpty(aVar.f44090c)) {
            if (f44105b) {
                Log.e("ExtCore-RemoteControl", "doUpdate: remote with null coreFilePath");
            }
            return new Exception("ExtCore-RemoteControl doUpdate: failed by updateInfo.coreFilePath empty");
        }
        C0798a i2 = i(aVar);
        if (f44105b) {
            Log.d("ExtCore-RemoteControl", "doUpdate: remote status: " + i2);
        }
        d(aVar.f44090c);
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
        return h.a().getLong(this.f44013a.b(), 0L);
    }

    public String h() {
        return h.a().getString(this.f44013a.e(), "0");
    }

    public final C0798a i(@NonNull d.a.l0.a.p0.g.a aVar) {
        if (f44105b) {
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate start.");
            Log.d("ExtCore-RemoteControl", "doRemoteUpdate version: " + aVar.f44088a + " ,filePath: " + aVar.f44090c + " ,sign:" + aVar.f44091d);
        }
        long j = aVar.f44089b;
        if (j == 0) {
            return C0798a.b("invalid version code : " + aVar.f44088a);
        } else if (!j0.a(new File(aVar.f44090c), aVar.f44091d)) {
            return C0798a.b("sign failed.");
        } else {
            if (!d.T(aVar.f44090c, b(j).getPath())) {
                return C0798a.b("unzip bundle failed.");
            }
            d.a.l0.a.p0.j.a.b(a(), g(), j);
            j(j);
            k(aVar.f44088a);
            if (f44105b) {
                Log.d("ExtCore-RemoteControl", "doRemoteUpdate end. version = " + j);
            }
            return C0798a.d();
        }
    }

    public void j(long j) {
        h.a().putLong(this.f44013a.b(), j);
    }

    public void k(String str) {
        h.a().putString(this.f44013a.e(), str);
    }
}
