package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes5.dex */
public class KPSwitchRootFrameLayout extends FrameLayout {
    public boolean nRO;
    private c nRP;

    public KPSwitchRootFrameLayout(Context context) {
        super(context);
        this.nRO = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nRO = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nRO = true;
        init();
    }

    private void init() {
        this.nRP = new c(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
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
}
