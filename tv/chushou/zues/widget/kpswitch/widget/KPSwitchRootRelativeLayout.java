package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes6.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean qrr;
    private c qrs;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.qrr = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qrr = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qrr = true;
        init();
    }

    private void init() {
        this.qrs = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.qrr) {
            this.qrs.ac(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.qrs != null) {
            this.qrs.setIsTranslucentStatus(z);
        }
    }

    public void eIm() {
        if (this.qrs != null) {
            this.qrs.eIm();
        }
    }

    public void euo() {
        if (this.qrs != null) {
            this.qrs.euo();
        }
    }
}
