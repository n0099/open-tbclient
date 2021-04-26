package d.a.h0.a.q1.b.b;

import android.content.Context;
import android.widget.RelativeLayout;
import d.a.h0.a.q1.b.b.g;
/* loaded from: classes3.dex */
public class f extends g.a {

    /* renamed from: f  reason: collision with root package name */
    public Context f43647f;

    public f(Context context) {
        super(context);
        this.f43647f = context;
    }

    @Override // d.a.h0.a.q1.b.b.g.a
    public g c() {
        this.f43654e = this.f43647f.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_action_sheet_list_item);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.f43654e);
        layoutParams.addRule(12);
        this.f43650a.u.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, this.f43647f.getResources().getDimensionPixelSize(d.a.h0.a.d.aiapps_action_sheet_bottom_divider));
        layoutParams2.addRule(2, this.f43650a.u.getId());
        this.f43650a.f43671h.setLayoutParams(layoutParams2);
        o(d.a.h0.a.c.aiapps_action_sheet_split_color);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(2, this.f43650a.f43671h.getId());
        this.f43650a.o.setLayoutParams(layoutParams3);
        return super.c();
    }
}
