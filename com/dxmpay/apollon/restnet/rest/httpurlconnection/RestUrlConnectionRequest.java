package com.dxmpay.apollon.restnet.rest.httpurlconnection;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.f.a.g.c.a;
import b.f.a.g.d.d;
import b.f.a.g.d.e;
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
/* loaded from: classes11.dex */
public class RestUrlConnectionRequest implements d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final RestHttpNetwork f62165a;

    /* renamed from: b  reason: collision with root package name */
    public final a f62166b;

    /* renamed from: c  reason: collision with root package name */
    public String f62167c;

    /* renamed from: d  reason: collision with root package name */
    public HttpDefines$HttpMethod f62168d;

    /* renamed from: e  reason: collision with root package name */
    public String f62169e;

    /* renamed from: f  reason: collision with root package name */
    public String f62170f;

    /* renamed from: g  reason: collision with root package name */
    public List<RestNameValuePair> f62171g;

    /* renamed from: h  reason: collision with root package name */
    public RestMultipartEntity f62172h;

    /* renamed from: i  reason: collision with root package name */
    public int f62173i;

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
        this.f62166b = new a();
        this.f62173i = -1;
        this.f62165a = restHttpNetwork;
        this.f62167c = str2;
        this.f62168d = httpDefines$HttpMethod;
        this.f62169e = str;
        this.f62171g = list;
        this.f62172h = restMultipartEntity;
    }

    @Override // b.f.a.g.d.d
    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62166b : (a) invokeV.objValue;
    }

    @Override // b.f.a.g.d.d
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62169e : (String) invokeV.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.f62169e = str;
        }
    }

    @Override // b.f.a.g.d.d
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f62167c : (String) invokeV.objValue;
    }

    @Override // b.f.a.g.d.d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f62165a.a();
        }
    }

    @Override // b.f.a.g.d.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f62170f : (String) invokeV.objValue;
    }

    public RestMultipartEntity g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f62172h : (RestMultipartEntity) invokeV.objValue;
    }

    public String getProcessedParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            List<RestNameValuePair> list = this.f62171g;
            if (list == null || list.size() == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (RestNameValuePair restNameValuePair : this.f62171g) {
                String name = restNameValuePair.getName();
                String value = restNameValuePair.getValue();
                if (!TextUtils.isEmpty(name)) {
                    if (value == null) {
                        value = "";
                    }
                    try {
                        sb.append(URLEncoder.encode(name, this.f62167c));
                        sb.append(com.alipay.sdk.encrypt.a.f34124h);
                        sb.append(URLEncoder.encode(value, this.f62167c));
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f62168d : (HttpDefines$HttpMethod) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f62173i : invokeV.intValue;
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

    @Override // b.f.a.g.d.d
    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f62173i = i2;
        }
    }

    @Override // b.f.a.g.d.d
    public e c() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Thread.currentThread().isInterrupted()) {
                return null;
            }
            return this.f62165a.a(this);
        }
        return (e) invokeV.objValue;
    }

    @Override // b.f.a.g.d.d
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f62170f = str;
        }
    }
}
