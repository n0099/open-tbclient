package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a.a;
import tv.chushou.zues.widget.kpswitch.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class KPSwitchFSPanelFrameLayout extends FrameLayout implements b {
    private a qgq;

    public KPSwitchFSPanelFrameLayout(Context context) {
        super(context);
        init();
    }

    public KPSwitchFSPanelFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public KPSwitchFSPanelFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.qgq = new a(this);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void rg(int i) {
        e.l(this, i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void jX(boolean z) {
        this.qgq.jX(z);
    }
}
