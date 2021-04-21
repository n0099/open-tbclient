package d.b.j0.i2.i.a;

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
    public TbPageContext f57626a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.r.s.a f57627b;

    /* renamed from: d  reason: collision with root package name */
    public View f57629d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f57630e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57631f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f57632g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57633h;
    public final View.OnClickListener i = new View$OnClickListenerC1370a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f57628c = d.b.i0.r.d0.b.j().g("key_person_dynamic_tab_guide_has_shown", false);

    /* renamed from: d.b.j0.i2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1370a implements View.OnClickListener {
        public View$OnClickListenerC1370a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f57627b != null) {
                a.this.f57627b.dismiss();
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f57626a = tbPageContext;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f57626a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.f57629d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        this.f57630e = tbImageView;
        e(tbImageView);
        this.f57630e.setAutoChangeStyle(true);
        this.f57630e.setRadius(l.g(this.f57626a.getPageActivity(), R.dimen.tbds24));
        this.f57630e.setConrers(3);
        this.f57630e.setIsBitmapPic(true);
        this.f57631f = (TextView) this.f57629d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.f57632g = (TextView) this.f57629d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        TextView textView = (TextView) this.f57629d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.f57633h = textView;
        textView.setOnClickListener(this.i);
        d();
    }

    public boolean c() {
        return this.f57628c;
    }

    public final void d() {
        SkinManager.setImageResource(this.f57630e, R.drawable.pic_person_center_dynamic_guide);
        SkinManager.setViewTextColor(this.f57631f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f57632g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f57633h, R.color.CAM_X0302);
    }

    public final void e(TbImageView tbImageView) {
        if (tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f57626a.getPageActivity()) - (l.g(this.f57626a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        if (this.f57628c) {
            return;
        }
        this.f57628c = true;
        d.b.i0.r.d0.b.j().t("key_person_dynamic_tab_guide_has_shown", true);
        b();
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f57626a.getPageActivity());
        this.f57627b = aVar;
        aVar.setContentViewSize(1);
        this.f57627b.setCancelable(true);
        this.f57627b.setCanceledOnTouchOutside(false);
        this.f57627b.setContentView(this.f57629d);
        this.f57627b.create(this.f57626a).show();
    }
}
