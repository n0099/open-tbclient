package d.a.o0.w1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class a extends Animation {

    /* renamed from: e  reason: collision with root package name */
    public View f66320e;

    /* renamed from: f  reason: collision with root package name */
    public int f66321f;

    /* renamed from: g  reason: collision with root package name */
    public int f66322g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f66323h;

    public a(View view, int i2, int i3) {
        if (view == null) {
            return;
        }
        this.f66320e = view;
        if (view.getVisibility() == 8 && i3 > 0) {
            this.f66321f = i3;
        } else {
            this.f66321f = this.f66320e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f66323h = layoutParams;
        this.f66322g = i2;
        if (i2 == 0) {
            layoutParams.bottomMargin = -this.f66321f;
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        if (f2 < 1.0f) {
            if (this.f66322g == 0) {
                FrameLayout.LayoutParams layoutParams = this.f66323h;
                int i2 = this.f66321f;
                layoutParams.bottomMargin = (-i2) + ((int) (i2 * f2));
            } else {
                this.f66323h.bottomMargin = -((int) (this.f66321f * f2));
            }
            this.f66320e.requestLayout();
        } else if (this.f66322g == 0) {
            this.f66323h.bottomMargin = 0;
            this.f66320e.requestLayout();
            this.f66321f = this.f66320e.getMeasuredHeight();
        } else {
            this.f66323h.bottomMargin = -this.f66321f;
            this.f66320e.setVisibility(8);
            this.f66320e.requestLayout();
        }
    }
}
