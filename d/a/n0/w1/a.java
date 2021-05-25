package d.a.n0.w1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {

    /* renamed from: e  reason: collision with root package name */
    public View f62480e;

    /* renamed from: f  reason: collision with root package name */
    public int f62481f;

    /* renamed from: g  reason: collision with root package name */
    public int f62482g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f62483h;

    public a(View view, int i2, int i3) {
        if (view == null) {
            return;
        }
        this.f62480e = view;
        if (view.getVisibility() == 8 && i3 > 0) {
            this.f62481f = i3;
        } else {
            this.f62481f = this.f62480e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f62483h = layoutParams;
        this.f62482g = i2;
        if (i2 == 0) {
            layoutParams.bottomMargin = -this.f62481f;
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        if (f2 < 1.0f) {
            if (this.f62482g == 0) {
                FrameLayout.LayoutParams layoutParams = this.f62483h;
                int i2 = this.f62481f;
                layoutParams.bottomMargin = (-i2) + ((int) (i2 * f2));
            } else {
                this.f62483h.bottomMargin = -((int) (this.f62481f * f2));
            }
            this.f62480e.requestLayout();
        } else if (this.f62482g == 0) {
            this.f62483h.bottomMargin = 0;
            this.f62480e.requestLayout();
            this.f62481f = this.f62480e.getMeasuredHeight();
        } else {
            this.f62483h.bottomMargin = -this.f62481f;
            this.f62480e.setVisibility(8);
            this.f62480e.requestLayout();
        }
    }
}
