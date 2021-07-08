package com.qq.e.comm.net.rr;

import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.util.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class AbstractRequest implements Request {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f38041a;

    /* renamed from: b  reason: collision with root package name */
    public int f38042b;

    /* renamed from: c  reason: collision with root package name */
    public int f38043c;

    /* renamed from: d  reason: collision with root package name */
    public int f38044d;

    /* renamed from: e  reason: collision with root package name */
    public String f38045e;

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f38046f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f38047g;

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f38048h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f38049i;
    public Request.Method j;
    public byte[] k;

    public AbstractRequest(String str, Request.Method method, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, method, bArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38041a = true;
        this.f38046f = new HashMap();
        this.f38047g = new HashMap();
        this.f38048h = Collections.unmodifiableMap(this.f38046f);
        this.f38049i = Collections.unmodifiableMap(this.f38047g);
        this.f38045e = str;
        this.j = method;
        this.k = bArr == null ? null : (byte[]) bArr.clone();
    }

    public AbstractRequest(String str, Map<String, String> map, Request.Method method) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, map, method};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38041a = true;
        this.f38046f = new HashMap();
        this.f38047g = new HashMap();
        this.f38048h = Collections.unmodifiableMap(this.f38046f);
        this.f38049i = Collections.unmodifiableMap(this.f38047g);
        this.f38045e = str;
        this.j = method;
        if (Request.Method.POST == method) {
            StringBuilder sb = new StringBuilder();
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String encode = URLEncoder.encode(entry.getKey(), "utf-8");
                    String encode2 = URLEncoder.encode(entry.getValue(), "utf-8");
                    if (sb.length() > 0) {
                        sb.append("&");
                    }
                    sb.append(encode);
                    sb.append("=");
                    sb.append(encode2);
                }
                if (sb.length() > 0) {
                    this.k = sb.toString().getBytes("utf-8");
                    addHeader("Content-Type", "application/x-www-form-urlencoded");
                }
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addHeader(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        this.f38046f.put(str, str2);
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void addQuery(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            this.f38047g.put(str, str2);
        }
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getConnectionTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f38043c : invokeV.intValue;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f38048h : (Map) invokeV.objValue;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Request.Method getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.j : (Request.Method) invokeV.objValue;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public byte[] getPostData() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (byte[]) invokeV.objValue;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f38042b : invokeV.intValue;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public Map<String, String> getQuerys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38049i : (Map) invokeV.objValue;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public int getSocketTimeOut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f38044d : invokeV.intValue;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f38045e : (String) invokeV.objValue;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public String getUrlWithParas() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (getQuerys().isEmpty()) {
                return getUrl();
            }
            Uri.Builder buildUpon = Uri.parse(getUrl()).buildUpon();
            for (Map.Entry<String, String> entry : getQuerys().entrySet()) {
                buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            return buildUpon.build().toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.qq.e.comm.net.rr.Request
    public boolean isAutoClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f38041a : invokeV.booleanValue;
    }

    public void setAutoClose(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f38041a = z;
        }
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setConnectionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f38043c = i2;
        }
    }

    public void setPriority(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f38042b = i2;
        }
    }

    @Override // com.qq.e.comm.net.rr.Request
    public void setSocketTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.f38044d = i2;
        }
    }
}
