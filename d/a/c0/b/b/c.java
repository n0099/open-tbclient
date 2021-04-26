package d.a.c0.b.b;

import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.YYPluginManageServiceFetcher;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.ubc.UBC;
import d.a.j0.q1.p.h;
import d.a.l0.d0;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final ConcurrentHashMap<ServiceReference, b<?>> f40464a = new ConcurrentHashMap<>();

    static {
        d();
    }

    public static <T> T a(ServiceReference serviceReference) {
        b<?> bVar = f40464a.get(serviceReference);
        if (bVar != null) {
            return (T) bVar.getService();
        }
        return null;
    }

    public static <T> void b(ServiceReference serviceReference, b<T> bVar) {
        f40464a.put(serviceReference, bVar);
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
        c("live", "ab", d.a.j0.q1.g.a.class);
        c("live", "account", d.a.j0.q1.b.a.class);
        c("live", DI.APP_INFO_NAME, d.a.j0.q1.c.a.class);
        c("live", DI.EXT.EXT_LIVE_JUMP_PAGE, d.a.j0.q1.j.a.class);
        c("live", DI.EXT.EXT_LIVE_LOG, d.a.j0.q1.m.a.class);
        c("live", DI.FOLLOW_STATUS, d.a.j0.q1.i.a.class);
        c("live", DI.LIGHTBROWSER_VIEW, d.a.j0.q1.e.b.class);
        c("live", DI.LIVE_CUSTOM_SETTINGS, d.a.j0.q1.r.a.class);
        c("live", DI.LIVE_EVENT_DISPATCHER, d.a.j0.q1.h.a.class);
        c("live", DI.LIVE_LIKE, d.a.j0.q1.k.a.class);
        c("live", DI.LIVE_LOCATION, d.a.j0.q1.l.a.class);
        c("live", DI.LIVE_REAL_AUTH, d.a.j0.q1.d.a.class);
        c("live", DI.LIVE_SHOW_VIDEO_PLAYER, d.a.j0.q1.p.a.class);
        c("live", "net", d.a.j0.q1.n.a.class);
        c("live", DI.PAY_CHANNEL, d.a.j0.q1.f.a.class);
        c("live", DI.LIVE_PLAYER, h.class);
        c("live", DI.ROUTER_NAME, d.a.j0.q1.q.a.class);
        c("live", "share", d.a.j0.q1.s.c.class);
        c("live", DI.TB.SHARE_CHANNEL, d.a.j0.q1.s.a.class);
        c("live", DI.THIRD_PART_ACCOUNT, d.a.j0.q1.t.a.class);
        c("live", DI.YY.THIRD_PART_ALI_RECHARGE, d.a.j0.q1.u.a.a.class);
        c("live", DI.YY.THIRD_PART_WX_RECHARGE, d.a.j0.q1.u.b.a.class);
        c("live", "toast", d.a.j0.q1.v.a.class);
        c("live", DI.YYPAY.YY_PAY, d.a.j0.q1.o.a.class);
        c("live", DI.YY.YY_PLUGIN, YYPluginManageServiceFetcher.class);
        c(UBCCloudControlProcessor.UBC_KEY, UBC.TAG, d0.class);
    }
}
