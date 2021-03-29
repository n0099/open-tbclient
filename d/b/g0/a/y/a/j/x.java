package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class x extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f47060a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f47060a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f47060a.c()) {
            bVar.f46970f.setShader(this.f47060a.b());
            return;
        }
        bVar.i.setColor(this.f47060a.a());
        bVar.f46970f.setColor(this.f47060a.a());
        bVar.f46970f.setShader(null);
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f47060a = new i(jSONArray);
        }
    }
}
