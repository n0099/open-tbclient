package com.ss.android.socialbase.downloader.network;

import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final l f76362a;

    /* renamed from: b  reason: collision with root package name */
    public static final l f76363b;

    /* renamed from: c  reason: collision with root package name */
    public static final l f76364c;

    /* renamed from: d  reason: collision with root package name */
    public static final l f76365d;

    /* renamed from: e  reason: collision with root package name */
    public static final l f76366e;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ l[] f76367f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1709912722, "Lcom/ss/android/socialbase/downloader/network/l;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1709912722, "Lcom/ss/android/socialbase/downloader/network/l;");
                return;
            }
        }
        f76362a = new l("POOR", 0);
        f76363b = new l("MODERATE", 1);
        f76364c = new l("GOOD", 2);
        f76365d = new l("EXCELLENT", 3);
        l lVar = new l(RomUtils.UNKNOWN, 4);
        f76366e = lVar;
        f76367f = new l[]{f76362a, f76363b, f76364c, f76365d, lVar};
    }

    public l(String str, int i2) {
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

    public static l valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (l) Enum.valueOf(l.class, str) : (l) invokeL.objValue;
    }

    public static l[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (l[]) f76367f.clone() : (l[]) invokeV.objValue;
    }
}
