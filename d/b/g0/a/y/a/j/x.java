package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class x extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f47452a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f47452a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f47452a.c()) {
            bVar.f47362f.setShader(this.f47452a.b());
            return;
        }
        bVar.i.setColor(this.f47452a.a());
        bVar.f47362f.setColor(this.f47452a.a());
        bVar.f47362f.setShader(null);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f47452a = new i(jSONArray);
        }
    }
}
