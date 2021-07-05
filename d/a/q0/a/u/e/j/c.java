package d.a.q0.a.u.e.j;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.net.NetRequest;
import com.baidu.searchbox.v8engine.net.NetRequestParam;
import com.baidu.searchbox.v8engine.net.NetRequestResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c implements NetRequest.RequestInterceptor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.v8engine.net.NetRequest.RequestInterceptor
    public boolean shouldInterceptRequest(NetRequestResult netRequestResult, NetRequestParam netRequestParam) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, netRequestResult, netRequestParam)) == null) {
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
                int c2 = d.a.q0.a.b2.a.b.c("request", url, r2);
                if (c2 != 0) {
                    d.a.q0.a.u.h.b P = g.P(c2);
                    netRequestResult.setStatusCodeAndMsg(P.f51166b, P.f51167c);
                    return true;
                }
            }
            if (!TextUtils.isEmpty(r2)) {
                netRequestParam.addHeader("X-SWAN-HOSTSIGN", d.a.q0.a.t1.g.a.b(d.a.q0.a.t1.g.b.h(r2)));
            }
            netRequestParam.addHeader("Referer", h.d());
            netRequestParam.addHeader("User-Agent", d.a.q0.m.b.b().a());
            return false;
        }
        return invokeLL.booleanValue;
    }
}
