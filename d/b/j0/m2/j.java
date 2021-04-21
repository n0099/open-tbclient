package d.b.j0.m2;

import com.baidu.adp.lib.util.StringUtils;
import java.util.HashMap;
import java.util.UUID;
/* loaded from: classes3.dex */
public class j implements d.b.j0.t1.g {

    /* renamed from: a  reason: collision with root package name */
    public String f58815a;

    /* renamed from: b  reason: collision with root package name */
    public String f58816b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, d.b.j0.t1.e> f58817c;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d.b.j0.t1.g f58818a = new j();
    }

    public static d.b.j0.t1.g m() {
        return b.f58818a;
    }

    @Override // d.b.j0.t1.g
    public void a(int i, String str) {
        n().e(this.f58815a, i, str);
    }

    @Override // d.b.j0.t1.g
    public void b(String str) {
        if (StringUtils.isNull(this.f58816b)) {
            return;
        }
        if (!o(this.f58816b) && !p(this.f58816b)) {
            d.b.j0.t1.d.b(this.f58816b);
            this.f58817c.remove(this.f58815a);
        } else {
            q(this.f58816b);
        }
        e();
        n().d(this.f58816b, str);
        this.f58816b = null;
    }

    @Override // d.b.j0.t1.g
    public void c(int i, String str) {
        n().l(this.f58815a, i, str);
    }

    @Override // d.b.j0.t1.g
    public void d(int i, int i2, String str) {
        n().b(this.f58815a, i, i2, str);
    }

    @Override // d.b.j0.t1.g
    public void e() {
        this.f58815a = UUID.randomUUID().toString();
    }

    @Override // d.b.j0.t1.g
    public void f(int i, String str) {
        n().c(this.f58815a, i, str);
    }

    @Override // d.b.j0.t1.g
    public void g() {
        n().i(this.f58815a);
        q(this.f58815a);
    }

    @Override // d.b.j0.t1.g
    public void h() {
        this.f58816b = this.f58815a;
    }

    @Override // d.b.j0.t1.g
    public void i(int i, String str) {
        n().k(this.f58815a, i, str);
    }

    @Override // d.b.j0.t1.g
    public void j() {
        n().h(this.f58815a);
    }

    @Override // d.b.j0.t1.g
    public void k(String str) {
        n().f(this.f58815a, str);
        if (!o(this.f58815a) && !p(this.f58815a)) {
            d.b.j0.t1.d.b(this.f58815a);
            this.f58817c.remove(this.f58815a);
        } else {
            q(this.f58815a);
        }
        this.f58815a = null;
    }

    public final d.b.j0.t1.e l() {
        i iVar = new i(this.f58815a);
        this.f58817c.put(this.f58815a, iVar);
        return iVar;
    }

    public final d.b.j0.t1.e n() {
        d.b.j0.t1.e eVar = this.f58817c.get(this.f58815a);
        return eVar == null ? l() : eVar;
    }

    public boolean o(String str) {
        return n().g(str);
    }

    public boolean p(String str) {
        return n().j(str);
    }

    public void q(String str) {
        d.b.j0.t1.e eVar = this.f58817c.get(str);
        if (eVar == null) {
            return;
        }
        eVar.a(str);
        this.f58817c.remove(str);
    }

    public j() {
        this.f58817c = new HashMap<>();
    }
}
