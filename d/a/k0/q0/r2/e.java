package d.a.k0.q0.r2;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.c.j.e.n;
import d.a.c.j.e.w;
import d.a.j0.r.q.a2;
import d.a.j0.r.s.a;
import d.a.k0.d3.j0.a;
import d.a.k0.d3.k;
import d.a.k0.d3.o;
import d.a.k0.d3.p;
import d.a.k0.u3.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter implements d.a.k0.q0.j2.d {

    /* renamed from: e  reason: collision with root package name */
    public List<n> f59436e;

    /* renamed from: f  reason: collision with root package name */
    public Context f59437f;
    public UserData j;
    public w k;
    public boolean o;

    /* renamed from: h  reason: collision with root package name */
    public String f59439h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f59440i = "";
    public int l = SkinManager.getColor(R.color.CAM_X0302);
    public String m = "";
    public HashSet<String> n = new HashSet<>();
    public d.a.k0.q0.j2.b p = new d.a.k0.q0.j2.b();
    public final View.OnClickListener q = new a();
    public View.OnClickListener r = new b();

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f59438g = p();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1536e c1536e;
            TextView textView;
            if ((e.this.f59437f == null || ViewHelper.checkUpIsLogin(e.this.f59437f)) && view != null) {
                if ((view.getTag() instanceof k) || (view.getTag() instanceof C1536e)) {
                    k kVar = null;
                    if (view.getTag() instanceof k) {
                        kVar = (k) view.getTag();
                    } else if ((view.getTag() instanceof C1536e) && (textView = (c1536e = (C1536e) view.getTag()).f59450c) != null && (textView.getTag() instanceof k)) {
                        kVar = (k) c1536e.f59450c.getTag();
                    }
                    if (kVar != null && kVar.l() == 2) {
                        if (StringUtils.isNull(kVar.k())) {
                            return;
                        }
                        String k = kVar.k();
                        if ((k.contains("nohead:url") || k.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.L(e.this.f59437f, R.string.book_plugin_not_install_tip);
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(e.this.f59438g, new String[]{k});
                        a.b b2 = d.a.k0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.e(), e.this.f59439h, e.this.f59440i, null);
                        b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
                        b2.f();
                    } else if (kVar == null || kVar.l() != 3) {
                    } else {
                        new StatisticItem("c13442").param("forum_id", e.this.f59439h).eventStat();
                        if (e.this.f59438g == null || TextUtils.isEmpty(e.this.f59439h)) {
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.f59438g.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(e.this.f59439h, 0L), 1)));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1536e c1536e;
            view.setPressed(false);
            if (e.this.k == null || !(view.getTag() instanceof C1536e) || (c1536e = (C1536e) view.getTag()) == null) {
                return;
            }
            n nVar = (n) ListUtils.getItem(e.this.f59436e, c1536e.f59448a);
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                e.this.k.b(view, a2Var, BdUniqueId.gen(), null, e.this.o ? c1536e.f59448a + 1 : c1536e.f59448a, 0L);
                TiebaStatic.log(new StatisticItem("c13124").param("fid", a2Var.c0()).param("tid", a2Var.x1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", c1536e.f59448a + 1));
            } else if (nVar instanceof p) {
                e.this.k.b(view, (p) nVar, BdUniqueId.gen(), null, c1536e.f59448a, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f59443e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f59444f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f59445g;

        public c(f fVar, String str, String str2) {
            this.f59443e = fVar;
            this.f59444f = str;
            this.f59445g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f59443e.f59450c.getLayout().getEllipsisCount(this.f59443e.f59450c.getLineCount() - 1) > 0) {
                e.this.x(this.f59444f, this.f59445g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f59447e;

        public d(e eVar, d.a.j0.r.s.a aVar) {
            this.f59447e = aVar;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            this.f59447e.dismiss();
        }
    }

    /* renamed from: d.a.k0.q0.r2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1536e {

        /* renamed from: a  reason: collision with root package name */
        public int f59448a;

        /* renamed from: b  reason: collision with root package name */
        public View f59449b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59450c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f59451d;

        public C1536e(e eVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class f extends C1536e {

        /* renamed from: e  reason: collision with root package name */
        public TextView f59452e;

        public f(e eVar) {
            super(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends C1536e {

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f59453e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f59454f;

        public g(e eVar) {
            super(eVar);
        }
    }

    public e(Context context) {
        this.f59437f = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f59436e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return ListUtils.getItem(this.f59436e, i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        f fVar;
        g gVar;
        if (getItemViewType(i2) == 1) {
            if (view != null && (view.getTag() instanceof g)) {
                gVar = (g) view.getTag();
            } else {
                gVar = new g(this);
                view = LayoutInflater.from(this.f59437f).inflate(R.layout.frs_header_top_item_single, (ViewGroup) null, false);
                gVar.f59449b = view;
                gVar.f59453e = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                gVar.f59450c = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                gVar.f59451d = (TextView) view.findViewById(R.id.top_item_type);
                gVar.f59454f = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(gVar);
            }
            m(gVar, (n) ListUtils.getItem(this.f59436e, i2));
        } else if (getItemViewType(i2) == 2) {
            if (view != null && (view.getTag() instanceof f)) {
                fVar = (f) view.getTag();
            } else {
                fVar = new f(this);
                view = LayoutInflater.from(this.f59437f).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                fVar.f59449b = view;
                fVar.f59451d = (TextView) view.findViewById(R.id.top_item_type);
                fVar.f59450c = (TextView) view.findViewById(R.id.top_item_title);
                fVar.f59452e = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(fVar);
            }
            n nVar = (n) ListUtils.getItem(this.f59436e, i2);
            if (nVar instanceof a2) {
                j(fVar, (a2) nVar, i2);
                fVar.f59448a = i2;
            } else if (nVar instanceof k) {
                k(fVar, (k) nVar);
            } else if (nVar instanceof o) {
                y((o) nVar, fVar, i2);
            } else if (nVar instanceof p) {
                fVar.f59448a = i2;
                l(fVar, (p) nVar, i2);
            }
        }
        return view;
    }

    public final void h(C1536e c1536e) {
        if (c1536e == null) {
            return;
        }
        SkinManager.setViewTextColor(c1536e.f59450c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(c1536e.f59451d, R.color.CAM_X0101);
    }

    @Override // d.a.k0.q0.j2.d
    public d.a.k0.q0.j2.b i() {
        return this.p;
    }

    public final void j(f fVar, a2 a2Var, int i2) {
        if (fVar == null || a2Var == null) {
            return;
        }
        fVar.f59451d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f59437f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f59451d);
        a2Var.W2();
        SpannableStringBuilder l1 = a2Var.l1();
        if ((l1 == null || d.a.c.e.p.k.isEmptyStringAfterTrim(l1.toString())) && a2Var.D() != null) {
            l1 = new SpannableStringBuilder(a2Var.D());
        }
        fVar.f59450c.setOnTouchListener(new i(l1));
        fVar.f59450c.setText(l1);
        fVar.f59449b.setOnClickListener(this.r);
        h(fVar);
    }

    public final void k(f fVar, k kVar) {
        String o = o(kVar);
        fVar.f59450c.setText(kVar.h());
        fVar.f59451d.setText(o);
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f59437f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f59451d);
        if (kVar.f() != 0) {
            fVar.f59452e.setVisibility(0);
            if (kVar.f() == -1) {
                fVar.f59452e.setText(this.f59437f.getString(R.string.no_rank));
            } else if (kVar.f() > 999) {
                fVar.f59452e.setText(this.f59437f.getString(R.string.rang_orer_thousand));
            } else {
                TextView textView = fVar.f59452e;
                textView.setText(this.f59437f.getString(R.string.rang_identify) + kVar.f());
            }
            if (!StringUtils.isNull(kVar.h())) {
                fVar.f59450c.setText(kVar.h());
            }
        } else {
            fVar.f59452e.setVisibility(8);
        }
        h(fVar);
        fVar.f59450c.setTag(kVar);
        View.OnClickListener onClickListener = this.q;
        if (onClickListener != null) {
            fVar.f59449b.setOnClickListener(onClickListener);
        }
        HashSet<String> hashSet = this.n;
        if (hashSet == null || !hashSet.add(kVar.e())) {
            return;
        }
        a.b b2 = d.a.k0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.e(), this.f59439h, this.f59440i, null);
        b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
        b2.f();
    }

    public final void l(f fVar, p pVar, int i2) {
        if (fVar == null || pVar == null || pVar.c() == null || this.j == null) {
            return;
        }
        fVar.f59451d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f59437f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f59451d);
        if (this.j.getIs_manager() == 1) {
            if (pVar.c().audit_status.intValue() == 0 && pVar.c().has_forum_rule.intValue() == 0) {
                fVar.f59450c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
            } else if (pVar.c().audit_status.intValue() == 0) {
                fVar.f59450c.setText(pVar.c().title);
            } else if (pVar.c().audit_status.intValue() == 1) {
                fVar.f59450c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
            } else if (pVar.c().audit_status.intValue() == 2) {
                fVar.f59450c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
            }
        } else {
            fVar.f59450c.setText(pVar.c().title);
        }
        fVar.f59449b.setOnClickListener(this.r);
        h(fVar);
    }

    public final void m(g gVar, n nVar) {
        if (gVar == null || nVar == null) {
            return;
        }
        if (nVar instanceof a2) {
            a2 a2Var = (a2) nVar;
            a2Var.W2();
            SpannableStringBuilder l1 = a2Var.l1();
            if ((l1 == null || d.a.c.e.p.k.isEmptyStringAfterTrim(l1.toString())) && a2Var.D() != null) {
                l1 = new SpannableStringBuilder(a2Var.D());
            }
            gVar.f59451d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            gVar.f59450c.setOnTouchListener(new i(l1));
            gVar.f59450c.setText(l1);
            if (StringUtils.isNull(this.m)) {
                gVar.f59453e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f59451d.getLayoutParams();
                layoutParams.setMargins((int) this.f59437f.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.f59453e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f59451d.getLayoutParams();
                layoutParams2.setMargins((int) this.f59437f.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.f59453e.V(this.m, 10, false);
            }
            gVar.f59451d.setTextColor(this.l);
            gVar.f59449b.setOnClickListener(this.r);
            h(gVar);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.m)) {
                gVar.f59451d.setText(o);
                gVar.f59451d.setVisibility(0);
                gVar.f59450c.setText(kVar.h());
                gVar.f59453e.setVisibility(8);
            } else {
                gVar.f59451d.setVisibility(8);
                gVar.f59453e.setVisibility(0);
                TextView textView = gVar.f59450c;
                textView.setText(o + "：" + kVar.h());
                gVar.f59453e.V(this.m, 10, false);
            }
            if (kVar.f() != 0) {
                gVar.f59454f.setVisibility(0);
                if (kVar.f() == -1) {
                    gVar.f59454f.setText(this.f59437f.getString(R.string.no_rank));
                } else if (kVar.f() > 999) {
                    gVar.f59454f.setText(this.f59437f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView2 = gVar.f59454f;
                    textView2.setText(this.f59437f.getString(R.string.rang_identify) + kVar.f());
                }
                if (!StringUtils.isNull(kVar.h())) {
                    gVar.f59450c.setText(kVar.h());
                }
            } else {
                gVar.f59454f.setVisibility(8);
            }
            gVar.f59451d.setTextColor(this.l);
            h(gVar);
            gVar.f59450c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                gVar.f59449b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.e())) {
                return;
            }
            a.b b2 = d.a.k0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.e(), this.f59439h, this.f59440i, null);
            b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
            b2.f();
        }
    }

    public List<n> n() {
        return this.f59436e;
    }

    public final String o(k kVar) {
        if (!TextUtils.isEmpty(kVar.i()) && kVar.i().trim().length() != 0) {
            return kVar.i();
        }
        if (kVar.c() == 1) {
            return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
        }
        return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
    }

    public TbPageContext p() {
        Context context = this.f59437f;
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public void q(BdUniqueId bdUniqueId) {
    }

    public void r(List<n> list) {
        this.f59436e = list;
        notifyDataSetChanged();
    }

    public void s(String str, String str2, UserData userData) {
        this.f59439h = str;
        this.f59440i = str2;
        this.j = userData;
    }

    public void t(ForumData forumData) {
    }

    public void u(String str) {
        this.m = str;
    }

    public void v(w wVar) {
        this.k = wVar;
    }

    public void w(int i2) {
        this.l = i2;
    }

    public final void x(String str, String str2) {
        if (d.a.c.e.p.k.isEmpty(str) || d.a.c.e.p.k.isEmpty(str2)) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a((BaseFragmentActivity) this.f59437f);
        aVar.setTitle(str2);
        aVar.setTitleShowCenter(true);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.frs_risk_dialog_button_text, new d(this, aVar));
        aVar.create(p()).show();
    }

    public final boolean y(o oVar, f fVar, int i2) {
        if (i2 != 0 || oVar == null || oVar.c() == null) {
            return false;
        }
        ForumData c2 = oVar.c();
        boolean z = oVar.e() && !ListUtils.isEmpty(c2.getTipInfos());
        String riskTipNotice = z ? c2.getTipInfos().get(0).tip_notice : c2.getRiskTipNotice();
        String riskTipPopTitle = z ? c2.getTipInfos().get(0).tip_pop_title : c2.getRiskTipPopTitle();
        String riskTipPop = z ? c2.getTipInfos().get(0).tip_pop : c2.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        fVar.f59451d.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f59437f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f59451d);
        fVar.f59450c.setText(riskTipNotice);
        fVar.f59450c.setOnClickListener(new c(fVar, riskTipPop, riskTipPopTitle));
        h(fVar);
        return true;
    }
}
