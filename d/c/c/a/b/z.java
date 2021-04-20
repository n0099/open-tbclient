package d.c.c.a.b;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.http.response.ResponseException;
import d.c.c.a.b.a.e;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class z implements i {

    /* renamed from: e  reason: collision with root package name */
    public final y f66418e;

    /* renamed from: f  reason: collision with root package name */
    public final e.l f66419f;

    /* renamed from: g  reason: collision with root package name */
    public t f66420g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f66421h;
    public final boolean i;
    public boolean j;

    /* loaded from: classes5.dex */
    public final class a extends d.c.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final j f66422f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ z f66423g;

        @Override // d.c.c.a.b.a.d
        public void i() {
            IOException e2;
            c h2;
            boolean z = true;
            try {
                try {
                    h2 = this.f66423g.h();
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                }
                try {
                    if (this.f66423g.f66419f.e()) {
                        this.f66422f.b(this.f66423g, new IOException(ResponseException.CANCELED));
                    } else {
                        this.f66422f.a(this.f66423g, h2);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    if (!z) {
                        this.f66423g.f66420g.h(this.f66423g, e2);
                        this.f66422f.b(this.f66423g, e2);
                    } else {
                        d.c.c.a.b.a.i.e j = d.c.c.a.b.a.i.e.j();
                        j.f(4, "Callback failure for " + this.f66423g.f(), e2);
                    }
                }
            } finally {
                this.f66423g.f66418e.v().b(this);
            }
        }

        public String j() {
            return this.f66423g.f66421h.a().v();
        }
    }

    public z(y yVar, a0 a0Var, boolean z) {
        this.f66418e = yVar;
        this.f66421h = a0Var;
        this.i = z;
        this.f66419f = new e.l(yVar, z);
    }

    public static z c(y yVar, a0 a0Var, boolean z) {
        z zVar = new z(yVar, a0Var, z);
        zVar.f66420g = yVar.A().a(zVar);
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
        this.f66420g.b(this);
        try {
            try {
                this.f66418e.v().c(this);
                c h2 = h();
                if (h2 != null) {
                    return h2;
                }
                throw new IOException(ResponseException.CANCELED);
            } catch (IOException e2) {
                this.f66420g.h(this, e2);
                throw e2;
            }
        } finally {
            this.f66418e.v().g(this);
        }
    }

    public boolean d() {
        return this.f66419f.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public z clone() {
        return c(this.f66418e, this.f66421h, this.i);
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
        return this.f66421h.a().C();
    }

    public c h() throws IOException {
        ArrayList arrayList = new ArrayList(this.f66418e.y());
        arrayList.add(this.f66419f);
        arrayList.add(new e.c(this.f66418e.i()));
        arrayList.add(new d.c.c.a.b.a.a.a(this.f66418e.j()));
        arrayList.add(new d.c.c.a.b.a.c.a(this.f66418e));
        if (!this.i) {
            arrayList.addAll(this.f66418e.z());
        }
        arrayList.add(new e.d(this.i));
        return new e.i(arrayList, null, null, null, 0, this.f66421h, this, this.f66420g, this.f66418e.b(), this.f66418e.e(), this.f66418e.f()).a(this.f66421h);
    }

    public final void i() {
        this.f66419f.d(d.c.c.a.b.a.i.e.j().c("response.body().close()"));
    }
}
