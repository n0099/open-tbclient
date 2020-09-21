package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes6.dex */
public class KPSwitchPanelRelativeLayout extends RelativeLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b oZJ;

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
        this.oZJ = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.oZJ.gw(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] ab = this.oZJ.ab(i, i2);
        super.onMeasure(ab[0], ab[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean bsU() {
        return this.oZJ.bsU();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.oZJ.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Yk() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Yl() {
        this.oZJ.Yl();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.oZJ.setIgnoreRecommendHeight(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void qx(int i) {
        this.oZJ.qy(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void jm(boolean z) {
        this.oZJ.jn(z);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eqM() {
        return this.oZJ.eqM();
    }

    public void setPanelEnabled(boolean z) {
        this.oZJ.setPanelEnabled(z);
    }
}
