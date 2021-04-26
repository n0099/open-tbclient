package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class d0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f45133a = -1;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2 = this.f45133a;
        if (i2 >= 0) {
            bVar.f45124g.setStrokeWidth(i2);
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            this.f45133a = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
        }
    }
}
