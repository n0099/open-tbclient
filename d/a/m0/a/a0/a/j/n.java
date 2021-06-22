package d.a.m0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f44428a;

    /* renamed from: b  reason: collision with root package name */
    public int f44429b;

    /* renamed from: c  reason: collision with root package name */
    public int f44430c;

    @Override // d.a.m0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (TextUtils.isEmpty(this.f44428a)) {
            return;
        }
        TextPaint textPaint = bVar.f44374i;
        int i2 = bVar.o;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i3 = this.f44430c;
        float f3 = i3 + f2;
        float f4 = fontMetrics.ascent + i3;
        float f5 = fontMetrics.bottom;
        float f6 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i3 : i3 - (f4 - f3) : (i3 + ((f5 - f2) / 2.0f)) - f5 : i3 + (((i3 + f5) - f3) / 2.0f) + (f4 - f3);
        int alpha = textPaint.getAlpha();
        bVar.d(textPaint);
        canvas.drawText(this.f44428a, this.f44429b, f6, textPaint);
        textPaint.setAlpha(alpha);
    }

    @Override // d.a.m0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.f44428a = jSONArray.optString(0);
                this.f44429b = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(1));
                this.f44430c = d.a.m0.a.v2.n0.g((float) jSONArray.optDouble(2));
            }
        } catch (Exception e2) {
            if (d.a.m0.a.k.f46983a) {
                e2.printStackTrace();
            }
        }
    }
}
