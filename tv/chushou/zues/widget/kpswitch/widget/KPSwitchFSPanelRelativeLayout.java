package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.a;
import tv.chushou.zues.widget.kpswitch.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes4.dex */
public class KPSwitchFSPanelRelativeLayout extends RelativeLayout implements b {
    private a nYP;

    public KPSwitchFSPanelRelativeLayout(Context context) {
        super(context);
        init();
    }

    public KPSwitchFSPanelRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public KPSwitchFSPanelRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.nYP = new a(this);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void dv(int i) {
        e.f(this, i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wf(boolean z) {
        this.nYP.wf(z);
    }
}
