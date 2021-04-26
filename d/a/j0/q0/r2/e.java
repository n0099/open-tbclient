package d.a.j0.q0.r2;

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
import d.a.i0.r.q.a2;
import d.a.i0.r.s.a;
import d.a.j0.d3.j0.a;
import d.a.j0.d3.k;
import d.a.j0.d3.o;
import d.a.j0.d3.p;
import d.a.j0.u3.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter implements d.a.j0.q0.j2.d {

    /* renamed from: e  reason: collision with root package name */
    public List<n> f58694e;

    /* renamed from: f  reason: collision with root package name */
    public Context f58695f;
    public UserData j;
    public w k;
    public boolean o;

    /* renamed from: h  reason: collision with root package name */
    public String f58697h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f58698i = "";
    public int l = SkinManager.getColor(R.color.CAM_X0302);
    public String m = "";
    public HashSet<String> n = new HashSet<>();
    public d.a.j0.q0.j2.b p = new d.a.j0.q0.j2.b();
    public final View.OnClickListener q = new a();
    public View.OnClickListener r = new b();

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f58696g = p();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1462e c1462e;
            TextView textView;
            if ((e.this.f58695f == null || ViewHelper.checkUpIsLogin(e.this.f58695f)) && view != null) {
                if ((view.getTag() instanceof k) || (view.getTag() instanceof C1462e)) {
                    k kVar = null;
                    if (view.getTag() instanceof k) {
                        kVar = (k) view.getTag();
                    } else if ((view.getTag() instanceof C1462e) && (textView = (c1462e = (C1462e) view.getTag()).f58708c) != null && (textView.getTag() instanceof k)) {
                        kVar = (k) c1462e.f58708c.getTag();
                    }
                    if (kVar != null && kVar.l() == 2) {
                        if (StringUtils.isNull(kVar.k())) {
                            return;
                        }
                        String k = kVar.k();
                        if ((k.contains("nohead:url") || k.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.L(e.this.f58695f, R.string.book_plugin_not_install_tip);
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(e.this.f58696g, new String[]{k});
                        a.b b2 = d.a.j0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.e(), e.this.f58697h, e.this.f58698i, null);
                        b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
                        b2.f();
                    } else if (kVar == null || kVar.l() != 3) {
                    } else {
                        new StatisticItem("c13442").param("forum_id", e.this.f58697h).eventStat();
                        if (e.this.f58696g == null || TextUtils.isEmpty(e.this.f58697h)) {
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.f58696g.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(e.this.f58697h, 0L), 1)));
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
            C1462e c1462e;
            view.setPressed(false);
            if (e.this.k == null || !(view.getTag() instanceof C1462e) || (c1462e = (C1462e) view.getTag()) == null) {
                return;
            }
            n nVar = (n) ListUtils.getItem(e.this.f58694e, c1462e.f58706a);
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                e.this.k.b(view, a2Var, BdUniqueId.gen(), null, e.this.o ? c1462e.f58706a + 1 : c1462e.f58706a, 0L);
                TiebaStatic.log(new StatisticItem("c13124").param("fid", a2Var.c0()).param("tid", a2Var.w1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", c1462e.f58706a + 1));
            } else if (nVar instanceof p) {
                e.this.k.b(view, (p) nVar, BdUniqueId.gen(), null, c1462e.f58706a, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f58701e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f58702f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f58703g;

        public c(f fVar, String str, String str2) {
            this.f58701e = fVar;
            this.f58702f = str;
            this.f58703g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f58701e.f58708c.getLayout().getEllipsisCount(this.f58701e.f58708c.getLineCount() - 1) > 0) {
                e.this.x(this.f58702f, this.f58703g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f58705e;

        public d(e eVar, d.a.i0.r.s.a aVar) {
            this.f58705e = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f58705e.dismiss();
        }
    }

    /* renamed from: d.a.j0.q0.r2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1462e {

        /* renamed from: a  reason: collision with root package name */
        public int f58706a;

        /* renamed from: b  reason: collision with root package name */
        public View f58707b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f58708c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f58709d;

        public C1462e(e eVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class f extends C1462e {

        /* renamed from: e  reason: collision with root package name */
        public TextView f58710e;

        public f(e eVar) {
            super(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends C1462e {

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f58711e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f58712f;

        public g(e eVar) {
            super(eVar);
        }
    }

    public e(Context context) {
        this.f58695f = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f58694e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return ListUtils.getItem(this.f58694e, i2);
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
                view = LayoutInflater.from(this.f58695f).inflate(R.layout.frs_header_top_item_single, (ViewGroup) null, false);
                gVar.f58707b = view;
                gVar.f58711e = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                gVar.f58708c = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                gVar.f58709d = (TextView) view.findViewById(R.id.top_item_type);
                gVar.f58712f = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(gVar);
            }
            m(gVar, (n) ListUtils.getItem(this.f58694e, i2));
        } else if (getItemViewType(i2) == 2) {
            if (view != null && (view.getTag() instanceof f)) {
                fVar = (f) view.getTag();
            } else {
                fVar = new f(this);
                view = LayoutInflater.from(this.f58695f).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                fVar.f58707b = view;
                fVar.f58709d = (TextView) view.findViewById(R.id.top_item_type);
                fVar.f58708c = (TextView) view.findViewById(R.id.top_item_title);
                fVar.f58710e = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(fVar);
            }
            n nVar = (n) ListUtils.getItem(this.f58694e, i2);
            if (nVar instanceof a2) {
                j(fVar, (a2) nVar, i2);
                fVar.f58706a = i2;
            } else if (nVar instanceof k) {
                k(fVar, (k) nVar);
            } else if (nVar instanceof o) {
                y((o) nVar, fVar, i2);
            } else if (nVar instanceof p) {
                fVar.f58706a = i2;
                l(fVar, (p) nVar, i2);
            }
        }
        return view;
    }

    public final void h(C1462e c1462e) {
        if (c1462e == null) {
            return;
        }
        SkinManager.setViewTextColor(c1462e.f58708c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(c1462e.f58709d, R.color.CAM_X0101);
    }

    @Override // d.a.j0.q0.j2.d
    public d.a.j0.q0.j2.b i() {
        return this.p;
    }

    public final void j(f fVar, a2 a2Var, int i2) {
        if (fVar == null || a2Var == null) {
            return;
        }
        fVar.f58709d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f58695f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f58709d);
        a2Var.U2();
        SpannableStringBuilder l1 = a2Var.l1();
        if ((l1 == null || d.a.c.e.p.k.isEmptyStringAfterTrim(l1.toString())) && a2Var.D() != null) {
            l1 = new SpannableStringBuilder(a2Var.D());
        }
        fVar.f58708c.setOnTouchListener(new i(l1));
        fVar.f58708c.setText(l1);
        fVar.f58707b.setOnClickListener(this.r);
        h(fVar);
    }

    public final void k(f fVar, k kVar) {
        String o = o(kVar);
        fVar.f58708c.setText(kVar.h());
        fVar.f58709d.setText(o);
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f58695f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f58709d);
        if (kVar.f() != 0) {
            fVar.f58710e.setVisibility(0);
            if (kVar.f() == -1) {
                fVar.f58710e.setText(this.f58695f.getString(R.string.no_rank));
            } else if (kVar.f() > 999) {
                fVar.f58710e.setText(this.f58695f.getString(R.string.rang_orer_thousand));
            } else {
                TextView textView = fVar.f58710e;
                textView.setText(this.f58695f.getString(R.string.rang_identify) + kVar.f());
            }
            if (!StringUtils.isNull(kVar.h())) {
                fVar.f58708c.setText(kVar.h());
            }
        } else {
            fVar.f58710e.setVisibility(8);
        }
        h(fVar);
        fVar.f58708c.setTag(kVar);
        View.OnClickListener onClickListener = this.q;
        if (onClickListener != null) {
            fVar.f58707b.setOnClickListener(onClickListener);
        }
        HashSet<String> hashSet = this.n;
        if (hashSet == null || !hashSet.add(kVar.e())) {
            return;
        }
        a.b b2 = d.a.j0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.e(), this.f58697h, this.f58698i, null);
        b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
        b2.f();
    }

    public final void l(f fVar, p pVar, int i2) {
        if (fVar == null || pVar == null || pVar.c() == null || this.j == null) {
            return;
        }
        fVar.f58709d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f58695f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f58709d);
        if (this.j.getIs_manager() == 1) {
            if (pVar.c().audit_status.intValue() == 0 && pVar.c().has_forum_rule.intValue() == 0) {
                fVar.f58708c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
            } else if (pVar.c().audit_status.intValue() == 0) {
                fVar.f58708c.setText(pVar.c().title);
            } else if (pVar.c().audit_status.intValue() == 1) {
                fVar.f58708c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
            } else if (pVar.c().audit_status.intValue() == 2) {
                fVar.f58708c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
            }
        } else {
            fVar.f58708c.setText(pVar.c().title);
        }
        fVar.f58707b.setOnClickListener(this.r);
        h(fVar);
    }

    public final void m(g gVar, n nVar) {
        if (gVar == null || nVar == null) {
            return;
        }
        if (nVar instanceof a2) {
            a2 a2Var = (a2) nVar;
            a2Var.U2();
            SpannableStringBuilder l1 = a2Var.l1();
            if ((l1 == null || d.a.c.e.p.k.isEmptyStringAfterTrim(l1.toString())) && a2Var.D() != null) {
                l1 = new SpannableStringBuilder(a2Var.D());
            }
            gVar.f58709d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            gVar.f58708c.setOnTouchListener(new i(l1));
            gVar.f58708c.setText(l1);
            if (StringUtils.isNull(this.m)) {
                gVar.f58711e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f58709d.getLayoutParams();
                layoutParams.setMargins((int) this.f58695f.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.f58711e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f58709d.getLayoutParams();
                layoutParams2.setMargins((int) this.f58695f.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.f58711e.V(this.m, 10, false);
            }
            gVar.f58709d.setTextColor(this.l);
            gVar.f58707b.setOnClickListener(this.r);
            h(gVar);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.m)) {
                gVar.f58709d.setText(o);
                gVar.f58709d.setVisibility(0);
                gVar.f58708c.setText(kVar.h());
                gVar.f58711e.setVisibility(8);
            } else {
                gVar.f58709d.setVisibility(8);
                gVar.f58711e.setVisibility(0);
                TextView textView = gVar.f58708c;
                textView.setText(o + "：" + kVar.h());
                gVar.f58711e.V(this.m, 10, false);
            }
            if (kVar.f() != 0) {
                gVar.f58712f.setVisibility(0);
                if (kVar.f() == -1) {
                    gVar.f58712f.setText(this.f58695f.getString(R.string.no_rank));
                } else if (kVar.f() > 999) {
                    gVar.f58712f.setText(this.f58695f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView2 = gVar.f58712f;
                    textView2.setText(this.f58695f.getString(R.string.rang_identify) + kVar.f());
                }
                if (!StringUtils.isNull(kVar.h())) {
                    gVar.f58708c.setText(kVar.h());
                }
            } else {
                gVar.f58712f.setVisibility(8);
            }
            gVar.f58709d.setTextColor(this.l);
            h(gVar);
            gVar.f58708c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                gVar.f58707b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.e())) {
                return;
            }
            a.b b2 = d.a.j0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.e(), this.f58697h, this.f58698i, null);
            b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
            b2.f();
        }
    }

    public List<n> n() {
        return this.f58694e;
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
        Context context = this.f58695f;
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public void q(BdUniqueId bdUniqueId) {
    }

    public void r(List<n> list) {
        this.f58694e = list;
        notifyDataSetChanged();
    }

    public void s(String str, String str2, UserData userData) {
        this.f58697h = str;
        this.f58698i = str2;
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
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a((BaseFragmentActivity) this.f58695f);
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
        fVar.f58709d.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f58695f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f58709d);
        fVar.f58708c.setText(riskTipNotice);
        fVar.f58708c.setOnClickListener(new c(fVar, riskTipPop, riskTipPopTitle));
        h(fVar);
        return true;
    }
}
