package com.dxmpay.apollon.restnet.rest.httpurlconnection;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.f.a.g.c.a;
import c.f.a.g.d.d;
import c.f.a.g.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.RestMultipartEntity;
import com.dxmpay.apollon.restnet.RestNameValuePair;
import com.dxmpay.apollon.restnet.http.HttpDefines$HttpMethod;
import com.dxmpay.apollon.restnet.rest.RestHttpNetwork;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes9.dex */
public class RestUrlConnectionRequest implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final RestHttpNetwork f69728a;

    /* renamed from: b  reason: collision with root package name */
    public final a f69729b;

    /* renamed from: c  reason: collision with root package name */
    public String f69730c;

    /* renamed from: d  reason: collision with root package name */
    public HttpDefines$HttpMethod f69731d;

    /* renamed from: e  reason: collision with root package name */
    public String f69732e;

    /* renamed from: f  reason: collision with root package name */
    public String f69733f;

    /* renamed from: g  reason: collision with root package name */
    public List<RestNameValuePair> f69734g;

    /* renamed from: h  reason: collision with root package name */
    public RestMultipartEntity f69735h;

    /* renamed from: i  reason: collision with root package name */
    public int f69736i;

    public RestUrlConnectionRequest(RestHttpNetwork restHttpNetwork, String str, HttpDefines$HttpMethod httpDefines$HttpMethod, List<RestNameValuePair> list, RestMultipartEntity restMultipartEntity, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {restHttpNetwork, str, httpDefines$HttpMethod, list, restMultipartEntity, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69729b = new a();
        this.f69736i = -1;
        this.f69728a = restHttpNetwork;
        this.f69730c = str2;
        this.f69731d = httpDefines$HttpMethod;
        this.f69732e = str;
        this.f69734g = list;
        this.f69735h = restMultipartEntity;
    }

    @Override // c.f.a.g.d.d
    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f69729b : (a) invokeV.objValue;
    }

    @Override // c.f.a.g.d.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f69732e : (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f69732e = str;
        }
    }

    @Override // c.f.a.g.d.d
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f69730c : (String) invokeV.objValue;
    }

    @Override // c.f.a.g.d.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f69728a.a();
        }
    }

    @Override // c.f.a.g.d.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f69733f : (String) invokeV.objValue;
    }

    public RestMultipartEntity g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f69735h : (RestMultipartEntity) invokeV.objValue;
    }

    public String getProcessedParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            List<RestNameValuePair> list = this.f69734g;
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (RestNameValuePair restNameValuePair : this.f69734g) {
                String name = restNameValuePair.getName();
                String value = restNameValuePair.getValue();
                if (!TextUtils.isEmpty(name)) {
                    if (value == null) {
                        value = "";
                    }
                    try {
                        sb.append(URLEncoder.encode(name, this.f69730c));
                        sb.append(com.alipay.sdk.encrypt.a.f36026h);
                        sb.append(URLEncoder.encode(value, this.f69730c));
                        sb.append(Typography.amp);
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

    public HttpDefines$HttpMethod h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f69731d : (HttpDefines$HttpMethod) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f69736i : invokeV.intValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? h() == HttpDefines$HttpMethod.POST : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? h() == HttpDefines$HttpMethod.GET : invokeV.booleanValue;
    }

    @Override // c.f.a.g.d.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f69736i = i2;
        }
    }

    @Override // c.f.a.g.d.d
    public e c() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Thread.currentThread().isInterrupted()) {
                return null;
            }
            return this.f69728a.a(this);
        }
        return (e) invokeV.objValue;
    }

    @Override // c.f.a.g.d.d
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f69733f = str;
        }
    }
}
