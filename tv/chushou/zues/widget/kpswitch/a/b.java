package tv.chushou.zues.widget.kpswitch.a;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import tv.chushou.zues.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class b implements tv.chushou.zues.widget.kpswitch.a {
    private int mMinHeight;
    private final View nZf;
    private boolean nZi;
    private boolean aZX = false;
    private boolean nZj = true;
    private final int[] nZk = new int[2];
    private boolean nZl = false;

    public b(View view, AttributeSet attributeSet) {
        this.nZi = false;
        this.mMinHeight = 0;
        this.nZf = view;
        if (attributeSet != null) {
            TypedArray typedArray = null;
            try {
                typedArray = view.getContext().obtainStyledAttributes(attributeSet, b.i.KPSwitchPanelLayout);
                this.nZi = typedArray.getBoolean(b.i.KPSwitchPanelLayout_ignore_recommend_height, false);
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
            this.aZX = false;
        }
        if (i == this.nZf.getVisibility()) {
            return true;
        }
        return dQN() && i == 0;
    }

    public int[] S(int i, int i2) {
        if (this.aZX) {
            this.nZf.setVisibility(8);
            i = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        }
        this.nZk[0] = i;
        this.nZk[1] = i2;
        return this.nZk;
    }

    public void xh(boolean z) {
        this.nZl = z;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dQN() {
        return this.nZl;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return !this.aZX;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Gh() {
        throw new IllegalAccessError("You can't invoke handle show in handler, please instead of handling in the panel layout, maybe just need invoke super.setVisibility(View.VISIBLE)");
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Gi() {
        this.aZX = true;
    }

    public void Ox(int i) {
        if (!this.nZi) {
            if (i < this.mMinHeight) {
                i = this.mMinHeight;
            }
            e.f(this.nZf, i);
        }
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nZi = z;
    }

    public void setMinHeight(int i) {
        this.mMinHeight = i;
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dQO() {
        return this.nZj;
    }

    public void setPanelEnabled(boolean z) {
        this.nZj = z;
    }
}
