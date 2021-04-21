package d.b.h0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class n extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f47746a;

    /* renamed from: b  reason: collision with root package name */
    public int f47747b;

    /* renamed from: c  reason: collision with root package name */
    public int f47748c;

    @Override // d.b.h0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (TextUtils.isEmpty(this.f47746a)) {
            return;
        }
        TextPaint textPaint = bVar.i;
        int i = bVar.o;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i2 = this.f47748c;
        float f3 = i2 + f2;
        float f4 = fontMetrics.ascent + i2;
        float f5 = fontMetrics.bottom;
        float f6 = i != 1 ? i != 2 ? i != 3 ? i2 : i2 - (f4 - f3) : (i2 + ((f5 - f2) / 2.0f)) - f5 : i2 + (((i2 + f5) - f3) / 2.0f) + (f4 - f3);
        int alpha = textPaint.getAlpha();
        bVar.d(textPaint);
        canvas.drawText(this.f47746a, this.f47747b, f6, textPaint);
        textPaint.setAlpha(alpha);
    }

    @Override // d.b.h0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.f47746a = jSONArray.optString(0);
                this.f47747b = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f47748c = d.b.h0.a.i2.h0.f((float) jSONArray.optDouble(2));
            }
        } catch (Exception e2) {
            if (d.b.h0.a.k.f45772a) {
                e2.printStackTrace();
            }
        }
    }
}
