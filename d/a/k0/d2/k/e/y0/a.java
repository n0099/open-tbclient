package d.a.k0.d2.k.e.y0;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import d.a.j0.z0.l;
import d.a.k0.d2.h.e;
import d.a.k0.d2.k.e.o;
/* loaded from: classes5.dex */
public class a extends o<d.a.k0.d2.h.a, b> {
    public d.a.k0.d2.k.e.y0.b s;
    public d.a.k0.d2.h.a t;
    public e u;
    public View.OnClickListener v;

    /* renamed from: d.a.k0.d2.k.e.y0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1252a implements View.OnClickListener {
        public View$OnClickListenerC1252a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.t == null || a.this.t.f52700e == null || l.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(a.this.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = a.this;
            aVar.n0(aVar.t);
            if (a.this.t.f52700e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (a.this.t.f52700e.a()) {
                a.this.s.u(a.this.t);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f53292a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f53293b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f53294c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f53295d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f53296e;

        /* renamed from: f  reason: collision with root package name */
        public View f53297f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f53298g;

        /* renamed from: d.a.k0.d2.k.e.y0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1253a implements View.OnClickListener {
            public View$OnClickListenerC1253a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f53298g != null) {
                    b.this.f53298g.onClick(view);
                }
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1252a view$OnClickListenerC1252a) {
            this(view);
        }

        public final void d(Context context, d.a.k0.d2.h.b bVar) {
            if (bVar == null) {
                return;
            }
            this.f53296e.setText(bVar.f52704c);
            this.f53293b.V(bVar.f52703b, 38, false);
            this.f53292a.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.f52705d) + "%");
            int d2 = d.a.c.e.m.b.d(bVar.f52705d, 0);
            if (d2 > 100) {
                d2 = 100;
            } else if (d2 < 0) {
                d2 = 0;
            }
            this.f53295d.setProgress(d2);
            if (bVar.a()) {
                this.f53294c.setText(R.string.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f53294c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f53294c, R.drawable.btn_pb_ad_card_gift_get);
                this.f53294c.setClickable(true);
            } else if (bVar.b()) {
                this.f53294c.setText(R.string.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f53294c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f53294c, R.drawable.btn_pb_ad_card_gift_watch);
                this.f53294c.setClickable(true);
            } else {
                this.f53294c.setText(R.string.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f53294c, R.color.CAM_X0109);
                this.f53294c.setBackgroundResource(R.drawable.transparent_bg);
                this.f53294c.setClickable(false);
            }
            e();
        }

        public final void e() {
            SkinManager.setBackgroundResource(this.f53297f, R.drawable.bg_pb_ad_card_gift);
            SkinManager.setViewTextColor(this.f53296e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f53292a, R.color.CAM_X0107);
            this.f53295d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }

        public void f(View.OnClickListener onClickListener) {
            this.f53298g = onClickListener;
        }

        public b(View view) {
            super(view);
            this.f53297f = view.findViewById(R.id.bg_ad_card_gift);
            this.f53293b = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.f53292a = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.f53294c = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.f53295d = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.f53296e = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.f53293b.setRadius(d.a.c.e.p.l.g(a().getContext(), R.dimen.tbds20));
            this.f53293b.setConrers(5);
            this.f53293b.setDefaultBgResource(R.color.cp_atp_a);
            this.f53293b.setDrawCorner(true);
            this.f53294c.setOnClickListener(new View$OnClickListenerC1253a());
            this.f53295d.setMax(100);
        }
    }

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.v = new View$OnClickListenerC1252a();
        this.s = new d.a.k0.d2.k.e.y0.b(pbFragment);
    }

    @Override // d.a.k0.d2.k.e.o, d.a.c.j.e.a
    public /* bridge */ /* synthetic */ View W(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i2, view, viewGroup, (d.a.k0.d2.h.a) obj, (b) viewHolder);
        return view;
    }

    public final void n0(d.a.k0.d2.h.a aVar) {
        d.a.k0.c3.c.g().c(this.n.getUniqueId(), d.a.k0.c3.a.e(this.u.L(), "a005", "common_click", 1, aVar.f52701f, true, aVar.f52700e.f52702a + "", null, 18));
    }

    public void onDestroy() {
        d.a.k0.d2.k.e.y0.b bVar = this.s;
        if (bVar != null) {
            bVar.q();
        }
    }

    public final void p0(d.a.k0.d2.h.a aVar) {
        String str = aVar.f52700e.f52702a + "";
        d.a.k0.c3.c.g().d(this.n.getUniqueId(), d.a.k0.c3.a.c(this.u.L().x1(), str, "", null), d.a.k0.c3.a.g(this.u.L(), "a005", "common_exp", aVar.f52701f, true, str, "", 18));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.a
    /* renamed from: q0 */
    public b P(ViewGroup viewGroup) {
        b bVar = new b(LayoutInflater.from(this.f39564e).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false), null);
        bVar.f(this.v);
        return bVar;
    }

    public void s(e eVar) {
        this.u = eVar;
        d.a.k0.d2.k.e.y0.b bVar = this.s;
        if (bVar != null) {
            bVar.v(eVar);
        }
    }

    public View s0(int i2, View view, ViewGroup viewGroup, d.a.k0.d2.h.a aVar, b bVar) {
        super.W(i2, view, viewGroup, aVar, bVar);
        if (aVar != null && bVar != null) {
            aVar.f52701f = i2 + 1;
            this.t = aVar;
            p0(aVar);
            bVar.d(this.f39564e, aVar.f52700e);
        }
        return view;
    }
}
