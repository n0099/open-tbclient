package com.qq.e.comm.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class VideoAdValidity {
    public static /* synthetic */ Interceptable $ic;
    public static final VideoAdValidity NONE_CACHE;
    public static final VideoAdValidity OVERDUE;
    public static final VideoAdValidity SHOWED;
    public static final VideoAdValidity VALID;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ VideoAdValidity[] f38256b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f38257a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(766035924, "Lcom/qq/e/comm/util/VideoAdValidity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(766035924, "Lcom/qq/e/comm/util/VideoAdValidity;");
                return;
            }
        }
        VALID = new VideoAdValidity("VALID", 0, "有效且可展示的广告");
        OVERDUE = new VideoAdValidity("OVERDUE", 1, "过期的广告");
        SHOWED = new VideoAdValidity("SHOWED", 2, "已经展示的广告");
        VideoAdValidity videoAdValidity = new VideoAdValidity("NONE_CACHE", 3, "视频未缓存的广告");
        NONE_CACHE = videoAdValidity;
        f38256b = new VideoAdValidity[]{VALID, OVERDUE, SHOWED, videoAdValidity};
    }

    public VideoAdValidity(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38257a = str2;
    }

    public static VideoAdValidity valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (VideoAdValidity) Enum.valueOf(VideoAdValidity.class, str) : (VideoAdValidity) invokeL.objValue;
    }

    public static VideoAdValidity[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (VideoAdValidity[]) f38256b.clone() : (VideoAdValidity[]) invokeV.objValue;
    }

    public final String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f38257a : (String) invokeV.objValue;
    }
}
