package d.a.k0.h3;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tblauncherInterestGuide.data.InterestFrsData;
import d.a.c.e.m.g;
/* loaded from: classes5.dex */
public class d extends Dialog implements a {

    /* renamed from: e  reason: collision with root package name */
    public Context f55596e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55597f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55598g;

    /* renamed from: h  reason: collision with root package name */
    public View f55599h;

    /* renamed from: i  reason: collision with root package name */
    public View f55600i;
    public InterestFrsData.Tag j;
    public c k;
    public GridView l;
    public LinearLayout m;

    public d(Context context, int i2) {
        super(context, i2);
        this.f55596e = context;
        e();
    }

    @Override // d.a.k0.h3.a
    public void a(int i2) {
        this.k.notifyDataSetChanged();
    }

    @Override // d.a.k0.h3.a
    public void b(int i2) {
        this.k.notifyDataSetChanged();
    }

    @Override // d.a.k0.h3.a
    public void c(InterestFrsData.Tag tag) {
        this.j = tag;
        if (tag != null) {
            this.f55597f.setText(tag.getBname());
            this.f55598g.setText(tag.getBdesc());
            this.k.a(tag.getCard_list());
        }
    }

    @Override // d.a.k0.h3.a
    public void d(View.OnClickListener onClickListener) {
        this.m.setOnClickListener(onClickListener);
        this.k.c(onClickListener);
    }

    public final void e() {
        this.f55600i = View.inflate(this.f55596e, R.layout.new_user_img_box, null);
        this.k = new c(this.f55596e);
        setCanceledOnTouchOutside(true);
        this.m = (LinearLayout) this.f55600i.findViewById(R.id.box_close_layout);
        GridView gridView = (GridView) this.f55600i.findViewById(R.id.layout_content);
        this.l = gridView;
        gridView.setAdapter((ListAdapter) this.k);
        this.l.setSelector(R.color.common_color_10022);
        setContentView(this.f55600i);
        this.f55597f = (TextView) this.f55600i.findViewById(R.id.prompt_title);
        this.f55598g = (TextView) this.f55600i.findViewById(R.id.prompt_sub_title);
        View findViewById = this.f55600i.findViewById(R.id.view_layout);
        this.f55599h = findViewById;
        findViewById.setBackgroundDrawable(this.f55596e.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // d.a.k0.h3.a
    public View getRootView() {
        return this.f55600i;
    }

    @Override // android.app.Dialog, d.a.k0.h3.a
    public void hide() {
        Context context = this.f55596e;
        if (context instanceof Activity) {
            g.a(this, (Activity) context);
        } else {
            super.dismiss();
        }
    }
}
