package d.b.x.c.a;

import android.app.Application;
import com.baidu.nps.interfa.IHostAppRuntime;
import com.baidu.nps.interfa.IHostAppRuntime_HostAppRuntimeManager_Provider;
import com.baidu.pyramid.annotation.Inject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f65794b = new b();
    @Inject

    /* renamed from: a  reason: collision with root package name */
    public d.b.c0.a.b.c<IHostAppRuntime> f65795a;

    public b() {
        c();
    }

    public static b b() {
        return f65794b;
    }

    public Application a() {
        return this.f65795a.get().getApplication();
    }

    public void c() {
        d.b.c0.a.b.a b2 = d.b.c0.a.b.a.b();
        this.f65795a = b2;
        b2.a(new IHostAppRuntime_HostAppRuntimeManager_Provider());
    }
}
