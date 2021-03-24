package d.b.i0.u1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public class a extends Animation {

    /* renamed from: e  reason: collision with root package name */
    public View f61259e;

    /* renamed from: f  reason: collision with root package name */
    public int f61260f;

    /* renamed from: g  reason: collision with root package name */
    public int f61261g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f61262h;

    public a(View view, int i, int i2) {
        if (view == null) {
            return;
        }
        this.f61259e = view;
        if (view.getVisibility() == 8 && i2 > 0) {
            this.f61260f = i2;
        } else {
            this.f61260f = this.f61259e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f61262h = layoutParams;
        this.f61261g = i;
        if (i == 0) {
            layoutParams.bottomMargin = -this.f61260f;
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        if (f2 < 1.0f) {
            if (this.f61261g == 0) {
                FrameLayout.LayoutParams layoutParams = this.f61262h;
                int i = this.f61260f;
                layoutParams.bottomMargin = (-i) + ((int) (i * f2));
            } else {
                this.f61262h.bottomMargin = -((int) (this.f61260f * f2));
            }
            this.f61259e.requestLayout();
        } else if (this.f61261g == 0) {
            this.f61262h.bottomMargin = 0;
            this.f61259e.requestLayout();
            this.f61260f = this.f61259e.getMeasuredHeight();
        } else {
            this.f61262h.bottomMargin = -this.f61260f;
            this.f61259e.setVisibility(8);
            this.f61259e.requestLayout();
        }
    }
}
