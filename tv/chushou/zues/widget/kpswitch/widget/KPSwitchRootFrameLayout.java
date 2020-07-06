package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes5.dex */
public class KPSwitchRootFrameLayout extends FrameLayout {
    public boolean onG;
    private c onH;

    public KPSwitchRootFrameLayout(Context context) {
        super(context);
        this.onG = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onG = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.onG = true;
        init();
    }

    private void init() {
        this.onH = new c(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.onG) {
            this.onH.aa(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        }
        super.onMeasure(i, i2);
    }

    public void setIsTranslucentStatus(boolean z) {
        if (this.onH != null) {
            this.onH.setIsTranslucentStatus(z);
        }
    }
}
