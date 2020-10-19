package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes6.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b ppf;

    public KPSwitchPanelFrameLayout(Context context) {
        super(context);
        init(null);
    }

    public KPSwitchPanelFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public KPSwitchPanelFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.ppf = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.ppf.gT(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] aa = this.ppf.aa(i, i2);
        super.onMeasure(aa[0], aa[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean bvE() {
        return this.ppf.bvE();
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

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void qV(int i) {
        this.ppf.qW(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void jK(boolean z) {
        this.ppf.jL(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eux() {
        return this.ppf.eux();
    }

    public void setPanelEnabled(boolean z) {
        this.ppf.setPanelEnabled(z);
    }
}
