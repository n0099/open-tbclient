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
public final class L {
    public static /* synthetic */ Interceptable $ic;
    public static final L a;

    /* renamed from: b  reason: collision with root package name */
    public static final L f43985b;

    /* renamed from: c  reason: collision with root package name */
    public static final L f43986c;

    /* renamed from: d  reason: collision with root package name */
    public static final L f43987d;

    /* renamed from: e  reason: collision with root package name */
    public static final L f43988e;

    /* renamed from: f  reason: collision with root package name */
    public static final L f43989f;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ L[] f43990g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1471125979, "Lcom/win/opensdk/L;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1471125979, "Lcom/win/opensdk/L;");
                return;
            }
        }
        a = new L("BANNER", 0);
        f43985b = new L("INTERSTITIAL", 1);
        f43986c = new L(Constant.TYPE_NATIVE, 2);
        f43987d = new L("Video", 3);
        f43988e = new L("SPLASH", 4);
        L l = new L("DRAW_VIDEO", 5);
        f43989f = l;
        f43990g = new L[]{a, f43985b, f43986c, f43987d, f43988e, l};
    }

    public L(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static L valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (L) Enum.valueOf(L.class, str) : (L) invokeL.objValue;
    }

    public static L[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (L[]) f43990g.clone() : (L[]) invokeV.objValue;
    }
}
