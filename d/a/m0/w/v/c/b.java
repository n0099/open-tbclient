package d.a.m0.w.v.c;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R$styleable;
import d.a.m0.w.v.d.d;
/* loaded from: classes3.dex */
public class b implements d.a.m0.w.v.a {

    /* renamed from: e  reason: collision with root package name */
    public final View f54548e;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54550g;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54549f = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54551h = false;

    public b(View view, AttributeSet attributeSet) {
        this.f54550g = false;
        this.f54548e = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, R$styleable.KPSwitchPanelLayout);
                this.f54550g = typedArray.getBoolean(R$styleable.KPSwitchPanelLayout_ignore_recommend_height, false);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean a(int i2) {
        if (i2 == 0) {
            this.f54549f = false;
        }
        if (i2 == this.f54548e.getVisibility()) {
            return true;
        }
        return b() && i2 == 0;
    }

    @Override // d.a.m0.w.v.a
    public boolean b() {
        return this.f54551h;
    }

    public int[] c(int i2, int i3) {
        if (this.f54549f) {
            this.f54548e.setVisibility(8);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i3 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = makeMeasureSpec;
        }
        return new int[]{i2, i3};
    }

    public void d(int i2) {
        if (this.f54550g) {
            return;
        }
        d.d(this.f54548e, i2);
    }

    public void e(boolean z) {
        this.f54550g = z;
    }

    public void f(boolean z) {
        this.f54551h = z;
    }

    @Override // d.a.m0.w.v.a
    public void handleHide() {
        this.f54549f = true;
    }

    @Override // d.a.m0.w.v.a
    public void handleShow() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // d.a.m0.w.v.a
    public boolean isVisible() {
        return !this.f54549f;
    }
}
