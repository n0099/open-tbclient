package d.a.m0.n.i.k;

import androidx.annotation.Nullable;
import d.a.m0.n.f.g;
import d.a.m0.n.j.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.m0.n.i.d<d.a.m0.n.i.l.e> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public g f51860h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public g f51861i;

    public e(g gVar, d.a.m0.n.i.m.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        this.f51860h = gVar3;
        this.f51861i = gVar4;
    }

    @Override // d.a.m0.n.i.d
    public String f() {
        return "updatecore";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.m0.n.i.l.e eVar) {
        return eVar != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: p */
    public d.a.m0.n.h.a m(d.a.m0.n.i.l.e eVar) {
        this.f51810e.D();
        d.a.m0.n.n.a.e(this.f51811f.a(), eVar.f51877a);
        g gVar = this.f51810e;
        if (gVar == this.f51860h || gVar == this.f51861i) {
            gVar = null;
        }
        f.c(eVar.f51878b, gVar, this.f51860h, this.f51861i);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.n.i.d
    /* renamed from: q */
    public d.a.m0.n.i.l.e n(JSONObject jSONObject) {
        return d.a.m0.n.o.e.n(jSONObject);
    }
}
