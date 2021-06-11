package d.a.n0.r3.i.d;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f63764a;

    /* renamed from: b  reason: collision with root package name */
    public String f63765b;

    /* renamed from: c  reason: collision with root package name */
    public String f63766c;

    /* renamed from: d  reason: collision with root package name */
    public String f63767d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63768e = false;

    /* renamed from: f  reason: collision with root package name */
    public c f63769f;

    /* renamed from: g  reason: collision with root package name */
    public f f63770g;

    /* renamed from: h  reason: collision with root package name */
    public d f63771h;

    /* renamed from: i  reason: collision with root package name */
    public e f63772i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes5.dex */
    public class a extends f {
        public a(Context context, String str, String str2, e eVar, c cVar) {
            super(context, str, str2, eVar, cVar);
        }

        @Override // d.a.n0.r3.i.d.f
        public void k() {
            b.this.j = true;
            b.this.d();
        }
    }

    /* renamed from: d.a.n0.r3.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1627b extends d {
        public C1627b(Context context, String str, e eVar, c cVar) {
            super(context, str, eVar, cVar);
        }

        @Override // d.a.n0.r3.i.d.d
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
        this.f63764a = context;
        this.f63765b = str;
        this.f63766c = str2;
        this.f63767d = str3;
    }

    public final void d() {
        if (this.j && this.k && !this.l) {
            this.f63772i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        f fVar = this.f63770g;
        if (fVar != null) {
            fVar.interrupt();
            this.f63770g = null;
        }
        d dVar = this.f63771h;
        if (dVar != null) {
            dVar.interrupt();
            this.f63771h = null;
        }
    }

    public boolean f() {
        return this.f63768e;
    }

    public final void g() {
        if (this.f63769f != null) {
            File file = new File(this.f63766c);
            if (file.exists() && file.length() > 0) {
                this.f63769f.b(this.f63766c);
            } else {
                this.f63769f.c(223, "Err empty outputFile");
            }
        }
        this.f63768e = false;
    }

    public void h(c cVar) {
        this.f63769f = cVar;
    }

    public void i() {
        if (this.f63768e) {
            return;
        }
        this.f63768e = true;
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f63766c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f63769f;
            if (cVar != null) {
                cVar.c(222, d.a.n0.u1.a.a(e2));
            }
        }
        try {
            this.f63772i = new e(this.f63766c);
            a aVar = new a(this.f63764a, this.f63765b, this.f63767d, this.f63772i, this.f63769f);
            this.f63770g = aVar;
            aVar.start();
            C1627b c1627b = new C1627b(this.f63764a, this.f63765b, this.f63772i, this.f63769f);
            this.f63771h = c1627b;
            c1627b.start();
        } catch (Exception unused) {
        }
    }
}
