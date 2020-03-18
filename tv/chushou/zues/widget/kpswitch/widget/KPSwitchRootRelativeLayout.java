package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes5.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean obH;
    private c obI;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.obH = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.obH = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.obH = true;
        init();
    }

    private void init() {
        this.obI = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.obH) {
            this.obI.T(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.obI != null) {
            this.obI.setIsTranslucentStatus(z);
        }
    }

    public void dRr() {
        if (this.obI != null) {
            this.obI.dRr();
        }
    }

    public void dCH() {
        if (this.obI != null) {
            this.obI.dCH();
        }
    }
}
