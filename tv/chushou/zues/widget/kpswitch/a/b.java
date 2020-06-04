package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View nRi;
    private boolean nRl;
    private boolean bGt = false;
    private boolean nRm = true;
    private final int[] nRn = new int[2];
    private boolean nRo = false;

    public b(View view, AttributeSet attributeSet) {
        this.nRl = false;
        this.mMinHeight = 0;
        this.nRi = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.nRl = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean ed(int i) {
        if (i == 0) {
            this.bGt = false;
        }
        if (i == this.nRi.getVisibility()) {
            return true;
        }
        return dSv() && i == 0;
    }

    public int[] X(int i, int i2) {
        if (this.bGt) {
            this.nRi.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.nRn[0] = i;
        this.nRn[1] = i2;
        return this.nRn;
    }

    public void xt(boolean z) {
        this.nRo = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dSv() {
        return this.nRo;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.bGt;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Ql() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Qm() {
        this.bGt = true;
    }

    public void KN(int i) {
        if (!this.nRl) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.D(this.nRi, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nRl = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dSw() {
        return this.nRm;
    }

    public void setPanelEnabled(boolean z) {
        this.nRm = z;
    }
}
