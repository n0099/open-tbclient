package d.b.c.a.b;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.http.response.ResponseException;
import d.b.c.a.b.a.e;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class z implements i {

    /* renamed from: e  reason: collision with root package name */
    public final y f64906e;

    /* renamed from: f  reason: collision with root package name */
    public final e.l f64907f;

    /* renamed from: g  reason: collision with root package name */
    public t f64908g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f64909h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f64910i;
    public boolean j;

    /* loaded from: classes5.dex */
    public final class a extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final j f64911f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ z f64912g;

        @Override // d.b.c.a.b.a.d
        public void i() {
            IOException e2;
            c h2;
            boolean z = true;
            try {
                try {
                    h2 = this.f64912g.h();
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                }
                try {
                    if (this.f64912g.f64907f.e()) {
                        this.f64911f.b(this.f64912g, new IOException(ResponseException.CANCELED));
                    } else {
                        this.f64911f.a(this.f64912g, h2);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    if (!z) {
                        this.f64912g.f64908g.h(this.f64912g, e2);
                        this.f64911f.b(this.f64912g, e2);
                    } else {
                        d.b.c.a.b.a.i.e j = d.b.c.a.b.a.i.e.j();
                        j.f(4, "Callback failure for " + this.f64912g.f(), e2);
                    }
                }
            } finally {
                this.f64912g.f64906e.v().b(this);
            }
        }

        public String j() {
            return this.f64912g.f64909h.a().v();
        }
    }

    public z(y yVar, a0 a0Var, boolean z) {
        this.f64906e = yVar;
        this.f64909h = a0Var;
        this.f64910i = z;
        this.f64907f = new e.l(yVar, z);
    }

    public static z c(y yVar, a0 a0Var, boolean z) {
        z zVar = new z(yVar, a0Var, z);
        zVar.f64908g = yVar.A().a(zVar);
        return zVar;
    }

    @Override // d.b.c.a.b.i
    public c a() throws IOException {
        synchronized (this) {
            if (!this.j) {
                this.j = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        i();
        this.f64908g.b(this);
        try {
            try {
                this.f64906e.v().c(this);
                c h2 = h();
                if (h2 != null) {
                    return h2;
                }
                throw new IOException(ResponseException.CANCELED);
            } catch (IOException e2) {
                this.f64908g.h(this, e2);
                throw e2;
            }
        } finally {
            this.f64906e.v().g(this);
        }
    }

    public boolean d() {
        return this.f64907f.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public z clone() {
        return c(this.f64906e, this.f64909h, this.f64910i);
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append(d() ? "canceled " : "");
        sb.append(this.f64910i ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(g());
        return sb.toString();
    }

    public String g() {
        return this.f64909h.a().C();
    }

    public c h() throws IOException {
        ArrayList arrayList = new ArrayList(this.f64906e.y());
        arrayList.add(this.f64907f);
        arrayList.add(new e.c(this.f64906e.i()));
        arrayList.add(new d.b.c.a.b.a.a.a(this.f64906e.j()));
        arrayList.add(new d.b.c.a.b.a.c.a(this.f64906e));
        if (!this.f64910i) {
            arrayList.addAll(this.f64906e.z());
        }
        arrayList.add(new e.d(this.f64910i));
        return new e.i(arrayList, null, null, null, 0, this.f64909h, this, this.f64908g, this.f64906e.b(), this.f64906e.e(), this.f64906e.f()).a(this.f64909h);
    }

    public final void i() {
        this.f64907f.d(d.b.c.a.b.a.i.e.j().c("response.body().close()"));
    }
}
