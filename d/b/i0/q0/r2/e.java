package d.b.i0.q0.r2;

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
import d.b.h0.r.q.a2;
import d.b.h0.r.s.a;
import d.b.i0.d3.j0.a;
import d.b.i0.d3.k;
import d.b.i0.d3.o;
import d.b.i0.d3.p;
import d.b.i0.u3.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter implements d.b.i0.q0.j2.d {

    /* renamed from: e  reason: collision with root package name */
    public List<n> f60169e;

    /* renamed from: f  reason: collision with root package name */
    public Context f60170f;
    public UserData j;
    public w k;
    public boolean o;

    /* renamed from: h  reason: collision with root package name */
    public String f60172h = "";
    public String i = "";
    public int l = SkinManager.getColor(R.color.CAM_X0302);
    public String m = "";
    public HashSet<String> n = new HashSet<>();
    public d.b.i0.q0.j2.b p = new d.b.i0.q0.j2.b();
    public final View.OnClickListener q = new a();
    public View.OnClickListener r = new b();

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f60171g = p();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1500e c1500e;
            TextView textView;
            if ((e.this.f60170f == null || ViewHelper.checkUpIsLogin(e.this.f60170f)) && view != null) {
                if ((view.getTag() instanceof k) || (view.getTag() instanceof C1500e)) {
                    k kVar = null;
                    if (view.getTag() instanceof k) {
                        kVar = (k) view.getTag();
                    } else if ((view.getTag() instanceof C1500e) && (textView = (c1500e = (C1500e) view.getTag()).f60182c) != null && (textView.getTag() instanceof k)) {
                        kVar = (k) c1500e.f60182c.getTag();
                    }
                    if (kVar != null && kVar.l() == 2) {
                        if (StringUtils.isNull(kVar.k())) {
                            return;
                        }
                        String k = kVar.k();
                        if ((k.contains("nohead:url") || k.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.K(e.this.f60170f, R.string.book_plugin_not_install_tip);
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(e.this.f60171g, new String[]{k});
                        a.b b2 = d.b.i0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.e(), e.this.f60172h, e.this.i, null);
                        b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
                        b2.f();
                    } else if (kVar == null || kVar.l() != 3) {
                    } else {
                        new StatisticItem("c13442").param("forum_id", e.this.f60172h).eventStat();
                        if (e.this.f60171g == null || TextUtils.isEmpty(e.this.f60172h)) {
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.f60171g.getPageActivity()).createNormalConfig(d.b.c.e.m.b.f(e.this.f60172h, 0L), 1)));
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
            C1500e c1500e;
            view.setPressed(false);
            if (e.this.k == null || !(view.getTag() instanceof C1500e) || (c1500e = (C1500e) view.getTag()) == null) {
                return;
            }
            n nVar = (n) ListUtils.getItem(e.this.f60169e, c1500e.f60180a);
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                e.this.k.f(view, a2Var, BdUniqueId.gen(), null, e.this.o ? c1500e.f60180a + 1 : c1500e.f60180a, 0L);
                TiebaStatic.log(new StatisticItem("c13124").param("fid", a2Var.c0()).param("tid", a2Var.w1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", c1500e.f60180a + 1));
            } else if (nVar instanceof p) {
                e.this.k.f(view, (p) nVar, BdUniqueId.gen(), null, c1500e.f60180a, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f60175e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f60176f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f60177g;

        public c(f fVar, String str, String str2) {
            this.f60175e = fVar;
            this.f60176f = str;
            this.f60177g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f60175e.f60182c.getLayout().getEllipsisCount(this.f60175e.f60182c.getLineCount() - 1) > 0) {
                e.this.x(this.f60176f, this.f60177g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f60179e;

        public d(e eVar, d.b.h0.r.s.a aVar) {
            this.f60179e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f60179e.dismiss();
        }
    }

    /* renamed from: d.b.i0.q0.r2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1500e {

        /* renamed from: a  reason: collision with root package name */
        public int f60180a;

        /* renamed from: b  reason: collision with root package name */
        public View f60181b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f60182c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f60183d;

        public C1500e(e eVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class f extends C1500e {

        /* renamed from: e  reason: collision with root package name */
        public TextView f60184e;

        public f(e eVar) {
            super(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends C1500e {

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f60185e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f60186f;

        public g(e eVar) {
            super(eVar);
        }
    }

    public e(Context context) {
        this.f60170f = context;
    }

    @Override // d.b.i0.q0.j2.d
    public d.b.i0.q0.j2.b b() {
        return this.p;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f60169e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return ListUtils.getItem(this.f60169e, i);
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
                view = LayoutInflater.from(this.f60170f).inflate(R.layout.frs_header_top_item_single, (ViewGroup) null, false);
                gVar.f60181b = view;
                gVar.f60185e = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                gVar.f60182c = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                gVar.f60183d = (TextView) view.findViewById(R.id.top_item_type);
                gVar.f60186f = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(gVar);
            }
            m(gVar, (n) ListUtils.getItem(this.f60169e, i));
        } else if (getItemViewType(i) == 2) {
            if (view != null && (view.getTag() instanceof f)) {
                fVar = (f) view.getTag();
            } else {
                fVar = new f(this);
                view = LayoutInflater.from(this.f60170f).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                fVar.f60181b = view;
                fVar.f60183d = (TextView) view.findViewById(R.id.top_item_type);
                fVar.f60182c = (TextView) view.findViewById(R.id.top_item_title);
                fVar.f60184e = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(fVar);
            }
            n nVar = (n) ListUtils.getItem(this.f60169e, i);
            if (nVar instanceof a2) {
                j(fVar, (a2) nVar, i);
                fVar.f60180a = i;
            } else if (nVar instanceof k) {
                k(fVar, (k) nVar);
            } else if (nVar instanceof o) {
                y((o) nVar, fVar, i);
            } else if (nVar instanceof p) {
                fVar.f60180a = i;
                l(fVar, (p) nVar, i);
            }
        }
        return view;
    }

    public final void i(C1500e c1500e) {
        if (c1500e == null) {
            return;
        }
        SkinManager.setViewTextColor(c1500e.f60182c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(c1500e.f60183d, R.color.CAM_X0101);
    }

    public final void j(f fVar, a2 a2Var, int i) {
        if (fVar == null || a2Var == null) {
            return;
        }
        fVar.f60183d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f60170f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f60183d);
        a2Var.U2();
        SpannableStringBuilder l1 = a2Var.l1();
        if ((l1 == null || d.b.c.e.p.k.isEmptyStringAfterTrim(l1.toString())) && a2Var.D() != null) {
            l1 = new SpannableStringBuilder(a2Var.D());
        }
        fVar.f60182c.setOnTouchListener(new i(l1));
        fVar.f60182c.setText(l1);
        fVar.f60181b.setOnClickListener(this.r);
        i(fVar);
    }

    public final void k(f fVar, k kVar) {
        String o = o(kVar);
        fVar.f60182c.setText(kVar.g());
        fVar.f60183d.setText(o);
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f60170f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f60183d);
        if (kVar.f() != 0) {
            fVar.f60184e.setVisibility(0);
            if (kVar.f() == -1) {
                fVar.f60184e.setText(this.f60170f.getString(R.string.no_rank));
            } else if (kVar.f() > 999) {
                fVar.f60184e.setText(this.f60170f.getString(R.string.rang_orer_thousand));
            } else {
                TextView textView = fVar.f60184e;
                textView.setText(this.f60170f.getString(R.string.rang_identify) + kVar.f());
            }
            if (!StringUtils.isNull(kVar.g())) {
                fVar.f60182c.setText(kVar.g());
            }
        } else {
            fVar.f60184e.setVisibility(8);
        }
        i(fVar);
        fVar.f60182c.setTag(kVar);
        View.OnClickListener onClickListener = this.q;
        if (onClickListener != null) {
            fVar.f60181b.setOnClickListener(onClickListener);
        }
        HashSet<String> hashSet = this.n;
        if (hashSet == null || !hashSet.add(kVar.e())) {
            return;
        }
        a.b b2 = d.b.i0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.e(), this.f60172h, this.i, null);
        b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
        b2.f();
    }

    public final void l(f fVar, p pVar, int i) {
        if (fVar == null || pVar == null || pVar.a() == null || this.j == null) {
            return;
        }
        fVar.f60183d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f60170f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f60183d);
        if (this.j.getIs_manager() == 1) {
            if (pVar.a().audit_status.intValue() == 0 && pVar.a().has_forum_rule.intValue() == 0) {
                fVar.f60182c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
            } else if (pVar.a().audit_status.intValue() == 0) {
                fVar.f60182c.setText(pVar.a().title);
            } else if (pVar.a().audit_status.intValue() == 1) {
                fVar.f60182c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
            } else if (pVar.a().audit_status.intValue() == 2) {
                fVar.f60182c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
            }
        } else {
            fVar.f60182c.setText(pVar.a().title);
        }
        fVar.f60181b.setOnClickListener(this.r);
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
            gVar.f60183d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            gVar.f60182c.setOnTouchListener(new i(l1));
            gVar.f60182c.setText(l1);
            if (StringUtils.isNull(this.m)) {
                gVar.f60185e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f60183d.getLayoutParams();
                layoutParams.setMargins((int) this.f60170f.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.f60185e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f60183d.getLayoutParams();
                layoutParams2.setMargins((int) this.f60170f.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.f60185e.W(this.m, 10, false);
            }
            gVar.f60183d.setTextColor(this.l);
            gVar.f60181b.setOnClickListener(this.r);
            i(gVar);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.m)) {
                gVar.f60183d.setText(o);
                gVar.f60183d.setVisibility(0);
                gVar.f60182c.setText(kVar.g());
                gVar.f60185e.setVisibility(8);
            } else {
                gVar.f60183d.setVisibility(8);
                gVar.f60185e.setVisibility(0);
                TextView textView = gVar.f60182c;
                textView.setText(o + "：" + kVar.g());
                gVar.f60185e.W(this.m, 10, false);
            }
            if (kVar.f() != 0) {
                gVar.f60186f.setVisibility(0);
                if (kVar.f() == -1) {
                    gVar.f60186f.setText(this.f60170f.getString(R.string.no_rank));
                } else if (kVar.f() > 999) {
                    gVar.f60186f.setText(this.f60170f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView2 = gVar.f60186f;
                    textView2.setText(this.f60170f.getString(R.string.rang_identify) + kVar.f());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    gVar.f60182c.setText(kVar.g());
                }
            } else {
                gVar.f60186f.setVisibility(8);
            }
            gVar.f60183d.setTextColor(this.l);
            i(gVar);
            gVar.f60182c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                gVar.f60181b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.e())) {
                return;
            }
            a.b b2 = d.b.i0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.e(), this.f60172h, this.i, null);
            b2.e(TiebaStatic.Params.OBJ_URL, kVar.k());
            b2.f();
        }
    }

    public List<n> n() {
        return this.f60169e;
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
        Context context = this.f60170f;
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public void q(BdUniqueId bdUniqueId) {
    }

    public void r(List<n> list) {
        this.f60169e = list;
        notifyDataSetChanged();
    }

    public void s(String str, String str2, UserData userData) {
        this.f60172h = str;
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
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a((BaseFragmentActivity) this.f60170f);
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
        fVar.f60183d.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f60170f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f60183d);
        fVar.f60182c.setText(riskTipNotice);
        fVar.f60182c.setOnClickListener(new c(fVar, riskTipPop, riskTipPopTitle));
        i(fVar);
        return true;
    }
}
