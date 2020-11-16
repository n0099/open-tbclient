package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes6.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b qrp;
    private boolean qrq;

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
        this.qrp = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void rO(int i) {
        this.qrp.rP(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void kh(boolean z) {
        this.qrp.ki(z);
        if (this.qrq) {
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
        this.qrq = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean bzm() {
        return this.qrp.bzm();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.qrp.hk(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] ab = this.qrp.ab(i, i2);
        super.onMeasure(ab[0], ab[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.qrp.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void aeI() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void aeJ() {
        this.qrp.aeJ();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.qrp.setIgnoreRecommendHeight(z);
    }

    public void setMinHeight(int i) {
        this.qrp.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eIl() {
        return this.qrp.eIl();
    }

    public void setPanelEnabled(boolean z) {
        this.qrp.setPanelEnabled(z);
    }
}
