package d.a.k0.v1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {

    /* renamed from: e  reason: collision with root package name */
    public View f62374e;

    /* renamed from: f  reason: collision with root package name */
    public int f62375f;

    /* renamed from: g  reason: collision with root package name */
    public int f62376g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f62377h;

    public a(View view, int i2, int i3) {
        if (view == null) {
            return;
        }
        this.f62374e = view;
        if (view.getVisibility() == 8 && i3 > 0) {
            this.f62375f = i3;
        } else {
            this.f62375f = this.f62374e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f62377h = layoutParams;
        this.f62376g = i2;
        if (i2 == 0) {
            layoutParams.bottomMargin = -this.f62375f;
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        if (f2 < 1.0f) {
            if (this.f62376g == 0) {
                FrameLayout.LayoutParams layoutParams = this.f62377h;
                int i2 = this.f62375f;
                layoutParams.bottomMargin = (-i2) + ((int) (i2 * f2));
            } else {
                this.f62377h.bottomMargin = -((int) (this.f62375f * f2));
            }
            this.f62374e.requestLayout();
        } else if (this.f62376g == 0) {
            this.f62377h.bottomMargin = 0;
            this.f62374e.requestLayout();
            this.f62375f = this.f62374e.getMeasuredHeight();
        } else {
            this.f62377h.bottomMargin = -this.f62375f;
            this.f62374e.setVisibility(8);
            this.f62374e.requestLayout();
        }
    }
}
