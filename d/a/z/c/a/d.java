package d.a.z.c.a;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.nps.interfa.IResourcesFetcher;
import com.baidu.nps.interfa.IResourcesFetcher_ResourcesFetcherManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f68623b = new d();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.e0.a.b.c<IResourcesFetcher> f68624a;

    public d() {
        e();
    }

    public static d c() {
        return f68623b;
    }

    public Resources a() {
        if (d.a.z.i.b.a()) {
            Log.i("NPS-ResourcesFetcher", "resourcesFetcherHolder class=" + this.f68624a.getClass());
        }
        return this.f68624a.get().getBaseContextResources();
    }

    public Resources b() {
        return this.f68624a.get().getGlobalResources();
    }

    public Resources[] d() {
        return this.f68624a.get().getWrapperResources();
    }

    public void e() {
        d.a.e0.a.b.a b2 = d.a.e0.a.b.a.b();
        this.f68624a = b2;
        b2.a(new IResourcesFetcher_ResourcesFetcherManager_Provider());
    }
}
