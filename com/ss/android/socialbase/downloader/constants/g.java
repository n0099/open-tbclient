package com.ss.android.socialbase.downloader.constants;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final g f38650a;

    /* renamed from: b  reason: collision with root package name */
    public static final g f38651b;

    /* renamed from: c  reason: collision with root package name */
    public static final g f38652c;

    /* renamed from: d  reason: collision with root package name */
    public static final g f38653d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ g[] f38654e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1721992850, "Lcom/ss/android/socialbase/downloader/constants/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1721992850, "Lcom/ss/android/socialbase/downloader/constants/g;");
                return;
            }
        }
        f38650a = new g("DELAY_RETRY_NONE", 0);
        f38651b = new g("DELAY_RETRY_WAITING", 1);
        f38652c = new g("DELAY_RETRY_DOWNLOADING", 2);
        g gVar = new g("DELAY_RETRY_DOWNLOADED", 3);
        f38653d = gVar;
        f38654e = new g[]{f38650a, f38651b, f38652c, gVar};
    }

    public g(String str, int i2) {
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

    public static g valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (g) Enum.valueOf(g.class, str) : (g) invokeL.objValue;
    }

    public static g[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (g[]) f38654e.clone() : (g[]) invokeV.objValue;
    }
}
