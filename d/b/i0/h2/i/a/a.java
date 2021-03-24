package d.b.i0.h2.i.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f55346a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.r.s.a f55347b;

    /* renamed from: d  reason: collision with root package name */
    public View f55349d;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f55350e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f55351f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f55352g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f55353h;
    public final View.OnClickListener i = new View$OnClickListenerC1271a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f55348c = d.b.h0.r.d0.b.i().g("key_person_dynamic_tab_guide_has_shown", false);

    /* renamed from: d.b.i0.h2.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1271a implements View.OnClickListener {
        public View$OnClickListenerC1271a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55347b != null) {
                a.this.f55347b.dismiss();
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f55346a = tbPageContext;
    }

    public final void b() {
        View inflate = LayoutInflater.from(this.f55346a.getPageActivity()).inflate(R.layout.person_center_dynamic_tab_guide, (ViewGroup) null);
        this.f55349d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.id_person_center_dynamic_tab_guide_img);
        this.f55350e = tbImageView;
        e(tbImageView);
        this.f55350e.setAutoChangeStyle(true);
        this.f55350e.setRadius(l.g(this.f55346a.getPageActivity(), R.dimen.tbds24));
        this.f55350e.setConrers(3);
        this.f55350e.setIsBitmapPic(true);
        this.f55351f = (TextView) this.f55349d.findViewById(R.id.id_person_center_dynamic_tab_guide_tip);
        this.f55352g = (TextView) this.f55349d.findViewById(R.id.id_person_center_dynamic_tab_guide_title);
        TextView textView = (TextView) this.f55349d.findViewById(R.id.id_person_center_dynamic_tab_guide_close);
        this.f55353h = textView;
        textView.setOnClickListener(this.i);
        d();
    }

    public boolean c() {
        return this.f55348c;
    }

    public final void d() {
        SkinManager.setImageResource(this.f55350e, R.drawable.pic_person_center_dynamic_guide);
        SkinManager.setViewTextColor(this.f55351f, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f55352g, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f55353h, R.color.CAM_X0302);
    }

    public final void e(TbImageView tbImageView) {
        if (tbImageView == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tbImageView.getLayoutParams();
        int k = l.k(this.f55346a.getPageActivity()) - (l.g(this.f55346a.getPageActivity(), R.dimen.ds40) * 2);
        layoutParams.width = k;
        layoutParams.height = (k * 214) / 380;
        tbImageView.setLayoutParams(layoutParams);
    }

    public void f() {
        if (this.f55348c) {
            return;
        }
        this.f55348c = true;
        d.b.h0.r.d0.b.i().s("key_person_dynamic_tab_guide_has_shown", true);
        b();
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f55346a.getPageActivity());
        this.f55347b = aVar;
        aVar.setContentViewSize(1);
        this.f55347b.setCancelable(true);
        this.f55347b.setCanceledOnTouchOutside(false);
        this.f55347b.setContentView(this.f55349d);
        this.f55347b.create(this.f55346a).show();
    }
}
