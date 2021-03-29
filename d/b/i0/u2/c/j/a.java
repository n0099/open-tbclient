package d.b.i0.u2.c.j;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.b.i0.u2.c.j.b;
import java.io.File;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f61394a;

    /* renamed from: d  reason: collision with root package name */
    public Context f61397d;

    /* renamed from: b  reason: collision with root package name */
    public String f61395b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61396c = false;

    /* renamed from: e  reason: collision with root package name */
    public b.a f61398e = new C1600a();

    /* renamed from: d.b.i0.u2.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1600a implements b.a {
        public C1600a() {
        }

        @Override // d.b.i0.u2.c.j.b.a
        public void a() {
            if (a.this.f61396c) {
                a.this.f61396c = false;
            }
        }
    }

    public a(Context context) {
        this.f61397d = context;
    }

    public final String c() {
        if (!TextUtils.isEmpty(this.f61395b)) {
            return this.f61395b;
        }
        String b2 = c.b();
        this.f61395b = b2;
        if (TextUtils.isEmpty(b2)) {
            this.f61395b = c.c();
        } else if (!this.f61395b.endsWith(File.separator)) {
            this.f61395b += File.separator;
        }
        return this.f61395b;
    }

    public boolean d() {
        return this.f61396c;
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
        if (this.f61394a == null) {
            e(str);
            b bVar = new b(str, str2, z);
            this.f61394a = bVar;
            bVar.b(this.f61398e);
            try {
                this.f61394a.start();
                return true;
            } catch (IllegalThreadStateException unused) {
                return true;
            } catch (Exception e2) {
                this.f61394a = null;
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
            this.f61396c = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.b.i0.u2.c.j.b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [d.b.i0.u2.c.j.b$a, d.b.i0.u2.c.j.b] */
    public final void h() {
        b bVar = this.f61394a;
        if (bVar != null) {
            try {
                try {
                    bVar.c();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            } finally {
                this.f61394a.b(null);
                this.f61394a = null;
            }
        }
        this.f61396c = false;
    }

    public void i() {
        h();
    }
}
