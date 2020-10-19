package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes6.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b ppf;
    private boolean ppg;

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
        this.ppf = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void qV(int i) {
        this.ppf.qW(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void jK(boolean z) {
        this.ppf.jL(z);
        if (this.ppg) {
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
        this.ppg = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean bvE() {
        return this.ppf.bvE();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.ppf.gT(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] aa = this.ppf.aa(i, i2);
        super.onMeasure(aa[0], aa[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.ppf.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void aaW() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void aaX() {
        this.ppf.aaX();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.ppf.setIgnoreRecommendHeight(z);
    }

    public void setMinHeight(int i) {
        this.ppf.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eux() {
        return this.ppf.eux();
    }

    public void setPanelEnabled(boolean z) {
        this.ppf.setPanelEnabled(z);
    }
}
