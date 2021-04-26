package d.a.j0.f1.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionImageUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.AtMessageActivity;
import com.baidu.tieba.imMessageCenter.mention.FeedData;
import d.a.j0.f1.b.f.b;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.c.a.d<AtMessageActivity> {

    /* renamed from: a  reason: collision with root package name */
    public d.a.i0.g0.f.d<FeedData, d.a.i0.g0.d.b, d.a.j0.f1.b.a> f54111a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f54112b;

    /* renamed from: c  reason: collision with root package name */
    public View f54113c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f54114d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.r.f0.g f54115e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.i0.g0.g.a f54116f;

    /* renamed from: g  reason: collision with root package name */
    public View f54117g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f54118h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f54119i;
    public List<FeedData> j;

    /* loaded from: classes4.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            d.this.l(z);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements BdListView.q {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void q(BdListView bdListView) {
            d.this.f54114d.loadMoreData();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f54122a;

        public c(FeedData feedData) {
            this.f54122a = feedData;
        }

        @Override // d.a.j0.f1.b.f.b.c
        public void a() {
            if (ListUtils.isEmpty(d.this.j)) {
                return;
            }
            d.this.j.remove(this.f54122a);
            if (d.this.f54111a != null) {
                d.this.f54111a.k(d.this.j);
            }
        }
    }

    /* renamed from: d.a.j0.f1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1256d implements Runnable {
        public RunnableC1256d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f54112b.F();
        }
    }

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.f54114d = atMessageActivity;
    }

    public void g(FeedData feedData) {
        if (feedData == null) {
            return;
        }
        d.a.j0.f1.b.f.a aVar = new d.a.j0.f1.b.f.a();
        aVar.f54145a = 2;
        aVar.f54146b = d.a.c.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f54147c = d.a.c.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f54148d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        d.a.j0.f1.b.f.b bVar = new d.a.j0.f1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(feedData));
        bVar.i();
    }

    public void h() {
        BdListView bdListView = this.f54112b;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void j(TbPageContext<?> tbPageContext, int i2) {
        d.a.i0.g0.f.d<FeedData, d.a.i0.g0.d.b, d.a.j0.f1.b.a> dVar = this.f54111a;
        if (dVar != null) {
            dVar.onChangeSkinType(tbPageContext, i2);
        }
        d.a.i0.g0.g.a aVar = this.f54116f;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i2);
        }
        d.a.i0.r.f0.g gVar = this.f54115e;
        if (gVar != null) {
            gVar.I(i2);
        }
        this.f54118h.onChangeSkinType(tbPageContext, i2);
    }

    public View k() {
        View inflate = this.f54114d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.f54113c = inflate;
        this.f54114d.setContentView(inflate);
        this.f54112b = (BdListView) this.f54113c.findViewById(R.id.atme_lv);
        NavigationBar navigationBar = (NavigationBar) this.f54113c.findViewById(R.id.view_navigation_bar);
        this.f54118h = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54118h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.f54118h.showBottomLine();
        d.a.i0.r.f0.g gVar = new d.a.i0.r.f0.g(this.f54114d.getPageContext());
        this.f54115e = gVar;
        gVar.Z(this.f54114d.getUniqueId());
        this.f54115e.a(this.f54114d);
        d.a.i0.g0.g.a aVar = new d.a.i0.g0.g.a(this.f54114d);
        this.f54116f = aVar;
        aVar.a();
        this.f54117g = new TextView(this.f54114d.getPageContext().getPageActivity());
        this.f54117g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.a.c.e.p.l.g(this.f54114d.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.c(this.f54117g, BdListViewHelper.HeadType.DEFAULT, d.a.c.e.p.j.z());
        this.f54112b.setPullRefresh(this.f54115e);
        this.f54112b.x(this.f54117g, 0);
        this.f54112b.setNextPage(this.f54116f);
        this.f54112b.setDividerHeight(0);
        NoNetworkView noNetworkView = (NoNetworkView) this.f54113c.findViewById(R.id.no_networkview);
        this.f54119i = noNetworkView;
        noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.f54119i.a(new a());
        this.f54112b.setExOnSrollToBottomListener(new b());
        d.a.i0.g0.f.d<FeedData, d.a.i0.g0.d.b, d.a.j0.f1.b.a> dVar = new d.a.i0.g0.f.d<>(this.f54114d.getPageContext(), d.a.j0.f1.b.a.class, R.layout.mention_atme_item, this.f54114d.getEventCenter());
        this.f54111a = dVar;
        dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f54114d)), NoDataViewFactory.e.d(null, this.f54114d.getResources().getString(R.string.mention_atme_nodata)), null, null);
        this.f54112b.setAdapter((ListAdapter) this.f54111a);
        return this.f54113c;
    }

    public void l(boolean z) {
        BdListView bdListView;
        BdListViewHelper.c(this.f54117g, BdListViewHelper.HeadType.DEFAULT, d.a.c.e.p.j.z());
        if (z && (bdListView = this.f54112b) != null && bdListView.getWrappedAdapter() != null && this.f54112b.getWrappedAdapter().getCount() <= 0) {
            d.a.c.e.m.e.a().post(new RunnableC1256d());
        }
    }

    public void m(d.a.i0.g0.b.a aVar) {
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            this.j = gVar.a();
            d.a.i0.g0.f.d<FeedData, d.a.i0.g0.d.b, d.a.j0.f1.b.a> dVar = this.f54111a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void n(d.a.i0.g0.d.b bVar) {
        if (bVar instanceof d.a.i0.g0.d.a) {
            d.a.i0.g0.d.a aVar = (d.a.i0.g0.d.a) bVar;
            if (this.f54116f != null) {
                if (aVar.d()) {
                    this.f54116f.d();
                    if (aVar.b()) {
                        this.f54116f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f54116f.f(R.string.loading);
                    } else {
                        this.f54116f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f54116f.e();
                }
            }
            if (aVar.c()) {
                o();
            } else {
                h();
            }
        }
    }

    public void o() {
        d.a.i0.r.f0.g gVar = this.f54115e;
        if (gVar != null) {
            gVar.a(null);
        }
        BdListView bdListView = this.f54112b;
        if (bdListView != null) {
            bdListView.F();
        }
        d.a.i0.r.f0.g gVar2 = this.f54115e;
        if (gVar2 != null) {
            gVar2.a(this.f54114d);
        }
    }
}
