package d.b.i0.i2.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57205a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.r.s.a f57206b;

    /* renamed from: d  reason: collision with root package name */
    public View f57208d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f57209e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57210f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57211g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57212h;
    public final View.OnClickListener i = new View$OnClickListenerC1347a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f57207c = d.b.h0.r.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);

    /* renamed from: d.b.i0.i2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1347a implements View.OnClickListener {
        public View$OnClickListenerC1347a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57206b != null) {
                a.this.f57206b.dismiss();
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f57205a = tbPageContext;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f57205a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.f57208d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        this.f57209e = tbImageView;
        e(tbImageView);
        this.f57209e.setAutoChangeStyle(true);
        this.f57209e.setRadius(l.g(this.f57205a.getPageActivity(), R.dimen.tbds24));
        this.f57209e.setConrers(3);
        this.f57209e.setIsBitmapPic(true);
        this.f57210f = (TextView) this.f57208d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.f57211g = (TextView) this.f57208d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        TextView textView = (TextView) this.f57208d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.f57212h = textView;
        textView.setOnClickListener(this.i);
        d();
    }

    public boolean c() {
        return this.f57207c;
    }

    public final void d() {
        SkinManager.setImageResource(this.f57209e, R.drawable.pic_person_center_dynamic_guide);
        SkinManager.setViewTextColor(this.f57210f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f57211g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f57212h, R.color.CAM_X0302);
    }

    public final void e(TbImageView tbImageView) {
        if (tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f57205a.getPageActivity()) - (l.g(this.f57205a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        if (this.f57207c) {
            return;
        }
        this.f57207c = true;
        d.b.h0.r.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f57205a.getPageActivity());
        this.f57206b = aVar;
        aVar.setContentViewSize(1);
        this.f57206b.setCancelable(true);
        this.f57206b.setCanceledOnTouchOutside(false);
        this.f57206b.setContentView(this.f57208d);
        this.f57206b.create(this.f57205a).show();
    }
}
