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
    public TbPageContext f56474a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.r.s.a f56475b;

    /* renamed from: d  reason: collision with root package name */
    public View f56477d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f56478e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f56479f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56480g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f56481h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f56482i = new View$OnClickListenerC1399a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f56476c = d.a.m0.r.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);

    /* renamed from: d.a.n0.j2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1399a implements View.OnClickListener {
        public View$OnClickListenerC1399a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f56475b != null) {
                a.this.f56475b.dismiss();
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f56474a = tbPageContext;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f56474a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.f56477d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        this.f56478e = tbImageView;
        e(tbImageView);
        this.f56478e.setAutoChangeStyle(true);
        this.f56478e.setRadius(l.g(this.f56474a.getPageActivity(), R.dimen.tbds24));
        this.f56478e.setConrers(3);
        this.f56478e.setIsBitmapPic(true);
        this.f56479f = (TextView) this.f56477d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.f56480g = (TextView) this.f56477d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        TextView textView = (TextView) this.f56477d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.f56481h = textView;
        textView.setOnClickListener(this.f56482i);
        d();
    }

    public boolean c() {
        return this.f56476c;
    }

    public final void d() {
        SkinManager.setImageResource(this.f56478e, R.drawable.pic_person_center_dynamic_guide);
        SkinManager.setViewTextColor(this.f56479f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f56480g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f56481h, R.color.CAM_X0302);
    }

    public final void e(TbImageView tbImageView) {
        if (tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f56474a.getPageActivity()) - (l.g(this.f56474a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        if (this.f56476c) {
            return;
        }
        this.f56476c = true;
        d.a.m0.r.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f56474a.getPageActivity());
        this.f56475b = aVar;
        aVar.setContentViewSize(1);
        this.f56475b.setCancelable(true);
        this.f56475b.setCanceledOnTouchOutside(false);
        this.f56475b.setContentView(this.f56477d);
        this.f56475b.create(this.f56474a).show();
    }
}
