package d.b.j0.q0.s1.a.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public e f60645e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f60646f = true;

    public final View a(View view) {
        e eVar = this.f60645e;
        if (eVar == null) {
            return view;
        }
        if (view == null || view != eVar.getArrowView()) {
            view = this.f60645e.getArrowView();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new AbsListView.LayoutParams(-1, d()));
            }
        }
        this.f60645e.a(view);
        return view;
    }

    public abstract int b();

    public abstract Object c(int i);

    public abstract int d();

    public abstract long e(int i);

    public int f(int i) {
        int arrowIndex;
        e eVar = this.f60645e;
        if (eVar == null || !eVar.b() || i < (arrowIndex = this.f60645e.getArrowIndex())) {
            return i;
        }
        if (i == arrowIndex) {
            return -1;
        }
        return i - 1;
    }

    public abstract View g(int i, View view, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        int b2;
        if (h()) {
            if (this.f60646f) {
                b2 = this.f60645e.getArrowIndex();
            } else {
                e eVar = this.f60645e;
                if (eVar != null && eVar.b()) {
                    b2 = b();
                } else {
                    return b();
                }
            }
            return b2 + 1;
        }
        return b();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (h()) {
            int f2 = f(i);
            if (f2 >= 0) {
                return c(f2);
            }
            return c(i);
        }
        return c(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (h()) {
            int f2 = f(i);
            if (f2 >= 0) {
                return e(f2);
            }
            return e(i);
        }
        return e(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int arrowIndex;
        return (h() && (arrowIndex = this.f60645e.getArrowIndex()) > 0 && i == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (getItemViewType(i) == 0) {
            return g(f(i), view, viewGroup);
        }
        return a(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return h() ? 2 : 1;
    }

    public boolean h() {
        e eVar = this.f60645e;
        return eVar != null && eVar.b() && b() - 1 > this.f60645e.getArrowIndex();
    }

    public void i(e eVar) {
        this.f60645e = eVar;
    }

    public abstract void j(int i);

    public void k(boolean z) {
        this.f60646f = z;
    }
}
