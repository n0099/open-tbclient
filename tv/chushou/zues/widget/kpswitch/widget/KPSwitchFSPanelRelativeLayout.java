package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import tv.chushou.zues.widget.kpswitch.a.a;
import tv.chushou.zues.widget.kpswitch.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes5.dex */
public class KPSwitchFSPanelRelativeLayout extends RelativeLayout implements b {
    private a nRL;

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
        this.nRL = new a(this);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void KM(int i) {
        e.D(this, i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void wC(boolean z) {
        this.nRL.wC(z);
    }
}
