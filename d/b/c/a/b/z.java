package d.b.c.a.b;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.http.response.ResponseException;
import d.b.c.a.b.a.e;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class z implements i {

    /* renamed from: e  reason: collision with root package name */
    public final y f65592e;

    /* renamed from: f  reason: collision with root package name */
    public final e.l f65593f;

    /* renamed from: g  reason: collision with root package name */
    public t f65594g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f65595h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f65596i;
    public boolean j;

    /* loaded from: classes6.dex */
    public final class a extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final j f65597f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ z f65598g;

        @Override // d.b.c.a.b.a.d
        public void i() {
            IOException e2;
            c h2;
            boolean z = true;
            try {
                try {
                    h2 = this.f65598g.h();
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                }
                try {
                    if (this.f65598g.f65593f.e()) {
                        this.f65597f.b(this.f65598g, new IOException(ResponseException.CANCELED));
                    } else {
                        this.f65597f.a(this.f65598g, h2);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    if (!z) {
                        this.f65598g.f65594g.h(this.f65598g, e2);
                        this.f65597f.b(this.f65598g, e2);
                    } else {
                        d.b.c.a.b.a.i.e j = d.b.c.a.b.a.i.e.j();
                        j.f(4, "Callback failure for " + this.f65598g.f(), e2);
                    }
                }
            } finally {
                this.f65598g.f65592e.v().b(this);
            }
        }

        public String j() {
            return this.f65598g.f65595h.a().v();
        }
    }

    public z(y yVar, a0 a0Var, boolean z) {
        this.f65592e = yVar;
        this.f65595h = a0Var;
        this.f65596i = z;
        this.f65593f = new e.l(yVar, z);
    }

    public static z c(y yVar, a0 a0Var, boolean z) {
        z zVar = new z(yVar, a0Var, z);
        zVar.f65594g = yVar.A().a(zVar);
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
        this.f65594g.b(this);
        try {
            try {
                this.f65592e.v().c(this);
                c h2 = h();
                if (h2 != null) {
                    return h2;
                }
                throw new IOException(ResponseException.CANCELED);
            } catch (IOException e2) {
                this.f65594g.h(this, e2);
                throw e2;
            }
        } finally {
            this.f65592e.v().g(this);
        }
    }

    public boolean d() {
        return this.f65593f.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public z clone() {
        return c(this.f65592e, this.f65595h, this.f65596i);
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append(d() ? "canceled " : "");
        sb.append(this.f65596i ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(g());
        return sb.toString();
    }

    public String g() {
        return this.f65595h.a().C();
    }

    public c h() throws IOException {
        ArrayList arrayList = new ArrayList(this.f65592e.y());
        arrayList.add(this.f65593f);
        arrayList.add(new e.c(this.f65592e.i()));
        arrayList.add(new d.b.c.a.b.a.a.a(this.f65592e.j()));
        arrayList.add(new d.b.c.a.b.a.c.a(this.f65592e));
        if (!this.f65596i) {
            arrayList.addAll(this.f65592e.z());
        }
        arrayList.add(new e.d(this.f65596i));
        return new e.i(arrayList, null, null, null, 0, this.f65595h, this, this.f65594g, this.f65592e.b(), this.f65592e.e(), this.f65592e.f()).a(this.f65595h);
    }

    public final void i() {
        this.f65593f.d(d.b.c.a.b.a.i.e.j().c("response.body().close()"));
    }
}
