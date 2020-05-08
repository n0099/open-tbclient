package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a.a;
import tv.chushou.zues.widget.kpswitch.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class KPSwitchFSPanelLinearLayout extends LinearLayout implements b {
    private a nvF;

    public KPSwitchFSPanelLinearLayout(Context context) {
        super(context);
        init();
    }

    public KPSwitchFSPanelLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @TargetApi(11)
    public KPSwitchFSPanelLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.nvF = new a(this);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void JZ(int i) {
        e.D(this, i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wc(boolean z) {
        this.nvF.wc(z);
    }
}
