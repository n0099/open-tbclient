package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View oPQ;
    private boolean oPT;
    private boolean bRd = false;
    private boolean oPU = true;
    private final int[] oPV = new int[2];
    private boolean oPW = false;

    public b(View view, AttributeSet attributeSet) {
        this.oPT = false;
        this.mMinHeight = 0;
        this.oPQ = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.oPT = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean gm(int i) {
        if (i == 0) {
            this.bRd = false;
        }
        if (i == this.oPQ.getVisibility()) {
            return true;
        }
        return emO() && i == 0;
    }

    public int[] ab(int i, int i2) {
        if (this.bRd) {
            this.oPQ.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.oPV[0] = i;
        this.oPV[1] = i2;
        return this.oPV;
    }

    public void zn(boolean z) {
        this.oPW = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean emO() {
        return this.oPW;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.bRd;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void XB() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void XC() {
        this.bRd = true;
    }

    public void OQ(int i) {
        if (!this.oPT) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.E(this.oPQ, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.oPT = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean emP() {
        return this.oPU;
    }

    public void setPanelEnabled(boolean z) {
        this.oPU = z;
    }
}
