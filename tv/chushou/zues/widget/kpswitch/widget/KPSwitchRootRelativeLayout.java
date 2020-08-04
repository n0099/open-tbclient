package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes6.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean own;
    private c owo;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.own = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.own = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.own = true;
        init();
    }

    private void init() {
        this.owo = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.own) {
            this.owo.aa(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.owo != null) {
            this.owo.setIsTranslucentStatus(z);
        }
    }

    public void eaF() {
        if (this.owo != null) {
            this.owo.eaF();
        }
    }

    public void dMF() {
        if (this.owo != null) {
            this.owo.dMF();
        }
    }
}
