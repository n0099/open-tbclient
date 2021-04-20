package d.b.i0.q3.j.d;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f60637a;

    /* renamed from: b  reason: collision with root package name */
    public String f60638b;

    /* renamed from: c  reason: collision with root package name */
    public String f60639c;

    /* renamed from: d  reason: collision with root package name */
    public String f60640d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60641e = false;

    /* renamed from: f  reason: collision with root package name */
    public c f60642f;

    /* renamed from: g  reason: collision with root package name */
    public f f60643g;

    /* renamed from: h  reason: collision with root package name */
    public d f60644h;
    public e i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes5.dex */
    public class a extends f {
        public a(Context context, String str, String str2, e eVar, c cVar) {
            super(context, str, str2, eVar, cVar);
        }

        @Override // d.b.i0.q3.j.d.f
        public void k() {
            b.this.j = true;
            b.this.d();
        }
    }

    /* renamed from: d.b.i0.q3.j.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1522b extends d {
        public C1522b(Context context, String str, e eVar, c cVar) {
            super(context, str, eVar, cVar);
        }

        @Override // d.b.i0.q3.j.d.d
        public void k() {
            b.this.k = true;
            b.this.d();
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i, String str);

        void b(String str);

        void c(int i, String str);
    }

    public b(Context context, String str, String str2, String str3) {
        this.f60637a = context;
        this.f60638b = str;
        this.f60639c = str2;
        this.f60640d = str3;
    }

    public final void d() {
        if (this.j && this.k && !this.l) {
            this.i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        f fVar = this.f60643g;
        if (fVar != null) {
            fVar.interrupt();
            this.f60643g = null;
        }
        d dVar = this.f60644h;
        if (dVar != null) {
            dVar.interrupt();
            this.f60644h = null;
        }
    }

    public boolean f() {
        return this.f60641e;
    }

    public final void g() {
        if (this.f60642f != null) {
            File file = new File(this.f60639c);
            if (file.exists() && file.length() > 0) {
                this.f60642f.b(this.f60639c);
            } else {
                this.f60642f.c(223, "Err empty outputFile");
            }
        }
        this.f60641e = false;
    }

    public void h(c cVar) {
        this.f60642f = cVar;
    }

    public void i() {
        if (this.f60641e) {
            return;
        }
        this.f60641e = true;
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f60639c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f60642f;
            if (cVar != null) {
                cVar.c(222, d.b.i0.t1.a.a(e2));
            }
        }
        try {
            this.i = new e(this.f60639c);
            a aVar = new a(this.f60637a, this.f60638b, this.f60640d, this.i, this.f60642f);
            this.f60643g = aVar;
            aVar.start();
            C1522b c1522b = new C1522b(this.f60637a, this.f60638b, this.i, this.f60642f);
            this.f60644h = c1522b;
            c1522b.start();
        } catch (Exception unused) {
        }
    }
}
