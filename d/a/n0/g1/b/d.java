package d.a.n0.g1.b;

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
import d.a.n0.g1.b.f.b;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends d.a.c.a.d<AtMessageActivity> {

    /* renamed from: a  reason: collision with root package name */
    public d.a.m0.g0.f.d<FeedData, d.a.m0.g0.d.b, d.a.n0.g1.b.a> f55006a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f55007b;

    /* renamed from: c  reason: collision with root package name */
    public View f55008c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f55009d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.r.f0.g f55010e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.g0.g.a f55011f;

    /* renamed from: g  reason: collision with root package name */
    public View f55012g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f55013h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f55014i;
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
            d.this.f55009d.loadMoreData();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f55017a;

        public c(FeedData feedData) {
            this.f55017a = feedData;
        }

        @Override // d.a.n0.g1.b.f.b.c
        public void a() {
            if (ListUtils.isEmpty(d.this.j)) {
                return;
            }
            d.this.j.remove(this.f55017a);
            if (d.this.f55006a != null) {
                d.this.f55006a.k(d.this.j);
            }
        }
    }

    /* renamed from: d.a.n0.g1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1346d implements Runnable {
        public RunnableC1346d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f55007b.F();
        }
    }

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.f55009d = atMessageActivity;
    }

    public void g(FeedData feedData) {
        if (feedData == null) {
            return;
        }
        d.a.n0.g1.b.f.a aVar = new d.a.n0.g1.b.f.a();
        aVar.f55040a = 2;
        aVar.f55041b = d.a.c.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f55042c = d.a.c.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f55043d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        d.a.n0.g1.b.f.b bVar = new d.a.n0.g1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(feedData));
        bVar.i();
    }

    public void h() {
        BdListView bdListView = this.f55007b;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void j(TbPageContext<?> tbPageContext, int i2) {
        d.a.m0.g0.f.d<FeedData, d.a.m0.g0.d.b, d.a.n0.g1.b.a> dVar = this.f55006a;
        if (dVar != null) {
            dVar.onChangeSkinType(tbPageContext, i2);
        }
        d.a.m0.g0.g.a aVar = this.f55011f;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i2);
        }
        d.a.m0.r.f0.g gVar = this.f55010e;
        if (gVar != null) {
            gVar.I(i2);
        }
        this.f55013h.onChangeSkinType(tbPageContext, i2);
    }

    public View k() {
        View inflate = this.f55009d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.f55008c = inflate;
        this.f55009d.setContentView(inflate);
        this.f55007b = (BdListView) this.f55008c.findViewById(R.id.atme_lv);
        NavigationBar navigationBar = (NavigationBar) this.f55008c.findViewById(R.id.view_navigation_bar);
        this.f55013h = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f55013h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.f55013h.showBottomLine();
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(this.f55009d.getPageContext());
        this.f55010e = gVar;
        gVar.Z(this.f55009d.getUniqueId());
        this.f55010e.a(this.f55009d);
        d.a.m0.g0.g.a aVar = new d.a.m0.g0.g.a(this.f55009d);
        this.f55011f = aVar;
        aVar.a();
        this.f55012g = new TextView(this.f55009d.getPageContext().getPageActivity());
        this.f55012g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.a.c.e.p.l.g(this.f55009d.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.c(this.f55012g, BdListViewHelper.HeadType.DEFAULT, d.a.c.e.p.j.z());
        this.f55007b.setPullRefresh(this.f55010e);
        this.f55007b.x(this.f55012g, 0);
        this.f55007b.setNextPage(this.f55011f);
        this.f55007b.setDividerHeight(0);
        NoNetworkView noNetworkView = (NoNetworkView) this.f55008c.findViewById(R.id.no_networkview);
        this.f55014i = noNetworkView;
        noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.f55014i.a(new a());
        this.f55007b.setExOnSrollToBottomListener(new b());
        d.a.m0.g0.f.d<FeedData, d.a.m0.g0.d.b, d.a.n0.g1.b.a> dVar = new d.a.m0.g0.f.d<>(this.f55009d.getPageContext(), d.a.n0.g1.b.a.class, R.layout.mention_atme_item, this.f55009d.getEventCenter());
        this.f55006a = dVar;
        dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f55009d)), NoDataViewFactory.e.d(null, this.f55009d.getResources().getString(R.string.mention_atme_nodata)), null, null);
        this.f55007b.setAdapter((ListAdapter) this.f55006a);
        return this.f55008c;
    }

    public void l(boolean z) {
        BdListView bdListView;
        BdListViewHelper.c(this.f55012g, BdListViewHelper.HeadType.DEFAULT, d.a.c.e.p.j.z());
        if (z && (bdListView = this.f55007b) != null && bdListView.getWrappedAdapter() != null && this.f55007b.getWrappedAdapter().getCount() <= 0) {
            d.a.c.e.m.e.a().post(new RunnableC1346d());
        }
    }

    public void m(d.a.m0.g0.b.a aVar) {
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            this.j = gVar.a();
            d.a.m0.g0.f.d<FeedData, d.a.m0.g0.d.b, d.a.n0.g1.b.a> dVar = this.f55006a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void n(d.a.m0.g0.d.b bVar) {
        if (bVar instanceof d.a.m0.g0.d.a) {
            d.a.m0.g0.d.a aVar = (d.a.m0.g0.d.a) bVar;
            if (this.f55011f != null) {
                if (aVar.d()) {
                    this.f55011f.d();
                    if (aVar.b()) {
                        this.f55011f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f55011f.f(R.string.loading);
                    } else {
                        this.f55011f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f55011f.e();
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
        d.a.m0.r.f0.g gVar = this.f55010e;
        if (gVar != null) {
            gVar.a(null);
        }
        BdListView bdListView = this.f55007b;
        if (bdListView != null) {
            bdListView.F();
        }
        d.a.m0.r.f0.g gVar2 = this.f55010e;
        if (gVar2 != null) {
            gVar2.a(this.f55009d);
        }
    }
}
