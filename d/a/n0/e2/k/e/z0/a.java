package d.a.n0.e2.k.e.z0;

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
import d.a.m0.z0.l;
import d.a.n0.e2.h.e;
import d.a.n0.e2.k.e.o;
/* loaded from: classes5.dex */
public class a extends o<d.a.n0.e2.h.a, b> {
    public d.a.n0.e2.k.e.z0.b s;
    public d.a.n0.e2.h.a t;
    public e u;
    public View.OnClickListener v;

    /* renamed from: d.a.n0.e2.k.e.z0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1327a implements View.OnClickListener {
        public View$OnClickListenerC1327a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.t == null || a.this.t.f56594e == null || l.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(a.this.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = a.this;
            aVar.m0(aVar.t);
            if (a.this.t.f56594e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (a.this.t.f56594e.a()) {
                a.this.s.u(a.this.t);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57237a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f57238b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57239c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f57240d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57241e;

        /* renamed from: f  reason: collision with root package name */
        public View f57242f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f57243g;

        /* renamed from: d.a.n0.e2.k.e.z0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1328a implements View.OnClickListener {
            public View$OnClickListenerC1328a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f57243g != null) {
                    b.this.f57243g.onClick(view);
                }
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1327a view$OnClickListenerC1327a) {
            this(view);
        }

        public final void d(Context context, d.a.n0.e2.h.b bVar) {
            if (bVar == null) {
                return;
            }
            this.f57241e.setText(bVar.f56598c);
            this.f57238b.U(bVar.f56597b, 38, false);
            this.f57237a.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.f56599d) + "%");
            int d2 = d.a.c.e.m.b.d(bVar.f56599d, 0);
            if (d2 > 100) {
                d2 = 100;
            } else if (d2 < 0) {
                d2 = 0;
            }
            this.f57240d.setProgress(d2);
            if (bVar.a()) {
                this.f57239c.setText(R.string.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f57239c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f57239c, R.drawable.btn_pb_ad_card_gift_get);
                this.f57239c.setClickable(true);
            } else if (bVar.b()) {
                this.f57239c.setText(R.string.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f57239c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f57239c, R.drawable.btn_pb_ad_card_gift_watch);
                this.f57239c.setClickable(true);
            } else {
                this.f57239c.setText(R.string.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f57239c, R.color.CAM_X0109);
                this.f57239c.setBackgroundResource(R.drawable.transparent_bg);
                this.f57239c.setClickable(false);
            }
            e();
        }

        public final void e() {
            SkinManager.setBackgroundResource(this.f57242f, R.drawable.bg_pb_ad_card_gift);
            SkinManager.setViewTextColor(this.f57241e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f57237a, R.color.CAM_X0107);
            this.f57240d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }

        public void f(View.OnClickListener onClickListener) {
            this.f57243g = onClickListener;
        }

        public b(View view) {
            super(view);
            this.f57242f = view.findViewById(R.id.bg_ad_card_gift);
            this.f57238b = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.f57237a = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.f57239c = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.f57240d = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.f57241e = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.f57238b.setRadius(d.a.c.e.p.l.g(a().getContext(), R.dimen.tbds20));
            this.f57238b.setConrers(5);
            this.f57238b.setDefaultBgResource(R.color.cp_atp_a);
            this.f57238b.setDrawCorner(true);
            this.f57239c.setOnClickListener(new View$OnClickListenerC1328a());
            this.f57240d.setMax(100);
        }
    }

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.v = new View$OnClickListenerC1327a();
        this.s = new d.a.n0.e2.k.e.z0.b(pbFragment);
    }

    @Override // d.a.n0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i2, view, viewGroup, (d.a.n0.e2.h.a) obj, (b) viewHolder);
        return view;
    }

    public final void m0(d.a.n0.e2.h.a aVar) {
        d.a.n0.d3.c.g().c(this.n.getUniqueId(), d.a.n0.d3.a.e(this.u.L(), "a005", "common_click", 1, aVar.f56595f, true, aVar.f56594e.f56596a + "", null, 18));
    }

    public void onDestroy() {
        d.a.n0.e2.k.e.z0.b bVar = this.s;
        if (bVar != null) {
            bVar.q();
        }
    }

    public final void p0(d.a.n0.e2.h.a aVar) {
        String str = aVar.f56594e.f56596a + "";
        d.a.n0.d3.c.g().d(this.n.getUniqueId(), d.a.n0.d3.a.c(this.u.L().z1(), str, "", null), d.a.n0.d3.a.g(this.u.L(), "a005", "common_exp", aVar.f56595f, true, str, "", 18));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: q0 */
    public b Q(ViewGroup viewGroup) {
        b bVar = new b(LayoutInflater.from(this.f42909e).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false), null);
        bVar.f(this.v);
        return bVar;
    }

    public View s0(int i2, View view, ViewGroup viewGroup, d.a.n0.e2.h.a aVar, b bVar) {
        super.X(i2, view, viewGroup, aVar, bVar);
        if (aVar != null && bVar != null) {
            aVar.f56595f = i2 + 1;
            this.t = aVar;
            p0(aVar);
            bVar.d(this.f42909e, aVar.f56594e);
        }
        return view;
    }

    public void t(e eVar) {
        this.u = eVar;
        d.a.n0.e2.k.e.z0.b bVar = this.s;
        if (bVar != null) {
            bVar.v(eVar);
        }
    }
}
