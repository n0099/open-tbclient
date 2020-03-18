package master.flame.danmaku.danmaku.model.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import master.flame.danmaku.danmaku.model.android.a;
import master.flame.danmaku.danmaku.model.n;
/* loaded from: classes5.dex */
public abstract class b {
    protected a nJc;

    /* loaded from: classes5.dex */
    public static abstract class a {
        public abstract void e(master.flame.danmaku.danmaku.model.d dVar, boolean z);

        public abstract void t(master.flame.danmaku.danmaku.model.d dVar);
    }

    public abstract void a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, boolean z, a.C0781a c0781a);

    public abstract void b(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z);

    public void b(master.flame.danmaku.danmaku.model.d dVar, boolean z) {
        if (this.nJc != null) {
            this.nJc.e(dVar, z);
        }
    }

    public boolean a(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f, float f2, Paint paint, TextPaint textPaint) {
        f fVar;
        n<?> dMj = dVar.dMj();
        if (dMj == null || (fVar = (f) dMj.get()) == null) {
            return false;
        }
        return fVar.a(canvas, f, f2, paint);
    }

    public void s(master.flame.danmaku.danmaku.model.d dVar) {
    }

    public void a(a aVar) {
        this.nJc = aVar;
    }

    public void t(master.flame.danmaku.danmaku.model.d dVar) {
        if (this.nJc != null) {
            this.nJc.t(dVar);
        }
    }
}
