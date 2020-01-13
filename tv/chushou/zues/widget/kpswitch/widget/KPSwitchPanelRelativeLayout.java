package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes4.dex */
public class KPSwitchPanelRelativeLayout extends RelativeLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b nYL;

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
        this.nYL = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.nYL.dx(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] S = this.nYL.S(i, i2);
        super.onMeasure(S[0], S[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dPw() {
        return this.nYL.dPw();
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

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void dv(int i) {
        this.nYL.Ou(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wf(boolean z) {
        this.nYL.xe(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dPx() {
        return this.nYL.dPx();
    }

    public void setPanelEnabled(boolean z) {
        this.nYL.setPanelEnabled(z);
    }
}
