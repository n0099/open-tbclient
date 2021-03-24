package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class o0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f47032a;

    /* renamed from: b  reason: collision with root package name */
    public int f47033b;

    /* renamed from: c  reason: collision with root package name */
    public int f47034c;

    /* renamed from: d  reason: collision with root package name */
    public float f47035d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f47036e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f47037f = 1.0f;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (TextUtils.isEmpty(this.f47032a)) {
            return;
        }
        TextPaint textPaint = bVar.i;
        int i = bVar.o;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i2 = this.f47034c;
        float f3 = i2 + f2;
        float f4 = fontMetrics.ascent + i2;
        float f5 = fontMetrics.bottom;
        float f6 = i != 1 ? i != 2 ? i != 3 ? i2 : i2 - (f4 - f3) : (i2 + ((f5 - f2) / 2.0f)) - f5 : i2 + (((i2 + f5) - f3) / 2.0f) + (f4 - f3);
        if (this.f47036e == 0.0d) {
            Rect rect = new Rect();
            String str = this.f47032a;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            if (this.f47035d != -1.0f) {
                float f7 = this.f47035d;
                if (rect.width() > f7) {
                    this.f47036e = f7 / rect.width();
                }
            }
            this.f47036e = 1.0f;
        }
        canvas.save();
        int alpha = textPaint.getAlpha();
        int color = textPaint.getColor();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.f47037f);
        textPaint.setColor(bVar.q);
        bVar.d(textPaint);
        canvas.scale(this.f47036e, 1.0f);
        canvas.drawText(this.f47032a, this.f47033b, f6, textPaint);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAlpha(alpha);
        textPaint.setColor(color);
        canvas.restore();
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.f47032a = jSONArray.optString(0);
                this.f47033b = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f47034c = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.f47035d = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3));
                }
                this.f47037f = d.b.g0.a.i2.h0.f(1.0f);
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45050a) {
                e2.printStackTrace();
            }
        }
    }
}
