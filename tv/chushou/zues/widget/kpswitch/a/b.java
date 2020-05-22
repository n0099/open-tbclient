package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View nPY;
    private boolean nQb;
    private boolean bGt = false;
    private boolean nQc = true;
    private final int[] nQd = new int[2];
    private boolean nQe = false;

    public b(View view, AttributeSet attributeSet) {
        this.nQb = false;
        this.mMinHeight = 0;
        this.nPY = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.nQb = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean eb(int i) {
        if (i == 0) {
            this.bGt = false;
        }
        if (i == this.nPY.getVisibility()) {
            return true;
        }
        return dSh() && i == 0;
    }

    public int[] X(int i, int i2) {
        if (this.bGt) {
            this.nPY.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.nQd[0] = i;
        this.nQd[1] = i2;
        return this.nQd;
    }

    public void xr(boolean z) {
        this.nQe = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dSh() {
        return this.nQe;
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

    public void KL(int i) {
        if (!this.nQb) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.D(this.nPY, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nQb = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dSi() {
        return this.nQc;
    }

    public void setPanelEnabled(boolean z) {
        this.nQc = z;
    }
}
