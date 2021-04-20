package d.b.w.c.a;

import android.app.Application;
import com.baidu.nps.interfa.IHostAppRuntime;
import com.baidu.nps.interfa.IHostAppRuntime_HostAppRuntimeManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f65530b = new b();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.b0.a.b.c<IHostAppRuntime> f65531a;

    public b() {
        c();
    }

    public static b b() {
        return f65530b;
    }

    public Application a() {
        return this.f65531a.get().getApplication();
    }

    public void c() {
        d.b.b0.a.b.a b2 = d.b.b0.a.b.a.b();
        this.f65531a = b2;
        b2.a(new IHostAppRuntime_HostAppRuntimeManager_Provider());
    }
}
