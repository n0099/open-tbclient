package tv.chushou.zues.widget.kpswitch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import tv.chushou.zues.widget.kpswitch.a.a;
import tv.chushou.zues.widget.kpswitch.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class KPSwitchFSPanelFrameLayout extends FrameLayout implements b {
    private a qro;

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
        this.qro = new a(this);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void rO(int i) {
        e.o(this, i);
    }

    @Override // tv.chushou.zues.widget.kpswitch.b
    public void kh(boolean z) {
        this.qro.kh(z);
    }
}
