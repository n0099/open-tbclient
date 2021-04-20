package d.b.i0.d2.k.e.y0;

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
import d.b.i0.d2.h.e;
import d.b.i0.d2.k.e.o;
/* loaded from: classes3.dex */
public class a extends o<d.b.i0.d2.h.a, b> {
    public d.b.i0.d2.k.e.y0.b s;
    public d.b.i0.d2.h.a t;
    public e u;
    public View.OnClickListener v;

    /* renamed from: d.b.i0.d2.k.e.y0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1218a implements View.OnClickListener {
        public View$OnClickListenerC1218a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.t == null || a.this.t.f53801e == null || l.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(a.this.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = a.this;
            aVar.p0(aVar.t);
            if (a.this.t.f53801e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (a.this.t.f53801e.a()) {
                a.this.s.u(a.this.t);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f54353a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f54354b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54355c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f54356d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f54357e;

        /* renamed from: f  reason: collision with root package name */
        public View f54358f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f54359g;

        /* renamed from: d.b.i0.d2.k.e.y0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC1219a implements View.OnClickListener {
            public View$OnClickListenerC1219a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f54359g != null) {
                    b.this.f54359g.onClick(view);
                }
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1218a view$OnClickListenerC1218a) {
            this(view);
        }

        public final void d(Context context, d.b.i0.d2.h.b bVar) {
            if (bVar == null) {
                return;
            }
            this.f54357e.setText(bVar.f53805c);
            this.f54354b.W(bVar.f53804b, 38, false);
            this.f54353a.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.f53806d) + "%");
            int d2 = d.b.c.e.m.b.d(bVar.f53806d, 0);
            if (d2 > 100) {
                d2 = 100;
            } else if (d2 < 0) {
                d2 = 0;
            }
            this.f54356d.setProgress(d2);
            if (bVar.a()) {
                this.f54355c.setText(R.string.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f54355c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f54355c, R.drawable.btn_pb_ad_card_gift_get);
                this.f54355c.setClickable(true);
            } else if (bVar.b()) {
                this.f54355c.setText(R.string.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f54355c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f54355c, R.drawable.btn_pb_ad_card_gift_watch);
                this.f54355c.setClickable(true);
            } else {
                this.f54355c.setText(R.string.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f54355c, R.color.CAM_X0109);
                this.f54355c.setBackgroundResource(R.drawable.transparent_bg);
                this.f54355c.setClickable(false);
            }
            e();
        }

        public final void e() {
            SkinManager.setBackgroundResource(this.f54358f, R.drawable.bg_pb_ad_card_gift);
            SkinManager.setViewTextColor(this.f54357e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f54353a, R.color.CAM_X0107);
            this.f54356d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }

        public void f(View.OnClickListener onClickListener) {
            this.f54359g = onClickListener;
        }

        public b(View view) {
            super(view);
            this.f54358f = view.findViewById(R.id.bg_ad_card_gift);
            this.f54354b = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.f54353a = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.f54355c = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.f54356d = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.f54357e = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.f54354b.setRadius(d.b.c.e.p.l.g(a().getContext(), R.dimen.tbds20));
            this.f54354b.setConrers(5);
            this.f54354b.setDefaultBgResource(R.color.cp_atp_a);
            this.f54354b.setDrawCorner(true);
            this.f54355c.setOnClickListener(new View$OnClickListenerC1219a());
            this.f54356d.setMax(100);
        }
    }

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.v = new View$OnClickListenerC1218a();
        this.s = new d.b.i0.d2.k.e.y0.b(pbFragment);
    }

    @Override // d.b.i0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i, view, viewGroup, (d.b.i0.d2.h.a) obj, (b) viewHolder);
        return view;
    }

    public void onDestroy() {
        d.b.i0.d2.k.e.y0.b bVar = this.s;
        if (bVar != null) {
            bVar.q();
        }
    }

    public final void p0(d.b.i0.d2.h.a aVar) {
        d.b.i0.c3.c.g().c(this.n.getUniqueId(), d.b.i0.c3.a.e(this.u.L(), "a005", "common_click", 1, aVar.f53802f, true, aVar.f53801e.f53803a + "", null, 18));
    }

    public final void q0(d.b.i0.d2.h.a aVar) {
        String str = aVar.f53801e.f53803a + "";
        d.b.i0.c3.c.g().d(this.n.getUniqueId(), d.b.i0.c3.a.c(this.u.L().w1(), str, "", null), d.b.i0.c3.a.g(this.u.L(), "a005", "common_exp", aVar.f53802f, true, str, "", 18));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: r0 */
    public b R(ViewGroup viewGroup) {
        b bVar = new b(LayoutInflater.from(this.f42855e).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false), null);
        bVar.f(this.v);
        return bVar;
    }

    public void s(e eVar) {
        this.u = eVar;
        d.b.i0.d2.k.e.y0.b bVar = this.s;
        if (bVar != null) {
            bVar.v(eVar);
        }
    }

    public View s0(int i, View view, ViewGroup viewGroup, d.b.i0.d2.h.a aVar, b bVar) {
        super.X(i, view, viewGroup, aVar, bVar);
        if (aVar != null && bVar != null) {
            aVar.f53802f = i + 1;
            this.t = aVar;
            q0(aVar);
            bVar.d(this.f42855e, aVar.f53801e);
        }
        return view;
    }
}
