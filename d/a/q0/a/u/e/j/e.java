package d.a.q0.a.u.e.j;

import com.baidu.searchbox.v8engine.net.NetInfo;
import com.baidu.searchbox.v8engine.net.NetRequestResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.j2.k;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes8.dex */
public class e implements Observer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public e() {
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

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, observable, obj) == null) && (obj instanceof NetRequestResult)) {
            NetRequestResult netRequestResult = (NetRequestResult) obj;
            String url = netRequestResult.getUrl();
            String valueOf = String.valueOf(netRequestResult.getId());
            if (netRequestResult.getStatusCode() == 4 && url != null) {
                d.a.q0.a.h0.q.b.g().k(valueOf, url);
            }
            NetInfo netInfo = netRequestResult.getNetInfo();
            if (netRequestResult.getFromType() == 1 && url != null && netInfo != null) {
                d.a.q0.a.h0.q.b.g().t(valueOf, url, netInfo);
            }
            int statusCode = netRequestResult.getStatusCode();
            if (statusCode < 0 || statusCode >= 400) {
                String statusMsg = netRequestResult.getStatusMsg();
                NetInfo.Response response = netInfo.getResponse();
                NetInfo.Base base = netInfo.getBase();
                StringBuilder sb = new StringBuilder();
                sb.append(statusMsg);
                sb.append("; code=");
                sb.append(response != null ? Integer.valueOf(response.mCode) : "");
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append("; status=");
                sb3.append(base != null ? Integer.valueOf(base.mStatus) : "");
                k.J(statusCode, netRequestResult.getUrl(), 0, sb3.toString(), 0L, 0L);
            }
        }
    }
}
