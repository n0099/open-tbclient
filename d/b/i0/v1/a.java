package d.b.i0.v1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {

    /* renamed from: e  reason: collision with root package name */
    public View f62998e;

    /* renamed from: f  reason: collision with root package name */
    public int f62999f;

    /* renamed from: g  reason: collision with root package name */
    public int f63000g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f63001h;

    public a(View view, int i, int i2) {
        if (view == null) {
            return;
        }
        this.f62998e = view;
        if (view.getVisibility() == 8 && i2 > 0) {
            this.f62999f = i2;
        } else {
            this.f62999f = this.f62998e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f63001h = layoutParams;
        this.f63000g = i;
        if (i == 0) {
            layoutParams.bottomMargin = -this.f62999f;
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        if (f2 < 1.0f) {
            if (this.f63000g == 0) {
                FrameLayout.LayoutParams layoutParams = this.f63001h;
                int i = this.f62999f;
                layoutParams.bottomMargin = (-i) + ((int) (i * f2));
            } else {
                this.f63001h.bottomMargin = -((int) (this.f62999f * f2));
            }
            this.f62998e.requestLayout();
        } else if (this.f63000g == 0) {
            this.f63001h.bottomMargin = 0;
            this.f62998e.requestLayout();
            this.f62999f = this.f62998e.getMeasuredHeight();
        } else {
            this.f63001h.bottomMargin = -this.f62999f;
            this.f62998e.setVisibility(8);
            this.f62998e.requestLayout();
        }
    }
}
