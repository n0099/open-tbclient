package d.a.o0.r0.r2;

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
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.n0.r.q.a2;
import d.a.n0.r.s.a;
import d.a.o0.e3.j0.a;
import d.a.o0.e3.k;
import d.a.o0.e3.o;
import d.a.o0.e3.p;
import d.a.o0.v3.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter implements d.a.o0.r0.j2.d {

    /* renamed from: e  reason: collision with root package name */
    public List<n> f63393e;

    /* renamed from: f  reason: collision with root package name */
    public Context f63394f;
    public UserData j;
    public w k;
    public boolean o;

    /* renamed from: h  reason: collision with root package name */
    public String f63396h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f63397i = "";
    public int l = SkinManager.getColor(R.color.CAM_X0302);
    public String m = "";
    public HashSet<String> n = new HashSet<>();
    public d.a.o0.r0.j2.b p = new d.a.o0.r0.j2.b();
    public final View.OnClickListener q = new a();
    public View.OnClickListener r = new b();

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f63395g = p();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1609e c1609e;
            TextView textView;
            if ((e.this.f63394f == null || ViewHelper.checkUpIsLogin(e.this.f63394f)) && view != null) {
                if ((view.getTag() instanceof k) || (view.getTag() instanceof C1609e)) {
                    k kVar = null;
                    if (view.getTag() instanceof k) {
                        kVar = (k) view.getTag();
                    } else if ((view.getTag() instanceof C1609e) && (textView = (c1609e = (C1609e) view.getTag()).f63407c) != null && (textView.getTag() instanceof k)) {
                        kVar = (k) c1609e.f63407c.getTag();
                    }
                    if (kVar != null && kVar.k() == 2) {
                        if (StringUtils.isNull(kVar.i())) {
                            return;
                        }
                        String i2 = kVar.i();
                        if ((i2.contains("nohead:url") || i2.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.L(e.this.f63394f, R.string.book_plugin_not_install_tip);
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(e.this.f63395g, new String[]{i2});
                        a.b b2 = d.a.o0.e3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.c(), e.this.f63396h, e.this.f63397i, null);
                        b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
                        b2.f();
                    } else if (kVar == null || kVar.k() != 3) {
                    } else {
                        new StatisticItem("c13442").param("forum_id", e.this.f63396h).eventStat();
                        if (e.this.f63395g == null || TextUtils.isEmpty(e.this.f63396h)) {
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.f63395g.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(e.this.f63396h, 0L), 1)));
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
            C1609e c1609e;
            view.setPressed(false);
            if (e.this.k == null || !(view.getTag() instanceof C1609e) || (c1609e = (C1609e) view.getTag()) == null) {
                return;
            }
            n nVar = (n) ListUtils.getItem(e.this.f63393e, c1609e.f63405a);
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                e.this.k.b(view, a2Var, BdUniqueId.gen(), null, e.this.o ? c1609e.f63405a + 1 : c1609e.f63405a, 0L);
                TiebaStatic.log(new StatisticItem("c13124").param("fid", a2Var.c0()).param("tid", a2Var.z1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", c1609e.f63405a + 1));
            } else if (nVar instanceof p) {
                e.this.k.b(view, (p) nVar, BdUniqueId.gen(), null, c1609e.f63405a, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f63400e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63401f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f63402g;

        public c(f fVar, String str, String str2) {
            this.f63400e = fVar;
            this.f63401f = str;
            this.f63402g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f63400e.f63407c.getLayout().getEllipsisCount(this.f63400e.f63407c.getLineCount() - 1) > 0) {
                e.this.x(this.f63401f, this.f63402g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f63404e;

        public d(e eVar, d.a.n0.r.s.a aVar) {
            this.f63404e = aVar;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            this.f63404e.dismiss();
        }
    }

    /* renamed from: d.a.o0.r0.r2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1609e {

        /* renamed from: a  reason: collision with root package name */
        public int f63405a;

        /* renamed from: b  reason: collision with root package name */
        public View f63406b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63407c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63408d;

        public C1609e(e eVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class f extends C1609e {

        /* renamed from: e  reason: collision with root package name */
        public TextView f63409e;

        public f(e eVar) {
            super(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends C1609e {

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f63410e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f63411f;

        public g(e eVar) {
            super(eVar);
        }
    }

    public e(Context context) {
        this.f63394f = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f63393e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return ListUtils.getItem(this.f63393e, i2);
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
                view = LayoutInflater.from(this.f63394f).inflate(R.layout.frs_header_top_item_single, (ViewGroup) null, false);
                gVar.f63406b = view;
                gVar.f63410e = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                gVar.f63407c = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                gVar.f63408d = (TextView) view.findViewById(R.id.top_item_type);
                gVar.f63411f = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(gVar);
            }
            m(gVar, (n) ListUtils.getItem(this.f63393e, i2));
        } else if (getItemViewType(i2) == 2) {
            if (view != null && (view.getTag() instanceof f)) {
                fVar = (f) view.getTag();
            } else {
                fVar = new f(this);
                view = LayoutInflater.from(this.f63394f).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                fVar.f63406b = view;
                fVar.f63408d = (TextView) view.findViewById(R.id.top_item_type);
                fVar.f63407c = (TextView) view.findViewById(R.id.top_item_title);
                fVar.f63409e = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(fVar);
            }
            n nVar = (n) ListUtils.getItem(this.f63393e, i2);
            if (nVar instanceof a2) {
                i(fVar, (a2) nVar, i2);
                fVar.f63405a = i2;
            } else if (nVar instanceof k) {
                k(fVar, (k) nVar);
            } else if (nVar instanceof o) {
                y((o) nVar, fVar, i2);
            } else if (nVar instanceof p) {
                fVar.f63405a = i2;
                l(fVar, (p) nVar, i2);
            }
        }
        return view;
    }

    public final void h(C1609e c1609e) {
        if (c1609e == null) {
            return;
        }
        SkinManager.setViewTextColor(c1609e.f63407c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(c1609e.f63408d, R.color.CAM_X0101);
    }

    public final void i(f fVar, a2 a2Var, int i2) {
        if (fVar == null || a2Var == null) {
            return;
        }
        fVar.f63408d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f63394f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f63408d);
        a2Var.Y2();
        SpannableStringBuilder n1 = a2Var.n1();
        if ((n1 == null || d.a.c.e.p.k.isEmptyStringAfterTrim(n1.toString())) && a2Var.D() != null) {
            n1 = new SpannableStringBuilder(a2Var.D());
        }
        fVar.f63407c.setOnTouchListener(new i(n1));
        fVar.f63407c.setText(n1);
        fVar.f63406b.setOnClickListener(this.r);
        h(fVar);
    }

    @Override // d.a.o0.r0.j2.d
    public d.a.o0.r0.j2.b j() {
        return this.p;
    }

    public final void k(f fVar, k kVar) {
        String o = o(kVar);
        fVar.f63407c.setText(kVar.g());
        fVar.f63408d.setText(o);
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f63394f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f63408d);
        if (kVar.e() != 0) {
            fVar.f63409e.setVisibility(0);
            if (kVar.e() == -1) {
                fVar.f63409e.setText(this.f63394f.getString(R.string.no_rank));
            } else if (kVar.e() > 999) {
                fVar.f63409e.setText(this.f63394f.getString(R.string.rang_orer_thousand));
            } else {
                TextView textView = fVar.f63409e;
                textView.setText(this.f63394f.getString(R.string.rang_identify) + kVar.e());
            }
            if (!StringUtils.isNull(kVar.g())) {
                fVar.f63407c.setText(kVar.g());
            }
        } else {
            fVar.f63409e.setVisibility(8);
        }
        h(fVar);
        fVar.f63407c.setTag(kVar);
        View.OnClickListener onClickListener = this.q;
        if (onClickListener != null) {
            fVar.f63406b.setOnClickListener(onClickListener);
        }
        HashSet<String> hashSet = this.n;
        if (hashSet == null || !hashSet.add(kVar.c())) {
            return;
        }
        a.b b2 = d.a.o0.e3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.c(), this.f63396h, this.f63397i, null);
        b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
        b2.f();
    }

    public final void l(f fVar, p pVar, int i2) {
        if (fVar == null || pVar == null || pVar.b() == null || this.j == null) {
            return;
        }
        fVar.f63408d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f63394f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f63408d);
        if (this.j.getIs_manager() == 1) {
            if (pVar.b().audit_status.intValue() == 0 && pVar.b().has_forum_rule.intValue() == 0) {
                fVar.f63407c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
            } else if (pVar.b().audit_status.intValue() == 0) {
                fVar.f63407c.setText(pVar.b().title);
            } else if (pVar.b().audit_status.intValue() == 1) {
                fVar.f63407c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
            } else if (pVar.b().audit_status.intValue() == 2) {
                fVar.f63407c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
            }
        } else {
            fVar.f63407c.setText(pVar.b().title);
        }
        fVar.f63406b.setOnClickListener(this.r);
        h(fVar);
    }

    public final void m(g gVar, n nVar) {
        if (gVar == null || nVar == null) {
            return;
        }
        if (nVar instanceof a2) {
            a2 a2Var = (a2) nVar;
            a2Var.Y2();
            SpannableStringBuilder n1 = a2Var.n1();
            if ((n1 == null || d.a.c.e.p.k.isEmptyStringAfterTrim(n1.toString())) && a2Var.D() != null) {
                n1 = new SpannableStringBuilder(a2Var.D());
            }
            gVar.f63408d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            gVar.f63407c.setOnTouchListener(new i(n1));
            gVar.f63407c.setText(n1);
            if (StringUtils.isNull(this.m)) {
                gVar.f63410e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f63408d.getLayoutParams();
                layoutParams.setMargins((int) this.f63394f.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.f63410e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f63408d.getLayoutParams();
                layoutParams2.setMargins((int) this.f63394f.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.f63410e.U(this.m, 10, false);
            }
            gVar.f63408d.setTextColor(this.l);
            gVar.f63406b.setOnClickListener(this.r);
            h(gVar);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.m)) {
                gVar.f63408d.setText(o);
                gVar.f63408d.setVisibility(0);
                gVar.f63407c.setText(kVar.g());
                gVar.f63410e.setVisibility(8);
            } else {
                gVar.f63408d.setVisibility(8);
                gVar.f63410e.setVisibility(0);
                TextView textView = gVar.f63407c;
                textView.setText(o + "：" + kVar.g());
                gVar.f63410e.U(this.m, 10, false);
            }
            if (kVar.e() != 0) {
                gVar.f63411f.setVisibility(0);
                if (kVar.e() == -1) {
                    gVar.f63411f.setText(this.f63394f.getString(R.string.no_rank));
                } else if (kVar.e() > 999) {
                    gVar.f63411f.setText(this.f63394f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView2 = gVar.f63411f;
                    textView2.setText(this.f63394f.getString(R.string.rang_identify) + kVar.e());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    gVar.f63407c.setText(kVar.g());
                }
            } else {
                gVar.f63411f.setVisibility(8);
            }
            gVar.f63408d.setTextColor(this.l);
            h(gVar);
            gVar.f63407c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                gVar.f63406b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.c())) {
                return;
            }
            a.b b2 = d.a.o0.e3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.c(), this.f63396h, this.f63397i, null);
            b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.f();
        }
    }

    public List<n> n() {
        return this.f63393e;
    }

    public final String o(k kVar) {
        if (!TextUtils.isEmpty(kVar.h()) && kVar.h().trim().length() != 0) {
            return kVar.h();
        }
        if (kVar.b() == 1) {
            return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
        }
        return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
    }

    public TbPageContext p() {
        Context context = this.f63394f;
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public void q(BdUniqueId bdUniqueId) {
    }

    public void r(List<n> list) {
        this.f63393e = list;
        notifyDataSetChanged();
    }

    public void s(String str, String str2, UserData userData) {
        this.f63396h = str;
        this.f63397i = str2;
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
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a((BaseFragmentActivity) this.f63394f);
        aVar.setTitle(str2);
        aVar.setTitleShowCenter(true);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.frs_risk_dialog_button_text, new d(this, aVar));
        aVar.create(p()).show();
    }

    public final boolean y(o oVar, f fVar, int i2) {
        if (i2 != 0 || oVar == null || oVar.b() == null) {
            return false;
        }
        ForumData b2 = oVar.b();
        boolean z = oVar.c() && !ListUtils.isEmpty(b2.getTipInfos());
        String riskTipNotice = z ? b2.getTipInfos().get(0).tip_notice : b2.getRiskTipNotice();
        String riskTipPopTitle = z ? b2.getTipInfos().get(0).tip_pop_title : b2.getRiskTipPopTitle();
        String riskTipPop = z ? b2.getTipInfos().get(0).tip_pop : b2.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        fVar.f63408d.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f63394f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f63408d);
        fVar.f63407c.setText(riskTipNotice);
        fVar.f63407c.setOnClickListener(new c(fVar, riskTipPop, riskTipPopTitle));
        h(fVar);
        return true;
    }
}
