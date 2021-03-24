package d.b.b.j.e;

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
    public Context f42357e;

    /* renamed from: f  reason: collision with root package name */
    public w f42358f;

    /* renamed from: g  reason: collision with root package name */
    public x f42359g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f42360h;
    public BdUniqueId i;
    public r<n> j;
    public V k;
    public d.b.b.j.c.a l = new d.b.b.j.c.a();

    public a(Context context, BdUniqueId bdUniqueId) {
        this.f42357e = context;
        this.f42360h = bdUniqueId;
    }

    public w A() {
        return this.f42358f;
    }

    public x B() {
        return this.f42359g;
    }

    public int E(int i) {
        BdUniqueId bdUniqueId;
        r<n> rVar = this.j;
        if (rVar == null || (bdUniqueId = this.f42360h) == null) {
            return -1;
        }
        return rVar.a(i, bdUniqueId.getId());
    }

    public d.b.b.j.c.c F(int i) {
        return this.l.a(i);
    }

    public BdUniqueId G() {
        return this.f42360h;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: d.b.b.j.e.a<T, V extends com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public View I(int i, View view, ViewGroup viewGroup, T t) {
        if (K(view)) {
            V v = (V) S(viewGroup, t);
            this.k = v;
            view = v.a();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.k.getClass().getName());
            }
        }
        View view2 = view;
        return X(i, view2, viewGroup, t, (TypeAdapter.ViewHolder) view2.getTag());
    }

    public boolean J(int i) {
        return this.l.b(i);
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

    public V O(ViewGroup viewGroup, T t) {
        return null;
    }

    public V P(ViewGroup viewGroup, T t) {
        return null;
    }

    public V Q(ViewGroup viewGroup, T t) {
        return null;
    }

    public abstract V R(ViewGroup viewGroup);

    public V S(ViewGroup viewGroup, T t) {
        return R(viewGroup);
    }

    public View T(int i, View view, ViewGroup viewGroup, T t, V v) {
        return X(i, view, viewGroup, t, v);
    }

    public View U(int i, View view, ViewGroup viewGroup, T t, V v) {
        return X(i, view, viewGroup, t, v);
    }

    public View V(int i, View view, ViewGroup viewGroup, T t, V v) {
        return X(i, view, viewGroup, t, v);
    }

    public View W(int i, View view, ViewGroup viewGroup, T t, V v) {
        return X(i, view, viewGroup, t, v);
    }

    public abstract View X(int i, View view, ViewGroup viewGroup, T t, V v);

    public void Y(int i, ViewGroup viewGroup, V v, T t) {
        X(i, v.a(), viewGroup, t, v);
    }

    public void b0(r<n> rVar) {
        this.j = rVar;
    }

    public void c0(w wVar) {
        this.f42358f = wVar;
    }

    public void d0(x xVar) {
        this.f42359g = xVar;
    }

    public void f0(BdUniqueId bdUniqueId) {
        this.i = bdUniqueId;
    }

    public boolean g0(int i, int i2, int i3) {
        return this.l.c(i, i2, i3);
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

    public n z(int i) {
        r<n> rVar = this.j;
        if (rVar != null) {
            return rVar.getItem(i);
        }
        return null;
    }

    public a(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        this.f42357e = context;
        this.f42360h = bdUniqueId;
        this.i = bdUniqueId2;
    }
}
