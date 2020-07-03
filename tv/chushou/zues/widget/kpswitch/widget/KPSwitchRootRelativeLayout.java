package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes5.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean onD;
    private c onE;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.onD = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onD = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onD = true;
        init();
    }

    private void init() {
        this.onE = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.onD) {
            this.onE.aa(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.onE != null) {
            this.onE.setIsTranslucentStatus(z);
        }
    }

    public void dXe() {
        if (this.onE != null) {
            this.onE.dXe();
        }
    }

    public void dJf() {
        if (this.onE != null) {
            this.onE.dJf();
        }
    }
}
