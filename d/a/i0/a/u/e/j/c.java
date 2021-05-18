package d.a.i0.a.u.e.j;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.net.NetRequestParam;
import com.baidu.searchbox.v8engine.net.NetRequestResult;
/* loaded from: classes2.dex */
public class c implements NetRequest.RequestInterceptor {
    @Override // com.baidu.searchbox.v8engine.net.NetRequest.RequestInterceptor
    public boolean shouldInterceptRequest(NetRequestResult netRequestResult, NetRequestParam netRequestParam) {
        if (netRequestParam == null) {
            return false;
        }
        String url = netRequestParam.getUrl();
        if (TextUtils.isEmpty(url)) {
            if (netRequestResult != null) {
                netRequestResult.setStatusCodeAndMsg(1001, "illegal url");
            }
            return true;
        }
        JsObject jsObject = netRequestParam.getJsObject();
        if (jsObject != null) {
            int propertyIndex = jsObject.getPropertyIndex("__plugin__");
            r2 = propertyIndex > 0 ? jsObject.toString(propertyIndex) : null;
            int c2 = d.a.i0.a.b2.a.b.c("request", url, r2);
            if (c2 != 0) {
                d.a.i0.a.u.h.b P = g.P(c2);
                netRequestResult.setStatusCodeAndMsg(P.f45062b, P.f45063c);
                return true;
            }
        }
        if (!TextUtils.isEmpty(r2)) {
            netRequestParam.addHeader("X-SWAN-HOSTSIGN", d.a.i0.a.t1.g.a.b(d.a.i0.a.t1.g.b.h(r2)));
        }
        netRequestParam.addHeader("Referer", h.d());
        netRequestParam.addHeader("User-Agent", d.a.i0.m.b.b().a());
        return false;
    }
}
