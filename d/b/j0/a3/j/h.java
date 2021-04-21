package d.b.j0.a3.j;

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
import d.b.i0.r.f0.f;
/* loaded from: classes4.dex */
public class h extends d.b.c.a.d<Object> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<Object> f53643a;

    /* renamed from: b  reason: collision with root package name */
    public View f53644b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f53645c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f53646d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.r.f0.g f53647e;

    /* renamed from: f  reason: collision with root package name */
    public e f53648f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f53649g;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.f53647e.Z(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        this.f53646d.a(bVar);
    }

    public void e() {
        this.f53645c.A(0L);
    }

    public void f() {
        this.f53646d.setVisibility(0);
    }

    public void g(boolean z, String str) {
        e();
        if (z || str == null) {
            return;
        }
        this.f53643a.showToast(str, true);
    }

    public View h() {
        return this.f53644b;
    }

    public void i() {
        NoDataView noDataView = this.f53649g;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.f53645c.removeHeaderView(this.f53649g);
        }
    }

    public void k() {
        this.f53646d.setVisibility(8);
    }

    public void l(f fVar) {
        if (fVar != null) {
            try {
                if (fVar.g()) {
                    return;
                }
                this.f53648f.i(fVar);
                this.f53648f.notifyDataSetChanged();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void m(NoNetworkView.b bVar) {
        this.f53646d.d(bVar);
    }

    public void n(f.g gVar) {
        this.f53647e.b(gVar);
    }

    public void o(int i) {
        if (this.f53649g == null) {
            this.f53649g = NoDataViewFactory.a(this.f53643a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i), null);
        }
        this.f53649g.setTextOption(NoDataViewFactory.e.a(i));
        this.f53649g.f(this.f53643a, TbadkCoreApplication.getInst().getSkinType());
        this.f53649g.setVisibility(0);
        this.f53645c.removeHeaderView(this.f53649g);
        this.f53645c.addHeaderView(this.f53649g);
    }

    public void onChangeSkinType(int i) {
        this.f53643a.getLayoutMode().k(i == 1);
        this.f53643a.getLayoutMode().j(this.f53644b);
        this.f53648f.h(i);
        this.f53647e.I(i);
        this.f53646d.c(this.mContext, i);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.f53643a = null;
        this.f53645c = null;
        this.f53647e = null;
        this.f53648f = null;
        this.f53643a = tbPageContext;
        this.f53644b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f53645c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f53643a.getOrignalPage() instanceof SquareActivity) {
            this.f53645c.setOnItemClickListener((SquareActivity) this.f53643a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f53648f = eVar;
        this.f53645c.setAdapter((ListAdapter) eVar);
        d.b.i0.r.f0.g gVar = new d.b.i0.r.f0.g(tbPageContext);
        this.f53647e = gVar;
        this.f53645c.setPullRefresh(gVar);
        this.f53646d = (NoNetworkView) this.f53644b.findViewById(R.id.view_no_network);
    }
}
