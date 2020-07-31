package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes6.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean owl;
    private c owm;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.owl = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.owl = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.owl = true;
        init();
    }

    private void init() {
        this.owm = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.owl) {
            this.owm.aa(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.owm != null) {
            this.owm.setIsTranslucentStatus(z);
        }
    }

    public void eaE() {
        if (this.owm != null) {
            this.owm.eaE();
        }
    }

    public void dME() {
        if (this.owm != null) {
            this.owm.dME();
        }
    }
}
