package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes6.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b owl;
    private boolean owm;

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
        this.owl = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void Mm(int i) {
        this.owl.Mn(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void xD(boolean z) {
        this.owl.yt(z);
        if (this.owm) {
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
        this.owm = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eaC() {
        return this.owl.eaC();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.owl.ep(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] Z = this.owl.Z(i, i2);
        super.onMeasure(Z[0], Z[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.owl.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void RG() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void RH() {
        this.owl.RH();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.owl.setIgnoreRecommendHeight(z);
    }

    public void setMinHeight(int i) {
        this.owl.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eaD() {
        return this.owl.eaD();
    }

    public void setPanelEnabled(boolean z) {
        this.owl.setPanelEnabled(z);
    }
}
