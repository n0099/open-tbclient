package d.b.i0.f1.b;

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
import d.b.i0.f1.b.f.b;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.b.c.a.d<AtMessageActivity> {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.f1.b.a> f55811a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f55812b;

    /* renamed from: c  reason: collision with root package name */
    public View f55813c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f55814d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.r.f0.g f55815e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.g0.g.a f55816f;

    /* renamed from: g  reason: collision with root package name */
    public View f55817g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f55818h;
    public NoNetworkView i;
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
        public void y(BdListView bdListView) {
            d.this.f55814d.loadMoreData();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f55821a;

        public c(FeedData feedData) {
            this.f55821a = feedData;
        }

        @Override // d.b.i0.f1.b.f.b.c
        public void a() {
            if (ListUtils.isEmpty(d.this.j)) {
                return;
            }
            d.this.j.remove(this.f55821a);
            if (d.this.f55811a != null) {
                d.this.f55811a.k(d.this.j);
            }
        }
    }

    /* renamed from: d.b.i0.f1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1294d implements Runnable {
        public RunnableC1294d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f55812b.F();
        }
    }

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.f55814d = atMessageActivity;
    }

    public void g(FeedData feedData) {
        if (feedData == null) {
            return;
        }
        d.b.i0.f1.b.f.a aVar = new d.b.i0.f1.b.f.a();
        aVar.f55843a = 2;
        aVar.f55844b = d.b.c.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f55845c = d.b.c.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f55846d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        d.b.i0.f1.b.f.b bVar = new d.b.i0.f1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(feedData));
        bVar.i();
    }

    public void h() {
        BdListView bdListView = this.f55812b;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i) {
        d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.f1.b.a> dVar = this.f55811a;
        if (dVar != null) {
            dVar.onChangeSkinType(tbPageContext, i);
        }
        d.b.h0.g0.g.a aVar = this.f55816f;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i);
        }
        d.b.h0.r.f0.g gVar = this.f55815e;
        if (gVar != null) {
            gVar.I(i);
        }
        this.f55818h.onChangeSkinType(tbPageContext, i);
    }

    public View k() {
        View inflate = this.f55814d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.f55813c = inflate;
        this.f55814d.setContentView(inflate);
        this.f55812b = (BdListView) this.f55813c.findViewById(R.id.atme_lv);
        NavigationBar navigationBar = (NavigationBar) this.f55813c.findViewById(R.id.view_navigation_bar);
        this.f55818h = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f55818h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.f55818h.showBottomLine();
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f55814d.getPageContext());
        this.f55815e = gVar;
        gVar.Z(this.f55814d.getUniqueId());
        this.f55815e.b(this.f55814d);
        d.b.h0.g0.g.a aVar = new d.b.h0.g0.g.a(this.f55814d);
        this.f55816f = aVar;
        aVar.a();
        this.f55817g = new TextView(this.f55814d.getPageContext().getPageActivity());
        this.f55817g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.b.c.e.p.l.g(this.f55814d.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.c(this.f55817g, BdListViewHelper.HeadType.DEFAULT, d.b.c.e.p.j.z());
        this.f55812b.setPullRefresh(this.f55815e);
        this.f55812b.x(this.f55817g, 0);
        this.f55812b.setNextPage(this.f55816f);
        this.f55812b.setDividerHeight(0);
        NoNetworkView noNetworkView = (NoNetworkView) this.f55813c.findViewById(R.id.no_networkview);
        this.i = noNetworkView;
        noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.i.a(new a());
        this.f55812b.setExOnSrollToBottomListener(new b());
        d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.f1.b.a> dVar = new d.b.h0.g0.f.d<>(this.f55814d.getPageContext(), d.b.i0.f1.b.a.class, R.layout.mention_atme_item, this.f55814d.getEventCenter());
        this.f55811a = dVar;
        dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f55814d)), NoDataViewFactory.e.d(null, this.f55814d.getResources().getString(R.string.mention_atme_nodata)), null, null);
        this.f55812b.setAdapter((ListAdapter) this.f55811a);
        return this.f55813c;
    }

    public void l(boolean z) {
        BdListView bdListView;
        BdListViewHelper.c(this.f55817g, BdListViewHelper.HeadType.DEFAULT, d.b.c.e.p.j.z());
        if (z && (bdListView = this.f55812b) != null && bdListView.getWrappedAdapter() != null && this.f55812b.getWrappedAdapter().getCount() <= 0) {
            d.b.c.e.m.e.a().post(new RunnableC1294d());
        }
    }

    public void m(d.b.h0.g0.b.a aVar) {
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            this.j = gVar.b();
            d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.f1.b.a> dVar = this.f55811a;
            if (dVar != null) {
                dVar.k(gVar.b());
            }
        }
    }

    public void n(d.b.h0.g0.d.b bVar) {
        if (bVar instanceof d.b.h0.g0.d.a) {
            d.b.h0.g0.d.a aVar = (d.b.h0.g0.d.a) bVar;
            if (this.f55816f != null) {
                if (aVar.d()) {
                    this.f55816f.d();
                    if (aVar.b()) {
                        this.f55816f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f55816f.f(R.string.loading);
                    } else {
                        this.f55816f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f55816f.e();
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
        d.b.h0.r.f0.g gVar = this.f55815e;
        if (gVar != null) {
            gVar.b(null);
        }
        BdListView bdListView = this.f55812b;
        if (bdListView != null) {
            bdListView.F();
        }
        d.b.h0.r.f0.g gVar2 = this.f55815e;
        if (gVar2 != null) {
            gVar2.b(this.f55814d);
        }
    }
}
