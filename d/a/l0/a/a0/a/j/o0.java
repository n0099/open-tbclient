package d.a.l0.a.a0.a.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.text.TextUtils;
import org.json.JSONArray;
/* loaded from: classes2.dex */
public class o0 extends a {

    /* renamed from: a  reason: collision with root package name */
    public String f40652a;

    /* renamed from: b  reason: collision with root package name */
    public int f40653b;

    /* renamed from: c  reason: collision with root package name */
    public int f40654c;

    /* renamed from: d  reason: collision with root package name */
    public float f40655d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f40656e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f40657f = 1.0f;

    @Override // d.a.l0.a.a0.a.j.a
    public void a(b bVar, Canvas canvas) {
        if (TextUtils.isEmpty(this.f40652a)) {
            return;
        }
        TextPaint textPaint = bVar.f40590i;
        int i2 = bVar.o;
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float f2 = fontMetrics.top;
        int i3 = this.f40654c;
        float f3 = i3 + f2;
        float f4 = fontMetrics.ascent + i3;
        float f5 = fontMetrics.bottom;
        float f6 = i2 != 1 ? i2 != 2 ? i2 != 3 ? i3 : i3 - (f4 - f3) : (i3 + ((f5 - f2) / 2.0f)) - f5 : i3 + (((i3 + f5) - f3) / 2.0f) + (f4 - f3);
        if (this.f40656e == 0.0d) {
            Rect rect = new Rect();
            String str = this.f40652a;
            textPaint.getTextBounds(str, 0, str.length(), rect);
            if (this.f40655d != -1.0f) {
                float f7 = this.f40655d;
                if (rect.width() > f7) {
                    this.f40656e = f7 / rect.width();
                }
            }
            this.f40656e = 1.0f;
        }
        canvas.save();
        int alpha = textPaint.getAlpha();
        int color = textPaint.getColor();
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(this.f40657f);
        textPaint.setColor(bVar.q);
        bVar.d(textPaint);
        canvas.scale(this.f40656e, 1.0f);
        canvas.drawText(this.f40652a, this.f40653b, f6, textPaint);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAlpha(alpha);
        textPaint.setColor(color);
        canvas.restore();
    }

    @Override // d.a.l0.a.a0.a.j.a
    public void b(JSONArray jSONArray) {
        try {
            if (jSONArray.length() > 2) {
                this.f40652a = jSONArray.optString(0);
                this.f40653b = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(1));
                this.f40654c = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(2));
                if (jSONArray.length() > 3) {
                    this.f40655d = d.a.l0.a.v2.n0.g((float) jSONArray.optDouble(3));
                }
                this.f40657f = d.a.l0.a.v2.n0.g(1.0f);
            }
        } catch (Exception e2) {
            if (d.a.l0.a.k.f43199a) {
                e2.printStackTrace();
            }
        }
    }
}
