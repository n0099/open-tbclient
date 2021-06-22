package d.a.o0.e2.k.e.z0;

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
import d.a.n0.z0.l;
import d.a.o0.e2.h.e;
import d.a.o0.e2.k.e.o;
/* loaded from: classes5.dex */
public class a extends o<d.a.o0.e2.h.a, b> {
    public d.a.o0.e2.k.e.z0.b s;
    public d.a.o0.e2.h.a t;
    public e u;
    public View.OnClickListener v;

    /* renamed from: d.a.o0.e2.k.e.z0.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1331a implements View.OnClickListener {
        public View$OnClickListenerC1331a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.t == null || a.this.t.f56719e == null || l.a()) {
                return;
            }
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.checkUpIsLogin(a.this.n.getPageContext().getPageActivity());
                return;
            }
            a aVar = a.this;
            aVar.m0(aVar.t);
            if (a.this.t.f56719e.b()) {
                UrlManager.getInstance().dealOneLink((TbPageContext<?>) a.this.n.getPageContext(), new String[]{TbConfig.URL_JUMP_TAG_CARDBOX}, true);
            } else if (a.this.t.f56719e.a()) {
                a.this.s.u(a.this.t);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public TextView f57362a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f57363b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f57364c;

        /* renamed from: d  reason: collision with root package name */
        public ProgressBar f57365d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f57366e;

        /* renamed from: f  reason: collision with root package name */
        public View f57367f;

        /* renamed from: g  reason: collision with root package name */
        public View.OnClickListener f57368g;

        /* renamed from: d.a.o0.e2.k.e.z0.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class View$OnClickListenerC1332a implements View.OnClickListener {
            public View$OnClickListenerC1332a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.f57368g != null) {
                    b.this.f57368g.onClick(view);
                }
            }
        }

        public /* synthetic */ b(View view, View$OnClickListenerC1331a view$OnClickListenerC1331a) {
            this(view);
        }

        public final void d(Context context, d.a.o0.e2.h.b bVar) {
            if (bVar == null) {
                return;
            }
            this.f57366e.setText(bVar.f56723c);
            this.f57363b.U(bVar.f56722b, 38, false);
            this.f57362a.setText(context.getResources().getString(R.string.pb_ad_card_gift_rate, bVar.f56724d) + "%");
            int d2 = d.a.c.e.m.b.d(bVar.f56724d, 0);
            if (d2 > 100) {
                d2 = 100;
            } else if (d2 < 0) {
                d2 = 0;
            }
            this.f57365d.setProgress(d2);
            if (bVar.a()) {
                this.f57364c.setText(R.string.pb_ad_card_gift_get);
                SkinManager.setViewTextColor(this.f57364c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f57364c, R.drawable.btn_pb_ad_card_gift_get);
                this.f57364c.setClickable(true);
            } else if (bVar.b()) {
                this.f57364c.setText(R.string.pb_ad_card_gift_watch_btn);
                SkinManager.setViewTextColor(this.f57364c, R.color.CAM_X0101);
                SkinManager.setBackgroundResource(this.f57364c, R.drawable.btn_pb_ad_card_gift_watch);
                this.f57364c.setClickable(true);
            } else {
                this.f57364c.setText(R.string.pb_ad_card_gift_over_btn);
                SkinManager.setViewTextColor(this.f57364c, R.color.CAM_X0109);
                this.f57364c.setBackgroundResource(R.drawable.transparent_bg);
                this.f57364c.setClickable(false);
            }
            e();
        }

        public final void e() {
            SkinManager.setBackgroundResource(this.f57367f, R.drawable.bg_pb_ad_card_gift);
            SkinManager.setViewTextColor(this.f57366e, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f57362a, R.color.CAM_X0107);
            this.f57365d.setProgressDrawable(SkinManager.getDrawable(R.drawable.bg_pb_ad_card_gift_progress));
        }

        public void f(View.OnClickListener onClickListener) {
            this.f57368g = onClickListener;
        }

        public b(View view) {
            super(view);
            this.f57367f = view.findViewById(R.id.bg_ad_card_gift);
            this.f57363b = (TbImageView) view.findViewById(R.id.img_ad_card_gift_logo);
            this.f57362a = (TextView) view.findViewById(R.id.txt_ad_card_gift_rate);
            this.f57364c = (TextView) view.findViewById(R.id.btn_ad_card_gift_get);
            this.f57365d = (ProgressBar) view.findViewById(R.id.progress_ad_card_gift);
            this.f57366e = (TextView) view.findViewById(R.id.txt_ad_card_gift_title);
            this.f57363b.setRadius(d.a.c.e.p.l.g(a().getContext(), R.dimen.tbds20));
            this.f57363b.setConrers(5);
            this.f57363b.setDefaultBgResource(R.color.cp_atp_a);
            this.f57363b.setDrawCorner(true);
            this.f57364c.setOnClickListener(new View$OnClickListenerC1332a());
            this.f57365d.setMax(100);
        }
    }

    public a(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        this.v = new View$OnClickListenerC1331a();
        this.s = new d.a.o0.e2.k.e.z0.b(pbFragment);
    }

    @Override // d.a.o0.e2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        s0(i2, view, viewGroup, (d.a.o0.e2.h.a) obj, (b) viewHolder);
        return view;
    }

    public final void m0(d.a.o0.e2.h.a aVar) {
        d.a.o0.d3.c.g().c(this.n.getUniqueId(), d.a.o0.d3.a.e(this.u.L(), "a005", "common_click", 1, aVar.f56720f, true, aVar.f56719e.f56721a + "", null, 18));
    }

    public void onDestroy() {
        d.a.o0.e2.k.e.z0.b bVar = this.s;
        if (bVar != null) {
            bVar.q();
        }
    }

    public final void p0(d.a.o0.e2.h.a aVar) {
        String str = aVar.f56719e.f56721a + "";
        d.a.o0.d3.c.g().d(this.n.getUniqueId(), d.a.o0.d3.a.c(this.u.L().z1(), str, "", null), d.a.o0.d3.a.g(this.u.L(), "a005", "common_exp", aVar.f56720f, true, str, "", 18));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: q0 */
    public b Q(ViewGroup viewGroup) {
        b bVar = new b(LayoutInflater.from(this.f43012e).inflate(R.layout.pb_ad_card_gift_item, viewGroup, false), null);
        bVar.f(this.v);
        return bVar;
    }

    public View s0(int i2, View view, ViewGroup viewGroup, d.a.o0.e2.h.a aVar, b bVar) {
        super.X(i2, view, viewGroup, aVar, bVar);
        if (aVar != null && bVar != null) {
            aVar.f56720f = i2 + 1;
            this.t = aVar;
            p0(aVar);
            bVar.d(this.f43012e, aVar.f56719e);
        }
        return view;
    }

    public void t(e eVar) {
        this.u = eVar;
        d.a.o0.e2.k.e.z0.b bVar = this.s;
        if (bVar != null) {
            bVar.v(eVar);
        }
    }
}
