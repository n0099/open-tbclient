package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes5.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b nvD;
    private boolean nvE;

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
        this.nvD = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void JZ(int i) {
        this.nvD.Ka(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wc(boolean z) {
        this.nvD.wU(z);
        if (this.nvE) {
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
        this.nvE = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dKq() {
        return this.nvD.dKq();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.nvD.dV(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] U = this.nvD.U(i, i2);
        super.onMeasure(U[0], U[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.nvD.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void NZ() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Oa() {
        this.nvD.Oa();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nvD.setIgnoreRecommendHeight(z);
    }

    public void setMinHeight(int i) {
        this.nvD.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dKr() {
        return this.nvD.dKr();
    }

    public void setPanelEnabled(boolean z) {
        this.nvD.setPanelEnabled(z);
    }
}
