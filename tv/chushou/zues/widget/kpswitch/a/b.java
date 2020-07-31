package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View ovF;
    private boolean ovI;
    private boolean bLD = false;
    private boolean ovJ = true;
    private final int[] ovK = new int[2];
    private boolean ovL = false;

    public b(View view, AttributeSet attributeSet) {
        this.ovI = false;
        this.mMinHeight = 0;
        this.ovF = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.ovI = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
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
        if (i == this.ovF.getVisibility()) {
            return true;
        }
        return eaB() && i == 0;
    }

    public int[] Z(int i, int i2) {
        if (this.bLD) {
            this.ovF.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.ovK[0] = i;
        this.ovK[1] = i2;
        return this.ovK;
    }

    public void yt(boolean z) {
        this.ovL = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eaB() {
        return this.ovL;
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
        if (!this.ovI) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.E(this.ovF, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.ovI = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eaC() {
        return this.ovJ;
    }

    public void setPanelEnabled(boolean z) {
        this.ovJ = z;
    }
}
