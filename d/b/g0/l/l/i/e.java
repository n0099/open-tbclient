package d.b.g0.l.l.i;

import androidx.annotation.Nullable;
import d.b.g0.l.h.g;
import d.b.g0.l.m.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.b.g0.l.l.d<d.b.g0.l.l.j.e> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public g f49367h;
    @Nullable
    public g i;

    public e(g gVar, d.b.g0.l.l.k.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        this.f49367h = gVar3;
        this.i = gVar4;
    }

    @Override // d.b.g0.l.l.d
    public String e() {
        return "updatecore";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: n */
    public boolean d(d.b.g0.l.l.j.e eVar) {
        return eVar != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: o */
    public d.b.g0.l.k.a l(d.b.g0.l.l.j.e eVar) {
        this.f49324e.D();
        d.b.g0.l.q.a.e(this.f49325f.a(), eVar.f49383a);
        g gVar = this.f49324e;
        if (gVar == this.f49367h || gVar == this.i) {
            gVar = null;
        }
        f.c(eVar.f49384b, gVar, this.f49367h, this.i);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.l.d
    /* renamed from: p */
    public d.b.g0.l.l.j.e m(JSONObject jSONObject) {
        return d.b.g0.l.r.e.n(jSONObject);
    }
}
