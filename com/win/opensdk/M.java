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
/* loaded from: classes10.dex */
public final class M {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final M f77132a;

    /* renamed from: b  reason: collision with root package name */
    public static final M f77133b;

    /* renamed from: c  reason: collision with root package name */
    public static final M f77134c;

    /* renamed from: d  reason: collision with root package name */
    public static final M f77135d;

    /* renamed from: e  reason: collision with root package name */
    public static final M f77136e;

    /* renamed from: f  reason: collision with root package name */
    public static final M f77137f;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ M[] f77138g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1471126010, "Lcom/win/opensdk/M;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1471126010, "Lcom/win/opensdk/M;");
                return;
            }
        }
        f77132a = new M("BANNER", 0);
        f77133b = new M("INTERSTITIAL", 1);
        f77134c = new M(Constant.TYPE_NATIVE, 2);
        f77135d = new M("Video", 3);
        f77136e = new M("SPLASH", 4);
        M m = new M("DRAW_VIDEO", 5);
        f77137f = m;
        f77138g = new M[]{f77132a, f77133b, f77134c, f77135d, f77136e, m};
    }

    public M(String str, int i2) {
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

    public static M valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (M) Enum.valueOf(M.class, str) : (M) invokeL.objValue;
    }

    public static M[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (M[]) f77138g.clone() : (M[]) invokeV.objValue;
    }
}
