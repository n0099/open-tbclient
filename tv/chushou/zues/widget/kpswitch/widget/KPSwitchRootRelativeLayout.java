package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes5.dex */
public class KPSwitchRootRelativeLayout extends RelativeLayout {
    public boolean nvF;
    private c nvG;

    public KPSwitchRootRelativeLayout(Context context) {
        super(context);
        this.nvF = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nvF = true;
        init();
    }

    public KPSwitchRootRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nvF = true;
        init();
    }

    private void init() {
        this.nvG = new c(this);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.nvF) {
            this.nvG.V(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.nvG != null) {
            this.nvG.setIsTranslucentStatus(z);
        }
    }

    public void dKt() {
        if (this.nvG != null) {
            this.nvG.dKt();
        }
    }

    public void dwZ() {
        if (this.nvG != null) {
            this.nvG.dwZ();
        }
    }
}
