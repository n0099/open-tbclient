package d.a.k0.a3.j;

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
import d.a.j0.r.f0.f;
/* loaded from: classes5.dex */
public class h extends d.a.c.a.d<Object> {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<Object> f52082a;

    /* renamed from: b  reason: collision with root package name */
    public View f52083b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f52084c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f52085d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.r.f0.g f52086e;

    /* renamed from: f  reason: collision with root package name */
    public e f52087f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f52088g;

    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        this.f52086e.Z(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        this.f52085d.a(bVar);
    }

    public void e() {
        this.f52084c.A(0L);
    }

    public void f() {
        this.f52085d.setVisibility(0);
    }

    public void g(boolean z, String str) {
        e();
        if (z || str == null) {
            return;
        }
        this.f52082a.showToast(str, true);
    }

    public View h() {
        return this.f52083b;
    }

    public void j() {
        NoDataView noDataView = this.f52088g;
        if (noDataView != null) {
            noDataView.setVisibility(8);
            this.f52084c.removeHeaderView(this.f52088g);
        }
    }

    public void k() {
        this.f52085d.setVisibility(8);
    }

    public void l(f fVar) {
        if (fVar != null) {
            try {
                if (fVar.g()) {
                    return;
                }
                this.f52087f.i(fVar);
                this.f52087f.notifyDataSetChanged();
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public void m(NoNetworkView.b bVar) {
        this.f52085d.d(bVar);
    }

    public void n(f.g gVar) {
        this.f52086e.a(gVar);
    }

    public void o(int i2) {
        if (this.f52088g == null) {
            this.f52088g = NoDataViewFactory.a(this.f52082a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i2), null);
        }
        this.f52088g.setTextOption(NoDataViewFactory.e.a(i2));
        this.f52088g.f(this.f52082a, TbadkCoreApplication.getInst().getSkinType());
        this.f52088g.setVisibility(0);
        this.f52084c.removeHeaderView(this.f52088g);
        this.f52084c.addHeaderView(this.f52088g);
    }

    public void onChangeSkinType(int i2) {
        this.f52082a.getLayoutMode().k(i2 == 1);
        this.f52082a.getLayoutMode().j(this.f52083b);
        this.f52087f.h(i2);
        this.f52086e.I(i2);
        this.f52085d.c(this.mContext, i2);
    }

    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        this.f52082a = null;
        this.f52084c = null;
        this.f52086e = null;
        this.f52087f = null;
        this.f52082a = tbPageContext;
        this.f52083b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f52084c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f52082a.getOrignalPage() instanceof SquareActivity) {
            this.f52084c.setOnItemClickListener((SquareActivity) this.f52082a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f52087f = eVar;
        this.f52084c.setAdapter((ListAdapter) eVar);
        d.a.j0.r.f0.g gVar = new d.a.j0.r.f0.g(tbPageContext);
        this.f52086e = gVar;
        this.f52084c.setPullRefresh(gVar);
        this.f52085d = (NoNetworkView) this.f52083b.findViewById(R.id.view_no_network);
    }
}
