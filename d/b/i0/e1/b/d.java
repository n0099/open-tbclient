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
/* loaded from: classes3.dex */
public class d extends d.b.b.a.d<AtMessageActivity> {

    /* renamed from: a  reason: collision with root package name */
    public d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.e1.b.a> f54370a;

    /* renamed from: b  reason: collision with root package name */
    public BdListView f54371b;

    /* renamed from: c  reason: collision with root package name */
    public View f54372c;

    /* renamed from: d  reason: collision with root package name */
    public AtMessageActivity f54373d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.r.f0.g f54374e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.h0.g0.g.a f54375f;

    /* renamed from: g  reason: collision with root package name */
    public View f54376g;

    /* renamed from: h  reason: collision with root package name */
    public NavigationBar f54377h;
    public NoNetworkView i;
    public List<FeedData> j;

    /* loaded from: classes3.dex */
    public class a implements NoNetworkView.b {
        public a() {
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void b(boolean z) {
            d.this.l(z);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BdListView.q {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.q
        public void y(BdListView bdListView) {
            d.this.f54373d.loadMoreData();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements b.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FeedData f54380a;

        public c(FeedData feedData) {
            this.f54380a = feedData;
        }

        @Override // d.b.i0.e1.b.f.b.c
        public void a() {
            if (ListUtils.isEmpty(d.this.j)) {
                return;
            }
            d.this.j.remove(this.f54380a);
            if (d.this.f54370a != null) {
                d.this.f54370a.k(d.this.j);
            }
        }
    }

    /* renamed from: d.b.i0.e1.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1235d implements Runnable {
        public RunnableC1235d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f54371b.F();
        }
    }

    public d(AtMessageActivity atMessageActivity) {
        super(atMessageActivity.getPageContext());
        this.f54373d = atMessageActivity;
    }

    public void g(FeedData feedData) {
        if (feedData == null) {
            return;
        }
        d.b.i0.e1.b.f.a aVar = new d.b.i0.e1.b.f.a();
        aVar.f54402a = 2;
        aVar.f54403b = d.b.b.e.m.b.f(feedData.getThread_id(), 0L);
        aVar.f54404c = d.b.b.e.m.b.f(feedData.getPost_id(), 0L);
        aVar.f54405d = feedData.getBaijiahaoData() != null ? feedData.getBaijiahaoData().oriUgcNid : "";
        d.b.i0.e1.b.f.b bVar = new d.b.i0.e1.b.f.b(getPageContext());
        bVar.g(aVar);
        bVar.h(new c(feedData));
        bVar.i();
    }

    public void h() {
        BdListView bdListView = this.f54371b;
        if (bdListView != null) {
            bdListView.A(0L);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i) {
        d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.e1.b.a> dVar = this.f54370a;
        if (dVar != null) {
            dVar.onChangeSkinType(tbPageContext, i);
        }
        d.b.h0.g0.g.a aVar = this.f54375f;
        if (aVar != null) {
            aVar.onChangeSkinType(tbPageContext, i);
        }
        d.b.h0.r.f0.g gVar = this.f54374e;
        if (gVar != null) {
            gVar.I(i);
        }
        this.f54377h.onChangeSkinType(tbPageContext, i);
    }

    public View k() {
        View inflate = this.f54373d.getActivity().getLayoutInflater().inflate(R.layout.at_me_activity, (ViewGroup) null);
        this.f54372c = inflate;
        this.f54373d.setContentView(inflate);
        this.f54371b = (BdListView) this.f54372c.findViewById(R.id.atme_lv);
        NavigationBar navigationBar = (NavigationBar) this.f54372c.findViewById(R.id.view_navigation_bar);
        this.f54377h = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f54377h.setCenterTextTitle(getPageContext().getString(R.string.at_me));
        this.f54377h.showBottomLine();
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(this.f54373d.getPageContext());
        this.f54374e = gVar;
        gVar.Z(this.f54373d.getUniqueId());
        this.f54374e.b(this.f54373d);
        d.b.h0.g0.g.a aVar = new d.b.h0.g0.g.a(this.f54373d);
        this.f54375f = aVar;
        aVar.a();
        this.f54376g = new TextView(this.f54373d.getPageContext().getPageActivity());
        this.f54376g.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + d.b.b.e.p.l.g(this.f54373d.getPageContext().getPageActivity(), R.dimen.ds88)));
        BdListViewHelper.c(this.f54376g, BdListViewHelper.HeadType.DEFAULT, d.b.b.e.p.j.z());
        this.f54371b.setPullRefresh(this.f54374e);
        this.f54371b.x(this.f54376g, 0);
        this.f54371b.setNextPage(this.f54375f);
        this.f54371b.setDividerHeight(0);
        NoNetworkView noNetworkView = (NoNetworkView) this.f54372c.findViewById(R.id.no_networkview);
        this.i = noNetworkView;
        noNetworkView.c(getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.i.a(new a());
        this.f54371b.setExOnSrollToBottomListener(new b());
        d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.e1.b.a> dVar = new d.b.h0.g0.f.d<>(this.f54373d.getPageContext(), d.b.i0.e1.b.a.class, R.layout.mention_atme_item, this.f54373d.getEventCenter());
        this.f54370a = dVar;
        dVar.j(NoDataViewFactory.d.b(NoDataViewFactory.ImgType.CREATE, EmotionImageUtil.getEmotionTopMargin(this.f54373d)), NoDataViewFactory.e.d(null, this.f54373d.getResources().getString(R.string.mention_atme_nodata)), null, null);
        this.f54371b.setAdapter((ListAdapter) this.f54370a);
        return this.f54372c;
    }

    public void l(boolean z) {
        BdListView bdListView;
        BdListViewHelper.c(this.f54376g, BdListViewHelper.HeadType.DEFAULT, d.b.b.e.p.j.z());
        if (z && (bdListView = this.f54371b) != null && bdListView.getWrappedAdapter() != null && this.f54371b.getWrappedAdapter().getCount() <= 0) {
            d.b.b.e.m.e.a().post(new RunnableC1235d());
        }
    }

    public void m(d.b.h0.g0.b.a aVar) {
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            this.j = gVar.b();
            d.b.h0.g0.f.d<FeedData, d.b.h0.g0.d.b, d.b.i0.e1.b.a> dVar = this.f54370a;
            if (dVar != null) {
                dVar.k(gVar.b());
            }
        }
    }

    public void n(d.b.h0.g0.d.b bVar) {
        if (bVar instanceof d.b.h0.g0.d.a) {
            d.b.h0.g0.d.a aVar = (d.b.h0.g0.d.a) bVar;
            if (this.f54375f != null) {
                if (aVar.d()) {
                    this.f54375f.d();
                    if (aVar.b()) {
                        this.f54375f.f(R.string.loading);
                    } else if (aVar.a()) {
                        this.f54375f.f(R.string.loading);
                    } else {
                        this.f54375f.g(R.string.no_more_msg);
                    }
                } else {
                    this.f54375f.e();
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
        d.b.h0.r.f0.g gVar = this.f54374e;
        if (gVar != null) {
            gVar.b(null);
        }
        BdListView bdListView = this.f54371b;
        if (bdListView != null) {
            bdListView.F();
        }
        d.b.h0.r.f0.g gVar2 = this.f54374e;
        if (gVar2 != null) {
            gVar2.b(this.f54373d);
        }
    }
}
