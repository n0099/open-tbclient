package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes5.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b nRM;
    private boolean nRN;

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
        this.nRM = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void KM(int i) {
        this.nRM.KN(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wC(boolean z) {
        this.nRM.xt(z);
        if (this.nRN) {
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
        this.nRN = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dSv() {
        return this.nRM.dSv();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.nRM.ed(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] X = this.nRM.X(i, i2);
        super.onMeasure(X[0], X[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.nRM.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Ql() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Qm() {
        this.nRM.Qm();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nRM.setIgnoreRecommendHeight(z);
    }

    public void setMinHeight(int i) {
        this.nRM.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dSw() {
        return this.nRM.dSw();
    }

    public void setPanelEnabled(boolean z) {
        this.nRM.setPanelEnabled(z);
    }
}
