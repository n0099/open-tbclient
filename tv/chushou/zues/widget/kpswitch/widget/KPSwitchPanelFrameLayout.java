package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes5.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b onE;

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
        this.onE = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.onE.eo(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] Z = this.onE.Z(i, i2);
        super.onMeasure(Z[0], Z[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dXf() {
        return this.onE.dXf();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.onE.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Rr() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Rs() {
        this.onE.Rs();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.onE.setIgnoreRecommendHeight(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void LS(int i) {
        this.onE.LT(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wY(boolean z) {
        this.onE.xO(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dXg() {
        return this.onE.dXg();
    }

    public void setPanelEnabled(boolean z) {
        this.onE.setPanelEnabled(z);
    }
}
