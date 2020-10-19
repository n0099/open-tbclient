package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private final View faK;
    private boolean faN;
    private int mMinHeight;
    private boolean cfr = false;
    private boolean poO = true;
    private final int[] poP = new int[2];
    private boolean faO = false;

    public b(View view, AttributeSet attributeSet) {
        this.faN = false;
        this.mMinHeight = 0;
        this.faK = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.faN = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean gT(int i) {
        if (i == 0) {
            this.cfr = false;
        }
        if (i == this.faK.getVisibility()) {
            return true;
        }
        return bvE() && i == 0;
    }

    public int[] aa(int i, int i2) {
        if (this.cfr) {
            this.faK.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.poP[0] = i;
        this.poP[1] = i2;
        return this.poP;
    }

    public void jL(boolean z) {
        this.faO = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean bvE() {
        return this.faO;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.cfr;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void aaW() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void aaX() {
        this.cfr = true;
    }

    public void qW(int i) {
        if (!this.faN) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.l(this.faK, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.faN = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eux() {
        return this.poO;
    }

    public void setPanelEnabled(boolean z) {
        this.poO = z;
    }
}
