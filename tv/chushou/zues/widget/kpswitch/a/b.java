package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View nvc;
    private boolean nvf;
    private boolean byQ = false;
    private boolean nvg = true;
    private final int[] nvh = new int[2];
    private boolean nvi = false;

    public b(View view, AttributeSet attributeSet) {
        this.nvf = false;
        this.mMinHeight = 0;
        this.nvc = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.nvf = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
                this.mMinHeight = (int) typedArray.getDimension(b.i.KPSwitchPanelLayout_min_height, 0.0f);
            } finally {
                if (typedArray != null) {
                    typedArray.recycle();
                }
            }
        }
    }

    public boolean dV(int i) {
        if (i == 0) {
            this.byQ = false;
        }
        if (i == this.nvc.getVisibility()) {
            return true;
        }
        return dKm() && i == 0;
    }

    public int[] U(int i, int i2) {
        if (this.byQ) {
            this.nvc.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.nvh[0] = i;
        this.nvh[1] = i2;
        return this.nvh;
    }

    public void wU(boolean z) {
        this.nvi = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dKm() {
        return this.nvi;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.byQ;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void NY() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void NZ() {
        this.byQ = true;
    }

    public void Ka(int i) {
        if (!this.nvf) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.D(this.nvc, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nvf = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dKn() {
        return this.nvg;
    }

    public void setPanelEnabled(boolean z) {
        this.nvg = z;
    }
}
