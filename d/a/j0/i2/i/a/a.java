package d.a.j0.i2.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55583a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.r.s.a f55584b;

    /* renamed from: d  reason: collision with root package name */
    public View f55586d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f55587e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55588f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55589g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55590h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f55591i = new View$OnClickListenerC1309a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f55585c = d.a.i0.r.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);

    /* renamed from: d.a.j0.i2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1309a implements View.OnClickListener {
        public View$OnClickListenerC1309a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55584b != null) {
                a.this.f55584b.dismiss();
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f55583a = tbPageContext;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f55583a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.f55586d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        this.f55587e = tbImageView;
        e(tbImageView);
        this.f55587e.setAutoChangeStyle(true);
        this.f55587e.setRadius(l.g(this.f55583a.getPageActivity(), R.dimen.tbds24));
        this.f55587e.setConrers(3);
        this.f55587e.setIsBitmapPic(true);
        this.f55588f = (TextView) this.f55586d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.f55589g = (TextView) this.f55586d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        TextView textView = (TextView) this.f55586d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.f55590h = textView;
        textView.setOnClickListener(this.f55591i);
        d();
    }

    public boolean c() {
        return this.f55585c;
    }

    public final void d() {
        SkinManager.setImageResource(this.f55587e, R.drawable.pic_person_center_dynamic_guide);
        SkinManager.setViewTextColor(this.f55588f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f55589g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f55590h, R.color.CAM_X0302);
    }

    public final void e(TbImageView tbImageView) {
        if (tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f55583a.getPageActivity()) - (l.g(this.f55583a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        if (this.f55585c) {
            return;
        }
        this.f55585c = true;
        d.a.i0.r.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f55583a.getPageActivity());
        this.f55584b = aVar;
        aVar.setContentViewSize(1);
        this.f55584b.setCancelable(true);
        this.f55584b.setCanceledOnTouchOutside(false);
        this.f55584b.setContentView(this.f55586d);
        this.f55584b.create(this.f55583a).show();
    }
}
