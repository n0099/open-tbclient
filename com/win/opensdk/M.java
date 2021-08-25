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
    public static final M f76633a;

    /* renamed from: b  reason: collision with root package name */
    public static final M f76634b;

    /* renamed from: c  reason: collision with root package name */
    public static final M f76635c;

    /* renamed from: d  reason: collision with root package name */
    public static final M f76636d;

    /* renamed from: e  reason: collision with root package name */
    public static final M f76637e;

    /* renamed from: f  reason: collision with root package name */
    public static final M f76638f;

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ M[] f76639g;
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
        f76633a = new M("BANNER", 0);
        f76634b = new M("INTERSTITIAL", 1);
        f76635c = new M(Constant.TYPE_NATIVE, 2);
        f76636d = new M("Video", 3);
        f76637e = new M("SPLASH", 4);
        M m = new M("DRAW_VIDEO", 5);
        f76638f = m;
        f76639g = new M[]{f76633a, f76634b, f76635c, f76636d, f76637e, m};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (M[]) f76639g.clone() : (M[]) invokeV.objValue;
    }
}
