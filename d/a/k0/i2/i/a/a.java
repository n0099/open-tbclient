package d.a.k0.i2.i.a;

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
    public TbPageContext f56290a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.r.s.a f56291b;

    /* renamed from: d  reason: collision with root package name */
    public View f56293d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f56294e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56295f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56296g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56297h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f56298i = new View$OnClickListenerC1381a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f56292c = d.a.j0.r.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);

    /* renamed from: d.a.k0.i2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1381a implements View.OnClickListener {
        public View$OnClickListenerC1381a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f56291b != null) {
                a.this.f56291b.dismiss();
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f56290a = tbPageContext;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f56290a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.f56293d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        this.f56294e = tbImageView;
        e(tbImageView);
        this.f56294e.setAutoChangeStyle(true);
        this.f56294e.setRadius(l.g(this.f56290a.getPageActivity(), R.dimen.tbds24));
        this.f56294e.setConrers(3);
        this.f56294e.setIsBitmapPic(true);
        this.f56295f = (TextView) this.f56293d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.f56296g = (TextView) this.f56293d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        TextView textView = (TextView) this.f56293d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.f56297h = textView;
        textView.setOnClickListener(this.f56298i);
        d();
    }

    public boolean c() {
        return this.f56292c;
    }

    public final void d() {
        SkinManager.setImageResource(this.f56294e, R.drawable.pic_person_center_dynamic_guide);
        SkinManager.setViewTextColor(this.f56295f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f56296g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f56297h, R.color.CAM_X0302);
    }

    public final void e(TbImageView tbImageView) {
        if (tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f56290a.getPageActivity()) - (l.g(this.f56290a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        if (this.f56292c) {
            return;
        }
        this.f56292c = true;
        d.a.j0.r.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f56290a.getPageActivity());
        this.f56291b = aVar;
        aVar.setContentViewSize(1);
        this.f56291b.setCancelable(true);
        this.f56291b.setCanceledOnTouchOutside(false);
        this.f56291b.setContentView(this.f56293d);
        this.f56291b.create(this.f56290a).show();
    }
}
