package com.dxmpay.apollon.restnet.rest.httpurlconnection;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.RestMultipartEntity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.http.HttpDefines;
import com.dxmpay.apollon.restnet.rest.RestHttpNetwork;
import com.dxmpay.apollon.restnet.rest.e;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
/* loaded from: classes7.dex */
public class RestUrlConnectionRequest implements com.dxmpay.apollon.restnet.rest.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RestHttpNetwork a;

    /* renamed from: b  reason: collision with root package name */
    public final com.dxmpay.apollon.restnet.http.a f52279b;

    /* renamed from: c  reason: collision with root package name */
    public String f52280c;

    /* renamed from: d  reason: collision with root package name */
    public HttpDefines.HttpMethod f52281d;

    /* renamed from: e  reason: collision with root package name */
    public String f52282e;

    /* renamed from: f  reason: collision with root package name */
    public String f52283f;

    /* renamed from: g  reason: collision with root package name */
    public List<RestNameValuePair> f52284g;

    /* renamed from: h  reason: collision with root package name */
    public RestMultipartEntity f52285h;

    /* renamed from: i  reason: collision with root package name */
    public int f52286i;

    public RestUrlConnectionRequest(RestHttpNetwork restHttpNetwork, String str, HttpDefines.HttpMethod httpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {restHttpNetwork, str, httpMethod, list, restMultipartEntity, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52279b = new com.dxmpay.apollon.restnet.http.a();
        this.f52286i = -1;
        this.a = restHttpNetwork;
        this.f52280c = str2;
        this.f52281d = httpMethod;
        this.f52282e = str;
        this.f52284g = list;
        this.f52285h = restMultipartEntity;
    }

    @Override // com.dxmpay.apollon.restnet.rest.d
    public com.dxmpay.apollon.restnet.http.a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52279b : (com.dxmpay.apollon.restnet.http.a) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.restnet.rest.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52282e : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.restnet.rest.d
    public e c() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (Thread.currentThread().isInterrupted()) {
                return null;
            }
            return this.a.a(this);
        }
        return (e) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.restnet.rest.d
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f52280c : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.restnet.rest.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.a();
        }
    }

    @Override // com.dxmpay.apollon.restnet.rest.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f52283f : (String) invokeV.objValue;
    }

    public RestMultipartEntity g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f52285h : (RestMultipartEntity) invokeV.objValue;
    }

    public String getProcessedParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            List<RestNameValuePair> list = this.f52284g;
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (RestNameValuePair restNameValuePair : this.f52284g) {
                String name = restNameValuePair.getName();
                String value = restNameValuePair.getValue();
                if (!TextUtils.isEmpty(name)) {
                    if (value == null) {
                        value = "";
                    }
                    try {
                        sb.append(URLEncoder.encode(name, this.f52280c));
                        sb.append(com.alipay.sdk.encrypt.a.f29503h);
                        sb.append(URLEncoder.encode(value, this.f52280c));
                        sb.append('&');
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (sb.length() > 1) {
                sb.replace(sb.length() - 1, sb.length(), "");
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public HttpDefines.HttpMethod h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f52281d : (HttpDefines.HttpMethod) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f52286i : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? h() == HttpDefines.HttpMethod.POST : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? h() == HttpDefines.HttpMethod.GET : invokeV.booleanValue;
    }

    @Override // com.dxmpay.apollon.restnet.rest.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f52286i = i2;
        }
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f52282e = str;
        }
    }

    @Override // com.dxmpay.apollon.restnet.rest.d
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f52283f = str;
        }
    }
}
