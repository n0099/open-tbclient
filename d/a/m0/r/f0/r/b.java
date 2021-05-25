package d.a.m0.r.f0.r;

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
    public Context f49807a;

    /* renamed from: b  reason: collision with root package name */
    public a<T, V> f49808b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f49809c;

    /* loaded from: classes3.dex */
    public interface a<T extends n, V extends BdBaseViewPagerAdapter.a> {
        void a(V v, T t);
    }

    public b(Context context, BdUniqueId bdUniqueId) {
        this.f49807a = context;
        this.f49809c = bdUniqueId;
    }

    public a<T, V> a() {
        return this.f49808b;
    }

    public BdUniqueId b() {
        return this.f49809c;
    }

    public abstract V c(ViewGroup viewGroup);

    public void d(V v, T t) {
    }

    public abstract View e(ViewGroup viewGroup, V v, T t);

    public void f(a<T, V> aVar) {
        this.f49808b = aVar;
    }
}
