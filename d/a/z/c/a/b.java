package d.a.z.c.a;

import android.app.Application;
import com.baidu.nps.interfa.IHostAppRuntime;
import com.baidu.nps.interfa.IHostAppRuntime_HostAppRuntimeManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f68723b = new b();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.a.f0.a.b.c<IHostAppRuntime> f68724a;

    public b() {
        c();
    }

    public static b b() {
        return f68723b;
    }

    public Application a() {
        return this.f68724a.get().getApplication();
    }

    public void c() {
        d.a.f0.a.b.a b2 = d.a.f0.a.b.a.b();
        this.f68724a = b2;
        b2.a(new IHostAppRuntime_HostAppRuntimeManager_Provider());
    }
}
