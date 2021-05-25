package d.a.n0.w2.c.j;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.a.n0.w2.c.j.b;
import java.io.File;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f62628a;

    /* renamed from: d  reason: collision with root package name */
    public Context f62631d;

    /* renamed from: b  reason: collision with root package name */
    public String f62629b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62630c = false;

    /* renamed from: e  reason: collision with root package name */
    public b.a f62632e = new C1701a();

    /* renamed from: d.a.n0.w2.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1701a implements b.a {
        public C1701a() {
        }

        @Override // d.a.n0.w2.c.j.b.a
        public void a() {
            if (a.this.f62630c) {
                a.this.f62630c = false;
            }
        }
    }

    public a(Context context) {
        this.f62631d = context;
    }

    public final String c() {
        if (!TextUtils.isEmpty(this.f62629b)) {
            return this.f62629b;
        }
        String b2 = c.b();
        this.f62629b = b2;
        if (TextUtils.isEmpty(b2)) {
            this.f62629b = c.c();
        } else if (!this.f62629b.endsWith(File.separator)) {
            this.f62629b += File.separator;
        }
        return this.f62629b;
    }

    public boolean d() {
        return this.f62630c;
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
        if (this.f62628a == null) {
            e(str);
            b bVar = new b(str, str2, z);
            this.f62628a = bVar;
            bVar.b(this.f62632e);
            try {
                this.f62628a.start();
                return true;
            } catch (IllegalThreadStateException unused) {
                return true;
            } catch (Exception e2) {
                this.f62628a = null;
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
            this.f62630c = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.a.n0.w2.c.j.b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [d.a.n0.w2.c.j.b, d.a.n0.w2.c.j.b$a] */
    public final void h() {
        b bVar = this.f62628a;
        if (bVar != null) {
            try {
                try {
                    bVar.c();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            } finally {
                this.f62628a.b(null);
                this.f62628a = null;
            }
        }
        this.f62630c = false;
    }

    public void i() {
        h();
    }
}
