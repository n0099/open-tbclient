package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f40473a;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f40473a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f40473a.c()) {
            bVar.f40414g.setShader(this.f40473a.b());
            return;
        }
        bVar.q = this.f40473a.a();
        bVar.f40414g.setColor(this.f40473a.a());
        bVar.f40413f.setShader(null);
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f40473a = new i(jSONArray);
        }
    }
}
