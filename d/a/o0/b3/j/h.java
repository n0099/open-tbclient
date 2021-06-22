package d.a.o0.b3.j;

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
import d.a.n0.r.f0.f;
/* loaded from: classes5.dex */
public class h extends d.a.c.a.d<Object> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<Object> f56063a;

    /* renamed from: b  reason: collision with root package name */
    public View f56064b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f56065c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f56066d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r.f0.g f56067e;

    /* renamed from: f  reason: collision with root package name */
    public e f56068f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f56069g;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.f56067e.Z(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        this.f56066d.a(bVar);
    }

    public void e() {
        this.f56065c.A(0L);
    }

    public void f() {
        this.f56066d.setVisibility(0);
    }

    public void g(boolean z, String str) {
        e();
        if (z || str == null) {
            return;
        }
        this.f56063a.showToast(str, true);
    }

    public View h() {
        return this.f56064b;
    }

    public void i() {
        NoDataView noDataView = this.f56069g;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.f56065c.removeHeaderView(this.f56069g);
        }
    }

    public void k() {
        this.f56066d.setVisibility(8);
    }

    public void l(f fVar) {
        if (fVar != null) {
            try {
                if (fVar.g()) {
                    return;
                }
                this.f56068f.i(fVar);
                this.f56068f.notifyDataSetChanged();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void m(NoNetworkView.b bVar) {
        this.f56066d.d(bVar);
    }

    public void n(f.g gVar) {
        this.f56067e.a(gVar);
    }

    public void o(int i2) {
        if (this.f56069g == null) {
            this.f56069g = NoDataViewFactory.a(this.f56063a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i2), null);
        }
        this.f56069g.setTextOption(NoDataViewFactory.e.a(i2));
        this.f56069g.f(this.f56063a, TbadkCoreApplication.getInst().getSkinType());
        this.f56069g.setVisibility(0);
        this.f56065c.removeHeaderView(this.f56069g);
        this.f56065c.addHeaderView(this.f56069g);
    }

    public void onChangeSkinType(int i2) {
        this.f56063a.getLayoutMode().k(i2 == 1);
        this.f56063a.getLayoutMode().j(this.f56064b);
        this.f56068f.h(i2);
        this.f56067e.I(i2);
        this.f56066d.c(this.mContext, i2);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.f56063a = null;
        this.f56065c = null;
        this.f56067e = null;
        this.f56068f = null;
        this.f56063a = tbPageContext;
        this.f56064b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f56065c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f56063a.getOrignalPage() instanceof SquareActivity) {
            this.f56065c.setOnItemClickListener((SquareActivity) this.f56063a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f56068f = eVar;
        this.f56065c.setAdapter((ListAdapter) eVar);
        d.a.n0.r.f0.g gVar = new d.a.n0.r.f0.g(tbPageContext);
        this.f56067e = gVar;
        this.f56065c.setPullRefresh(gVar);
        this.f56066d = (NoNetworkView) this.f56064b.findViewById(R.id.view_no_network);
    }
}
