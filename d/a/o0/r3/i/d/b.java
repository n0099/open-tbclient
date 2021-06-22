package d.a.o0.r3.i.d;

import android.annotation.TargetApi;
import android.content.Context;
import java.io.File;
@TargetApi(18)
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public Context f63889a;

    /* renamed from: b  reason: collision with root package name */
    public String f63890b;

    /* renamed from: c  reason: collision with root package name */
    public String f63891c;

    /* renamed from: d  reason: collision with root package name */
    public String f63892d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f63893e = false;

    /* renamed from: f  reason: collision with root package name */
    public c f63894f;

    /* renamed from: g  reason: collision with root package name */
    public f f63895g;

    /* renamed from: h  reason: collision with root package name */
    public d f63896h;

    /* renamed from: i  reason: collision with root package name */
    public e f63897i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;

    /* loaded from: classes5.dex */
    public class a extends f {
        public a(Context context, String str, String str2, e eVar, c cVar) {
            super(context, str, str2, eVar, cVar);
        }

        @Override // d.a.o0.r3.i.d.f
        public void k() {
            b.this.j = true;
            b.this.d();
        }
    }

    /* renamed from: d.a.o0.r3.i.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1631b extends d {
        public C1631b(Context context, String str, e eVar, c cVar) {
            super(context, str, eVar, cVar);
        }

        @Override // d.a.o0.r3.i.d.d
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
        this.f63889a = context;
        this.f63890b = str;
        this.f63891c = str2;
        this.f63892d = str3;
    }

    public final void d() {
        if (this.j && this.k && !this.l) {
            this.f63897i.f();
            this.l = true;
            g();
        }
    }

    public void e() {
        f fVar = this.f63895g;
        if (fVar != null) {
            fVar.interrupt();
            this.f63895g = null;
        }
        d dVar = this.f63896h;
        if (dVar != null) {
            dVar.interrupt();
            this.f63896h = null;
        }
    }

    public boolean f() {
        return this.f63893e;
    }

    public final void g() {
        if (this.f63894f != null) {
            File file = new File(this.f63891c);
            if (file.exists() && file.length() > 0) {
                this.f63894f.b(this.f63891c);
            } else {
                this.f63894f.c(223, "Err empty outputFile");
            }
        }
        this.f63893e = false;
    }

    public void h(c cVar) {
        this.f63894f = cVar;
    }

    public void i() {
        if (this.f63893e) {
            return;
        }
        this.f63893e = true;
        this.j = false;
        this.k = false;
        this.l = false;
        try {
            File file = new File(new File(this.f63891c).getParent());
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c cVar = this.f63894f;
            if (cVar != null) {
                cVar.c(222, d.a.o0.u1.a.a(e2));
            }
        }
        try {
            this.f63897i = new e(this.f63891c);
            a aVar = new a(this.f63889a, this.f63890b, this.f63892d, this.f63897i, this.f63894f);
            this.f63895g = aVar;
            aVar.start();
            C1631b c1631b = new C1631b(this.f63889a, this.f63890b, this.f63897i, this.f63894f);
            this.f63896h = c1631b;
            c1631b.start();
        } catch (Exception unused) {
        }
    }
}
