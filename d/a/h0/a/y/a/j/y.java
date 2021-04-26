package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class y extends a {

    /* renamed from: a  reason: collision with root package name */
    public int f45216a;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        int i2 = this.f45216a;
        if (i2 > 0) {
            bVar.f45126i.setTextSize(i2);
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 0) {
                this.f45216a = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
