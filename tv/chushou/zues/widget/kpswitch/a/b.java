package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View ovH;
    private boolean ovK;
    private boolean bLD = false;
    private boolean ovL = true;
    private final int[] ovM = new int[2];
    private boolean ovN = false;

    public b(View view, AttributeSet attributeSet) {
        this.ovK = false;
        this.mMinHeight = 0;
        this.ovH = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.ovK = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean ep(int i) {
        if (i == 0) {
            this.bLD = false;
        }
        if (i == this.ovH.getVisibility()) {
            return true;
        }
        return eaC() && i == 0;
    }

    public int[] Z(int i, int i2) {
        if (this.bLD) {
            this.ovH.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.ovM[0] = i;
        this.ovM[1] = i2;
        return this.ovM;
    }

    public void yt(boolean z) {
        this.ovN = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eaC() {
        return this.ovN;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.bLD;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void RG() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void RH() {
        this.bLD = true;
    }

    public void Mn(int i) {
        if (!this.ovK) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.E(this.ovH, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.ovK = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eaD() {
        return this.ovL;
    }

    public void setPanelEnabled(boolean z) {
        this.ovL = z;
    }
}
