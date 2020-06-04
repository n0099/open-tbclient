package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import java.util.HashMap;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.a;
/* loaded from: classes5.dex */
public class h extends b {
    private static final Map<Float, Float> nzW = new HashMap();

    protected Float b(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
        Float valueOf = Float.valueOf(paint.getTextSize());
        Float f = nzW.get(valueOf);
        if (f == null) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            Float valueOf2 = Float.valueOf(fontMetrics.leading + (fontMetrics.descent - fontMetrics.ascent));
            nzW.put(valueOf, valueOf2);
            return valueOf2;
        }
        return f;
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void b(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        String[] strArr;
        float f = 0.0f;
        Float valueOf = Float.valueOf(0.0f);
        if (dVar.nxl == null) {
            if (dVar.text != null) {
                f = textPaint.measureText(dVar.text.toString());
                valueOf = b(dVar, textPaint);
            }
            dVar.nxq = f;
            dVar.nxr = valueOf.floatValue();
            return;
        }
        Float b = b(dVar, textPaint);
        float f2 = 0.0f;
        for (String str : dVar.nxl) {
            if (str.length() > 0) {
                f2 = Math.max(textPaint.measureText(str), f2);
            }
        }
        dVar.nxq = f2;
        dVar.nxr = dVar.nxl.length * b.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f, float f2, Paint paint) {
        if (str != null) {
            canvas.drawText(str, f, f2, paint);
        } else {
            canvas.drawText(dVar.text.toString(), f, f2, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z) {
        if (str != null) {
            canvas.drawText(str, f, f2, textPaint);
        } else {
            canvas.drawText(dVar.text.toString(), f, f2, textPaint);
        }
    }

    protected void b(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2) {
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z, a.C0888a c0888a) {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8 = f + dVar.padding;
        float f9 = dVar.padding + f2;
        if (dVar.borderColor != 0) {
            f3 = f9 + 4.0f;
            f4 = f8 + 4.0f;
        } else {
            f3 = f9;
            f4 = f8;
        }
        c0888a.xa(z);
        TextPaint d = c0888a.d(dVar, z);
        b(dVar, canvas, f, f2);
        if (dVar.nxl != null) {
            String[] strArr = dVar.nxl;
            if (strArr.length == 1) {
                if (c0888a.p(dVar)) {
                    c0888a.a(dVar, d, true);
                    float ascent = f3 - d.ascent();
                    if (c0888a.nyO) {
                        f7 = f4 + c0888a.nyG;
                        ascent += c0888a.nyH;
                    } else {
                        f7 = f4;
                    }
                    a(dVar, strArr[0], canvas, f7, ascent, d);
                }
                c0888a.a(dVar, d, false);
                a(dVar, strArr[0], canvas, f4, f3 - d.ascent(), d, z);
            } else {
                float length = (dVar.nxr - (dVar.padding * 2)) / strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    if (strArr[i2] != null && strArr[i2].length() != 0) {
                        if (c0888a.p(dVar)) {
                            c0888a.a(dVar, d, true);
                            float ascent2 = ((i2 * length) + f3) - d.ascent();
                            if (c0888a.nyO) {
                                f6 = f4 + c0888a.nyG;
                                ascent2 += c0888a.nyH;
                            } else {
                                f6 = f4;
                            }
                            a(dVar, strArr[i2], canvas, f6, ascent2, d);
                        }
                        c0888a.a(dVar, d, false);
                        a(dVar, strArr[i2], canvas, f4, ((i2 * length) + f3) - d.ascent(), d, z);
                    }
                    i = i2 + 1;
                }
            }
        } else {
            if (c0888a.p(dVar)) {
                c0888a.a(dVar, d, true);
                float ascent3 = f3 - d.ascent();
                if (c0888a.nyO) {
                    f5 = f4 + c0888a.nyG;
                    ascent3 += c0888a.nyH;
                } else {
                    f5 = f4;
                }
                a(dVar, (String) null, canvas, f5, ascent3, d);
            }
            c0888a.a(dVar, d, false);
            a(dVar, null, canvas, f4, f3 - d.ascent(), d, z);
        }
        if (dVar.nxo != 0) {
            Paint r = c0888a.r(dVar);
            float f10 = (dVar.nxr + f2) - c0888a.nyF;
            canvas.drawLine(f, f10, f + dVar.nxq, f10, r);
        }
        if (dVar.borderColor != 0) {
            canvas.drawRect(f, f2, f + dVar.nxq, f2 + dVar.nxr, c0888a.q(dVar));
        }
    }
}
