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
public final class EnqueueType {
    public static /* synthetic */ Interceptable $ic;
    public static final EnqueueType ENQUEUE_HEAD;
    public static final EnqueueType ENQUEUE_NONE;
    public static final EnqueueType ENQUEUE_TAIL;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ EnqueueType[] f70074a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1825370007, "Lcom/ss/android/socialbase/downloader/constants/EnqueueType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1825370007, "Lcom/ss/android/socialbase/downloader/constants/EnqueueType;");
                return;
            }
        }
        ENQUEUE_NONE = new EnqueueType("ENQUEUE_NONE", 0);
        ENQUEUE_HEAD = new EnqueueType("ENQUEUE_HEAD", 1);
        EnqueueType enqueueType = new EnqueueType("ENQUEUE_TAIL", 2);
        ENQUEUE_TAIL = enqueueType;
        f70074a = new EnqueueType[]{ENQUEUE_NONE, ENQUEUE_HEAD, enqueueType};
    }

    public EnqueueType(String str, int i2) {
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

    public static EnqueueType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EnqueueType) Enum.valueOf(EnqueueType.class, str) : (EnqueueType) invokeL.objValue;
    }

    public static EnqueueType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EnqueueType[]) f70074a.clone() : (EnqueueType[]) invokeV.objValue;
    }
}
