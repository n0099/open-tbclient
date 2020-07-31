package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes6.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b owj;
    private boolean owk;

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
        this.owj = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void Mm(int i) {
        this.owj.Mn(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void xD(boolean z) {
        this.owj.yt(z);
        if (this.owk) {
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
        this.owk = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eaB() {
        return this.owj.eaB();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.owj.ep(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] Z = this.owj.Z(i, i2);
        super.onMeasure(Z[0], Z[1]);
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

    public void setMinHeight(int i) {
        this.owj.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eaC() {
        return this.owj.eaC();
    }

    public void setPanelEnabled(boolean z) {
        this.owj.setPanelEnabled(z);
    }
}
