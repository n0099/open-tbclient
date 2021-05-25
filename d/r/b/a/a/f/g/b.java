package d.r.b.a.a.f.g;

import android.content.Context;
import android.text.TextUtils;
import com.yy.mobile.framework.revenuesdk.baseapi.router.RouterInfo;
import d.r.b.a.a.f.d.d;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentHashMap<Integer, RouterInfo> f67764a = new ConcurrentHashMap<>();

    public static RouterInfo a(Context context, int i2) {
        d.g("RouterInfoCenter", "getRouterInfo routerInfoMap:%s", Integer.valueOf(f67764a.size()));
        RouterInfo routerInfo = f67764a.get(Integer.valueOf(i2));
        if (routerInfo != null && !TextUtils.isEmpty(routerInfo.serviceName)) {
            d.g("RouterInfoCenter", "getRouterInfo----1 cmd:%s, serviceName:%s, functionName:%s", Long.valueOf(routerInfo.cmd), routerInfo.serviceName, routerInfo.functionName);
            return routerInfo;
        }
        RouterInfo b2 = a.a().b(context, i2);
        if (b2 != null && !TextUtils.isEmpty(b2.serviceName)) {
            d.g("RouterInfoCenter", "getRouterInfo --- 2 cmd:%s, serviceName:%s, functionName:%s", Long.valueOf(b2.cmd), b2.serviceName, b2.functionName);
            return b2;
        }
        d.f("RouterInfoCenter", "getRouterInfo but routerInfo = null");
        return null;
    }
}
