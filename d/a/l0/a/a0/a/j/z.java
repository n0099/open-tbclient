package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class z extends a {

    /* renamed from: a  reason: collision with root package name */
    public float f44357a = -1.0f;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        float f2 = this.f44357a;
        if (f2 < 0.0f || f2 > 1.0f) {
            return;
        }
        bVar.n = (int) (f2 * 255.0f);
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f44357a = (float) jSONArray.optDouble(0);
        }
    }
}
