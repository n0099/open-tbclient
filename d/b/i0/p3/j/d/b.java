package d.b.i0.p3.j.d;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f58969a;

    /* renamed from: b  reason: collision with root package name */
    public String f58970b;

    /* renamed from: c  reason: collision with root package name */
    public String f58971c;

    /* renamed from: d  reason: collision with root package name */
    public String f58972d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58973e = false;

    /* renamed from: f  reason: collision with root package name */
    public c f58974f;

    /* renamed from: g  reason: collision with root package name */
    public f f58975g;

    /* renamed from: h  reason: collision with root package name */
    public d f58976h;
    public e i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes5.dex */
    public class a extends f {
        public a(Context context, String str, String str2, e eVar, c cVar) {
            super(context, str, str2, eVar, cVar);
        }

        @Override // d.b.i0.p3.j.d.f
        public void k() {
            b.this.j = true;
            b.this.d();
        }
    }

    /* renamed from: d.b.i0.p3.j.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1459b extends d {
        public C1459b(Context context, String str, e eVar, c cVar) {
            super(context, str, eVar, cVar);
        }

        @Override // d.b.i0.p3.j.d.d
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
        this.f58969a = context;
        this.f58970b = str;
        this.f58971c = str2;
        this.f58972d = str3;
    }

    public final void d() {
        if (this.j && this.k && !this.l) {
            this.i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        f fVar = this.f58975g;
        if (fVar != null) {
            fVar.interrupt();
            this.f58975g = null;
        }
        d dVar = this.f58976h;
        if (dVar != null) {
            dVar.interrupt();
            this.f58976h = null;
        }
    }

    public boolean f() {
        return this.f58973e;
    }

    public final void g() {
        if (this.f58974f != null) {
            File file = new File(this.f58971c);
            if (file.exists() && file.length() > 0) {
                this.f58974f.b(this.f58971c);
            } else {
                this.f58974f.c(223, "Err empty outputFile");
            }
        }
        this.f58973e = false;
    }

    public void h(c cVar) {
        this.f58974f = cVar;
    }

    public void i() {
        if (this.f58973e) {
            return;
        }
        this.f58973e = true;
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f58971c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f58974f;
            if (cVar != null) {
                cVar.c(222, d.b.i0.s1.a.a(e2));
            }
        }
        try {
            this.i = new e(this.f58971c);
            a aVar = new a(this.f58969a, this.f58970b, this.f58972d, this.i, this.f58974f);
            this.f58975g = aVar;
            aVar.start();
            C1459b c1459b = new C1459b(this.f58969a, this.f58970b, this.i, this.f58974f);
            this.f58976h = c1459b;
            c1459b.start();
        } catch (Exception unused) {
        }
    }
}
