package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.InetSocketAddress;
/* loaded from: classes10.dex */
public final class cq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f77273a;

    /* renamed from: a  reason: collision with other field name */
    public String f200a;

    public cq(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f200a = str;
        this.f77273a = i2;
    }

    public static cq a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, str, i2)) == null) {
            int lastIndexOf = str.lastIndexOf(":");
            if (lastIndexOf != -1) {
                String substring = str.substring(0, lastIndexOf);
                try {
                    int parseInt = Integer.parseInt(str.substring(lastIndexOf + 1));
                    if (parseInt > 0) {
                        i2 = parseInt;
                    }
                } catch (NumberFormatException unused) {
                }
                str = substring;
            }
            return new cq(str, i2);
        }
        return (cq) invokeLI.objValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static InetSocketAddress m229a(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) {
            cq a2 = a(str, i2);
            return new InetSocketAddress(a2.m230a(), a2.a());
        }
        return (InetSocketAddress) invokeLI.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f77273a : invokeV.intValue;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m230a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f200a : (String) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f77273a > 0) {
                return this.f200a + ":" + this.f77273a;
            }
            return this.f200a;
        }
        return (String) invokeV.objValue;
    }
}
