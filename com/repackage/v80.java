package com.repackage;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import com.repackage.g80;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class v80 extends s80 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g80.d b;

    public v80(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.a = context;
    }

    public void a(g80.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.b = dVar;
        }
    }

    @Override // com.repackage.u80.b
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Host", IMHttpDnsUrlRequest.HTTP_DNS_HOST);
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.repackage.u80.b
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? IMHttpDnsUrlRequest.HTTP_DNS_URL : (String) invokeV.objValue;
    }

    @Override // com.repackage.u80.b
    public String getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // com.repackage.s80, com.repackage.u80.b
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "GET" : (String) invokeV.objValue;
    }

    @Override // com.repackage.u80.b
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ("type=ipv4,ipv6&dn=" + k80.S(this.a).x).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.repackage.u80.d
    public void onFailure(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i, str) == null) {
            b90.b("LCPHttpDnsUrlRequest", "HttpDns failure errorcode:" + i + ",errormsg:" + str);
            g80.f(true);
            g80.c(this.a).b(k80.S(this.a).x, this.b);
        }
    }

    @Override // com.repackage.u80.d
    public void onSuccess(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            String str = new String(bArr);
            b90.a("LCPHttpDnsUrlRequest", "onSuccess----ip of " + k80.S(this.a).x + " is " + str);
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(k80.S(this.a).x);
                JSONArray optJSONArray = jSONObject.optJSONArray("ip");
                JSONArray optJSONArray2 = jSONObject.optJSONArray(HttpDnsCacheForHost.JSON_KEY_IPV6);
                int length = optJSONArray2 == null ? 0 : optJSONArray2.length();
                int length2 = optJSONArray == null ? 0 : optJSONArray.length();
                if (length2 + length > 0) {
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null && length2 > 0) {
                        arrayList.add(optJSONArray.getString(0));
                    }
                    if (optJSONArray2 != null && length > 0) {
                        arrayList.add(optJSONArray2.getString(0));
                    }
                    g80.j(arrayList);
                    if (this.b == null || g80.c.size() <= 0) {
                        return;
                    }
                    this.b.a(0, "ok", g80.c.get(0));
                    if (g80.c.size() > 1) {
                        g80.d++;
                        return;
                    }
                    return;
                }
                b90.b("LCPHttpDnsUrlRequest", "HttpDnsResponse ips is null ");
                g80.f(true);
                g80.c(this.a).b(k80.S(this.a).x, this.b);
            } catch (Exception e) {
                b90.b("LCPHttpDnsUrlRequest", "HttpDnsRequester ip parse exception " + e.getMessage());
                g80.f(true);
                g80.c(this.a).b(k80.S(this.a).x, this.b);
            }
        }
    }
}
