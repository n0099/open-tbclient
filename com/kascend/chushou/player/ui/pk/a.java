package com.kascend.chushou.player.ui.pk;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
/* loaded from: classes6.dex */
public class a implements TypeEvaluator<PointF> {
    private PointF pno;
    private PointF pnp;

    public a(PointF pointF, PointF pointF2) {
        this.pno = pointF;
        this.pnp = pointF2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        float f2 = 1.0f - f;
        PointF pointF3 = new PointF();
        pointF3.x = (f2 * f2 * f2 * pointF.x) + (3.0f * f2 * f2 * f * this.pno.x) + (3.0f * f2 * f * f * this.pnp.x) + (f * f * f * pointF2.x);
        pointF3.y = (f2 * 3.0f * f * f * this.pnp.y) + (f2 * f2 * f2 * pointF.y) + (3.0f * f2 * f2 * f * this.pno.y) + (f * f * f * pointF2.y);
        return pointF3;
    }
}
