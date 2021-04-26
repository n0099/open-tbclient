package d.a.j0.v1;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
/* loaded from: classes3.dex */
public class a extends Animation {

    /* renamed from: e  reason: collision with root package name */
    public View f61650e;

    /* renamed from: f  reason: collision with root package name */
    public int f61651f;

    /* renamed from: g  reason: collision with root package name */
    public int f61652g;

    /* renamed from: h  reason: collision with root package name */
    public FrameLayout.LayoutParams f61653h;

    public a(View view, int i2, int i3) {
        if (view == null) {
            return;
        }
        this.f61650e = view;
        if (view.getVisibility() == 8 && i3 > 0) {
            this.f61651f = i3;
        } else {
            this.f61651f = this.f61650e.getMeasuredHeight();
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        this.f61653h = layoutParams;
        this.f61652g = i2;
        if (i2 == 0) {
            layoutParams.bottomMargin = -this.f61651f;
        } else {
            layoutParams.bottomMargin = 0;
        }
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        if (f2 < 1.0f) {
            if (this.f61652g == 0) {
                FrameLayout.LayoutParams layoutParams = this.f61653h;
                int i2 = this.f61651f;
                layoutParams.bottomMargin = (-i2) + ((int) (i2 * f2));
            } else {
                this.f61653h.bottomMargin = -((int) (this.f61651f * f2));
            }
            this.f61650e.requestLayout();
        } else if (this.f61652g == 0) {
            this.f61653h.bottomMargin = 0;
            this.f61650e.requestLayout();
            this.f61651f = this.f61650e.getMeasuredHeight();
        } else {
            this.f61653h.bottomMargin = -this.f61651f;
            this.f61650e.setVisibility(8);
            this.f61650e.requestLayout();
        }
    }
}
