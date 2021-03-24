package d.b.h0.w.v.c;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R$styleable;
import d.b.h0.w.v.d.d;
/* loaded from: classes3.dex */
public class b implements d.b.h0.w.v.a {

    /* renamed from: e  reason: collision with root package name */
    public final View f51552e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f51554g;

    /* renamed from: f  reason: collision with root package name */
    public boolean f51553f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f51555h = false;

    public b(View view, AttributeSet attributeSet) {
        this.f51554g = false;
        this.f51552e = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.KPSwitchPanelLayout);
                this.f51554g = typedArray.getBoolean(R$styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean a(int i) {
        if (i == 0) {
            this.f51553f = false;
        }
        if (i == this.f51552e.getVisibility()) {
            return true;
        }
        return b() && i == 0;
    }

    @Override // d.b.h0.w.v.a
    public boolean b() {
        return this.f51555h;
    }

    public int[] c(int i, int i2) {
        if (this.f51553f) {
            this.f51552e.setVisibility(8);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i = makeMeasureSpec;
        }
        return new int[]{i, i2};
    }

    public void d(int i) {
        if (this.f51554g) {
            return;
        }
        d.d(this.f51552e, i);
    }

    public void e(boolean z) {
        this.f51554g = z;
    }

    public void f(boolean z) {
        this.f51555h = z;
    }

    @Override // d.b.h0.w.v.a
    public void handleHide() {
        this.f51553f = true;
    }

    @Override // d.b.h0.w.v.a
    public void handleShow() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // d.b.h0.w.v.a
    public boolean isVisible() {
        return !this.f51553f;
    }
}
