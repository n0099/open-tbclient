package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private final View eOD;
    private boolean eOG;
    private int mMinHeight;
    private boolean bTd = false;
    private boolean oZs = true;
    private final int[] oZt = new int[2];
    private boolean eOH = false;

    public b(View view, AttributeSet attributeSet) {
        this.eOG = false;
        this.mMinHeight = 0;
        this.eOD = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.eOG = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean gw(int i) {
        if (i == 0) {
            this.bTd = false;
        }
        if (i == this.eOD.getVisibility()) {
            return true;
        }
        return bsU() && i == 0;
    }

    public int[] ab(int i, int i2) {
        if (this.bTd) {
            this.eOD.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.oZt[0] = i;
        this.oZt[1] = i2;
        return this.oZt;
    }

    public void jn(boolean z) {
        this.eOH = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean bsU() {
        return this.eOH;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.bTd;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Yk() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Yl() {
        this.bTd = true;
    }

    public void qy(int i) {
        if (!this.eOG) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.k(this.eOD, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.eOG = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eqM() {
        return this.oZs;
    }

    public void setPanelEnabled(boolean z) {
        this.oZs = z;
    }
}
