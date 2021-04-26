package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class x extends a {

    /* renamed from: a  reason: collision with root package name */
    public i f45215a;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        i iVar = this.f45215a;
        if (iVar == null || !iVar.d()) {
            return;
        }
        if (this.f45215a.c()) {
            bVar.f45123f.setShader(this.f45215a.b());
            return;
        }
        bVar.f45126i.setColor(this.f45215a.a());
        bVar.f45123f.setColor(this.f45215a.a());
        bVar.f45123f.setShader(null);
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f45215a = new i(jSONArray);
        }
    }
}
