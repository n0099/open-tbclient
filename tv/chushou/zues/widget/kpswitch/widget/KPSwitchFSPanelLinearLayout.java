package tv.chushou.zues.widget.kpswitch.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import tv.chushou.zues.widget.kpswitch.a.a;
import tv.chushou.zues.widget.kpswitch.b;
import tv.chushou.zues.widget.kpswitch.b.e;
/* loaded from: classes6.dex */
public class KPSwitchFSPanelLinearLayout extends LinearLayout implements b {
    private a qgq;

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
