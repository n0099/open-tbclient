package com.bytedance.sdk.openadsdk.preload.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.math.BigInteger;
/* loaded from: classes5.dex */
public final class q extends l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Object f32265a;

    public q(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bool};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f32265a = com.bytedance.sdk.openadsdk.preload.a.b.a.a(bool);
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public Number a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Object obj = this.f32265a;
            return obj instanceof String ? new com.bytedance.sdk.openadsdk.preload.a.b.g((String) this.f32265a) : (Number) obj;
        }
        return (Number) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (o()) {
                return a().toString();
            }
            if (n()) {
                return ((Boolean) this.f32265a).toString();
            }
            return (String) this.f32265a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public double c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? o() ? a().doubleValue() : Double.parseDouble(b()) : invokeV.doubleValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? o() ? a().longValue() : Long.parseLong(b()) : invokeV.longValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? o() ? a().intValue() : Integer.parseInt(b()) : invokeV.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || q.class != obj.getClass()) {
                return false;
            }
            q qVar = (q) obj;
            if (this.f32265a == null) {
                return qVar.f32265a == null;
            } else if (a(this) && a(qVar)) {
                return a().longValue() == qVar.a().longValue();
            } else if ((this.f32265a instanceof Number) && (qVar.f32265a instanceof Number)) {
                double doubleValue = a().doubleValue();
                double doubleValue2 = qVar.a().doubleValue();
                if (doubleValue != doubleValue2) {
                    return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
                }
                return true;
            } else {
                return this.f32265a.equals(qVar.f32265a);
            }
        }
        return invokeL.booleanValue;
    }

    @Override // com.bytedance.sdk.openadsdk.preload.a.l
    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (n()) {
                return ((Boolean) this.f32265a).booleanValue();
            }
            return Boolean.parseBoolean(b());
        }
        return invokeV.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        long doubleToLongBits;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.f32265a == null) {
                return 31;
            }
            if (a(this)) {
                doubleToLongBits = a().longValue();
            } else {
                Object obj = this.f32265a;
                if (obj instanceof Number) {
                    doubleToLongBits = Double.doubleToLongBits(a().doubleValue());
                } else {
                    return obj.hashCode();
                }
            }
            return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
        }
        return invokeV.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f32265a instanceof Boolean : invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f32265a instanceof Number : invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f32265a instanceof String : invokeV.booleanValue;
    }

    public static boolean a(q qVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, qVar)) == null) {
            Object obj = qVar.f32265a;
            if (obj instanceof Number) {
                Number number = (Number) obj;
                return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public q(Number number) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {number};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f32265a = com.bytedance.sdk.openadsdk.preload.a.b.a.a(number);
    }

    public q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f32265a = com.bytedance.sdk.openadsdk.preload.a.b.a.a(str);
    }
}
