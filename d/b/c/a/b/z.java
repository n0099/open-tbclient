package d.b.c.a.b;

import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.http.response.ResponseException;
import d.b.c.a.b.a.e;
import java.io.IOException;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public final class z implements i {

    /* renamed from: e  reason: collision with root package name */
    public final y f65635e;

    /* renamed from: f  reason: collision with root package name */
    public final e.l f65636f;

    /* renamed from: g  reason: collision with root package name */
    public t f65637g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f65638h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f65639i;
    public boolean j;

    /* loaded from: classes6.dex */
    public final class a extends d.b.c.a.b.a.d {

        /* renamed from: f  reason: collision with root package name */
        public final j f65640f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ z f65641g;

        @Override // d.b.c.a.b.a.d
        public void i() {
            IOException e2;
            c h2;
            boolean z = true;
            try {
                try {
                    h2 = this.f65641g.h();
                } catch (IOException e3) {
                    e2 = e3;
                    z = false;
                }
                try {
                    if (this.f65641g.f65636f.e()) {
                        this.f65640f.b(this.f65641g, new IOException(ResponseException.CANCELED));
                    } else {
                        this.f65640f.a(this.f65641g, h2);
                    }
                } catch (IOException e4) {
                    e2 = e4;
                    if (!z) {
                        this.f65641g.f65637g.h(this.f65641g, e2);
                        this.f65640f.b(this.f65641g, e2);
                    } else {
                        d.b.c.a.b.a.i.e j = d.b.c.a.b.a.i.e.j();
                        j.f(4, "Callback failure for " + this.f65641g.f(), e2);
                    }
                }
            } finally {
                this.f65641g.f65635e.v().b(this);
            }
        }

        public String j() {
            return this.f65641g.f65638h.a().v();
        }
    }

    public z(y yVar, a0 a0Var, boolean z) {
        this.f65635e = yVar;
        this.f65638h = a0Var;
        this.f65639i = z;
        this.f65636f = new e.l(yVar, z);
    }

    public static z c(y yVar, a0 a0Var, boolean z) {
        z zVar = new z(yVar, a0Var, z);
        zVar.f65637g = yVar.A().a(zVar);
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
        this.f65637g.b(this);
        try {
            try {
                this.f65635e.v().c(this);
                c h2 = h();
                if (h2 != null) {
                    return h2;
                }
                throw new IOException(ResponseException.CANCELED);
            } catch (IOException e2) {
                this.f65637g.h(this, e2);
                throw e2;
            }
        } finally {
            this.f65635e.v().g(this);
        }
    }

    public boolean d() {
        return this.f65636f.e();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: e */
    public z clone() {
        return c(this.f65635e, this.f65638h, this.f65639i);
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append(d() ? "canceled " : "");
        sb.append(this.f65639i ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(g());
        return sb.toString();
    }

    public String g() {
        return this.f65638h.a().C();
    }

    public c h() throws IOException {
        ArrayList arrayList = new ArrayList(this.f65635e.y());
        arrayList.add(this.f65636f);
        arrayList.add(new e.c(this.f65635e.i()));
        arrayList.add(new d.b.c.a.b.a.a.a(this.f65635e.j()));
        arrayList.add(new d.b.c.a.b.a.c.a(this.f65635e));
        if (!this.f65639i) {
            arrayList.addAll(this.f65635e.z());
        }
        arrayList.add(new e.d(this.f65639i));
        return new e.i(arrayList, null, null, null, 0, this.f65638h, this, this.f65637g, this.f65635e.b(), this.f65635e.e(), this.f65635e.f()).a(this.f65638h);
    }

    public final void i() {
        this.f65636f.d(d.b.c.a.b.a.i.e.j().c("response.body().close()"));
    }
}
