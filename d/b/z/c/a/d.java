package d.b.z.c.a;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.nps.interfa.IResourcesFetcher;
import com.baidu.nps.interfa.IResourcesFetcher_ResourcesFetcherManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f64869b = new d();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.d0.a.b.c<IResourcesFetcher> f64870a;

    public d() {
        e();
    }

    public static d c() {
        return f64869b;
    }

    public Resources a() {
        if (d.b.z.h.b.a()) {
            Log.i("NPS-ResourcesFetcher", "resourcesFetcherHolder class=" + this.f64870a.getClass());
        }
        return this.f64870a.get().getBaseContextResources();
    }

    public Resources b() {
        return this.f64870a.get().getGlobalResources();
    }

    public Resources[] d() {
        return this.f64870a.get().getWrapperResources();
    }

    public void e() {
        d.b.d0.a.b.a b2 = d.b.d0.a.b.a.b();
        this.f64870a = b2;
        b2.a(new IResourcesFetcher_ResourcesFetcherManager_Provider());
    }
}
