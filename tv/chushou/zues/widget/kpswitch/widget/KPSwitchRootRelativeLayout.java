package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes4.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean nYN;
    private c nYO;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.nYN = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nYN = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nYN = true;
        init();
    }

    private void init() {
        this.nYO = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.nYN) {
            this.nYO.T(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.nYO != null) {
            this.nYO.setIsTranslucentStatus(z);
        }
    }

    public void dPz() {
        if (this.nYO != null) {
            this.nYO.dPz();
        }
    }

    public void dAY() {
        if (this.nYO != null) {
            this.nYO.dAY();
        }
    }
}
