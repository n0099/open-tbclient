package com.dxmpay.apollon.restnet;

import b.f.a.g.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.http.HttpStatus;
import java.util.List;
import kotlin.text.Typography;
/* loaded from: classes11.dex */
public class RestResponseEntity<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final HttpStatus f62150a;

    /* renamed from: b  reason: collision with root package name */
    public a f62151b;

    /* renamed from: c  reason: collision with root package name */
    public T f62152c;

    /* renamed from: d  reason: collision with root package name */
    public String f62153d;

    public RestResponseEntity(a aVar, HttpStatus httpStatus) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, httpStatus};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62151b = aVar;
        this.f62150a = httpStatus;
    }

    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62153d : (String) invokeV.objValue;
    }

    public String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            a aVar = this.f62151b;
            return aVar != null ? aVar.g(str) : "";
        }
        return (String) invokeL.objValue;
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f62153d = str;
        }
    }

    public T getBody() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f62152c : (T) invokeV.objValue;
    }

    public List<String> getHeaderValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            a aVar = this.f62151b;
            if (aVar != null) {
                return aVar.get(str);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            StringBuilder sb = new StringBuilder("<");
            sb.append(this.f62150a.toString());
            sb.append(' ');
            sb.append(this.f62150a.getReasonPhrase());
            sb.append(',');
            T body = getBody();
            a aVar = this.f62151b;
            if (body != null) {
                sb.append(body);
                if (aVar != null) {
                    sb.append(',');
                }
            }
            if (aVar != null) {
                sb.append(aVar);
            }
            sb.append(Typography.greater);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public RestResponseEntity(T t, a aVar, HttpStatus httpStatus) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t, aVar, httpStatus};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f62151b = aVar;
        this.f62152c = t;
        this.f62150a = httpStatus;
    }
}
