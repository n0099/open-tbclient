package d.b.j0.d2.k.e.y0;

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
import d.b.i0.z0.l;
import d.b.j0.d2.h.e;
import d.b.j0.d2.k.e.o;
/* loaded from: classes3.dex */
public class a extends o<d.b.j0.d2.h.a, b> {
    public d.b.j0.d2.k.e.y0.b s;
    public d.b.j0.d2.h.a t;
    public e u;
    public View.OnClickListener v;

    /* renamed from: d.b.j0.d2.k.e.y0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1241a implements View.OnClickListener {
        public View$OnClickListenerC1241a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.t == null || a.this.t.f54222e == null || l.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(a.this.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = a.this;
            aVar.p0(aVar.t);
            if (a.this.t.f54222e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (a.this.t.f54222e.a()) {
                a.this.s.u(a.this.t);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f54774a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f54775b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54776c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f54777d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f54778e;

        /* renamed from: f  reason: collision with root package name */
        public View f54779f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f54780g;

        /* renamed from: d.b.j0.d2.k.e.y0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC1242a implements View.OnClickListener {
            public View$OnClickListenerC1242a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f54780g != null) {
                    b.this.f54780g.onClick(view);
                }
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1241a view$OnClickListenerC1241a) {
            this(view);
        }

        public final void d(Context context, d.b.j0.d2.h.b bVar) {
            if (bVar == null) {
                return;
            }
            this.f54778e.setText(bVar.f54226c);
            this.f54775b.W(bVar.f54225b, 38, false);
            this.f54774a.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.f54227d) + "%");
            int d2 = d.b.c.e.m.b.d(bVar.f54227d, 0);
            if (d2 > 100) {
                d2 = 100;
            } else if (d2 < 0) {
                d2 = 0;
            }
            this.f54777d.setProgress(d2);
            if (bVar.a()) {
                this.f54776c.setText(R.string.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f54776c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f54776c, R.drawable.btn_pb_ad_card_gift_get);
                this.f54776c.setClickable(true);
            } else if (bVar.b()) {
                this.f54776c.setText(R.string.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f54776c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f54776c, R.drawable.btn_pb_ad_card_gift_watch);
                this.f54776c.setClickable(true);
            } else {
                this.f54776c.setText(R.string.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f54776c, R.color.CAM_X0109);
                this.f54776c.setBackgroundResource(R.drawable.transparent_bg);
                this.f54776c.setClickable(false);
            }
            e();
        }

        public final void e() {
            SkinManager.setBackgroundResource(this.f54779f, R.drawable.bg_pb_ad_card_gift);
            SkinManager.setViewTextColor(this.f54778e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f54774a, R.color.CAM_X0107);
            this.f54777d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }

        public void f(View.OnClickListener onClickListener) {
            this.f54780g = onClickListener;
        }

        public b(View view) {
            super(view);
            this.f54779f = view.findViewById(R.id.bg_ad_card_gift);
            this.f54775b = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.f54774a = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.f54776c = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.f54777d = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.f54778e = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.f54775b.setRadius(d.b.c.e.p.l.g(a().getContext(), R.dimen.tbds20));
            this.f54775b.setConrers(5);
            this.f54775b.setDefaultBgResource(R.color.cp_atp_a);
            this.f54775b.setDrawCorner(true);
            this.f54776c.setOnClickListener(new View$OnClickListenerC1242a());
            this.f54777d.setMax(100);
        }
    }

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.v = new View$OnClickListenerC1241a();
        this.s = new d.b.j0.d2.k.e.y0.b(pbFragment);
    }

    @Override // d.b.j0.d2.k.e.o, d.b.c.j.e.a
    public /* bridge */ /* synthetic */ View X(int i, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i, view, viewGroup, (d.b.j0.d2.h.a) obj, (b) viewHolder);
        return view;
    }

    public void onDestroy() {
        d.b.j0.d2.k.e.y0.b bVar = this.s;
        if (bVar != null) {
            bVar.q();
        }
    }

    public final void p0(d.b.j0.d2.h.a aVar) {
        d.b.j0.c3.c.g().c(this.n.getUniqueId(), d.b.j0.c3.a.e(this.u.L(), "a005", "common_click", 1, aVar.f54223f, true, aVar.f54222e.f54224a + "", null, 18));
    }

    public final void q0(d.b.j0.d2.h.a aVar) {
        String str = aVar.f54222e.f54224a + "";
        d.b.j0.c3.c.g().d(this.n.getUniqueId(), d.b.j0.c3.a.c(this.u.L().w1(), str, "", null), d.b.j0.c3.a.g(this.u.L(), "a005", "common_exp", aVar.f54223f, true, str, "", 18));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.c.j.e.a
    /* renamed from: r0 */
    public b R(ViewGroup viewGroup) {
        b bVar = new b(LayoutInflater.from(this.f43095e).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false), null);
        bVar.f(this.v);
        return bVar;
    }

    public void s(e eVar) {
        this.u = eVar;
        d.b.j0.d2.k.e.y0.b bVar = this.s;
        if (bVar != null) {
            bVar.v(eVar);
        }
    }

    public View s0(int i, View view, ViewGroup viewGroup, d.b.j0.d2.h.a aVar, b bVar) {
        super.X(i, view, viewGroup, aVar, bVar);
        if (aVar != null && bVar != null) {
            aVar.f54223f = i + 1;
            this.t = aVar;
            q0(aVar);
            bVar.d(this.f43095e, aVar.f54222e);
        }
        return view;
    }
}
