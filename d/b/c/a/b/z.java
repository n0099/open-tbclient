package d.b.c.a.b;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.http.response.ResponseException;
import d.b.c.a.b.a.e;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class z implements i {

    /* renamed from: e  reason: collision with root package name */
    public final y f69470e;

    /* renamed from: f  reason: collision with root package name */
    public final e.l f69471f;

    /* renamed from: g  reason: collision with root package name */
    public t f69472g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f69473h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f69474i;
    public boolean j;

    /* loaded from: classes6.dex */
    public final class a extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final j f69475f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ z f69476g;

        @Override // d.b.c.a.b.a.d
        public void i() {
            IOException e2;
            c h2;
            boolean z = true;
            try {
                try {
                    h2 = this.f69476g.h();
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                }
                try {
                    if (this.f69476g.f69471f.e()) {
                        this.f69475f.b(this.f69476g, new IOException(ResponseException.CANCELED));
                    } else {
                        this.f69475f.a(this.f69476g, h2);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    if (!z) {
                        this.f69476g.f69472g.h(this.f69476g, e2);
                        this.f69475f.b(this.f69476g, e2);
                    } else {
                        d.b.c.a.b.a.i.e j = d.b.c.a.b.a.i.e.j();
                        j.f(4, "Callback failure for " + this.f69476g.f(), e2);
                    }
                }
            } finally {
                this.f69476g.f69470e.v().b(this);
            }
        }

        public String j() {
            return this.f69476g.f69473h.a().v();
        }
    }

    public z(y yVar, a0 a0Var, boolean z) {
        this.f69470e = yVar;
        this.f69473h = a0Var;
        this.f69474i = z;
        this.f69471f = new e.l(yVar, z);
    }

    public static z c(y yVar, a0 a0Var, boolean z) {
        z zVar = new z(yVar, a0Var, z);
        zVar.f69472g = yVar.A().a(zVar);
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
        this.f69472g.b(this);
        try {
            try {
                this.f69470e.v().c(this);
                c h2 = h();
                if (h2 != null) {
                    return h2;
                }
                throw new IOException(ResponseException.CANCELED);
            } catch (IOException e2) {
                this.f69472g.h(this, e2);
                throw e2;
            }
        } finally {
            this.f69470e.v().g(this);
        }
    }

    public boolean d() {
        return this.f69471f.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public z clone() {
        return c(this.f69470e, this.f69473h, this.f69474i);
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append(d() ? "canceled " : "");
        sb.append(this.f69474i ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(g());
        return sb.toString();
    }

    public String g() {
        return this.f69473h.a().C();
    }

    public c h() throws IOException {
        ArrayList arrayList = new ArrayList(this.f69470e.y());
        arrayList.add(this.f69471f);
        arrayList.add(new e.c(this.f69470e.i()));
        arrayList.add(new d.b.c.a.b.a.a.a(this.f69470e.j()));
        arrayList.add(new d.b.c.a.b.a.c.a(this.f69470e));
        if (!this.f69474i) {
            arrayList.addAll(this.f69470e.z());
        }
        arrayList.add(new e.d(this.f69474i));
        return new e.i(arrayList, null, null, null, 0, this.f69473h, this, this.f69472g, this.f69470e.b(), this.f69470e.e(), this.f69470e.f()).a(this.f69473h);
    }

    public final void i() {
        this.f69471f.d(d.b.c.a.b.a.i.e.j().c("response.body().close()"));
    }
}
