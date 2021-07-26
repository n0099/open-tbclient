package d.a.o0.a.p.c;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import okhttp3.HttpUrl;
/* loaded from: classes7.dex */
public class o extends d.a.o0.a.c1.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public o() {
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

    @Override // d.a.o0.a.p.d.a0
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public long B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0L;
        }
        return invokeV.longValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public HttpRequest C(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, map)) == null) ? M("ma/accredit_v1", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? d.a.o0.a.d0.c.w(String.format("%s/ma/grs/brand/applist", N()), true) : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public HttpRequest J(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, map)) == null) ? M("ma/user/openid", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? String.format("%s/ma/ai", N()) : (String) invokeV.objValue;
    }

    public final HttpRequest M(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, map)) == null) {
            HttpUrl parse = HttpUrl.parse(N());
            if (parse == null) {
                return null;
            }
            HttpUrl.Builder addPathSegments = parse.newBuilder().addPathSegments(str);
            for (Map.Entry<String, String> entry : d.a.o0.a.d0.b.b().f44444d.entrySet()) {
                addPathSegments.addQueryParameter(entry.getKey(), entry.getValue());
            }
            HttpUrl build = addPathSegments.build();
            d.a.o0.m.d.a aVar = new d.a.o0.m.d.a();
            aVar.f51098b = "POST";
            aVar.f51097a = d.a.o0.a.d0.c.w(build.toString(), true);
            aVar.f51100d = d.a.o0.a.e2.c.d.b(map);
            aVar.f51102f = true;
            aVar.f51103g = true;
            aVar.f51104h = false;
            HttpRequestBuilder a2 = d.a.o0.m.e.b.a(aVar);
            d.a.o0.m.e.a.g().t(a2, aVar);
            return a2.build();
        }
        return (HttpRequest) invokeLL.objValue;
    }

    public final String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? d.a.o0.a.d0.c.f44445a : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public HttpRequest a(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, map)) == null) ? M("ma/user/checksessionkey", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? d.a.o0.a.d0.c.w(String.format("%s/ma/update", N()), true) : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? d.a.o0.a.d0.c.v(String.format("%s/ma/history/sync", N())) : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? String.format("%s/ma/component/comment/bos_auth", "https://ossapi.baidu.com") : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public HttpRequest g(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, context, map)) == null) ? M("ma/user/swanid", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? d.a.o0.a.c1.a.m().a() : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public HttpRequest o(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, context, map)) == null) ? M("ma/accredit_data", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public HttpRequest r(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, context, map)) == null) ? M("ma/login", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public HttpRequest s(Context context, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, context, map)) == null) ? M("ma/open/data", map) : (HttpRequest) invokeLL.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? d.a.o0.a.d0.c.v(String.format("%s/ma/reset", N())) : (String) invokeV.objValue;
    }

    @Override // d.a.o0.a.p.d.a0
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? d.a.o0.a.d0.c.v(String.format("%s/api/subscribe/v1/relation/get", d.a.o0.a.d0.a.c())) : (String) invokeV.objValue;
    }
}
