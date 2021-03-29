package d.b.i0.g3;

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
import d.b.b.e.m.g;
/* loaded from: classes5.dex */
public class d extends Dialog implements a {

    /* renamed from: e  reason: collision with root package name */
    public Context f55014e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55015f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55016g;

    /* renamed from: h  reason: collision with root package name */
    public View f55017h;
    public View i;
    public InterestFrsData.Tag j;
    public c k;
    public GridView l;
    public LinearLayout m;

    public d(Context context, int i) {
        super(context, i);
        this.f55014e = context;
        e();
    }

    @Override // d.b.i0.g3.a
    public void a(int i) {
        this.k.notifyDataSetChanged();
    }

    @Override // d.b.i0.g3.a
    public void b(int i) {
        this.k.notifyDataSetChanged();
    }

    @Override // d.b.i0.g3.a
    public void c(InterestFrsData.Tag tag) {
        this.j = tag;
        if (tag != null) {
            this.f55015f.setText(tag.getBname());
            this.f55016g.setText(tag.getBdesc());
            this.k.a(tag.getCard_list());
        }
    }

    @Override // d.b.i0.g3.a
    public void d(View.OnClickListener onClickListener) {
        this.m.setOnClickListener(onClickListener);
        this.k.c(onClickListener);
    }

    public final void e() {
        this.i = View.inflate(this.f55014e, R.layout.new_user_img_box, null);
        this.k = new c(this.f55014e);
        setCanceledOnTouchOutside(true);
        this.m = (LinearLayout) this.i.findViewById(R.id.box_close_layout);
        GridView gridView = (GridView) this.i.findViewById(R.id.layout_content);
        this.l = gridView;
        gridView.setAdapter((ListAdapter) this.k);
        this.l.setSelector(R.color.common_color_10022);
        setContentView(this.i);
        this.f55015f = (TextView) this.i.findViewById(R.id.prompt_title);
        this.f55016g = (TextView) this.i.findViewById(R.id.prompt_sub_title);
        View findViewById = this.i.findViewById(R.id.view_layout);
        this.f55017h = findViewById;
        findViewById.setBackgroundDrawable(this.f55014e.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // d.b.i0.g3.a
    public View getRootView() {
        return this.i;
    }

    @Override // android.app.Dialog, d.b.i0.g3.a
    public void hide() {
        Context context = this.f55014e;
        if (context instanceof Activity) {
            g.a(this, (Activity) context);
        } else {
            super.dismiss();
        }
    }
}
