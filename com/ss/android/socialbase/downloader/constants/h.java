package com.ss.android.socialbase.downloader.constants;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final h f76203a;

    /* renamed from: b  reason: collision with root package name */
    public static final h f76204b;

    /* renamed from: c  reason: collision with root package name */
    public static final h f76205c;

    /* renamed from: d  reason: collision with root package name */
    public static final h f76206d;

    /* renamed from: e  reason: collision with root package name */
    public static final h f76207e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final h f76208f;

    /* renamed from: g  reason: collision with root package name */
    public static final h f76209g;

    /* renamed from: h  reason: collision with root package name */
    public static final h f76210h;

    /* renamed from: i  reason: collision with root package name */
    public static final h f76211i;

    /* renamed from: j  reason: collision with root package name */
    public static final /* synthetic */ h[] f76212j;
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
        f76203a = new h("RUN_STATUS_NONE", 0);
        f76204b = new h("RUN_STATUS_PAUSE", 1);
        f76205c = new h("RUN_STATUS_CANCELED", 2);
        f76206d = new h("RUN_STATUS_ERROR", 3);
        f76207e = new h("RUN_STATUS_END_RIGHT_NOW", 4);
        f76208f = new h("RUN_STATUS_RETRY_DELAY", 5);
        f76209g = new h("RUN_STATUS_WAITING_ASYNC_HANDLER", 6);
        f76210h = new h("RUN_STATUS_END_FOR_FILE_EXIST", 7);
        h hVar = new h("RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET", 8);
        f76211i = hVar;
        f76212j = new h[]{f76203a, f76204b, f76205c, f76206d, f76207e, f76208f, f76209g, f76210h, hVar};
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (h[]) f76212j.clone() : (h[]) invokeV.objValue;
    }
}
