package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes5.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean nZI;
    private c nZJ;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.nZI = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nZI = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nZI = true;
        init();
    }

    private void init() {
        this.nZJ = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.nZI) {
            this.nZJ.T(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.nZJ != null) {
            this.nZJ.setIsTranslucentStatus(z);
        }
    }

    public void dQQ() {
        if (this.nZJ != null) {
            this.nZJ.dQQ();
        }
    }

    public void dCi() {
        if (this.nZJ != null) {
            this.nZJ.dCi();
        }
    }
}
