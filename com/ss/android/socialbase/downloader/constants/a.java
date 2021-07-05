package com.ss.android.socialbase.downloader.constants;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final a f41441a;

    /* renamed from: b  reason: collision with root package name */
    public static final a f41442b;

    /* renamed from: c  reason: collision with root package name */
    public static final a f41443c;

    /* renamed from: d  reason: collision with root package name */
    public static final a f41444d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f41445e;

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ a[] f41446f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1721992664, "Lcom/ss/android/socialbase/downloader/constants/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1721992664, "Lcom/ss/android/socialbase/downloader/constants/a;");
                return;
            }
        }
        f41441a = new a("ASYNC_HANDLE_NONE", 0);
        f41442b = new a("ASYNC_HANDLE_WAITING", 1);
        f41443c = new a("ASYNC_HANDLE_RESTART", 2);
        f41444d = new a("ASYNC_HANDLE_DOWNLOADING", 3);
        a aVar = new a("ASYNC_HANDLE_DOWNLOADED", 4);
        f41445e = aVar;
        f41446f = new a[]{f41441a, f41442b, f41443c, f41444d, aVar};
    }

    public a(String str, int i2) {
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

    public static a valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (a) Enum.valueOf(a.class, str) : (a) invokeL.objValue;
    }

    public static a[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (a[]) f41446f.clone() : (a[]) invokeV.objValue;
    }
}
