package com.kascend.chushou.widget.b;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes6.dex */
public class a extends Animation {

    /* renamed from: a  reason: collision with root package name */
    private float f4260a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private Camera pqP;

    public a(float f, float f2, float f3, float f4, float f5, float f6) {
        this.f4260a = f;
        this.b = f2;
        this.e = f3;
        this.f = f4;
        this.c = f5;
        this.d = f6;
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.pqP = new Camera();
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f4260a + ((this.b - this.f4260a) * f);
        float f3 = this.c;
        float f4 = this.d;
        Matrix matrix = transformation.getMatrix();
        this.pqP.save();
        this.pqP.rotateY(f2);
        this.pqP.getMatrix(matrix);
        this.pqP.restore();
        matrix.preTranslate(-f3, -f4);
        matrix.postTranslate(f3, f4);
    }
}
