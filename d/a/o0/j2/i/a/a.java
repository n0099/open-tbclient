package d.a.o0.j2.i.a;

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
    public TbPageContext f60288a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.r.s.a f60289b;

    /* renamed from: d  reason: collision with root package name */
    public View f60291d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f60292e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f60293f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60294g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60295h;

    /* renamed from: i  reason: collision with root package name */
    public final View.OnClickListener f60296i = new View$OnClickListenerC1459a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f60290c = d.a.n0.r.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);

    /* renamed from: d.a.o0.j2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1459a implements View.OnClickListener {
        public View$OnClickListenerC1459a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f60289b != null) {
                a.this.f60289b.dismiss();
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f60288a = tbPageContext;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f60288a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.f60291d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        this.f60292e = tbImageView;
        e(tbImageView);
        this.f60292e.setAutoChangeStyle(true);
        this.f60292e.setRadius(l.g(this.f60288a.getPageActivity(), R.dimen.tbds24));
        this.f60292e.setConrers(3);
        this.f60292e.setIsBitmapPic(true);
        this.f60293f = (TextView) this.f60291d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.f60294g = (TextView) this.f60291d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        TextView textView = (TextView) this.f60291d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.f60295h = textView;
        textView.setOnClickListener(this.f60296i);
        d();
    }

    public boolean c() {
        return this.f60290c;
    }

    public final void d() {
        SkinManager.setImageResource(this.f60292e, R.drawable.pic_person_center_dynamic_guide);
        SkinManager.setViewTextColor(this.f60293f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f60294g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f60295h, R.color.CAM_X0302);
    }

    public final void e(TbImageView tbImageView) {
        if (tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f60288a.getPageActivity()) - (l.g(this.f60288a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        if (this.f60290c) {
            return;
        }
        this.f60290c = true;
        d.a.n0.r.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f60288a.getPageActivity());
        this.f60289b = aVar;
        aVar.setContentViewSize(1);
        this.f60289b.setCancelable(true);
        this.f60289b.setCanceledOnTouchOutside(false);
        this.f60289b.setContentView(this.f60291d);
        this.f60289b.create(this.f60288a).show();
    }
}
