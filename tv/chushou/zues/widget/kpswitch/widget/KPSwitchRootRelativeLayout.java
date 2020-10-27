package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes6.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean qgt;
    private c qgu;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.qgt = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qgt = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qgt = true;
        init();
    }

    private void init() {
        this.qgu = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.qgt) {
            this.qgu.ac(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.qgu != null) {
            this.qgu.setIsTranslucentStatus(z);
        }
    }

    public void eEw() {
        if (this.qgu != null) {
            this.qgu.eEw();
        }
    }

    public void eqz() {
        if (this.qgu != null) {
            this.qgu.eqz();
        }
    }
}
