package d.a.j0.v2.c.j;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.a.j0.v2.c.j.b;
import java.io.File;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f61797a;

    /* renamed from: d  reason: collision with root package name */
    public Context f61800d;

    /* renamed from: b  reason: collision with root package name */
    public String f61798b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61799c = false;

    /* renamed from: e  reason: collision with root package name */
    public b.a f61801e = new C1623a();

    /* renamed from: d.a.j0.v2.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1623a implements b.a {
        public C1623a() {
        }

        @Override // d.a.j0.v2.c.j.b.a
        public void a() {
            if (a.this.f61799c) {
                a.this.f61799c = false;
            }
        }
    }

    public a(Context context) {
        this.f61800d = context;
    }

    public final String c() {
        if (!TextUtils.isEmpty(this.f61798b)) {
            return this.f61798b;
        }
        String b2 = c.b();
        this.f61798b = b2;
        if (TextUtils.isEmpty(b2)) {
            this.f61798b = c.c();
        } else if (!this.f61798b.endsWith(File.separator)) {
            this.f61798b += File.separator;
        }
        return this.f61798b;
    }

    public boolean d() {
        return this.f61799c;
    }

    public final void e(String str) {
        File file = new File(str);
        if (!file.exists()) {
            if (file.mkdirs()) {
                BdLog.d("folder mkdir success: " + str);
            } else if (!file.exists()) {
                BdLog.d("folder mkdir failed");
            }
        }
        if (file.isDirectory()) {
            return;
        }
        throw new IllegalArgumentException("The logcat folder path is not a directory: " + str);
    }

    public final boolean f(String str, String str2, boolean z) {
        if (this.f61797a == null) {
            e(str);
            b bVar = new b(str, str2, z);
            this.f61797a = bVar;
            bVar.b(this.f61801e);
            try {
                this.f61797a.start();
                return true;
            } catch (IllegalThreadStateException unused) {
                return true;
            } catch (Exception e2) {
                this.f61797a = null;
                BdLog.e(e2);
                return false;
            }
        }
        return true;
    }

    public void g() {
        String c2 = c();
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        h();
        if (c.e(c2) && f(c2, "instant", true)) {
            this.f61799c = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.a.j0.v2.c.j.b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [d.a.j0.v2.c.j.b$a, d.a.j0.v2.c.j.b] */
    public final void h() {
        b bVar = this.f61797a;
        if (bVar != null) {
            try {
                try {
                    bVar.c();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            } finally {
                this.f61797a.b(null);
                this.f61797a = null;
            }
        }
        this.f61799c = false;
    }

    public void i() {
        h();
    }
}
