package d.a.i0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class c0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public Paint.Join f40422a;

    @Override // d.a.i0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        Paint.Join join = this.f40422a;
        if (join != null) {
            bVar.f40414g.setStrokeJoin(join);
        }
    }

    @Override // d.a.i0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            String optString = jSONArray.optString(0);
            if (TextUtils.equals(optString, "bevel")) {
                this.f40422a = Paint.Join.BEVEL;
            } else if (TextUtils.equals(optString, "round")) {
                this.f40422a = Paint.Join.ROUND;
            } else if (TextUtils.equals(optString, "miter")) {
                this.f40422a = Paint.Join.MITER;
            }
        }
    }
}
