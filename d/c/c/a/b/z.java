package d.c.c.a.b;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.http.response.ResponseException;
import d.c.c.a.b.a.e;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class z implements i {

    /* renamed from: e  reason: collision with root package name */
    public final y f65573e;

    /* renamed from: f  reason: collision with root package name */
    public final e.l f65574f;

    /* renamed from: g  reason: collision with root package name */
    public t f65575g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f65576h;
    public final boolean i;
    public boolean j;

    /* loaded from: classes5.dex */
    public final class a extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final j f65577f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ z f65578g;

        @Override // d.c.c.a.b.a.d
        public void i() {
            IOException e2;
            c h2;
            boolean z = true;
            try {
                try {
                    h2 = this.f65578g.h();
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                }
                try {
                    if (this.f65578g.f65574f.e()) {
                        this.f65577f.b(this.f65578g, new IOException(ResponseException.CANCELED));
                    } else {
                        this.f65577f.a(this.f65578g, h2);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    if (!z) {
                        this.f65578g.f65575g.h(this.f65578g, e2);
                        this.f65577f.b(this.f65578g, e2);
                    } else {
                        d.c.c.a.b.a.i.e j = d.c.c.a.b.a.i.e.j();
                        j.f(4, "Callback failure for " + this.f65578g.f(), e2);
                    }
                }
            } finally {
                this.f65578g.f65573e.v().b(this);
            }
        }

        public String j() {
            return this.f65578g.f65576h.a().v();
        }
    }

    public z(y yVar, a0 a0Var, boolean z) {
        this.f65573e = yVar;
        this.f65576h = a0Var;
        this.i = z;
        this.f65574f = new e.l(yVar, z);
    }

    public static z c(y yVar, a0 a0Var, boolean z) {
        z zVar = new z(yVar, a0Var, z);
        zVar.f65575g = yVar.A().a(zVar);
        return zVar;
    }

    @Override // d.c.c.a.b.i
    public c a() throws IOException {
        synchronized (this) {
            if (!this.j) {
                this.j = true;
            } else {
                throw new IllegalStateException("Already Executed");
            }
        }
        i();
        this.f65575g.b(this);
        try {
            try {
                this.f65573e.v().c(this);
                c h2 = h();
                if (h2 != null) {
                    return h2;
                }
                throw new IOException(ResponseException.CANCELED);
            } catch (IOException e2) {
                this.f65575g.h(this, e2);
                throw e2;
            }
        } finally {
            this.f65573e.v().g(this);
        }
    }

    public boolean d() {
        return this.f65574f.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public z clone() {
        return c(this.f65573e, this.f65576h, this.i);
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append(d() ? "canceled " : "");
        sb.append(this.i ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(g());
        return sb.toString();
    }

    public String g() {
        return this.f65576h.a().C();
    }

    public c h() throws IOException {
        ArrayList arrayList = new ArrayList(this.f65573e.y());
        arrayList.add(this.f65574f);
        arrayList.add(new e.c(this.f65573e.i()));
        arrayList.add(new d.c.c.a.b.a.a.a(this.f65573e.j()));
        arrayList.add(new d.c.c.a.b.a.c.a(this.f65573e));
        if (!this.i) {
            arrayList.addAll(this.f65573e.z());
        }
        arrayList.add(new e.d(this.i));
        return new e.i(arrayList, null, null, null, 0, this.f65576h, this, this.f65575g, this.f65573e.b(), this.f65573e.e(), this.f65573e.f()).a(this.f65576h);
    }

    public final void i() {
        this.f65574f.d(d.c.c.a.b.a.i.e.j().c("response.body().close()"));
    }
}
