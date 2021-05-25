package d.a.l0.a.z1.b.b;

import android.content.Context;
import android.widget.RelativeLayout;
import d.a.l0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class g extends h.a {

    /* renamed from: f  reason: collision with root package name */
    public Context f46090f;

    public g(Context context) {
        super(context);
        this.f46090f = context;
    }

    @Override // d.a.l0.a.z1.b.b.h.a
    public h c() {
        this.f46097e = this.f46090f.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_action_sheet_list_item);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f46097e);
        layoutParams.addRule(12);
        this.f46093a.t.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f46090f.getResources().getDimensionPixelSize(d.a.l0.a.d.aiapps_action_sheet_bottom_divider));
        layoutParams2.addRule(2, this.f46093a.t.getId());
        this.f46093a.f46114h.setLayoutParams(layoutParams2);
        o(d.a.l0.a.c.aiapps_action_sheet_split_color);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(2, this.f46093a.f46114h.getId());
        this.f46093a.u.setLayoutParams(layoutParams3);
        return super.c();
    }
}
