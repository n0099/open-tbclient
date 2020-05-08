package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import java.lang.ref.SoftReference;
/* loaded from: classes5.dex */
public class i extends h {
    @Override // master.flame.danmaku.danmaku.model.android.h, master.flame.danmaku.danmaku.model.android.b
    public void b(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z) {
        CharSequence charSequence;
        if ((dVar.text instanceof Spanned) && (charSequence = dVar.text) != null) {
            StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(StaticLayout.getDesiredWidth(dVar.text, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            dVar.nbd = staticLayout.getWidth();
            dVar.nbe = staticLayout.getHeight();
            dVar.obj = new SoftReference(staticLayout);
            return;
        }
        super.b(dVar, textPaint, z);
    }

    @Override // master.flame.danmaku.danmaku.model.android.h
    public void a(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f, float f2, Paint paint) {
        if (dVar.obj == null) {
            super.a(dVar, str, canvas, f, f2, paint);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.h
    public void a(master.flame.danmaku.danmaku.model.d dVar, String str, Canvas canvas, float f, float f2, TextPaint textPaint, boolean z) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        if (dVar.obj == null) {
            super.a(dVar, str, canvas, f, f2, textPaint, z);
            return;
        }
        StaticLayout staticLayout3 = (StaticLayout) ((SoftReference) dVar.obj).get();
        boolean z2 = (dVar.nbs & 1) != 0;
        boolean z3 = (dVar.nbs & 2) != 0;
        if (z3 || staticLayout3 == null) {
            if (z3) {
                dVar.nbs &= -3;
            }
            CharSequence charSequence = dVar.text;
            if (charSequence != null) {
                if (z2) {
                    staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(StaticLayout.getDesiredWidth(dVar.text, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                    dVar.nbd = staticLayout.getWidth();
                    dVar.nbe = staticLayout.getHeight();
                    dVar.nbs &= -2;
                } else {
                    staticLayout = new StaticLayout(charSequence, textPaint, (int) dVar.nbd, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
                }
                dVar.obj = new SoftReference(staticLayout);
                staticLayout2 = staticLayout;
            } else {
                return;
            }
        } else {
            staticLayout2 = staticLayout3;
        }
        boolean z4 = false;
        if (f != 0.0f && f2 != 0.0f) {
            canvas.save();
            canvas.translate(f, textPaint.ascent() + f2);
            z4 = true;
        }
        staticLayout2.draw(canvas);
        if (z4) {
            canvas.restore();
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void s(master.flame.danmaku.danmaku.model.d dVar) {
        super.s(dVar);
        if (dVar != null && dVar.obj != null && (dVar.obj instanceof SoftReference)) {
            try {
                ((SoftReference) dVar.obj).clear();
            } catch (Exception e) {
            }
        }
    }

    @Override // master.flame.danmaku.danmaku.model.android.b
    public void t(master.flame.danmaku.danmaku.model.d dVar) {
        s(dVar);
        super.t(dVar);
    }
}
