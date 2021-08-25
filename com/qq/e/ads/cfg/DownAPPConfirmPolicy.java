package com.qq.e.ads.cfg;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class DownAPPConfirmPolicy {
    public static /* synthetic */ Interceptable $ic;
    public static final DownAPPConfirmPolicy Default;
    public static final DownAPPConfirmPolicy NOConfirm;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ DownAPPConfirmPolicy[] f74940b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f74941a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-827809601, "Lcom/qq/e/ads/cfg/DownAPPConfirmPolicy;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-827809601, "Lcom/qq/e/ads/cfg/DownAPPConfirmPolicy;");
                return;
            }
        }
        Default = new DownAPPConfirmPolicy("Default", 0, 0);
        DownAPPConfirmPolicy downAPPConfirmPolicy = new DownAPPConfirmPolicy("NOConfirm", 1, 2);
        NOConfirm = downAPPConfirmPolicy;
        f74940b = new DownAPPConfirmPolicy[]{Default, downAPPConfirmPolicy};
    }

    public DownAPPConfirmPolicy(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f74941a = i3;
    }

    public static DownAPPConfirmPolicy valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DownAPPConfirmPolicy) Enum.valueOf(DownAPPConfirmPolicy.class, str) : (DownAPPConfirmPolicy) invokeL.objValue;
    }

    public static DownAPPConfirmPolicy[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DownAPPConfirmPolicy[]) f74940b.clone() : (DownAPPConfirmPolicy[]) invokeV.objValue;
    }

    public final int value() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f74941a : invokeV.intValue;
    }
}
