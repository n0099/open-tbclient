package d.a.h0.l.l.i;

import androidx.annotation.Nullable;
import d.a.h0.l.h.g;
import d.a.h0.l.m.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends d.a.h0.l.l.d<d.a.h0.l.l.j.e> {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public g f47207h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public g f47208i;

    public e(g gVar, d.a.h0.l.l.k.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        this.f47207h = gVar3;
        this.f47208i = gVar4;
    }

    @Override // d.a.h0.l.l.d
    public String e() {
        return "updatecore";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: n */
    public boolean d(d.a.h0.l.l.j.e eVar) {
        return eVar != null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: o */
    public d.a.h0.l.k.a l(d.a.h0.l.l.j.e eVar) {
        this.f47163e.D();
        d.a.h0.l.q.a.e(this.f47164f.a(), eVar.f47224a);
        g gVar = this.f47163e;
        if (gVar == this.f47207h || gVar == this.f47208i) {
            gVar = null;
        }
        f.c(eVar.f47225b, gVar, this.f47207h, this.f47208i);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.l.l.d
    /* renamed from: p */
    public d.a.h0.l.l.j.e m(JSONObject jSONObject) {
        return d.a.h0.l.r.e.n(jSONObject);
    }
}
