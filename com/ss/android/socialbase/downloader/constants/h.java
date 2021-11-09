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
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final h f69194a;

    /* renamed from: b  reason: collision with root package name */
    public static final h f69195b;

    /* renamed from: c  reason: collision with root package name */
    public static final h f69196c;

    /* renamed from: d  reason: collision with root package name */
    public static final h f69197d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f69198e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final h f69199f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f69200g;

    /* renamed from: h  reason: collision with root package name */
    public static final h f69201h;

    /* renamed from: i  reason: collision with root package name */
    public static final h f69202i;
    public static final /* synthetic */ h[] j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1721992881, "Lcom/ss/android/socialbase/downloader/constants/h;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1721992881, "Lcom/ss/android/socialbase/downloader/constants/h;");
                return;
            }
        }
        f69194a = new h("RUN_STATUS_NONE", 0);
        f69195b = new h("RUN_STATUS_PAUSE", 1);
        f69196c = new h("RUN_STATUS_CANCELED", 2);
        f69197d = new h("RUN_STATUS_ERROR", 3);
        f69198e = new h("RUN_STATUS_END_RIGHT_NOW", 4);
        f69199f = new h("RUN_STATUS_RETRY_DELAY", 5);
        f69200g = new h("RUN_STATUS_WAITING_ASYNC_HANDLER", 6);
        f69201h = new h("RUN_STATUS_END_FOR_FILE_EXIST", 7);
        h hVar = new h("RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET", 8);
        f69202i = hVar;
        j = new h[]{f69194a, f69195b, f69196c, f69197d, f69198e, f69199f, f69200g, f69201h, hVar};
    }

    public h(String str, int i2) {
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

    public static h valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (h) Enum.valueOf(h.class, str) : (h) invokeL.objValue;
    }

    public static h[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (h[]) j.clone() : (h[]) invokeV.objValue;
    }
}
