package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes4.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b nYL;
    private boolean nYM;

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
        this.nYL = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void dv(int i) {
        this.nYL.Ou(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wf(boolean z) {
        this.nYL.xe(z);
        if (this.nYM) {
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
        this.nYM = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dPw() {
        return this.nYL.dPw();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.nYL.dx(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] S = this.nYL.S(i, i2);
        super.onMeasure(S[0], S[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.nYL.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void DQ() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void DR() {
        this.nYL.DR();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nYL.setIgnoreRecommendHeight(z);
    }

    public void setMinHeight(int i) {
        this.nYL.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dPx() {
        return this.nYL.dPx();
    }

    public void setPanelEnabled(boolean z) {
        this.nYL.setPanelEnabled(z);
    }
}
