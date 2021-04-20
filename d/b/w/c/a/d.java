package d.b.w.c.a;

import android.content.res.Resources;
import android.util.Log;
import com.baidu.nps.interfa.IResourcesFetcher;
import com.baidu.nps.interfa.IResourcesFetcher_ResourcesFetcherManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public static d f65534b = new d();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.b0.a.b.c<IResourcesFetcher> f65535a;

    public d() {
        e();
    }

    public static d c() {
        return f65534b;
    }

    public Resources a() {
        if (d.b.w.h.b.a()) {
            Log.i("NPS-ResourcesFetcher", "resourcesFetcherHolder class=" + this.f65535a.getClass());
        }
        return this.f65535a.get().getBaseContextResources();
    }

    public Resources b() {
        return this.f65535a.get().getGlobalResources();
    }

    public Resources[] d() {
        return this.f65535a.get().getWrapperResources();
    }

    public void e() {
        d.b.b0.a.b.a b2 = d.b.b0.a.b.a.b();
        this.f65535a = b2;
        b2.a(new IResourcesFetcher_ResourcesFetcherManager_Provider());
    }
}
