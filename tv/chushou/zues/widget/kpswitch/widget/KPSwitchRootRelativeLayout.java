package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes5.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean nvI;
    private c nvJ;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.nvI = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nvI = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nvI = true;
        init();
    }

    private void init() {
        this.nvJ = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.nvI) {
            this.nvJ.V(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.nvJ != null) {
            this.nvJ.setIsTranslucentStatus(z);
        }
    }

    public void dKq() {
        if (this.nvJ != null) {
            this.nvJ.dKq();
        }
    }

    public void dwX() {
        if (this.nvJ != null) {
            this.nvJ.dwX();
        }
    }
}
