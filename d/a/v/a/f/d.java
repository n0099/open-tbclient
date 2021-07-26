package d.a.v.a.f;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMHttpDnsUrlRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.daemon.HttpDnsCacheForHost;
import d.a.v.a.c.a;
import d.a.v.a.c.f;
import d.a.v.a.h.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a.d f68426b;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68426b = null;
        this.f68422a = context;
    }

    public void a(a.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, dVar) == null) {
            this.f68426b = dVar;
        }
    }

    @Override // d.a.v.a.f.c.b
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

    @Override // d.a.v.a.f.c.b
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? IMHttpDnsUrlRequest.HTTP_DNS_URL : (String) invokeV.objValue;
    }

    @Override // d.a.v.a.f.c.b
    public String getMediaType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "application/x-www-form-urlencoded" : (String) invokeV.objValue;
    }

    @Override // d.a.v.a.f.a, d.a.v.a.f.c.b
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "GET" : (String) invokeV.objValue;
    }

    @Override // d.a.v.a.f.c.b
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ("type=ipv4,ipv6&dn=" + f.S(this.f68422a).x).getBytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // d.a.v.a.f.c.d
    public void onFailure(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048582, this, i2, str) == null) {
            e.b("LCPHttpDnsUrlRequest", "HttpDns failure errorcode:" + i2 + ",errormsg:" + str);
            d.a.v.a.c.a.f(true);
            d.a.v.a.c.a.c(this.f68422a).b(f.S(this.f68422a).x, this.f68426b);
        }
    }

    @Override // d.a.v.a.f.c.d
    public void onSuccess(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            String str = new String(bArr);
            e.a("LCPHttpDnsUrlRequest", "onSuccess----ip of " + f.S(this.f68422a).x + " is " + str);
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("data").getJSONObject(f.S(this.f68422a).x);
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
                    d.a.v.a.c.a.j(arrayList);
                    if (this.f68426b == null || d.a.v.a.c.a.f68352c.size() <= 0) {
                        return;
                    }
                    this.f68426b.a(0, "ok", d.a.v.a.c.a.f68352c.get(0));
                    if (d.a.v.a.c.a.f68352c.size() > 1) {
                        d.a.v.a.c.a.f68353d++;
                        return;
                    }
                    return;
                }
                e.b("LCPHttpDnsUrlRequest", "HttpDnsResponse ips is null ");
                d.a.v.a.c.a.f(true);
                d.a.v.a.c.a.c(this.f68422a).b(f.S(this.f68422a).x, this.f68426b);
            } catch (Exception e2) {
                e.b("LCPHttpDnsUrlRequest", "HttpDnsRequester ip parse exception " + e2.getMessage());
                d.a.v.a.c.a.f(true);
                d.a.v.a.c.a.c(this.f68422a).b(f.S(this.f68422a).x, this.f68426b);
            }
        }
    }
}
