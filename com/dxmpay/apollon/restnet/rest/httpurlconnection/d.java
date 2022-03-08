package com.dxmpay.apollon.restnet.rest.httpurlconnection;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.http.HttpStatus;
import com.dxmpay.apollon.restnet.rest.e;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
/* loaded from: classes7.dex */
public class d implements e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public int f52292b;

    /* renamed from: c  reason: collision with root package name */
    public String f52293c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, List<String>> f52294d;

    /* renamed from: e  reason: collision with root package name */
    public com.dxmpay.apollon.restnet.http.a f52295e;

    /* renamed from: f  reason: collision with root package name */
    public InputStream f52296f;

    public d(InputStream inputStream, int i2, String str, Map<String, List<String>> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, Integer.valueOf(i2), str, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = inputStream;
        this.f52292b = i2;
        this.f52293c = str;
        this.f52294d = map;
    }

    private boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            String a = c().a();
            return !TextUtils.isEmpty(a) && a.contains("gzip");
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.apollon.restnet.rest.e
    public String a() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52293c : (String) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.restnet.rest.e
    public InputStream b() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (g()) {
                return a(this.a);
            }
            return this.a;
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.restnet.rest.e
    public com.dxmpay.apollon.restnet.http.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f52295e == null) {
                this.f52295e = new com.dxmpay.apollon.restnet.http.a(this.f52294d, false);
            }
            return this.f52295e;
        }
        return (com.dxmpay.apollon.restnet.http.a) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.restnet.rest.e
    public HttpStatus d() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? HttpStatus.valueOf(f()) : (HttpStatus) invokeV.objValue;
    }

    @Override // com.dxmpay.apollon.restnet.rest.e
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            InputStream inputStream = this.f52296f;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            InputStream inputStream2 = this.a;
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    public int f() throws IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f52292b : invokeV.intValue;
    }

    private InputStream a(InputStream inputStream) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, inputStream)) == null) {
            if (this.f52296f == null) {
                this.f52296f = new GZIPInputStream(inputStream);
            }
            return this.f52296f;
        }
        return (InputStream) invokeL.objValue;
    }
}
