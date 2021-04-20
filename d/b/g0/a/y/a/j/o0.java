package d.b.g0.a.y.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class o0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f47425a;

    /* renamed from: b  reason: collision with root package name */
    public int f47426b;

    /* renamed from: c  reason: collision with root package name */
    public int f47427c;

    /* renamed from: d  reason: collision with root package name */
    public float f47428d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f47429e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f47430f = 1.0f;

    @Override // d.b.g0.a.y.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (TextUtils.isEmpty(this.f47425a)) {
            return;
        }
        TextPaint textPaint = bVar.i;
        int i = bVar.o;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i2 = this.f47427c;
        float f3 = i2 + f2;
        float f4 = fontMetrics.ascent + i2;
        float f5 = fontMetrics.bottom;
        float f6 = i != 1 ? i != 2 ? i != 3 ? i2 : i2 - (f4 - f3) : (i2 + ((f5 - f2) / 2.0f)) - f5 : i2 + (((i2 + f5) - f3) / 2.0f) + (f4 - f3);
        if (this.f47429e == 0.0d) {
            Rect rect = new Rect();
            String str = this.f47425a;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            if (this.f47428d != -1.0f) {
                float f7 = this.f47428d;
                if (rect.width() > f7) {
                    this.f47429e = f7 / rect.width();
                }
            }
            this.f47429e = 1.0f;
        }
        canvas.save();
        int alpha = textPaint.getAlpha();
        int color = textPaint.getColor();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.f47430f);
        textPaint.setColor(bVar.q);
        bVar.d(textPaint);
        canvas.scale(this.f47429e, 1.0f);
        canvas.drawText(this.f47425a, this.f47426b, f6, textPaint);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAlpha(alpha);
        textPaint.setColor(color);
        canvas.restore();
    }

    @Override // d.b.g0.a.y.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.f47425a = jSONArray.optString(0);
                this.f47426b = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(1));
                this.f47427c = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.f47428d = d.b.g0.a.i2.h0.f((float) jSONArray.optDouble(3));
                }
                this.f47430f = d.b.g0.a.i2.h0.f(1.0f);
            }
        } catch (Exception e2) {
            if (d.b.g0.a.k.f45443a) {
                e2.printStackTrace();
            }
        }
    }
}
