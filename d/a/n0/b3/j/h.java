package d.a.n0.b3.j;

import android.view.View;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareActivity;
import d.a.c.e.p.l;
import d.a.m0.r.f0.f;
/* loaded from: classes5.dex */
public class h extends d.a.c.a.d<Object> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<Object> f52249a;

    /* renamed from: b  reason: collision with root package name */
    public View f52250b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f52251c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f52252d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.r.f0.g f52253e;

    /* renamed from: f  reason: collision with root package name */
    public e f52254f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f52255g;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.f52253e.Z(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        this.f52252d.a(bVar);
    }

    public void e() {
        this.f52251c.A(0L);
    }

    public void f() {
        this.f52252d.setVisibility(0);
    }

    public void g(boolean z, String str) {
        e();
        if (z || str == null) {
            return;
        }
        this.f52249a.showToast(str, true);
    }

    public View h() {
        return this.f52250b;
    }

    public void j() {
        NoDataView noDataView = this.f52255g;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.f52251c.removeHeaderView(this.f52255g);
        }
    }

    public void k() {
        this.f52252d.setVisibility(8);
    }

    public void l(f fVar) {
        if (fVar != null) {
            try {
                if (fVar.g()) {
                    return;
                }
                this.f52254f.i(fVar);
                this.f52254f.notifyDataSetChanged();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void m(NoNetworkView.b bVar) {
        this.f52252d.d(bVar);
    }

    public void n(f.g gVar) {
        this.f52253e.a(gVar);
    }

    public void o(int i2) {
        if (this.f52255g == null) {
            this.f52255g = NoDataViewFactory.a(this.f52249a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i2), null);
        }
        this.f52255g.setTextOption(NoDataViewFactory.e.a(i2));
        this.f52255g.f(this.f52249a, TbadkCoreApplication.getInst().getSkinType());
        this.f52255g.setVisibility(0);
        this.f52251c.removeHeaderView(this.f52255g);
        this.f52251c.addHeaderView(this.f52255g);
    }

    public void onChangeSkinType(int i2) {
        this.f52249a.getLayoutMode().k(i2 == 1);
        this.f52249a.getLayoutMode().j(this.f52250b);
        this.f52254f.h(i2);
        this.f52253e.I(i2);
        this.f52252d.c(this.mContext, i2);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.f52249a = null;
        this.f52251c = null;
        this.f52253e = null;
        this.f52254f = null;
        this.f52249a = tbPageContext;
        this.f52250b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f52251c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f52249a.getOrignalPage() instanceof SquareActivity) {
            this.f52251c.setOnItemClickListener((SquareActivity) this.f52249a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f52254f = eVar;
        this.f52251c.setAdapter((ListAdapter) eVar);
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(tbPageContext);
        this.f52253e = gVar;
        this.f52251c.setPullRefresh(gVar);
        this.f52252d = (NoNetworkView) this.f52250b.findViewById(R.id.view_no_network);
    }
}
