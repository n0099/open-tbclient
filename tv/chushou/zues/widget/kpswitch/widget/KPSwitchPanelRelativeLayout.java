package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes5.dex */
public class KPSwitchPanelRelativeLayout extends RelativeLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b nQC;

    public KPSwitchPanelRelativeLayout(Context context) {
        super(context);
        init(null);
    }

    public KPSwitchPanelRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public KPSwitchPanelRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    private void init(AttributeSet attributeSet) {
        this.nQC = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.nQC.eb(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] X = this.nQC.X(i, i2);
        super.onMeasure(X[0], X[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dSh() {
        return this.nQC.dSh();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.nQC.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Ql() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Qm() {
        this.nQC.Qm();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nQC.setIgnoreRecommendHeight(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void KK(int i) {
        this.nQC.KL(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wA(boolean z) {
        this.nQC.xr(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dSi() {
        return this.nQC.dSi();
    }

    public void setPanelEnabled(boolean z) {
        this.nQC.setPanelEnabled(z);
    }
}
