package d.a.j0.h3;

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
    public Context f54889e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f54890f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f54891g;

    /* renamed from: h  reason: collision with root package name */
    public View f54892h;

    /* renamed from: i  reason: collision with root package name */
    public View f54893i;
    public InterestFrsData.Tag j;
    public c k;
    public GridView l;
    public LinearLayout m;

    public d(Context context, int i2) {
        super(context, i2);
        this.f54889e = context;
        e();
    }

    @Override // d.a.j0.h3.a
    public void a(int i2) {
        this.k.notifyDataSetChanged();
    }

    @Override // d.a.j0.h3.a
    public void b(int i2) {
        this.k.notifyDataSetChanged();
    }

    @Override // d.a.j0.h3.a
    public void c(InterestFrsData.Tag tag) {
        this.j = tag;
        if (tag != null) {
            this.f54890f.setText(tag.getBname());
            this.f54891g.setText(tag.getBdesc());
            this.k.a(tag.getCard_list());
        }
    }

    @Override // d.a.j0.h3.a
    public void d(View.OnClickListener onClickListener) {
        this.m.setOnClickListener(onClickListener);
        this.k.c(onClickListener);
    }

    public final void e() {
        this.f54893i = View.inflate(this.f54889e, R.layout.new_user_img_box, null);
        this.k = new c(this.f54889e);
        setCanceledOnTouchOutside(true);
        this.m = (LinearLayout) this.f54893i.findViewById(R.id.box_close_layout);
        GridView gridView = (GridView) this.f54893i.findViewById(R.id.layout_content);
        this.l = gridView;
        gridView.setAdapter((ListAdapter) this.k);
        this.l.setSelector(R.color.common_color_10022);
        setContentView(this.f54893i);
        this.f54890f = (TextView) this.f54893i.findViewById(R.id.prompt_title);
        this.f54891g = (TextView) this.f54893i.findViewById(R.id.prompt_sub_title);
        View findViewById = this.f54893i.findViewById(R.id.view_layout);
        this.f54892h = findViewById;
        findViewById.setBackgroundDrawable(this.f54889e.getResources().getDrawable(R.drawable.bg_startpage2_card_orange_up));
    }

    @Override // d.a.j0.h3.a
    public View getRootView() {
        return this.f54893i;
    }

    @Override // android.app.Dialog, d.a.j0.h3.a
    public void hide() {
        Context context = this.f54889e;
        if (context instanceof Activity) {
            g.a(this, (Activity) context);
        } else {
            super.dismiss();
        }
    }
}
