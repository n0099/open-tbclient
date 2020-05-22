package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes5.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean nQE;
    private c nQF;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.nQE = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nQE = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nQE = true;
        init();
    }

    private void init() {
        this.nQF = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.nQE) {
            this.nQF.Y(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.nQF != null) {
            this.nQF.setIsTranslucentStatus(z);
        }
    }

    public void dSk() {
        if (this.nQF != null) {
            this.nQF.dSk();
        }
    }

    public void dEp() {
        if (this.nQF != null) {
            this.nQF.dEp();
        }
    }
}
