package d.b.i0.z2.j;

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
import d.b.b.e.p.l;
import d.b.h0.r.f0.f;
/* loaded from: classes5.dex */
public class h extends d.b.b.a.d<Object> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<Object> f63602a;

    /* renamed from: b  reason: collision with root package name */
    public View f63603b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f63604c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f63605d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.r.f0.g f63606e;

    /* renamed from: f  reason: collision with root package name */
    public e f63607f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f63608g;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.f63606e.Z(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        this.f63605d.a(bVar);
    }

    public void e() {
        this.f63604c.A(0L);
    }

    public void f() {
        this.f63605d.setVisibility(0);
    }

    public void g(boolean z, String str) {
        e();
        if (z || str == null) {
            return;
        }
        this.f63602a.showToast(str, true);
    }

    public View h() {
        return this.f63603b;
    }

    public void i() {
        NoDataView noDataView = this.f63608g;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.f63604c.removeHeaderView(this.f63608g);
        }
    }

    public void k() {
        this.f63605d.setVisibility(8);
    }

    public void l(f fVar) {
        if (fVar != null) {
            try {
                if (fVar.g()) {
                    return;
                }
                this.f63607f.i(fVar);
                this.f63607f.notifyDataSetChanged();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void m(NoNetworkView.b bVar) {
        this.f63605d.d(bVar);
    }

    public void n(f.g gVar) {
        this.f63606e.b(gVar);
    }

    public void o(int i) {
        if (this.f63608g == null) {
            this.f63608g = NoDataViewFactory.a(this.f63602a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i), null);
        }
        this.f63608g.setTextOption(NoDataViewFactory.e.a(i));
        this.f63608g.f(this.f63602a, TbadkCoreApplication.getInst().getSkinType());
        this.f63608g.setVisibility(0);
        this.f63604c.removeHeaderView(this.f63608g);
        this.f63604c.addHeaderView(this.f63608g);
    }

    public void onChangeSkinType(int i) {
        this.f63602a.getLayoutMode().k(i == 1);
        this.f63602a.getLayoutMode().j(this.f63603b);
        this.f63607f.h(i);
        this.f63606e.I(i);
        this.f63605d.c(this.mContext, i);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.f63602a = null;
        this.f63604c = null;
        this.f63606e = null;
        this.f63607f = null;
        this.f63602a = tbPageContext;
        this.f63603b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f63604c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f63602a.getOrignalPage() instanceof SquareActivity) {
            this.f63604c.setOnItemClickListener((SquareActivity) this.f63602a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f63607f = eVar;
        this.f63604c.setAdapter((ListAdapter) eVar);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(tbPageContext);
        this.f63606e = gVar;
        this.f63604c.setPullRefresh(gVar);
        this.f63605d = (NoNetworkView) this.f63603b.findViewById(R.id.view_no_network);
    }
}
