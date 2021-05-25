package d.a.n0.r3.j.d;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f60075a;

    /* renamed from: b  reason: collision with root package name */
    public String f60076b;

    /* renamed from: c  reason: collision with root package name */
    public String f60077c;

    /* renamed from: d  reason: collision with root package name */
    public String f60078d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60079e = false;

    /* renamed from: f  reason: collision with root package name */
    public c f60080f;

    /* renamed from: g  reason: collision with root package name */
    public f f60081g;

    /* renamed from: h  reason: collision with root package name */
    public d f60082h;

    /* renamed from: i  reason: collision with root package name */
    public e f60083i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes5.dex */
    public class a extends f {
        public a(Context context, String str, String str2, e eVar, c cVar) {
            super(context, str, str2, eVar, cVar);
        }

        @Override // d.a.n0.r3.j.d.f
        public void k() {
            b.this.j = true;
            b.this.d();
        }
    }

    /* renamed from: d.a.n0.r3.j.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1571b extends d {
        public C1571b(Context context, String str, e eVar, c cVar) {
            super(context, str, eVar, cVar);
        }

        @Override // d.a.n0.r3.j.d.d
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
        this.f60075a = context;
        this.f60076b = str;
        this.f60077c = str2;
        this.f60078d = str3;
    }

    public final void d() {
        if (this.j && this.k && !this.l) {
            this.f60083i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        f fVar = this.f60081g;
        if (fVar != null) {
            fVar.interrupt();
            this.f60081g = null;
        }
        d dVar = this.f60082h;
        if (dVar != null) {
            dVar.interrupt();
            this.f60082h = null;
        }
    }

    public boolean f() {
        return this.f60079e;
    }

    public final void g() {
        if (this.f60080f != null) {
            File file = new File(this.f60077c);
            if (file.exists() && file.length() > 0) {
                this.f60080f.b(this.f60077c);
            } else {
                this.f60080f.c(223, "Err empty outputFile");
            }
        }
        this.f60079e = false;
    }

    public void h(c cVar) {
        this.f60080f = cVar;
    }

    public void i() {
        if (this.f60079e) {
            return;
        }
        this.f60079e = true;
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f60077c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f60080f;
            if (cVar != null) {
                cVar.c(222, d.a.n0.u1.a.a(e2));
            }
        }
        try {
            this.f60083i = new e(this.f60077c);
            a aVar = new a(this.f60075a, this.f60076b, this.f60078d, this.f60083i, this.f60080f);
            this.f60081g = aVar;
            aVar.start();
            C1571b c1571b = new C1571b(this.f60075a, this.f60076b, this.f60083i, this.f60080f);
            this.f60082h = c1571b;
            c1571b.start();
        } catch (Exception unused) {
        }
    }
}
