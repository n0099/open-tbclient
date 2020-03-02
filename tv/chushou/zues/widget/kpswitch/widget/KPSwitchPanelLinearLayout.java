package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a;
import tv.chushou.zues.widget.kpswitch.b;
/* loaded from: classes5.dex */
public class KPSwitchPanelLinearLayout extends LinearLayout implements a, b {
    private tv.chushou.zues.widget.kpswitch.a.b nZG;
    private boolean nZH;

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
        this.nZG = new tv.chushou.zues.widget.kpswitch.a.b(this, attributeSet);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void dL(int i) {
        this.nZG.Ox(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wj(boolean z) {
        this.nZG.xh(z);
        if (this.nZH) {
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
        this.nZH = z;
    }

    public void setDirectVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dQN() {
        return this.nZG.dQN();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (!this.nZG.dN(i)) {
            super.setVisibility(i);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int[] S = this.nZG.S(i, i2);
        super.onMeasure(S[0], S[1]);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean isVisible() {
        return this.nZG.isVisible();
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Gh() {
        super.setVisibility(0);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public void Gi() {
        this.nZG.Gi();
    }

    public void setIgnoreRecommendHeight(boolean z) {
        this.nZG.setIgnoreRecommendHeight(z);
    }

    public void setMinHeight(int i) {
        this.nZG.setMinHeight(i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.a
    public boolean dQO() {
        return this.nZG.dQO();
    }

    public void setPanelEnabled(boolean z) {
        this.nZG.setPanelEnabled(z);
    }
}
