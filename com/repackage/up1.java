package com.repackage;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.net.NetInfo;
import com.baidu.searchbox.v8engine.net.NetRequestResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes7.dex */
public class up1 implements Observer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public up1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final String a(@NonNull NetInfo netInfo, @NonNull NetRequestResult netRequestResult, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, netInfo, netRequestResult, i)) == null) {
            if (i == 200) {
                return "";
            }
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
            return sb3.toString();
        }
        return (String) invokeLLI.objValue;
    }

    @Override // java.util.Observer
    @SuppressLint({"BDThrowableCheck"})
    public void update(Observable observable, Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, observable, obj) == null) && (obj instanceof NetRequestResult)) {
            NetRequestResult netRequestResult = (NetRequestResult) obj;
            String url = netRequestResult.getUrl();
            String valueOf = String.valueOf(netRequestResult.getId());
            int statusCode = netRequestResult.getStatusCode();
            if (statusCode == 3) {
                t52.D(valueOf, 0L, netRequestResult.getCreatedTime(), 0L);
            } else if (statusCode != 4) {
                if (statusCode == 5) {
                    t52.D(valueOf, 0L, 0L, netRequestResult.getCreatedTime());
                } else if (statusCode == 6) {
                    t52.D(valueOf, netRequestResult.getCreatedTime(), 0L, 0L);
                }
            } else if (url != null) {
                t52.k().q(valueOf, url);
            }
            NetInfo netInfo = netRequestResult.getNetInfo();
            int statusCode2 = netRequestResult.getStatusCode();
            if (netRequestResult.getFromType() != 1 || url == null || netInfo == null) {
                if (netInfo != null) {
                    if (statusCode2 < 0 || statusCode2 >= 400) {
                        c73.P(statusCode2, netRequestResult.getUrl(), 0, a(netInfo, netRequestResult, statusCode2), 0L, 0L, valueOf);
                        return;
                    }
                    return;
                }
                return;
            }
            t52.k().B(valueOf, url, netInfo);
            long l = t52.k().l(valueOf);
            long currentTimeMillis = System.currentTimeMillis();
            String e = de3.n().e();
            c73.Q(statusCode2, netRequestResult.getUrl(), 0, a(netInfo, netRequestResult, statusCode2), c73.l(), e, l, currentTimeMillis, valueOf);
        }
    }
}
