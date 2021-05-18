package d.a.x.c.a;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.nps.interfa.IResourcesFetcher;
import com.baidu.nps.interfa.IResourcesFetcher_ResourcesFetcherManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f64839b = new d();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.c0.a.b.c<IResourcesFetcher> f64840a;

    public d() {
        e();
    }

    public static d c() {
        return f64839b;
    }

    public Resources a() {
        if (d.a.x.i.b.a()) {
            Log.i("NPS-ResourcesFetcher", "resourcesFetcherHolder class=" + this.f64840a.getClass());
        }
        return this.f64840a.get().getBaseContextResources();
    }

    public Resources b() {
        return this.f64840a.get().getGlobalResources();
    }

    public Resources[] d() {
        return this.f64840a.get().getWrapperResources();
    }

    public void e() {
        d.a.c0.a.b.a b2 = d.a.c0.a.b.a.b();
        this.f64840a = b2;
        b2.a(new IResourcesFetcher_ResourcesFetcherManager_Provider());
    }
}
