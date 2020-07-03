package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View omW;
    private boolean omZ;
    private boolean bLh = false;
    private boolean ona = true;
    private final int[] onb = new int[2];
    private boolean onc = false;

    public b(View view, AttributeSet attributeSet) {
        this.omZ = false;
        this.mMinHeight = 0;
        this.omW = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.omZ = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean eo(int i) {
        if (i == 0) {
            this.bLh = false;
        }
        if (i == this.omW.getVisibility()) {
            return true;
        }
        return dXb() && i == 0;
    }

    public int[] Z(int i, int i2) {
        if (this.bLh) {
            this.omW.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.onb[0] = i;
        this.onb[1] = i2;
        return this.onb;
    }

    public void xO(boolean z) {
        this.onc = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dXb() {
        return this.onc;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.bLh;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Rr() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Rs() {
        this.bLh = true;
    }

    public void LT(int i) {
        if (!this.omZ) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.D(this.omW, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.omZ = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dXc() {
        return this.ona;
    }

    public void setPanelEnabled(boolean z) {
        this.ona = z;
    }
}
