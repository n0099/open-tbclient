package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes5.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b onB;
    private boolean onC;

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
        this.onB = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void LS(int i) {
        this.onB.LT(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wY(boolean z) {
        this.onB.xO(z);
        if (this.onC) {
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
        this.onC = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dXb() {
        return this.onB.dXb();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.onB.eo(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] Z = this.onB.Z(i, i2);
        super.onMeasure(Z[0], Z[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.onB.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Rr() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Rs() {
        this.onB.Rs();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.onB.setIgnoreRecommendHeight(z);
    }

    public void setMinHeight(int i) {
        this.onB.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dXc() {
        return this.onB.dXc();
    }

    public void setPanelEnabled(boolean z) {
        this.onB.setPanelEnabled(z);
    }
}
