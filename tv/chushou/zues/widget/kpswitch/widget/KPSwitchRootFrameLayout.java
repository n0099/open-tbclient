package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes5.dex */
public class KPSwitchRootFrameLayout extends FrameLayout {
    public boolean onD;
    private c onE;

    public KPSwitchRootFrameLayout(Context context) {
        super(context);
        this.onD = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onD = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onD = true;
        init();
    }

    private void init() {
        this.onE = new c(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
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
}
