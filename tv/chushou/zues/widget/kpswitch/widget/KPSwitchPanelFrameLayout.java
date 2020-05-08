package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes5.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b nvG;

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
        this.nvG = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.nvG.dV(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] U = this.nvG.U(i, i2);
        super.onMeasure(U[0], U[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dKm() {
        return this.nvG.dKm();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.nvG.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void NY() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void NZ() {
        this.nvG.NZ();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nvG.setIgnoreRecommendHeight(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void JZ(int i) {
        this.nvG.Ka(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wc(boolean z) {
        this.nvG.wU(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dKn() {
        return this.nvG.dKn();
    }

    public void setPanelEnabled(boolean z) {
        this.nvG.setPanelEnabled(z);
    }
}
