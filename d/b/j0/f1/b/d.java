package d.b.j0.f1.b;

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
import d.b.j0.f1.b.f.b;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.b.c.a.d<AtMessageActivity> {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.g0.f.d<FeedData, d.b.i0.g0.d.b, d.b.j0.f1.b.a> f56232a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f56233b;

    /* renamed from: c  reason: collision with root package name */
    public View f56234c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f56235d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.r.f0.g f56236e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.i0.g0.g.a f56237f;

    /* renamed from: g  reason: collision with root package name */
    public View f56238g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f56239h;
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
            d.this.f56235d.loadMoreData();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f56242a;

        public c(FeedData feedData) {
            this.f56242a = feedData;
        }

        @Override // d.b.j0.f1.b.f.b.c
        public void a() {
            if (ListUtils.isEmpty(d.this.j)) {
                return;
            }
            d.this.j.remove(this.f56242a);
            if (d.this.f56232a != null) {
                d.this.f56232a.k(d.this.j);
            }
        }
    }

    /* renamed from: d.b.j0.f1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1317d implements Runnable {
        public RunnableC1317d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f56233b.F();
        }
    }

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.f56235d = atMessageActivity;
    }

    public void g(FeedData feedData) {
        if (feedData == null) {
            return;
        }
        d.b.j0.f1.b.f.a aVar = new d.b.j0.f1.b.f.a();
        aVar.f56264a = 2;
        aVar.f56265b = d.b.c.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f56266c = d.b.c.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f56267d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        d.b.j0.f1.b.f.b bVar = new d.b.j0.f1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(feedData));
        bVar.i();
    }

    public void h() {
        BdListView bdListView = this.f56233b;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i) {
        d.b.i0.g0.f.d<FeedData, d.b.i0.g0.d.b, d.b.j0.f1.b.a> dVar = this.f56232a;
        if (dVar != null) {
            dVar.onChangeSkinType(tbPageContext, i);
        }
        d.b.i0.g0.g.a aVar = this.f56237f;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i);
        }
        d.b.i0.r.f0.g gVar = this.f56236e;
        if (gVar != null) {
            gVar.I(i);
        }
        this.f56239h.onChangeSkinType(tbPageContext, i);
    }

    public View k() {
        View inflate = this.f56235d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.f56234c = inflate;
        this.f56235d.setContentView(inflate);
        this.f56233b = (BdListView) this.f56234c.findViewById(R.id.atme_lv);
        NavigationBar navigationBar = (NavigationBar) this.f56234c.findViewById(R.id.view_navigation_bar);
        this.f56239h = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56239h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.f56239h.showBottomLine();
        d.b.i0.r.f0.g gVar = new d.b.i0.r.f0.g(this.f56235d.getPageContext());
        this.f56236e = gVar;
        gVar.Z(this.f56235d.getUniqueId());
        this.f56236e.b(this.f56235d);
        d.b.i0.g0.g.a aVar = new d.b.i0.g0.g.a(this.f56235d);
        this.f56237f = aVar;
        aVar.a();
        this.f56238g = new TextView(this.f56235d.getPageContext().getPageActivity());
        this.f56238g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.b.c.e.p.l.g(this.f56235d.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.c(this.f56238g, BdListViewHelper.HeadType.DEFAULT, d.b.c.e.p.j.z());
        this.f56233b.setPullRefresh(this.f56236e);
        this.f56233b.x(this.f56238g, 0);
        this.f56233b.setNextPage(this.f56237f);
        this.f56233b.setDividerHeight(0);
        NoNetworkView noNetworkView = (NoNetworkView) this.f56234c.findViewById(R.id.no_networkview);
        this.i = noNetworkView;
        noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.i.a(new a());
        this.f56233b.setExOnSrollToBottomListener(new b());
        d.b.i0.g0.f.d<FeedData, d.b.i0.g0.d.b, d.b.j0.f1.b.a> dVar = new d.b.i0.g0.f.d<>(this.f56235d.getPageContext(), d.b.j0.f1.b.a.class, R.layout.mention_atme_item, this.f56235d.getEventCenter());
        this.f56232a = dVar;
        dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f56235d)), NoDataViewFactory.e.d(null, this.f56235d.getResources().getString(R.string.mention_atme_nodata)), null, null);
        this.f56233b.setAdapter((ListAdapter) this.f56232a);
        return this.f56234c;
    }

    public void l(boolean z) {
        BdListView bdListView;
        BdListViewHelper.c(this.f56238g, BdListViewHelper.HeadType.DEFAULT, d.b.c.e.p.j.z());
        if (z && (bdListView = this.f56233b) != null && bdListView.getWrappedAdapter() != null && this.f56233b.getWrappedAdapter().getCount() <= 0) {
            d.b.c.e.m.e.a().post(new RunnableC1317d());
        }
    }

    public void m(d.b.i0.g0.b.a aVar) {
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            this.j = gVar.b();
            d.b.i0.g0.f.d<FeedData, d.b.i0.g0.d.b, d.b.j0.f1.b.a> dVar = this.f56232a;
            if (dVar != null) {
                dVar.k(gVar.b());
            }
        }
    }

    public void n(d.b.i0.g0.d.b bVar) {
        if (bVar instanceof d.b.i0.g0.d.a) {
            d.b.i0.g0.d.a aVar = (d.b.i0.g0.d.a) bVar;
            if (this.f56237f != null) {
                if (aVar.d()) {
                    this.f56237f.d();
                    if (aVar.b()) {
                        this.f56237f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f56237f.f(R.string.loading);
                    } else {
                        this.f56237f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f56237f.e();
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
        d.b.i0.r.f0.g gVar = this.f56236e;
        if (gVar != null) {
            gVar.b(null);
        }
        BdListView bdListView = this.f56233b;
        if (bdListView != null) {
            bdListView.F();
        }
        d.b.i0.r.f0.g gVar2 = this.f56236e;
        if (gVar2 != null) {
            gVar2.b(this.f56235d);
        }
    }
}
