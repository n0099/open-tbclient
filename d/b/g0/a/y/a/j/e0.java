package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f46987a = -1;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i = this.f46987a;
        if (i >= 0) {
            bVar.f46971g.setStrokeMiter(i);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f46987a = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(0));
        }
    }
}
