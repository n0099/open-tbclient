package d.b.h0.g0.f;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import d.b.h0.g0.d.b;
import d.b.h0.g0.f.a;
import d.b.i0.d3.t;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class c<D, S extends d.b.h0.g0.d.b, H extends a<D, S>> extends BaseAdapter implements t {

    /* renamed from: e  reason: collision with root package name */
    public List<D> f50619e;

    /* renamed from: h  reason: collision with root package name */
    public final TbPageContext<?> f50622h;
    public S i;
    public final ViewEventCenter j;
    public NoDataView l;
    public FrameLayout m;
    public NoDataViewFactory.e n;
    public NoDataViewFactory.d o;
    public NoDataViewFactory.c p;
    public FrameLayout.LayoutParams q;

    /* renamed from: f  reason: collision with root package name */
    public final List<H> f50620f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<H> f50621g = new SparseArray<>();
    public boolean k = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.f50622h = tbPageContext;
        this.j = viewEventCenter;
    }

    public View a() {
        if (this.m == null) {
            this.m = new FrameLayout(this.f50622h.getPageActivity());
        }
        if (this.l == null) {
            this.l = NoDataViewFactory.a(this.f50622h.getPageActivity(), this.m, this.o, this.n, this.p);
        }
        this.l.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = this.q;
        if (layoutParams != null) {
            this.l.setLayoutParams(layoutParams);
        }
        this.m.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.l.f(this.f50622h, TbadkCoreApplication.getInst().getSkinType());
        return this.m;
    }

    public void b() {
        NoDataView noDataView;
        FrameLayout frameLayout = this.m;
        if (frameLayout == null || (noDataView = this.l) == null) {
            return;
        }
        frameLayout.removeView(noDataView);
        this.l = null;
    }

    public int c() {
        List<D> list = this.f50619e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<D> d() {
        if (this.f50619e == null) {
            return new ArrayList();
        }
        return new ArrayList(this.f50619e);
    }

    public boolean e() {
        List<D> list = this.f50619e;
        return list != null && list.size() == 0;
    }

    public final View f(View view, int i, Class<?> cls, int i2) {
        H g2 = g(view, cls, i2);
        if (this.f50621g.indexOfValue(g2) >= 0) {
            this.f50621g.remove(g2.n());
        }
        this.f50621g.put(i, g2);
        m(g2, i);
        return g2.g();
    }

    public final H g(View view, Class<?> cls, int i) {
        if (view != null && view.getTag() != null) {
            return (H) view.getTag();
        }
        View inflate = this.f50622h.getPageActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
        try {
            H h2 = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.f50622h, inflate, this.j);
            h2.onChangeSkinType(this.f50622h, TbadkCoreApplication.getInst().getSkinType());
            inflate.setTag(h2);
            this.f50620f.add(h2);
            return h2;
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (IllegalArgumentException e3) {
            throw e3;
        } catch (InstantiationException e4) {
            throw new RuntimeException(e4);
        } catch (NoSuchMethodException e5) {
            throw new RuntimeException(e5);
        } catch (SecurityException e6) {
            throw e6;
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<D> list = this.f50619e;
        if (list == null) {
            return 0;
        }
        if (list.size() == 0 && this.k) {
            return 1;
        }
        return this.f50619e.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i) {
        List<D> list = this.f50619e;
        if (list != null && list.size() != 0 && i >= 0 && i < this.f50619e.size()) {
            return this.f50619e.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        List<D> list = this.f50619e;
        if (list != null && list.size() != 0 && i >= 0 && i < this.f50619e.size()) {
            return i;
        }
        return 0L;
    }

    public void h(D d2) {
        List<D> list;
        if (d2 == null || (list = this.f50619e) == null) {
            return;
        }
        list.remove(d2);
        notifyDataSetChanged();
    }

    public void i(List<D> list) {
        if (list != null) {
            if (this.f50619e == null) {
                this.f50619e = new ArrayList();
            }
            this.f50619e.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void j(NoDataViewFactory.d dVar, NoDataViewFactory.e eVar, NoDataViewFactory.c cVar, FrameLayout.LayoutParams layoutParams) {
        this.o = dVar;
        this.n = eVar;
        this.p = cVar;
        this.q = layoutParams;
        NoDataView noDataView = this.l;
        if (noDataView != null) {
            noDataView.setTextOption(eVar);
            this.l.setImgOption(dVar);
            this.l.setButtonOption(cVar);
            if (layoutParams != null) {
                this.l.setLayoutParams(layoutParams);
            }
        }
    }

    public void k(List<D> list) {
        l(list);
        notifyDataSetChanged();
    }

    public void l(List<D> list) {
        if (list != null) {
            if (this.f50619e == null) {
                this.f50619e = new ArrayList();
            }
            this.f50619e.clear();
            this.f50619e.addAll(list);
            this.f50621g.clear();
        }
    }

    public final void m(H h2, int i) {
        D item = getItem(i);
        if (item != null) {
            h2.j = i;
            h2.l(item, this.i);
        }
    }

    public void n(D d2) {
        List<D> list;
        H h2;
        if (d2 == null || (list = this.f50619e) == null || !list.contains(d2) || (h2 = this.f50621g.get(this.f50619e.indexOf(d2))) == null) {
            return;
        }
        h2.k(d2);
    }

    @Override // d.b.i0.d3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        int size = this.f50620f.size();
        for (int i2 = 0; i2 < size; i2++) {
            H h2 = this.f50620f.get(i2);
            if (h2 != null) {
                h2.onChangeSkinType(tbPageContext, i);
            }
        }
        NoDataView noDataView = this.l;
        if (noDataView != null) {
            noDataView.f(this.f50622h, i);
            return true;
        }
        return true;
    }
}
