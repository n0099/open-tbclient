package d.a.k0.q0.s1.a.e;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
/* loaded from: classes4.dex */
public abstract class a extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public e f59494e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59495f = true;

    public final View a(View view) {
        e eVar = this.f59494e;
        if (eVar == null) {
            return view;
        }
        if (view == null || view != eVar.getArrowView()) {
            view = this.f59494e.getArrowView();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new AbsListView.LayoutParams(-1, d()));
            }
        }
        this.f59494e.a(view);
        return view;
    }

    public abstract int b();

    public abstract Object c(int i2);

    public abstract int d();

    public abstract long e(int i2);

    public int f(int i2) {
        int arrowIndex;
        e eVar = this.f59494e;
        if (eVar == null || !eVar.b() || i2 < (arrowIndex = this.f59494e.getArrowIndex())) {
            return i2;
        }
        if (i2 == arrowIndex) {
            return -1;
        }
        return i2 - 1;
    }

    public abstract View g(int i2, View view, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public int getCount() {
        int b2;
        if (h()) {
            if (this.f59495f) {
                b2 = this.f59494e.getArrowIndex();
            } else {
                e eVar = this.f59494e;
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
    public Object getItem(int i2) {
        if (h()) {
            int f2 = f(i2);
            if (f2 >= 0) {
                return c(f2);
            }
            return c(i2);
        }
        return c(i2);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        if (h()) {
            int f2 = f(i2);
            if (f2 >= 0) {
                return e(f2);
            }
            return e(i2);
        }
        return e(i2);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        int arrowIndex;
        return (h() && (arrowIndex = this.f59494e.getArrowIndex()) > 0 && i2 == arrowIndex) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (getItemViewType(i2) == 0) {
            return g(f(i2), view, viewGroup);
        }
        return a(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return h() ? 2 : 1;
    }

    public boolean h() {
        e eVar = this.f59494e;
        return eVar != null && eVar.b() && b() - 1 > this.f59494e.getArrowIndex();
    }

    public void i(e eVar) {
        this.f59494e = eVar;
    }

    public abstract void j(int i2);

    public void k(boolean z) {
        this.f59495f = z;
    }
}
