package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes4.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b nYQ;
    private boolean nYR;

    public KPSwitchPanelLinearLayout(Context context) {
        super(context);
        init(null);
    }

    public KPSwitchPanelLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    @TargetApi(11)
    public KPSwitchPanelLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.nYQ = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void dv(int i) {
        this.nYQ.Ou(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wf(boolean z) {
        this.nYQ.xe(z);
        if (this.nYR) {
            if (z) {
                super.setVisibility(4);
            } else if (super.getVisibility() != 0) {
                super.setVisibility(8);
            }
        } else if (z) {
            super.setVisibility(8);
        }
    }

    public void setUseStatusBar(boolean z) {
        this.nYR = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dPy() {
        return this.nYQ.dPy();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.nYQ.dx(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] S = this.nYQ.S(i, i2);
        super.onMeasure(S[0], S[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.nYQ.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void DQ() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void DR() {
        this.nYQ.DR();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nYQ.setIgnoreRecommendHeight(z);
    }

    public void setMinHeight(int i) {
        this.nYQ.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dPz() {
        return this.nYQ.dPz();
    }

    public void setPanelEnabled(boolean z) {
        this.nYQ.setPanelEnabled(z);
    }
}
