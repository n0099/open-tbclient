package d.b.j0.q0.r2;

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
import d.b.c.e.p.l;
import d.b.c.j.e.n;
import d.b.c.j.e.w;
import d.b.i0.r.q.a2;
import d.b.i0.r.s.a;
import d.b.j0.d3.j0.a;
import d.b.j0.d3.k;
import d.b.j0.d3.o;
import d.b.j0.d3.p;
import d.b.j0.u3.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter implements d.b.j0.q0.j2.d {

    /* renamed from: e  reason: collision with root package name */
    public List<n> f60590e;

    /* renamed from: f  reason: collision with root package name */
    public Context f60591f;
    public UserData j;
    public w k;
    public boolean o;

    /* renamed from: h  reason: collision with root package name */
    public String f60593h = "";
    public String i = "";
    public int l = SkinManager.getColor(R.color.CAM_X0302);
    public String m = "";
    public HashSet<String> n = new HashSet<>();
    public d.b.j0.q0.j2.b p = new d.b.j0.q0.j2.b();
    public final View.OnClickListener q = new a();
    public View.OnClickListener r = new b();

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f60592g = p();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1523e c1523e;
            TextView textView;
            if ((e.this.f60591f == null || ViewHelper.checkUpIsLogin(e.this.f60591f)) && view != null) {
                if ((view.getTag() instanceof k) || (view.getTag() instanceof C1523e)) {
                    k kVar = null;
                    if (view.getTag() instanceof k) {
                        kVar = (k) view.getTag();
                    } else if ((view.getTag() instanceof C1523e) && (textView = (c1523e = (C1523e) view.getTag()).f60603c) != null && (textView.getTag() instanceof k)) {
                        kVar = (k) c1523e.f60603c.getTag();
                    }
                    if (kVar != null && kVar.l() == 2) {
                        if (StringUtils.isNull(kVar.k())) {
                            return;
                        }
                        String k = kVar.k();
                        if ((k.contains("nohead:url") || k.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.K(e.this.f60591f, R.string.book_plugin_not_install_tip);
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(e.this.f60592g, new String[]{k});
                        a.b b2 = d.b.j0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.e(), e.this.f60593h, e.this.i, null);
                        b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
                        b2.f();
                    } else if (kVar == null || kVar.l() != 3) {
                    } else {
                        new StatisticItem("c13442").param("forum_id", e.this.f60593h).eventStat();
                        if (e.this.f60592g == null || TextUtils.isEmpty(e.this.f60593h)) {
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.f60592g.getPageActivity()).createNormalConfig(d.b.c.e.m.b.f(e.this.f60593h, 0L), 1)));
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
            C1523e c1523e;
            view.setPressed(false);
            if (e.this.k == null || !(view.getTag() instanceof C1523e) || (c1523e = (C1523e) view.getTag()) == null) {
                return;
            }
            n nVar = (n) ListUtils.getItem(e.this.f60590e, c1523e.f60601a);
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                e.this.k.f(view, a2Var, BdUniqueId.gen(), null, e.this.o ? c1523e.f60601a + 1 : c1523e.f60601a, 0L);
                TiebaStatic.log(new StatisticItem("c13124").param("fid", a2Var.c0()).param("tid", a2Var.w1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", c1523e.f60601a + 1));
            } else if (nVar instanceof p) {
                e.this.k.f(view, (p) nVar, BdUniqueId.gen(), null, c1523e.f60601a, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f60596e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f60597f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f60598g;

        public c(f fVar, String str, String str2) {
            this.f60596e = fVar;
            this.f60597f = str;
            this.f60598g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f60596e.f60603c.getLayout().getEllipsisCount(this.f60596e.f60603c.getLineCount() - 1) > 0) {
                e.this.x(this.f60597f, this.f60598g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f60600e;

        public d(e eVar, d.b.i0.r.s.a aVar) {
            this.f60600e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f60600e.dismiss();
        }
    }

    /* renamed from: d.b.j0.q0.r2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1523e {

        /* renamed from: a  reason: collision with root package name */
        public int f60601a;

        /* renamed from: b  reason: collision with root package name */
        public View f60602b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60603c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60604d;

        public C1523e(e eVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class f extends C1523e {

        /* renamed from: e  reason: collision with root package name */
        public TextView f60605e;

        public f(e eVar) {
            super(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends C1523e {

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f60606e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60607f;

        public g(e eVar) {
            super(eVar);
        }
    }

    public e(Context context) {
        this.f60591f = context;
    }

    @Override // d.b.j0.q0.j2.d
    public d.b.j0.q0.j2.b b() {
        return this.p;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f60590e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return ListUtils.getItem(this.f60590e, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        f fVar;
        g gVar;
        if (getItemViewType(i) == 1) {
            if (view != null && (view.getTag() instanceof g)) {
                gVar = (g) view.getTag();
            } else {
                gVar = new g(this);
                view = LayoutInflater.from(this.f60591f).inflate(R.layout.frs_header_top_item_single, (ViewGroup) null, false);
                gVar.f60602b = view;
                gVar.f60606e = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                gVar.f60603c = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                gVar.f60604d = (TextView) view.findViewById(R.id.top_item_type);
                gVar.f60607f = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(gVar);
            }
            m(gVar, (n) ListUtils.getItem(this.f60590e, i));
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof f)) {
                fVar = (f) view.getTag();
            } else {
                fVar = new f(this);
                view = LayoutInflater.from(this.f60591f).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                fVar.f60602b = view;
                fVar.f60604d = (TextView) view.findViewById(R.id.top_item_type);
                fVar.f60603c = (TextView) view.findViewById(R.id.top_item_title);
                fVar.f60605e = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(fVar);
            }
            n nVar = (n) ListUtils.getItem(this.f60590e, i);
            if (nVar instanceof a2) {
                j(fVar, (a2) nVar, i);
                fVar.f60601a = i;
            } else if (nVar instanceof k) {
                k(fVar, (k) nVar);
            } else if (nVar instanceof o) {
                y((o) nVar, fVar, i);
            } else if (nVar instanceof p) {
                fVar.f60601a = i;
                l(fVar, (p) nVar, i);
            }
        }
        return view;
    }

    public final void i(C1523e c1523e) {
        if (c1523e == null) {
            return;
        }
        SkinManager.setViewTextColor(c1523e.f60603c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(c1523e.f60604d, R.color.CAM_X0101);
    }

    public final void j(f fVar, a2 a2Var, int i) {
        if (fVar == null || a2Var == null) {
            return;
        }
        fVar.f60604d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f60591f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f60604d);
        a2Var.U2();
        SpannableStringBuilder l1 = a2Var.l1();
        if ((l1 == null || d.b.c.e.p.k.isEmptyStringAfterTrim(l1.toString())) && a2Var.D() != null) {
            l1 = new SpannableStringBuilder(a2Var.D());
        }
        fVar.f60603c.setOnTouchListener(new i(l1));
        fVar.f60603c.setText(l1);
        fVar.f60602b.setOnClickListener(this.r);
        i(fVar);
    }

    public final void k(f fVar, k kVar) {
        String o = o(kVar);
        fVar.f60603c.setText(kVar.g());
        fVar.f60604d.setText(o);
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f60591f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f60604d);
        if (kVar.f() != 0) {
            fVar.f60605e.setVisibility(0);
            if (kVar.f() == -1) {
                fVar.f60605e.setText(this.f60591f.getString(R.string.no_rank));
            } else if (kVar.f() > 999) {
                fVar.f60605e.setText(this.f60591f.getString(R.string.rang_orer_thousand));
            } else {
                TextView textView = fVar.f60605e;
                textView.setText(this.f60591f.getString(R.string.rang_identify) + kVar.f());
            }
            if (!StringUtils.isNull(kVar.g())) {
                fVar.f60603c.setText(kVar.g());
            }
        } else {
            fVar.f60605e.setVisibility(8);
        }
        i(fVar);
        fVar.f60603c.setTag(kVar);
        View.OnClickListener onClickListener = this.q;
        if (onClickListener != null) {
            fVar.f60602b.setOnClickListener(onClickListener);
        }
        HashSet<String> hashSet = this.n;
        if (hashSet == null || !hashSet.add(kVar.e())) {
            return;
        }
        a.b b2 = d.b.j0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.e(), this.f60593h, this.i, null);
        b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
        b2.f();
    }

    public final void l(f fVar, p pVar, int i) {
        if (fVar == null || pVar == null || pVar.a() == null || this.j == null) {
            return;
        }
        fVar.f60604d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f60591f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f60604d);
        if (this.j.getIs_manager() == 1) {
            if (pVar.a().audit_status.intValue() == 0 && pVar.a().has_forum_rule.intValue() == 0) {
                fVar.f60603c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
            } else if (pVar.a().audit_status.intValue() == 0) {
                fVar.f60603c.setText(pVar.a().title);
            } else if (pVar.a().audit_status.intValue() == 1) {
                fVar.f60603c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
            } else if (pVar.a().audit_status.intValue() == 2) {
                fVar.f60603c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
            }
        } else {
            fVar.f60603c.setText(pVar.a().title);
        }
        fVar.f60602b.setOnClickListener(this.r);
        i(fVar);
    }

    public final void m(g gVar, n nVar) {
        if (gVar == null || nVar == null) {
            return;
        }
        if (nVar instanceof a2) {
            a2 a2Var = (a2) nVar;
            a2Var.U2();
            SpannableStringBuilder l1 = a2Var.l1();
            if ((l1 == null || d.b.c.e.p.k.isEmptyStringAfterTrim(l1.toString())) && a2Var.D() != null) {
                l1 = new SpannableStringBuilder(a2Var.D());
            }
            gVar.f60604d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            gVar.f60603c.setOnTouchListener(new i(l1));
            gVar.f60603c.setText(l1);
            if (StringUtils.isNull(this.m)) {
                gVar.f60606e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f60604d.getLayoutParams();
                layoutParams.setMargins((int) this.f60591f.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.f60606e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f60604d.getLayoutParams();
                layoutParams2.setMargins((int) this.f60591f.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.f60606e.W(this.m, 10, false);
            }
            gVar.f60604d.setTextColor(this.l);
            gVar.f60602b.setOnClickListener(this.r);
            i(gVar);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.m)) {
                gVar.f60604d.setText(o);
                gVar.f60604d.setVisibility(0);
                gVar.f60603c.setText(kVar.g());
                gVar.f60606e.setVisibility(8);
            } else {
                gVar.f60604d.setVisibility(8);
                gVar.f60606e.setVisibility(0);
                TextView textView = gVar.f60603c;
                textView.setText(o + "：" + kVar.g());
                gVar.f60606e.W(this.m, 10, false);
            }
            if (kVar.f() != 0) {
                gVar.f60607f.setVisibility(0);
                if (kVar.f() == -1) {
                    gVar.f60607f.setText(this.f60591f.getString(R.string.no_rank));
                } else if (kVar.f() > 999) {
                    gVar.f60607f.setText(this.f60591f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView2 = gVar.f60607f;
                    textView2.setText(this.f60591f.getString(R.string.rang_identify) + kVar.f());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    gVar.f60603c.setText(kVar.g());
                }
            } else {
                gVar.f60607f.setVisibility(8);
            }
            gVar.f60604d.setTextColor(this.l);
            i(gVar);
            gVar.f60603c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                gVar.f60602b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.e())) {
                return;
            }
            a.b b2 = d.b.j0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.e(), this.f60593h, this.i, null);
            b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
            b2.f();
        }
    }

    public List<n> n() {
        return this.f60590e;
    }

    public final String o(k kVar) {
        if (!TextUtils.isEmpty(kVar.j()) && kVar.j().trim().length() != 0) {
            return kVar.j();
        }
        if (kVar.a() == 1) {
            return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
        }
        return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
    }

    public TbPageContext p() {
        Context context = this.f60591f;
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public void q(BdUniqueId bdUniqueId) {
    }

    public void r(List<n> list) {
        this.f60590e = list;
        notifyDataSetChanged();
    }

    public void s(String str, String str2, UserData userData) {
        this.f60593h = str;
        this.i = str2;
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

    public void w(int i) {
        this.l = i;
    }

    public final void x(String str, String str2) {
        if (d.b.c.e.p.k.isEmpty(str) || d.b.c.e.p.k.isEmpty(str2)) {
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a((BaseFragmentActivity) this.f60591f);
        aVar.setTitle(str2);
        aVar.setTitleShowCenter(true);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.frs_risk_dialog_button_text, new d(this, aVar));
        aVar.create(p()).show();
    }

    public final boolean y(o oVar, f fVar, int i) {
        if (i != 0 || oVar == null || oVar.a() == null) {
            return false;
        }
        ForumData a2 = oVar.a();
        boolean z = oVar.e() && !ListUtils.isEmpty(a2.getTipInfos());
        String riskTipNotice = z ? a2.getTipInfos().get(0).tip_notice : a2.getRiskTipNotice();
        String riskTipPopTitle = z ? a2.getTipInfos().get(0).tip_pop_title : a2.getRiskTipPopTitle();
        String riskTipPop = z ? a2.getTipInfos().get(0).tip_pop : a2.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        fVar.f60604d.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f60591f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f60604d);
        fVar.f60603c.setText(riskTipNotice);
        fVar.f60603c.setOnClickListener(new c(fVar, riskTipPop, riskTipPopTitle));
        i(fVar);
        return true;
    }
}
