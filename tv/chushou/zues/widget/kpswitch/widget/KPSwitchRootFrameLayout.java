package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes6.dex */
public class KPSwitchRootFrameLayout extends FrameLayout {
    public boolean owl;
    private c owm;

    public KPSwitchRootFrameLayout(Context context) {
        super(context);
        this.owl = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.owl = true;
        init();
    }

    public KPSwitchRootFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.owl = true;
        init();
    }

    private void init() {
        this.owm = new c(this);
    }

    @Override // android.widget.FrameLayout, android.view.View
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
}
