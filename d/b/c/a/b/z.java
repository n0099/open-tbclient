package d.b.c.a.b;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.http.response.ResponseException;
import d.b.c.a.b.a.e;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class z implements i {

    /* renamed from: e  reason: collision with root package name */
    public final y f69366e;

    /* renamed from: f  reason: collision with root package name */
    public final e.l f69367f;

    /* renamed from: g  reason: collision with root package name */
    public t f69368g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f69369h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f69370i;
    public boolean j;

    /* loaded from: classes6.dex */
    public final class a extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final j f69371f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ z f69372g;

        @Override // d.b.c.a.b.a.d
        public void i() {
            IOException e2;
            c h2;
            boolean z = true;
            try {
                try {
                    h2 = this.f69372g.h();
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                }
                try {
                    if (this.f69372g.f69367f.e()) {
                        this.f69371f.b(this.f69372g, new IOException(ResponseException.CANCELED));
                    } else {
                        this.f69371f.a(this.f69372g, h2);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    if (!z) {
                        this.f69372g.f69368g.h(this.f69372g, e2);
                        this.f69371f.b(this.f69372g, e2);
                    } else {
                        d.b.c.a.b.a.i.e j = d.b.c.a.b.a.i.e.j();
                        j.f(4, "Callback failure for " + this.f69372g.f(), e2);
                    }
                }
            } finally {
                this.f69372g.f69366e.v().b(this);
            }
        }

        public String j() {
            return this.f69372g.f69369h.a().v();
        }
    }

    public z(y yVar, a0 a0Var, boolean z) {
        this.f69366e = yVar;
        this.f69369h = a0Var;
        this.f69370i = z;
        this.f69367f = new e.l(yVar, z);
    }

    public static z c(y yVar, a0 a0Var, boolean z) {
        z zVar = new z(yVar, a0Var, z);
        zVar.f69368g = yVar.A().a(zVar);
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
        this.f69368g.b(this);
        try {
            try {
                this.f69366e.v().c(this);
                c h2 = h();
                if (h2 != null) {
                    return h2;
                }
                throw new IOException(ResponseException.CANCELED);
            } catch (IOException e2) {
                this.f69368g.h(this, e2);
                throw e2;
            }
        } finally {
            this.f69366e.v().g(this);
        }
    }

    public boolean d() {
        return this.f69367f.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public z clone() {
        return c(this.f69366e, this.f69369h, this.f69370i);
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append(d() ? "canceled " : "");
        sb.append(this.f69370i ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(g());
        return sb.toString();
    }

    public String g() {
        return this.f69369h.a().C();
    }

    public c h() throws IOException {
        ArrayList arrayList = new ArrayList(this.f69366e.y());
        arrayList.add(this.f69367f);
        arrayList.add(new e.c(this.f69366e.i()));
        arrayList.add(new d.b.c.a.b.a.a.a(this.f69366e.j()));
        arrayList.add(new d.b.c.a.b.a.c.a(this.f69366e));
        if (!this.f69370i) {
            arrayList.addAll(this.f69366e.z());
        }
        arrayList.add(new e.d(this.f69370i));
        return new e.i(arrayList, null, null, null, 0, this.f69369h, this, this.f69368g, this.f69366e.b(), this.f69366e.e(), this.f69366e.f()).a(this.f69369h);
    }

    public final void i() {
        this.f69367f.d(d.b.c.a.b.a.i.e.j().c("response.body().close()"));
    }
}
