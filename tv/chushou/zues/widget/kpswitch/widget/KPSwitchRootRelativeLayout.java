package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes6.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean oZL;
    private c oZM;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.oZL = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oZL = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oZL = true;
        init();
    }

    private void init() {
        this.oZM = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.oZL) {
            this.oZM.ac(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.oZM != null) {
            this.oZM.setIsTranslucentStatus(z);
        }
    }

    public void eqN() {
        if (this.oZM != null) {
            this.oZM.eqN();
        }
    }

    public void ecO() {
        if (this.oZM != null) {
            this.oZM.ecO();
        }
    }
}
