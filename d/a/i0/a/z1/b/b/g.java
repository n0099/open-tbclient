package d.a.i0.a.z1.b.b;

import android.content.Context;
import android.widget.RelativeLayout;
import d.a.i0.a.z1.b.b.h;
/* loaded from: classes3.dex */
public class g extends h.a {

    /* renamed from: f  reason: collision with root package name */
    public Context f45914f;

    public g(Context context) {
        super(context);
        this.f45914f = context;
    }

    @Override // d.a.i0.a.z1.b.b.h.a
    public h c() {
        this.f45921e = this.f45914f.getResources().getDimensionPixelSize(d.a.i0.a.d.aiapps_action_sheet_list_item);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f45921e);
        layoutParams.addRule(12);
        this.f45917a.t.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f45914f.getResources().getDimensionPixelSize(d.a.i0.a.d.aiapps_action_sheet_bottom_divider));
        layoutParams2.addRule(2, this.f45917a.t.getId());
        this.f45917a.f45938h.setLayoutParams(layoutParams2);
        o(d.a.i0.a.c.aiapps_action_sheet_split_color);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(2, this.f45917a.f45938h.getId());
        this.f45917a.u.setLayoutParams(layoutParams3);
        return super.c();
    }
}
