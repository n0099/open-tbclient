package d.a.n0.j2.i.a;

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
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60163a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.r.s.a f60164b;

    /* renamed from: d  reason: collision with root package name */
    public View f60166d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f60167e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60168f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60169g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60170h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f60171i = new View$OnClickListenerC1455a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f60165c = d.a.m0.r.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);

    /* renamed from: d.a.n0.j2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1455a implements View.OnClickListener {
        public View$OnClickListenerC1455a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f60164b != null) {
                a.this.f60164b.dismiss();
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f60163a = tbPageContext;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f60163a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.f60166d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        this.f60167e = tbImageView;
        e(tbImageView);
        this.f60167e.setAutoChangeStyle(true);
        this.f60167e.setRadius(l.g(this.f60163a.getPageActivity(), R.dimen.tbds24));
        this.f60167e.setConrers(3);
        this.f60167e.setIsBitmapPic(true);
        this.f60168f = (TextView) this.f60166d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.f60169g = (TextView) this.f60166d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        TextView textView = (TextView) this.f60166d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.f60170h = textView;
        textView.setOnClickListener(this.f60171i);
        d();
    }

    public boolean c() {
        return this.f60165c;
    }

    public final void d() {
        SkinManager.setImageResource(this.f60167e, R.drawable.pic_person_center_dynamic_guide);
        SkinManager.setViewTextColor(this.f60168f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f60169g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f60170h, R.color.CAM_X0302);
    }

    public final void e(TbImageView tbImageView) {
        if (tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f60163a.getPageActivity()) - (l.g(this.f60163a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        if (this.f60165c) {
            return;
        }
        this.f60165c = true;
        d.a.m0.r.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f60163a.getPageActivity());
        this.f60164b = aVar;
        aVar.setContentViewSize(1);
        this.f60164b.setCancelable(true);
        this.f60164b.setCanceledOnTouchOutside(false);
        this.f60164b.setContentView(this.f60166d);
        this.f60164b.create(this.f60163a).show();
    }
}
