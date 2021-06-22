package d.a.n0.g0.f;

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
import d.a.n0.g0.d.b;
import d.a.n0.g0.f.a;
import d.a.o0.e3.t;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class c<D, S extends d.a.n0.g0.d.b, H extends a<D, S>> extends BaseAdapter implements t {

    /* renamed from: e  reason: collision with root package name */
    public List<D> f53187e;

    /* renamed from: h  reason: collision with root package name */
    public final TbPageContext<?> f53190h;

    /* renamed from: i  reason: collision with root package name */
    public S f53191i;
    public final ViewEventCenter j;
    public NoDataView l;
    public FrameLayout m;
    public NoDataViewFactory.e n;
    public NoDataViewFactory.d o;
    public NoDataViewFactory.c p;
    public FrameLayout.LayoutParams q;

    /* renamed from: f  reason: collision with root package name */
    public final List<H> f53188f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<H> f53189g = new SparseArray<>();
    public boolean k = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.f53190h = tbPageContext;
        this.j = viewEventCenter;
    }

    public View a() {
        if (this.m == null) {
            this.m = new FrameLayout(this.f53190h.getPageActivity());
        }
        if (this.l == null) {
            this.l = NoDataViewFactory.a(this.f53190h.getPageActivity(), this.m, this.o, this.n, this.p);
        }
        this.l.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = this.q;
        if (layoutParams != null) {
            this.l.setLayoutParams(layoutParams);
        }
        this.m.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.l.f(this.f53190h, TbadkCoreApplication.getInst().getSkinType());
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
        List<D> list = this.f53187e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<D> d() {
        if (this.f53187e == null) {
            return new ArrayList();
        }
        return new ArrayList(this.f53187e);
    }

    public boolean e() {
        List<D> list = this.f53187e;
        return list != null && list.size() == 0;
    }

    public final View f(View view, int i2, Class<?> cls, int i3) {
        H g2 = g(view, cls, i3);
        if (this.f53189g.indexOfValue(g2) >= 0) {
            this.f53189g.remove(g2.n());
        }
        this.f53189g.put(i2, g2);
        m(g2, i2);
        return g2.g();
    }

    public final H g(View view, Class<?> cls, int i2) {
        if (view != null && view.getTag() != null) {
            return (H) view.getTag();
        }
        View inflate = this.f53190h.getPageActivity().getLayoutInflater().inflate(i2, (ViewGroup) null);
        try {
            H h2 = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.f53190h, inflate, this.j);
            h2.onChangeSkinType(this.f53190h, TbadkCoreApplication.getInst().getSkinType());
            inflate.setTag(h2);
            this.f53188f.add(h2);
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
        List<D> list = this.f53187e;
        if (list == null) {
            return 0;
        }
        if (list.size() == 0 && this.k) {
            return 1;
        }
        return this.f53187e.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i2) {
        List<D> list = this.f53187e;
        if (list != null && list.size() != 0 && i2 >= 0 && i2 < this.f53187e.size()) {
            return this.f53187e.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        List<D> list = this.f53187e;
        if (list != null && list.size() != 0 && i2 >= 0 && i2 < this.f53187e.size()) {
            return i2;
        }
        return 0L;
    }

    public void h(D d2) {
        List<D> list;
        if (d2 == null || (list = this.f53187e) == null) {
            return;
        }
        list.remove(d2);
        notifyDataSetChanged();
    }

    public void i(List<D> list) {
        if (list != null) {
            if (this.f53187e == null) {
                this.f53187e = new ArrayList();
            }
            this.f53187e.addAll(list);
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
            if (this.f53187e == null) {
                this.f53187e = new ArrayList();
            }
            this.f53187e.clear();
            this.f53187e.addAll(list);
            this.f53189g.clear();
        }
    }

    public final void m(H h2, int i2) {
        D item = getItem(i2);
        if (item != null) {
            h2.j = i2;
            h2.l(item, this.f53191i);
        }
    }

    public void n(D d2) {
        List<D> list;
        H h2;
        if (d2 == null || (list = this.f53187e) == null || !list.contains(d2) || (h2 = this.f53189g.get(this.f53187e.indexOf(d2))) == null) {
            return;
        }
        h2.k(d2);
    }

    @Override // d.a.o0.e3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        int size = this.f53188f.size();
        for (int i3 = 0; i3 < size; i3++) {
            H h2 = this.f53188f.get(i3);
            if (h2 != null) {
                h2.onChangeSkinType(tbPageContext, i2);
            }
        }
        NoDataView noDataView = this.l;
        if (noDataView != null) {
            noDataView.f(this.f53190h, i2);
            return true;
        }
        return true;
    }
}
