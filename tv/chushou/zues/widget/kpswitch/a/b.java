package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes4.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View nYk;
    private boolean nYn;
    private boolean aVK = false;
    private boolean nYo = true;
    private final int[] nYp = new int[2];
    private boolean nYq = false;

    public b(View view, AttributeSet attributeSet) {
        this.nYn = false;
        this.mMinHeight = 0;
        this.nYk = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.nYn = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
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
        if (i == this.nYk.getVisibility()) {
            return true;
        }
        return dPw() && i == 0;
    }

    public int[] S(int i, int i2) {
        if (this.aVK) {
            this.nYk.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.nYp[0] = i;
        this.nYp[1] = i2;
        return this.nYp;
    }

    public void xe(boolean z) {
        this.nYq = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dPw() {
        return this.nYq;
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
        if (!this.nYn) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.f(this.nYk, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nYn = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dPx() {
        return this.nYo;
    }

    public void setPanelEnabled(boolean z) {
        this.nYo = z;
    }
}
