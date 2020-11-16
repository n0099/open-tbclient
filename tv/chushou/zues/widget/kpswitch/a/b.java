package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private final View foi;
    private boolean fol;
    private int mMinHeight;
    private boolean csc = false;
    private boolean qqY = true;
    private final int[] qqZ = new int[2];
    private boolean fom = false;

    public b(View view, AttributeSet attributeSet) {
        this.fol = false;
        this.mMinHeight = 0;
        this.foi = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.fol = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean hk(int i) {
        if (i == 0) {
            this.csc = false;
        }
        if (i == this.foi.getVisibility()) {
            return true;
        }
        return bzm() && i == 0;
    }

    public int[] ab(int i, int i2) {
        if (this.csc) {
            this.foi.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.qqZ[0] = i;
        this.qqZ[1] = i2;
        return this.qqZ;
    }

    public void ki(boolean z) {
        this.fom = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean bzm() {
        return this.fom;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.csc;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void aeI() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void aeJ() {
        this.csc = true;
    }

    public void rP(int i) {
        if (!this.fol) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.o(this.foi, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fol = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eIl() {
        return this.qqY;
    }

    public void setPanelEnabled(boolean z) {
        this.qqY = z;
    }
}
