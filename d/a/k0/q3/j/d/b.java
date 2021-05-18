package d.a.k0.q3.j.d;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f59934a;

    /* renamed from: b  reason: collision with root package name */
    public String f59935b;

    /* renamed from: c  reason: collision with root package name */
    public String f59936c;

    /* renamed from: d  reason: collision with root package name */
    public String f59937d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59938e = false;

    /* renamed from: f  reason: collision with root package name */
    public c f59939f;

    /* renamed from: g  reason: collision with root package name */
    public f f59940g;

    /* renamed from: h  reason: collision with root package name */
    public d f59941h;

    /* renamed from: i  reason: collision with root package name */
    public e f59942i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes5.dex */
    public class a extends f {
        public a(Context context, String str, String str2, e eVar, c cVar) {
            super(context, str, str2, eVar, cVar);
        }

        @Override // d.a.k0.q3.j.d.f
        public void k() {
            b.this.j = true;
            b.this.d();
        }
    }

    /* renamed from: d.a.k0.q3.j.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1558b extends d {
        public C1558b(Context context, String str, e eVar, c cVar) {
            super(context, str, eVar, cVar);
        }

        @Override // d.a.k0.q3.j.d.d
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
        this.f59934a = context;
        this.f59935b = str;
        this.f59936c = str2;
        this.f59937d = str3;
    }

    public final void d() {
        if (this.j && this.k && !this.l) {
            this.f59942i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        f fVar = this.f59940g;
        if (fVar != null) {
            fVar.interrupt();
            this.f59940g = null;
        }
        d dVar = this.f59941h;
        if (dVar != null) {
            dVar.interrupt();
            this.f59941h = null;
        }
    }

    public boolean f() {
        return this.f59938e;
    }

    public final void g() {
        if (this.f59939f != null) {
            File file = new File(this.f59936c);
            if (file.exists() && file.length() > 0) {
                this.f59939f.b(this.f59936c);
            } else {
                this.f59939f.c(223, "Err empty outputFile");
            }
        }
        this.f59938e = false;
    }

    public void h(c cVar) {
        this.f59939f = cVar;
    }

    public void i() {
        if (this.f59938e) {
            return;
        }
        this.f59938e = true;
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f59936c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f59939f;
            if (cVar != null) {
                cVar.c(222, d.a.k0.t1.a.a(e2));
            }
        }
        try {
            this.f59942i = new e(this.f59936c);
            a aVar = new a(this.f59934a, this.f59935b, this.f59937d, this.f59942i, this.f59939f);
            this.f59940g = aVar;
            aVar.start();
            C1558b c1558b = new C1558b(this.f59934a, this.f59935b, this.f59942i, this.f59939f);
            this.f59941h = c1558b;
            c1558b.start();
        } catch (Exception unused) {
        }
    }
}
