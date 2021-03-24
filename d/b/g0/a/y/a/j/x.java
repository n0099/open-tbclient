package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class x extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f47059a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f47059a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f47059a.c()) {
            bVar.f46969f.setShader(this.f47059a.b());
            return;
        }
        bVar.i.setColor(this.f47059a.a());
        bVar.f46969f.setColor(this.f47059a.a());
        bVar.f46969f.setShader(null);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f47059a = new i(jSONArray);
        }
    }
}
