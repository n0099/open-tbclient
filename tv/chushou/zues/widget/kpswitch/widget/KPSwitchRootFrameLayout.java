package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes6.dex */
public class KPSwitchRootFrameLayout extends FrameLayout {
    public boolean oQe;
    private c oQf;

    public KPSwitchRootFrameLayout(Context context) {
        super(context);
        this.oQe = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.oQe = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oQe = true;
        init();
    }

    private void init() {
        this.oQf = new c(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.oQe) {
            this.oQf.ac(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.oQf != null) {
            this.oQf.setIsTranslucentStatus(z);
        }
    }
}
