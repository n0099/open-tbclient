package d.a.i0.r.f0.r;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter;
import com.baidu.tbadk.core.view.viewpager.BdBaseViewPagerAdapter.a;
import d.a.c.j.e.n;
/* loaded from: classes3.dex */
public abstract class b<T extends n, V extends BdBaseViewPagerAdapter.a> {

    /* renamed from: a  reason: collision with root package name */
    public Context f48933a;

    /* renamed from: b  reason: collision with root package name */
    public a<T, V> f48934b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f48935c;

    /* loaded from: classes3.dex */
    public interface a<T extends n, V extends BdBaseViewPagerAdapter.a> {
        void a(V v, T t);
    }

    public b(Context context, BdUniqueId bdUniqueId) {
        this.f48933a = context;
        this.f48935c = bdUniqueId;
    }

    public a<T, V> a() {
        return this.f48934b;
    }

    public BdUniqueId b() {
        return this.f48935c;
    }

    public abstract V c(ViewGroup viewGroup);

    public void d(V v, T t) {
    }

    public abstract View e(ViewGroup viewGroup, V v, T t);

    public void f(a<T, V> aVar) {
        this.f48934b = aVar;
    }
}
