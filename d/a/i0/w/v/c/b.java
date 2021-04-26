package d.a.i0.w.v.c;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R$styleable;
import d.a.i0.w.v.d.d;
/* loaded from: classes3.dex */
public class b implements d.a.i0.w.v.a {

    /* renamed from: e  reason: collision with root package name */
    public final View f49979e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f49981g;

    /* renamed from: f  reason: collision with root package name */
    public boolean f49980f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49982h = false;

    public b(View view, AttributeSet attributeSet) {
        this.f49981g = false;
        this.f49979e = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.KPSwitchPanelLayout);
                this.f49981g = typedArray.getBoolean(R$styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean a(int i2) {
        if (i2 == 0) {
            this.f49980f = false;
        }
        if (i2 == this.f49979e.getVisibility()) {
            return true;
        }
        return b() && i2 == 0;
    }

    @Override // d.a.i0.w.v.a
    public boolean b() {
        return this.f49982h;
    }

    public int[] c(int i2, int i3) {
        if (this.f49980f) {
            this.f49979e.setVisibility(8);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i3 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = makeMeasureSpec;
        }
        return new int[]{i2, i3};
    }

    public void d(int i2) {
        if (this.f49981g) {
            return;
        }
        d.d(this.f49979e, i2);
    }

    public void e(boolean z) {
        this.f49981g = z;
    }

    public void f(boolean z) {
        this.f49982h = z;
    }

    @Override // d.a.i0.w.v.a
    public void handleHide() {
        this.f49980f = true;
    }

    @Override // d.a.i0.w.v.a
    public void handleShow() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // d.a.i0.w.v.a
    public boolean isVisible() {
        return !this.f49980f;
    }
}
