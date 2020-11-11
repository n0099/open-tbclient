package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes6.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean qpO;
    private c qpP;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.qpO = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qpO = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qpO = true;
        init();
    }

    private void init() {
        this.qpP = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.qpO) {
            this.qpP.ac(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.qpP != null) {
            this.qpP.setIsTranslucentStatus(z);
        }
    }

    public void eIl() {
        if (this.qpP != null) {
            this.qpP.eIl();
        }
    }

    public void euo() {
        if (this.qpP != null) {
            this.qpP.euo();
        }
    }
}
