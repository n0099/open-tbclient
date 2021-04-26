package d.a.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class s extends a {

    /* renamed from: a  reason: collision with root package name */
    public RectF f45211a;

    @Override // d.a.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        RectF rectF = this.f45211a;
        if (rectF != null) {
            bVar.j.addRect(rectF, Path.Direction.CW);
        }
    }

    @Override // d.a.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() == 4) {
                int f2 = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(0));
                int f3 = d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f45211a = new RectF(f2, f3, f2 + d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(2)), f3 + d.a.h0.a.i2.h0.f((float) jSONArray.optDouble(3)));
            }
        } catch (Exception e2) {
            if (d.a.h0.a.k.f43101a) {
                e2.printStackTrace();
            }
        }
    }
}
