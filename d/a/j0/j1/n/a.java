package d.a.j0.j1.n;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import d.a.c.j.e.e;
import d.a.j0.j1.o.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends e {
    public TbPageContext m;
    public List<ICardInfo> n;
    public int o;
    public boolean p;
    public NoDataView q;
    public FrameLayout r;
    public NoDataViewFactory.e s;
    public NoDataViewFactory.d t;
    public NoDataViewFactory.c u;
    public FrameLayout.LayoutParams v;
    public String w;
    public boolean x;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.o = 0;
        this.p = true;
        this.m = tbPageContext;
    }

    public boolean A() {
        List<ICardInfo> list = this.n;
        return list != null && list.size() == 0;
    }

    public final void B(int i2) {
        ICardInfo iCardInfo = this.n.get(i2);
        if (iCardInfo instanceof d.a.j0.j1.o.i.a) {
            ((d.a.j0.j1.o.i.a) iCardInfo).doLoad(iCardInfo, this.m);
        }
    }

    public void C(List<ICardInfo> list) {
        List<ICardInfo> list2 = this.n;
        if (list2 == null) {
            this.n = new ArrayList();
        } else {
            list2.clear();
        }
        if (list != null) {
            this.n.addAll(list);
        }
        this.o = w();
        notifyDataSetChanged();
    }

    public final void D(int i2) {
        if (this.x) {
            int u = u(i2 - 1);
            int u2 = u(i2 - 2);
            B(u);
            B(u2);
            return;
        }
        int u3 = u(i2 + 1);
        int u4 = u(i2 + 2);
        B(u3);
        B(u4);
    }

    public void E(String str) {
        this.w = str;
    }

    public void F(NoDataViewFactory.d dVar, NoDataViewFactory.e eVar, NoDataViewFactory.c cVar, FrameLayout.LayoutParams layoutParams) {
        this.t = dVar;
        this.s = eVar;
        this.u = cVar;
        this.v = layoutParams;
        NoDataView noDataView = this.q;
        if (noDataView != null) {
            noDataView.setTextOption(eVar);
            this.q.setImgOption(dVar);
            this.q.setButtonOption(cVar);
            if (layoutParams != null) {
                this.q.setLayoutParams(layoutParams);
            }
        }
    }

    public void G(boolean z) {
        this.p = z;
    }

    public void H(boolean z) {
        this.x = z;
    }

    @Override // d.a.c.j.e.e, android.widget.Adapter, d.a.c.j.e.o
    public int getCount() {
        if (this.o == 0 && this.p) {
            return 1;
        }
        return this.o;
    }

    @Override // d.a.c.j.e.e, android.widget.Adapter
    public long getItemId(int i2) {
        return i2;
    }

    @Override // d.a.c.j.e.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        ICardInfo x = x(i2);
        if (x != null) {
            return d.a.j0.j1.o.e.f55751a.get(x.getAdapterType());
        }
        return 0;
    }

    @Override // d.a.c.j.e.e, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (this.p && A()) {
            return t();
        }
        v();
        D(i2);
        ICardInfo x = x(i2);
        BaseLegoCardView y = y(view, x);
        if (y != null) {
            y.f18681e = this.w;
            y.g(x);
        }
        return y;
    }

    @Override // d.a.c.j.e.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return d.a.j0.j1.o.e.f55751a.size() + 1;
    }

    @Override // d.a.c.j.e.e, android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.o == 0;
    }

    public View t() {
        if (this.r == null) {
            this.r = new FrameLayout(this.m.getPageActivity());
        }
        if (this.q == null) {
            this.q = NoDataViewFactory.a(this.m.getPageActivity(), this.r, this.t, this.s, this.u);
        }
        this.q.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = this.v;
        if (layoutParams != null) {
            this.q.setLayoutParams(layoutParams);
        }
        this.r.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.q.f(this.m, TbadkCoreApplication.getInst().getSkinType());
        return this.r;
    }

    public final int u(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        return i2 >= this.n.size() ? this.n.size() - 1 : i2;
    }

    public void v() {
        NoDataView noDataView;
        FrameLayout frameLayout = this.r;
        if (frameLayout == null || (noDataView = this.q) == null) {
            return;
        }
        frameLayout.removeView(noDataView);
        this.q = null;
    }

    public final int w() {
        List<ICardInfo> list = this.n;
        int i2 = 0;
        if (list == null) {
            return 0;
        }
        for (ICardInfo iCardInfo : list) {
            i2 += iCardInfo.getAdapterCount();
        }
        return i2;
    }

    public final ICardInfo x(int i2) {
        for (ICardInfo iCardInfo : this.n) {
            int adapterCount = iCardInfo.getAdapterCount();
            if (i2 < adapterCount) {
                return iCardInfo.getAdapterItem(i2);
            }
            i2 -= adapterCount;
        }
        return null;
    }

    public BaseLegoCardView y(View view, ICardInfo iCardInfo) {
        if (iCardInfo == null) {
            return null;
        }
        if (view instanceof BaseLegoCardView) {
            return (BaseLegoCardView) view;
        }
        return (BaseLegoCardView) b.h().a(this.m, iCardInfo, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.j.e.e, android.widget.Adapter, d.a.c.j.e.o
    /* renamed from: z */
    public ICardInfo getItem(int i2) {
        return x(i2);
    }
}
