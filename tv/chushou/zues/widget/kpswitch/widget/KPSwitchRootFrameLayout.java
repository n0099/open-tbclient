package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes4.dex */
public class KPSwitchRootFrameLayout extends FrameLayout {
    public boolean nYS;
    private c nYT;

    public KPSwitchRootFrameLayout(Context context) {
        super(context);
        this.nYS = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nYS = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nYS = true;
        init();
    }

    private void init() {
        this.nYT = new c(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.nYS) {
            this.nYT.T(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.nYT != null) {
            this.nYT.setIsTranslucentStatus(z);
        }
    }
}
