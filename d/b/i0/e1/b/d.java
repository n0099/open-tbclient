package d.b.i0.e1.b;

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
import d.b.i0.e1.b.f.b;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.b.b.a.d<AtMessageActivity> {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.e1.b.a> f54369a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f54370b;

    /* renamed from: c  reason: collision with root package name */
    public View f54371c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f54372d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.r.f0.g f54373e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.g0.g.a f54374f;

    /* renamed from: g  reason: collision with root package name */
    public View f54375g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f54376h;
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
            d.this.f54372d.loadMoreData();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f54379a;

        public c(FeedData feedData) {
            this.f54379a = feedData;
        }

        @Override // d.b.i0.e1.b.f.b.c
        public void a() {
            if (ListUtils.isEmpty(d.this.j)) {
                return;
            }
            d.this.j.remove(this.f54379a);
            if (d.this.f54369a != null) {
                d.this.f54369a.k(d.this.j);
            }
        }
    }

    /* renamed from: d.b.i0.e1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1234d implements Runnable {
        public RunnableC1234d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f54370b.F();
        }
    }

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.f54372d = atMessageActivity;
    }

    public void g(FeedData feedData) {
        if (feedData == null) {
            return;
        }
        d.b.i0.e1.b.f.a aVar = new d.b.i0.e1.b.f.a();
        aVar.f54401a = 2;
        aVar.f54402b = d.b.b.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f54403c = d.b.b.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f54404d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        d.b.i0.e1.b.f.b bVar = new d.b.i0.e1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(feedData));
        bVar.i();
    }

    public void h() {
        BdListView bdListView = this.f54370b;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i) {
        d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.e1.b.a> dVar = this.f54369a;
        if (dVar != null) {
            dVar.onChangeSkinType(tbPageContext, i);
        }
        d.b.h0.g0.g.a aVar = this.f54374f;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i);
        }
        d.b.h0.r.f0.g gVar = this.f54373e;
        if (gVar != null) {
            gVar.I(i);
        }
        this.f54376h.onChangeSkinType(tbPageContext, i);
    }

    public View k() {
        View inflate = this.f54372d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.f54371c = inflate;
        this.f54372d.setContentView(inflate);
        this.f54370b = (BdListView) this.f54371c.findViewById(R.id.atme_lv);
        NavigationBar navigationBar = (NavigationBar) this.f54371c.findViewById(R.id.view_navigation_bar);
        this.f54376h = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54376h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.f54376h.showBottomLine();
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f54372d.getPageContext());
        this.f54373e = gVar;
        gVar.Z(this.f54372d.getUniqueId());
        this.f54373e.b(this.f54372d);
        d.b.h0.g0.g.a aVar = new d.b.h0.g0.g.a(this.f54372d);
        this.f54374f = aVar;
        aVar.a();
        this.f54375g = new TextView(this.f54372d.getPageContext().getPageActivity());
        this.f54375g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.b.b.e.p.l.g(this.f54372d.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.c(this.f54375g, BdListViewHelper.HeadType.DEFAULT, d.b.b.e.p.j.z());
        this.f54370b.setPullRefresh(this.f54373e);
        this.f54370b.x(this.f54375g, 0);
        this.f54370b.setNextPage(this.f54374f);
        this.f54370b.setDividerHeight(0);
        NoNetworkView noNetworkView = (NoNetworkView) this.f54371c.findViewById(R.id.no_networkview);
        this.i = noNetworkView;
        noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.i.a(new a());
        this.f54370b.setExOnSrollToBottomListener(new b());
        d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.e1.b.a> dVar = new d.b.h0.g0.f.d<>(this.f54372d.getPageContext(), d.b.i0.e1.b.a.class, R.layout.mention_atme_item, this.f54372d.getEventCenter());
        this.f54369a = dVar;
        dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f54372d)), NoDataViewFactory.e.d(null, this.f54372d.getResources().getString(R.string.mention_atme_nodata)), null, null);
        this.f54370b.setAdapter((ListAdapter) this.f54369a);
        return this.f54371c;
    }

    public void l(boolean z) {
        BdListView bdListView;
        BdListViewHelper.c(this.f54375g, BdListViewHelper.HeadType.DEFAULT, d.b.b.e.p.j.z());
        if (z && (bdListView = this.f54370b) != null && bdListView.getWrappedAdapter() != null && this.f54370b.getWrappedAdapter().getCount() <= 0) {
            d.b.b.e.m.e.a().post(new RunnableC1234d());
        }
    }

    public void m(d.b.h0.g0.b.a aVar) {
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            this.j = gVar.b();
            d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.e1.b.a> dVar = this.f54369a;
            if (dVar != null) {
                dVar.k(gVar.b());
            }
        }
    }

    public void n(d.b.h0.g0.d.b bVar) {
        if (bVar instanceof d.b.h0.g0.d.a) {
            d.b.h0.g0.d.a aVar = (d.b.h0.g0.d.a) bVar;
            if (this.f54374f != null) {
                if (aVar.d()) {
                    this.f54374f.d();
                    if (aVar.b()) {
                        this.f54374f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f54374f.f(R.string.loading);
                    } else {
                        this.f54374f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f54374f.e();
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
        d.b.h0.r.f0.g gVar = this.f54373e;
        if (gVar != null) {
            gVar.b(null);
        }
        BdListView bdListView = this.f54370b;
        if (bdListView != null) {
            bdListView.F();
        }
        d.b.h0.r.f0.g gVar2 = this.f54373e;
        if (gVar2 != null) {
            gVar2.b(this.f54372d);
        }
    }
}
