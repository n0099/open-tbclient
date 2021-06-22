package d.a.f0.b.b;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceFetcher;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.ubc.UBC;
import d.a.o0.r1.p.h;
import d.a.q0.d0;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<ServiceReference, b<?>> f43541a = new ConcurrentHashMap<>();

    static {
        d();
    }

    public static <T> T a(ServiceReference serviceReference) {
        b<?> bVar = f43541a.get(serviceReference);
        if (bVar != null) {
            return (T) bVar.getService();
        }
        return null;
    }

    public static <T> void b(ServiceReference serviceReference, b<T> bVar) {
        f43541a.put(serviceReference, bVar);
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
        c("live", "ab", d.a.o0.r1.g.a.class);
        c("live", "account", d.a.o0.r1.b.a.class);
        c("live", DI.APP_INFO_NAME, d.a.o0.r1.c.a.class);
        c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, d.a.o0.r1.j.a.class);
        c("live", DI.EXT.EXT_LIVE_LOG, d.a.o0.r1.m.a.class);
        c("live", DI.FOLLOW_STATUS, d.a.o0.r1.i.a.class);
        c("live", DI.LIGHTBROWSER_VIEW, d.a.o0.r1.e.b.class);
        c("live", DI.LIVE_CUSTOM_SETTINGS, d.a.o0.r1.r.a.class);
        c("live", DI.LIVE_EVENT_DISPATCHER, d.a.o0.r1.h.a.class);
        c("live", DI.LIVE_LIKE, d.a.o0.r1.k.a.class);
        c("live", DI.LIVE_LOCATION, d.a.o0.r1.l.a.class);
        c("live", DI.LIVE_REAL_AUTH, d.a.o0.r1.d.a.class);
        c("live", DI.LIVE_SHOW_VIDEO_PLAYER, d.a.o0.r1.p.a.class);
        c("live", "net", d.a.o0.r1.n.a.class);
        c("live", DI.PAY_CHANNEL, d.a.o0.r1.f.a.class);
        c("live", DI.LIVE_PLAYER, h.class);
        c("live", DI.ROUTER_NAME, d.a.o0.r1.q.a.class);
        c("live", "share", d.a.o0.r1.s.c.class);
        c("live", DI.TB.SHARE_CHANNEL, d.a.o0.r1.s.a.class);
        c("live", DI.THIRD_PART_ACCOUNT, d.a.o0.r1.t.a.class);
        c("live", DI.YY.THIRD_PART_ALI_RECHARGE, d.a.o0.r1.u.a.a.class);
        c("live", DI.YY.THIRD_PART_WX_RECHARGE, d.a.o0.r1.u.b.a.class);
        c("live", "toast", d.a.o0.r1.v.a.class);
        c("live", DI.YYPAY.YY_PAY, d.a.o0.r1.o.a.class);
        c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
        c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, d0.class);
    }
}
