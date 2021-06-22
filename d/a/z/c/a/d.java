package d.a.z.c.a;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.nps.interfa.IResourcesFetcher;
import com.baidu.nps.interfa.IResourcesFetcher_ResourcesFetcherManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f68727b = new d();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.f0.a.b.c<IResourcesFetcher> f68728a;

    public d() {
        e();
    }

    public static d c() {
        return f68727b;
    }

    public Resources a() {
        if (d.a.z.i.b.a()) {
            Log.i("NPS-ResourcesFetcher", "resourcesFetcherHolder class=" + this.f68728a.getClass());
        }
        return this.f68728a.get().getBaseContextResources();
    }

    public Resources b() {
        return this.f68728a.get().getGlobalResources();
    }

    public Resources[] d() {
        return this.f68728a.get().getWrapperResources();
    }

    public void e() {
        d.a.f0.a.b.a b2 = d.a.f0.a.b.a.b();
        this.f68728a = b2;
        b2.a(new IResourcesFetcher_ResourcesFetcherManager_Provider());
    }
}
