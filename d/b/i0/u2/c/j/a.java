package d.b.i0.u2.c.j;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.b.i0.u2.c.j.b;
import java.io.File;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f61393a;

    /* renamed from: d  reason: collision with root package name */
    public Context f61396d;

    /* renamed from: b  reason: collision with root package name */
    public String f61394b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61395c = false;

    /* renamed from: e  reason: collision with root package name */
    public b.a f61397e = new C1599a();

    /* renamed from: d.b.i0.u2.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1599a implements b.a {
        public C1599a() {
        }

        @Override // d.b.i0.u2.c.j.b.a
        public void a() {
            if (a.this.f61395c) {
                a.this.f61395c = false;
            }
        }
    }

    public a(Context context) {
        this.f61396d = context;
    }

    public final String c() {
        if (!TextUtils.isEmpty(this.f61394b)) {
            return this.f61394b;
        }
        String b2 = c.b();
        this.f61394b = b2;
        if (TextUtils.isEmpty(b2)) {
            this.f61394b = c.c();
        } else if (!this.f61394b.endsWith(File.separator)) {
            this.f61394b += File.separator;
        }
        return this.f61394b;
    }

    public boolean d() {
        return this.f61395c;
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
        if (this.f61393a == null) {
            e(str);
            b bVar = new b(str, str2, z);
            this.f61393a = bVar;
            bVar.b(this.f61397e);
            try {
                this.f61393a.start();
                return true;
            } catch (IllegalThreadStateException unused) {
                return true;
            } catch (Exception e2) {
                this.f61393a = null;
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
            this.f61395c = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.b.i0.u2.c.j.b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [d.b.i0.u2.c.j.b$a, d.b.i0.u2.c.j.b] */
    public final void h() {
        b bVar = this.f61393a;
        if (bVar != null) {
            try {
                try {
                    bVar.c();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            } finally {
                this.f61393a.b(null);
                this.f61393a = null;
            }
        }
        this.f61395c = false;
    }

    public void i() {
        h();
    }
}
