package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.a;
import tv.chushou.zues.widget.kpswitch.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class KPSwitchFSPanelRelativeLayout extends RelativeLayout implements b {
    private a nvC;

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
        this.nvC = new a(this);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void JZ(int i) {
        e.D(this, i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wc(boolean z) {
        this.nvC.wc(z);
    }
}
