package d.a.i0.n.i.k;

import androidx.annotation.Nullable;
import d.a.i0.n.f.g;
import d.a.i0.n.j.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.i0.n.i.d<d.a.i0.n.i.l.e> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public g f47902h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public g f47903i;

    public e(g gVar, d.a.i0.n.i.m.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        this.f47902h = gVar3;
        this.f47903i = gVar4;
    }

    @Override // d.a.i0.n.i.d
    public String f() {
        return "updatecore";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.i0.n.i.l.e eVar) {
        return eVar != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: p */
    public d.a.i0.n.h.a m(d.a.i0.n.i.l.e eVar) {
        this.f47852e.D();
        d.a.i0.n.n.a.e(this.f47853f.a(), eVar.f47919a);
        g gVar = this.f47852e;
        if (gVar == this.f47902h || gVar == this.f47903i) {
            gVar = null;
        }
        f.c(eVar.f47920b, gVar, this.f47902h, this.f47903i);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.n.i.d
    /* renamed from: q */
    public d.a.i0.n.i.l.e n(JSONObject jSONObject) {
        return d.a.i0.n.o.e.n(jSONObject);
    }
}
