package d.b.j0.q3.j.d;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f61058a;

    /* renamed from: b  reason: collision with root package name */
    public String f61059b;

    /* renamed from: c  reason: collision with root package name */
    public String f61060c;

    /* renamed from: d  reason: collision with root package name */
    public String f61061d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f61062e = false;

    /* renamed from: f  reason: collision with root package name */
    public c f61063f;

    /* renamed from: g  reason: collision with root package name */
    public f f61064g;

    /* renamed from: h  reason: collision with root package name */
    public d f61065h;
    public e i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes5.dex */
    public class a extends f {
        public a(Context context, String str, String str2, e eVar, c cVar) {
            super(context, str, str2, eVar, cVar);
        }

        @Override // d.b.j0.q3.j.d.f
        public void k() {
            b.this.j = true;
            b.this.d();
        }
    }

    /* renamed from: d.b.j0.q3.j.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1545b extends d {
        public C1545b(Context context, String str, e eVar, c cVar) {
            super(context, str, eVar, cVar);
        }

        @Override // d.b.j0.q3.j.d.d
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
        this.f61058a = context;
        this.f61059b = str;
        this.f61060c = str2;
        this.f61061d = str3;
    }

    public final void d() {
        if (this.j && this.k && !this.l) {
            this.i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        f fVar = this.f61064g;
        if (fVar != null) {
            fVar.interrupt();
            this.f61064g = null;
        }
        d dVar = this.f61065h;
        if (dVar != null) {
            dVar.interrupt();
            this.f61065h = null;
        }
    }

    public boolean f() {
        return this.f61062e;
    }

    public final void g() {
        if (this.f61063f != null) {
            File file = new File(this.f61060c);
            if (file.exists() && file.length() > 0) {
                this.f61063f.b(this.f61060c);
            } else {
                this.f61063f.c(223, "Err empty outputFile");
            }
        }
        this.f61062e = false;
    }

    public void h(c cVar) {
        this.f61063f = cVar;
    }

    public void i() {
        if (this.f61062e) {
            return;
        }
        this.f61062e = true;
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f61060c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f61063f;
            if (cVar != null) {
                cVar.c(222, d.b.j0.t1.a.a(e2));
            }
        }
        try {
            this.i = new e(this.f61060c);
            a aVar = new a(this.f61058a, this.f61059b, this.f61061d, this.i, this.f61063f);
            this.f61064g = aVar;
            aVar.start();
            C1545b c1545b = new C1545b(this.f61058a, this.f61059b, this.i, this.f61063f);
            this.f61065h = c1545b;
            c1545b.start();
        } catch (Exception unused) {
        }
    }
}
