package d.b.b0.b.b;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.ubc.UBC;
import d.b.i0.q1.n.h;
import d.b.k0.c0;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final HashMap<ServiceReference, b<?>> f41961a = new HashMap<>();

    static {
        d();
    }

    public static <T> T a(ServiceReference serviceReference) {
        b<?> bVar = f41961a.get(serviceReference);
        if (bVar != null) {
            return (T) bVar.getService();
        }
        return null;
    }

    public static <T> void b(ServiceReference serviceReference, b<T> bVar) {
        synchronized (f41961a) {
            f41961a.put(serviceReference, bVar);
        }
    }

    public static <T> void c(String str, String str2, Class<? extends b<T>> cls) {
        try {
            b(new ServiceReference(str, str2), cls.newInstance());
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
    }

    public static void d() {
        c("live", "ab", d.b.i0.q1.g.a.class);
        c("live", "account", d.b.i0.q1.b.a.class);
        c("live", DI.APP_INFO_NAME, d.b.i0.q1.c.a.class);
        c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, d.b.i0.q1.j.a.class);
        c("live", DI.EXT.EXT_LIVE_LOG, d.b.i0.q1.l.a.class);
        c("live", DI.FOLLOW_STATUS, d.b.i0.q1.i.a.class);
        c("live", DI.LIGHTBROWSER_VIEW, d.b.i0.q1.e.b.class);
        c("live", DI.LIVE_CUSTOM_SETTINGS, d.b.i0.q1.p.a.class);
        c("live", DI.LIVE_LOCATION, d.b.i0.q1.k.a.class);
        c("live", DI.LIVE_REAL_AUTH, d.b.i0.q1.d.a.class);
        c("live", DI.LIVE_SHOW_VIDEO_PLAYER, d.b.i0.q1.n.a.class);
        c("live", DI.LIVE_EVENT_DISPATCHER, d.b.i0.q1.h.a.class);
        c("live", "net", d.b.i0.q1.m.a.class);
        c("live", DI.PAY_CHANNEL, d.b.i0.q1.f.a.class);
        c("live", DI.LIVE_PLAYER, h.class);
        c("live", DI.ROUTER_NAME, d.b.i0.q1.o.a.class);
        c("live", "share", d.b.i0.q1.q.c.class);
        c("live", DI.TB.SHARE_CHANNEL, d.b.i0.q1.q.a.class);
        c("live", "toast", d.b.i0.q1.r.a.class);
        c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, c0.class);
    }
}
