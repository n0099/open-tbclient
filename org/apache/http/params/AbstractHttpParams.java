package org.apache.http.params;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes3.dex */
public abstract class AbstractHttpParams implements HttpParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbstractHttpParams() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.http.params.HttpParams
    public boolean getBooleanParameter(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLZ.booleanValue;
    }

    @Override // org.apache.http.params.HttpParams
    public double getDoubleParameter(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeCommon.doubleValue;
    }

    @Override // org.apache.http.params.HttpParams
    public int getIntParameter(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLI.intValue;
    }

    @Override // org.apache.http.params.HttpParams
    public long getLongParameter(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeLJ.longValue;
    }

    @Override // org.apache.http.params.HttpParams
    public boolean isParameterFalse(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.booleanValue;
    }

    @Override // org.apache.http.params.HttpParams
    public boolean isParameterTrue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            throw new RuntimeException("Stub!");
        }
        return invokeL.booleanValue;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setBooleanParameter(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048582, this, str, z)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpParams) invokeLZ.objValue;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setDoubleParameter(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpParams) invokeCommon.objValue;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setIntParameter(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i2)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpParams) invokeLI.objValue;
    }

    @Override // org.apache.http.params.HttpParams
    public HttpParams setLongParameter(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048585, this, str, j)) == null) {
            throw new RuntimeException("Stub!");
        }
        return (HttpParams) invokeLJ.objValue;
    }
}
