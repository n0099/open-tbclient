package d.a.j0.a3.j;

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
import d.a.i0.r.f0.f;
/* loaded from: classes5.dex */
public class h extends d.a.c.a.d<Object> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<Object> f51383a;

    /* renamed from: b  reason: collision with root package name */
    public View f51384b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f51385c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f51386d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.r.f0.g f51387e;

    /* renamed from: f  reason: collision with root package name */
    public e f51388f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f51389g;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.f51387e.Z(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        this.f51386d.a(bVar);
    }

    public void e() {
        this.f51385c.A(0L);
    }

    public void f() {
        this.f51386d.setVisibility(0);
    }

    public void g(boolean z, String str) {
        e();
        if (z || str == null) {
            return;
        }
        this.f51383a.showToast(str, true);
    }

    public View h() {
        return this.f51384b;
    }

    public void j() {
        NoDataView noDataView = this.f51389g;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.f51385c.removeHeaderView(this.f51389g);
        }
    }

    public void k() {
        this.f51386d.setVisibility(8);
    }

    public void l(f fVar) {
        if (fVar != null) {
            try {
                if (fVar.g()) {
                    return;
                }
                this.f51388f.i(fVar);
                this.f51388f.notifyDataSetChanged();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void m(NoNetworkView.b bVar) {
        this.f51386d.d(bVar);
    }

    public void n(f.g gVar) {
        this.f51387e.a(gVar);
    }

    public void o(int i2) {
        if (this.f51389g == null) {
            this.f51389g = NoDataViewFactory.a(this.f51383a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i2), null);
        }
        this.f51389g.setTextOption(NoDataViewFactory.e.a(i2));
        this.f51389g.f(this.f51383a, TbadkCoreApplication.getInst().getSkinType());
        this.f51389g.setVisibility(0);
        this.f51385c.removeHeaderView(this.f51389g);
        this.f51385c.addHeaderView(this.f51389g);
    }

    public void onChangeSkinType(int i2) {
        this.f51383a.getLayoutMode().k(i2 == 1);
        this.f51383a.getLayoutMode().j(this.f51384b);
        this.f51388f.h(i2);
        this.f51387e.I(i2);
        this.f51386d.c(this.mContext, i2);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.f51383a = null;
        this.f51385c = null;
        this.f51387e = null;
        this.f51388f = null;
        this.f51383a = tbPageContext;
        this.f51384b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f51385c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f51383a.getOrignalPage() instanceof SquareActivity) {
            this.f51385c.setOnItemClickListener((SquareActivity) this.f51383a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f51388f = eVar;
        this.f51385c.setAdapter((ListAdapter) eVar);
        d.a.i0.r.f0.g gVar = new d.a.i0.r.f0.g(tbPageContext);
        this.f51387e = gVar;
        this.f51385c.setPullRefresh(gVar);
        this.f51386d = (NoNetworkView) this.f51384b.findViewById(R.id.view_no_network);
    }
}
