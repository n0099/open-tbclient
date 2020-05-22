package tv.chushou.zues.widget.emanate.a;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
/* loaded from: classes5.dex */
public class a implements TypeEvaluator<PointF> {
    private PointF nOC;
    private PointF nOD;

    public a(PointF pointF, PointF pointF2) {
        this.nOC = pointF;
        this.nOD = pointF2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: b */
    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        float f2 = 1.0f - f;
        float f3 = f2 * f2 * f2;
        float f4 = 3.0f * f2 * f2 * f;
        float f5 = f2 * 3.0f * f * f;
        float f6 = f * f * f;
        PointF pointF3 = new PointF();
        pointF3.x = (pointF.x * f3) + (this.nOC.x * f4) + (this.nOD.x * f5) + (pointF2.x * f6);
        pointF3.y = (f5 * this.nOD.y) + (f3 * pointF.y) + (f4 * this.nOC.y) + (pointF2.y * f6);
        return pointF3;
    }
}
