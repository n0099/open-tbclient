package d.b.i0.j3.h;

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
import d.b.h0.r.s.a;
import java.util.List;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public DressupCenterActivity f57824a;

    /* renamed from: b  reason: collision with root package name */
    public View f57825b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f57826c;

    /* renamed from: d  reason: collision with root package name */
    public NavigationBar f57827d;

    /* renamed from: e  reason: collision with root package name */
    public NoNetworkView f57828e;

    /* renamed from: f  reason: collision with root package name */
    public CoverFlowView<d.b.i0.j3.h.a> f57829f;

    /* renamed from: g  reason: collision with root package name */
    public MemberRecommendView f57830g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57831h;
    public d.b.i0.j3.h.b i;
    public int j;

    /* loaded from: classes5.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            d.b.i0.j3.h.d item = c.this.i.getItem(i);
            if (item == null) {
                return;
            }
            d.b.h0.r.d0.b j2 = d.b.h0.r.d0.b.j();
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
                customMessage = new CustomMessage(2002001, new PersonalBackdropGroupActivityConfig(c.this.f57824a.getActivity()));
            } else if (d2 == 3) {
                customMessage = new CustomMessage(2002001, new BubbleGroupActivityConfig(c.this.f57824a.getActivity()));
            } else if (d2 == 4) {
                customMessage = new CustomMessage(2002001, new PersonalCardCategoryActivityConfig(c.this.f57824a.getPageContext().getPageActivity()));
            } else if (d2 != 5) {
                UrlManager.getInstance().dealOneLink(c.this.f57824a.getPageContext(), new String[]{c2});
            } else {
                TiebaStatic.log("c11611");
                customMessage = new CustomMessage(2002001, new AvatarPendantActivityConfig(c.this.f57824a.getActivity()));
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

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* renamed from: d.b.i0.j3.h.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1375c implements d.b.h0.r.w.a {
        public C1375c(c cVar) {
        }

        @Override // d.b.h0.r.w.a
        public d.b.h0.r.w.b.c a() {
            d.b.h0.r.w.b.c cVar = new d.b.h0.r.w.b.c();
            cVar.c(R.drawable.icon_diandian_white_n);
            cVar.g(R.drawable.icon_diandian_white_s);
            cVar.h(R.dimen.ds1);
            cVar.d(85);
            cVar.f(R.dimen.ds30);
            cVar.e(R.dimen.ds20);
            return cVar;
        }

        @Override // d.b.h0.r.w.a
        public View b() {
            return null;
        }

        @Override // d.b.h0.r.w.a
        public TbImageView c(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setGifIconSupport(false);
            return tbImageView;
        }

        @Override // d.b.h0.r.w.a
        public d.b.h0.r.w.b.e d() {
            d.b.h0.r.w.b.e eVar = new d.b.h0.r.w.b.e();
            eVar.a(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds280));
            return eVar;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements d.b.h0.r.w.b.d<d.b.i0.j3.h.a> {
        public d() {
        }

        @Override // d.b.h0.r.w.b.d
        public void b(int i, String str) {
            TiebaStatic.log("c10262");
            UrlManager.getInstance().dealOneLink(c.this.f57824a.getPageContext(), new String[]{str});
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.r.w.b.d
        /* renamed from: c */
        public void a(int i, d.b.i0.j3.h.a aVar) {
        }
    }

    public c(DressupCenterActivity dressupCenterActivity) {
        this.j = 0;
        this.f57824a = dressupCenterActivity;
        this.j = l.g(dressupCenterActivity.getPageContext().getPageActivity(), R.dimen.ds120);
        View inflate = LayoutInflater.from(this.f57824a.getPageContext().getPageActivity()).inflate(R.layout.dressup_center_activity_layout, (ViewGroup) null);
        this.f57825b = inflate;
        this.f57824a.setContentView(inflate);
        NavigationBar navigationBar = (NavigationBar) this.f57825b.findViewById(R.id.view_navigation_bar);
        this.f57827d = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f57827d.setCenterTextTitle(this.f57824a.getPageContext().getString(R.string.dressup_center_title));
        this.f57828e = (NoNetworkView) this.f57825b.findViewById(R.id.view_no_network);
        this.f57826c = (BdListView) this.f57825b.findViewById(R.id.dress_listview);
        this.f57829f = (CoverFlowView) this.f57825b.findViewById(R.id.dressup_center_coverflowview);
        j();
        MemberRecommendView memberRecommendView = (MemberRecommendView) this.f57825b.findViewById(R.id.dressup_center_recommend);
        this.f57830g = memberRecommendView;
        memberRecommendView.setFromType(1);
        this.i = new d.b.i0.j3.h.b(this.f57824a.getPageContext());
        TextView textView = new TextView(this.f57824a.getActivity());
        this.f57831h = textView;
        textView.setHeight(l.g(this.f57824a.getActivity(), R.dimen.ds30));
        this.f57826c.setAdapter((ListAdapter) this.i);
        this.f57826c.setOnItemClickListener(new a());
    }

    public void d() {
        this.f57824a.hideNetRefreshView(this.f57825b);
        this.f57826c.setVisibility(0);
        this.f57830g.setVisibility(0);
        this.f57829f.setVisibility(0);
    }

    public View e() {
        return this.f57825b;
    }

    @SuppressLint({"ResourceAsColor"})
    public void f() {
        d.b.i0.j3.h.b bVar;
        this.f57824a.getLayoutMode().k(TbadkApplication.getInst().getSkinType() == 1);
        this.f57824a.getLayoutMode().j(this.f57825b);
        NavigationBar navigationBar = this.f57827d;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f57824a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        NoNetworkView noNetworkView = this.f57828e;
        if (noNetworkView != null) {
            noNetworkView.c(this.f57824a.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        CoverFlowView<d.b.i0.j3.h.a> coverFlowView = this.f57829f;
        if (coverFlowView != null && coverFlowView.getVisibility() == 0) {
            this.f57829f.s();
        }
        BdListView bdListView = this.f57826c;
        if (bdListView != null && bdListView.getVisibility() == 0 && (bVar = this.i) != null) {
            bVar.notifyDataSetChanged();
        }
        MemberRecommendView memberRecommendView = this.f57830g;
        if (memberRecommendView != null && memberRecommendView.getVisibility() == 0) {
            this.f57830g.d();
        }
        SkinManager.setBackgroundColor(this.f57831h, R.color.CAM_X0204);
    }

    public final boolean g(List<d.b.i0.j3.h.a> list) {
        if (list != null && list.size() > 0) {
            this.f57829f.setVisibility(0);
            this.f57829f.setData(list);
            return true;
        }
        this.f57829f.setVisibility(8);
        return false;
    }

    public final void h(List<d.b.i0.j3.h.d> list, boolean z) {
        if (list != null && list.size() > 0) {
            if (z) {
                this.f57826c.removeHeaderView(this.f57831h);
                this.f57826c.addHeaderView(this.f57831h);
            } else {
                this.f57826c.removeHeaderView(this.f57831h);
            }
            this.f57826c.setVisibility(0);
            this.i.b(list);
            this.i.notifyDataSetChanged();
            return;
        }
        this.f57826c.setVisibility(8);
    }

    public final boolean i(e eVar) {
        if (eVar != null && !StringUtils.isNull(eVar.c())) {
            this.f57830g.setVisibility(0);
            this.f57830g.e(eVar);
            return true;
        }
        this.f57830g.setVisibility(8);
        return false;
    }

    public final void j() {
        CoverFlowView<d.b.i0.j3.h.a> coverFlowView = this.f57829f;
        if (coverFlowView == null) {
            return;
        }
        coverFlowView.setCoverFlowFactory(new C1375c(this));
        this.f57829f.setCallback(new d());
    }

    public final void k() {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f57824a.getPageContext().getPageActivity());
        aVar.setMessageId(R.string.function_unavailable_tip);
        aVar.setPositiveButton(R.string.confirm, new b(this));
        aVar.create(this.f57824a.getPageContext()).show();
    }

    public void l() {
        this.f57826c.setVisibility(8);
        this.f57829f.setVisibility(8);
        this.f57830g.setVisibility(8);
        String string = this.f57824a.getPageContext().getResources().getString(R.string.no_data_text);
        this.f57824a.setNetRefreshViewTopMargin(this.j);
        this.f57824a.showNetRefreshView(this.f57825b, string, false);
    }

    public void m(List<d.b.i0.j3.h.a> list, e eVar, List<d.b.i0.j3.h.d> list2, boolean z) {
        if ((list != null && list.size() > 0) || ((eVar != null && !StringUtils.isNull(eVar.c())) || (list2 != null && list2.size() > 0))) {
            d();
            h(list2, g(list) || i(eVar));
            return;
        }
        l();
    }
}
