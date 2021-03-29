package d.b.i0.u1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {

    /* renamed from: e  reason: collision with root package name */
    public View f61260e;

    /* renamed from: f  reason: collision with root package name */
    public int f61261f;

    /* renamed from: g  reason: collision with root package name */
    public int f61262g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f61263h;

    public a(View view, int i, int i2) {
        if (view == null) {
            return;
        }
        this.f61260e = view;
        if (view.getVisibility() == 8 && i2 > 0) {
            this.f61261f = i2;
        } else {
            this.f61261f = this.f61260e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f61263h = layoutParams;
        this.f61262g = i;
        if (i == 0) {
            layoutParams.bottomMargin = -this.f61261f;
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        if (f2 < 1.0f) {
            if (this.f61262g == 0) {
                FrameLayout.LayoutParams layoutParams = this.f61263h;
                int i = this.f61261f;
                layoutParams.bottomMargin = (-i) + ((int) (i * f2));
            } else {
                this.f61263h.bottomMargin = -((int) (this.f61261f * f2));
            }
            this.f61260e.requestLayout();
        } else if (this.f61262g == 0) {
            this.f61263h.bottomMargin = 0;
            this.f61260e.requestLayout();
            this.f61261f = this.f61260e.getMeasuredHeight();
        } else {
            this.f61263h.bottomMargin = -this.f61261f;
            this.f61260e.setVisibility(8);
            this.f61260e.requestLayout();
        }
    }
}
