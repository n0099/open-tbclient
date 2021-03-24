package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public Paint.Cap f46967a;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        Paint.Cap cap = this.f46967a;
        if (cap != null) {
            bVar.f46970g.setStrokeCap(cap);
        }
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "butt")) {
                this.f46967a = Paint.Cap.BUTT;
            } else if (TextUtils.equals(optString, "round")) {
                this.f46967a = Paint.Cap.ROUND;
            } else if (TextUtils.equals(optString, "square")) {
                this.f46967a = Paint.Cap.SQUARE;
            }
        }
    }
}
