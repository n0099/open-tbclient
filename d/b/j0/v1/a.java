package d.b.j0.v1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {

    /* renamed from: e  reason: collision with root package name */
    public View f63419e;

    /* renamed from: f  reason: collision with root package name */
    public int f63420f;

    /* renamed from: g  reason: collision with root package name */
    public int f63421g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f63422h;

    public a(View view, int i, int i2) {
        if (view == null) {
            return;
        }
        this.f63419e = view;
        if (view.getVisibility() == 8 && i2 > 0) {
            this.f63420f = i2;
        } else {
            this.f63420f = this.f63419e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f63422h = layoutParams;
        this.f63421g = i;
        if (i == 0) {
            layoutParams.bottomMargin = -this.f63420f;
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        if (f2 < 1.0f) {
            if (this.f63421g == 0) {
                FrameLayout.LayoutParams layoutParams = this.f63422h;
                int i = this.f63420f;
                layoutParams.bottomMargin = (-i) + ((int) (i * f2));
            } else {
                this.f63422h.bottomMargin = -((int) (this.f63420f * f2));
            }
            this.f63419e.requestLayout();
        } else if (this.f63421g == 0) {
            this.f63422h.bottomMargin = 0;
            this.f63419e.requestLayout();
            this.f63420f = this.f63419e.getMeasuredHeight();
        } else {
            this.f63422h.bottomMargin = -this.f63420f;
            this.f63419e.setVisibility(8);
            this.f63419e.requestLayout();
        }
    }
}
