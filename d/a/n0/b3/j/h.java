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
    public TbPageContext<Object> f55938a;

    /* renamed from: b  reason: collision with root package name */
    public View f55939b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f55940c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f55941d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.r.f0.g f55942e;

    /* renamed from: f  reason: collision with root package name */
    public e f55943f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f55944g;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.f55942e.Z(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        this.f55941d.a(bVar);
    }

    public void e() {
        this.f55940c.A(0L);
    }

    public void f() {
        this.f55941d.setVisibility(0);
    }

    public void g(boolean z, String str) {
        e();
        if (z || str == null) {
            return;
        }
        this.f55938a.showToast(str, true);
    }

    public View h() {
        return this.f55939b;
    }

    public void i() {
        NoDataView noDataView = this.f55944g;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.f55940c.removeHeaderView(this.f55944g);
        }
    }

    public void k() {
        this.f55941d.setVisibility(8);
    }

    public void l(f fVar) {
        if (fVar != null) {
            try {
                if (fVar.g()) {
                    return;
                }
                this.f55943f.i(fVar);
                this.f55943f.notifyDataSetChanged();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void m(NoNetworkView.b bVar) {
        this.f55941d.d(bVar);
    }

    public void n(f.g gVar) {
        this.f55942e.a(gVar);
    }

    public void o(int i2) {
        if (this.f55944g == null) {
            this.f55944g = NoDataViewFactory.a(this.f55938a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i2), null);
        }
        this.f55944g.setTextOption(NoDataViewFactory.e.a(i2));
        this.f55944g.f(this.f55938a, TbadkCoreApplication.getInst().getSkinType());
        this.f55944g.setVisibility(0);
        this.f55940c.removeHeaderView(this.f55944g);
        this.f55940c.addHeaderView(this.f55944g);
    }

    public void onChangeSkinType(int i2) {
        this.f55938a.getLayoutMode().k(i2 == 1);
        this.f55938a.getLayoutMode().j(this.f55939b);
        this.f55943f.h(i2);
        this.f55942e.I(i2);
        this.f55941d.c(this.mContext, i2);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.f55938a = null;
        this.f55940c = null;
        this.f55942e = null;
        this.f55943f = null;
        this.f55938a = tbPageContext;
        this.f55939b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f55940c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f55938a.getOrignalPage() instanceof SquareActivity) {
            this.f55940c.setOnItemClickListener((SquareActivity) this.f55938a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f55943f = eVar;
        this.f55940c.setAdapter((ListAdapter) eVar);
        d.a.m0.r.f0.g gVar = new d.a.m0.r.f0.g(tbPageContext);
        this.f55942e = gVar;
        this.f55940c.setPullRefresh(gVar);
        this.f55941d = (NoNetworkView) this.f55939b.findViewById(R.id.view_no_network);
    }
}
