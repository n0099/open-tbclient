package d.a.i0.g0.f;

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
import d.a.i0.g0.d.b;
import d.a.i0.g0.f.a;
import d.a.j0.d3.t;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class c<D, S extends d.a.i0.g0.d.b, H extends a<D, S>> extends BaseAdapter implements t {

    /* renamed from: e  reason: collision with root package name */
    public List<D> f48534e;

    /* renamed from: h  reason: collision with root package name */
    public final TbPageContext<?> f48537h;

    /* renamed from: i  reason: collision with root package name */
    public S f48538i;
    public final ViewEventCenter j;
    public NoDataView l;
    public FrameLayout m;
    public NoDataViewFactory.e n;
    public NoDataViewFactory.d o;
    public NoDataViewFactory.c p;
    public FrameLayout.LayoutParams q;

    /* renamed from: f  reason: collision with root package name */
    public final List<H> f48535f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final SparseArray<H> f48536g = new SparseArray<>();
    public boolean k = true;

    public c(TbPageContext<?> tbPageContext, ViewEventCenter viewEventCenter) {
        this.f48537h = tbPageContext;
        this.j = viewEventCenter;
    }

    public View a() {
        if (this.m == null) {
            this.m = new FrameLayout(this.f48537h.getPageActivity());
        }
        if (this.l == null) {
            this.l = NoDataViewFactory.a(this.f48537h.getPageActivity(), this.m, this.o, this.n, this.p);
        }
        this.l.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = this.q;
        if (layoutParams != null) {
            this.l.setLayoutParams(layoutParams);
        }
        this.m.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.l.f(this.f48537h, TbadkCoreApplication.getInst().getSkinType());
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
        List<D> list = this.f48534e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<D> d() {
        if (this.f48534e == null) {
            return new ArrayList();
        }
        return new ArrayList(this.f48534e);
    }

    public boolean e() {
        List<D> list = this.f48534e;
        return list != null && list.size() == 0;
    }

    public final View f(View view, int i2, Class<?> cls, int i3) {
        H g2 = g(view, cls, i3);
        if (this.f48536g.indexOfValue(g2) >= 0) {
            this.f48536g.remove(g2.n());
        }
        this.f48536g.put(i2, g2);
        m(g2, i2);
        return g2.g();
    }

    public final H g(View view, Class<?> cls, int i2) {
        if (view != null && view.getTag() != null) {
            return (H) view.getTag();
        }
        View inflate = this.f48537h.getPageActivity().getLayoutInflater().inflate(i2, (ViewGroup) null);
        try {
            H h2 = (H) cls.getConstructor(TbPageContext.class, View.class, ViewEventCenter.class).newInstance(this.f48537h, inflate, this.j);
            h2.onChangeSkinType(this.f48537h, TbadkCoreApplication.getInst().getSkinType());
            inflate.setTag(h2);
            this.f48535f.add(h2);
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
        List<D> list = this.f48534e;
        if (list == null) {
            return 0;
        }
        if (list.size() == 0 && this.k) {
            return 1;
        }
        return this.f48534e.size();
    }

    @Override // android.widget.Adapter
    public D getItem(int i2) {
        List<D> list = this.f48534e;
        if (list != null && list.size() != 0 && i2 >= 0 && i2 < this.f48534e.size()) {
            return this.f48534e.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        List<D> list = this.f48534e;
        if (list != null && list.size() != 0 && i2 >= 0 && i2 < this.f48534e.size()) {
            return i2;
        }
        return 0L;
    }

    public void h(D d2) {
        List<D> list;
        if (d2 == null || (list = this.f48534e) == null) {
            return;
        }
        list.remove(d2);
        notifyDataSetChanged();
    }

    public void i(List<D> list) {
        if (list != null) {
            if (this.f48534e == null) {
                this.f48534e = new ArrayList();
            }
            this.f48534e.addAll(list);
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
            if (this.f48534e == null) {
                this.f48534e = new ArrayList();
            }
            this.f48534e.clear();
            this.f48534e.addAll(list);
            this.f48536g.clear();
        }
    }

    public final void m(H h2, int i2) {
        D item = getItem(i2);
        if (item != null) {
            h2.j = i2;
            h2.l(item, this.f48538i);
        }
    }

    public void n(D d2) {
        List<D> list;
        H h2;
        if (d2 == null || (list = this.f48534e) == null || !list.contains(d2) || (h2 = this.f48536g.get(this.f48534e.indexOf(d2))) == null) {
            return;
        }
        h2.k(d2);
    }

    @Override // d.a.j0.d3.t
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i2) {
        int size = this.f48535f.size();
        for (int i3 = 0; i3 < size; i3++) {
            H h2 = this.f48535f.get(i3);
            if (h2 != null) {
                h2.onChangeSkinType(tbPageContext, i2);
            }
        }
        NoDataView noDataView = this.l;
        if (noDataView != null) {
            noDataView.f(this.f48537h, i2);
            return true;
        }
        return true;
    }
}
