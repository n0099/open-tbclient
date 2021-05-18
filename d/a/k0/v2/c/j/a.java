package d.a.k0.v2.c.j;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.a.k0.v2.c.j.b;
import java.io.File;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f62521a;

    /* renamed from: d  reason: collision with root package name */
    public Context f62524d;

    /* renamed from: b  reason: collision with root package name */
    public String f62522b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62523c = false;

    /* renamed from: e  reason: collision with root package name */
    public b.a f62525e = new C1688a();

    /* renamed from: d.a.k0.v2.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1688a implements b.a {
        public C1688a() {
        }

        @Override // d.a.k0.v2.c.j.b.a
        public void a() {
            if (a.this.f62523c) {
                a.this.f62523c = false;
            }
        }
    }

    public a(Context context) {
        this.f62524d = context;
    }

    public final String c() {
        if (!TextUtils.isEmpty(this.f62522b)) {
            return this.f62522b;
        }
        String b2 = c.b();
        this.f62522b = b2;
        if (TextUtils.isEmpty(b2)) {
            this.f62522b = c.c();
        } else if (!this.f62522b.endsWith(File.separator)) {
            this.f62522b += File.separator;
        }
        return this.f62522b;
    }

    public boolean d() {
        return this.f62523c;
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
        if (this.f62521a == null) {
            e(str);
            b bVar = new b(str, str2, z);
            this.f62521a = bVar;
            bVar.b(this.f62525e);
            try {
                this.f62521a.start();
                return true;
            } catch (IllegalThreadStateException unused) {
                return true;
            } catch (Exception e2) {
                this.f62521a = null;
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
            this.f62523c = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.a.k0.v2.c.j.b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [d.a.k0.v2.c.j.b, d.a.k0.v2.c.j.b$a] */
    public final void h() {
        b bVar = this.f62521a;
        if (bVar != null) {
            try {
                try {
                    bVar.c();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            } finally {
                this.f62521a.b(null);
                this.f62521a = null;
            }
        }
        this.f62523c = false;
    }

    public void i() {
        h();
    }
}
