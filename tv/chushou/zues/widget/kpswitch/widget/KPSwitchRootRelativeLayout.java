package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes6.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean pph;
    private c ppj;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.pph = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.pph = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pph = true;
        init();
    }

    private void init() {
        this.ppj = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.pph) {
            this.ppj.ab(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.ppj != null) {
            this.ppj.setIsTranslucentStatus(z);
        }
    }

    public void euy() {
        if (this.ppj != null) {
            this.ppj.euy();
        }
    }

    public void egz() {
        if (this.ppj != null) {
            this.ppj.egz();
        }
    }
}
