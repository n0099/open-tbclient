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
    public TbPageContext<Object> f63603a;

    /* renamed from: b  reason: collision with root package name */
    public View f63604b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f63605c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f63606d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.r.f0.g f63607e;

    /* renamed from: f  reason: collision with root package name */
    public e f63608f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f63609g;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.f63607e.Z(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        this.f63606d.a(bVar);
    }

    public void e() {
        this.f63605c.A(0L);
    }

    public void f() {
        this.f63606d.setVisibility(0);
    }

    public void g(boolean z, String str) {
        e();
        if (z || str == null) {
            return;
        }
        this.f63603a.showToast(str, true);
    }

    public View h() {
        return this.f63604b;
    }

    public void i() {
        NoDataView noDataView = this.f63609g;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.f63605c.removeHeaderView(this.f63609g);
        }
    }

    public void k() {
        this.f63606d.setVisibility(8);
    }

    public void l(f fVar) {
        if (fVar != null) {
            try {
                if (fVar.g()) {
                    return;
                }
                this.f63608f.i(fVar);
                this.f63608f.notifyDataSetChanged();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void m(NoNetworkView.b bVar) {
        this.f63606d.d(bVar);
    }

    public void n(f.g gVar) {
        this.f63607e.b(gVar);
    }

    public void o(int i) {
        if (this.f63609g == null) {
            this.f63609g = NoDataViewFactory.a(this.f63603a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i), null);
        }
        this.f63609g.setTextOption(NoDataViewFactory.e.a(i));
        this.f63609g.f(this.f63603a, TbadkCoreApplication.getInst().getSkinType());
        this.f63609g.setVisibility(0);
        this.f63605c.removeHeaderView(this.f63609g);
        this.f63605c.addHeaderView(this.f63609g);
    }

    public void onChangeSkinType(int i) {
        this.f63603a.getLayoutMode().k(i == 1);
        this.f63603a.getLayoutMode().j(this.f63604b);
        this.f63608f.h(i);
        this.f63607e.I(i);
        this.f63606d.c(this.mContext, i);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.f63603a = null;
        this.f63605c = null;
        this.f63607e = null;
        this.f63608f = null;
        this.f63603a = tbPageContext;
        this.f63604b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f63605c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f63603a.getOrignalPage() instanceof SquareActivity) {
            this.f63605c.setOnItemClickListener((SquareActivity) this.f63603a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f63608f = eVar;
        this.f63605c.setAdapter((ListAdapter) eVar);
        d.b.h0.r.f0.g gVar = new d.b.h0.r.f0.g(tbPageContext);
        this.f63607e = gVar;
        this.f63605c.setPullRefresh(gVar);
        this.f63606d = (NoNetworkView) this.f63604b.findViewById(R.id.view_no_network);
    }
}
