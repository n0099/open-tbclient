package d.a.c.j.e;

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
    public Context f40319e;

    /* renamed from: f  reason: collision with root package name */
    public w f40320f;

    /* renamed from: g  reason: collision with root package name */
    public x f40321g;

    /* renamed from: h  reason: collision with root package name */
    public BdUniqueId f40322h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f40323i;
    public r<n> j;
    public V k;
    public d.a.c.j.c.a l = new d.a.c.j.c.a();

    public a(Context context, BdUniqueId bdUniqueId) {
        this.f40319e = context;
        this.f40322h = bdUniqueId;
    }

    public x A() {
        return this.f40321g;
    }

    public int B(int i2) {
        BdUniqueId bdUniqueId;
        r<n> rVar = this.j;
        if (rVar == null || (bdUniqueId = this.f40322h) == null) {
            return -1;
        }
        return rVar.a(i2, bdUniqueId.getId());
    }

    public d.a.c.j.c.c F(int i2) {
        return this.l.a(i2);
    }

    public BdUniqueId G() {
        return this.f40322h;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: d.a.c.j.e.a<T, V extends com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public View H(int i2, View view, ViewGroup viewGroup, T t) {
        if (J(view)) {
            V v = (V) Q(viewGroup, t);
            this.k = v;
            view = v.a();
            if (BdBaseApplication.getInst().isDebugMode()) {
                BdLog.i("convertView is creating" + this.k.getClass().getName());
            }
        }
        View view2 = view;
        return W(i2, view2, viewGroup, t, (TypeAdapter.ViewHolder) view2.getTag());
    }

    public boolean I(int i2) {
        return this.l.b(i2);
    }

    public final boolean J(View view) {
        V v;
        return view == null || view.getTag() == null || (v = this.k) == null || !v.getClass().isAssignableFrom(view.getTag().getClass()) || !view.getTag().getClass().isAssignableFrom(this.k.getClass());
    }

    public void K() {
        r<n> rVar = this.j;
        if (rVar != null) {
            rVar.notifyDataSetChanged();
        }
    }

    public V L(ViewGroup viewGroup, T t) {
        return null;
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

    public abstract V P(ViewGroup viewGroup);

    public V Q(ViewGroup viewGroup, T t) {
        return P(viewGroup);
    }

    public View R(int i2, View view, ViewGroup viewGroup, T t, V v) {
        return W(i2, view, viewGroup, t, v);
    }

    public View S(int i2, View view, ViewGroup viewGroup, T t, V v) {
        return W(i2, view, viewGroup, t, v);
    }

    public View T(int i2, View view, ViewGroup viewGroup, T t, V v) {
        return W(i2, view, viewGroup, t, v);
    }

    public View V(int i2, View view, ViewGroup viewGroup, T t, V v) {
        return W(i2, view, viewGroup, t, v);
    }

    public abstract View W(int i2, View view, ViewGroup viewGroup, T t, V v);

    public void X(int i2, ViewGroup viewGroup, V v, T t) {
        W(i2, v.a(), viewGroup, t, v);
    }

    public void Y(r<n> rVar) {
        this.j = rVar;
    }

    public void Z(w wVar) {
        this.f40320f = wVar;
    }

    public void a0(x xVar) {
        this.f40321g = xVar;
    }

    public void b0(BdUniqueId bdUniqueId) {
        this.f40323i = bdUniqueId;
    }

    public boolean d0(int i2, int i3, int i4) {
        return this.l.c(i2, i3, i4);
    }

    public ViewGroup.LayoutParams t(ViewGroup viewGroup) {
        if (viewGroup instanceof ListView) {
            return new AbsListView.LayoutParams(-1, -2);
        }
        if (viewGroup instanceof RecyclerView) {
            return new RecyclerView.LayoutParams(-1, -2);
        }
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public BdUniqueId u() {
        return null;
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

    public n y(int i2) {
        r<n> rVar = this.j;
        if (rVar != null) {
            return rVar.getItem(i2);
        }
        return null;
    }

    public w z() {
        return this.f40320f;
    }

    public a(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        this.f40319e = context;
        this.f40322h = bdUniqueId;
        this.f40323i = bdUniqueId2;
    }
}
