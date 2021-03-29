package d.b.i0.c2.k.e.w0;

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
import d.b.h0.z0.l;
import d.b.i0.c2.h.e;
import d.b.i0.c2.k.e.m;
/* loaded from: classes4.dex */
public class a extends m<d.b.i0.c2.h.a, b> {
    public d.b.i0.c2.k.e.w0.b s;
    public d.b.i0.c2.h.a t;
    public e u;
    public View.OnClickListener v;

    /* renamed from: d.b.i0.c2.k.e.w0.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1155a implements View.OnClickListener {
        public View$OnClickListenerC1155a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.t == null || a.this.t.f52406e == null || l.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(a.this.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = a.this;
            aVar.p0(aVar.t);
            if (a.this.t.f52406e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (a.this.t.f52406e.a()) {
                a.this.s.u(a.this.t);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f52858a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f52859b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f52860c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f52861d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f52862e;

        /* renamed from: f  reason: collision with root package name */
        public View f52863f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f52864g;

        /* renamed from: d.b.i0.c2.k.e.w0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1156a implements View.OnClickListener {
            public View$OnClickListenerC1156a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f52864g != null) {
                    b.this.f52864g.onClick(view);
                }
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1155a view$OnClickListenerC1155a) {
            this(view);
        }

        public final void d(Context context, d.b.i0.c2.h.b bVar) {
            if (bVar == null) {
                return;
            }
            this.f52862e.setText(bVar.f52410c);
            this.f52859b.W(bVar.f52409b, 38, false);
            this.f52858a.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.f52411d) + "%");
            int d2 = d.b.b.e.m.b.d(bVar.f52411d, 0);
            if (d2 > 100) {
                d2 = 100;
            } else if (d2 < 0) {
                d2 = 0;
            }
            this.f52861d.setProgress(d2);
            if (bVar.a()) {
                this.f52860c.setText(R.string.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f52860c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f52860c, R.drawable.btn_pb_ad_card_gift_get);
                this.f52860c.setClickable(true);
            } else if (bVar.b()) {
                this.f52860c.setText(R.string.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f52860c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f52860c, R.drawable.btn_pb_ad_card_gift_watch);
                this.f52860c.setClickable(true);
            } else {
                this.f52860c.setText(R.string.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f52860c, R.color.CAM_X0109);
                this.f52860c.setBackgroundResource(R.drawable.transparent_bg);
                this.f52860c.setClickable(false);
            }
            e();
        }

        public final void e() {
            SkinManager.setBackgroundResource(this.f52863f, R.drawable.bg_pb_ad_card_gift);
            SkinManager.setViewTextColor(this.f52862e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f52858a, R.color.CAM_X0107);
            this.f52861d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }

        public void f(View.OnClickListener onClickListener) {
            this.f52864g = onClickListener;
        }

        public b(View view) {
            super(view);
            this.f52863f = view.findViewById(R.id.bg_ad_card_gift);
            this.f52859b = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.f52858a = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.f52860c = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.f52861d = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.f52862e = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.f52859b.setRadius(d.b.b.e.p.l.g(a().getContext(), R.dimen.tbds20));
            this.f52859b.setConrers(5);
            this.f52859b.setDefaultBgResource(R.color.cp_atp_a);
            this.f52859b.setDrawCorner(true);
            this.f52860c.setOnClickListener(new View$OnClickListenerC1156a());
            this.f52861d.setMax(100);
        }
    }

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.v = new View$OnClickListenerC1155a();
        this.s = new d.b.i0.c2.k.e.w0.b(pbFragment);
    }

    @Override // d.b.i0.c2.k.e.m, d.b.b.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i, view, viewGroup, (d.b.i0.c2.h.a) obj, (b) viewHolder);
        return view;
    }

    public void onDestroy() {
        d.b.i0.c2.k.e.w0.b bVar = this.s;
        if (bVar != null) {
            bVar.q();
        }
    }

    public final void p0(d.b.i0.c2.h.a aVar) {
        d.b.i0.b3.c.g().c(this.n.getUniqueId(), d.b.i0.b3.a.e(this.u.L(), "a005", "common_click", 1, aVar.f52407f, true, aVar.f52406e.f52408a + "", null, 18));
    }

    public final void q0(d.b.i0.c2.h.a aVar) {
        String str = aVar.f52406e.f52408a + "";
        d.b.i0.b3.c.g().d(this.n.getUniqueId(), d.b.i0.b3.a.c(this.u.L().w1(), str, "", null), d.b.i0.b3.a.g(this.u.L(), "a005", "common_exp", aVar.f52407f, true, str, "", 18));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: r0 */
    public b R(ViewGroup viewGroup) {
        b bVar = new b(LayoutInflater.from(this.f42358e).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false), null);
        bVar.f(this.v);
        return bVar;
    }

    public void s(e eVar) {
        this.u = eVar;
        d.b.i0.c2.k.e.w0.b bVar = this.s;
        if (bVar != null) {
            bVar.v(eVar);
        }
    }

    public View s0(int i, View view, ViewGroup viewGroup, d.b.i0.c2.h.a aVar, b bVar) {
        super.X(i, view, viewGroup, aVar, bVar);
        if (aVar != null && bVar != null) {
            aVar.f52407f = i + 1;
            this.t = aVar;
            q0(aVar);
            bVar.d(this.f42358e, aVar.f52406e);
        }
        return view;
    }
}
