package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import java.util.HashMap;
import java.util.Map;
import master.flame.danmaku.danmaku.model.android.a;
/* loaded from: classes4.dex */
public class h extends b {
    private static final Map<Float, Float> nHo = new HashMap();

    protected Float b(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
        Float valueOf = Float.valueOf(paint.getTextSize());
        Float f = nHo.get(valueOf);
        if (f == null) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            Float valueOf2 = Float.valueOf(fontMetrics.leading + (fontMetrics.descent - fontMetrics.ascent));
            nHo.put(valueOf, valueOf2);
            return valueOf2;
        }
        return f;
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void b(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        String[] strArr;
        float f = 0.0f;
        Float valueOf = Float.valueOf(0.0f);
        if (dVar.nED == null) {
            if (dVar.text != null) {
                f = textPaint.measureText(dVar.text.toString());
                valueOf = b(dVar, textPaint);
            }
            dVar.nEI = f;
            dVar.nEJ = valueOf.floatValue();
            return;
        }
        Float b = b(dVar, textPaint);
        float f2 = 0.0f;
        for (String str : dVar.nED) {
            if (str.length() > 0) {
                f2 = Math.max(textPaint.measureText(str), f2);
            }
        }
        dVar.nEI = f2;
        dVar.nEJ = dVar.nED.length * b.floatValue();
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
    public void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z, a.C0772a c0772a) {
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
        c0772a.wK(z);
        TextPaint d = c0772a.d(dVar, z);
        b(dVar, canvas, f, f2);
        if (dVar.nED != null) {
            String[] strArr = dVar.nED;
            if (strArr.length == 1) {
                if (c0772a.p(dVar)) {
                    c0772a.a(dVar, d, true);
                    float ascent = f3 - d.ascent();
                    if (c0772a.nGe) {
                        f7 = f4 + c0772a.nFW;
                        ascent += c0772a.nFX;
                    } else {
                        f7 = f4;
                    }
                    a(dVar, strArr[0], canvas, f7, ascent, d);
                }
                c0772a.a(dVar, d, false);
                a(dVar, strArr[0], canvas, f4, f3 - d.ascent(), d, z);
            } else {
                float length = (dVar.nEJ - (dVar.padding * 2)) / strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    if (strArr[i2] != null && strArr[i2].length() != 0) {
                        if (c0772a.p(dVar)) {
                            c0772a.a(dVar, d, true);
                            float ascent2 = ((i2 * length) + f3) - d.ascent();
                            if (c0772a.nGe) {
                                f6 = f4 + c0772a.nFW;
                                ascent2 += c0772a.nFX;
                            } else {
                                f6 = f4;
                            }
                            a(dVar, strArr[i2], canvas, f6, ascent2, d);
                        }
                        c0772a.a(dVar, d, false);
                        a(dVar, strArr[i2], canvas, f4, ((i2 * length) + f3) - d.ascent(), d, z);
                    }
                    i = i2 + 1;
                }
            }
        } else {
            if (c0772a.p(dVar)) {
                c0772a.a(dVar, d, true);
                float ascent3 = f3 - d.ascent();
                if (c0772a.nGe) {
                    f5 = f4 + c0772a.nFW;
                    ascent3 += c0772a.nFX;
                } else {
                    f5 = f4;
                }
                a(dVar, (String) null, canvas, f5, ascent3, d);
            }
            c0772a.a(dVar, d, false);
            a(dVar, null, canvas, f4, f3 - d.ascent(), d, z);
        }
        if (dVar.nEG != 0) {
            Paint r = c0772a.r(dVar);
            float f10 = (dVar.nEJ + f2) - c0772a.nFV;
            canvas.drawLine(f, f10, f + dVar.nEI, f10, r);
        }
        if (dVar.borderColor != 0) {
            canvas.drawRect(f, f2, f + dVar.nEI, f2 + dVar.nEJ, c0772a.q(dVar));
        }
    }
}
