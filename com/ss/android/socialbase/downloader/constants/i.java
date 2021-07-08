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
public final class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final i f38483a;

    /* renamed from: b  reason: collision with root package name */
    public static final i f38484b;

    /* renamed from: c  reason: collision with root package name */
    public static final i f38485c;

    /* renamed from: d  reason: collision with root package name */
    public static final i f38486d;

    /* renamed from: e  reason: collision with root package name */
    public static final i f38487e;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final i f38488f;

    /* renamed from: g  reason: collision with root package name */
    public static final i f38489g;

    /* renamed from: h  reason: collision with root package name */
    public static final i f38490h;

    /* renamed from: i  reason: collision with root package name */
    public static final i f38491i;
    public static final /* synthetic */ i[] j;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1721992912, "Lcom/ss/android/socialbase/downloader/constants/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1721992912, "Lcom/ss/android/socialbase/downloader/constants/i;");
                return;
            }
        }
        f38483a = new i("RUN_STATUS_NONE", 0);
        f38484b = new i("RUN_STATUS_PAUSE", 1);
        f38485c = new i("RUN_STATUS_CANCELED", 2);
        f38486d = new i("RUN_STATUS_ERROR", 3);
        f38487e = new i("RUN_STATUS_END_RIGHT_NOW", 4);
        f38488f = new i("RUN_STATUS_RETRY_DELAY", 5);
        f38489g = new i("RUN_STATUS_WAITING_ASYNC_HANDLER", 6);
        f38490h = new i("RUN_STATUS_END_FOR_FILE_EXIST", 7);
        i iVar = new i("RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET", 8);
        f38491i = iVar;
        j = new i[]{f38483a, f38484b, f38485c, f38486d, f38487e, f38488f, f38489g, f38490h, iVar};
    }

    public i(String str, int i2) {
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

    public static i valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (i) Enum.valueOf(i.class, str) : (i) invokeL.objValue;
    }

    public static i[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (i[]) j.clone() : (i[]) invokeV.objValue;
    }
}
