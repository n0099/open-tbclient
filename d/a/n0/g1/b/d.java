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
    public d.a.m0.g0.f.d<FeedData, d.a.m0.g0.d.b, d.a.n0.g1.b.a> f58695a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f58696b;

    /* renamed from: c  reason: collision with root package name */
    public View f58697c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f58698d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.r.f0.g f58699e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.m0.g0.g.a f58700f;

    /* renamed from: g  reason: collision with root package name */
    public View f58701g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f58702h;

    /* renamed from: i  reason: collision with root package name */
    public NoNetworkView f58703i;
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
        public void g(BdListView bdListView) {
            d.this.f58698d.loadMoreData();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f58706a;

        public c(FeedData feedData) {
            this.f58706a = feedData;
        }

        @Override // d.a.n0.g1.b.f.b.c
        public void a() {
            if (ListUtils.isEmpty(d.this.j)) {
                return;
            }
            d.this.j.remove(this.f58706a);
            if (d.this.f58695a != null) {
                d.this.f58695a.k(d.this.j);
            }
        }
    }

    /* renamed from: d.a.n0.g1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1402d implements Runnable {
        public RunnableC1402d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f58696b.F();
        }
    }

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.f58698d = atMessageActivity;
    }

    public void g(FeedData feedData) {
        if (feedData == null) {
            return;
        }
        d.a.n0.g1.b.f.a aVar = new d.a.n0.g1.b.f.a();
        aVar.f58729a = 2;
        aVar.f58730b = d.a.c.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f58731c = d.a.c.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f58732d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        d.a.n0.g1.b.f.b bVar = new d.a.n0.g1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(feedData));
        bVar.i();
    }

    public void h() {
        BdListView bdListView = this.f58696b;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        d.a.m0.g0.f.d<FeedData, d.a.m0.g0.d.b, d.a.n0.g1.b.a> dVar = this.f58695a;
        if (dVar != null) {
            dVar.onChangeSkinType(tbPageContext, i2);
        }
        d.a.m0.g0.g.a aVar = this.f58700f;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i2);
        }
        d.a.m0.r.f0.g gVar = this.f58699e;
        if (gVar != null) {
            gVar.I(i2);
        }
        this.f58702h.onChangeSkinType(tbPageContext, i2);
    }

    public View k() {
        View inflate = this.f58698d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.f58697c = inflate;
        this.f58698d.setContentView(inflate);
        this.f58696b = (BdListView) this.f58697c.findViewById(R.id.atme_lv);
        NavigationBar navigationBar = (NavigationBar) this.f58697c.findViewById(R.id.view_navigation_bar);
        this.f58702h = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f58702h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.f58702h.showBottomLine();
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(this.f58698d.getPageContext());
        this.f58699e = gVar;
        gVar.Z(this.f58698d.getUniqueId());
        this.f58699e.a(this.f58698d);
        d.a.m0.g0.g.a aVar = new d.a.m0.g0.g.a(this.f58698d);
        this.f58700f = aVar;
        aVar.a();
        this.f58701g = new TextView(this.f58698d.getPageContext().getPageActivity());
        this.f58701g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.a.c.e.p.l.g(this.f58698d.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.c(this.f58701g, BdListViewHelper.HeadType.DEFAULT, d.a.c.e.p.j.z());
        this.f58696b.setPullRefresh(this.f58699e);
        this.f58696b.x(this.f58701g, 0);
        this.f58696b.setNextPage(this.f58700f);
        this.f58696b.setDividerHeight(0);
        NoNetworkView noNetworkView = (NoNetworkView) this.f58697c.findViewById(R.id.no_networkview);
        this.f58703i = noNetworkView;
        noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.f58703i.a(new a());
        this.f58696b.setExOnSrollToBottomListener(new b());
        d.a.m0.g0.f.d<FeedData, d.a.m0.g0.d.b, d.a.n0.g1.b.a> dVar = new d.a.m0.g0.f.d<>(this.f58698d.getPageContext(), d.a.n0.g1.b.a.class, R.layout.mention_atme_item, this.f58698d.getEventCenter());
        this.f58695a = dVar;
        dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f58698d)), NoDataViewFactory.e.d(null, this.f58698d.getResources().getString(R.string.mention_atme_nodata)), null, null);
        this.f58696b.setAdapter((ListAdapter) this.f58695a);
        return this.f58697c;
    }

    public void l(boolean z) {
        BdListView bdListView;
        BdListViewHelper.c(this.f58701g, BdListViewHelper.HeadType.DEFAULT, d.a.c.e.p.j.z());
        if (z && (bdListView = this.f58696b) != null && bdListView.getWrappedAdapter() != null && this.f58696b.getWrappedAdapter().getCount() <= 0) {
            d.a.c.e.m.e.a().post(new RunnableC1402d());
        }
    }

    public void m(d.a.m0.g0.b.a aVar) {
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            this.j = gVar.a();
            d.a.m0.g0.f.d<FeedData, d.a.m0.g0.d.b, d.a.n0.g1.b.a> dVar = this.f58695a;
            if (dVar != null) {
                dVar.k(gVar.a());
            }
        }
    }

    public void n(d.a.m0.g0.d.b bVar) {
        if (bVar instanceof d.a.m0.g0.d.a) {
            d.a.m0.g0.d.a aVar = (d.a.m0.g0.d.a) bVar;
            if (this.f58700f != null) {
                if (aVar.d()) {
                    this.f58700f.d();
                    if (aVar.b()) {
                        this.f58700f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f58700f.f(R.string.loading);
                    } else {
                        this.f58700f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f58700f.e();
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
        d.a.m0.r.f0.g gVar = this.f58699e;
        if (gVar != null) {
            gVar.a(null);
        }
        BdListView bdListView = this.f58696b;
        if (bdListView != null) {
            bdListView.F();
        }
        d.a.m0.r.f0.g gVar2 = this.f58699e;
        if (gVar2 != null) {
            gVar2.a(this.f58698d);
        }
    }
}
