package d.a.j0.i0.c;

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
import d.a.i0.r.q.n1;
import d.a.i0.r.q.o1;
import d.a.i0.r.q.p1;
import d.a.i0.r.q.w;
import d.a.i0.r.s.a;
import d.a.j0.d3.n0.f;
import d.a.j0.i0.h.b;
import d.a.j0.i0.m.f;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f54919e;

    /* renamed from: f  reason: collision with root package name */
    public ViewEventCenter f54920f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.i0.m.f f54921g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.i0.h.b f54922h;

    /* renamed from: i  reason: collision with root package name */
    public EnterForumModel f54923i;
    public d.a.j0.i0.d.c l;
    public d.a.j0.i0.m.b m;
    public List<w> j = new ArrayList();
    public boolean k = true;
    public f.c o = new f(this);
    public HashSet<Long> n = new HashSet<>();

    /* renamed from: d.a.j0.i0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1281a implements f.j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.i0.m.b f54924a;

        public C1281a(d.a.j0.i0.m.b bVar) {
            this.f54924a = bVar;
        }

        @Override // d.a.j0.i0.m.f.j
        public void a() {
            a.this.notifyDataSetChanged();
            this.f54924a.r0(a.this.f54921g.s());
            this.f54924a.s0(a.this.f54921g.t());
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.d {
        public b() {
        }

        @Override // d.a.j0.i0.h.b.d
        public void a(int i2) {
            a.this.f54923i.E(true, i2);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f54920f != null) {
                a.this.f54920f.dispatchMvcEvent(new d.a.i0.g0.c.b(6, null, null, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f54920f != null) {
                a.this.f54920f.dispatchMvcEvent(new d.a.i0.g0.c.b(6, null, null, null));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {

        /* renamed from: d.a.j0.i0.c.a$e$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C1282a implements a.e {
            public C1282a() {
            }

            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                d.a.j0.d3.n0.f.b(NetWorkErr.ERROR_UEG_BIND_MOBILE, "", a.this.o);
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class b implements a.e {
            public b(e eVar) {
            }

            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        /* loaded from: classes4.dex */
        public class c implements a.e {
            public c(e eVar) {
            }

            @Override // d.a.i0.r.s.a.e
            public void onClick(d.a.i0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.log("c13379");
            if (a.this.f54923i.u()) {
                if (a.this.f54920f != null) {
                    a.this.f54920f.dispatchMvcEvent(new d.a.i0.g0.c.b(14, null, null, null));
                    return;
                }
                return;
            }
            boolean z = false;
            ForumCreateInfoData b2 = a.this.f54923i.w().b();
            if (b2 != null) {
                int t = b2.t();
                if (t == 220012) {
                    BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                    blockPopInfoData.block_info = k.isEmpty(b2.s()) ? a.this.f54919e.getResources().getString(R.string.create_forum_block_tip) : b2.s();
                    blockPopInfoData.ahead_info = a.this.f54919e.getResources().getString(R.string.create_forum_feed);
                    blockPopInfoData.ok_info = a.this.f54919e.getResources().getString(R.string.know);
                    blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                    AntiHelper.s(a.this.f54919e.getPageActivity(), blockPopInfoData);
                } else if (t == 2121002) {
                    d.a.i0.s.h.a.b(a.this.f54919e, null, a.this.f54919e.getResources().getString(R.string.create_forum_register_mobile_tip), a.this.f54919e.getResources().getString(R.string.to_binding), a.this.f54919e.getResources().getString(R.string.think_more), new C1282a(), new b(this)).show();
                }
                z = true;
            }
            if (z) {
                return;
            }
            String string = a.this.f54919e.getResources().getString(R.string.create_forum_err);
            if (b2 != null) {
                string = k.isEmpty(b2.s()) ? a.this.f54919e.getResources().getString(R.string.create_forum_err) : b2.s();
            }
            d.a.i0.s.h.a.b(a.this.f54919e, null, string, a.this.f54919e.getResources().getString(R.string.know), null, new c(this), null).show();
        }
    }

    /* loaded from: classes4.dex */
    public class f extends f.c {
        public f(a aVar) {
        }

        @Override // d.a.j0.d3.n0.f.c
        public void a(String str) {
        }

        @Override // d.a.j0.d3.n0.f.c
        public void c(String str) {
        }

        @Override // d.a.j0.d3.n0.f.c
        public void d() {
        }

        @Override // d.a.j0.d3.n0.f.c
        public void e() {
        }
    }

    /* loaded from: classes4.dex */
    public class g {

        /* renamed from: a  reason: collision with root package name */
        public TextView f54931a;

        /* renamed from: b  reason: collision with root package name */
        public View f54932b;

        public g(a aVar) {
        }

        public /* synthetic */ g(a aVar, C1281a c1281a) {
            this(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class h {

        /* renamed from: a  reason: collision with root package name */
        public View f54933a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f54934b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f54935c;

        /* renamed from: d  reason: collision with root package name */
        public TBSpecificationBtn f54936d;

        public h(a aVar) {
        }

        public /* synthetic */ h(a aVar, C1281a c1281a) {
            this(aVar);
        }
    }

    /* loaded from: classes4.dex */
    public class i {

        /* renamed from: a  reason: collision with root package name */
        public TextView f54937a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f54938b;

        /* renamed from: c  reason: collision with root package name */
        public RelativeLayout f54939c;

        public i(a aVar) {
        }

        public /* synthetic */ i(a aVar, C1281a c1281a) {
            this(aVar);
        }
    }

    public a(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter, RecentlyVisitedForumModel recentlyVisitedForumModel, EnterForumModel enterForumModel, d.a.j0.i0.m.b bVar) {
        this.f54919e = tbPageContext;
        this.f54920f = viewEventCenter;
        this.m = bVar;
        d.a.j0.i0.m.f fVar = new d.a.j0.i0.m.f(this.f54919e, recentlyVisitedForumModel, viewEventCenter);
        this.f54921g = fVar;
        fVar.E(new C1281a(bVar));
        this.f54923i = enterForumModel;
        d.a.j0.i0.h.b bVar2 = new d.a.j0.i0.h.b(this.f54919e.getPageActivity(), Integer.valueOf(d.a.i0.r.d0.b.j().k("key_LIKE_forum_sort_state", 2)).intValue(), 0, this.f54921g);
        this.f54922h = bVar2;
        bVar2.u(new b());
    }

    public boolean f() {
        d.a.j0.i0.m.f fVar = this.f54921g;
        if (fVar == null) {
            return false;
        }
        return fVar.k();
    }

    public void g() {
        d.a.j0.i0.m.f fVar = this.f54921g;
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
        d.a.j0.i0.m.c cVar;
        w wVar;
        g gVar;
        h hVar;
        d.a.j0.i0.n.a aVar;
        d.a.j0.i0.n.e eVar;
        d.a.j0.i0.n.f fVar;
        d.a.j0.i0.n.d dVar;
        d.a.j0.i0.n.b bVar;
        d.a.j0.i0.n.c cVar2;
        switch (getItemViewType(i2)) {
            case 0:
                if (view != null && (view.getTag() instanceof i)) {
                    iVar = (i) view.getTag();
                } else {
                    view = this.f54919e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_title_item, viewGroup, false);
                    iVar = new i(this, null);
                    iVar.f54937a = (TextView) view.findViewById(R.id.title);
                    iVar.f54938b = (TextView) view.findViewById(R.id.sort_tab_menu_button);
                    iVar.f54939c = (RelativeLayout) view.findViewById(R.id.container);
                    view.setTag(iVar);
                }
                if (this.j.get(i2) instanceof d.a.j0.i0.d.e) {
                    d.a.j0.i0.d.e eVar2 = (d.a.j0.i0.d.e) this.j.get(i2);
                    this.f54922h.v(iVar.f54938b);
                    this.f54922h.r();
                    this.f54922h.q(TbadkCoreApplication.getInst().getSkinType());
                    if (eVar2 != null) {
                        iVar.f54937a.setText(eVar2.f54957h);
                        SkinManager.setViewTextColor(iVar.f54937a, R.color.CAM_X0105);
                        d.a.j0.i0.d.c cVar3 = this.l;
                        if (cVar3 != null && cVar3.f54944a) {
                            SkinManager.setBackgroundResource(iVar.f54939c, R.drawable.enter_forum_attenten_bar_ad_bg);
                        } else {
                            SkinManager.setBackgroundColor(iVar.f54939c, R.color.CAM_X0205);
                        }
                        TextView textView = iVar.f54938b;
                        if (textView != null) {
                            if (eVar2.f54958i) {
                                textView.setVisibility(0);
                            } else {
                                textView.setVisibility(8);
                            }
                            SkinManager.setBackgroundColor(iVar.f54938b, R.color.transparent);
                            return view;
                        }
                        return view;
                    }
                    return view;
                }
                return view;
            case 1:
                if (view != null && (view.getTag() instanceof d.a.j0.i0.m.c)) {
                    cVar = (d.a.j0.i0.m.c) view.getTag();
                } else {
                    view = this.f54919e.getPageActivity().getLayoutInflater().inflate(R.layout.home_like_list_item, viewGroup, false);
                    cVar = new d.a.j0.i0.m.c(this.f54919e, view, this.f54920f);
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
                    view = this.f54919e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_footer_item, (ViewGroup) null);
                    gVar = new g(this, null);
                    gVar.f54931a = (TextView) view.findViewById(R.id.footer_text);
                    gVar.f54932b = view.findViewById(R.id.container);
                    view.setTag(gVar);
                }
                View view2 = gVar.f54932b;
                if (view2 != null) {
                    view2.setOnClickListener(new c());
                }
                SkinManager.setViewTextColor(gVar.f54931a, R.color.CAM_X0304);
                return view;
            case 3:
                if (view != null && (view.getTag() instanceof h)) {
                    hVar = (h) view.getTag();
                } else {
                    view = this.f54919e.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_interest_image_item, (ViewGroup) null);
                    hVar = new h(this, null);
                    hVar.f54933a = view.findViewById(R.id.root);
                    hVar.f54934b = (ImageView) view.findViewById(R.id.image);
                    hVar.f54935c = (TextView) view.findViewById(R.id.hint_text);
                    hVar.f54936d = (TBSpecificationBtn) view.findViewById(R.id.footer_text);
                    d.a.i0.r.f0.m.a aVar2 = new d.a.i0.r.f0.m.a();
                    hVar.f54936d.setTextSize(R.dimen.tbds42);
                    hVar.f54936d.setConfig(aVar2);
                    view.setTag(hVar);
                }
                if (!TbadkCoreApplication.isLogin()) {
                    hVar.f54935c.setText(R.string.enter_forum_login_interest);
                    hVar.f54936d.setText(this.f54919e.getResources().getString(R.string.click_here_to_login_in));
                    hVar.f54936d.setTextHorizontalCenter(true);
                    SkinManager.setImageResource(hVar.f54934b, R.drawable.new_pic_emotion_09);
                } else {
                    hVar.f54935c.setText(R.string.forum_waiting_for_your_attention);
                    hVar.f54936d.setText(this.f54919e.getResources().getString(R.string.click_here_to_explore_more_forum));
                    SkinManager.setImageResource(hVar.f54934b, R.drawable.new_pic_emotion_01);
                }
                SkinManager.setViewTextColor(hVar.f54935c, R.color.CAM_X0107);
                SkinManager.setBackgroundColor(hVar.f54933a, R.color.CAM_X0205);
                hVar.f54936d.k();
                TBSpecificationBtn tBSpecificationBtn = hVar.f54936d;
                if (tBSpecificationBtn != null) {
                    tBSpecificationBtn.setOnClickListener(new d());
                    return view;
                }
                return view;
            case 4:
                View o = this.f54921g.o();
                this.f54921g.z();
                return o;
            case 5:
                m();
                if (view != null && (view.getTag() instanceof d.a.j0.i0.n.a)) {
                    aVar = (d.a.j0.i0.n.a) view.getTag();
                } else {
                    aVar = new d.a.j0.i0.n.a(this.f54919e);
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
                if (view != null && (view.getTag() instanceof d.a.j0.i0.n.e)) {
                    eVar = (d.a.j0.i0.n.e) view.getTag();
                } else {
                    eVar = new d.a.j0.i0.n.e(this.f54919e);
                    view = eVar.d();
                    view.setTag(eVar);
                }
                if (this.j.get(i2) instanceof p1) {
                    eVar.c((p1) this.j.get(i2));
                }
                if (this.f54923i.w() == null || this.f54923i.w().e() == null || this.f54923i.w().e().b() == null) {
                    return view;
                }
                eVar.e(this.f54923i.w().e().b().size() > 0);
                return view;
            case 8:
                if (view != null && (view.getTag() instanceof d.a.j0.i0.n.f)) {
                    fVar = (d.a.j0.i0.n.f) view.getTag();
                } else {
                    fVar = new d.a.j0.i0.n.f(this.f54919e);
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
                        if (this.f54923i.w() != null && this.f54923i.w().e() != null && this.f54923i.w().e().b() != null) {
                            boolean z = this.f54923i.w().e().b().size() > 0;
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
                if (view != null && (view.getTag() instanceof d.a.j0.i0.n.d)) {
                    dVar = (d.a.j0.i0.n.d) view.getTag();
                } else {
                    dVar = new d.a.j0.i0.n.d(this.f54919e);
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
                if (view != null && (view.getTag() instanceof d.a.j0.i0.n.b)) {
                    bVar = (d.a.j0.i0.n.b) view.getTag();
                } else {
                    bVar = new d.a.j0.i0.n.b(this.f54919e);
                    view = bVar.d();
                    view.setTag(bVar);
                }
                if (this.j.get(i2) instanceof d.a.j0.i0.d.a) {
                    bVar.c((d.a.j0.i0.d.a) this.j.get(i2));
                }
                if (this.f54923i.w() == null || this.f54923i.w().e() == null || this.f54923i.w().e().b() == null) {
                    return view;
                }
                bVar.e(this.f54923i.w().e().b().size() > 0);
                return view;
            case 11:
                if (view != null && (view.getTag() instanceof d.a.j0.i0.n.c)) {
                    cVar2 = (d.a.j0.i0.n.c) view.getTag();
                } else {
                    cVar2 = new d.a.j0.i0.n.c(this.f54919e);
                    view = cVar2.b();
                    view.setTag(cVar2);
                }
                cVar2.a();
                return view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final int getViewTypeCount() {
        return w.f49292g.length;
    }

    public void h() {
        this.k = true;
        this.n.clear();
    }

    public void i(int i2) {
        d.a.j0.i0.h.b bVar = this.f54922h;
        if (bVar != null) {
            bVar.t(i2);
        }
    }

    public void j(d.a.j0.i0.d.c cVar) {
        if (cVar != this.l) {
            this.l = cVar;
            boolean z = cVar.f54944a;
            boolean z2 = cVar.f54945b;
            int i2 = cVar.f54946c;
            notifyDataSetChanged();
        }
        d.a.j0.i0.m.f fVar = this.f54921g;
        if (fVar != null) {
            fVar.C(cVar);
        }
    }

    public void k(List<w> list, boolean z) {
        d.a.j0.i0.h.b bVar = this.f54922h;
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
        d.a.j0.i0.m.f fVar = this.f54921g;
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
