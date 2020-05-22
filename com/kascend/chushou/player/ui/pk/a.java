package com.kascend.chushou.player.ui.pk;

import android.animation.TypeEvaluator;
import android.graphics.PointF;
/* loaded from: classes5.dex */
public class a implements TypeEvaluator<PointF> {
    private PointF mWS;
    private PointF mWT;

    public a(PointF pointF, PointF pointF2) {
        this.mWS = pointF;
        this.mWT = pointF2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.animation.TypeEvaluator
    /* renamed from: a */
    public PointF evaluate(float f, PointF pointF, PointF pointF2) {
        float f2 = 1.0f - f;
        PointF pointF3 = new PointF();
        pointF3.x = (f2 * f2 * f2 * pointF.x) + (3.0f * f2 * f2 * f * this.mWS.x) + (3.0f * f2 * f * f * this.mWT.x) + (f * f * f * pointF2.x);
        pointF3.y = (f2 * 3.0f * f * f * this.mWT.y) + (f2 * f2 * f2 * pointF.y) + (3.0f * f2 * f2 * f * this.mWS.y) + (f * f * f * pointF2.y);
        return pointF3;
    }
}
