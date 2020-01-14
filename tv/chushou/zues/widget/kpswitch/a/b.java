package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes4.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View nYp;
    private boolean nYs;
    private boolean aVK = false;
    private boolean nYt = true;
    private final int[] nYu = new int[2];
    private boolean nYv = false;

    public b(View view, AttributeSet attributeSet) {
        this.nYs = false;
        this.mMinHeight = 0;
        this.nYp = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.nYs = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean dx(int i) {
        if (i == 0) {
            this.aVK = false;
        }
        if (i == this.nYp.getVisibility()) {
            return true;
        }
        return dPy() && i == 0;
    }

    public int[] S(int i, int i2) {
        if (this.aVK) {
            this.nYp.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.nYu[0] = i;
        this.nYu[1] = i2;
        return this.nYu;
    }

    public void xe(boolean z) {
        this.nYv = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dPy() {
        return this.nYv;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.aVK;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void DQ() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void DR() {
        this.aVK = true;
    }

    public void Ou(int i) {
        if (!this.nYs) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.f(this.nYp, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nYs = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dPz() {
        return this.nYt;
    }

    public void setPanelEnabled(boolean z) {
        this.nYt = z;
    }
}
