package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes6.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b oQc;
    private boolean oQd;

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
        this.oQc = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void OP(int i) {
        this.oQc.OQ(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void yu(boolean z) {
        this.oQc.zl(z);
        if (this.oQd) {
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
        this.oQd = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean emF() {
        return this.oQc.emF();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.oQc.gm(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] ab = this.oQc.ab(i, i2);
        super.onMeasure(ab[0], ab[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.oQc.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void XB() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void XC() {
        this.oQc.XC();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.oQc.setIgnoreRecommendHeight(z);
    }

    public void setMinHeight(int i) {
        this.oQc.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean emG() {
        return this.oQc.emG();
    }

    public void setPanelEnabled(boolean z) {
        this.oQc.setPanelEnabled(z);
    }
}
