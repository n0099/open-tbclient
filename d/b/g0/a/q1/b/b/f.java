package d.b.g0.a.q1.b.b;

import android.content.Context;
import android.widget.RelativeLayout;
import d.b.g0.a.q1.b.b.g;
/* loaded from: classes3.dex */
public class f extends g.a {

    /* renamed from: f  reason: collision with root package name */
    public Context f45965f;

    public f(Context context) {
        super(context);
        this.f45965f = context;
    }

    @Override // d.b.g0.a.q1.b.b.g.a
    public g c() {
        this.f45972e = this.f45965f.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_action_sheet_list_item);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f45972e);
        layoutParams.addRule(12);
        this.f45968a.u.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f45965f.getResources().getDimensionPixelSize(d.b.g0.a.d.aiapps_action_sheet_bottom_divider));
        layoutParams2.addRule(2, this.f45968a.u.getId());
        this.f45968a.f45989h.setLayoutParams(layoutParams2);
        o(d.b.g0.a.c.aiapps_action_sheet_split_color);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(2, this.f45968a.f45989h.getId());
        this.f45968a.o.setLayoutParams(layoutParams3);
        return super.c();
    }
}
