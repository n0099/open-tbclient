package com.win.opensdk;

import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class y {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final y f42702a;

    /* renamed from: b  reason: collision with root package name */
    public static final y f42703b;

    /* renamed from: c  reason: collision with root package name */
    public static final y f42704c;

    /* renamed from: d  reason: collision with root package name */
    public static final y f42705d;

    /* renamed from: e  reason: collision with root package name */
    public static final y f42706e;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ y[] f42707f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1471127374, "Lcom/win/opensdk/y;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1471127374, "Lcom/win/opensdk/y;");
                return;
            }
        }
        f42702a = new y("BANNER", 0);
        f42703b = new y("INTERSTITIAL", 1);
        f42704c = new y(Constant.TYPE_NATIVE, 2);
        f42705d = new y("Video", 3);
        y yVar = new y("SPLASH", 4);
        f42706e = yVar;
        f42707f = new y[]{f42702a, f42703b, f42704c, f42705d, yVar};
    }

    public y(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static y valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (y) Enum.valueOf(y.class, str) : (y) invokeL.objValue;
    }

    public static y[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (y[]) f42707f.clone() : (y[]) invokeV.objValue;
    }
}
