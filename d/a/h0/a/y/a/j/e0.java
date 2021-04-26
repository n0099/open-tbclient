package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class e0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f45141a = -1;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2 = this.f45141a;
        if (i2 >= 0) {
            bVar.f45124g.setStrokeMiter(i2);
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f45141a = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
        }
    }
}
