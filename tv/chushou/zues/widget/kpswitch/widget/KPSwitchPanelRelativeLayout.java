package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes6.dex */
public class KPSwitchPanelRelativeLayout extends RelativeLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b owj;

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
        this.owj = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.owj.ep(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] Z = this.owj.Z(i, i2);
        super.onMeasure(Z[0], Z[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eaB() {
        return this.owj.eaB();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.owj.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void RG() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void RH() {
        this.owj.RH();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.owj.setIgnoreRecommendHeight(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void Mm(int i) {
        this.owj.Mn(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void xD(boolean z) {
        this.owj.yt(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eaC() {
        return this.owj.eaC();
    }

    public void setPanelEnabled(boolean z) {
        this.owj.setPanelEnabled(z);
    }
}
