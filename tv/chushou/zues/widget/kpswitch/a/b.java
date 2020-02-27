package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View nZd;
    private boolean nZg;
    private boolean aZW = false;
    private boolean nZh = true;
    private final int[] nZi = new int[2];
    private boolean nZj = false;

    public b(View view, AttributeSet attributeSet) {
        this.nZg = false;
        this.mMinHeight = 0;
        this.nZd = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.nZg = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
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
            this.aZW = false;
        }
        if (i == this.nZd.getVisibility()) {
            return true;
        }
        return dQL() && i == 0;
    }

    public int[] S(int i, int i2) {
        if (this.aZW) {
            this.nZd.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.nZi[0] = i;
        this.nZi[1] = i2;
        return this.nZi;
    }

    public void xh(boolean z) {
        this.nZj = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dQL() {
        return this.nZj;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.aZW;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Gf() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Gg() {
        this.aZW = true;
    }

    public void Ox(int i) {
        if (!this.nZg) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.f(this.nZd, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nZg = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dQM() {
        return this.nZh;
    }

    public void setPanelEnabled(boolean z) {
        this.nZh = z;
    }
}
