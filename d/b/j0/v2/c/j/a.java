package d.b.j0.v2.c.j;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.b.j0.v2.c.j.b;
import java.io.File;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f63553a;

    /* renamed from: d  reason: collision with root package name */
    public Context f63556d;

    /* renamed from: b  reason: collision with root package name */
    public String f63554b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63555c = false;

    /* renamed from: e  reason: collision with root package name */
    public b.a f63557e = new C1683a();

    /* renamed from: d.b.j0.v2.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1683a implements b.a {
        public C1683a() {
        }

        @Override // d.b.j0.v2.c.j.b.a
        public void a() {
            if (a.this.f63555c) {
                a.this.f63555c = false;
            }
        }
    }

    public a(Context context) {
        this.f63556d = context;
    }

    public final String c() {
        if (!TextUtils.isEmpty(this.f63554b)) {
            return this.f63554b;
        }
        String b2 = c.b();
        this.f63554b = b2;
        if (TextUtils.isEmpty(b2)) {
            this.f63554b = c.c();
        } else if (!this.f63554b.endsWith(File.separator)) {
            this.f63554b += File.separator;
        }
        return this.f63554b;
    }

    public boolean d() {
        return this.f63555c;
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
        if (this.f63553a == null) {
            e(str);
            b bVar = new b(str, str2, z);
            this.f63553a = bVar;
            bVar.b(this.f63557e);
            try {
                this.f63553a.start();
                return true;
            } catch (IllegalThreadStateException unused) {
                return true;
            } catch (Exception e2) {
                this.f63553a = null;
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
            this.f63555c = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.b.j0.v2.c.j.b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [d.b.j0.v2.c.j.b, d.b.j0.v2.c.j.b$a] */
    public final void h() {
        b bVar = this.f63553a;
        if (bVar != null) {
            try {
                try {
                    bVar.c();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            } finally {
                this.f63553a.b(null);
                this.f63553a = null;
            }
        }
        this.f63555c = false;
    }

    public void i() {
        h();
    }
}
