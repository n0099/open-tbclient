package d.b.i0.a3.j;

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
import d.b.c.e.p.l;
import d.b.h0.r.f0.f;
/* loaded from: classes4.dex */
public class h extends d.b.c.a.d<Object> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<Object> f53222a;

    /* renamed from: b  reason: collision with root package name */
    public View f53223b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f53224c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f53225d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.r.f0.g f53226e;

    /* renamed from: f  reason: collision with root package name */
    public e f53227f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f53228g;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.f53226e.Z(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        this.f53225d.a(bVar);
    }

    public void e() {
        this.f53224c.A(0L);
    }

    public void f() {
        this.f53225d.setVisibility(0);
    }

    public void g(boolean z, String str) {
        e();
        if (z || str == null) {
            return;
        }
        this.f53222a.showToast(str, true);
    }

    public View h() {
        return this.f53223b;
    }

    public void i() {
        NoDataView noDataView = this.f53228g;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.f53224c.removeHeaderView(this.f53228g);
        }
    }

    public void k() {
        this.f53225d.setVisibility(8);
    }

    public void l(f fVar) {
        if (fVar != null) {
            try {
                if (fVar.g()) {
                    return;
                }
                this.f53227f.i(fVar);
                this.f53227f.notifyDataSetChanged();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void m(NoNetworkView.b bVar) {
        this.f53225d.d(bVar);
    }

    public void n(f.g gVar) {
        this.f53226e.b(gVar);
    }

    public void o(int i) {
        if (this.f53228g == null) {
            this.f53228g = NoDataViewFactory.a(this.f53222a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i), null);
        }
        this.f53228g.setTextOption(NoDataViewFactory.e.a(i));
        this.f53228g.f(this.f53222a, TbadkCoreApplication.getInst().getSkinType());
        this.f53228g.setVisibility(0);
        this.f53224c.removeHeaderView(this.f53228g);
        this.f53224c.addHeaderView(this.f53228g);
    }

    public void onChangeSkinType(int i) {
        this.f53222a.getLayoutMode().k(i == 1);
        this.f53222a.getLayoutMode().j(this.f53223b);
        this.f53227f.h(i);
        this.f53226e.I(i);
        this.f53225d.c(this.mContext, i);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.f53222a = null;
        this.f53224c = null;
        this.f53226e = null;
        this.f53227f = null;
        this.f53222a = tbPageContext;
        this.f53223b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f53224c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f53222a.getOrignalPage() instanceof SquareActivity) {
            this.f53224c.setOnItemClickListener((SquareActivity) this.f53222a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f53227f = eVar;
        this.f53224c.setAdapter((ListAdapter) eVar);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(tbPageContext);
        this.f53226e = gVar;
        this.f53224c.setPullRefresh(gVar);
        this.f53225d = (NoNetworkView) this.f53223b.findViewById(R.id.view_no_network);
    }
}
