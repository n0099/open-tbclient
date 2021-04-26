package d.a.j0.q3.j.d;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f59189a;

    /* renamed from: b  reason: collision with root package name */
    public String f59190b;

    /* renamed from: c  reason: collision with root package name */
    public String f59191c;

    /* renamed from: d  reason: collision with root package name */
    public String f59192d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59193e = false;

    /* renamed from: f  reason: collision with root package name */
    public c f59194f;

    /* renamed from: g  reason: collision with root package name */
    public f f59195g;

    /* renamed from: h  reason: collision with root package name */
    public d f59196h;

    /* renamed from: i  reason: collision with root package name */
    public e f59197i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes5.dex */
    public class a extends f {
        public a(Context context, String str, String str2, e eVar, c cVar) {
            super(context, str, str2, eVar, cVar);
        }

        @Override // d.a.j0.q3.j.d.f
        public void k() {
            b.this.j = true;
            b.this.d();
        }
    }

    /* renamed from: d.a.j0.q3.j.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1484b extends d {
        public C1484b(Context context, String str, e eVar, c cVar) {
            super(context, str, eVar, cVar);
        }

        @Override // d.a.j0.q3.j.d.d
        public void k() {
            b.this.k = true;
            b.this.d();
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i2, String str);

        void b(String str);

        void c(int i2, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.f59189a = context;
        this.f59190b = str;
        this.f59191c = str2;
        this.f59192d = str3;
    }

    public final void d() {
        if (this.j && this.k && !this.l) {
            this.f59197i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        f fVar = this.f59195g;
        if (fVar != null) {
            fVar.interrupt();
            this.f59195g = null;
        }
        d dVar = this.f59196h;
        if (dVar != null) {
            dVar.interrupt();
            this.f59196h = null;
        }
    }

    public boolean f() {
        return this.f59193e;
    }

    public final void g() {
        if (this.f59194f != null) {
            File file = new File(this.f59191c);
            if (file.exists() && file.length() > 0) {
                this.f59194f.b(this.f59191c);
            } else {
                this.f59194f.c(223, "Err empty outputFile");
            }
        }
        this.f59193e = false;
    }

    public void h(c cVar) {
        this.f59194f = cVar;
    }

    public void i() {
        if (this.f59193e) {
            return;
        }
        this.f59193e = true;
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f59191c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f59194f;
            if (cVar != null) {
                cVar.c(222, d.a.j0.t1.a.a(e2));
            }
        }
        try {
            this.f59197i = new e(this.f59191c);
            a aVar = new a(this.f59189a, this.f59190b, this.f59192d, this.f59197i, this.f59194f);
            this.f59195g = aVar;
            aVar.start();
            C1484b c1484b = new C1484b(this.f59189a, this.f59190b, this.f59197i, this.f59194f);
            this.f59196h = c1484b;
            c1484b.start();
        } catch (Exception unused) {
        }
    }
}
