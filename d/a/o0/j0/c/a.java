package d.a.o0.j0.c;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.NetWorkErr;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumModel;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.a.c.e.p.k;
import d.a.n0.r.q.n1;
import d.a.n0.r.q.o1;
import d.a.n0.r.q.p1;
import d.a.n0.r.q.w;
import d.a.n0.r.s.a;
import d.a.o0.e3.n0.f;
import d.a.o0.j0.h.b;
import d.a.o0.j0.m.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f59624e;

    /* renamed from: f  reason: collision with root package name */
    public ViewEventCenter f59625f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.j0.m.f f59626g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.o0.j0.h.b f59627h;

    /* renamed from: i  reason: collision with root package name */
    public EnterForumModel f59628i;
    public d.a.o0.j0.d.c l;
    public d.a.o0.j0.m.b m;
    public List<w> j = new ArrayList();
    public boolean k = true;
    public f.c o = new f(this);
    public HashSet<Long> n = new HashSet<>();

    /* renamed from: d.a.o0.j0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1431a implements f.j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.o0.j0.m.b f59629a;

        public C1431a(d.a.o0.j0.m.b bVar) {
            this.f59629a = bVar;
        }

        @Override // d.a.o0.j0.m.f.j
        public void a() {
            a.this.notifyDataSetChanged();
            this.f59629a.r0(a.this.f59626g.s());
            this.f59629a.s0(a.this.f59626g.t());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.d {
        public b() {
        }

        @Override // d.a.o0.j0.h.b.d
        public void a(int i2) {
            a.this.f59628i.I(true, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f59625f != null) {
                a.this.f59625f.dispatchMvcEvent(new d.a.n0.g0.c.b(6, null, null, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f59625f != null) {
                a.this.f59625f.dispatchMvcEvent(new d.a.n0.g0.c.b(6, null, null, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d.a.o0.j0.c.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1432a implements a.e {
            public C1432a() {
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                d.a.o0.e3.n0.f.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", a.this.o);
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b(e eVar) {
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class c implements a.e {
            public c(e eVar) {
            }

            @Override // d.a.n0.r.s.a.e
            public void onClick(d.a.n0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c13379");
            if (a.this.f59628i.y()) {
                if (a.this.f59625f != null) {
                    a.this.f59625f.dispatchMvcEvent(new d.a.n0.g0.c.b(14, null, null, null));
                    return;
                }
                return;
            }
            boolean z = false;
            ForumCreateInfoData b2 = a.this.f59628i.A().b();
            if (b2 != null) {
                int x = b2.x();
                if (x == 220012) {
                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                    blockPopInfoData.block_info = k.isEmpty(b2.w()) ? a.this.f59624e.getResources().getString(R.string.create_forum_block_tip) : b2.w();
                    blockPopInfoData.ahead_info = a.this.f59624e.getResources().getString(R.string.create_forum_feed);
                    blockPopInfoData.ok_info = a.this.f59624e.getResources().getString(R.string.know);
                    blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                    AntiHelper.s(a.this.f59624e.getPageActivity(), blockPopInfoData);
                } else if (x == 2121002) {
                    d.a.n0.s.h.a.b(a.this.f59624e, null, a.this.f59624e.getResources().getString(R.string.create_forum_register_mobile_tip), a.this.f59624e.getResources().getString(R.string.to_binding), a.this.f59624e.getResources().getString(R.string.think_more), new C1432a(), new b(this)).show();
                }
                z = true;
            }
            if (z) {
                return;
            }
            String string = a.this.f59624e.getResources().getString(R.string.create_forum_err);
            if (b2 != null) {
                string = k.isEmpty(b2.w()) ? a.this.f59624e.getResources().getString(R.string.create_forum_err) : b2.w();
            }
            d.a.n0.s.h.a.b(a.this.f59624e, null, string, a.this.f59624e.getResources().getString(R.string.know), null, new c(this), null).show();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends f.c {
        public f(a aVar) {
        }

        @Override // d.a.o0.e3.n0.f.c
        public void a(String str) {
        }

        @Override // d.a.o0.e3.n0.f.c
        public void c(String str) {
        }

        @Override // d.a.o0.e3.n0.f.c
        public void d() {
        }

        @Override // d.a.o0.e3.n0.f.c
        public void e() {
        }
    }

    /* loaded from: classes4.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59636a;

        /* renamed from: b  reason: collision with root package name */
        public View f59637b;

        public g(a aVar) {
        }

        public /* synthetic */ g(a aVar, C1431a c1431a) {
            this(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public View f59638a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f59639b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f59640c;

        /* renamed from: d  reason: collision with root package name */
        public TBSpecificationBtn f59641d;

        public h(a aVar) {
        }

        public /* synthetic */ h(a aVar, C1431a c1431a) {
            this(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        public TextView f59642a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f59643b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f59644c;

        public i(a aVar) {
        }

        public /* synthetic */ i(a aVar, C1431a c1431a) {
            this(aVar);
        }
    }

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, d.a.o0.j0.m.b bVar) {
        this.f59624e = tbPageContext;
        this.f59625f = viewEventCenter;
        this.m = bVar;
        d.a.o0.j0.m.f fVar = new d.a.o0.j0.m.f(this.f59624e, recentlyVisitedForumModel, viewEventCenter);
        this.f59626g = fVar;
        fVar.E(new C1431a(bVar));
        this.f59628i = enterForumModel;
        d.a.o0.j0.h.b bVar2 = new d.a.o0.j0.h.b(this.f59624e.getPageActivity(), Integer.valueOf(d.a.n0.r.d0.b.j().k("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.f59626g);
        this.f59627h = bVar2;
        bVar2.u(new b());
    }

    public boolean f() {
        d.a.o0.j0.m.f fVar = this.f59626g;
        if (fVar == null) {
            return false;
        }
        return fVar.k();
    }

    public void g() {
        d.a.o0.j0.m.f fVar = this.f59626g;
        if (fVar != null) {
            fVar.x();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.j.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        int size = this.j.size();
        if (size <= 0 || i2 >= size) {
            return null;
        }
        return this.j.get(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        List<w> list = this.j;
        if (list == null || (i2 < list.size() && i2 >= 0)) {
            return i2;
        }
        return -1L;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        if (i2 >= this.j.size() || i2 < 0) {
            return 6;
        }
        return this.j.get(i2).z();
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        i iVar;
        d.a.o0.j0.m.c cVar;
        w wVar;
        g gVar;
        h hVar;
        d.a.o0.j0.n.a aVar;
        d.a.o0.j0.n.e eVar;
        d.a.o0.j0.n.f fVar;
        d.a.o0.j0.n.d dVar;
        d.a.o0.j0.n.b bVar;
        d.a.o0.j0.n.c cVar2;
        switch (getItemViewType(i2)) {
            case 0:
                if (view != null && (view.getTag() instanceof i)) {
                    iVar = (i) view.getTag();
                } else {
                    view = this.f59624e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                    iVar = new i(this, null);
                    iVar.f59642a = (TextView) view.findViewById(R.id.title);
                    iVar.f59643b = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    iVar.f59644c = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(iVar);
                }
                if (this.j.get(i2) instanceof d.a.o0.j0.d.e) {
                    d.a.o0.j0.d.e eVar2 = (d.a.o0.j0.d.e) this.j.get(i2);
                    this.f59627h.v(iVar.f59643b);
                    this.f59627h.r();
                    this.f59627h.q(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar2 != null) {
                        iVar.f59642a.setText(eVar2.f59662h);
                        SkinManager.setViewTextColor(iVar.f59642a, R.color.CAM_X0105);
                        d.a.o0.j0.d.c cVar3 = this.l;
                        if (cVar3 != null && cVar3.f59649a) {
                            SkinManager.setBackgroundResource(iVar.f59644c, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            SkinManager.setBackgroundColor(iVar.f59644c, R.color.CAM_X0205);
                        }
                        TextView textView = iVar.f59643b;
                        if (textView != null) {
                            if (eVar2.f59663i) {
                                textView.setVisibility(0);
                            } else {
                                textView.setVisibility(8);
                            }
                            SkinManager.setBackgroundColor(iVar.f59643b, R.color.transparent);
                            return view;
                        }
                        return view;
                    }
                    return view;
                }
                return view;
            case 1:
                if (view != null && (view.getTag() instanceof d.a.o0.j0.m.c)) {
                    cVar = (d.a.o0.j0.m.c) view.getTag();
                } else {
                    view = this.f59624e.getPageActivity().getLayoutInflater().inflate(R.layout.home_like_list_item, viewGroup, false);
                    cVar = new d.a.o0.j0.m.c(this.f59624e, view, this.f59625f);
                    view.setTag(cVar);
                }
                if ((this.j.get(i2) instanceof w) && (wVar = this.j.get(i2)) != null) {
                    cVar.k(wVar);
                }
                cVar.m(this.l);
                return view;
            case 2:
                if (view != null && (view.getTag() instanceof g)) {
                    gVar = (g) view.getTag();
                } else {
                    view = this.f59624e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    gVar = new g(this, null);
                    gVar.f59636a = (TextView) view.findViewById(R.id.footer_text);
                    gVar.f59637b = view.findViewById(R.id.container);
                    view.setTag(gVar);
                }
                View view2 = gVar.f59637b;
                if (view2 != null) {
                    view2.setOnClickListener(new c());
                }
                SkinManager.setViewTextColor(gVar.f59636a, R.color.CAM_X0304);
                return view;
            case 3:
                if (view != null && (view.getTag() instanceof h)) {
                    hVar = (h) view.getTag();
                } else {
                    view = this.f59624e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    hVar = new h(this, null);
                    hVar.f59638a = view.findViewById(R.id.root);
                    hVar.f59639b = (ImageView) view.findViewById(R.id.image);
                    hVar.f59640c = (TextView) view.findViewById(R.id.hint_text);
                    hVar.f59641d = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                    d.a.n0.r.f0.m.a aVar2 = new d.a.n0.r.f0.m.a();
                    hVar.f59641d.setTextSize(R.dimen.tbds42);
                    hVar.f59641d.setConfig(aVar2);
                    view.setTag(hVar);
                }
                if (!TbadkCoreApplication.isLogin()) {
                    hVar.f59640c.setText(R.string.enter_forum_login_interest);
                    hVar.f59641d.setText(this.f59624e.getResources().getString(R.string.click_here_to_login_in));
                    hVar.f59641d.setTextHorizontalCenter(true);
                    SkinManager.setImageResource(hVar.f59639b, R.drawable.new_pic_emotion_09);
                } else {
                    hVar.f59640c.setText(R.string.forum_waiting_for_your_attention);
                    hVar.f59641d.setText(this.f59624e.getResources().getString(R.string.click_here_to_explore_more_forum));
                    SkinManager.setImageResource(hVar.f59639b, R.drawable.new_pic_emotion_01);
                }
                SkinManager.setViewTextColor(hVar.f59640c, R.color.CAM_X0107);
                SkinManager.setBackgroundColor(hVar.f59638a, R.color.CAM_X0205);
                hVar.f59641d.k();
                TBSpecificationBtn tBSpecificationBtn = hVar.f59641d;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setOnClickListener(new d());
                    return view;
                }
                return view;
            case 4:
                View o = this.f59626g.o();
                this.f59626g.z();
                return o;
            case 5:
                m();
                if (view != null && (view.getTag() instanceof d.a.o0.j0.n.a)) {
                    aVar = (d.a.o0.j0.n.a) view.getTag();
                } else {
                    aVar = new d.a.o0.j0.n.a(this.f59624e);
                    view = aVar.b();
                    view.setTag(aVar);
                }
                aVar.a();
                aVar.c(new e());
                return view;
            case 6:
            default:
                return view;
            case 7:
                if (view != null && (view.getTag() instanceof d.a.o0.j0.n.e)) {
                    eVar = (d.a.o0.j0.n.e) view.getTag();
                } else {
                    eVar = new d.a.o0.j0.n.e(this.f59624e);
                    view = eVar.d();
                    view.setTag(eVar);
                }
                if (this.j.get(i2) instanceof p1) {
                    eVar.c((p1) this.j.get(i2));
                }
                if (this.f59628i.A() == null || this.f59628i.A().e() == null || this.f59628i.A().e().b() == null) {
                    return view;
                }
                eVar.e(this.f59628i.A().e().b().size() > 0);
                return view;
            case 8:
                if (view != null && (view.getTag() instanceof d.a.o0.j0.n.f)) {
                    fVar = (d.a.o0.j0.n.f) view.getTag();
                } else {
                    fVar = new d.a.o0.j0.n.f(this.f59624e);
                    view = fVar.k();
                    view.setTag(fVar);
                }
                if (this.j.get(i2) instanceof n1) {
                    n1 n1Var = (n1) this.j.get(i2);
                    fVar.g(n1Var);
                    if (this.m.K().getGlobalVisibleRect(new Rect()) && view.getGlobalVisibleRect(new Rect()) && !this.n.contains(Long.valueOf(n1Var.C()))) {
                        StatisticItem statisticItem = new StatisticItem("c13642");
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("fid", n1Var.C());
                        statisticItem.param("obj_locate", 1);
                        if (this.f59628i.A() != null && this.f59628i.A().e() != null && this.f59628i.A().e().b() != null) {
                            boolean z = this.f59628i.A().e().b().size() > 0;
                            statisticItem.param("obj_type", z ? 3 : 1);
                            fVar.m(z);
                        }
                        TiebaStatic.log(statisticItem);
                        this.n.add(Long.valueOf(n1Var.C()));
                        return view;
                    }
                    return view;
                }
                return view;
            case 9:
                if (view != null && (view.getTag() instanceof d.a.o0.j0.n.d)) {
                    dVar = (d.a.o0.j0.n.d) view.getTag();
                } else {
                    dVar = new d.a.o0.j0.n.d(this.f59624e);
                    view = dVar.c();
                    view.setTag(dVar);
                }
                if (this.j.get(i2) instanceof o1) {
                    dVar.b((o1) this.j.get(i2));
                }
                StatisticItem statisticItem2 = new StatisticItem("c13641");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem2.param("obj_locate", 1);
                TiebaStatic.log(statisticItem2);
                return view;
            case 10:
                if (view != null && (view.getTag() instanceof d.a.o0.j0.n.b)) {
                    bVar = (d.a.o0.j0.n.b) view.getTag();
                } else {
                    bVar = new d.a.o0.j0.n.b(this.f59624e);
                    view = bVar.d();
                    view.setTag(bVar);
                }
                if (this.j.get(i2) instanceof d.a.o0.j0.d.a) {
                    bVar.c((d.a.o0.j0.d.a) this.j.get(i2));
                }
                if (this.f59628i.A() == null || this.f59628i.A().e() == null || this.f59628i.A().e().b() == null) {
                    return view;
                }
                bVar.e(this.f59628i.A().e().b().size() > 0);
                return view;
            case 11:
                if (view != null && (view.getTag() instanceof d.a.o0.j0.n.c)) {
                    cVar2 = (d.a.o0.j0.n.c) view.getTag();
                } else {
                    cVar2 = new d.a.o0.j0.n.c(this.f59624e);
                    view = cVar2.b();
                    view.setTag(cVar2);
                }
                cVar2.a();
                return view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return w.f53938g.length;
    }

    public void h() {
        this.k = true;
        this.n.clear();
    }

    public void i(int i2) {
        d.a.o0.j0.h.b bVar = this.f59627h;
        if (bVar != null) {
            bVar.t(i2);
        }
    }

    public void j(d.a.o0.j0.d.c cVar) {
        if (cVar != this.l) {
            this.l = cVar;
            boolean z = cVar.f59649a;
            boolean z2 = cVar.f59650b;
            int i2 = cVar.f59651c;
            notifyDataSetChanged();
        }
        d.a.o0.j0.m.f fVar = this.f59626g;
        if (fVar != null) {
            fVar.C(cVar);
        }
    }

    public void k(List<w> list, boolean z) {
        d.a.o0.j0.h.b bVar = this.f59627h;
        if (bVar != null) {
            bVar.p();
        }
        this.j.clear();
        if (list != null) {
            this.j.addAll(list);
        }
        this.m.V(z);
    }

    public void l(BdUniqueId bdUniqueId) {
        d.a.o0.j0.m.f fVar = this.f59626g;
        if (fVar != null) {
            fVar.F(bdUniqueId);
        }
    }

    public void m() {
        if (this.k) {
            TiebaStatic.log("c13378");
            this.k = false;
        }
    }
}
