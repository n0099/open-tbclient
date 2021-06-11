package d.a.n0.r0.r2;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.s.a;
import d.a.n0.e3.j0.a;
import d.a.n0.e3.k;
import d.a.n0.e3.o;
import d.a.n0.e3.p;
import d.a.n0.v3.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter implements d.a.n0.r0.j2.d {

    /* renamed from: e  reason: collision with root package name */
    public List<n> f63268e;

    /* renamed from: f  reason: collision with root package name */
    public Context f63269f;
    public UserData j;
    public w k;
    public boolean o;

    /* renamed from: h  reason: collision with root package name */
    public String f63271h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f63272i = "";
    public int l = SkinManager.getColor(R.color.CAM_X0302);
    public String m = "";
    public HashSet<String> n = new HashSet<>();
    public d.a.n0.r0.j2.b p = new d.a.n0.r0.j2.b();
    public final View.OnClickListener q = new a();
    public View.OnClickListener r = new b();

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f63270g = p();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1605e c1605e;
            TextView textView;
            if ((e.this.f63269f == null || ViewHelper.checkUpIsLogin(e.this.f63269f)) && view != null) {
                if ((view.getTag() instanceof k) || (view.getTag() instanceof C1605e)) {
                    k kVar = null;
                    if (view.getTag() instanceof k) {
                        kVar = (k) view.getTag();
                    } else if ((view.getTag() instanceof C1605e) && (textView = (c1605e = (C1605e) view.getTag()).f63282c) != null && (textView.getTag() instanceof k)) {
                        kVar = (k) c1605e.f63282c.getTag();
                    }
                    if (kVar != null && kVar.k() == 2) {
                        if (StringUtils.isNull(kVar.i())) {
                            return;
                        }
                        String i2 = kVar.i();
                        if ((i2.contains("nohead:url") || i2.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.L(e.this.f63269f, R.string.book_plugin_not_install_tip);
                            return;
                        }
                        UrlManager.getInstance().dealOneLink(e.this.f63270g, new String[]{i2});
                        a.b b2 = d.a.n0.e3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.c(), e.this.f63271h, e.this.f63272i, null);
                        b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
                        b2.f();
                    } else if (kVar == null || kVar.k() != 3) {
                    } else {
                        new StatisticItem("c13442").param("forum_id", e.this.f63271h).eventStat();
                        if (e.this.f63270g == null || TextUtils.isEmpty(e.this.f63271h)) {
                            return;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.f63270g.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(e.this.f63271h, 0L), 1)));
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
            C1605e c1605e;
            view.setPressed(false);
            if (e.this.k == null || !(view.getTag() instanceof C1605e) || (c1605e = (C1605e) view.getTag()) == null) {
                return;
            }
            n nVar = (n) ListUtils.getItem(e.this.f63268e, c1605e.f63280a);
            if (nVar instanceof a2) {
                a2 a2Var = (a2) nVar;
                e.this.k.b(view, a2Var, BdUniqueId.gen(), null, e.this.o ? c1605e.f63280a + 1 : c1605e.f63280a, 0L);
                TiebaStatic.log(new StatisticItem("c13124").param("fid", a2Var.c0()).param("tid", a2Var.z1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", c1605e.f63280a + 1));
            } else if (nVar instanceof p) {
                e.this.k.b(view, (p) nVar, BdUniqueId.gen(), null, c1605e.f63280a, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f63275e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f63276f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f63277g;

        public c(f fVar, String str, String str2) {
            this.f63275e = fVar;
            this.f63276f = str;
            this.f63277g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f63275e.f63282c.getLayout().getEllipsisCount(this.f63275e.f63282c.getLineCount() - 1) > 0) {
                e.this.x(this.f63276f, this.f63277g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f63279e;

        public d(e eVar, d.a.m0.r.s.a aVar) {
            this.f63279e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f63279e.dismiss();
        }
    }

    /* renamed from: d.a.n0.r0.r2.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1605e {

        /* renamed from: a  reason: collision with root package name */
        public int f63280a;

        /* renamed from: b  reason: collision with root package name */
        public View f63281b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f63282c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f63283d;

        public C1605e(e eVar) {
        }
    }

    /* loaded from: classes4.dex */
    public class f extends C1605e {

        /* renamed from: e  reason: collision with root package name */
        public TextView f63284e;

        public f(e eVar) {
            super(eVar);
        }
    }

    /* loaded from: classes4.dex */
    public class g extends C1605e {

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f63285e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f63286f;

        public g(e eVar) {
            super(eVar);
        }
    }

    public e(Context context) {
        this.f63269f = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.f63268e);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        return ListUtils.getItem(this.f63268e, i2);
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
                view = LayoutInflater.from(this.f63269f).inflate(R.layout.frs_header_top_item_single, (ViewGroup) null, false);
                gVar.f63281b = view;
                gVar.f63285e = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                gVar.f63282c = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                gVar.f63283d = (TextView) view.findViewById(R.id.top_item_type);
                gVar.f63286f = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(gVar);
            }
            m(gVar, (n) ListUtils.getItem(this.f63268e, i2));
        } else if (getItemViewType(i2) == 2) {
            if (view != null && (view.getTag() instanceof f)) {
                fVar = (f) view.getTag();
            } else {
                fVar = new f(this);
                view = LayoutInflater.from(this.f63269f).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                fVar.f63281b = view;
                fVar.f63283d = (TextView) view.findViewById(R.id.top_item_type);
                fVar.f63282c = (TextView) view.findViewById(R.id.top_item_title);
                fVar.f63284e = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(fVar);
            }
            n nVar = (n) ListUtils.getItem(this.f63268e, i2);
            if (nVar instanceof a2) {
                i(fVar, (a2) nVar, i2);
                fVar.f63280a = i2;
            } else if (nVar instanceof k) {
                k(fVar, (k) nVar);
            } else if (nVar instanceof o) {
                y((o) nVar, fVar, i2);
            } else if (nVar instanceof p) {
                fVar.f63280a = i2;
                l(fVar, (p) nVar, i2);
            }
        }
        return view;
    }

    public final void h(C1605e c1605e) {
        if (c1605e == null) {
            return;
        }
        SkinManager.setViewTextColor(c1605e.f63282c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(c1605e.f63283d, R.color.CAM_X0101);
    }

    public final void i(f fVar, a2 a2Var, int i2) {
        if (fVar == null || a2Var == null) {
            return;
        }
        fVar.f63283d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f63269f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f63283d);
        a2Var.Y2();
        SpannableStringBuilder n1 = a2Var.n1();
        if ((n1 == null || d.a.c.e.p.k.isEmptyStringAfterTrim(n1.toString())) && a2Var.D() != null) {
            n1 = new SpannableStringBuilder(a2Var.D());
        }
        fVar.f63282c.setOnTouchListener(new i(n1));
        fVar.f63282c.setText(n1);
        fVar.f63281b.setOnClickListener(this.r);
        h(fVar);
    }

    @Override // d.a.n0.r0.j2.d
    public d.a.n0.r0.j2.b j() {
        return this.p;
    }

    public final void k(f fVar, k kVar) {
        String o = o(kVar);
        fVar.f63282c.setText(kVar.g());
        fVar.f63283d.setText(o);
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f63269f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f63283d);
        if (kVar.e() != 0) {
            fVar.f63284e.setVisibility(0);
            if (kVar.e() == -1) {
                fVar.f63284e.setText(this.f63269f.getString(R.string.no_rank));
            } else if (kVar.e() > 999) {
                fVar.f63284e.setText(this.f63269f.getString(R.string.rang_orer_thousand));
            } else {
                TextView textView = fVar.f63284e;
                textView.setText(this.f63269f.getString(R.string.rang_identify) + kVar.e());
            }
            if (!StringUtils.isNull(kVar.g())) {
                fVar.f63282c.setText(kVar.g());
            }
        } else {
            fVar.f63284e.setVisibility(8);
        }
        h(fVar);
        fVar.f63282c.setTag(kVar);
        View.OnClickListener onClickListener = this.q;
        if (onClickListener != null) {
            fVar.f63281b.setOnClickListener(onClickListener);
        }
        HashSet<String> hashSet = this.n;
        if (hashSet == null || !hashSet.add(kVar.c())) {
            return;
        }
        a.b b2 = d.a.n0.e3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.c(), this.f63271h, this.f63272i, null);
        b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
        b2.f();
    }

    public final void l(f fVar, p pVar, int i2) {
        if (fVar == null || pVar == null || pVar.b() == null || this.j == null) {
            return;
        }
        fVar.f63283d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f63269f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f63283d);
        if (this.j.getIs_manager() == 1) {
            if (pVar.b().audit_status.intValue() == 0 && pVar.b().has_forum_rule.intValue() == 0) {
                fVar.f63282c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
            } else if (pVar.b().audit_status.intValue() == 0) {
                fVar.f63282c.setText(pVar.b().title);
            } else if (pVar.b().audit_status.intValue() == 1) {
                fVar.f63282c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
            } else if (pVar.b().audit_status.intValue() == 2) {
                fVar.f63282c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
            }
        } else {
            fVar.f63282c.setText(pVar.b().title);
        }
        fVar.f63281b.setOnClickListener(this.r);
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
            gVar.f63283d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            gVar.f63282c.setOnTouchListener(new i(n1));
            gVar.f63282c.setText(n1);
            if (StringUtils.isNull(this.m)) {
                gVar.f63285e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f63283d.getLayoutParams();
                layoutParams.setMargins((int) this.f63269f.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.f63285e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f63283d.getLayoutParams();
                layoutParams2.setMargins((int) this.f63269f.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.f63285e.U(this.m, 10, false);
            }
            gVar.f63283d.setTextColor(this.l);
            gVar.f63281b.setOnClickListener(this.r);
            h(gVar);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.m)) {
                gVar.f63283d.setText(o);
                gVar.f63283d.setVisibility(0);
                gVar.f63282c.setText(kVar.g());
                gVar.f63285e.setVisibility(8);
            } else {
                gVar.f63283d.setVisibility(8);
                gVar.f63285e.setVisibility(0);
                TextView textView = gVar.f63282c;
                textView.setText(o + "：" + kVar.g());
                gVar.f63285e.U(this.m, 10, false);
            }
            if (kVar.e() != 0) {
                gVar.f63286f.setVisibility(0);
                if (kVar.e() == -1) {
                    gVar.f63286f.setText(this.f63269f.getString(R.string.no_rank));
                } else if (kVar.e() > 999) {
                    gVar.f63286f.setText(this.f63269f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView2 = gVar.f63286f;
                    textView2.setText(this.f63269f.getString(R.string.rang_identify) + kVar.e());
                }
                if (!StringUtils.isNull(kVar.g())) {
                    gVar.f63282c.setText(kVar.g());
                }
            } else {
                gVar.f63286f.setVisibility(8);
            }
            gVar.f63283d.setTextColor(this.l);
            h(gVar);
            gVar.f63282c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                gVar.f63281b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.c())) {
                return;
            }
            a.b b2 = d.a.n0.e3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.c(), this.f63271h, this.f63272i, null);
            b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.f();
        }
    }

    public List<n> n() {
        return this.f63268e;
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
        Context context = this.f63269f;
        if (context instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) context).getPageContext();
        }
        return null;
    }

    public void q(BdUniqueId bdUniqueId) {
    }

    public void r(List<n> list) {
        this.f63268e = list;
        notifyDataSetChanged();
    }

    public void s(String str, String str2, UserData userData) {
        this.f63271h = str;
        this.f63272i = str2;
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
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a((BaseFragmentActivity) this.f63269f);
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
        fVar.f63283d.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f63269f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f63283d);
        fVar.f63282c.setText(riskTipNotice);
        fVar.f63282c.setOnClickListener(new c(fVar, riskTipPop, riskTipPopTitle));
        h(fVar);
        return true;
    }
}
