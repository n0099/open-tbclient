package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class a0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public Paint.Cap f44261a;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Paint.Cap cap = this.f44261a;
        if (cap != null) {
            bVar.f44264g.setStrokeCap(cap);
        }
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "butt")) {
                this.f44261a = Paint.Cap.BUTT;
            } else if (TextUtils.equals(optString, "round")) {
                this.f44261a = Paint.Cap.ROUND;
            } else if (TextUtils.equals(optString, "square")) {
                this.f44261a = Paint.Cap.SQUARE;
            }
        }
    }
}
