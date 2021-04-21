package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class x extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f47781a;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f47781a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f47781a.c()) {
            bVar.f47691f.setShader(this.f47781a.b());
            return;
        }
        bVar.i.setColor(this.f47781a.a());
        bVar.f47691f.setColor(this.f47781a.a());
        bVar.f47691f.setShader(null);
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f47781a = new i(jSONArray);
        }
    }
}
