package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes5.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean nRO;
    private c nRP;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.nRO = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nRO = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nRO = true;
        init();
    }

    private void init() {
        this.nRP = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.nRO) {
            this.nRP.Y(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.nRP != null) {
            this.nRP.setIsTranslucentStatus(z);
        }
    }

    public void dSy() {
        if (this.nRP != null) {
            this.nRP.dSy();
        }
    }

    public void dED() {
        if (this.nRP != null) {
            this.nRP.dED();
        }
    }
}
