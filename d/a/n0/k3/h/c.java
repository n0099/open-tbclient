package d.a.n0.k3.h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalBackdropGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalCardCategoryActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.dressCenter.DressupCenterActivity;
import d.a.c.e.p.l;
import d.a.m0.r.s.a;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public DressupCenterActivity f60814a;

    /* renamed from: b  reason: collision with root package name */
    public View f60815b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f60816c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f60817d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f60818e;

    /* renamed from: f  reason: collision with root package name */
    public CoverFlowView<d.a.n0.k3.h.a> f60819f;

    /* renamed from: g  reason: collision with root package name */
    public MemberRecommendView f60820g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f60821h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.k3.h.b f60822i;
    public int j;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            d.a.n0.k3.h.d item = c.this.f60822i.getItem(i2);
            if (item == null) {
                return;
            }
            d.a.m0.r.d0.b j2 = d.a.m0.r.d0.b.j();
            j2.w("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.c(), item.d());
            c.this.f60822i.notifyDataSetChanged();
            if (StringUtils.isNull(item.c())) {
                return;
            }
            String c2 = item.c();
            int d2 = d.a.c.e.m.b.d(c2, 0);
            CustomMessage customMessage = null;
            if (d2 == 1) {
                TiebaStatic.log("c10263");
                c.this.k();
            } else if (d2 == 2) {
                TiebaStatic.log("c10264");
                customMessage = new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(c.this.f60814a.getActivity()));
            } else if (d2 == 3) {
                customMessage = new CustomMessage(2002001, new BubbleGroupActivityConfig(c.this.f60814a.getActivity()));
            } else if (d2 == 4) {
                customMessage = new CustomMessage(2002001, new PersonalCardCategoryActivityConfig(c.this.f60814a.getPageContext().getPageActivity()));
            } else if (d2 != 5) {
                UrlManager.getInstance().dealOneLink(c.this.f60814a.getPageContext(), new String[]{c2});
            } else {
                TiebaStatic.log("c11611");
                customMessage = new CustomMessage(2002001, new AvatarPendantActivityConfig(c.this.f60814a.getActivity()));
            }
            if (customMessage != null) {
                MessageManager.getInstance().sendMessage(customMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b(c cVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* renamed from: d.a.n0.k3.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1483c implements d.a.m0.r.w.a {
        public C1483c(c cVar) {
        }

        @Override // d.a.m0.r.w.a
        public d.a.m0.r.w.b.c a() {
            d.a.m0.r.w.b.c cVar = new d.a.m0.r.w.b.c();
            cVar.c(R.drawable.icon_diandian_white_n);
            cVar.g(R.drawable.icon_diandian_white_s);
            cVar.h(R.dimen.ds1);
            cVar.d(85);
            cVar.f(R.dimen.ds30);
            cVar.e(R.dimen.ds20);
            return cVar;
        }

        @Override // d.a.m0.r.w.a
        public View b() {
            return null;
        }

        @Override // d.a.m0.r.w.a
        public d.a.m0.r.w.b.e c() {
            d.a.m0.r.w.b.e eVar = new d.a.m0.r.w.b.e();
            eVar.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
            return eVar;
        }

        @Override // d.a.m0.r.w.a
        public TbImageView d(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setGifIconSupport(false);
            return tbImageView;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.a.m0.r.w.b.d<d.a.n0.k3.h.a> {
        public d() {
        }

        @Override // d.a.m0.r.w.b.d
        public void b(int i2, String str) {
            TiebaStatic.log("c10262");
            UrlManager.getInstance().dealOneLink(c.this.f60814a.getPageContext(), new String[]{str});
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.r.w.b.d
        /* renamed from: c */
        public void a(int i2, d.a.n0.k3.h.a aVar) {
        }
    }

    public c(DressupCenterActivity dressupCenterActivity) {
        this.j = 0;
        this.f60814a = dressupCenterActivity;
        this.j = l.g(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f60814a.getPageContext().getPageActivity()).inflate(R.layout.dressup_center_activity_layout, (ViewGroup) null);
        this.f60815b = inflate;
        this.f60814a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f60815b.findViewById(R.id.view_navigation_bar);
        this.f60817d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60817d.setCenterTextTitle(this.f60814a.getPageContext().getString(R.string.dressup_center_title));
        this.f60818e = (NoNetworkView) this.f60815b.findViewById(R.id.view_no_network);
        this.f60816c = (BdListView) this.f60815b.findViewById(R.id.dress_listview);
        this.f60819f = (CoverFlowView) this.f60815b.findViewById(R.id.dressup_center_coverflowview);
        j();
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f60815b.findViewById(R.id.dressup_center_recommend);
        this.f60820g = memberRecommendView;
        memberRecommendView.setFromType(1);
        this.f60822i = new d.a.n0.k3.h.b(this.f60814a.getPageContext());
        TextView textView = new TextView(this.f60814a.getActivity());
        this.f60821h = textView;
        textView.setHeight(l.g(this.f60814a.getActivity(), R.dimen.ds30));
        this.f60816c.setAdapter((ListAdapter) this.f60822i);
        this.f60816c.setOnItemClickListener(new a());
    }

    public void d() {
        this.f60814a.hideNetRefreshView(this.f60815b);
        this.f60816c.setVisibility(0);
        this.f60820g.setVisibility(0);
        this.f60819f.setVisibility(0);
    }

    public View e() {
        return this.f60815b;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f() {
        d.a.n0.k3.h.b bVar;
        this.f60814a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f60814a.getLayoutMode().j(this.f60815b);
        NavigationBar navigationBar = this.f60817d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60814a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f60818e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f60814a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        CoverFlowView<d.a.n0.k3.h.a> coverFlowView = this.f60819f;
        if (coverFlowView != null && coverFlowView.getVisibility() == 0) {
            this.f60819f.s();
        }
        BdListView bdListView = this.f60816c;
        if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.f60822i) != null) {
            bVar.notifyDataSetChanged();
        }
        MemberRecommendView memberRecommendView = this.f60820g;
        if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
            this.f60820g.d();
        }
        SkinManager.setBackgroundColor(this.f60821h, R.color.CAM_X0204);
    }

    public final boolean g(List<d.a.n0.k3.h.a> list) {
        if (list != null && list.size() > 0) {
            this.f60819f.setVisibility(0);
            this.f60819f.setData(list);
            return true;
        }
        this.f60819f.setVisibility(8);
        return false;
    }

    public final void h(List<d.a.n0.k3.h.d> list, boolean z) {
        if (list != null && list.size() > 0) {
            if (z) {
                this.f60816c.removeHeaderView(this.f60821h);
                this.f60816c.addHeaderView(this.f60821h);
            } else {
                this.f60816c.removeHeaderView(this.f60821h);
            }
            this.f60816c.setVisibility(0);
            this.f60822i.b(list);
            this.f60822i.notifyDataSetChanged();
            return;
        }
        this.f60816c.setVisibility(8);
    }

    public final boolean i(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f60820g.setVisibility(0);
            this.f60820g.e(eVar);
            return true;
        }
        this.f60820g.setVisibility(8);
        return false;
    }

    public final void j() {
        CoverFlowView<d.a.n0.k3.h.a> coverFlowView = this.f60819f;
        if (coverFlowView == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new C1483c(this));
        this.f60819f.setCallback(new d());
    }

    public final void k() {
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f60814a.getPageContext().getPageActivity());
        aVar.setMessageId(R.string.function_unavailable_tip);
        aVar.setPositiveButton(R.string.confirm, new b(this));
        aVar.create(this.f60814a.getPageContext()).show();
    }

    public void l() {
        this.f60816c.setVisibility(8);
        this.f60819f.setVisibility(8);
        this.f60820g.setVisibility(8);
        String string = this.f60814a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f60814a.setNetRefreshViewTopMargin(this.j);
        this.f60814a.showNetRefreshView(this.f60815b, string, false);
    }

    public void m(List<d.a.n0.k3.h.a> list, e eVar, List<d.a.n0.k3.h.d> list2, boolean z) {
        if ((list != null && list.size() > 0) || ((eVar != null && !StringUtils.isNull(eVar.c())) || (list2 != null && list2.size() > 0))) {
            d();
            h(list2, g(list) || i(eVar));
            return;
        }
        l();
    }
}
