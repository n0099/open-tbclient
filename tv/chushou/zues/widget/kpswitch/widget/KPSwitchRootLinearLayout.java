package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a.c;
/* loaded from: classes4.dex */
public class KPSwitchRootLinearLayout extends LinearLayout {
    public boolean nYS;
    private c nYT;

    public KPSwitchRootLinearLayout(Context context) {
        super(context);
        this.nYS = true;
        init();
    }

    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nYS = true;
        init();
    }

    @TargetApi(11)
    public KPSwitchRootLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nYS = true;
        init();
    }

    private void init() {
        this.nYT = new c(this);
    }

    @Override // android.widget.LinearLayout, android.view.View
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
