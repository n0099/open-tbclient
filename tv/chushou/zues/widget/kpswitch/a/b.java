package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private final View fjj;
    private boolean fjm;
    private int mMinHeight;
    private boolean cnQ = false;
    private boolean qga = true;
    private final int[] qgb = new int[2];
    private boolean fjn = false;

    public b(View view, AttributeSet attributeSet) {
        this.fjm = false;
        this.mMinHeight = 0;
        this.fjj = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.fjm = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean he(int i) {
        if (i == 0) {
            this.cnQ = false;
        }
        if (i == this.fjj.getVisibility()) {
            return true;
        }
        return bxx() && i == 0;
    }

    public int[] ab(int i, int i2) {
        if (this.cnQ) {
            this.fjj.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.qgb[0] = i;
        this.qgb[1] = i2;
        return this.qgb;
    }

    public void jY(boolean z) {
        this.fjn = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean bxx() {
        return this.fjn;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.cnQ;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void acQ() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void acR() {
        this.cnQ = true;
    }

    public void rh(int i) {
        if (!this.fjm) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.l(this.fjj, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.fjm = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eEv() {
        return this.qga;
    }

    public void setPanelEnabled(boolean z) {
        this.qga = z;
    }
}
