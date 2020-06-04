package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes5.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b nRM;

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
        this.nRM = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.nRM.ed(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] X = this.nRM.X(i, i2);
        super.onMeasure(X[0], X[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dSv() {
        return this.nRM.dSv();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.nRM.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Ql() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Qm() {
        this.nRM.Qm();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nRM.setIgnoreRecommendHeight(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void KM(int i) {
        this.nRM.KN(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wC(boolean z) {
        this.nRM.xt(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dSw() {
        return this.nRM.dSw();
    }

    public void setPanelEnabled(boolean z) {
        this.nRM.setPanelEnabled(z);
    }
}
