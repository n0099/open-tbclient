package d.a.l0.n.i.k;

import androidx.annotation.Nullable;
import d.a.l0.n.f.g;
import d.a.l0.n.j.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.l0.n.i.d<d.a.l0.n.i.l.e> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public g f51752h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public g f51753i;

    public e(g gVar, d.a.l0.n.i.m.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        this.f51752h = gVar3;
        this.f51753i = gVar4;
    }

    @Override // d.a.l0.n.i.d
    public String f() {
        return "updatecore";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.l0.n.i.l.e eVar) {
        return eVar != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: p */
    public d.a.l0.n.h.a m(d.a.l0.n.i.l.e eVar) {
        this.f51702e.D();
        d.a.l0.n.n.a.e(this.f51703f.a(), eVar.f51769a);
        g gVar = this.f51702e;
        if (gVar == this.f51752h || gVar == this.f51753i) {
            gVar = null;
        }
        f.c(eVar.f51770b, gVar, this.f51752h, this.f51753i);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.n.i.d
    /* renamed from: q */
    public d.a.l0.n.i.l.e n(JSONObject jSONObject) {
        return d.a.l0.n.o.e.n(jSONObject);
    }
}
