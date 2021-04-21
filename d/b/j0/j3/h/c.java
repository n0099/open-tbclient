package d.b.j0.j3.h;

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
import d.b.c.e.p.l;
import d.b.i0.r.s.a;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public DressupCenterActivity f58245a;

    /* renamed from: b  reason: collision with root package name */
    public View f58246b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f58247c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f58248d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f58249e;

    /* renamed from: f  reason: collision with root package name */
    public CoverFlowView<d.b.j0.j3.h.a> f58250f;

    /* renamed from: g  reason: collision with root package name */
    public MemberRecommendView f58251g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f58252h;
    public d.b.j0.j3.h.b i;
    public int j;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d.b.j0.j3.h.d item = c.this.i.getItem(i);
            if (item == null) {
                return;
            }
            d.b.i0.r.d0.b j2 = d.b.i0.r.d0.b.j();
            j2.w("dressup_center_red_tip_" + TbadkCoreApplication.getCurrentAccount() + "_" + item.c(), item.d());
            c.this.i.notifyDataSetChanged();
            if (StringUtils.isNull(item.c())) {
                return;
            }
            String c2 = item.c();
            int d2 = d.b.c.e.m.b.d(c2, 0);
            CustomMessage customMessage = null;
            if (d2 == 1) {
                TiebaStatic.log("c10263");
                c.this.k();
            } else if (d2 == 2) {
                TiebaStatic.log("c10264");
                customMessage = new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(c.this.f58245a.getActivity()));
            } else if (d2 == 3) {
                customMessage = new CustomMessage(2002001, new BubbleGroupActivityConfig(c.this.f58245a.getActivity()));
            } else if (d2 == 4) {
                customMessage = new CustomMessage(2002001, new PersonalCardCategoryActivityConfig(c.this.f58245a.getPageContext().getPageActivity()));
            } else if (d2 != 5) {
                UrlManager.getInstance().dealOneLink(c.this.f58245a.getPageContext(), new String[]{c2});
            } else {
                TiebaStatic.log("c11611");
                customMessage = new CustomMessage(2002001, new AvatarPendantActivityConfig(c.this.f58245a.getActivity()));
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

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* renamed from: d.b.j0.j3.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1398c implements d.b.i0.r.w.a {
        public C1398c(c cVar) {
        }

        @Override // d.b.i0.r.w.a
        public d.b.i0.r.w.b.c a() {
            d.b.i0.r.w.b.c cVar = new d.b.i0.r.w.b.c();
            cVar.c(R.drawable.icon_diandian_white_n);
            cVar.g(R.drawable.icon_diandian_white_s);
            cVar.h(R.dimen.ds1);
            cVar.d(85);
            cVar.f(R.dimen.ds30);
            cVar.e(R.dimen.ds20);
            return cVar;
        }

        @Override // d.b.i0.r.w.a
        public View b() {
            return null;
        }

        @Override // d.b.i0.r.w.a
        public TbImageView c(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setGifIconSupport(false);
            return tbImageView;
        }

        @Override // d.b.i0.r.w.a
        public d.b.i0.r.w.b.e d() {
            d.b.i0.r.w.b.e eVar = new d.b.i0.r.w.b.e();
            eVar.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
            return eVar;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.b.i0.r.w.b.d<d.b.j0.j3.h.a> {
        public d() {
        }

        @Override // d.b.i0.r.w.b.d
        public void b(int i, String str) {
            TiebaStatic.log("c10262");
            UrlManager.getInstance().dealOneLink(c.this.f58245a.getPageContext(), new String[]{str});
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.i0.r.w.b.d
        /* renamed from: c */
        public void a(int i, d.b.j0.j3.h.a aVar) {
        }
    }

    public c(DressupCenterActivity dressupCenterActivity) {
        this.j = 0;
        this.f58245a = dressupCenterActivity;
        this.j = l.g(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f58245a.getPageContext().getPageActivity()).inflate(R.layout.dressup_center_activity_layout, (ViewGroup) null);
        this.f58246b = inflate;
        this.f58245a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f58246b.findViewById(R.id.view_navigation_bar);
        this.f58248d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58248d.setCenterTextTitle(this.f58245a.getPageContext().getString(R.string.dressup_center_title));
        this.f58249e = (NoNetworkView) this.f58246b.findViewById(R.id.view_no_network);
        this.f58247c = (BdListView) this.f58246b.findViewById(R.id.dress_listview);
        this.f58250f = (CoverFlowView) this.f58246b.findViewById(R.id.dressup_center_coverflowview);
        j();
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f58246b.findViewById(R.id.dressup_center_recommend);
        this.f58251g = memberRecommendView;
        memberRecommendView.setFromType(1);
        this.i = new d.b.j0.j3.h.b(this.f58245a.getPageContext());
        TextView textView = new TextView(this.f58245a.getActivity());
        this.f58252h = textView;
        textView.setHeight(l.g(this.f58245a.getActivity(), R.dimen.ds30));
        this.f58247c.setAdapter((ListAdapter) this.i);
        this.f58247c.setOnItemClickListener(new a());
    }

    public void d() {
        this.f58245a.hideNetRefreshView(this.f58246b);
        this.f58247c.setVisibility(0);
        this.f58251g.setVisibility(0);
        this.f58250f.setVisibility(0);
    }

    public View e() {
        return this.f58246b;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f() {
        d.b.j0.j3.h.b bVar;
        this.f58245a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f58245a.getLayoutMode().j(this.f58246b);
        NavigationBar navigationBar = this.f58248d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f58245a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f58249e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f58245a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        CoverFlowView<d.b.j0.j3.h.a> coverFlowView = this.f58250f;
        if (coverFlowView != null && coverFlowView.getVisibility() == 0) {
            this.f58250f.s();
        }
        BdListView bdListView = this.f58247c;
        if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.i) != null) {
            bVar.notifyDataSetChanged();
        }
        MemberRecommendView memberRecommendView = this.f58251g;
        if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
            this.f58251g.d();
        }
        SkinManager.setBackgroundColor(this.f58252h, R.color.CAM_X0204);
    }

    public final boolean g(List<d.b.j0.j3.h.a> list) {
        if (list != null && list.size() > 0) {
            this.f58250f.setVisibility(0);
            this.f58250f.setData(list);
            return true;
        }
        this.f58250f.setVisibility(8);
        return false;
    }

    public final void h(List<d.b.j0.j3.h.d> list, boolean z) {
        if (list != null && list.size() > 0) {
            if (z) {
                this.f58247c.removeHeaderView(this.f58252h);
                this.f58247c.addHeaderView(this.f58252h);
            } else {
                this.f58247c.removeHeaderView(this.f58252h);
            }
            this.f58247c.setVisibility(0);
            this.i.b(list);
            this.i.notifyDataSetChanged();
            return;
        }
        this.f58247c.setVisibility(8);
    }

    public final boolean i(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f58251g.setVisibility(0);
            this.f58251g.e(eVar);
            return true;
        }
        this.f58251g.setVisibility(8);
        return false;
    }

    public final void j() {
        CoverFlowView<d.b.j0.j3.h.a> coverFlowView = this.f58250f;
        if (coverFlowView == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new C1398c(this));
        this.f58250f.setCallback(new d());
    }

    public final void k() {
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f58245a.getPageContext().getPageActivity());
        aVar.setMessageId(R.string.function_unavailable_tip);
        aVar.setPositiveButton(R.string.confirm, new b(this));
        aVar.create(this.f58245a.getPageContext()).show();
    }

    public void l() {
        this.f58247c.setVisibility(8);
        this.f58250f.setVisibility(8);
        this.f58251g.setVisibility(8);
        String string = this.f58245a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f58245a.setNetRefreshViewTopMargin(this.j);
        this.f58245a.showNetRefreshView(this.f58246b, string, false);
    }

    public void m(List<d.b.j0.j3.h.a> list, e eVar, List<d.b.j0.j3.h.d> list2, boolean z) {
        if ((list != null && list.size() > 0) || ((eVar != null && !StringUtils.isNull(eVar.c())) || (list2 != null && list2.size() > 0))) {
            d();
            h(list2, g(list) || i(eVar));
            return;
        }
        l();
    }
}
