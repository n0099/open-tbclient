package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes6.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b oZJ;
    private boolean oZK;

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
        this.oZJ = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void qx(int i) {
        this.oZJ.qy(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void jm(boolean z) {
        this.oZJ.jn(z);
        if (this.oZK) {
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
        this.oZK = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean bsU() {
        return this.oZJ.bsU();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.oZJ.gw(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] ab = this.oZJ.ab(i, i2);
        super.onMeasure(ab[0], ab[1]);
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

    public void setMinHeight(int i) {
        this.oZJ.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean eqM() {
        return this.oZJ.eqM();
    }

    public void setPanelEnabled(boolean z) {
        this.oZJ.setPanelEnabled(z);
    }
}
