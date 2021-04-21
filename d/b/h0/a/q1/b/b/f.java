package d.b.h0.a.q1.b.b;

import android.content.Context;
import android.widget.RelativeLayout;
import d.b.h0.a.q1.b.b.g;
/* loaded from: classes3.dex */
public class f extends g.a {

    /* renamed from: f  reason: collision with root package name */
    public Context f46294f;

    public f(Context context) {
        super(context);
        this.f46294f = context;
    }

    @Override // d.b.h0.a.q1.b.b.g.a
    public g c() {
        this.f46301e = this.f46294f.getResources().getDimensionPixelSize(d.b.h0.a.d.aiapps_action_sheet_list_item);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f46301e);
        layoutParams.addRule(12);
        this.f46297a.u.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f46294f.getResources().getDimensionPixelSize(d.b.h0.a.d.aiapps_action_sheet_bottom_divider));
        layoutParams2.addRule(2, this.f46297a.u.getId());
        this.f46297a.f46318h.setLayoutParams(layoutParams2);
        o(d.b.h0.a.c.aiapps_action_sheet_split_color);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(2, this.f46297a.f46318h.getId());
        this.f46297a.o.setLayoutParams(layoutParams3);
        return super.c();
    }
}
