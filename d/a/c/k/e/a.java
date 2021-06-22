package d.a.c.k.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
/* loaded from: classes.dex */
public abstract class a<T, V extends TypeAdapter.ViewHolder> {

    /* renamed from: e  reason: collision with root package name */
    public Context f43012e;

    /* renamed from: f  reason: collision with root package name */
    public w f43013f;

    /* renamed from: g  reason: collision with root package name */
    public x f43014g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f43015h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f43016i;
    public r<n> j;
    public V k;
    public d.a.c.k.c.a l = new d.a.c.k.c.a();

    public a(Context context, BdUniqueId bdUniqueId) {
        this.f43012e = context;
        this.f43015h = bdUniqueId;
    }

    public w A() {
        return this.f43013f;
    }

    public x B() {
        return this.f43014g;
    }

    public int F(int i2) {
        BdUniqueId bdUniqueId;
        r<n> rVar = this.j;
        if (rVar == null || (bdUniqueId = this.f43015h) == null) {
            return -1;
        }
        return rVar.a(i2, bdUniqueId.getId());
    }

    public d.a.c.k.c.c G(int i2) {
        return this.l.a(i2);
    }

    public BdUniqueId H() {
        return this.f43015h;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: d.a.c.k.e.a<T, V extends com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public View I(int i2, View view, ViewGroup viewGroup, T t) {
        if (K(view)) {
            V v = (V) R(viewGroup, t);
            this.k = v;
            view = v.a();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.k.getClass().getName());
            }
        }
        View view2 = view;
        return X(i2, view2, viewGroup, t, (TypeAdapter.ViewHolder) view2.getTag());
    }

    public boolean J(int i2) {
        return this.l.b(i2);
    }

    public final boolean K(View view) {
        V v;
        return view == null || view.getTag() == null || (v = this.k) == null || !v.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.k.getClass());
    }

    public void L() {
        r<n> rVar = this.j;
        if (rVar != null) {
            rVar.notifyDataSetChanged();
        }
    }

    public V M(ViewGroup viewGroup, T t) {
        return null;
    }

    public V N(ViewGroup viewGroup, T t) {
        return null;
    }

    public V O(ViewGroup viewGroup, T t) {
        return null;
    }

    public V P(ViewGroup viewGroup, T t) {
        return null;
    }

    public abstract V Q(ViewGroup viewGroup);

    public V R(ViewGroup viewGroup, T t) {
        return Q(viewGroup);
    }

    public View S(int i2, View view, ViewGroup viewGroup, T t, V v) {
        return X(i2, view, viewGroup, t, v);
    }

    public View T(int i2, View view, ViewGroup viewGroup, T t, V v) {
        return X(i2, view, viewGroup, t, v);
    }

    public View U(int i2, View view, ViewGroup viewGroup, T t, V v) {
        return X(i2, view, viewGroup, t, v);
    }

    public View V(int i2, View view, ViewGroup viewGroup, T t, V v) {
        return X(i2, view, viewGroup, t, v);
    }

    public abstract View X(int i2, View view, ViewGroup viewGroup, T t, V v);

    public void Y(int i2, ViewGroup viewGroup, V v, T t) {
        X(i2, v.a(), viewGroup, t, v);
    }

    public void Z(r<n> rVar) {
        this.j = rVar;
    }

    public void a0(w wVar) {
        this.f43013f = wVar;
    }

    public void b0(x xVar) {
        this.f43014g = xVar;
    }

    public void c0(BdUniqueId bdUniqueId) {
        this.f43016i = bdUniqueId;
    }

    public boolean d0(int i2, int i3, int i4) {
        return this.l.c(i2, i3, i4);
    }

    public ViewGroup.LayoutParams u(ViewGroup viewGroup) {
        if (viewGroup instanceof ListView) {
            return new AbsListView.LayoutParams(-1, -2);
        }
        if (viewGroup instanceof RecyclerView) {
            return new RecyclerView.LayoutParams(-1, -2);
        }
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public BdUniqueId v() {
        return null;
    }

    public BdUniqueId w() {
        return null;
    }

    public BdUniqueId x() {
        return null;
    }

    public BdUniqueId y() {
        return null;
    }

    public n z(int i2) {
        r<n> rVar = this.j;
        if (rVar != null) {
            return rVar.getItem(i2);
        }
        return null;
    }

    public a(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        this.f43012e = context;
        this.f43015h = bdUniqueId;
        this.f43016i = bdUniqueId2;
    }
}
