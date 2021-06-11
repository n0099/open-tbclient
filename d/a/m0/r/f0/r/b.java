package d.a.m0.r.f0.r;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import d.a.c.k.e.n;
/* loaded from: classes3.dex */
public abstract class b<T extends n, V extends BdBaseViewPagerAdapter.a> {

    /* renamed from: a  reason: collision with root package name */
    public Context f53482a;

    /* renamed from: b  reason: collision with root package name */
    public a<T, V> f53483b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f53484c;

    /* loaded from: classes3.dex */
    public interface a<T extends n, V extends BdBaseViewPagerAdapter.a> {
        void a(V v, T t);
    }

    public b(Context context, BdUniqueId bdUniqueId) {
        this.f53482a = context;
        this.f53484c = bdUniqueId;
    }

    public a<T, V> a() {
        return this.f53483b;
    }

    public BdUniqueId b() {
        return this.f53484c;
    }

    public abstract V c(ViewGroup viewGroup);

    public void d(V v, T t) {
    }

    public abstract View e(ViewGroup viewGroup, V v, T t);

    public void f(a<T, V> aVar) {
        this.f53483b = aVar;
    }
}
