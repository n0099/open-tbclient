package com.bytedance.sdk.openadsdk.l;

import android.content.Context;
import android.location.Address;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.net.tnc.ITTAdNetDepend;
import com.bytedance.sdk.openadsdk.core.j;
import java.util.Map;
/* loaded from: classes6.dex */
public class d implements ITTAdNetDepend {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f31350a;

    /* renamed from: b  reason: collision with root package name */
    public Context f31351b;

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
        this.f31350a = "sp_multi_ttadnet_config";
        this.f31351b = context;
    }

    @Override // com.bytedance.sdk.component.net.tnc.ITTAdNetDepend
    public int getAid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Integer.parseInt("1371") : invokeV.intValue;
    }

    @Override // com.bytedance.sdk.component.net.tnc.ITTAdNetDepend
    public String getChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "openadsdk" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.net.tnc.ITTAdNetDepend
    public String[] getConfigServers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new String[]{"tnc3-bjlgy.snssdk.com", "tnc3-alisc1.snssdk.com", "tnc3-aliec2.snssdk.com"} : (String[]) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.net.tnc.ITTAdNetDepend
    public Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f31351b : (Context) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.net.tnc.ITTAdNetDepend
    public String getDid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? j.a(this.f31351b) : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.net.tnc.ITTAdNetDepend
    public Address getLocationAdress(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return null;
        }
        return (Address) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.net.tnc.ITTAdNetDepend
    public String getPlatform() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? "android" : (String) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.component.net.tnc.ITTAdNetDepend
    public int getProviderInt(Context context, String str, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048583, this, context, str, i2)) == null) ? com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f31350a, str, i2) : invokeLLI.intValue;
    }

    @Override // com.bytedance.sdk.component.net.tnc.ITTAdNetDepend
    public String getProviderString(Context context, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context, str, str2)) == null) ? com.bytedance.sdk.openadsdk.multipro.d.a.b(this.f31350a, str, str2) : (String) invokeLLL.objValue;
    }

    @Override // com.bytedance.sdk.component.net.tnc.ITTAdNetDepend
    public int getVersionCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 3613;
        }
        return invokeV.intValue;
    }

    @Override // com.bytedance.sdk.component.net.tnc.ITTAdNetDepend
    public void saveMapToProvider(Context context, Map<String, ?> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, context, map) == null) || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Integer) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f31350a, entry.getKey(), (Integer) value);
                } else if (value instanceof Long) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f31350a, entry.getKey(), (Long) value);
                } else if (value instanceof Float) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f31350a, entry.getKey(), (Float) value);
                } else if (value instanceof Boolean) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f31350a, entry.getKey(), (Boolean) value);
                } else if (value instanceof String) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a(this.f31350a, entry.getKey(), (String) value);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
