package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View obd;
    private boolean obg;
    private boolean bal = false;
    private boolean obh = true;
    private final int[] obi = new int[2];
    private boolean obk = false;

    public b(View view, AttributeSet attributeSet) {
        this.obg = false;
        this.mMinHeight = 0;
        this.obd = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.obg = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean dN(int i) {
        if (i == 0) {
            this.bal = false;
        }
        if (i == this.obd.getVisibility()) {
            return true;
        }
        return dRo() && i == 0;
    }

    public int[] S(int i, int i2) {
        if (this.bal) {
            this.obd.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.obi[0] = i;
        this.obi[1] = i2;
        return this.obi;
    }

    public void xp(boolean z) {
        this.obk = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dRo() {
        return this.obk;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.bal;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Gm() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Gn() {
        this.bal = true;
    }

    public void OD(int i) {
        if (!this.obg) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.f(this.obd, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.obg = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dRp() {
        return this.obh;
    }

    public void setPanelEnabled(boolean z) {
        this.obh = z;
    }
}
