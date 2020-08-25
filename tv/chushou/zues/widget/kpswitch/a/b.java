package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private boolean oPB;
    private final View oPy;
    private boolean bQZ = false;
    private boolean oPC = true;
    private final int[] oPD = new int[2];
    private boolean oPE = false;

    public b(View view, AttributeSet attributeSet) {
        this.oPB = false;
        this.mMinHeight = 0;
        this.oPy = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.oPB = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
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
            this.bQZ = false;
        }
        if (i == this.oPy.getVisibility()) {
            return true;
        }
        return emF() && i == 0;
    }

    public int[] ab(int i, int i2) {
        if (this.bQZ) {
            this.oPy.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.oPD[0] = i;
        this.oPD[1] = i2;
        return this.oPD;
    }

    public void zl(boolean z) {
        this.oPE = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean emF() {
        return this.oPE;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.bQZ;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void XB() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void XC() {
        this.bQZ = true;
    }

    public void OQ(int i) {
        if (!this.oPB) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.E(this.oPy, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.oPB = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean emG() {
        return this.oPC;
    }

    public void setPanelEnabled(boolean z) {
        this.oPC = z;
    }
}
