package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View omZ;
    private boolean onc;
    private boolean bLh = false;
    private boolean ond = true;
    private final int[] onf = new int[2];
    private boolean ong = false;

    public b(View view, AttributeSet attributeSet) {
        this.onc = false;
        this.mMinHeight = 0;
        this.omZ = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.onc = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
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
        if (i == this.omZ.getVisibility()) {
            return true;
        }
        return dXf() && i == 0;
    }

    public int[] Z(int i, int i2) {
        if (this.bLh) {
            this.omZ.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.onf[0] = i;
        this.onf[1] = i2;
        return this.onf;
    }

    public void xO(boolean z) {
        this.ong = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dXf() {
        return this.ong;
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
        if (!this.onc) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.D(this.omZ, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.onc = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dXg() {
        return this.ond;
    }

    public void setPanelEnabled(boolean z) {
        this.ond = z;
    }
}
