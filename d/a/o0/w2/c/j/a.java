package d.a.o0.w2.c.j;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.common.TitanConstant;
import d.a.o0.w2.c.j.b;
import java.io.File;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public b f66468a;

    /* renamed from: d  reason: collision with root package name */
    public Context f66471d;

    /* renamed from: b  reason: collision with root package name */
    public String f66469b = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66470c = false;

    /* renamed from: e  reason: collision with root package name */
    public b.a f66472e = new C1762a();

    /* renamed from: d.a.o0.w2.c.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1762a implements b.a {
        public C1762a() {
        }

        @Override // d.a.o0.w2.c.j.b.a
        public void a() {
            if (a.this.f66470c) {
                a.this.f66470c = false;
            }
        }
    }

    public a(Context context) {
        this.f66471d = context;
    }

    public final String c() {
        if (!TextUtils.isEmpty(this.f66469b)) {
            return this.f66469b;
        }
        String b2 = c.b();
        this.f66469b = b2;
        if (TextUtils.isEmpty(b2)) {
            this.f66469b = c.c();
        } else if (!this.f66469b.endsWith(File.separator)) {
            this.f66469b += File.separator;
        }
        return this.f66469b;
    }

    public boolean d() {
        return this.f66470c;
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
        if (this.f66468a == null) {
            e(str);
            b bVar = new b(str, str2, z);
            this.f66468a = bVar;
            bVar.b(this.f66472e);
            try {
                this.f66468a.start();
                return true;
            } catch (IllegalThreadStateException unused) {
                return true;
            } catch (Exception e2) {
                this.f66468a = null;
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
        if (c.e(c2) && f(c2, TitanConstant.KEY_INSTANT_INIT_CLASS, true)) {
            this.f66470c = true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: d.a.o0.w2.c.j.b */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [d.a.o0.w2.c.j.b, d.a.o0.w2.c.j.b$a] */
    public final void h() {
        b bVar = this.f66468a;
        if (bVar != null) {
            try {
                try {
                    bVar.c();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            } finally {
                this.f66468a.b(null);
                this.f66468a = null;
            }
        }
        this.f66470c = false;
    }

    public void i() {
        h();
    }
}
