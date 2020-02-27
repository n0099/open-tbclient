package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes5.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean nZG;
    private c nZH;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.nZG = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nZG = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nZG = true;
        init();
    }

    private void init() {
        this.nZH = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.nZG) {
            this.nZH.T(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.nZH != null) {
            this.nZH.setIsTranslucentStatus(z);
        }
    }

    public void dQO() {
        if (this.nZH != null) {
            this.nZH.dQO();
        }
    }

    public void dCg() {
        if (this.nZH != null) {
            this.nZH.dCg();
        }
    }
}
