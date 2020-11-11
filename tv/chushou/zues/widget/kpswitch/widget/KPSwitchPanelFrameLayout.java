package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes6.dex */
public class KPSwitchPanelFrameLayout extends FrameLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b qpM;

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
        this.qpM = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.qpM.ho(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] ab = this.qpM.ab(i, i2);
        super.onMeasure(ab[0], ab[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean bzW() {
        return this.qpM.bzW();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.qpM.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void afq() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void afr() {
        this.qpM.afr();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.qpM.setIgnoreRecommendHeight(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void rq(int i) {
        this.qpM.rr(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void kg(boolean z) {
        this.qpM.kh(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eIk() {
        return this.qpM.eIk();
    }

    public void setPanelEnabled(boolean z) {
        this.qpM.setPanelEnabled(z);
    }
}
