package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View nZq;
    private boolean nZt;
    private boolean aZY = false;
    private boolean nZu = true;
    private final int[] nZv = new int[2];
    private boolean nZw = false;

    public b(View view, AttributeSet attributeSet) {
        this.nZt = false;
        this.mMinHeight = 0;
        this.nZq = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.nZt = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
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
            this.aZY = false;
        }
        if (i == this.nZq.getVisibility()) {
            return true;
        }
        return dQO() && i == 0;
    }

    public int[] S(int i, int i2) {
        if (this.aZY) {
            this.nZq.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.nZv[0] = i;
        this.nZv[1] = i2;
        return this.nZv;
    }

    public void xh(boolean z) {
        this.nZw = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dQO() {
        return this.nZw;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.aZY;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Gh() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Gi() {
        this.aZY = true;
    }

    public void Ox(int i) {
        if (!this.nZt) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.f(this.nZq, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nZt = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dQP() {
        return this.nZu;
    }

    public void setPanelEnabled(boolean z) {
        this.nZu = z;
    }
}
