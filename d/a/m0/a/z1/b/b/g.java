package d.a.m0.a.z1.b.b;

import android.content.Context;
import android.widget.RelativeLayout;
import d.a.m0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class g extends h.a {

    /* renamed from: f  reason: collision with root package name */
    public Context f49872f;

    public g(Context context) {
        super(context);
        this.f49872f = context;
    }

    @Override // d.a.m0.a.z1.b.b.h.a
    public h c() {
        this.f49879e = this.f49872f.getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_action_sheet_list_item);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f49879e);
        layoutParams.addRule(12);
        this.f49875a.t.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f49872f.getResources().getDimensionPixelSize(d.a.m0.a.d.aiapps_action_sheet_bottom_divider));
        layoutParams2.addRule(2, this.f49875a.t.getId());
        this.f49875a.f49896h.setLayoutParams(layoutParams2);
        o(d.a.m0.a.c.aiapps_action_sheet_split_color);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(2, this.f49875a.f49896h.getId());
        this.f49875a.u.setLayoutParams(layoutParams3);
        return super.c();
    }
}
