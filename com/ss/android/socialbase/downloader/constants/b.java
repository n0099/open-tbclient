package com.ss.android.socialbase.downloader.constants;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static final b a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f61656b;

    /* renamed from: c  reason: collision with root package name */
    public static final b f61657c;

    /* renamed from: d  reason: collision with root package name */
    public static final b f61658d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ b[] f61659e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1721992695, "Lcom/ss/android/socialbase/downloader/constants/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1721992695, "Lcom/ss/android/socialbase/downloader/constants/b;");
                return;
            }
        }
        a = new b("BYTE_INVALID_RETRY_STATUS_NONE", 0);
        f61656b = new b("BYTE_INVALID_RETRY_STATUS_RESTART", 1);
        f61657c = new b("BYTE_INVALID_RETRY_STATUS_DOWNLOADING", 2);
        b bVar = new b("BYTE_INVALID_RETRY_STATUS_DOWNLOADED", 3);
        f61658d = bVar;
        f61659e = new b[]{a, f61656b, f61657c, bVar};
    }

    public b(String str, int i2) {
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

    public static b valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (b) Enum.valueOf(b.class, str) : (b) invokeL.objValue;
    }

    public static b[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (b[]) f61659e.clone() : (b[]) invokeV.objValue;
    }
}
